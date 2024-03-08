# COTS: Connected OpenAPI Test Synthesis for RESTful Applications (artefact)
This is the repository for COTS, a model-based testing tool for RESTful applications based on the DSL COpenAPI.

## Requirements

*The following instructions have only been tested on a MAC machine running macOS Sonoma 14.1.2 and do not guarantee successful execution on any other machine.*

To generate and executed the test drivers, you will need:

1. [Python 3](https://www.python.org/downloads/).
2. [Java SE Development Kit version 11 LTS](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html).
3. [sbt v1.5.0](https://www.scala-sbt.org/download/).

## Understanding the COpenAPI Syntax

```
T = Int | String | Bool | ...               #data types
P = x:T, ..., x':T'                         #payloads
S = +{!operation_id(P:g)<f>.S, ...}         #internal choice 
    | &{?response_code(P)<f>.S, ...}        #external choice
    | rec X.S                               #recursive statement
    | X                                     #recursive variable
    | end                                   #termination
```

The variables x,...,x' in payloads P are pairwise distinct and are categorised by the corresponding data type T. We assume a finite set of data types, including standard types (e.g., Int, String, etc. ) and user-defined types.

The communication units of our syntax are the output and input prefixes, respectively !l(P) and ?l(P) with a message label l and message payload description P; the message payload P, in turn, assigns a variable name and a type to the message contents. Functions f are boolean expressions that may refer to the variables occurring in preceding payload descriptions. They may be used to set assertions on the payloads received or on payloads being sent.

An internal choice allows the test driver to choose the continuation of the protocol; more precisely, in +{!l(P:g)[A].S, ...} the driver selects the k-th option for some k in the set, generate a payload value v via the corresponding generator g, and send the output message !l(v) to the server; then, the protocol continues as specified in S.

In an external choice &{?l(P)[A].S, ...}, the test driver instead waits to receive some message ?l(P), for any k chosen by the other server; so, if the k-th input ?l(P) is received, the variables in P are instantiated with the payload of the received message, and the function f is checked under such instantiation; if the assertion within the function holds, the party continues according to S. Both external choices and internal choice bind the variables that appear in the assertions occurring on their branches and in their continuations.

## Driver generation

Follow the instructions below to generate a test driver, here we describe the architecture and what is going on in the background.

Testing a REST API requires us to generate a test driver. To do so, we first need to write the specification tailored to the system under test. The specification includes:

1. the OpenAPI specification of the SUT, which is typically available as part of the REST APIs and documentation of the SUT itself;
2. the COpenAPI model; and
3. optionally, a “preamble” Scala file containing auxiliary definitions (e.g., functions that check assertions, or custom generators to produce randomised inputs for the SUT).

COTS takes as input the COpenAPI model and the optional preamble, and generates the Scala source code of an executable test driver that interacts with the SUT according to the model. The test driver, in turn, interacts with the REST API exposed by the SUT by using a Scala API which is auto-generated from the provided OpenAPI specification, using the open-source tool [OpenAPI Generator](https://github.com/chrisbartoloburlo/openapi-generator). When the test driver runs, it invokes such Scala API methods to send HTTP requests to the SUT, and to receive and parse its responses; the model determines which requests are sent (and in what order) by the test driver, and which responses are expected.


### Driver generation: Instructions

After downloading this repository on your machine and unzipping it, open a terminal window within the downloaded directory. For your convenience, this package comes with a directory named "COTS-examples" containing some case studies mentioned in the paper and the exact specifications we used for our evaluation. 

Next, follow these steps to generate and package a test driver:
*In this example we will generate the code to test the [Spring Petclinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest). However, the same steps can be followed to generate test drivers for other applications.*

1. Run the command: `python3 main.py`
2. A GUI window should pop up. Follow the steps shown on the window, selecting the respectful directories:
   i. *Select the specification file.* Click on the first button and select `COTS-examples/petclinic/petclinic.st`.
   ii. *Select the OpenAPI schema file.* Click on the second button and select `COTS-examples/petclinic/openapi.yml`.
   iii. *Select the Util file.* Click on the third button and select `COTS-examples/petclinic/util.scala`.
   iv. *Write the respective package name in the text box.* In this case, write `petclinic`.
   v. *Select a directory where to place the generated driver*.
   vi. *Finally, click on Generate test driver.* If the steps were followed correctly, this will generate a zip file in the location that was previously selected. 
3. Unzip the generated zip file and open a terminal in it. Execute `sbt assembly` (make sure that the environment is setup with JVM 11) which will package the driver files, avoiding compilation before executing the driver.


## Executing the test driver.

Make sure that the SUT, in this case the [Spring Petclinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest), is running in the background before running the test driver. If the test driver cannot connect to the SUT via the REST API, it will return an error as it is unable to send requests and test the responses. For your convenience, the JAR file for the [Spring Petclinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest) has been provided within the directory and can be executed by running the command: `java -jar spring-petclinic-rest-2.6.2.jar`.

To run the driver itself, execute: 
`java -cp target/scala-2.13/$(package)-assembly-0.0.3.jar $(package).Wrapper $(iterations)`. 
Replace `$(package)` with the respective package name and `$(iterations)` with the number of tests to be executed. In this case, write `petclinic` instead of `$(package)` and 10 instead of `$(iterations)` for 10 test executions of the driver.

## Analysing the results.

Every time the test driver receives a response from the SUT, it assesses its correctness by considering a series of test oracles:
1. Response code: first, the test driver checks the HTTP response status code. This is the part of an HTTP response indicating whether the request has been successfully fulfilled. In the model, one may specify any expected code for the response (as in M_clinic in Section III). If the SUT sends a response with an unexpected code, the SUT fails the test;
2. Response body: then, the test driver checks the HTTP response body. The schema describing the structure of the response body is part of the OpenAPI specification. The test driver parses the response body received from the SUT: if the body does not match the OpenAPI specification, the SUT fails the test; (note: this test oracle only considers the structure of the response body and not its contents)
3. Assertions: finally, the test driver checks whether the response contents satisfy the assertions (if any) specified in the model. Such assertions are Scala expression returning a boolean; if an assertion returns false, the SUT fails the test.


The driver outputs a log file with information about every performed test, this includes:
1. the random seed used to generate the test,
2. the sequence of requests/responses and their payloads; and
3. the test outcome (pass/fail);

Part of the output of the test driver is also an offline representation of failed tests as sequences of curl commands, which can be executed from a terminal to reproduce faults of the SUT without re-executing the test driver.

As an aid to the testers, the test driver also attempts to minimise its output: if it detects that different sequences of requests/responses trigger the same fault (i.e., the SUT responds to the same request with the same violation of the status code, response body, or assertion oracle), then the test driver only picks (one of) the shortest request/response sequence(s) which trigger that fault, and it only saves the corresponding sequence of curl commands. When this minimisation is toggled off, the test driver saves a curl-based test for every discovered sequence of requests/responses that leads to a fault.

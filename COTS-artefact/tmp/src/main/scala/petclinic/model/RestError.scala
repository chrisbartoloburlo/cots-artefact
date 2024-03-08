/**
 * Spring PetClinic
 * Spring PetClinic Sample Application.
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package petclinic.model

import java.net.URI
import java.time.OffsetDateTime

  /**
   * REST Error
   * The schema for all error responses.
   */
case class RestError(
  /* The HTTP status code. */
  status: Int,
  /* The short error message. */
  error: String,
  /* The path of the URL for this request. */
  path: URI,
  /* The time the error occured. */
  timestamp: OffsetDateTime,
  /* The long error message. */
  message: String,
  /* Validation errors against the OpenAPI schema. */
  schemaValidationErrors: Seq[ValidationMessage],
  /* The stacktrace for this error. */
  trace: Option[String] = None
)


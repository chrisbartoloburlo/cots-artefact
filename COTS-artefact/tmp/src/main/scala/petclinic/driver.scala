package petclinic
import petclinic.model._
import petclinic.core._
import petclinic.api._
import sttp.client3._
import petclinic.logger._
import scala.util.control.TailCalls.{TailRec, done, tailcall}
import java.io.File
class driver(setup: => Unit, teardown: => Unit, minimise: Boolean, max: Int, var seed: Int, repetitions: Int, report: String => Unit) extends Runnable {
	object info {
		object addOwner_20 {
			var ownerFields: OwnerFields = _
			var prob = 0.14285714285714285
		}
		object C201_19 {
			var owner: Owner = _
			var freq = 0
		}
		object getOwner_18 {
			var ownerId: Int = _
			var prob = -1.0
		}
		object C200_17 {
			var retrievedOwner: Owner = _
			var freq = 0
		}
		object updateOwner_16 {
			var ownerFields: OwnerFields = _
			var prob = -1.0
		}
		object C204_15 {
			var freq = 0
		}
		object getOwner_14 {
			var prob = -1.0
		}
		object C200_13 {
			var retrievedOwner: Owner = _
			var freq = 0
		}
		object listOwners_12 {
			var prob = -1.0
		}
		object C200_11 {
			var owners: Seq[Owner] = _
			var freq = 0
		}
		object listOwners_10 {
			var lastName: String = _
			var prob = -1.0
		}
		object C200_9 {
			var owners: Seq[Owner] = _
			var freq = 0
		}
		object deleteOwner_8 {
			var prob = -1.0
		}
		object C204_7 {
			var freq = 0
		}
		object getOwner_6 {
			var prob = -1.0
		}
		object C404_5 {
			var freq = 0
		}
		object updateOwner_4 {
			var ownerFields: OwnerFields = _
			var prob = -1.0
		}
		object C404_3 {
			var freq = 0
		}
		object deleteOwner_2 {
			var prob = -1.0
		}
		object C404_1 {
			var freq = 0
		}
		object listPets_68 {
			var prob = 0.14285714285714285
		}
		object C200_67 {
			var pets: Seq[Pet] = _
			var freq = 0
		}
		object addPet_22 {
			var pet: Pet = _
			var prob = 0.3333333333333333
		}
		object C200_21 {
			var pet: Pet = _
			var freq = 0
		}
		object getPet_62 {
			var petId: Int = _
			var prob = 0.3333333333333333
		}
		object C200_61 {
			var pet: Pet = _
			var freq = 0
		}
		object addOwner_60 {
			var ownerFields: OwnerFields = _
			var prob = -1.0
		}
		object C201_59 {
			var owner: Owner = _
			var freq = 0
		}
		object addPetToOwner_58 {
			var ownerId: Int = _
			var petFields: PetFields = _
			var prob = -1.0
		}
		object C201_57 {
			var createdPet: Pet = _
			var freq = 0
		}
		object getOwnersPet_24 {
			var petId: Int = _
			var prob = 0.3333333333333333
		}
		object C200_23 {
			var pet: Pet = _
			var freq = 0
		}
		object updatePet_38 {
			var petId: Int = _
			var pet: Pet = _
			var prob = 0.3333333333333333
		}
		object C204_37 {
			var freq = 0
		}
		object getPet_36 {
			var prob = -1.0
		}
		object C200_35 {
			var updatedPet: Pet = _
			var freq = 0
		}
		object deletePet_34 {
			var prob = -1.0
		}
		object C204_33 {
			var freq = 0
		}
		object getPet_32 {
			var prob = -1.0
		}
		object C404_31 {
			var freq = 0
		}
		object updatePet_30 {
			var pet: Pet = _
			var prob = -1.0
		}
		object C404_29 {
			var freq = 0
		}
		object deletePet_28 {
			var prob = -1.0
		}
		object C404_27 {
			var freq = 0
		}
		object deleteOwner_26 {
			var prob = -1.0
		}
		object C204_25 {
			var freq = 0
		}
		object addVisitToOwner_56 {
			var petId: Int = _
			var visitFields: VisitFields = _
			var prob = 0.3333333333333333
		}
		object C201_55 {
			var visit: Visit = _
			var freq = 0
		}
		object getVisit_54 {
			var visitId: Int = _
			var prob = -1.0
		}
		object C200_53 {
			var visit: Visit = _
			var freq = 0
		}
		object updateVisit_52 {
			var updatedVisit: Visit = _
			var prob = -1.0
		}
		object C204_51 {
			var freq = 0
		}
		object listVisits_50 {
			var prob = -1.0
		}
		object C200_49 {
			var visits: Seq[Visit] = _
			var freq = 0
		}
		object deleteVisit_48 {
			var prob = -1.0
		}
		object C204_47 {
			var freq = 0
		}
		object getVisit_46 {
			var prob = -1.0
		}
		object C404_45 {
			var freq = 0
		}
		object updateVisit_44 {
			var updatedVisit: Visit = _
			var prob = -1.0
		}
		object C404_43 {
			var freq = 0
		}
		object deleteVisit_42 {
			var prob = -1.0
		}
		object C404_41 {
			var freq = 0
		}
		object deleteOwner_40 {
			var prob = -1.0
		}
		object C204_39 {
			var freq = 0
		}
		object addVisit_66 {
			var visit: Visit = _
			var prob = 0.3333333333333333
		}
		object C201_65 {
			var visit: Visit = _
			var freq = 0
		}
		object getVisit_64 {
			var visitId: Int = _
			var prob = -1.0
		}
		object C200_63 {
			var visit: Visit = _
			var freq = 0
		}
		object addVet_86 {
			var vet: Vet = _
			var prob = 0.14285714285714285
		}
		object C201_85 {
			var vet: Vet = _
			var freq = 0
		}
		object listVets_70 {
			var prob = 0.5
		}
		object C200_69 {
			var vets: Seq[Vet] = _
			var freq = 0
		}
		object getVet_84 {
			var vetId: Int = _
			var prob = 0.5
		}
		object C200_83 {
			var vet: Vet = _
			var freq = 0
		}
		object updateVet_82 {
			var vetId: Int = _
			var updatedVet: Vet = _
			var prob = -1.0
		}
		object C204_81 {
			var freq = 0
		}
		object listVets_80 {
			var prob = -1.0
		}
		object C200_79 {
			var vets: Seq[Vet] = _
			var freq = 0
		}
		object deleteVet_78 {
			var prob = -1.0
		}
		object C204_77 {
			var freq = 0
		}
		object getVet_76 {
			var prob = -1.0
		}
		object C404_75 {
			var freq = 0
		}
		object updateVet_74 {
			var updatedVet: Vet = _
			var prob = -1.0
		}
		object C404_73 {
			var freq = 0
		}
		object deleteVet_72 {
			var prob = -1.0
		}
		object C404_71 {
			var freq = 0
		}
		object addPetType_102 {
			var petType: PetType = _
			var prob = 0.14285714285714285
		}
		object C201_101 {
			var petType: PetType = _
			var freq = 0
		}
		object listPetTypes_100 {
			var prob = -1.0
		}
		object C200_99 {
			var petTypes: Seq[PetType] = _
			var freq = 0
		}
		object getPetType_98 {
			var petTypeId: Int = _
			var prob = -1.0
		}
		object C200_97 {
			var retrievedPetType: PetType = _
			var freq = 0
		}
		object updatePetType_96 {
			var petType: PetType = _
			var prob = -1.0
		}
		object C204_95 {
			var freq = 0
		}
		object deletePetType_94 {
			var prob = -1.0
		}
		object C204_93 {
			var freq = 0
		}
		object getPetType_92 {
			var prob = -1.0
		}
		object C404_91 {
			var freq = 0
		}
		object updatePetType_90 {
			var petType: PetType = _
			var prob = -1.0
		}
		object C404_89 {
			var freq = 0
		}
		object deletePetType_88 {
			var prob = -1.0
		}
		object C404_87 {
			var freq = 0
		}
		object addSpecialty_118 {
			var specialty: Specialty = _
			var prob = 0.14285714285714285
		}
		object C201_117 {
			var specialty: Specialty = _
			var freq = 0
		}
		object listSpecialties_116 {
			var prob = -1.0
		}
		object C200_115 {
			var specialties: Seq[Specialty] = _
			var freq = 0
		}
		object updateSpecialty_114 {
			var specialtyId: Int = _
			var specialty: Specialty = _
			var prob = -1.0
		}
		object C204_113 {
			var freq = 0
		}
		object getSpecialty_112 {
			var prob = -1.0
		}
		object C200_111 {
			var retrievedSpecialty: Specialty = _
			var freq = 0
		}
		object deleteSpecialty_110 {
			var prob = -1.0
		}
		object C204_109 {
			var freq = 0
		}
		object getSpecialty_108 {
			var prob = -1.0
		}
		object C404_107 {
			var freq = 0
		}
		object updateSpecialty_106 {
			var specialty: Specialty = _
			var prob = -1.0
		}
		object C404_105 {
			var freq = 0
		}
		object deleteSpecialty_104 {
			var prob = -1.0
		}
		object C404_103 {
			var freq = 0
		}
		object failingRequest_120 {
			var prob = 0.14285714285714285
		}
		object C404_119 {
			var freq = 0
		}
		object addUser_122 {
			var user: User = _
			var prob = 0.14285714285714285
		}
		object C201_121 {
			var user: User = _
			var freq = 0
		}
	}
	abstract class DriverException(choice: Any, message: String) extends Exception {
		def getInfo: (Any, String) = {
			(choice, message)
		}
	}
	class InvalidMessageException(choice: Any, message: String) extends DriverException(choice, message)
	class AssertionViolationException(choice: Any, message: String) extends DriverException(choice, message)
	class InvalidTestException(choice: Any, message: String) extends DriverException(choice, message)
	var InvalidMessageExceptions:collection.mutable.Map[Any, List[(InvalidMessageException, String, Int)]] = collection.mutable.Map()
	var AssertionViolationExceptions:collection.mutable.Map[Any, List[(AssertionViolationException, String, Int)]] = collection.mutable.Map()
	var r = new scala.util.Random(seed)
	var passed = true
	var pass = 0.0
	var fail = 0.0
	val animationChars = List[Char]('|', '/', '-', '\\')
	val backend: SttpBackend[Identity, Any] = HttpURLConnectionBackend()
	val ownerApi = OwnerApi.apply()
	val petApi = PetApi.apply()
	val visitApi = VisitApi.apply()
	val vetApi = VetApi.apply()
	val vetsApi = VetsApi.apply()
	val pettypesApi = PettypesApi.apply()
	val specialtyApi = SpecialtyApi.apply()
	val failingApi = FailingApi.apply()
	val userApi = UserApi.apply()
	override def run(): Unit = {
		report("[DRIVER] Starting tests...\n")
		val l: csvLogger = new csvLogger(f"${System.getProperty("user.dir")}/logs/S_pc_tests.csv")
		l.log("rep seed passed seq_length sequence")
		report("\n")
		for(rep <- 1 to repetitions){
			setup
			report("\u001b[1A\u001b[2K")
			report(f"[DRIVER] Running test: $rep ${animationChars(rep % 4)}\n")
			val sequence = new StringBuilder()
			val curlSequence = new StringBuilder()
			try {
				sendInternalChoice4(0, sequence, curlSequence).result
				pass+=1
			} catch {
				case e: InvalidMessageException =>
					sequence.append(e.getInfo._2)
					val e_s_r: (InvalidMessageException, String, Int) = InvalidMessageExceptions.getOrElse(e.getInfo._1, List():+(e, sequence.toString(), rep)).minBy(e_s => e_s._2.length)
					InvalidMessageExceptions.update(e.getInfo._1, InvalidMessageExceptions.getOrElse(e.getInfo._1, List()):+(e, sequence.toString(), rep))
					if(minimise) {
						if(e_s_r._2.length > sequence.length() || e_s_r._2.length == sequence.length() && e_s_r._1==e) {
							new File(f"${System.getProperty("user.dir")}/debug/S_pc/invalid_msg_${e_s_r._3}.sh").delete()
							val debugLog: logger = new logger(f"${System.getProperty("user.dir")}/debug/S_pc/invalid_msg_$rep.sh")
							debugLog.log(curlSequence.toString())
						}
					} else {
						val debugLog: logger = new logger(f"${System.getProperty("user.dir")}/debug/S_pc/invalid_msg_$rep.sh")
						debugLog.log(curlSequence.toString())
					}
					passed=false; fail+=1
					teardown
				case e: AssertionViolationException =>
					sequence.append(e.getInfo._2)
					val e_s_r: (AssertionViolationException, String, Int) = AssertionViolationExceptions.getOrElse(e.getInfo._1, List():+(e, sequence.toString(), rep)).minBy(e_s => e_s._2.length)
					AssertionViolationExceptions.update(e.getInfo._1, AssertionViolationExceptions.getOrElse(e.getInfo._1, List()):+(e, sequence.toString(), rep))
					if(minimise) {
						if(e_s_r._2.length > sequence.length() || e_s_r._2.length == sequence.length() && e_s_r._1==e) {
							new File(f"${System.getProperty("user.dir")}/debug/S_pc/assertion_violation_${e_s_r._3}.sh").delete()
							val debugLog: logger = new logger(f"${System.getProperty("user.dir")}/debug/S_pc/assertion_violation_$rep.sh")
							debugLog.log(curlSequence.toString())
						}
					} else {
						val debugLog: logger = new logger(f"${System.getProperty("user.dir")}/debug/S_pc/assertion_violation_$rep.sh")
						debugLog.log(curlSequence.toString())
					}
					passed=false; fail+=1
					teardown
				case e: InvalidTestException =>
					sequence.append(e)
					l.log(f"$rep $seed $passed ${sequence.toString().split('.').length} ${sequence.insert(0,"\"").append("\"").toString()}")
					teardown
					throw new Exception(f"Error in test (choice: ${e.getInfo._1}) ${e.getInfo._2}")
				case e: Throwable =>
					sequence.append(e.getMessage)
					l.log(f"$rep $seed $passed ${sequence.toString().split('.').length} ${sequence.insert(0,"\"").append("\"").toString()}")
					teardown
					throw new Exception("Error in test")
			}
			l.log(f"$rep $seed $passed ${sequence.toString().split('.').length} ${sequence.insert(0,"\"").append("\"").toString()}")
			passed=true; seed=r.nextInt(); r=new scala.util.Random(seed)
		}
		reportSummary()
	}
	def reportSummary(): Unit = {
		report("[DRIVER] TESTS SUMMARY\n")
		report("Number of tests: "+repetitions+"\n")
		report("Passed (%): "+(pass/repetitions.toDouble)*100+"\n")
		report("Failed (%): "+(fail/repetitions.toDouble)*100+"\n")
		report("Invalid Message violations: "+InvalidMessageExceptions.size+"\n")
		report("Assertion violations: "+AssertionViolationExceptions.size+"\n")
	}
	def sendInternalChoice4(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val rand = r.nextDouble()
		if (rand <= info.addOwner_20.prob){
			var ownerFields = util.getOwnerFields("firstname","lastname","address 1","city 1","6085551023",r)
		val request = ownerApi.addOwner(ownerFields)
val response = request.send(backend)
		sequence.append(f"!addOwner_20($ownerFields).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_19(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_19(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_19", f"Unexpected response: $response")
			}
		} else if (rand <= info.listPets_68.prob+0.14285714285714285){
		val request = petApi.listPets()
val response = request.send(backend)
		sequence.append(f"!listPets().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_67(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Pet]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Pet]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_67(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Pet]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Pet]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_67", f"Unexpected response: $response")
			}
		} else if (rand <= info.addVet_86.prob+0.2857142857142857){
			var vet = util.getVet(r)
		val request = vetApi.addVet(vet)
val response = request.send(backend)
		sequence.append(f"!addVet($vet).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_85(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Vet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Vet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_85(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Vet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Vet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_85", f"Unexpected response: $response")
			}
		} else if (rand <= info.addPetType_102.prob+0.42857142857142855){
			var petType = util.getPetType(r)
		val request = pettypesApi.addPetType(petType)
val response = request.send(backend)
		sequence.append(f"!addPetType($petType).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_101(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[PetType] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[PetType], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_101(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[PetType] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[PetType], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_101", f"Unexpected response: $response")
			}
		} else if (rand <= info.addSpecialty_118.prob+0.5714285714285714){
			var specialty = util.getSpecialty(r)
		val request = specialtyApi.addSpecialty(specialty)
val response = request.send(backend)
		sequence.append(f"!addSpecialty($specialty).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_117(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Specialty] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Specialty], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_117(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Specialty] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Specialty], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_117", f"Unexpected response: $response")
			}
		} else if (rand <= info.failingRequest_120.prob+0.7142857142857142){
		val request = failingApi.failingRequest()
val response = request.send(backend)
		sequence.append(f"!failingRequest().")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_119(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_119(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
		} else if (rand <= info.addUser_122.prob+0.857142857142857){
			var user = util.getUser(r)
		val request = userApi.addUser(user)
val response = request.send(backend)
		sequence.append(f"!addUser($user).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_121(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[User] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[User], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_121(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[User] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[User], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_121", f"Unexpected response: $response")
			}
		} else { throw new Exception("[DRIVER] Error in test") }
	}
	def receiveC201_19(responseCode: Int, owner: Owner, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($owner).")
				if(util.setOwnerId(owner)){
					info.C201_19.freq+=1
					if (count < max) {
						sendgetOwner_18(count+1, sequence, curlSequence)
					} else { tailcall(sendgetOwner_18(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_19", "Violation in Assertion: util.setOwnerId(owner)");  }
			case code @ _ => sequence.append(f"?$code($owner)."); passed=false; throw new InvalidMessageException("C201_19", f"Unknown message: $code"); 
		}
	}
	def sendgetOwner_18(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var ownerId = util.getOwnerId(r)
		val request = ownerApi.getOwner(ownerId)
val response = request.send(backend)
		sequence.append(f"!getOwner_18($ownerId).")
		curlSequence.append(request.toCurl+"\n\n")
		info.getOwner_18.ownerId = ownerId
		try {
			if (count < max) {
			receiveC200_17(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_17(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_17", f"Unexpected response: $response")
			}
	}
	def receiveC200_17(responseCode: Int, retrievedOwner: Owner, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($retrievedOwner).")
				if(util.getOwnerId(retrievedOwner)==info.getOwner_18.ownerId){
					info.C200_17.freq+=1
					if (count < max) {
						sendupdateOwner_16(count+1, sequence, curlSequence)
					} else { tailcall(sendupdateOwner_16(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_17", "Violation in Assertion: util.getOwnerId(retrievedOwner)==ownerId");  }
			case code @ _ => sequence.append(f"?$code($retrievedOwner)."); passed=false; throw new InvalidMessageException("C200_17", f"Unknown message: $code"); 
		}
	}
	def sendupdateOwner_16(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var ownerFields = util.getUpdatedOwnerFields(r)
		val request = ownerApi.updateOwner(info.getOwner_18.ownerId, ownerFields)
val response = request.send(backend)
		sequence.append(f"!updateOwner_16(${info.getOwner_18.ownerId}, $ownerFields).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_15(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_15(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_15(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_15.freq+=1
				if (count < max) {
					sendgetOwner_14(count+1, sequence, curlSequence)
				} else { tailcall(sendgetOwner_14(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_15", f"Unknown message: $code"); 
		}
	}
	def sendgetOwner_14(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.getOwner(info.getOwner_18.ownerId)
val response = request.send(backend)
		sequence.append(f"!getOwner_14(${info.getOwner_18.ownerId}).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_13(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_13(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_13", f"Unexpected response: $response")
			}
	}
	def receiveC200_13(responseCode: Int, retrievedOwner: Owner, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($retrievedOwner).")
				info.C200_13.freq+=1
				info.C200_13.retrievedOwner = retrievedOwner
				if (count < max) {
					sendlistOwners_12(count+1, sequence, curlSequence)
				} else { tailcall(sendlistOwners_12(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($retrievedOwner)."); passed=false; throw new InvalidMessageException("C200_13", f"Unknown message: $code"); 
		}
	}
	def sendlistOwners_12(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.listOwners()
val response = request.send(backend)
		sequence.append(f"!listOwners_12().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_11(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Owner]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Owner]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_11(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Owner]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Owner]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_11", f"Unexpected response: $response")
			}
	}
	def receiveC200_11(responseCode: Int, owners: Seq[Owner], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($owners).")
				if(owners.contains(info.C200_13.retrievedOwner)){
					info.C200_11.freq+=1
					if (count < max) {
						sendlistOwners_10(count+1, sequence, curlSequence)
					} else { tailcall(sendlistOwners_10(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_11", "Violation in Assertion: owners.contains(retrievedOwner)");  }
			case code @ _ => sequence.append(f"?$code($owners)."); passed=false; throw new InvalidMessageException("C200_11", f"Unknown message: $code"); 
		}
	}
	def sendlistOwners_10(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var lastName = util.getLastName(r)
		val request = ownerApi.listOwners(lastName)
val response = request.send(backend)
		sequence.append(f"!listOwners_10($lastName).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_9(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Owner]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Owner]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_9(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Owner]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Owner]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_9", f"Unexpected response: $response")
			}
	}
	def receiveC200_9(responseCode: Int, owners: Seq[Owner], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($owners).")
				if(owners.contains(info.C200_13.retrievedOwner)){
					info.C200_9.freq+=1
					if (count < max) {
						senddeleteOwner_8(count+1, sequence, curlSequence)
					} else { tailcall(senddeleteOwner_8(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_9", "Violation in Assertion: owners.contains(retrievedOwner)");  }
			case code @ _ => sequence.append(f"?$code($owners)."); passed=false; throw new InvalidMessageException("C200_9", f"Unknown message: $code"); 
		}
	}
	def senddeleteOwner_8(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.deleteOwner(info.getOwner_18.ownerId)
val response = request.send(backend)
		sequence.append(f"!deleteOwner_8(${info.getOwner_18.ownerId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_7(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_7(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_7(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_7.freq+=1
				if (count < max) {
					sendgetOwner_6(count+1, sequence, curlSequence)
				} else { tailcall(sendgetOwner_6(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_7", f"Unknown message: $code"); 
		}
	}
	def sendgetOwner_6(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.getOwner(info.getOwner_18.ownerId)
val response = request.send(backend)
		sequence.append(f"!getOwner_6(${info.getOwner_18.ownerId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_5(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_5(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_5(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_5.freq+=1
				if (count < max) {
					sendupdateOwner_4(count+1, sequence, curlSequence)
				} else { tailcall(sendupdateOwner_4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_5", f"Unknown message: $code"); 
		}
	}
	def sendupdateOwner_4(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var ownerFields = util.getUpdatedOwnerFields(r)
		val request = ownerApi.updateOwner(info.getOwner_18.ownerId, ownerFields)
val response = request.send(backend)
		sequence.append(f"!updateOwner_4(${info.getOwner_18.ownerId}, $ownerFields).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_3(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_3(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_3(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_3.freq+=1
				if (count < max) {
					senddeleteOwner_2(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteOwner_2(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_3", f"Unknown message: $code"); 
		}
	}
	def senddeleteOwner_2(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.deleteOwner(info.getOwner_18.ownerId)
val response = request.send(backend)
		sequence.append(f"!deleteOwner_2(${info.getOwner_18.ownerId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_1(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_1(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_1(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_1.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_1", f"Unknown message: $code"); 
		}
	}
	def receiveC200_67(responseCode: Int, pets: Seq[Pet], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($pets).")
				if(util.setRandomPet(pets)){
					info.C200_67.freq+=1
					info.C200_67.pets = pets
					if (count < max) {
						sendInternalChoice2(count+1, sequence, curlSequence)
					} else { tailcall(sendInternalChoice2(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_67", "Violation in Assertion: util.setRandomPet(pets)");  }
			case code @ _ => sequence.append(f"?$code($pets)."); passed=false; throw new InvalidMessageException("C200_67", f"Unknown message: $code"); 
		}
	}
	def sendInternalChoice2(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val rand = r.nextDouble()
		if (rand <= info.addPet_22.prob){
			var pet = util.getPet(r)
		val request = petApi.addPet(pet)
val response = request.send(backend)
		sequence.append(f"!addPet($pet).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_21(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_21(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_21", f"Unexpected response: $response")
			}
		} else if (rand <= info.getPet_62.prob+0.3333333333333333){
			var petId = util.getRandomPetId(r)
		val request = petApi.getPet(petId)
val response = request.send(backend)
		sequence.append(f"!getPet_62($petId).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_61(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_61(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_61", f"Unexpected response: $response")
			}
		} else if (rand <= info.addVisit_66.prob+0.6666666666666666){
			var visit = util.getVisit(r)
		val request = visitApi.addVisit(visit)
val response = request.send(backend)
		sequence.append(f"!addVisit($visit).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_65(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_65(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_65", f"Unexpected response: $response")
			}
		} else { throw new Exception("[DRIVER] Error in test") }
	}
	def receiveC200_21(responseCode: Int, pet: Pet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($pet).")
				info.C200_21.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($pet)."); passed=false; throw new InvalidMessageException("C200_21", f"Unknown message: $code"); 
		}
	}
	def receiveC200_61(responseCode: Int, pet: Pet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($pet).")
				info.C200_61.freq+=1
				if (count < max) {
					sendaddOwner_60(count+1, sequence, curlSequence)
				} else { tailcall(sendaddOwner_60(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($pet)."); passed=false; throw new InvalidMessageException("C200_61", f"Unknown message: $code"); 
		}
	}
	def sendaddOwner_60(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var ownerFields = util.getOwnerFields("firstname","lastname","address 1","city 1","6085551023",r)
		val request = ownerApi.addOwner(ownerFields)
val response = request.send(backend)
		sequence.append(f"!addOwner_60($ownerFields).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_59(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_59(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Owner] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Owner], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_59", f"Unexpected response: $response")
			}
	}
	def receiveC201_59(responseCode: Int, owner: Owner, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($owner).")
				if(util.setOwnerId(owner)){
					info.C201_59.freq+=1
					if (count < max) {
						sendaddPetToOwner_58(count+1, sequence, curlSequence)
					} else { tailcall(sendaddPetToOwner_58(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_59", "Violation in Assertion: util.setOwnerId(owner)");  }
			case code @ _ => sequence.append(f"?$code($owner)."); passed=false; throw new InvalidMessageException("C201_59", f"Unknown message: $code"); 
		}
	}
	def sendaddPetToOwner_58(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var ownerId = util.getOwnerId(r)
		var petFields = util.getPetFields(r)
		val request = petApi.addPetToOwner(ownerId, petFields)
val response = request.send(backend)
		sequence.append(f"!addPetToOwner($ownerId, $petFields).")
		curlSequence.append(request.toCurl+"\n\n")
		info.addPetToOwner_58.ownerId = ownerId
		try {
			if (count < max) {
			receiveC201_57(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_57(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_57", f"Unexpected response: $response")
			}
	}
	def receiveC201_57(responseCode: Int, createdPet: Pet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($createdPet).")
				if(util.setRandomPet(info.C200_67.pets)){
					info.C201_57.freq+=1
					info.C201_57.createdPet = createdPet
					if (count < max) {
						sendInternalChoice1(count+1, sequence, curlSequence)
					} else { tailcall(sendInternalChoice1(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_57", "Violation in Assertion: util.setRandomPet(pets)");  }
			case code @ _ => sequence.append(f"?$code($createdPet)."); passed=false; throw new InvalidMessageException("C201_57", f"Unknown message: $code"); 
		}
	}
	def sendInternalChoice1(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val rand = r.nextDouble()
		if (rand <= info.getOwnersPet_24.prob){
			var petId = util.getRandomPetId(r)
		val request = petApi.getOwnersPet(info.addPetToOwner_58.ownerId, petId)
val response = request.send(backend)
		sequence.append(f"!getOwnersPet(${info.addPetToOwner_58.ownerId}, $petId).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_23(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_23(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_23", f"Unexpected response: $response")
			}
		} else if (rand <= info.updatePet_38.prob+0.3333333333333333){
			var petId = util.getRandomPetId(r)
			var pet = util.getUpdatedRandomPet(r)
		val request = petApi.updatePet(petId, pet)
val response = request.send(backend)
		sequence.append(f"!updatePet_38($petId, $pet).")
		curlSequence.append(request.toCurl+"\n\n")
		info.updatePet_38.petId = petId
		info.updatePet_38.pet = pet
		if (count < max) {
			receiveC204_37(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_37(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
		} else if (rand <= info.addVisitToOwner_56.prob+0.6666666666666666){
			var petId = util.getRandomPetId(r)
			var visitFields = util.getVisitFields(r)
		val request = visitApi.addVisitToOwner(info.addPetToOwner_58.ownerId, petId, visitFields)
val response = request.send(backend)
		sequence.append(f"!addVisitToOwner(${info.addPetToOwner_58.ownerId}, $petId, $visitFields).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC201_55(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], count+1, sequence, curlSequence)
		} else { tailcall(receiveC201_55(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C201_55", f"Unexpected response: $response")
			}
		} else { throw new Exception("[DRIVER] Error in test") }
	}
	def receiveC200_23(responseCode: Int, pet: Pet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($pet).")
				if(util.checkPets(info.C201_57.createdPet, pet)){
					info.C200_23.freq+=1
					if (count < max) {
						sendInternalChoice4(count+1, sequence, curlSequence)
					} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_23", "Violation in Assertion: util.checkPets(createdPet, pet)");  }
			case code @ _ => sequence.append(f"?$code($pet)."); passed=false; throw new InvalidMessageException("C200_23", f"Unknown message: $code"); 
		}
	}
	def receiveC204_37(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_37.freq+=1
				if (count < max) {
					sendgetPet_36(count+1, sequence, curlSequence)
				} else { tailcall(sendgetPet_36(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_37", f"Unknown message: $code"); 
		}
	}
	def sendgetPet_36(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = petApi.getPet(info.updatePet_38.petId)
val response = request.send(backend)
		sequence.append(f"!getPet_36(${info.updatePet_38.petId}).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_35(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_35(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Pet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Pet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_35", f"Unexpected response: $response")
			}
	}
	def receiveC200_35(responseCode: Int, updatedPet: Pet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($updatedPet).")
				if(util.checkPets(updatedPet, info.updatePet_38.pet)){
					info.C200_35.freq+=1
					if (count < max) {
						senddeletePet_34(count+1, sequence, curlSequence)
					} else { tailcall(senddeletePet_34(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_35", "Violation in Assertion: util.checkPets(updatedPet, pet)");  }
			case code @ _ => sequence.append(f"?$code($updatedPet)."); passed=false; throw new InvalidMessageException("C200_35", f"Unknown message: $code"); 
		}
	}
	def senddeletePet_34(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = petApi.deletePet(info.updatePet_38.petId)
val response = request.send(backend)
		sequence.append(f"!deletePet_34(${info.updatePet_38.petId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_33(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_33(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_33(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_33.freq+=1
				if (count < max) {
					sendgetPet_32(count+1, sequence, curlSequence)
				} else { tailcall(sendgetPet_32(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_33", f"Unknown message: $code"); 
		}
	}
	def sendgetPet_32(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = petApi.getPet(info.updatePet_38.petId)
val response = request.send(backend)
		sequence.append(f"!getPet_32(${info.updatePet_38.petId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_31(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_31(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_31(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_31.freq+=1
				if (count < max) {
					sendupdatePet_30(count+1, sequence, curlSequence)
				} else { tailcall(sendupdatePet_30(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_31", f"Unknown message: $code"); 
		}
	}
	def sendupdatePet_30(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var pet = util.getUpdatedRandomPet(r)
		val request = petApi.updatePet(info.updatePet_38.petId, pet)
val response = request.send(backend)
		sequence.append(f"!updatePet_30(${info.updatePet_38.petId}, $pet).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_29(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_29(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_29(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_29.freq+=1
				if (count < max) {
					senddeletePet_28(count+1, sequence, curlSequence)
				} else { tailcall(senddeletePet_28(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_29", f"Unknown message: $code"); 
		}
	}
	def senddeletePet_28(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = petApi.deletePet(info.updatePet_38.petId)
val response = request.send(backend)
		sequence.append(f"!deletePet_28(${info.updatePet_38.petId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_27(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_27(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_27(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_27.freq+=1
				if (count < max) {
					senddeleteOwner_26(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteOwner_26(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_27", f"Unknown message: $code"); 
		}
	}
	def senddeleteOwner_26(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.deleteOwner(info.addPetToOwner_58.ownerId)
val response = request.send(backend)
		sequence.append(f"!deleteOwner_26(${info.addPetToOwner_58.ownerId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_25(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_25(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_25(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_25.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_25", f"Unknown message: $code"); 
		}
	}
	def receiveC201_55(responseCode: Int, visit: Visit, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($visit).")
				if(util.setVisit(visit)){
					info.C201_55.freq+=1
					if (count < max) {
						sendgetVisit_54(count+1, sequence, curlSequence)
					} else { tailcall(sendgetVisit_54(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_55", "Violation in Assertion: util.setVisit(visit)");  }
			case code @ _ => sequence.append(f"?$code($visit)."); passed=false; throw new InvalidMessageException("C201_55", f"Unknown message: $code"); 
		}
	}
	def sendgetVisit_54(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var visitId = util.getVisitId(r)
		val request = visitApi.getVisit(visitId)
val response = request.send(backend)
		sequence.append(f"!getVisit_54($visitId).")
		curlSequence.append(request.toCurl+"\n\n")
		info.getVisit_54.visitId = visitId
		try {
			if (count < max) {
			receiveC200_53(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_53(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_53", f"Unexpected response: $response")
			}
	}
	def receiveC200_53(responseCode: Int, visit: Visit, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($visit).")
				if(util.testVisit(visit)){
					info.C200_53.freq+=1
					if (count < max) {
						sendupdateVisit_52(count+1, sequence, curlSequence)
					} else { tailcall(sendupdateVisit_52(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_53", "Violation in Assertion: util.testVisit(visit)");  }
			case code @ _ => sequence.append(f"?$code($visit)."); passed=false; throw new InvalidMessageException("C200_53", f"Unknown message: $code"); 
		}
	}
	def sendupdateVisit_52(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var updatedVisit = util.getUpdatedVisit(r)
		val request = visitApi.updateVisit(info.getVisit_54.visitId, updatedVisit)
val response = request.send(backend)
		sequence.append(f"!updateVisit_52(${info.getVisit_54.visitId}, $updatedVisit).")
		curlSequence.append(request.toCurl+"\n\n")
		info.updateVisit_52.updatedVisit = updatedVisit
		if (count < max) {
			receiveC204_51(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_51(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_51(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_51.freq+=1
				if (count < max) {
					sendlistVisits_50(count+1, sequence, curlSequence)
				} else { tailcall(sendlistVisits_50(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_51", f"Unknown message: $code"); 
		}
	}
	def sendlistVisits_50(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = visitApi.listVisits()
val response = request.send(backend)
		sequence.append(f"!listVisits().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_49(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Visit]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Visit]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_49(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Visit]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Visit]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_49", f"Unexpected response: $response")
			}
	}
	def receiveC200_49(responseCode: Int, visits: Seq[Visit], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($visits).")
				if(visits.contains(info.updateVisit_52.updatedVisit)){
					info.C200_49.freq+=1
					if (count < max) {
						senddeleteVisit_48(count+1, sequence, curlSequence)
					} else { tailcall(senddeleteVisit_48(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_49", "Violation in Assertion: visits.contains(updatedVisit)");  }
			case code @ _ => sequence.append(f"?$code($visits)."); passed=false; throw new InvalidMessageException("C200_49", f"Unknown message: $code"); 
		}
	}
	def senddeleteVisit_48(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = visitApi.deleteVisit(info.getVisit_54.visitId)
val response = request.send(backend)
		sequence.append(f"!deleteVisit_48(${info.getVisit_54.visitId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_47(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_47(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_47(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_47.freq+=1
				if (count < max) {
					sendgetVisit_46(count+1, sequence, curlSequence)
				} else { tailcall(sendgetVisit_46(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_47", f"Unknown message: $code"); 
		}
	}
	def sendgetVisit_46(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = visitApi.getVisit(info.getVisit_54.visitId)
val response = request.send(backend)
		sequence.append(f"!getVisit_46(${info.getVisit_54.visitId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_45(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_45(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_45(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_45.freq+=1
				if (count < max) {
					sendupdateVisit_44(count+1, sequence, curlSequence)
				} else { tailcall(sendupdateVisit_44(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_45", f"Unknown message: $code"); 
		}
	}
	def sendupdateVisit_44(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var updatedVisit = util.getUpdatedVisit(r)
		val request = visitApi.updateVisit(info.getVisit_54.visitId, updatedVisit)
val response = request.send(backend)
		sequence.append(f"!updateVisit_44(${info.getVisit_54.visitId}, $updatedVisit).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_43(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_43(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_43(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_43.freq+=1
				if (count < max) {
					senddeleteVisit_42(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteVisit_42(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_43", f"Unknown message: $code"); 
		}
	}
	def senddeleteVisit_42(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = visitApi.deleteVisit(info.getVisit_54.visitId)
val response = request.send(backend)
		sequence.append(f"!deleteVisit_42(${info.getVisit_54.visitId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_41(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_41(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_41(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_41.freq+=1
				if (count < max) {
					senddeleteOwner_40(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteOwner_40(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_41", f"Unknown message: $code"); 
		}
	}
	def senddeleteOwner_40(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = ownerApi.deleteOwner(info.addPetToOwner_58.ownerId)
val response = request.send(backend)
		sequence.append(f"!deleteOwner_40(${info.addPetToOwner_58.ownerId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_39(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_39(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_39(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_39.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_39", f"Unknown message: $code"); 
		}
	}
	def receiveC201_65(responseCode: Int, visit: Visit, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($visit).")
				if(util.testVisit(visit)){
					info.C201_65.freq+=1
					if (count < max) {
						sendgetVisit_64(count+1, sequence, curlSequence)
					} else { tailcall(sendgetVisit_64(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_65", "Violation in Assertion: util.testVisit(visit)");  }
			case code @ _ => sequence.append(f"?$code($visit)."); passed=false; throw new InvalidMessageException("C201_65", f"Unknown message: $code"); 
		}
	}
	def sendgetVisit_64(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var visitId = util.getVisitId(r)
		val request = visitApi.getVisit(visitId)
val response = request.send(backend)
		sequence.append(f"!getVisit_64($visitId).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_63(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_63(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Visit] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Visit], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_63", f"Unexpected response: $response")
			}
	}
	def receiveC200_63(responseCode: Int, visit: Visit, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($visit).")
				if(util.testVisit(visit)){
					info.C200_63.freq+=1
					if (count < max) {
						sendInternalChoice4(count+1, sequence, curlSequence)
					} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_63", "Violation in Assertion: util.testVisit(visit)");  }
			case code @ _ => sequence.append(f"?$code($visit)."); passed=false; throw new InvalidMessageException("C200_63", f"Unknown message: $code"); 
		}
	}
	def receiveC201_85(responseCode: Int, vet: Vet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($vet).")
				if(util.setVetId(vet)){
					info.C201_85.freq+=1
					info.C201_85.vet = vet
					if (count < max) {
						sendInternalChoice3(count+1, sequence, curlSequence)
					} else { tailcall(sendInternalChoice3(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_85", "Violation in Assertion: util.setVetId(vet)");  }
			case code @ _ => sequence.append(f"?$code($vet)."); passed=false; throw new InvalidMessageException("C201_85", f"Unknown message: $code"); 
		}
	}
	def sendInternalChoice3(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val rand = r.nextDouble()
		if (rand <= info.listVets_70.prob){
		val request = vetApi.listVets()
val response = request.send(backend)
		sequence.append(f"!listVets_70().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_69(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Vet]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Vet]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_69(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Vet]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Vet]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_69", f"Unexpected response: $response")
			}
		} else if (rand <= info.getVet_84.prob+0.5){
			var vetId = util.getVetId(r)
		val request = vetApi.getVet(vetId)
val response = request.send(backend)
		sequence.append(f"!getVet_84($vetId).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_83(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Vet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Vet], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_83(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Vet] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Vet], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_83", f"Unexpected response: $response")
			}
		} else { throw new Exception("[DRIVER] Error in test") }
	}
	def receiveC200_69(responseCode: Int, vets: Seq[Vet], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($vets).")
				if(vets.contains(info.C201_85.vet)){
					info.C200_69.freq+=1
					if (count < max) {
						sendInternalChoice4(count+1, sequence, curlSequence)
					} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_69", "Violation in Assertion: vets.contains(vet)");  }
			case code @ _ => sequence.append(f"?$code($vets)."); passed=false; throw new InvalidMessageException("C200_69", f"Unknown message: $code"); 
		}
	}
	def receiveC200_83(responseCode: Int, vet: Vet, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($vet).")
				info.C200_83.freq+=1
				if (count < max) {
					sendupdateVet_82(count+1, sequence, curlSequence)
				} else { tailcall(sendupdateVet_82(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($vet)."); passed=false; throw new InvalidMessageException("C200_83", f"Unknown message: $code"); 
		}
	}
	def sendupdateVet_82(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var vetId = util.getVetId(r)
		var updatedVet = util.getUpdatedVet(r)
		val request = vetApi.updateVet(vetId, updatedVet)
val response = request.send(backend)
		sequence.append(f"!updateVet_82($vetId, $updatedVet).")
		curlSequence.append(request.toCurl+"\n\n")
		info.updateVet_82.vetId = vetId
		info.updateVet_82.updatedVet = updatedVet
		if (count < max) {
			receiveC204_81(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_81(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_81(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_81.freq+=1
				if (count < max) {
					sendlistVets_80(count+1, sequence, curlSequence)
				} else { tailcall(sendlistVets_80(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_81", f"Unknown message: $code"); 
		}
	}
	def sendlistVets_80(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = vetApi.listVets()
val response = request.send(backend)
		sequence.append(f"!listVets_80().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_79(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Vet]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Vet]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_79(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Vet]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Vet]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_79", f"Unexpected response: $response")
			}
	}
	def receiveC200_79(responseCode: Int, vets: Seq[Vet], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($vets).")
				if(vets.contains(info.updateVet_82.updatedVet)){
					info.C200_79.freq+=1
					if (count < max) {
						senddeleteVet_78(count+1, sequence, curlSequence)
					} else { tailcall(senddeleteVet_78(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_79", "Violation in Assertion: vets.contains(updatedVet)");  }
			case code @ _ => sequence.append(f"?$code($vets)."); passed=false; throw new InvalidMessageException("C200_79", f"Unknown message: $code"); 
		}
	}
	def senddeleteVet_78(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = vetsApi.deleteVet(info.updateVet_82.vetId)
val response = request.send(backend)
		sequence.append(f"!deleteVet_78(${info.updateVet_82.vetId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_77(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_77(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_77(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_77.freq+=1
				if (count < max) {
					sendgetVet_76(count+1, sequence, curlSequence)
				} else { tailcall(sendgetVet_76(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_77", f"Unknown message: $code"); 
		}
	}
	def sendgetVet_76(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = vetApi.getVet(info.updateVet_82.vetId)
val response = request.send(backend)
		sequence.append(f"!getVet_76(${info.updateVet_82.vetId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_75(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_75(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_75(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_75.freq+=1
				if (count < max) {
					sendupdateVet_74(count+1, sequence, curlSequence)
				} else { tailcall(sendupdateVet_74(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_75", f"Unknown message: $code"); 
		}
	}
	def sendupdateVet_74(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var updatedVet = util.getUpdatedVet(r)
		val request = vetApi.updateVet(info.updateVet_82.vetId, updatedVet)
val response = request.send(backend)
		sequence.append(f"!updateVet_74(${info.updateVet_82.vetId}, $updatedVet).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_73(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_73(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_73(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_73.freq+=1
				if (count < max) {
					senddeleteVet_72(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteVet_72(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_73", f"Unknown message: $code"); 
		}
	}
	def senddeleteVet_72(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = vetsApi.deleteVet(info.updateVet_82.vetId)
val response = request.send(backend)
		sequence.append(f"!deleteVet_72(${info.updateVet_82.vetId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_71(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_71(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_71(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_71.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_71", f"Unknown message: $code"); 
		}
	}
	def receiveC201_101(responseCode: Int, petType: PetType, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($petType).")
				if(util.setPetType(petType)){
					info.C201_101.freq+=1
					if (count < max) {
						sendlistPetTypes_100(count+1, sequence, curlSequence)
					} else { tailcall(sendlistPetTypes_100(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_101", "Violation in Assertion: util.setPetType(petType)");  }
			case code @ _ => sequence.append(f"?$code($petType)."); passed=false; throw new InvalidMessageException("C201_101", f"Unknown message: $code"); 
		}
	}
	def sendlistPetTypes_100(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = pettypesApi.listPetTypes()
val response = request.send(backend)
		sequence.append(f"!listPetTypes().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_99(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[PetType]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[PetType]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_99(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[PetType]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[PetType]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_99", f"Unexpected response: $response")
			}
	}
	def receiveC200_99(responseCode: Int, petTypes: Seq[PetType], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($petTypes).")
				info.C200_99.freq+=1
				if (count < max) {
					sendgetPetType_98(count+1, sequence, curlSequence)
				} else { tailcall(sendgetPetType_98(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($petTypes)."); passed=false; throw new InvalidMessageException("C200_99", f"Unknown message: $code"); 
		}
	}
	def sendgetPetType_98(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var petTypeId = util.getPetTypeId(r)
		val request = pettypesApi.getPetType(petTypeId)
val response = request.send(backend)
		sequence.append(f"!getPetType_98($petTypeId).")
		curlSequence.append(request.toCurl+"\n\n")
		info.getPetType_98.petTypeId = petTypeId
		try {
			if (count < max) {
			receiveC200_97(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[PetType] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[PetType], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_97(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[PetType] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[PetType], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_97", f"Unexpected response: $response")
			}
	}
	def receiveC200_97(responseCode: Int, retrievedPetType: PetType, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($retrievedPetType).")
				if(util.checkPetType(retrievedPetType)){
					info.C200_97.freq+=1
					if (count < max) {
						sendupdatePetType_96(count+1, sequence, curlSequence)
					} else { tailcall(sendupdatePetType_96(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_97", "Violation in Assertion: util.checkPetType(retrievedPetType)");  }
			case code @ _ => sequence.append(f"?$code($retrievedPetType)."); passed=false; throw new InvalidMessageException("C200_97", f"Unknown message: $code"); 
		}
	}
	def sendupdatePetType_96(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var petType = util.getUpdatedPetType(r)
		val request = pettypesApi.updatePetType(info.getPetType_98.petTypeId, petType)
val response = request.send(backend)
		sequence.append(f"!updatePetType_96(${info.getPetType_98.petTypeId}, $petType).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_95(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_95(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_95(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_95.freq+=1
				if (count < max) {
					senddeletePetType_94(count+1, sequence, curlSequence)
				} else { tailcall(senddeletePetType_94(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_95", f"Unknown message: $code"); 
		}
	}
	def senddeletePetType_94(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = pettypesApi.deletePetType(info.getPetType_98.petTypeId)
val response = request.send(backend)
		sequence.append(f"!deletePetType_94(${info.getPetType_98.petTypeId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_93(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_93(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_93(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_93.freq+=1
				if (count < max) {
					sendgetPetType_92(count+1, sequence, curlSequence)
				} else { tailcall(sendgetPetType_92(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_93", f"Unknown message: $code"); 
		}
	}
	def sendgetPetType_92(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = pettypesApi.getPetType(info.getPetType_98.petTypeId)
val response = request.send(backend)
		sequence.append(f"!getPetType_92(${info.getPetType_98.petTypeId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_91(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_91(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_91(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_91.freq+=1
				if (count < max) {
					sendupdatePetType_90(count+1, sequence, curlSequence)
				} else { tailcall(sendupdatePetType_90(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_91", f"Unknown message: $code"); 
		}
	}
	def sendupdatePetType_90(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var petType = util.getUpdatedPetType(r)
		val request = pettypesApi.updatePetType(info.getPetType_98.petTypeId, petType)
val response = request.send(backend)
		sequence.append(f"!updatePetType_90(${info.getPetType_98.petTypeId}, $petType).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_89(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_89(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_89(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_89.freq+=1
				if (count < max) {
					senddeletePetType_88(count+1, sequence, curlSequence)
				} else { tailcall(senddeletePetType_88(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_89", f"Unknown message: $code"); 
		}
	}
	def senddeletePetType_88(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = pettypesApi.deletePetType(info.getPetType_98.petTypeId)
val response = request.send(backend)
		sequence.append(f"!deletePetType_88(${info.getPetType_98.petTypeId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_87(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_87(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_87(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_87.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_87", f"Unknown message: $code"); 
		}
	}
	def receiveC201_117(responseCode: Int, specialty: Specialty, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($specialty).")
				if(util.setSpecialty(specialty)){
					info.C201_117.freq+=1
					info.C201_117.specialty = specialty
					if (count < max) {
						sendlistSpecialties_116(count+1, sequence, curlSequence)
					} else { tailcall(sendlistSpecialties_116(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C201_117", "Violation in Assertion: util.setSpecialty(specialty)");  }
			case code @ _ => sequence.append(f"?$code($specialty)."); passed=false; throw new InvalidMessageException("C201_117", f"Unknown message: $code"); 
		}
	}
	def sendlistSpecialties_116(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = specialtyApi.listSpecialties()
val response = request.send(backend)
		sequence.append(f"!listSpecialties().")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_115(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Specialty]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Specialty]], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_115(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Seq[Specialty]] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Seq[Specialty]], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_115", f"Unexpected response: $response")
			}
	}
	def receiveC200_115(responseCode: Int, specialties: Seq[Specialty], count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($specialties).")
				if(specialties.contains(info.C201_117.specialty)){
					info.C200_115.freq+=1
					if (count < max) {
						sendupdateSpecialty_114(count+1, sequence, curlSequence)
					} else { tailcall(sendupdateSpecialty_114(0, sequence, curlSequence)) }
				} else {
				passed=false; throw new AssertionViolationException("C200_115", "Violation in Assertion: specialties.contains(specialty)");  }
			case code @ _ => sequence.append(f"?$code($specialties)."); passed=false; throw new InvalidMessageException("C200_115", f"Unknown message: $code"); 
		}
	}
	def sendupdateSpecialty_114(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var specialtyId = util.getSpecialtyId(r)
		var specialty = util.getUpdatedSpecialty(r)
		val request = specialtyApi.updateSpecialty(specialtyId, specialty)
val response = request.send(backend)
		sequence.append(f"!updateSpecialty_114($specialtyId, $specialty).")
		curlSequence.append(request.toCurl+"\n\n")
		info.updateSpecialty_114.specialtyId = specialtyId
		if (count < max) {
			receiveC204_113(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_113(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_113(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_113.freq+=1
				if (count < max) {
					sendgetSpecialty_112(count+1, sequence, curlSequence)
				} else { tailcall(sendgetSpecialty_112(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_113", f"Unknown message: $code"); 
		}
	}
	def sendgetSpecialty_112(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = specialtyApi.getSpecialty(info.updateSpecialty_114.specialtyId)
val response = request.send(backend)
		sequence.append(f"!getSpecialty_112(${info.updateSpecialty_114.specialtyId}).")
		curlSequence.append(request.toCurl+"\n\n")
		try {
			if (count < max) {
			receiveC200_111(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Specialty] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Specialty], count+1, sequence, curlSequence)
		} else { tailcall(receiveC200_111(response.code.toString.toInt, if(response.body.isInstanceOf[Right[Any, Any]]) response.body.asInstanceOf[Right[Any, Any]].value.asInstanceOf[Specialty] else response.body.asInstanceOf[Left[Any, Any]].value.asInstanceOf[Specialty], 0, sequence, curlSequence)) }
		} catch {
			case e: java.lang.ClassCastException =>
				throw new InvalidMessageException("C200_111", f"Unexpected response: $response")
			}
	}
	def receiveC200_111(responseCode: Int, retrievedSpecialty: Specialty, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 200 =>
			sequence.append(f"?$code($retrievedSpecialty).")
				info.C200_111.freq+=1
				if (count < max) {
					senddeleteSpecialty_110(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteSpecialty_110(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($retrievedSpecialty)."); passed=false; throw new InvalidMessageException("C200_111", f"Unknown message: $code"); 
		}
	}
	def senddeleteSpecialty_110(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = specialtyApi.deleteSpecialty(info.updateSpecialty_114.specialtyId)
val response = request.send(backend)
		sequence.append(f"!deleteSpecialty_110(${info.updateSpecialty_114.specialtyId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC204_109(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC204_109(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC204_109(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 204 =>
			sequence.append(f"?$code().")
				info.C204_109.freq+=1
				if (count < max) {
					sendgetSpecialty_108(count+1, sequence, curlSequence)
				} else { tailcall(sendgetSpecialty_108(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C204_109", f"Unknown message: $code"); 
		}
	}
	def sendgetSpecialty_108(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = specialtyApi.getSpecialty(info.updateSpecialty_114.specialtyId)
val response = request.send(backend)
		sequence.append(f"!getSpecialty_108(${info.updateSpecialty_114.specialtyId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_107(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_107(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_107(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_107.freq+=1
				if (count < max) {
					sendupdateSpecialty_106(count+1, sequence, curlSequence)
				} else { tailcall(sendupdateSpecialty_106(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_107", f"Unknown message: $code"); 
		}
	}
	def sendupdateSpecialty_106(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		var specialty = util.getUpdatedSpecialty(r)
		val request = specialtyApi.updateSpecialty(info.updateSpecialty_114.specialtyId, specialty)
val response = request.send(backend)
		sequence.append(f"!updateSpecialty_106(${info.updateSpecialty_114.specialtyId}, $specialty).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_105(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_105(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_105(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_105.freq+=1
				if (count < max) {
					senddeleteSpecialty_104(count+1, sequence, curlSequence)
				} else { tailcall(senddeleteSpecialty_104(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_105", f"Unknown message: $code"); 
		}
	}
	def senddeleteSpecialty_104(count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		val request = specialtyApi.deleteSpecialty(info.updateSpecialty_114.specialtyId)
val response = request.send(backend)
		sequence.append(f"!deleteSpecialty_104(${info.updateSpecialty_114.specialtyId}).")
		curlSequence.append(request.toCurl+"\n\n")
		if (count < max) {
			receiveC404_103(response.code.toString.toInt, null, count+1, sequence, curlSequence)
		} else { tailcall(receiveC404_103(response.code.toString.toInt, null, 0, sequence, curlSequence)) }
	}
	def receiveC404_103(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_103.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_103", f"Unknown message: $code"); 
		}
	}
	def receiveC404_119(responseCode: Int, body: Null, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 404 =>
			sequence.append(f"?$code().")
				info.C404_119.freq+=1
				done()
			case code @ _ => sequence.append(f"?$code()."); passed=false; throw new InvalidMessageException("C404_119", f"Unknown message: $code"); 
		}
	}
	def receiveC201_121(responseCode: Int, user: User, count: Int, sequence: StringBuilder, curlSequence: StringBuilder): TailRec[Unit] = {
		responseCode match {
			case code @ 201 =>
			sequence.append(f"?$code($user).")
				info.C201_121.freq+=1
				if (count < max) {
					sendInternalChoice4(count+1, sequence, curlSequence)
				} else { tailcall(sendInternalChoice4(0, sequence, curlSequence)) }
			case code @ _ => sequence.append(f"?$code($user)."); passed=false; throw new InvalidMessageException("C201_121", f"Unknown message: $code"); 
		}
	}
}
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


case class VisitAllOf(
  /* The ID of the visit. */
  id: Int,
  /* The ID of the pet. */
  petId: Option[Int] = None
)

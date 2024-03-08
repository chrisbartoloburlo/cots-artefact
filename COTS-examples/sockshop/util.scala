package sockshop

import sockshop.model._

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.util.Random

object util {
  def const(string: String, rand: Random): String ={
    string
  }

  private var apiKey: String = ""
  def setApiKey(apiKey: String): Unit = {
    this.apiKey=apiKey
  }
  def getApiKey(rand: Random): String = {
    apiKey
  }

  def rndRegister(rand: Random): Register = {
    val id = Random.nextInt
    Register(f"testUser${id}", "testPassword",
             Some(f"test${id}@domain.com"))
  }

  private var userId = ""
  def setUserId(resp: Statusresponse): Boolean = {
    userId = resp.id
    true
  }
  def getUserId(rand: Random): String = {
    userId
  }

  def checkCustomerExists(customers: Getcustomersresponse, username: String): Boolean = {
    (!customers.embedded.customer.isEmpty) &&
      customers.embedded.customer.get.exists(c => c.username == username)
  }

  def checkCustomerNotExists(customers: Getcustomersresponse, username: String): Boolean = {
    customers.embedded.customer.isDefined &&
      customers.embedded.customer.get.forall(c => c.username != username)
  }

  def checkCardsEmpty(cards: Getcardsresponse): Boolean = {
    cards.embedded.card.isEmpty || (cards.embedded.card.get.size == 0)
  }
}

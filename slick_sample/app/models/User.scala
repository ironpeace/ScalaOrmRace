package models
 
import scala.slick.driver.H2Driver.simple._
 
 
case class User(id: Option[Int] = None, name: String, age:Int)
 
object Users extends Table[User]("users") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
 
  // This is the primary key column
  def name = column[String]("name")

  def age = column[Int]("age")
 
  // Every table needs a * projection with the same type as the table's type parameter
  def * = id.? ~ name ~ age <> (User, User.unapply _)
}
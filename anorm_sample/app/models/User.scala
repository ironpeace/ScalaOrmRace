import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

import java.util.Date

case class User(id:Pk[Int], name:String, age:Int)

object User {

  val simple = { 
    get[Pk[Int]]("ID") ~
    get[String]("NAME") ~ 
    get[Int]("AGE")  map { 
      case id~name~age
        => User(id, name, age)
    }
  }

  def create (name:String, age:Int) = {
    DB.withConnection { implicit conn =>
      SQL("""
          INSERT INTO USER (name, age)
          VALUES ({name}, {age})
          """)
        .on(
          "name" -> name, 
          "age" -> age
        ).executeInsert()
    }
  }

  def all():List[User] = { 
    DB.withConnection{ implicit conn =>
      SQL("SELECT * FROM USER").as(User.simple *)
    }
  }

  def count():Long = {
    DB.withConnection{ implicit conn =>
      SQL("select count(*) from USER").as(scalar[Long].single)
    }
  }

}
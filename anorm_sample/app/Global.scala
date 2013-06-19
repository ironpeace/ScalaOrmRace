import play.api._
import play.api.db._
import play.api.Play.current
import models._
import anorm._
import anorm.SqlParser._

object Global extends GlobalSettings {
	override def onStart(app: Application) {
		for (i <- 1 to 1000) {
			User.create("name" + i, i)
		}

		println(User.count + " records are inserted")


	    DB.withConnection{ implicit conn =>
			val start = new java.util.Date()
	    	val users = SQL("SELECT * FROM USER").as(User.simple *)
			val end = new java.util.Date()
			println(end.getTime - start.getTime + " ms spent from start to end")
	    }

	}
}
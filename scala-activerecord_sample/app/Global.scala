import play.api._
import com.github.aselab.activerecord._
import models._
import com.github.aselab.activerecord.dsl._

object Global extends GlobalSettings {
	override def onStart(app: Application) {
		Tables.initialize

		for (i <- 1 to 1000) {
			User("name" + i, i).save
		}

		println(User.count + " records are inserted")

		inTransaction{
			val start = new java.util.Date()
			val users = User.all.toList
			val end = new java.util.Date()
			println(end.getTime - start.getTime + " ms spent from start to end")
		}


	}

}
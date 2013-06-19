import play.api._
import play.api.GlobalSettings
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.{GetResult, StaticQuery => Q} 
import Q.interpolation
import Database.threadLocalSession
 
import play.api.Application
import play.api.Play.current

import models._
 
 
object Global extends GlobalSettings {
 
  override def onStart(app: Application) {
 
 	Database.forURL("jdbc:h2:mem:play", driver = "org.h2.Driver") withSession {
		Users.ddl.create

		for (i <- 1 to 1000) {
			Users.insert(User(None, "name" + i, i))
		}

		val start = new java.util.Date()
		val l = Query(Users).list
		val end = new java.util.Date()
		println(end.getTime - start.getTime + " ms spent from start to end")

    }
  }
}
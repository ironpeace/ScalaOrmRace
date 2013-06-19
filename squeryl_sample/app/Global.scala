import org.squeryl.adapters.{H2Adapter, PostgreSqlAdapter}
import org.squeryl.internals.DatabaseAdapter
import org.squeryl.{Session, SessionFactory}
import org.squeryl.PrimitiveTypeMode._

import play.api._
import play.api.db._
import play.api.GlobalSettings

import play.api.Application

import models._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    SessionFactory.concreteFactory = app.configuration.getString("db.default.driver") match {
      case Some("org.h2.Driver") => Some(() => getSession(new H2Adapter, app))
      case Some("org.postgresql.Driver") => Some(() => getSession(new PostgreSqlAdapter, app))
      case _ => sys.error("Database driver must be either org.h2.Driver or org.postgresql.Driver")
    }


    inTransaction {
		for (i <- 1 to 1000) {
			//new User(Some("name" + i), Some(i)).save
			AppDB.user.insert(new User(Some("name" + i), Some(i)))
		}

		val c = from( AppDB.user )( u => compute (count( u.id ) ) )
		println(c + " records are inserted ******************************")

		val start = new java.util.Date()
		val list = from(AppDB.user)(s => select(s)).toList
		val end = new java.util.Date()
		println(end.getTime - start.getTime + " ms spent from start to end ******************************")
    }
  }

  def getSession(adapter:DatabaseAdapter, app: Application) = Session.create(DB.getConnection()(app), adapter)

}
import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "slick_sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.typesafe.slick" %% "slick" % "1.0.0",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "com.h2database" % "h2" % "1.3.166"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}

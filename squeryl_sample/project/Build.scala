import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "squeryl_sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "org.squeryl" %% "squeryl" % "0.9.5-6",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "com.h2database" % "h2" % "1.3.166"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}

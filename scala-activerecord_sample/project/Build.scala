import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "scala-activerecord_sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.github.aselab" %% "scala-activerecord" % "0.2.2",
    "org.slf4j" % "slf4j-nop" % "1.7.2",
    "com.h2database" % "h2" % "1.3.170"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    resolvers ++= List(
        "aselab repo" at "http://aselab.github.com/maven/"
    )
  )

}


import play.Project._





name := "playmodules"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

lazy val root = project.in(file(".")).aggregate(web, portal).dependsOn(web, portal)

lazy val web = project.in(file("modules/web"))

lazy val portal = project.in(file("modules/portal"))


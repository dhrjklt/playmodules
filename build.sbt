
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

TaskKey[Unit]("stop") := {
  val pidFile = target.value / "universal" / "stage" / "RUNNING_PID"
  if (!pidFile.exists) throw new Exception("App not started!")
  val pid = IO.read(pidFile)
  s"kill $pid".!
  println(s"Stopped application with process ID $pid")
}
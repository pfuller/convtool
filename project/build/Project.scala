import sbt._

class SimpleProject(info: ProjectInfo) extends DefaultProject(info) {
  val toolsrepo = "toolsrepo" at "http://scala-tools.org/repo-releases/"

  override def libraryDependencies = Set(
    "org.scala-lang" % "scala-swing" % "2.8.1" % "compile->default"
  ) ++ super.libraryDependencies
}

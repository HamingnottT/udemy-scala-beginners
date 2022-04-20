
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
    //   organization := "ch.epfl.scala",
      scalaVersion := "3.0.2" //Daniel Ciocîrlan chose scala 3
    )),
    name := "udemy-scala-beginners"
  )

// To learn more about multi-project builds, head over to the official sbt
// documentation at http://www.scala-sbt.org/documentation.html

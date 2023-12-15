
ThisBuild / organization := "com.tagless-final-practice"
ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.0.1-SNAPSHOT"

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:_",
  "-unchecked",
  "-Wunused:_",
  "-Wvalue-discard",
  "-Xfatal-warnings",
  "-Ymacro-annotations"
)


lazy val `tagless-final-practice`
            = project
                .in(file("."))
                .settings(commonSettings)
                .aggregate(dsls, interpreters, programs, main)

lazy val dsls
            = project
                .in(file("01-dsls"))
                .settings(commonSettings)

lazy val interpreters
            = project
                .in(file("02-interpreters"))
                .dependsOn(dsls)
                .settings(commonSettings)
                .settings(
                    libraryDependencies += "org.typelevel" %% "cats-core" % "2.7.0"
                )
            
lazy val programs
            = project
                .in(file("02-programs"))
                .dependsOn(dsls)
                .settings(commonSettings)
                
lazy val main = project
                .in(file("03-main"))
                .dependsOn(interpreters)
                .dependsOn(programs)
                .settings(commonSettings)

lazy val commonSettings = Seq(
  addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full),
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings"
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value
)

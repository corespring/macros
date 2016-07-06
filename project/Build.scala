import sbt._
import sbt.Keys._
import org.corespring.sbt.repo.RepoAuthPlugin.Keys.authPublishTo
import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.Version.Bump

object Build extends sbt.Build{

  lazy val macros = Project("macros", file("macros"))
      .settings(
        libraryDependencies <+= (scalaVersion)( "org.scala-lang" % "scala-reflect" % _),
        releaseVersionBump := Bump.Minor,
        publishTo := authPublishTo.value
      )

  lazy val test = Project("macros-test", file("test"))
    .settings(
      publish := false,
      libraryDependencies += "org.specs2" %% "specs2-core" % "3.3.1" % "test"
    )
    .dependsOn(macros)

  lazy val root = Project("macros-root", file("."))
    .aggregate(macros,test)
}
package config

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._

object Constants {

  val conf = ConfigFactory.load("app.properties")

  // Application Details
  val baseUrl = conf.getString("BASE_URL")

  // Scenario Details
  val repeatTimes = conf.getString("REPEAT").toInt
  val pause = conf.getString("PAUSEBETWEENREQUESTSMS").toInt
  val pace = conf.getString("PACEINMS").toInt

  // Game scenario details
  val gamecsvFeeder = csv(conf.getString("game"))

}
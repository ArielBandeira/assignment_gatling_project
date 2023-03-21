package scenario

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import request.GameRequests
import config.Constants

object Scenarios {
  def createScenario (name: String, feed: FeederBuilder, chains: ChainBuilder*): ScenarioBuilder = {
    if(Constants.repeatTimes > 0) {
      scenario(name).feed(feed).repeat(Constants.repeatTimes) {
        pace(Constants.pace).exec(chains).pause(Constants.pause)
      }
    } else {
        scenario(name).feed(feed).forever() {
          pace(Constants.pace).exec(chains).pause(Constants.pause)
        }
    }
  }

  val scnGameDetails = createScenario("getGameById", Constants.gamecsvFeeder.circular, GameRequests.getGameById)

}

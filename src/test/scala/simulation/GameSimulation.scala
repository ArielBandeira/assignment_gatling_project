package simulation

import io.gatling.core.Predef._
import config._
import request.GameRequests
import _root_.scenario._

import scala.concurrent.duration._

class GameSimulation extends Simulation {

  setUp(Scenarios.createScenario("getGameById", Constants.gamecsvFeeder.circular, GameRequests.getGameById)
    .inject(constantConcurrentUsers(5) during(10), rampConcurrentUsers(5) to (15) during(10)))
    .protocols(Constants.httpProtocol)
    .maxDuration(60)
    .assertions(
      global.successfulRequests.percent.is(100)
    )
}
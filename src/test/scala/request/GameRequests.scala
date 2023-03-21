package request

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GameRequests {

  val getGameById = exec(http("getGameById").get("/api/game?id=${game_id}")
        .check(bodyString.saveAs("myResponse")))
        .exec( session => {
          println(session("myResponse").as[String])
          session
        })
}

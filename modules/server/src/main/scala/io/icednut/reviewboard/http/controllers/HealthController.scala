package io.icednut.reviewboard.http.controllers

import io.icednut.reviewboard.http.endpoints.HealthEndpoint
import sttp.tapir.*
import zio.*

class HealthController private extends HealthEndpoint {
    val health = healthEndpoint
        .serverLogicSuccess[Task](_ => ZIO.succeed("All Good!"))
}

object HealthController {

    val makeZIO = ZIO.succeed(new HealthController)
}

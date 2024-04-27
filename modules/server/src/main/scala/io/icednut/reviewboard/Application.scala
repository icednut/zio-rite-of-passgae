package io.icednut.reviewboard

import zio.*
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import zio.http.Server
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.server.ziohttp.ZioHttpServerOptions
import io.icednut.reviewboard.http.controllers.HealthController

object Application extends ZIOAppDefault {

    val program = for {
        controller <- HealthController.makeZIO
        _ <- Server.serve(
            ZioHttpInterpreter(
                ZioHttpServerOptions.default
            ).toHttp(controller.health)
        )
    } yield ()

    override def run = program.provide(
        Server.default
    )
}

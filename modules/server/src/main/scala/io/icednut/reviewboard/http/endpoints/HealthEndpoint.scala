package io.icednut.reviewboard.http.endpoints

import sttp.tapir.*

trait HealthEndpoint {
    val healthEndpoint = endpoint
        .tag("health")
        .name("health")
        .description("health check endpoint")
        // ^^ for documentation
        .get                    // http method
        .in("health")           // path
        .out(plainBody[String]) // output
}

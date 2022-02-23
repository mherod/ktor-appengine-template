package com.example

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationKtTest {

    @Test
    fun testRootGetHelloWorld() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(
                    expected = "Hello, world!",
                    actual = response.content
                )
            }
        }
    }
}

package com.github.fnunezkanut

import com.github.fnunezkanut.models.UuidResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@RunWith(SpringRunner::class)
@SpringBootTest
class AppTests {

    lateinit var client: WebTestClient

    @Autowired
    lateinit var routerFunction: RouterFunction<ServerResponse>

    @Before
    fun setUp() {
        client = WebTestClient.bindToRouterFunction(routerFunction).build()
    }

    @Test
    fun getUuid() {

        //given

        //when
        var result = client.get().uri("/uuid").exchange().expectStatus().isOk.returnResult<UuidResponse>()
        var uuidResponse = result.responseBody.blockFirst()

        //then
        assertThat(result.status.value()).isEqualTo(200)
        assertThat(uuidResponse).isExactlyInstanceOf(UuidResponse::class.java)
    }
}
package com.epseelon

import geb.spock.GebSpec
import grails.http.client.RxHttpClientBuilder
import grails.test.mixin.integration.Integration
import grails.transaction.Transactional
import spock.lang.Shared

/**
 * Created by sarbogast on 14/02/2017.
 */
@Integration
@Transactional
class TodoControllerSpec extends GebSpec {

    @Shared RxHttpClientBuilder rest = new RxHttpClientBuilder()

    void "test get todos"() {
        when:
        def resp = rest.get("http://localhost:${serverPort}/todo").toBlocking().first()
        def jsonResponse = resp.toJson().toBlocking().first()

        then:
        jsonResponse.size() == 3
        ['TODO', 'IN_PROGRESS', 'DONE'].contains(jsonResponse[0].status)
    }
}

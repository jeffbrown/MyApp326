package com.epseelon

import geb.spock.GebSpec
import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import grails.transaction.Transactional

/**
 * Created by sarbogast on 14/02/2017.
 */
@Integration
@Transactional
class TodoControllerSpec extends GebSpec {
    void "test get todos"() {
        expect:
        def resp = new RestBuilder().get("$baseUrl/todo")
        resp.json.size() == 3
        ['TODO', 'IN_PROGRESS', 'DONE'].contains(resp.json[0].status)
    }
}

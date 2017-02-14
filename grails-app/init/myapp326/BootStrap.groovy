package myapp326

import com.epseelon.Todo
import com.epseelon.TodoStatus
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Enum) {
            return it.toString()
        }

        new Todo(title: "Buy some milk", status: TodoStatus.TODO).save(failOnError: true)
        new Todo(title: "Get the laundry", status: TodoStatus.IN_PROGRESS).save(failOnError: true)
        new Todo(title: "Change the light bulb", status: TodoStatus.DONE).save(failOnError: true)
    }
    def destroy = {
    }
}

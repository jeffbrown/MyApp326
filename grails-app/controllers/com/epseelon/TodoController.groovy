package com.epseelon

import grails.converters.JSON

class TodoController {
	static responseFormats = ['json']
	
    def index() {
        def todos = Todo.findAll().collect {
            new TodoListItem(title: it.title, status: it.status)
        }
        render todos as JSON
    }
}

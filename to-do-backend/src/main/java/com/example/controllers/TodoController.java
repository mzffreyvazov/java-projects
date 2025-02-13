package com.example.controllers;

import com.example.models.responses.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.models.TodoItem;
import com.example.services.TodoService;

import java.util.List;
import java.util.Map;


@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping("/yourtodos")
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todoItem) {
        TodoItem createdTodo = todoService.addTodoItem(todoItem);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @GetMapping("/yourtodos")
    public ResponseEntity<?> getTodoByTitle(@RequestParam(required = false) String title, @RequestParam(required = false) Long id) {
        // If there is a title request parameter: get todo item by title
        if (title != null) {
            TodoItem item = todoService.getTodoItemByTitle(title);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        // If there is a id request parameter: get todo item by id
        else if (id != null) {
            TodoItem item = todoService.getTodoById(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        // Otherwise: get all todo
        else {
            List<TodoItem> todos = (List<TodoItem>) todoService.getAllTodos();
            return new ResponseEntity<>(todos, HttpStatus.OK);
        }
    }


    @PutMapping("/yourtodos/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable(value = "id") Long id, @RequestBody TodoItem todoItem) {
        todoItem.setId(id);
        return todoService.updateTodoItem(id, todoItem);
    }

    @DeleteMapping("/yourtodos/delete")
    public ResponseEntity<?> deleteTodo(@RequestParam(required = false) Long id, @RequestParam(required = false) String title) {
        if (id != null) {
            todoService.deleteTodoItem(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);

        } else if (title != null) {
            return todoService.deleteTodoItemByTitle(title);
        }
        else {
            // if neither id nor title is provided, then get all the todos and return bad request response
            List<TodoItem> todos = (List<TodoItem>) todoService.getAllTodos();
            String message = "Please provide either 'id' or 'title'";
            return new ResponseEntity<>(new DeleteResponse(message, todos), HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/yourtodos/partially-update{id}")
    public ResponseEntity<?> partialUpdateTodo(@RequestParam(value = "id") Long id, @RequestBody Map<String, Object> updates) {

        TodoItem existingTodo = todoService.getTodoById(id);
        if (updates.containsKey("taskTitle")) {
            existingTodo.setTaskTitle((String) updates.get("taskTitle"));
        }
        if (updates.containsKey("taskDescription")) {
            existingTodo.setTaskDescription((String) updates.get("taskDescription"));
        }
        if (updates.containsKey("isCompleted")) {
            existingTodo.setIsCompleted((Boolean) updates.get("isCompleted"));
        }

        return todoService.updateTodoItem(id, existingTodo);

    }

    // search todos whose title contains the word: basic implementation
    @GetMapping("/yourtodos/search{word}")
    public ResponseEntity<List<TodoItem>> searchTodos(@RequestParam String word) {
        List<TodoItem> todoItems = todoService.getTodosWithWord(word);
        return new ResponseEntity<>(todoItems, HttpStatus.OK);
    }

    // search todos whose description contains the word: database query
    @GetMapping("/yourtodos/search-desc{word}")
    public ResponseEntity<List<TodoItem>> searchTodosByDesc(@RequestParam String word) {
        List<TodoItem> todoItems = todoService.getTodosWithWordInDesc(word);
        return new ResponseEntity<>(todoItems, HttpStatus.OK);
    }
}

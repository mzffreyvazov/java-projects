package com.example.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.models.TodoItem;
import com.example.repositories.TodoRepoInterface;

@Service
public class TodoService {
    
    private TodoRepoInterface todoRepoInterface;

    public TodoService(TodoRepoInterface todoRepoInterface) {
        this.todoRepoInterface = todoRepoInterface;
    }

    // list of services: getalltodos, addtodo, updatetodo, deletetodo, findbytitle, 

    // get all todo
    public Iterable<TodoItem> getAllTodos() {
        return todoRepoInterface.findAll();
    }

    //add todo
    public TodoItem addTodoItem(TodoItem todoItem) {
        return todoRepoInterface.save(todoItem);
    }

    // update todo
    public ResponseEntity<String> updateTodoItem(Long id, TodoItem todoItem) {
        // First check if todo exists
        if (!todoRepoInterface.existsById(id)) {
            return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
        }

        boolean updated = todoRepoInterface.updateTodo(
                id,
                todoItem.getTaskTitle(),
                todoItem.getTaskDescription(),
                todoItem.getIsCompleted()
        );

        if (updated) {
            return new ResponseEntity<>("Todo updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update todo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete todo by id
    public void deleteTodoItem(long id) {
        todoRepoInterface.deleteById(id);
    }

    //delete todo by title
    public ResponseEntity<String> deleteTodoItemByTitle(String title) {
        boolean deleted = todoRepoInterface.deleteTodoByTitle(title);

        if (deleted) {
            return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete todo", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // get todo by title
    public TodoItem getTodoItemByTitle(String title) {
        return todoRepoInterface.findByTaskTitle(title);
    }

    // get todo by id
    public TodoItem getTodoById(long id) {
        return todoRepoInterface.findById(id).orElse(null);
    }

    // get todos that contains a specific keyword
    // this method is inefficient, since it retrieves all the data from database and then filters
    public List<TodoItem> getTodosWithWord(String word) {
        List<TodoItem> allTodos = (List<TodoItem>) todoRepoInterface.findAll();
        List<TodoItem> filteredTodos = new ArrayList<TodoItem>();
        for (TodoItem todoItem : allTodos) {
            if (todoItem.getTaskTitle().contains(word)) {
                filteredTodos.add(todoItem);
            }
        }
        return filteredTodos;
    }

    // get todos whose description contains a specific word
    public List<TodoItem> getTodosWithWordInDesc(String word) {
        return todoRepoInterface.getTodosWithWordInDesc(word);
    }

}

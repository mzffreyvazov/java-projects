package com.example.models.responses;

import com.example.models.TodoItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DeleteResponse {
    private String message;
    private List<TodoItem> todos;
}

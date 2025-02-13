package com.example.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class TodoItem implements Serializable {

    @Id
    private Long id;
    private String taskTitle;
    private String taskDescription;
    private Boolean isCompleted;

}

package com.example.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.TodoItem;

@Repository
public interface TodoRepoInterface extends CrudRepository<TodoItem, Long> {

    @Query("SELECT * FROM todo_item WHERE task_title = :title")
    public TodoItem findByTaskTitle(String title);

    @Modifying
    @Query("UPDATE todo_item SET task_title = :title, task_description = :description, is_completed = :completed WHERE id = :id")
    public boolean updateTodo(@Param("id") Long id,
                              @Param("title") String title,
                              @Param("description") String description,
                              @Param("completed") Boolean completed);

    @Modifying
    @Query("delete from todo_item where title = :title")
    public boolean deleteTodoByTitle(@Param("title") String title);

    @Query("SELECT * FROM todo_item WHERE LOWER(task_description) LIKE LOWER(CONCAT('%', :word, '%'))" )
    public List<TodoItem> getTodosWithWordInDesc(String word);
}

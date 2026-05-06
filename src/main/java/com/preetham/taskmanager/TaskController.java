package com.preetham.taskmanager;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TaskController {

    final private List<String> tasks = Collections.synchronizedList(new ArrayList<>());

    @GetMapping("/api/test")
    public String test() {
        return "API is working!";
    }

    @GetMapping("/api/add")
    public String add(@RequestParam String task) {
        tasks.add(task);
        return "Added: " + task;
    }

    @GetMapping("/api/tasks")
    public List<String> getTasks() {
        return tasks;
    }

    @DeleteMapping("/api/clear")
    public String clear() {
        tasks.clear();
        return "All tasks cleared";
    }
}
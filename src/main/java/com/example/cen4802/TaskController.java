package com.example.cen4802;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1, "Submit my assignment"));
        tasks.add(new Task(2, "Study for the FCLE "));
        tasks.add(new Task(3, "Prepare for graduation"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        int newId = tasks.size() + 1;
        tasks.add(new Task(newId, description));
        return "redirect:/";
    }
}
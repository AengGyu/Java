package practice1.toDoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    private final List<String> todos = new ArrayList<>();

    @GetMapping("/")
    public String listTodos(Model model){
        model.addAttribute("todos", todos);
        return "todo";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam("task") String task, Model model){
        if(todos.contains(task)){
            model.addAttribute("error", "이미 존재하는 항목입니다.");
            model.addAttribute("todos" , todos);
            return "todo";
        }
        todos.add(task);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam("index") int index){
        if(index >= 0 && index < todos.size()){
            todos.remove(index);
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editTodoForm(@RequestParam("index") int index, Model model){
        if(index >= 0 && index < todos.size()){
            model.addAttribute("index", index);
            model.addAttribute("todo", todos.get(index));
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String editTodo(@RequestParam("index") int index, @RequestParam("task") String task){
        if(index >= 0 && index < todos.size()){
            todos.set(index, task);
        }
        return "redirect:/";
    }
}

package com.todo.controller;

import com.todo.domain.ToDoDTO;
import com.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping(value = "/") // 투두 리스트이 메인 페이지로 맵핑
    // 제네릭 형태인 List
    public String todoList(Model model){
        // toDoList : 투두 리스트 보내주기 위함
        // todo : 투두에서 객체 받음
        List<ToDoDTO> toDoList = toDoService.getToDoList();
        model.addAttribute("toDoList", toDoList);
        model.addAttribute("todo", new ToDoDTO());
        return "index";
    }

    @PostMapping(value = "/todo/register.do") // 할 일 맵핑
    public String insertToDoList(Model model, ToDoDTO params){
        toDoService.insertToDoList(params);
        return "redirect:/";
    }

    @PostMapping(value = "/todo/update.do")
    public String updateToDoList(@RequestParam(value = "idx", required = false) Long idx, ToDoDTO params){
        System.out.print("check");
        System.out.println(idx);
        toDoService.updateToDoList(params);
        return "redirect:/";
    }

    @PostMapping(value="/todo/delete.do")
    public String deleteToDoList(@RequestParam(value="idx", required = false) Long idx){
        System.out.println("삭제"+idx);
        toDoService.deleteToDoList(idx);
        return "redirect:/";
    }
}
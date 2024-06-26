package com.example.guesstimates.controller;

import com.example.guesstimates.model.Question;
import com.example.guesstimates.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestions(@RequestParam(defaultValue = "2") int count) {
        return questionService.getRandomQuestions(count);
    }
}

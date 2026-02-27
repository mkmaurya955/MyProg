package com.quiz.controller;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/createQuiz")
    public Quiz CreateQuiz(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }
    @GetMapping("/getAll")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id){
        return quizService.getQuizById(id);
    }

}

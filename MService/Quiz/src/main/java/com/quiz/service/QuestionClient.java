package com.quiz.service;


import com.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:1111", value = "QuestionClient")
//For LoadBalance
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/{quizId}")
    public List<Question> getAllQuestionById(@PathVariable Long quizId);
}

package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/createQuestion")
	public Question createQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}
	
	@GetMapping("/getAll")
	public List<Question> getAllQuestion(){
		return questionService.getAllQuestion();
	}
	
	@GetMapping("ques/{id}")
	public Question getbyId(@PathVariable Long id) {
		return questionService.getQuestionById(id);
	}
	@GetMapping("/{quizId}")
	public List<Question> getQuestionByQuizId(@PathVariable Long quizId){
		return questionService.getAllQuestionByQuizId(quizId);
	}
}

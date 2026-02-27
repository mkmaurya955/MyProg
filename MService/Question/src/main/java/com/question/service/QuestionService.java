package com.question.service;

import java.util.List;

import com.question.entity.Question;

public interface QuestionService {

	Question createQuestion(Question question);

	List<Question> getAllQuestion();

	Question getQuestionById(Long Id);

	List<Question> getAllQuestionByQuizId(Long quizId);
}

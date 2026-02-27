package com.quiz.serviceimpl;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizList= quizRepository.findAll();
        List<Quiz> quizQuestionList= quizList.stream().map(quiz->{
            quiz.setQuestion(questionClient.getAllQuestionById(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return quizQuestionList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Resourse not found..!!"));
        quiz.setQuestion(questionClient.getAllQuestionById(quiz.getId()));
        return quiz;
    }
}

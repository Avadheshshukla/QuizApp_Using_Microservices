package com.quiz.Service;

import com.quiz.Model.Quiz;
import com.quiz.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

     @Autowired
    QuestionClient questionClient;

    public String addQuiz(Quiz quiz) {
        quizRepo.save(quiz);
        return "Quiz Added Successfully!!!";
    }

    public List<Quiz> getAllQuiz() {
       List<Quiz> quizzes=  quizRepo.findAll();
       List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
       return quiz;
       }).collect(Collectors.toList());
        return newQuizList;
    }


    public Quiz getQuizById(Integer quizId) {
        Quiz quiz = quizRepo.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found!!!"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
        return quiz;
    }
}

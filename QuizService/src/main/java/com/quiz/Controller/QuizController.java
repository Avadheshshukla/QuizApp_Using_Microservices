package com.quiz.Controller;

import com.quiz.Model.Quiz;
import com.quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping()
    public String addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping()
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable Integer quizId){
        return quizService.getQuizById(quizId);
    }
}

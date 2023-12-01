package com.question.Controller;


import com.question.Model.Question;
import com.question.Service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuesController {

    @Autowired
    QuesService quesService;

    @PostMapping()
    public String addQuestions(@RequestBody Question question){
        return quesService.addQuestions(question);
    }

    @GetMapping("/{quesId}")
    public Question getQuestionById(@PathVariable Integer quesId){
        return quesService.getQuestionById(quesId);
    }

    @GetMapping()
    public List<Question> getAllQuestions(){
        return quesService.getAllQuestions();
    }


    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Integer quizId){
        return quesService.getQuestionsByQuizId(quizId);
    }
}

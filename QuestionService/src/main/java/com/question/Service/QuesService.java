package com.question.Service;

import com.question.Model.Question;
import com.question.Repo.QuesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesService {

    @Autowired
    QuesRepo quesRepo;

    public String addQuestions(Question question) {
        quesRepo.save(question);
        return "Question Added Successfully!!!";
    }

    public Question getQuestionById(Integer quesId) {
        return quesRepo.findById(quesId).orElseThrow(()-> new RuntimeException("Question Not Found with QuestionId "+quesId));
    }

    public List<Question> getAllQuestions() {
        return quesRepo.findAll();
    }

    public List<Question> getQuestionsByQuizId(Integer quizId) {
        return quesRepo.findByQuizId(quizId);
    }


}

package com.question.Repo;

import com.question.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuesRepo extends JpaRepository<Question, Integer> {

    List<Question> findByQuizId(Integer quizId);
}

package com.MARS.QuizApplication.dao;

import com.MARS.QuizApplication.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
}

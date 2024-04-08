package com.lovekholiya.QuizApplication1.dao;

import com.lovekholiya.QuizApplication1.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}

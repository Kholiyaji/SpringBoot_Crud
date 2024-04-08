package com.lovekholiya.QuizApplication1.dao;


import com.lovekholiya.QuizApplication1.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<questions,Integer> {
List<questions> findByCategory(String category);
     @Query(value="SELECT* FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ ",nativeQuery = true)
    List<questions> findRandomQuestionsBycategory(String category, int numQ);
}

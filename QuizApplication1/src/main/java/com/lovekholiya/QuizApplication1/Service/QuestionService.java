package com.lovekholiya.QuizApplication1.Service;

import com.lovekholiya.QuizApplication1.model.questions;
import com.lovekholiya.QuizApplication1.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questiondao;
    public ResponseEntity<List<questions>> getAllQuestions() {
  try {
      return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
  } catch(Exception e){
      e.printStackTrace();
  }
  return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<questions>> getQuestionsByCategory(String category) {
   try{
        return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);}
   catch(Exception e){
       e.printStackTrace();
   }
   return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(questions Questions) {
         questiondao.save(Questions);
         try {
             return new ResponseEntity<>("success", HttpStatus.CREATED);
         }
         catch(Exception e){
             e.printStackTrace();
        }
         return  new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
    }

}

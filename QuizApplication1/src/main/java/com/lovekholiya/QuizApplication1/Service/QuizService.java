package com.lovekholiya.QuizApplication1.Service;

import com.lovekholiya.QuizApplication1.dao.QuestionDao;
import com.lovekholiya.QuizApplication1.dao.QuizDao;
import com.lovekholiya.QuizApplication1.model.QuestionWrapper;
import com.lovekholiya.QuizApplication1.model.Quiz;
import com.lovekholiya.QuizApplication1.model.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
 @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
       List<questions>questions=questionDao.findRandomQuestionsBycategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz=quizDao.findById(id);
       List<questions>questionFromDb=quiz.get().getQuestions();
       List<QuestionWrapper>questionForUser=new ArrayList<>();
       for(questions q:questionFromDb){
           QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionForUser.add(qw);
       }
return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}

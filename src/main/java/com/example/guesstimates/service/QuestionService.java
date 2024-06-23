package com.example.guesstimates.service;

import com.example.guesstimates.model.Question;
import com.example.guesstimates.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> allQuestions = getAllQuestions();
        Random random = new Random();
        return random.ints(0, allQuestions.size())
                     .distinct()
                     .limit(count)
                     .mapToObj(allQuestions::get)
                     .toList();
    }
}

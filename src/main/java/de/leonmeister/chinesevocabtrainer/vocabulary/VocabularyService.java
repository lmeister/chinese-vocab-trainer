package de.leonmeister.chinesevocabtrainer.vocabulary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    public List<Vocabulary> getVocabularies() {
        return vocabularyRepository.findAll();
    }


    public Vocabulary getRandom() {
        List<Vocabulary> allVocab = vocabularyRepository.findAll();
        int random = new Random().nextInt(allVocab.size());
        return allVocab.get(random);
    }
}

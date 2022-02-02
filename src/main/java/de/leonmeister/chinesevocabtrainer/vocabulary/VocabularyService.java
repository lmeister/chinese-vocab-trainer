package de.leonmeister.chinesevocabtrainer.vocabulary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Randomize this
    public Vocabulary getRandom() {
        return vocabularyRepository.findAll().get(1);
    }
}

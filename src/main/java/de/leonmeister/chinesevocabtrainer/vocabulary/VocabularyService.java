package de.leonmeister.chinesevocabtrainer.vocabulary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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


    public Optional<Vocabulary> getRandom() {
        List<Vocabulary> allVocab = vocabularyRepository.findAll();
        if (allVocab.size() == 0) {
            return Optional.empty();
        }
        int random = new Random().nextInt(allVocab.size());
        return Optional.of(allVocab.get(random));
    }

    public void addNewVocabulary(Vocabulary vocabulary) {
        Optional<Vocabulary> vocabularyByHanzi = vocabularyRepository.findVocabularyByHanzi(vocabulary.getHanzi());

        if (vocabularyByHanzi.isPresent()) {
            throw new IllegalStateException("Vocabulary already in database.");
        }
        vocabularyRepository.save(vocabulary);

        System.out.println(vocabulary);
    }

    public void deleteVocabulary(Long id) {
        boolean exists = vocabularyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Could not find vocabulary with id " + id);
        }
        vocabularyRepository.deleteById(id);
    }
}

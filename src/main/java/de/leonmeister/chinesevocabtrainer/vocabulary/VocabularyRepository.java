package de.leonmeister.chinesevocabtrainer.vocabulary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

    @Query("SELECT v FROM Vocabulary v WHERE v.area = ?1") //Könnte man auch weglassen, glaube ich
    Optional<Vocabulary> findVocabularyByArea(String area);

    @Query("SELECT v FROM Vocabulary v WHERE v.hanzi = ?1")
    Optional<Vocabulary> findVocabularyByHanzi(String hanzi);
}

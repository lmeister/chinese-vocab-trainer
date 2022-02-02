package de.leonmeister.chinesevocabtrainer.vocabulary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VocabularyConfig {
    @Bean
    CommandLineRunner commandLineRunner(VocabularyRepository vocabularyRepository) {
        return args -> {
            Vocabulary person = new Vocabulary(
                    "人",
                    "rén",
                    "person",
                    Area.OTHER,
                    Category.NOUN
            );
            Vocabulary china = new Vocabulary(
                    "中国",
                    "zhōngguó",
                    "China",
                    Area.COUNTRIES,
                    Category.NOUN
            );
            vocabularyRepository.saveAll(List.of(person, china));
        };
    }
}

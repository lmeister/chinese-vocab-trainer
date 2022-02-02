package de.leonmeister.chinesevocabtrainer.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VocabularyController {

    @Autowired
    VocabularyService vocabularyService;

    @GetMapping("/")
    public String home(Model model) {
        List<Vocabulary> allVocabularies = vocabularyService.getVocabularies();

        model.addAttribute("amountOfVocabularies", allVocabularies.size());
        model.addAttribute("allVocabularies", allVocabularies);
        return "home";
    }

}

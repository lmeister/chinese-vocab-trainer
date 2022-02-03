package de.leonmeister.chinesevocabtrainer.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("random")
    public String random(Model model) {
        Optional<Vocabulary> vocabulary = vocabularyService.getRandom();
        //For now, redirect to home when there are no vocabs saved
        if (vocabulary.isPresent()) {
            model.addAttribute("vocabulary", vocabulary.get());
            return "random";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("add")
    public String getAddVocabularyForm() {
        return "add";
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addVocabulary(Vocabulary vocabulary) {
        vocabularyService.addNewVocabulary(vocabulary);
    }

    @GetMapping(path="/delete/{id}")
    public String deleteVocabulary(@PathVariable("id") Long id) {
        vocabularyService.deleteVocabulary(id);
        return "redirect:/";
    }
}

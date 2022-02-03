package de.leonmeister.chinesevocabtrainer.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
        Vocabulary vocabulary = vocabularyService.getRandom();
        model.addAttribute("vocabulary", vocabulary);
        return "random";
    }


    @GetMapping("add")
    public String getAddVocabularyForm() {
        return "add";
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addVocabulary(Vocabulary vocabulary) {

//        Vocabulary vocabulary = new Vocabulary(
//                content.get("hanzi"),
//                content.get("pinyin"),
//                content.get("english")
//        );
//        System.out.println(content);
        System.out.println(vocabulary);
        vocabularyService.addNewVocabulary(vocabulary);
    }
}

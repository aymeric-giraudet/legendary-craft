package fr.univlille1.hembertgiraudet.legendarycraft.controller;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.AccountRepository;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private AccountRepository accountRepository;

    private static final Logger log = LoggerFactory.getLogger(CharacterController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String all(Model model, Principal p) {
        model.addAttribute("characters", accountRepository.findByUsername(p.getName()).getCharacters());
        return "character/all";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCharacterById(@PathVariable String id, Model model){
        model.addAttribute("character", characterRepository.findOne(Long.parseLong(id)));
        return "character/character";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCharacter(){
        return "character/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCharacterPost(@ModelAttribute Character c){
        // TODO: Sécurité des entrées
        Character newCharac = characterRepository.save(c);
        return "redirect:"+newCharac.getId();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCharacter(@PathVariable String id){
        characterRepository.delete(Long.parseLong(id));
        return "redirect:/character";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCharacter(@PathVariable String id, Model model){
        model.addAttribute("character", characterRepository.findOne(Long.parseLong(id)));
        return "character/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateCharacterPost(@ModelAttribute Character c){
        // TODO: Sécurité des entrées
        Character newCharac = characterRepository.save(c);
        return "redirect:"+newCharac.getId();
    }

}

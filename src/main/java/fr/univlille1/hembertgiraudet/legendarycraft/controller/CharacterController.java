package fr.univlille1.hembertgiraudet.legendarycraft.controller;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String all(Model model) {
        model.addAttribute("characters", repository.findAll());
        return "character/all";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCharacterById(@PathVariable String id, Model model){
        model.addAttribute("character", repository.findOne(Long.parseLong(id)));
        return "character/character";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCharacter(){
        return "character/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCharacterPost(@ModelAttribute Character c){
        // TODO: Sécurité des entrées
        Character newCharac = repository.save(c);
        return "redirect:"+newCharac.getId();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCharacter(@PathVariable String id){
        repository.delete(Long.parseLong(id));
        return "redirect:/character";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCharacter(@PathVariable String id, Model model){
        model.addAttribute("character", repository.findOne(Long.parseLong(id)));
        return "character/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateCharacterPost(@ModelAttribute Character c){
        // TODO: Sécurité des entrées
        Character newCharac = repository.save(c);
        return "redirect:"+newCharac.getId();
    }

}

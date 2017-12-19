package fr.univlille1.hembertgiraudet.legendarycraft.controller;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Account;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Stats;
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
@RequestMapping(value={"/", "/character"})
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
        Character c = characterRepository.findOne(Long.parseLong(id));
        model.addAttribute("character", c);
        model.addAttribute("stats", c.getStuffStats());
        return "character/character";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCharacter(){
        return "character/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCharacterPost(@ModelAttribute Character c, Principal p){
        // TODO: Sécurité des entrées
        Account account = accountRepository.findByUsername(p.getName());
        c.setAccount(account);
        //c.setStats(new Stats(0,0,0,0,0,0));
        account.getCharacters().add(c);
        accountRepository.save(account);
        return "redirect:"+account.getCharacters().get(account.getCharacters().size()-1).getId();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCharacter(@PathVariable String id, Principal p){
        Account a = accountRepository.findByUsername(p.getName());
        a.getCharacters().remove(characterRepository.findOne(Long.parseLong(id)));
        accountRepository.save(a);
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

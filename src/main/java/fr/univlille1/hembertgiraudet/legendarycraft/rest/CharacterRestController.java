package fr.univlille1.hembertgiraudet.legendarycraft.rest;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/character")
public class CharacterRestController {
    @Autowired
    private CharacterRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Character> getAllCharacters(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Character getCharacterById(@PathVariable String id){
        return repository.findOne(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Character saveCharacter(@RequestBody Character character){
        return repository.save(character);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCharacter(@PathVariable String id){
        repository.delete(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Character updateCharacter(@RequestBody Character character){
        return repository.save(character);
    }

}

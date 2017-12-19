package fr.univlille1.hembertgiraudet.legendarycraft.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Item;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.ItemRepository;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
	
	@Autowired
    private ItemRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Item> getAllItem(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable String id){
        return repository.findOne(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item saveItem(@RequestBody Item character){
        return repository.save(character);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable String id){
        repository.delete(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item character){
        return repository.save(character);
    }

}

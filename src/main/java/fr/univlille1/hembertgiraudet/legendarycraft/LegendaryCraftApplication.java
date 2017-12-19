package fr.univlille1.hembertgiraudet.legendarycraft;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Account;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Item;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Stats;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.AccountRepository;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.CharacterRepository;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LegendaryCraftApplication {

	private static final Logger log = LoggerFactory.getLogger(LegendaryCraftApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LegendaryCraftApplication.class, args);
	}

	@Bean
	public CommandLineRunner itemFilling(ItemRepository repository) {
		return (args) -> {
			repository.save(new Item("Chaperon de chevalier d'Achérus", "Armure : 47\n+15 [Force or Intelligence]\n+15 Endurance\nAugmente votre score de coup critique de +9.", new Stats(15,0,15,0,47,9)));
			repository.save(new Item("Espauliers de chevalier d'Achérus", "Armure : 43\n+11 [Force or Intelligence]\n+11 Endurance\nAugmente votre score de coup critique de +9.", new Stats(11,0,11,0,43,9)));
			repository.save(new Item("Tunique de chevalier d'Achérus", "Armure : 57\n+20 [Force or Intelligence]\n+11 Endurance\nAugmente votre score de coup critique de +7.", new Stats(20,0,11,0,57,7)));
			repository.save(new Item("Ceinturon de chevalier d'Achérus", "Armure : 32\n+10 [Force or Intelligence]\nAugmente votre score de coup critique de +15.", new Stats(10,0,0,0,47,15)));
			repository.save(new Item("Cuissards de chevalier d'Achérus", "Armure : 50\n+13 [Force or Intelligence]\n+15 Endurance\nAugmente votre score de coup critique de +10.", new Stats(13,0,15,0,50,10)));

			log.info("-----------------------------");
			log.info("Item found with findAll():");

			for (Item item : repository.findAll()) {
				log.info(item.toString());
			}

			log.info("-----------------------------");
			log.info("Item found with findOne(2):");

			Item p = repository.findOne(2L);
			log.info(p.toString());

			log.info("-----------------------------");
			log.info("Item found with findByName(Espauliers de chevalier d'Achérus):");

			for (Item item : repository.findByName("Espauliers de chevalier d'Achérus")) {
				log.info(item.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner characterFilling(CharacterRepository characterRepo, AccountRepository accountRepo, ItemRepository itemRepository) {
		return (args) -> {
            Account aymericard = new Account();
            aymericard.setUsername("aymericard");
            aymericard.setPassword("lolilol");
            List<Item> items = new ArrayList<>();
            for(Item item : itemRepository.findAll())
                items.add(item);
            Character c = new Character(aymericard, "Aymericard", 99, new Stats(80, 36, 85, 54, 100, 120));
            c.setStuff(items);
            aymericard.getCharacters().add(c);
            aymericard.getCharacters().add(new Character(aymericard, "Romdeu", 100, new Stats(80, 36, 85, 54, 100, 120)));
            aymericard.getCharacters().add(new Character(aymericard, "xXDarkLink78Xx", 2, new Stats(8, 3, 8, 5, 1, 1)));
            aymericard.getCharacters().add(new Character(aymericard, "Tigre Bois", 74, new Stats(80, 36, 85, 54, 100, 120)));
			accountRepo.save(aymericard);

			Account samantha = new Account();
			samantha.setUsername("samantha");
			samantha.setPassword("lolilol");
			samantha.getCharacters().add(new Character(samantha, "Samantha", 1, new Stats(8, 3, 5, 4, 1, 1)));
			accountRepo.save(samantha);

			log.info("-----------------------------");
			log.info("Characters found with findAll():");

			for (Character charac : characterRepo.findAll()) {
				log.info(charac.toString());
			}

			log.info("-----------------------------");
			log.info("Character found with findOne(4):");

			Character p = characterRepo.findOne(4L);
			log.info(p.toString());

			log.info("-----------------------------");
			log.info("Character found with findByName(Samantha):");

			for (Character charac : characterRepo.findByName("Samantha")) {
				log.info(charac.toString());
			}
		};
	}
}

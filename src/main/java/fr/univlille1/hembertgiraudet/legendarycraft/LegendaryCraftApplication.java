package fr.univlille1.hembertgiraudet.legendarycraft;

import fr.univlille1.hembertgiraudet.legendarycraft.model.Item;
import fr.univlille1.hembertgiraudet.legendarycraft.model.Character;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.CharacterRepository;
import fr.univlille1.hembertgiraudet.legendarycraft.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LegendaryCraftApplication {

	private static final Logger log = LoggerFactory.getLogger(LegendaryCraftApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LegendaryCraftApplication.class, args);
	}

	@Bean
	public CommandLineRunner itemFilling(ItemRepository repository) {
		return (args) -> {
			repository.save(new Item("Chaperon de chevalier d'Achérus", "Armure : 47\n+15 [Force or Intelligence]\n+15 Endurance\nAugmente votre score de coup critique de +9."));
			repository.save(new Item("Espauliers de chevalier d'Achérus", "Armure : 43\n+11 [Force or Intelligence]\n+11 Endurance\nAugmente votre score de coup critique de +9."));
			repository.save(new Item("Tunique de chevalier d'Achérus", "Armure : 57\n+20 [Force or Intelligence]\n+11 Endurance\nAugmente votre score de coup critique de +7."));
			repository.save(new Item("Ceinturon de chevalier d'Achérus", "Armure : 32\n+10 [Force or Intelligence]\nAugmente votre score de coup critique de +15."));
			repository.save(new Item("Cuissards de chevalier d'Achérus", "Armure : 50\n+13 [Force or Intelligence]\n+15 Endurance\nAugmente votre score de coup critique de +10."));

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
	public CommandLineRunner characterFilling(CharacterRepository repository) {
		return (args) -> {
			repository.save(new Character("Aymericard", 99));
			repository.save(new Character("Romdeu", 100));
			repository.save(new Character("xXDarkLink78Xx", 2));
			repository.save(new Character("Tigre Bois", 74));
			repository.save(new Character("Samantha", 1));

			log.info("-----------------------------");
			log.info("Characters found with findAll():");

			for (Character charac : repository.findAll()) {
				log.info(charac.toString());
			}

			log.info("-----------------------------");
			log.info("Character found with findOne(4):");

			Character p = repository.findOne(4L);
			log.info(p.toString());

			log.info("-----------------------------");
			log.info("Character found with findByName(Samantha):");

			for (Character charac : repository.findByName("Samantha")) {
				log.info(charac.toString());
			}
		};
	}
}

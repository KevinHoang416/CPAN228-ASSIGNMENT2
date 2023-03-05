package com.cpan228.Assignment1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.cpan228.Assignment1.model.Item;
import com.cpan228.Assignment1.model.Item.Brand;
import com.cpan228.Assignment1.repository.ItemRepository;

@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository) {
		return args -> {
			repository.save(Item.builder()
					.name("Shirt")
					.brandFrom(Brand.Dior)
					.price(2000)
					.year_of_creation(2023).build());
			repository.save(Item.builder()
					.name("Pants")
					.brandFrom(Brand.Louis_Vuitton)
					.price(4000)
					.year_of_creation(2022).build());
			repository.save(Item.builder()
					.name("Belt")
					.brandFrom(Brand.Polo)
					.price(3000)
					.year_of_creation(2022).build());
			repository.save(Item.builder()
					.name("Scrubs")
					.brandFrom(Brand.Polo)
					.price(1001)
					.year_of_creation(2023).build());

		};
	}

}

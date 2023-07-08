package ca.sheridancollege.sin13014.controllers;

import ca.sheridancollege.sin13014.beans.Drink;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ca.sheridancollege.sin13014.repositories.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller


public class DrinkController {
	private Logger log = LoggerFactory.getLogger(DrinkController.class);
	private DrinkRepository drinkRepo;
	public DrinkController(DrinkRepository drinkRepo){
		this.drinkRepo = drinkRepo;
	}
	@GetMapping("/")
	public String loadRoot(){
		return "home";
	}

	@GetMapping("/view")
	public String viewDrinks(Model model){
		model.addAttribute("drinks", drinkRepo.getDrinks());
		return "view";
	}

	@GetMapping("/add")
	public String addDrink(Model model){
		model.addAttribute("drink", new Drink());
		return "add";
	}
	@PostMapping("/add")
	public String addToRepo(@ModelAttribute Drink drink, Model model){
		drinkRepo.addDrink(drink);
		model.addAttribute("drink", new Drink());
		return "redirect:/add";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model){
		Drink drink = drinkRepo.findById(id);
		log.info(drink.toString());
		model.addAttribute(drink);
		return "edit";
	}

	@PostMapping("/edit")
	public String saveChangesInRepo(@ModelAttribute Drink drink){
		drinkRepo.updateDrink(drink);
		return "redirect:/view";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		log.info(drinkRepo.findById(id).toString());
		drinkRepo.deleteById(id);
		return "redirect:/view";
	}

}


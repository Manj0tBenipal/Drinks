package ca.sheridancollege.sin13014.controllers;

import ca.sheridancollege.sin13014.beans.Drink;
import org.springframework.stereotype.Controller;

import ca.sheridancollege.sin13014.repositories.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DrinkController {
	private DrinkRepository drinkRepo;
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

}


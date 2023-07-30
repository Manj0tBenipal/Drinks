package ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.controllers;


import ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.beans.Ticket;
import ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.beans.User;
import ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.repositories.TicketsRepo;
import ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class MainController {
    private final Logger log = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TicketsRepo ticketRepo;


    @GetMapping("/")
    public String loadRoot() {
        return "home";
    }


    @GetMapping("/viewMyTickets/**")
    public String viewMyTickets(@RequestParam(name = "userName") String userName, Model model) {
        ArrayList<Ticket> tickets = ticketRepo.getTicketsByUserName(userName);
        model.addAttribute("tickets", tickets);
        return "view-tickets";
    }

    @GetMapping("/access-denied")
    public String goAway() {
        return "access-denied";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerUser() {

        return "register";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String password, BCryptPasswordEncoder passwordEncoder) {
        userRepo.addUser(username, passwordEncoder.encode(password));
        log.info("User added");
        return "redirect:login";
    }

    @GetMapping("/viewAllTickets")
    public String viewAllTickets(Model model) {
        ArrayList<Ticket> tickets = ticketRepo.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "view-tickets";
    }

    @GetMapping("/add")
    public String addTicket(Model model) {
        ArrayList<User> users = userRepo.getUsers();
        String[] time = {"9:00AM EDT", "6:00PM EDT", "9:00PM EDT"};
        String[] addresses = {"The Michener Institute · Toronto, Ontario", "Ramada Airport East Hotel Toronto, Ontario", "Metro Toronto Convention Centre (MTCC), Front Street West, Toronto"};
        String[] date = {"September 1, 2023", "September 2, 2023", "September 3, 2023"};
        String[] anime = {"Jujutsu Kaisen", "Demon Slayer","Attack on Titan", "Dragon Ball Z", "Baki Hanma","Zom 100", "Naruto","Tokyo Ghoul", "Tokyo Revengers", "My Hero Academia", "Hells Paradise"};
        Double[] price = {234.98, 199.98, 300.00};
        model.addAttribute("addresses", addresses);
        model.addAttribute("users", users);
        model.addAttribute("time", time);
        model.addAttribute("date", date);
        model.addAttribute("anime", anime);
        model.addAttribute("price", price);
        model.addAttribute(new Ticket());
        return "add";
    }
    @PostMapping("/add-ticket")
    public String addTicket(@ModelAttribute Ticket ticket){
        ticketRepo.addTicket(ticket);
        return "redirect:/viewAllTickets";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  int id, Model model){
        model.addAttribute("ticket" ,ticketRepo.getTicketById(id)) ;
        ArrayList<User> users = userRepo.getUsers();
        String[] time = {"9:00AM EDT", "6:00PM EDT", "9:00PM EDT"};
        String[] addresses = {"The Michener Institute · Toronto, Ontario", "Ramada Airport East Hotel Toronto, Ontario", "Metro Toronto Convention Centre (MTCC), Front Street West, Toronto"};
        String[] date = {"September 1, 2023", "September 2, 2023", "September 3, 2023"};
        String[] anime = {"Jujutsu Kaisen", "Demon Slayer","Attack on Titan", "Dragon Ball Z", "Baki Hanma","Zom 100", "Naruto","Tokyo Ghoul", "Tokyo Revengers", "My Hero Academia", "Hells Paradise"};
        Double[] price = {234.98, 199.98, 300.00};
        model.addAttribute("addresses", addresses);
        model.addAttribute("users", users);
        model.addAttribute("time", time);
        model.addAttribute("date", date);
        model.addAttribute("anime", anime);
        model.addAttribute("price", price);
        return "edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable  int id){
      ticketRepo.deleteById(id) ;
      return "redirect:/viewAllTickets";
    }
    @PostMapping("/update-ticket")
    public String updateTicket(@ModelAttribute Ticket ticket){
    ticketRepo.updateTicket(ticket);
    return "redirect:/viewAllTickets";
    }

    @GetMapping("/registerForEvent/{username}")
    public String registerForEvent(@RequestParam String userName, Model model){
        Ticket ticket = new Ticket();
        ticket.setUserName(userName);
        model.addAttribute("ticket", ticket);
        String[] addresses = {"The Michener Institute · Toronto, Ontario", "Ramada Airport East Hotel Toronto, Ontario", "Metro Toronto Convention Centre (MTCC), Front Street West, Toronto"};
        String[] date = {"September 1, 2023", "September 2, 2023", "September 3, 2023"};
        String[] anime = {"Jujutsu Kaisen", "Demon Slayer","Attack on Titan", "Dragon Ball Z", "Baki Hanma","Zom 100", "Naruto","Tokyo Ghoul", "Tokyo Revengers", "My Hero Academia", "Hells Paradise"};
        String[] time = {"9:00AM EDT", "6:00PM EDT", "9:00PM EDT"};
        model.addAttribute("addresses", addresses);
        model.addAttribute("time", time);
        model.addAttribute("date", date);
        model.addAttribute("anime", anime);

        return "register-for-event";
    }

    @PostMapping("/confirm-guest-ticket")
    public String confirmTicket(@ModelAttribute Ticket ticket){
        ticketRepo.addTicket(ticket);
        return "redirect:/viewMyTickets/?userName=" + ticket.getUserName();
    }
}



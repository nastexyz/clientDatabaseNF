package pl.coderslab.DatabaseNF.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DatabaseNF.dao.TherapistDao;
import pl.coderslab.DatabaseNF.entity.Person;
import pl.coderslab.DatabaseNF.entity.Therapist;
import pl.coderslab.DatabaseNF.repository.TherapistRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/therapist")
public class TherapistController {

    private final TherapistDao therapistDao;
    private final TherapistRepository therapistRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public TherapistController(TherapistDao therapistDao, TherapistRepository therapistRepository, BCryptPasswordEncoder passwordEncoder) {
        this.therapistDao = therapistDao;
        this.therapistRepository = therapistRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String prepareRegister(Model model) {
        model.addAttribute("therapist", new Therapist());
        return "therapist/register";
    }
/*
    @PostMapping("/register")
    public String saveTherapist(@ModelAttribute Therapist therapist) {
        therapist.setPassword(passwordEncoder.encode(therapist.getPassword()));
        therapistRepository.save(therapist);
        return "redirect:/therapist/form/all";
    }*/

   @PostMapping("/register")
    public String saveTherapist(@ModelAttribute("therapist") @Valid Therapist therapist, BindingResult result) {
       if (result.hasErrors()) {
           return "/therapist/therapistForm";
       }
       therapist.setPassword(passwordEncoder.encode(therapist.getPassword()));
       therapistRepository.save(therapist);
       return "redirect:/therapist/form/all";
   }



    @GetMapping("/login")
    public String login() {
        return "therapist/login";
    }

    @GetMapping("/form/all")
    /*public String showAllService(Model model) {*/
        public String showAllTherapist(Model model) {
        model.addAttribute("therapist", therapistDao.findAll());
        return "/therapist/therapistListing";
    }

    @GetMapping("/form/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("therapist", therapistDao.findById(idToEdit));
        return "/therapist/therapistForm";
    }

    @PostMapping("/form/edit")
    public String merge(@ModelAttribute("therapist") @Valid Therapist therapist, BindingResult result) {
        if (result.hasErrors()) {
            return "/therapist/therapistForm";
        }
        therapistDao.merge(therapist);
        return "redirect:/therapist/form/all";
    }

    @GetMapping("/form/remove")
    public String prepareRemove(@RequestParam int idToRemove, Model model) {
        model.addAttribute("therapist", therapistDao.findById(idToRemove));
        return "therapist/remove";
    }

    @PostMapping("/form/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int idToRemove) {
        if ("yes".equals(confirmed)) {
            therapistDao.remove(idToRemove);
        }
        return "redirect:/therapist/form/all";
    }

}

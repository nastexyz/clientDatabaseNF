package pl.coderslab.DatabaseNF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DatabaseNF.dao.PersonDao;
import pl.coderslab.DatabaseNF.dao.ServiceDao;
import pl.coderslab.DatabaseNF.dao.TherapistDao;
import pl.coderslab.DatabaseNF.entity.Person;
import pl.coderslab.DatabaseNF.entity.Service;
import pl.coderslab.DatabaseNF.entity.Therapist;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;
    private final ServiceDao serviceDao;
    private final TherapistDao therapistDao;


    public PersonController (PersonDao personDao, ServiceDao serviceDao, TherapistDao therapistDao) {
        this.personDao = personDao;
        this.serviceDao = serviceDao;
        this.therapistDao = therapistDao;

    }

    @GetMapping("/form/all")
    public String showAllPerson(Model model) {
        model.addAttribute("person", personDao.findAll());
        return "/person/personListing";
    }

    @GetMapping("/form/add")
    public String showPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "/person/personForm";
    }

    @PostMapping("/form/add")
    public String savePerson(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/person/personForm";
        }
        personDao.persist(person);
        return "redirect:/person/form/all";
    }

    @GetMapping("/form/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("person", personDao.findById(idToEdit));
        return "/person/personForm";
    }

    @PostMapping("/form/edit")
    public String merge(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/person/personForm";
        }
        personDao.merge(person);
        return "redirect:/person/form/all";
    }

    @GetMapping("/form/remove")
    public String prepareRemove(@RequestParam int idToRemove, Model model) {
        model.addAttribute("person", personDao.findById(idToRemove));
        return "person/remove";
    }

    @PostMapping("/form/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int idToRemove) {
        if ("yes".equals(confirmed)) {
            personDao.remove(idToRemove);
        }
        return "redirect:/person/form/all";
    }

    @ModelAttribute("therapistLastName")
    public List<Therapist> therapistLastName() {
        return therapistDao.findAll();
    }

    @ModelAttribute("serviceName")
    public List<Service> serviceName() {
        return serviceDao.findAll();
    }


}

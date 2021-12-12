package pl.coderslab.DatabaseNF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DatabaseNF.dao.ServiceDao;
import pl.coderslab.DatabaseNF.entity.Person;
import pl.coderslab.DatabaseNF.entity.Service;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {

    private final ServiceDao serviceDao;

    public ServiceController (ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }


    @GetMapping("/form/all")
    public String showAllService(Model model) {
        model.addAttribute("service", serviceDao.findAll());
        return "/service/serviceListing";
    }

    @GetMapping("/form/add")
    /*public String showPersonForm(Model model) {*/
    public String showServiceForm(Model model) {
        model.addAttribute("service", new Service());
        return "/service/serviceForm";
    }

    @PostMapping("/form/add")
    public String saveService(@ModelAttribute("service") @Valid Service service, BindingResult result) {
        if (result.hasErrors()) {
            return "/service/serviceForm";
        }
        serviceDao.persist(service);
        return "redirect:/service/form/all";
    }

    @GetMapping("/form/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("service", serviceDao.findById(idToEdit));
        return "/service/serviceForm";
    }

    @PostMapping("/form/edit")
    public String merge(@ModelAttribute("service") @Valid Service service, BindingResult result) {
        if (result.hasErrors()) {
            return "/service/serviceForm";
        }
        serviceDao.merge(service);
        return "redirect:/service/form/all";
    }

    @GetMapping("/form/remove")
    public String prepareRemove(@RequestParam int idToRemove, Model model) {
        model.addAttribute("service", serviceDao.findById(idToRemove));
        return "service/remove";
    }

    @PostMapping("/form/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int idToRemove) {
        if ("yes".equals(confirmed)) {
            serviceDao.remove(idToRemove);
        }
        return "redirect:/service/form/all";
    }



}

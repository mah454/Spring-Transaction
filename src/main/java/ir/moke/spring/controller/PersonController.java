package ir.moke.spring.controller;

import ir.moke.spring.model.entities.Person;
import ir.moke.spring.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("session")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    private Person person;
    private String action = "add";

    @RequestMapping(value = "/")
    public String getViewPerson(Model model) {
        model.addAttribute("personList", repository.select());
        model.addAttribute("person", person);
        model.addAttribute("action", action);
        return "index";
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET, params = "edit")
    public String getEditPerson(@RequestParam("id") long id) {
        person = repository.select(id);
        action = "edit";
        return "redirect:/";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST, params = "add")
    public String postAddPerson(@RequestParam("name") String name) {
        repository.insert(new Person(name));
        return "redirect:/";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST, params = "edit")
    public String postEditPerson(@RequestParam("id") long id, @RequestParam("name") String name) {
        person = repository.select(id);
        person.setName(name);
        repository.update(person);
        action = "add";
        person = null;
        return "redirect:/";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST, params = "delete")
    public String postDeletePerson(@RequestParam("id") long id) {
        repository.delete(id);
        return "redirect:/";
    }
}
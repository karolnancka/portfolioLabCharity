package pl.coderslab.charity.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InstitutionController {
    private final InstitutionRepository institutionRepository;


    public InstitutionController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/institutions/add")
    public String getAddForm(Model model) {
        model.addAttribute("institution", new Institution());
        return "addInstitution";
    }

    @PostMapping("/institutions/add")
    public String addUser(@Valid final Institution institution, final BindingResult validationResult) {

        if (validationResult.hasErrors()) {
            return "addInstitution";
        }

        institutionRepository.save(institution);
        return "/index";
    }
}

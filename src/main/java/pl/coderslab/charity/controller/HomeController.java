package pl.coderslab.charity.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {


    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;


    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model) {

        model.addAttribute("donationsOty", donationRepository.count());
        model.addAttribute("bagsQty", donationRepository.getTotalQty().orElse(0));
        model.addAttribute("institutions", institutionRepository.findAll(Pageable.ofSize(4)).getContent());

        return "index";
    }
}

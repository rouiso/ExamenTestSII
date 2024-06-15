package tn.esprit.oumaimarouis.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.oumaimarouis.entities.Company;
import tn.esprit.oumaimarouis.service.ICompany;
import tn.esprit.oumaimarouis.service.IMPCompany;

@RestController
@RequestMapping
public class CompanyController {
    private final ICompany iCompany;

    public CompanyController(ICompany iCompany) {
        this.iCompany = iCompany;
    }

    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company company) {
        return iCompany.addCompany(company);
    }
}

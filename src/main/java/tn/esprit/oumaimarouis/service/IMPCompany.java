package tn.esprit.oumaimarouis.service;

import org.springframework.stereotype.Service;
import tn.esprit.oumaimarouis.entities.Company;
import tn.esprit.oumaimarouis.repositories.CompanyRepository;

@Service
public class IMPCompany implements ICompany {

    private final CompanyRepository companyRepository;

    public IMPCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company addCompany(Company company) {
        if (company.getCompanyName() == null) {
            throw new IllegalArgumentException("Company name cannot be null");
        }
        return companyRepository.save(company);
    }
}
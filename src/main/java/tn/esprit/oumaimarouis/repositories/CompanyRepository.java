package tn.esprit.oumaimarouis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.oumaimarouis.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
Company findByCompanyName(String companyName);
}


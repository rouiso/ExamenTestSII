package tn.esprit.oumaimarouis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.oumaimarouis.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e JOIN e.donationSet d WHERE e.company.companyName = :companyName")
    List<Employee> findEmployeesByCompanyNameAndDonationArea(String companyName);
}

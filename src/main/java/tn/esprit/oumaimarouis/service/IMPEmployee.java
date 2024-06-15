package tn.esprit.oumaimarouis.service;

import org.springframework.stereotype.Service;
import tn.esprit.oumaimarouis.entities.Company;
import tn.esprit.oumaimarouis.entities.Employee;
import tn.esprit.oumaimarouis.repositories.CompanyRepository;
import tn.esprit.oumaimarouis.repositories.EmployeeRepository;

@Service
public class IMPEmployee implements IEmployee{

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public IMPEmployee(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Employee addEmployeeAndAssignToCompany(Employee employee, String companyName) {
        Company company = companyRepository.findByCompanyName(companyName);
        if (company != null) {
            employee.setCompany(company);
            return employeeRepository.save(employee);
        }
        throw new IllegalArgumentException("Company not found");
    }}
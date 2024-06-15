package tn.esprit.oumaimarouis.RestController;

import org.springframework.web.bind.annotation.*;
import tn.esprit.oumaimarouis.entities.Employee;
import tn.esprit.oumaimarouis.service.IEmployee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final IEmployee iEmployee;

    public EmployeeController(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }

    @PostMapping("/employes/{companyName}")
    public Employee addEmployeeAndAssignToCompany(@RequestBody Employee employee, @PathVariable String companyName) {
        return iEmployee.addEmployeeAndAssignToCompany(employee, companyName);
    }}

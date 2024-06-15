package tn.esprit.oumaimarouis.service;

import tn.esprit.oumaimarouis.entities.Employee;

public interface IEmployee {
    Employee addEmployeeAndAssignToCompany(Employee employee, String companyName);
}

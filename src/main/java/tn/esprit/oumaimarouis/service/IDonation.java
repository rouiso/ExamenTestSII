package tn.esprit.oumaimarouis.service;

import tn.esprit.oumaimarouis.entities.Donation;
import tn.esprit.oumaimarouis.entities.DonationType;
import tn.esprit.oumaimarouis.entities.Employee;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IDonation {
    Donation addDonation(Donation donation);
    Set<Donation> getDonationByType(DonationType type);
    void getEmployeeByDonation();
    List<Employee> getEmployeeByArea(String companyName);
    Float getTotalDonation(Date date1, Date date2);
}

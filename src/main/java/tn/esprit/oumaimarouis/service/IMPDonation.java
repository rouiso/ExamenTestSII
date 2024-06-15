package tn.esprit.oumaimarouis.service;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.oumaimarouis.entities.Donation;
import tn.esprit.oumaimarouis.entities.DonationType;
import tn.esprit.oumaimarouis.entities.Employee;
import tn.esprit.oumaimarouis.repositories.DonationRepository;
import tn.esprit.oumaimarouis.repositories.EmployeeRepository;

import java.util.*;
import java.util.stream.Collectors;

public class IMPDonation {
    private final DonationRepository donationRepository;
    private final EmployeeRepository employeeRepository;

    public IMPDonation(DonationRepository donationRepository, EmployeeRepository employeeRepository) {
        this.donationRepository = donationRepository;
        this.employeeRepository = employeeRepository;
    }


    public Donation addDonation(Donation donation) {
        if (donation.getType() == DonationType.MONETARY && donation.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0 for monetary donations");
        }
        if (donation.getType() != DonationType.MONETARY) {
            donation.setAmount(0);
        }
        return donationRepository.save(donation);
    }


    public Set<Donation> getDonationByType(DonationType type) {
        return donationRepository.findByTypeOrderByDate(type);
    }


    @Scheduled(cron = "0 0 0 1 * ?") // Every start of the month
    public void getEmployeeByDonation() {
        // Calculate the first and last day of the previous month
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar.getTime();

        // Get donations made in the previous month
        List<Donation> donations = donationRepository.findDonationsByDateBetween(startDate, endDate);

        // Group donations by employee and count them
        Map<Employee, Long> donationCountByEmployee = donations.stream()
                .collect(Collectors.groupingBy(Donation::getEmployee, Collectors.counting()));

        // Find the employee with the maximum number of donations
        Employee bestEmploye = Collections.max(donationCountByEmployee.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Log the best employee (or perform any other action)
        System.out.println("Best employee for the last month: " + bestEmploye.getFirstName() + " " + bestEmploye.getLastName());
    }


    public List<Employee> getEmployeeByArea(String companyName) {
        return employeeRepository.findEmployeesByCompanyNameAndDonationArea(companyName);
    }


    public Float getTotalDonation(Date date1, Date date2) {
        return donationRepository.calculateTotalAmountBetweenDates(date1, date2);
    }
}

package tn.esprit.oumaimarouis.RestController;

import org.springframework.web.bind.annotation.*;
import tn.esprit.oumaimarouis.entities.Donation;
import tn.esprit.oumaimarouis.entities.DonationType;
import tn.esprit.oumaimarouis.entities.Employee;
import tn.esprit.oumaimarouis.service.IDonation;

import java.util.Date;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/api")
public class DonationController {

    private final IDonation iDonation;

    public DonationController(IDonation iDonation) {
        this.iDonation = iDonation;
    }

    @PostMapping("/donations")
    public Donation addDonation(@RequestBody Donation donation) {
        return iDonation.addDonation(donation);
    }

    @GetMapping("/donations/type/{type}")
    public Set<Donation> getDonationByType(@PathVariable DonationType type) {
        return iDonation.getDonationByType(type);
    }

    @GetMapping("/employes/donations")
    public List<Employee> getEmployeByArea(@RequestParam String companyName) {
        return iDonation.getEmployeeByArea(companyName);
    }

    @GetMapping("/donations/total")
    public Float getTotalDonation(@RequestParam Date date1, @RequestParam Date date2) {
        return iDonation.getTotalDonation(date1, date2);
    }
}

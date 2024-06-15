package tn.esprit.oumaimarouis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.oumaimarouis.entities.Donation;
import tn.esprit.oumaimarouis.entities.DonationType;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface DonationRepository extends JpaRepository<Donation,Long> {
    Set<Donation> findByTypeOrderByDate(DonationType type);
    @Query("SELECT SUM(d.amount) FROM Donation d WHERE d.date BETWEEN :date1 AND :date2")
    Float calculateTotalAmountBetweenDates(Date date1, Date date2);

    @Query("SELECT d FROM Donation d WHERE d.date BETWEEN :startDate AND :endDate")
    List<Donation> findDonationsByDateBetween(Date startDate, Date endDate);

}

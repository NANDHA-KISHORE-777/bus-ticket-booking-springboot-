package cc.example.busbooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cc.example.busbooking.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {
}

package cc.example.busbooking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cc.example.busbooking.model.BusDetails;



@Repository
public interface BusDetailsRepository extends JpaRepository<BusDetails, String> {
    List<BusDetails> findByBusClass(String busClass);
    
}


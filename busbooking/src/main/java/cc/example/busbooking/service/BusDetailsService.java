package cc.example.busbooking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cc.example.busbooking.model.BusDetails;
import cc.example.busbooking.repository.BusDetailsRepository;

import java.util.List;

@Service
public class BusDetailsService {

    @Autowired
    private BusDetailsRepository busRepository;

    public List<BusDetails> getAllBuses() {
        return busRepository.findAll();
    }
    
     public List<BusDetails> findByBusClass(String classString)
    {
        return busRepository.findByBusClass(classString);
    }
    public Page<BusDetails> pagediv(int pno,int size)
    {
        PageRequest pageRequest=PageRequest.of(pno, size,Sort.by(Direction.DESC,"busNo"));
        return busRepository.findAll(pageRequest);
    }
    public BusDetails getBusById(String id) {
        return busRepository.findById(id).orElse(null);
    }

    public BusDetails saveBus(BusDetails bus) {
        return busRepository.save(bus);
    }

    public void deleteBus(String id) {
        busRepository.deleteById(id);
    }
}


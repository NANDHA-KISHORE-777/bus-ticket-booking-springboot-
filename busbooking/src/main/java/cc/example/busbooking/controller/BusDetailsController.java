package cc.example.busbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cc.example.busbooking.model.BusDetails;
import cc.example.busbooking.service.BusDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusDetailsController {

    @Autowired
    private BusDetailsService busService;

    @GetMapping("/get/{class}")
    public List<BusDetails> getAllBuses(@PathVariable("class") String classString) {
        return busService.findByBusClass(classString);
    }
    
    @GetMapping("/get/{pno}/{size}")
    public List<BusDetails> pagBusDetails(@PathVariable int pno,@PathVariable int size) {
        return busService.pagediv(pno,size).getContent();
    }
    
    @GetMapping("/{id}")
    public BusDetails getBusById(@PathVariable String id) {
        return busService.getBusById(id);
    }

    @GetMapping("find/{id}")
    public BusDetails getBusByBusClass(@PathVariable String id) {
        return busService.getBusById(id);
    }

    @PostMapping("/post")
    public BusDetails saveBus(@RequestBody BusDetails bus) {
        return busService.saveBus(bus);
    }
    
    @PutMapping("/{id}")
    public BusDetails updateBus(@PathVariable String id, @RequestBody BusDetails busDetails) {
    BusDetails bus = busService.getBusById(id);
    if (bus == null) {
        throw new RuntimeException("Bus not found with id: " + id);
    }

    bus.setBusNo(busDetails.getBusNo());
    bus.setBusName(busDetails.getBusName());
    bus.setTotalSeats(busDetails.getTotalSeats());
    bus.setBusClass(busDetails.getBusClass());
                                  
    return busService.saveBus(bus);
}

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable String id) {
        busService.deleteBus(id);
    }
}


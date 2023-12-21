package com.cdac.hikers.hikersbackend.booking.controller;

import com.cdac.hikers.hikersbackend.booking.entities.Booking;
import com.cdac.hikers.hikersbackend.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BookingController {
    @Autowired
    public BookingService bookingService;

    @PostMapping("/booking")
    public String saveBooking(@RequestBody Booking booking) {
        String result = bookingService.saveBooking(booking);
        return result;
    }
    @GetMapping("/viewbooking")
    public List<Booking> viewAllBookings(){
        return bookingService.getBookingList();
    }
    @GetMapping("/findbyid/{id}")
    public Booking findById(@PathVariable int Id){
        return bookingService.getById(Id);
    }
    @GetMapping("/findbyname/{id}")
    public Booking findByName(@PathVariable String name){
        return bookingService.getByName(name);
    }
    @DeleteMapping("/deletebyid/{id}")
    public String dataDeleteById(@PathVariable int id){
        return bookingService.deleteById(id);
    }
    @PutMapping("/updatebooking")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.updateData(booking);
    }

}

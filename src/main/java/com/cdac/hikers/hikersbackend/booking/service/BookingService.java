package com.cdac.hikers.hikersbackend.booking.service;

import com.cdac.hikers.hikersbackend.booking.entities.Booking;
import com.cdac.hikers.hikersbackend.booking.repository.BookingRepository;
import com.cdac.hikers.hikersbackend.util.email.service.EmailService;
import com.cdac.hikers.hikersbackend.util.userValidation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserValidation userValidation;

    public String saveBooking(Booking booking) {
        if (userValidation.checkForRegisteredUser(booking.getName(), booking.getEmail())) {
            try {
                if (booking.getName() == null || booking.getName().equals("") || booking.getName().trim().length() < 1) {
                    return "name in booking should not be blank. please try again";
                }
                if (booking.getAddress() == null || booking.getAddress().equals("") || booking.getAddress().trim().length() < 1) {
                    return "address in booking should not be blank, please try again";
                }
                if (booking.getPhone() == null || booking.getPhone().equals("") || booking.getPhone().trim().length() < 1) {
                    return "phone in booking should not be blank, please try again";
                }
                if (booking.getEmail() == null || booking.getEmail().equals("") || booking.getEmail().trim().length() < 1) {
                    return "email in booking should not be blank, please try again";
                }
                if (booking.getTrip() == null || booking.getTrip().equals("") || booking.getTrip().trim().length() < 1) {
                    return "trip in booking should not be blank, please try again";
                }
                bookingRepository.save(booking);
                try {
                    System.out.println("sending email for booking : " + emailService.sendSimpleMail(booking.getName(), booking.getEmail(), booking.getTrip()));
                } catch (Exception e) {
                    System.out.println("exception in sending email : "+e.toString());
                }
                return "Your Booking is completed, you'll receive an email if it's confirmed";
            } catch (Exception e) {
                e.printStackTrace();
                return "booking not saved, try again.";
            }
        } else {
            return "please check Name and Email, it should be same as you entered in Signup.";
        }
    }

    public List<Booking> getBookingList() {
        return bookingRepository.findAll();
    }

    public Booking getById(int id) {
       return bookingRepository.findById(id).orElse(null);
    }

    public Booking getByName(String name) {
        try {
            return bookingRepository.findByName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public String deleteById(int id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return "removed data !!"+id;
        } else {
            return "not found";
        }
    }

    public Booking updateData(Booking booking) {
        Booking existingBooking = bookingRepository.findById(booking.getId()).orElse(null);
        if (existingBooking != null) {
            if (booking.getName() != null) existingBooking.setName(booking.getName());
            if (booking.getDob() != null) existingBooking.setDob(booking.getDob());
            if (booking.getGender() != null) existingBooking.setGender(booking.getGender());
            if (booking.getEmail() != null) existingBooking.setEmail(booking.getEmail());
            if (booking.getTrip() != null) existingBooking.setTrip(booking.getTrip());
            if (booking.getPhone() != null) existingBooking.setPhone(booking.getPhone());
            if (booking.getAddress() != null) existingBooking.setAddress(booking.getAddress());
            if (booking.getPickupPoint() != null) existingBooking.setPickupPoint(booking.getPickupPoint());
        }
//        return existingBooking;
        return bookingRepository.save(existingBooking);
    }

}

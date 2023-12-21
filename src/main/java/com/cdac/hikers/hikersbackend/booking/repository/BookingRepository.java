package com.cdac.hikers.hikersbackend.booking.repository;

import com.cdac.hikers.hikersbackend.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    Booking findByName(String name);
}

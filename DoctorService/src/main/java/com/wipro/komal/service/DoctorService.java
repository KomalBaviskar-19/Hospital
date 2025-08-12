package com.wipro.komal.service;


import org.springframework.data.domain.Page;

import com.wipro.komal.entities.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    Page<Doctor> getAllDoctors(int page, int size);
    List<Doctor> checkAvailability(String availability);
    Doctor updateDoctor(Long id, Doctor doctor);
}

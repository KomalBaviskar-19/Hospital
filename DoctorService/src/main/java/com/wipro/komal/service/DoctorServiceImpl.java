package com.wipro.komal.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wipro.komal.entities.Doctor;
import com.wipro.komal.exception.DoctorNotFoundException;
import com.wipro.komal.repo.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Page<Doctor> getAllDoctors(int page, int size) {
        return doctorRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Doctor> checkAvailability(String availability) {
        return doctorRepository.findByAvailability(availability.toUpperCase());
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with ID " + id));
        
        existing.setName(doctor.getName());
        existing.setSpecialization(doctor.getSpecialization());
        existing.setAvailability(doctor.getAvailability());
        existing.setExperience(doctor.getExperience());
        existing.setEmail(doctor.getEmail());
        existing.setPhone(doctor.getPhone());

        return doctorRepository.save(existing);
    }
}

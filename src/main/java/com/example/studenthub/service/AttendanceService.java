package com.example.studenthub.service;

import com.example.studenthub.entity.Attendance;
import com.example.studenthub.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public AttendanceService (AttendanceRepository attendanceRepository){
    this.attendanceRepository = attendanceRepository;
    }
    public Attendance createAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }
    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }
    public Attendance getAttendanceById(long id){
        return attendanceRepository.findById(id).orElse(null);
    }
    public Attendance updateAttendance(long id , Attendance attendance){
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
                if(existingAttendance == null){
                    return  null;
                }
        existingAttendance.setDate(attendance.getDate());
        existingAttendance.setStatus(attendance.getStatus());
        existingAttendance.setStudent(attendance.getStudent());
        existingAttendance.setSubject(attendance.getSubject());
        return attendanceRepository.save(existingAttendance);
    }

    public void deleteAttendance(Long id){
        attendanceRepository.deleteById(id);
    }
}

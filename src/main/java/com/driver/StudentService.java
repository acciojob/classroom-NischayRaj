package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudentToDB(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacherToDB(teacher);
    }

    public void makingStudentAndTeacher(String student, String teacher) {
        studentRepository.addStudentTeacher(student,teacher);
    }

    public Student findStudent (String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher findTeacher(String name) {
        return studentRepository.getTeacher(name);
    }

    public ArrayList<String> findStudentFromTeacher(String teacher) {
        return studentRepository.getStudentFromTeacher(teacher);
    }

    public ArrayList<String> getAllStudents(){
        return studentRepository.getListOfStudents();
    }

    public void deleteStudents(String teacher) {
        studentRepository.deleteTeacherByStudents(teacher);
    }

    public void deleteTeachers() {
        studentRepository.deleteAllTeacher();
    }

}

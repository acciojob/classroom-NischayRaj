package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private Map<String, Student> sMap;
    private Map<String, Teacher> tMap;
    private Map<String, ArrayList<String>> stMap;

    public StudentRepository() {
        this.sMap = new HashMap<String, Student>();
        this.tMap = new HashMap<String, Teacher>();
        this.stMap = new HashMap<String, ArrayList<String>>();
    }

    public void addTeacherToDB(Teacher teacher) {
        tMap.put(teacher.getName(), teacher);
    }

    public void addStudentToDB(Student student) {
        sMap.put(student.getName(), student);
    }

    public Student getStudent(String student) {
        return sMap.get(student);
    }

    public void addStudentTeacher(String student, String teacher) {
        if (sMap.containsKey(student) && tMap.containsKey(teacher)) {
            sMap.put(student, sMap.get(student));
            tMap.put(teacher, tMap.get(teacher));
            ArrayList<String> StudentsInClass = new ArrayList<>();
            if (tMap.containsKey(teacher)) {
                StudentsInClass = stMap.get(teacher);
                StudentsInClass.add(student);
                stMap.put(teacher, StudentsInClass);
            }
        }
    }

    public Teacher getTeacher(String teacher) {
        return tMap.get(teacher);
    }

    public ArrayList<String> getListOfStudents() {
        return new ArrayList<>(sMap.keySet());
    }
    public ArrayList<String> getStudentFromTeacher(String teacher) {
        ArrayList<String> noOfStudents = new ArrayList<>();
        if (stMap.containsKey(teacher)) {
            noOfStudents = stMap.get(teacher);
        }
        return noOfStudents;
    }


    public void deleteTeacherByStudents(String teacher) {
        ArrayList<String> Students = new ArrayList<>();
        if (stMap.containsKey(teacher)) {
            Students = stMap.get(teacher);
            for (String student : Students) {
                if (sMap.containsKey(student)) {
                    sMap.remove(student);
                }
            }
            stMap.remove(teacher);
        }
        if (tMap.containsKey(teacher)) {
            tMap.remove(teacher);
        }
    }

    public void deleteAllTeacher() {
        HashSet<String> studentHash = new HashSet<String>();
        for (String teacher : stMap.keySet()) {
            for (String student : stMap.get(teacher)) {
                studentHash.add(student);
            }
        }

        for (String student : studentHash) {
            if (sMap.containsKey(student)) {
                sMap.remove(student);
            }
        }
    }
}

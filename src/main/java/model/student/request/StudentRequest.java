package model.student.request;

import java.util.List;

public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    public StudentRequest(String firstName, String lastName, String email, String programme, List<String> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.programme = programme;
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProgramme() {
        return programme;
    }

    public List<String> getCourses() {
        return courses;
    }
}

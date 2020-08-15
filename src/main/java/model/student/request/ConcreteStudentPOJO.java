package model.student.request;

import java.util.List;

public class ConcreteStudentPOJO implements StudentBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    @Override
    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public StudentBuilder setProgramme(String programme) {
        this.programme = programme;
        return this;
    }

    @Override
    public StudentBuilder setCourses(List<String> courses) {
        this.courses = courses;
        return this;
    }

    @Override
    public StudentRequest build() {
        return new StudentRequest(firstName, lastName, email, programme, courses);
    }
}

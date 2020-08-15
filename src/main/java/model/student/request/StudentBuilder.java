package model.student.request;

import java.util.List;

public interface StudentBuilder {

    StudentBuilder setFirstName(String firstName);

    StudentBuilder setLastName(String lastName);

    StudentBuilder setEmail(String email);

    StudentBuilder setProgramme(String programme);

    StudentBuilder setCourses(List<String> courses);

    StudentRequest build();

}

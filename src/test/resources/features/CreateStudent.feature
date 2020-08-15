Feature: Create Student

  Scenario: System admin can create new student
    When I call API to create new student as below info
      | First Name | Last Name | Email                   | Programme        | Courses   |
      | Tung       | Doan      | doansontung@hotmail.com | Computer Science | Java, C++ |
    Then I see the status code is 201
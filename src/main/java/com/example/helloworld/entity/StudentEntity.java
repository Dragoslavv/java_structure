package com.example.helloworld.entity;

public class StudentEntity extends AbstractEntity implements GenericEntityInterface {

    private int $idStudent;

    private String $firstName;

    private String $lastName;

    private String $email;

    public int getId() {
        return $idStudent;
    }

    public String getFirstName() {
        return $firstName;
    }

    public String getLastName() {
        return $lastName;
    }

    public String getEmail() {
        return $email;
    }

    public void setId(int $idStudent) {
        this.$idStudent = $idStudent;
    }

    public void setFirstName(String $firstName){
        this.$firstName = $firstName;
    }

    public void setLastName(String $lastName) {
        this.$lastName = $lastName;
    }

    public void setEmail(String $email) {
        this.$email = $email;
    }

    public String toString()
    {
        String[] $names = new String[0];
        if($firstName.equals("")) {
            $names[1] = $firstName;
        }

        if($lastName.equals("")) {
            $names[2] = $firstName;
        }

        return String.join(" ", $names);
    }

}

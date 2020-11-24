package com.example.helloworld.entity;

public class MarksEntity extends AbstractEntity implements GenericEntityInterface {

    private int $student_id;

    private int $marks;

    @Override
    public int getId() {
        return $student_id;
    }

    @Override
    public void setId(int $student_id) {
        this.$student_id = $student_id;
    }

    public int getMarks() {
        return $marks;
    }

    public void setMarks(int $marks) {
        this.$marks = $marks;
    }
}

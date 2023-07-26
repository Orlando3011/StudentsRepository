package src.model;

public class Grade {
    private Integer grade;
    private int studentId;


    public Grade(Integer grade, int studentId) {
        this.grade = grade;
        this.studentId = studentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return grade.toString();
    }
}

package com.tnsif.certificateServicesprint1;

import jakarta.persistence.*;

@Entity
public class Certificate {

    @Id
    @Column(name = "C_id")
    private int c_id;

    @Column(name = "C_name")
    private String c_name;

    @Column(name = "Issued_By")
    private String issuedBy;

    @Column(name = "Issue_Date")
    private String issueDate;

    @Column(name = "Expiry_Date")
    private String expiryDate;

    @Column(name = "Course")
    private String course;

    @Column(name = "Student_Name")
    private String studentName;

    public Certificate() {}

    public Certificate(int c_id, String c_name, String issuedBy, String issueDate,
                       String expiryDate, String course, String studentName) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.issuedBy = issuedBy;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.course = course;
        this.studentName = studentName;
    }

    // Getters and setters
    public int getC_id() { return c_id; }
    public void setC_id(int c_id) { this.c_id = c_id; }

    public String getC_name() { return c_name; }
    public void setC_name(String c_name) { this.c_name = c_name; }

    public String getIssuedBy() { return issuedBy; }
    public void setIssuedBy(String issuedBy) { this.issuedBy = issuedBy; }

    public String getIssueDate() { return issueDate; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    @Override
    public String toString() {
        return "Certificate [c_id=" + c_id + ", c_name=" + c_name + ", issuedBy=" + issuedBy +
                ", issueDate=" + issueDate + ", expiryDate=" + expiryDate +
                ", course=" + course + ", studentName=" + studentName + "]";
    }
}

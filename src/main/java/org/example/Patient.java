package org.example;


import java.time.LocalDate;

public class Patient {
    private String fullName;
    private String address;
    private LocalDate bornDate;
    private LocalDate receptionDate;
    private String doctorName;
    private String conclusion;


    public  Patient(){
        this.fullName = "";
        this.address = "";
        this.bornDate = null;
        this.receptionDate = null;
        this.doctorName = "";
        this.conclusion = "";
    }

    public Patient(String fullName, String address, LocalDate bornDate, LocalDate receptionDate, String doctorName, String conclusion) {
     this.fullName = fullName;
     this.address = address;
     this.bornDate = bornDate;
     this.receptionDate = receptionDate;
     this.doctorName = doctorName;
     this.conclusion = conclusion;
    }


    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public LocalDate getReceptionDate() {
        return receptionDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBornDate(LocalDate date) {
        this.bornDate = date;
    }

    public void setReceptionDate(LocalDate date) {
        this.receptionDate = date;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}

package pl.coderslab.DatabaseNF.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String address;
    private String postcode;
    private String city;
    @Email
    private String email;
    private String phoneNumber;
    private String firstVisitDate;
    private String therapistLastName;
    private String serviceName;
    private String serviceBegin;
    private String serviceExpire;

    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    private Therapist therapist;

    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    private Service service;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstVisitDate() {
        return firstVisitDate;
    }
    public void setFirstVisitDate(String firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public String getTherapistLastName() {
        return therapistLastName;
    }
    public void setTherapistLastName(String therapistLastName) {
        this.therapistLastName = therapistLastName;
    }

    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Therapist getTherapist() {
        return therapist;
    }
    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }

    public String getServiceBegin() {
        return serviceBegin;
    }
    public void setServiceBegin(String serviceBegin) {
        this.serviceBegin = serviceBegin;
    }

    public String getServiceExpire() {
        return serviceExpire;
    }
    public void setServiceExpire(String serviceExpire) {
        this.serviceExpire = serviceExpire;
    }

    @Override
    public String toString() {
        return "Klient: " +
                "id: " + id +
                ", imię: '" + firstName + '\'' +
                ", nazwisko: '" + lastName + '\'' +
                ", adres: '" + address + '\'' +
                ", kod pocztowy: '" + postcode + '\'' +
                ", miejscowość: '" + city + '\'' +
                ", email: '" + email + '\'' +
                ", numer telefonu: '" + phoneNumber + '\'' +
                ", data pierwszej wizyty: '" + firstVisitDate + '\'' +
                ", osoba obsługująca: '" + therapistLastName + '\'' +
                ", nazwa usługi: '" + serviceName + '\'' +
                ", id osoby prowadzącej: " + therapist +
                ", nazwa usługi: " + service +
                ", rozpoczęcie usługi: " + serviceBegin +
                ", zakończenie usługi: " + serviceExpire +
                '}';
    }

}

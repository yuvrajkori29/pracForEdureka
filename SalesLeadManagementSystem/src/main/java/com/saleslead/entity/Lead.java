package com.saleslead.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sales_lead")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "contactPerson", nullable = false)
    private String contactPerson;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToMany(mappedBy = "leads")
    private Set<Salesperson> salespersons;

    // Constructors, getters, and setters
    public Lead() {}

    public Lead(String companyName, String contactPerson, Status status) {
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Salesperson> getSalespersons() {
        return salespersons;
    }

    public void setSalespersons(Set<Salesperson> salespersons) {
        this.salespersons = salespersons;
    }
}

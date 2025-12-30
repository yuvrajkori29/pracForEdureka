package com.saleslead.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "salesperson")
public class Salesperson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "region")
    private String region;

    @ManyToMany
    @JoinTable(
        name = "salesperson_leads", 
        joinColumns = @JoinColumn(name = "salesperson_id"), 
        inverseJoinColumns = @JoinColumn(name = "lead_id")
    )
    private Set<Lead> leads;

    // Constructors, getters, and setters
    public Salesperson() {}

    public Salesperson(String name, String email, String region) {
        this.name = name;
        this.email = email;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Lead> getLeads() {
        return leads;
    }

    public void setLeads(Set<Lead> leads) {
        this.leads = leads;
    }
}

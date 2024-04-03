/*
 * You can use the following import statements
 *
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import javax.persistence.*;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.findmyproject.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "researcher")
public class Researcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int researcherId;
    @Column(name = "name")
    String researcherName;
    @Column(name = "specialization")
    String specialization;
    @ManyToMany
    @JoinTable(name = "researcher_project", joinColumns = @JoinColumn(name = "projectid"), inverseJoinColumns = @JoinColumn(name = "researcherid"))
    @JsonIgnoreProperties("researchers")
    List<Project> projects;

    public Researcher() {
    }

    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
package com.example.nejidhiaexamentp;

public class Personnel {
    private String matricule;
    private String nom;
    private String prenom;
    private String service;

    public Personnel(String matricule, String nom, String prenom, String service) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.service = service;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}

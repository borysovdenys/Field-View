package borysov.entity;

import java.sql.Date;

public class Stuff {
    private int id;
    private int idOfUser;
    private String name;
    private String linkToMaterial;
    private Date dateOfCreation;
    private String coordinates;
    private String prescription;

    public Stuff() {
    }

    public Stuff(int id, int idOfUser, String name, String linkToMaterial, Date dateOfCreation, String coordinates, String prescription) {
        this.id = id;
        this.idOfUser = idOfUser;
        this.name = name;
        this.linkToMaterial = linkToMaterial;
        this.dateOfCreation = dateOfCreation;
        this.coordinates = coordinates;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfUser() {
        return idOfUser;
    }

    public void setIdOfUser(int idOfUser) {
        this.idOfUser = idOfUser;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkToMaterial() {
        return linkToMaterial;
    }

    public void setLinkToMaterial(String linkToMaterial) {
        this.linkToMaterial = linkToMaterial;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "id=" + id +
                ", idOfUser=" + idOfUser +
                ", name='" + name + '\'' +
                ", linkToMaterial='" + linkToMaterial + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", coordinates='" + coordinates + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}

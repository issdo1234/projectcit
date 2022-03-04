package com.example.study;

public class Annonce {
    private String firstName, lastName, email,typeOffre,ville,titreAnnonce,dateAnnonce ;
    private int imageId,prix,id,userId,tel;

    public Annonce(String firstName, String lastName, String email, String typeOffre,
                   String ville, String titreAnnonce,
                   int imageId, int prix, int id, int userId,
                   int tel, String dateAnnonce) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.typeOffre = typeOffre;
        this.ville = ville;
        this.titreAnnonce = titreAnnonce;
        this.imageId = imageId;
        this.prix = prix;
        this.id = id;
        this.userId = userId;
        this.tel = tel;
        this.dateAnnonce = dateAnnonce;
    }

    public Annonce(String firstName, String lastName, int imageId, int prix, String dateAnnonce) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageId = imageId;
        this.prix = prix;
        this.dateAnnonce = dateAnnonce;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOffre() {
        return typeOffre;
    }

    public void setTypeOffre(String typeOffre) {
        this.typeOffre = typeOffre;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    public void setTitreAnnonce(String titreAnnonce) {
        this.titreAnnonce = titreAnnonce;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(String dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }
}








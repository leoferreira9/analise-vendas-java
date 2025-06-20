package com.cadastro.model;

public class Cliente extends Pessoa{

    private int id;
    private String email;

    public Cliente(String nome, String cpf, int id, String email){
        super(nome, cpf);
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.rits.POJO;

/**
 *
 * @author root
 */
public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String mail;
    private String fone;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, String mail, String fone) {
        this.id = id;
        this.nome = nome;
        this.mail = mail;
        this.fone = fone;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }        

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}

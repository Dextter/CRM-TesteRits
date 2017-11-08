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
public class UsuarioPOJO {

    private String nome;
    private String mail;
    private String fone;

    public UsuarioPOJO() {
    }

    public UsuarioPOJO(String nome, String mail, String fone) {
        this.nome = nome;
        this.mail = mail;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

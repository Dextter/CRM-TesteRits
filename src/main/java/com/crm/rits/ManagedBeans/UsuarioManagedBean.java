package com.crm.rits.ManagedBeans;


import com.crm.rits.DAO.UsuarioDAO;
import com.crm.rits.POJO.Usuario;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

@ManagedBean (name = "userBean")
public class UsuarioManagedBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    private UsuarioDAO uDao;
    
    
    public UsuarioManagedBean() {
        this.usuario = new Usuario();
        this.uDao = new UsuarioDAO();
    }    
        
    //Logar no sistema
    public String logar(){        
        this.usuario = uDao.select(this.usuario); // jogar o usuario na varivel de sessão
        if(this.usuario != null){ //verifica se houve algum retorno da pesquisa no banco
            return "home.xhtml?faces-redirect=true";
        } else if(this.usuario == null){
	    FacesMessage message = new FacesMessage("Login inválido");    
	    message.setSeverity(FacesMessage.SEVERITY_ERROR);    
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login inválido", null)); 
	}else{
	    FacesMessage message = new FacesMessage("Senha inválido");    
	    message.setSeverity(FacesMessage.SEVERITY_ERROR);    
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha inválida", null));
	}
        this.usuario = new Usuario();
	return "login.xhtml";
    }
    
    
    //Cadastrar um Novo usuário
    public String cadastrar(){
        uDao.insert(usuario);
        return "login.xhtml";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
}
}

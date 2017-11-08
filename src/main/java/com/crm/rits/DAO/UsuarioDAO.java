/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.rits.DAO;

import com.crm.rits.ConnectionFactory.PGConnection;
import com.crm.rits.POJO.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class UsuarioDAO extends PGConnection {

    ArrayList<Usuario> usuarios;

    public UsuarioDAO() {
        super();
    }

    /**
     * Select para selecionar um usuario pelo username e password. Usado para
     * login
     *
     * @return Usuario
     */
    public Usuario select(Usuario user) {
        Usuario usuario = null;
        CriarConexao();

        try {

            preparacao = conexao.prepareStatement("SELECT * FROM usuario WHERE nome=? AND senha=?");
            preparacao.setString(1, user.getNome());
            preparacao.setString(2, user.getSenha());
            resultado = preparacao.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("senha"),
                        resultado.getString("mail"), resultado.getString("fone"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return usuario;
    }

    /**
     * Select para selecionar um usuario pelo Id
     *
     * @return Usuario
     */
    public Usuario select(int id) {
        Usuario usuario = null;
        CriarConexao();

        try {

            preparacao = conexao.prepareStatement("SELECT * FROM usuario WHERE id=?");
            preparacao.setInt(1, id);
            resultado = preparacao.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("senha"),
                        resultado.getString("mail"), resultado.getString("fone"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return usuario;
    }

    /**
     * Select que retorna a lista de usuarios
     *
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> select() {
        usuarios = new ArrayList<Usuario>();
        CriarConexao();

        try {
            resultado = consulta.executeQuery("SELECT * FROM usuario");

            while (resultado.next()) {
                usuarios.add(new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("senha"),
                        resultado.getString("mail"), resultado.getString("fone")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return usuarios;
    }

    /**
     * Inserir um usuário no banco
     *
     * @param user
     */
    public void insert(Usuario user) {
        CriarConexao();

        System.out.println(user.getNome());
        System.out.println(user.getSenha());
        System.out.println(user.getMail());
        System.out.println(user.getFone());

        try {
            preparacao = conexao.prepareStatement("INSERT INTO usuario(nome, senha, mail, fone) VALUES(?,?,?,?)");
            preparacao.setString(1, user.getNome());
            preparacao.setString(2, user.getSenha());
            preparacao.setString(3, user.getMail());
            preparacao.setString(4, user.getFone());
            preparacao.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
}

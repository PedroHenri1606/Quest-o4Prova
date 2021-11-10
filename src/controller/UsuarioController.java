package controller;

import dao.UsuarioDAO;
import model.UsuarioModel;

import java.util.List;

public class UsuarioController {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void adicionar(UsuarioModel tmp1){ usuarioDAO.adicionar(tmp1); }
    public void adicionarMensagem(UsuarioModel tmp1){ usuarioDAO.adicionarMensagem(tmp1);}
    public List<UsuarioModel> listar(){  return usuarioDAO.listar();}
    public List<UsuarioModel> listarMensagens(){ return usuarioDAO.listarMensagens();}
    public void carregar(){ usuarioDAO.carregar();}
    public void carregarMensagens(){ usuarioDAO.carregarMensagens();}
    public boolean login(String tmp1){ return usuarioDAO.login(tmp1);}
    public String getNomeUsuario(){ return usuarioDAO.getNomeUsuario();}
    public String getIdUsuario(){ return usuarioDAO.getIdUsuario();}

    }


package dao;

import model.UsuarioModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UsuarioDAO {
    static List<UsuarioModel> usuarios = new ArrayList<>();
    static List<UsuarioModel> mensagens = new ArrayList<>();
    static int usuarioAtual; //talvez use futuramente

    public void salvar(){
        try{
            BufferedWriter salvar = new BufferedWriter(new FileWriter("usuarios.txt"));
            for (int i = 0; i < usuarios.size(); i++){
                salvar.write(usuarios.get(i).toString());
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e){
            System.out.println(" --- ERRO AO ABRIR ARQUIVO --- ");
        }
    }

    public void adicionar(UsuarioModel usuarioModel){
        usuarios.add(usuarioModel);
        this.salvar();
    }

    public void adicionarMensagem(UsuarioModel usuarioModel){
        mensagens.add(usuarioModel);
        this.salvarMensagens();
    }

    public List<UsuarioModel> listar(){ return usuarios;}

    public List<UsuarioModel> listarMensagens(){ return mensagens;}

    public boolean login(String tmp1){
        for (int i = 0; i < usuarios.size(); i++){
            if (tmp1.equals(usuarios.get(i).getId())){
                System.out.println(" --- USUARIO SELECIONADO COM SUCESSO --- ");
                usuarioAtual = i;
                return true;
            }
        }
        return false;
    }

    public void carregar(){
        try{
            BufferedReader carregar = new BufferedReader(new FileReader("usuarios.txt"));
            while(true){
                String linha = carregar.readLine();
                if (linha == null){
                    break;
                } else {
                    StringTokenizer separador = new StringTokenizer(linha,";");
                    UsuarioModel usuario = new UsuarioModel();
                    usuario.setId(separador.nextToken());
                    usuario.setNome(separador.nextToken());
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void carregarMensagens(){
        try{
            BufferedReader carregar = new BufferedReader(new FileReader("log.txt"));
            while(true){
                String linha = carregar.readLine();
                if (linha == null){
                    break;
                } else {
                    StringTokenizer separador = new StringTokenizer(linha,";");
                    UsuarioModel usuario = new UsuarioModel();
                    usuario.setId(separador.nextToken());
                    usuario.setNome(separador.nextToken());
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void salvarMensagens(){
        try{
            BufferedWriter salvar = new BufferedWriter(new FileWriter("log.txt"));
            for (int i = 0; i < usuarios.size(); i++){
                salvar.write(usuarios.get(i).toString());
                salvar.newLine();
            }
            salvar.close();
        } catch (IOException e){
            System.out.println(" --- ERRO AO ABRIR ARQUIVO --- ");
        }
    }


    public String getNomeUsuario(){
        return usuarios.get(usuarioAtual).getNome();
    }

    public String getIdUsuario(){
        return usuarios.get(usuarioAtual).getId();
    }


}

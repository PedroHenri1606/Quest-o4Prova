package view;

import controller.UsuarioController;
import model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioView {

    UsuarioController usuarioController = new UsuarioController();

    public void menu() {

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("==================================");
            System.out.println("   [1] - Cadastrar Cliente");
            System.out.println("   [2] - Listar Clientes");
            System.out.println("   [3] - Selecionar Cliente");
            System.out.println("==================================");

            opcao = scan.nextInt();

            switch (opcao) {

                case 1:
                    this.cadastrarUsuario();
                    break;
                case 2:
                    this.listarUsuarios();
                    break;
                case 3:
                    this.loginUsuario();
                    break;
                default:

                    break;
            }

        } while (true);
    }

    public void cadastrarUsuario() {
        Scanner scan = new Scanner(System.in);
        UsuarioModel usuarioModel = new UsuarioModel();

        System.out.println("==================================");
        System.out.print  (" Nome: ");
        usuarioModel.setNome(scan.nextLine());
        System.out.print  (" Id: ");
        usuarioModel.setId(scan.nextLine());
        System.out.println("==================================");
        usuarioController.adicionar(usuarioModel);
    }

    public void listarUsuarios() {
        System.out.println("==================================");
        List<UsuarioModel> usuariosCadastrados = usuarioController.listar();
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            System.out.println(usuariosCadastrados.get(i).getId() + " | " + usuariosCadastrados.get(i).getNome());
        }
        System.out.println("==================================");
    }

    public void loginUsuario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("==================================");
        this.listarUsuarios();
        System.out.print  (" Selecione o usuario por ID: ");
        String id = scan.nextLine();

        if (usuarioController.login(id)) {
            this.menuUsuario();
        } else {
            System.out.println(" --- ID incompativel, tente novamente ---");
        }
    }

    public void menuUsuario() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("==================================");
            System.out.println(" Bem Vindo: " + usuarioController.getNomeUsuario());
            System.out.println("");
            System.out.println("  [1] - Cadastrar mensagem");
            System.out.println("  [2] - Listar Mensagens");
            System.out.println("  [0] - Voltar");
            System.out.println("==================================");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrarMensagem();
                    break;
                case 2:
                    this.listarMensagens();
                    break;
                default:
                    break;
            }

        } while (opcao != 0);
    }

    public void cadastrarMensagem(){
        UsuarioModel usuarioModel = new UsuarioModel();
        Scanner scan = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println(" Mensagem: "); usuarioModel.setMensagem(scan.nextLine());
        System.out.println("==================================");
        System.out.println(" Id da Mensagem: "); usuarioModel.setIdMensagem(scan.nextLine());
        System.out.println("==================================");
        usuarioController.adicionarMensagem(usuarioModel);
    }

    public void listarMensagens(){
        System.out.println("==================================");
        List<UsuarioModel> mensagensCadastradas = usuarioController.listarMensagens();
        for (int i = 0; i < mensagensCadastradas.size(); i++){
            System.out.println( mensagensCadastradas.get(i).getMensagem() + " | " + mensagensCadastradas.get(i).getIdMensagem());
        }
        System.out.println("==================================");
    }
}
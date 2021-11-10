import controller.UsuarioController;
import view.UsuarioView;

public class Main {
    public static void main(String[] args) {

        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController();

        usuarioController.carregar();
        usuarioController.carregarMensagens();

        usuarioView.menu();

    }
}

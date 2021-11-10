package model;

public class UsuarioModel {
    //Pra funcionar tem que verificar o numero do ID do usuario que vc quer enviar

    private String nome;
    private String id;
    private String mensagem;
    private String idMensagem;

    public UsuarioModel() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(String idMensagem) {
        this.idMensagem = idMensagem;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getNome();
    }
}

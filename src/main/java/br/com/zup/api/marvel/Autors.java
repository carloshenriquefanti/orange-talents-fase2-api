package br.com.zup.api.marvel;

import java.util.List;

public class Autors {
    private String autores;

    public Autors() {
    }

    public Autors(String autores) {
        this.autores = autores;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

     public static class Autor {
        private String nome;
        private Integer codigo;

        public Autor() {
        }

        public Autor(String nome, Integer codigo) {
            this.nome = nome;
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }
    }
}

package com.ciskow.gerenciadordecursos;

public class Curso {
    private int id;
    private String nome;
    private int duracaoHoras;
    private String dataCriacao;

    public Curso( int id, String nome, int duracaoHoras, String dataCriacao ) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.dataCriacao = dataCriacao;
    }


    public Curso() { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getDuracaoHoras() { return duracaoHoras; }

    public void setDuracaoHoras(int duracaoHoras) { this.duracaoHoras = duracaoHoras; }


    @Override
    public String toString() {
        return "Nome = " + nome + ", Duração(Horas) = " + duracaoHoras  + " Data de Criação: " + dataCriacao + ", ID = " + id + ".";
    }
}

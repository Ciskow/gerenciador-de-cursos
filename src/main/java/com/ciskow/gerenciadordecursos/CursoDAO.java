package com.ciskow.gerenciadordecursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> list() {

        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM curso";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id" );
                String nome = rs.getString("nome" );
                int duracaoHoras = rs.getInt("duracao_horas");
                String dataCriacao = rs.getString("data_criacao");

                cursos.add(new Curso(
                        id,
                        nome,
                        duracaoHoras,
                        dataCriacao
                ));
            }


        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        return cursos;
    }

    public Curso getById(int id) {

        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracao_horas"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        return curso;
    }

    public void create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?,?);";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA! Foi adicionada " + rowsAffected + " linha(s).");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha(s).");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
        }
    }

    public void update(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDADE! Foi atualizada: " + rowsAffected + " linha(s).");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }

    public void criacao(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getId());

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String dataCriacao = rs.getString("data_criacao");
                String nome = rs.getString("nome");
                System.out.println("Curso '" + nome + "' foi criado em: "+ dataCriacao);
            }


        } catch (SQLException e) {
            System.out.println("Data de Criação FALHOU!");
            e.printStackTrace();
        }

    }
}

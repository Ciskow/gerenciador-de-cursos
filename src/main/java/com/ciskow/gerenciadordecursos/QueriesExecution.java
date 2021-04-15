package com.ciskow.gerenciadordecursos;

import java.util.List;
import java.util.Scanner;

public class QueriesExecution {
    public static void main(String[] args) {
        String opcao;
        Curso curso = new Curso();
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.list();
        Scanner sc = new Scanner(System.in);

        System.out.println("Gerenciador de Cursos");
        System.out.println("O que você quer fazer? Digite: criar, consultar, deletar, atualizar, listar ou data");
        opcao = sc.nextLine();

        switch (opcao) {
            case "criar" -> {
                System.out.println("Digite o nome do curso:");
                curso.setNome(sc.nextLine());
                System.out.println("Digite a duração de horas do curso:");
                curso.setDuracaoHoras(Integer.parseInt(sc.nextLine()));
                cursoDAO.create(curso);
                System.out.println("Curso criado com SUCESSO!");
            }
            case "consultar" -> {
                System.out.println("Digite o ID do curso que quer consultar:");
                curso.setId(Integer.parseInt(sc.nextLine()));
                System.out.println(cursoDAO.getById(curso.getId()));
            }
            case "deletar" -> {
                System.out.println("Digite o ID do curso que quer deletar:");
                curso = cursoDAO.getById(Integer.parseInt(sc.nextLine()));
                cursoDAO.delete(curso.getId());
                System.out.println("Curso '" + curso.getNome() + "' deletado com SUCESSO!");
            }

            case "atualizar" -> {
                System.out.println("Digite o ID do curso que quer atualizar:");
                curso = cursoDAO.getById(Integer.parseInt(sc.nextLine()));
                System.out.println("Digite o nome do curso:");
                curso.setNome(sc.nextLine());
                System.out.println("Digite a duração em horas do curso:");
                curso.setDuracaoHoras(Integer.parseInt(sc.nextLine()));
                cursoDAO.update(curso);
            }
            case "listar" -> {
                System.out.println("Lista de cursos no banco de dados:");
                cursos.forEach(System.out::println);
            }
            case "data" -> {
                System.out.println("Digite o ID do curso que quer saber a data de criação:");
                curso = cursoDAO.getById(Integer.parseInt(sc.nextLine()));
                cursoDAO.criacao(curso);
            }
            default -> System.out.println("Nenhuma opção correta foi digitada.");
        }
    }
}

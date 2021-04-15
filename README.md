# Projeto
Um simples gerenciador de curso usando MySQL ou PostgreSQL, JDBC e Maven.

### Pré-requisitos
- Java Development Kit (JDK) – 14 ou superior
- IntelliJ IDEA (É recomendável seguir com essa IDE, porém, pode ser selecionada outra)
- MySQL ou PostgreSQL (É recomendável Docker para uma instalação mais fácil)

### Instalação
Com os pré requisitos instalados, basta baixar esse projeto no seu IDE (através do comando `git clone`).

Com o banco de dados da sua escolha já rodando, usar o arquivo [project_final_estrutura.sql](https://github.com/Ciskow/gerenciador-de-cursos/blob/master/project_final_estrutura.sql) para criar a estrutura do banco de dados e tabela, e [project_final_cursos.sql](https://github.com/Ciskow/gerenciador-de-cursos/blob/master/project_final_cursos.sql) para já colocar alguns cursos se quiser.

Ajustar usuário e senha do seu banco de dados no arquivo [application.properties](https://github.com/Ciskow/gerenciador-de-cursos/blob/master/src/main/resources/application.properties).

## Executar
Basta rodar a função `main` no seguinte arquivo:
- [QueriesExecution.java](https://github.com/Ciskow/gerenciador-de-cursos/blob/master/src/main/java/com/ciskow/gerenciadordecursos/QueriesExecution.java)

# Workshop JavaFX JDBC

Projeto didático em Java que demonstra uma aplicação desktop JavaFX conectada a um banco MySQL via JDBC. A aplicação usa telas FXML, padrão DAO e entidades simples para cadastro/consulta de departamentos e vendedores.

## Funcionalidades

- Janela principal JavaFX com menus de cadastro e ajuda.
- Listagem de departamentos em uma `TableView`.
- Diálogo FXML inicial para cadastro de departamento.
- Camada DAO JDBC para operações CRUD de `Department` e `Seller`.
- Fábrica de DAOs e serviço de departamento para separar interface gráfica, regra de acesso e persistência.

## Estrutura do projeto

```text
src/
  application/      Classe principal JavaFX
  db/               Conexão JDBC e exceções de banco
  gui/              Controllers, telas FXML e utilitários JavaFX
  model/dao/        Interfaces DAO, fábrica e implementações JDBC
  model/entities/   Entidades Department e Seller
  model/services/   Serviços usados pela interface gráfica
```

## Requisitos

- JDK 21 ou compatível com JavaFX usado pelo projeto.
- JavaFX SDK configurado no classpath/module-path da IDE ou da linha de comando.
- MySQL em execução.
- Driver JDBC do MySQL disponível no classpath.

## Configuração do banco

A conexão é lida do arquivo `db.properties` na raiz do projeto:

```properties
user=root
password=1234
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

A aplicação espera um banco `coursejdbc` com tabelas compatíveis com as entidades:

- `department`: campos `Id` e `Name`.
- `seller`: campos `Id`, `Name`, `Email`, `BirthDate`, `BaseSalary` e `DepartmentId`.

Ajuste usuário, senha e URL conforme o ambiente local antes de executar.

## Como executar

1. Abra o projeto em uma IDE com suporte a JavaFX, como IntelliJ IDEA, Eclipse ou NetBeans.
2. Configure o JDK, o JavaFX SDK e o driver MySQL Connector/J no projeto.
3. Garanta que o MySQL esteja ativo e que o arquivo `db.properties` aponte para o banco correto.
4. Execute a classe `application.Main`.

## Observações

Este repositório não possui um arquivo de build Maven ou Gradle. Por isso, a execução depende da configuração manual de dependências na IDE ou na linha de comando.

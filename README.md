<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="120" height="205"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-plain-wordmark.svg" width="120" height="205"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width="120" height="205" />

# Projeto ER Departamento Pessoal

>  Construindo uma API REST com banco de dados usando Java e Spring Boot para o projeto final do módulo.

### Tecnologias

- Lógica de programação (Java)
- Programação orientada a objetos (Java)
- Banco de Dados (Postegree)
- Ferramentas
  - Spring Tool Suite (STS)
  - Insomnia

## Regras

O aluno deverá construir uma aplicação Java, usando os conceitos apresentados em sala usando as tecnologias do ecossistema Spring.

Pontos que serão OBRIGATÓRIOS para a entrega do trabalho.

- Diagrama de classes da solução;
- Arquivo Insomnia com exemplos de todas as chamadas de API’s da aplicação;
- Documentação das API’s no Swagger
- Software rodando corretamente;
- Lista de Requisitos funcionais/Requisitos não funcionais/Regras de negócio;
- Cobertura de código de no mínimo 50%;
- Persistência de dados em Postgres;
- Uso do Flyway para gerenciamento das Migrations;
- Uso do Maven para gerenciamento das dependências e estrutura do projeto
- PLUS: Deploy no RailWay, conforme tutorial: [***\*Como configurar o springboot e postgresSQL no Railway\****](https://www.notion.so/Como-configurar-o-springboot-e-postgresSQL-no-Railway-301bdf4514fe49eb88fb082298aa8a2a?pvs=21)

Não estão elencados acima porém também são pré requisitos:

- Qualidade de código
- Normalização de banco de dados



# Tema

------

O tema do trabalho será definido pelo aluno, porém assim como a liberdade criativa na definição dos temas o aluno é responsável é responsável por aquilo que planejou (te tornas eternamente responsável por aquilo que cativas).

Neste caso, estamos falando de um início de projeto de Departamento pessoal, com as entidades Usuário e Departamento.



### Visão geral do sistema

Vamos construir um pequeno sistema (API REST) de usuários e departamentos, com os seguintes casos de uso:

- Buscar todos usuários
- Buscar um usuário pelo seu id
- Inserir um novo usuário

![Image](https://raw.githubusercontent.com/devsuperior/java-web-spring-2022/main/img/dominio.png "Modelo conceitual")

### Desenvolvimento moderno: relacional -> objeto -> json

![Image](https://raw.githubusercontent.com/devsuperior/java-web-spring-2022/main/img/objetos.png "Objetos")

### Passos do Projeto

- Criar o projeto
- Diagrama de classes da solução
- Implementar o modelo de domínio
- Uso do Maven para gerenciamento das dependências 
- Mapeamento objeto-relacional com JPA
- Configurar o banco de dados H2
- Criar os endpoints da API REST Usuário e Departamento
  - Usuário e Departamento: GET (BUSCAR)
  - Usuário e Departamento: GET BY ID (BUSCAR por ID)
  - Usuário e Departamento: GET (BUSCAR)
  - Usuário e Departamento: POST (INSERIR)
  - Usuário e Departamento: DELETE (DELETAR)
  - Usuário e Departamento: UPDATE (ATUALIZAR)

- Testes Unitários com no mínimo 50% [Não realizado]
- Documentação das APIs no Swagger
- Persistência de dados em Postgres [Por enquanto feito em h2]
- Uso do Flyway para gerenciamento das Migrations [Não realizado]
- PLUS: Deploy no RailWay, conforme tutorial. [Não realizado]

#### Configurações do banco de dados

```
# Dados de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Configuração do cliente web do banco H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração para mostrar o SQL no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

#### Script SQL

```sql
INSERT INTO tb_department(name) VALUES ('Gestão');
INSERT INTO tb_department(name) VALUES ('Informática');

INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');
```
#### Collection Insomnia

https://github.com/edsonsreis/DepPersonal-Project/blob/main/userdept/Insomnia_2023-10-07.json

### **Swagger**

http://localhost:8080/swagger-ui/index.html


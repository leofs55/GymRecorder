# 🏋️‍♂️ Gym Recorder API

*Sua vida fitness organizada, um treino de cada vez.*

[![Status do Projeto](https://img.shields.io/badge/status-em--desenvolvimento-yellowgreen)]()

---

## 📝 Descrição do Projeto

Esta é uma API RESTful para gerenciamento de treinos de academia. A API permite o cadastro e gerenciamento de usuários, treinos e exercícios, facilitando o acompanhamento de rotinas de treinamento de forma estruturada.

---

## 🚀 Status do Projeto

O projeto encontra-se **Em Desenvolvimento**.

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

*   **Linguagem:** `Java 17`
*   **Framework Principal:** `Spring Boot 3.5.3`
*   **Persistência de Dados:**
    *   `Spring Data JPA` com `Hibernate`
    *   `Spring Data MongoDB`
    *   `PostgreSQL` (banco de dados relacional principal)
    *   `Flyway`: Para versionamento do schema do banco de dados PostgreSQL.
*   **Build Tool:** `Maven`
*   **Outras Dependências:**
    *   `Lombok`: Para reduzir código boilerplate.
    *   `Spring Web`: Para criação dos endpoints REST.
    *   `Spring Validation`: Para validação dos dados de entrada.

---

## ✨ Funcionalidades

*   👤 **Gerenciamento de Usuários:** CRUD completo para criação, busca, atualização e exclusão de usuários.
*   💪 **Gerenciamento de Treinos:** CRUD completo para criação, busca, atualização e exclusão de rotinas de treino associadas a um usuário.
*   🤸 **Gerenciamento de Exercícios:** CRUD completo para criação, busca, atualização e exclusão de exercícios.

---

## 🔧 Pré-requisitos

Para executar o projeto localmente, você precisará de:

*   `Java JDK 17` ou superior
*   `Maven 3.8` ou superior
*   `PostgreSQL` e `MongoDB` em execução local ou via Docker.
*   Um cliente de API, como `Postman` ou `Insomnia`.

---

## ⚙️ Como Rodar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/leofs55/GymRecorder.git
    ```

2.  **Navegue até o diretório raiz:**
    ```bash
    cd GymRecorder
    ```
3.  **Configure o Banco de Dados:**
    Certifique-se de que suas instâncias do PostgreSQL e MongoDB estejam ativas e configure as credenciais de acesso no arquivo `src/main/resources/application.yml`.

4.  **Instale as dependências e compile:**
    ```bash
    mvn clean install
    ```

5.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.

---

## 🔌 Endpoints da API

Todos os endpoints estão sob o prefixo `/api/v1`.

### Usuários (`/user`)

*   `POST /user/create`: Cria um novo usuário.
*   `GET /user/find-by/{id}`: Busca um usuário pelo seu ID.
*   `PATCH /user/update/{id}`: Atualiza os dados de um usuário.
*   `DELETE /user/detele/{id}`: Exclui um usuário.

### Treinos (`/training`)

*   `POST /training/create`: Cria um novo treino.
*   `GET /training/find-by/{id}`: Busca um treino pelo seu ID.
*   `GET /training/find-by/{userId}`: Lista todos os treinos de um usuário específico.
*   `PATCH /training/update/{id}`: Atualiza um treino existente.
*   `DELETE /training/detele/{id}`: Exclui um treino.

### Exercícios (`/exercise`)

*   `POST /exercise/create`: Cria um novo exercício.
*   `GET /exercise/find-by/{id}`: Busca um exercício pelo seu ID.
*   `GET /exercise/find-by/{userId}`: Lista todos os exercícios de um usuário específico.
*   `PATCH /exercise/update/{id}`: Atualiza um exercício.
*   `DELETE /exercise/detele/{id}`: Exclui um exercício.

---

## 🤝 Como Contribuir

Contribuições são bem-vindas! Se você quiser melhorar este projeto, siga os passos:

1.  Faça um **Fork** do projeto.
2.  Crie uma **Branch** para sua Feature (`git checkout -b feature/sua-feature`).
3.  Faça o **Commit** de suas alterações (`git commit -m 'feat: Adiciona nova feature'`).
4.  Faça o **Push** para a Branch (`git push origin feature/sua-feature`).
5.  Abra um **Pull Request**.

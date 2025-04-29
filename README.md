# Estudos sobre Aplicações

Bem-vindo ao repositório de estudos sobre aplicações! Este projeto demonstra a construção de uma API RESTful utilizando **Spring Boot** e **Maven**, com exemplos simples para controle de produtos.

## Estrutura do Repositório

- **.mvn/wrapper/**: Arquivos do Maven Wrapper para facilitar a execução do projeto.
- **src/**: Código-fonte da aplicação.
  - **ControllerPing.java**: Endpoint para teste de conectividade (`/ping`).
  - **ControllerProduto.java**: CRUD de produtos na memória (`/produtos`).
  - **Produto.java**: Classe modelo representando um produto.
  - **StudyApixApplication.java**: Classe principal da aplicação Spring Boot.
- **application.properties**: Configurações da aplicação.
- **pom.xml**: Arquivo de configuração do Maven.

## Como Executar

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/GN0Ber/study-apix.git
   ```

2. **Navegue até a pasta do projeto:**

   ```bash
   cd study-apix
   ```

3. **Execute o projeto com Maven:**

   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API:**

   - Teste de conectividade: [http://localhost:8080/ping](http://localhost:8080/ping)
   - Endpoints de Produto: [http://localhost:8080/produtos](http://localhost:8080/produtos)
   - Documentação Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Banco de Dados com Docker

Para utilizar um banco de dados MySQL localmente, você pode subir um container Docker:

1. **Abra o Docker Desktop** (certifique-se de que está em execução).
2. **Cole o comando abaixo no Git Bash usando `Ctrl + Shift + Insert`:**

   ```bash
   docker run -d \
       --name mysql \
       --rm \
       -e MYSQL_ROOT_PASSWORD=root_pwd \
       -e MYSQL_USER=new_user \
       -e MYSQL_PASSWORD=my_pwd \
       -p 3306:3306 \
       mysql
   ```

Esse comando irá iniciar um container MySQL, expondo a porta padrão `3306`, criando o usuário `new_user` com a senha `my_pwd`, e a senha de root `root_pwd`.

## Dependências

A aplicação depende das seguintes bibliotecas principais (listadas no `pom.xml`):

- Spring Boot Starter Web
- Spring Boot DevTools
- Swagger (Springfox)

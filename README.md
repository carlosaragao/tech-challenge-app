# TechFood - Sistema de Autoatendimento para Restaurante FastFood

## Índice

- [Visão Geral](#visão-geral)
- [Requisitos](#requisitos)
- [Domain-Driven Development (DDD)](#domain-driven-development-ddd)
- [Arquitetura](#arquitetura)
- [Funcionalidades Principais](#funcionalidades-principais)
- [Principais Tecnologias Utilizadas](#principais-tecnologias-utilizadas)
- [APIs Disponíveis](#apis-disponíveis)
- [Como Executar](#como-executar)
- [Acessando Swagger](#acessando-swagger)
- [Banco de dados](#banco-de-dados)
- [Postman Collection](#postman-collection)

### Visão Geral

Este é um projeto do curso de Pós-graduação em Arquitetura de Software da FIAP compreende uma solução possível para um sistema de autoatendimento de restaurante do tipo fast-food, com quiosques ou terminais de autoatendimento, com o objetivo de otimizar o processo de pedidos, pagamento, preparação e entrega de comida..

Autores membros do Grupo:

- Geraldo Moratto Junior - RM356285
- Pedro Cantarelli - RM355410
- Vinicius Lopes - RM354901

### Requisitos

Em geral os clientes e administradores usarão o sistema, que dependerá de um serviço de pagamento externo.

No atual momento, os requisitos do sistema são:

- Gerenciamento de pedidos, com acompanhamento e pagamento.
- Gerenciamento de clientes
- Gerenciamento de produtos e categorias

### Domain-Driven Development (DDD)

A abordagem utilizada para o desenvolvimento foi a DDD, com as seguintes saídas documentadas:

- Glossário ubíquo (Adicionar imagem ou link da imagem)
- Event storming (Adicionar imagem ou link da imagem)
- Storytelling (Adicionar imagem ou link da imagem)
- Mapa de Contexto (Adicionar imagem ou link da imagem)

### Arquitetura

O sistema expõe RESTful APIs para aplicações front-end, como terminais de autoatendimento para clientes e interfaces para administradores. Tem como dependência um provedor externo de pagamento, o MercadoPago.

Arquitetura Hexagonal (Ports and Adapters) e Clean Architecture foram adotadas no projeto.

### Funcionalidades Principais

- **Pedido Personalizado:** Os clientes podem criar pedidos personalizados, escolhendo entre uma variedade de itens, como lanches, acompanhamentos, bebidas e sobremesas.
- **Pagamento Integrado:** Integração com o Mercado Pago, permitindo que os clientes efetuem o pagamento de seus pedidos através de um QRCode.
- **Acompanhamento de Pedido:** Os clientes podem acompanhar o status de seus pedidos, desde o momento em que são recebidos até estarem prontos para retirada.
- **Gerenciamento Administrativo:** Os administradores têm acesso a um painel de controle para gerenciar clientes, produtos, categorias e pedidos em andamento.

### Principais Tecnologias Utilizadas

- **Kotlin**
- **Java 17**
- **Spring-Boot 3.2.5**
- **PostgreSQL**
- **Docker**
- **Swagger**
- **Gradle 8**

### APIs Disponíveis

O TechFood expõe as seguintes APIs para integração:

- **Cadastro do Cliente:** API para cadastrar novos clientes no sistema.
- **Identificação do Cliente via CPF:** API para identificar clientes existentes utilizando o CPF.
- **Gerenciamento de Produtos:** APIs para criar, editar e remover produtos do menu, além de buscar produtos por categoria.
- **Checkout:** API para o checkout de pedidos, enviando os produtos escolhidos para a fila de preparação.
- **Acompanhamento de Pedidos:** API para listar os pedidos em andamento e o tempo de espera de cada pedido.

### Como Executar

#### Em ambiente local

Para executar o sistema, siga as instruções abaixo:

1. Certifique-se de ter o Docker e o Docker Compose instalados em seu computador.
2. Clone o repositório, no terminal executando o comando:
```
$ git clone https://github.com/FIAP-7SOAT/tech-challenge-app
```
3. Entre na pasta do projeto:
```
$ cd tech-challenge-app
```
4. Build o projeto rodando o comando:
```shell
./gradlew clean build
```
5. Subindo o ambiente com alguns dados no banco, para facilitar o processo de testes de código.
   :
```shell
docker-compose -f docker-compose.yml up -d
```

### Acessando Swagger

Acesse a documentação da API através do Swagger para começar a interagir com o sistema.
Para acessar o Swagger utilize a url [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

### Banco de dados

Para vizualizar o Banco de Dados através, recomendamos que baixe o DBeaver ou outro Gerenciador de banco de dados para PostgreSQL de sua preferência:

- Criar nova conexão
- Host: localhost
- Port: 5432
- Database: techfood
- Username: postgres
- Password: postgres

### Postman Collection

Baixar o Postman ou o API Client de sua preferência e importar a collection:

[API Client Collection](src/main/resources/collection/fiap_techfood_postman_collection.json).

# DSCommerce

# Sobre o projeto

Projeto que Visa simular um pequeno comércio e algumas de suas funcionalidades, seguindo boas práticas, tratando exceções, implmentando a segurança no projeto e mais algumas Features

## Modelo conceitual
![Modelo Conceitual](https://github.com/LucasIbiapino7/assets/blob/main/imgs/DSCommerce.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Postgres
# Competências
- Desenvolvimento em Camadas
- Tratamento de Exceções, Validação de dados e Reapostas customizadas
- Implementação da Segurança com Spring Secutiry e Token JWT
- Consultas personalizadas
- Controle de acesso
# Features
- Busca de Produto por Id (public)
- Busca Paginada dos produtos pelo nome (public)
- Inserir um Novo Produto (Admin)
- Atualizar um produto (Admin)
- Deletar um Produto (Admin)
- Tratamento de exceções, validação e controle de acesso para esses endpoints

- Login: O usuário informa as credenciais e o sistema retorna um Token de acesso caso ele esteja no Banco de Dados, e ele pode acessar novos recursos, dependendo dos seus Roles (ADMIN OU CLIENT)
- EndPoint para receber informações do usuário que está logado. Ex de retorno:
```json
{
    "id": 2,
    "name": "Alex Green",
    "email": "alex@gmail.com",
    "phone": "977777777",
    "birthDate": "1987-12-13",
    "roles": [
        "ROLE_CLIENT",
        "ROLE_ADMIN"
    ]
}
```
- Busca uma lista com todas as categorias (ADMIN)
- Busca uma Order pelo id (ADMIN ou USUÁRIO AO QUAL PERTENCE A ORDER) Ex de Resposta:
```json
{
    "id": 1,
    "moment": "2022-07-25T13:00:00Z",
    "status": "PAID",
    "client": {
        "id": 1,
        "name": "Maria Brown"
    },
    "payment": {
        "id": 1,
        "moment": "2022-07-25T15:00:00Z"
    },
    "items": [
        {
            "productId": 1,
            "name": "The Lord of the Rings",
            "price": 90.5,
            "quantity": 2,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
            "subTotal": 181.0
        },
        {
            "productId": 3,
            "name": "Macbook Pro",
            "price": 1250.0,
            "quantity": 1,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg",
            "subTotal": 1250.0
        }
    ],
    "total": 1431.0
}
```
- Inserir uma nova Order no sistema (CLIENT). Com isso, simulamos o comportamento de um Carrinho de compras e a finalização de um pedido.
- Todos os EndPoints tem controle de acesso.
- Exceções personalizadas com códigos correspondentes a cada situação.
# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone git@github.com:LucasIbiapino7/Agregador-de-Investimentos.git
```
# Autor

Lucas Ibiapino Do Nascimento Duarte

# Agradecimentos

escola de Progrmação: https://devsuperior.com.br



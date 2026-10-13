para executar a aplicação:

chmod +x mvnw
./mvnw spring-boot:run

http://localhost:8080

Teste de rotas:


Criar um aventureiro - POST

Rota: /api/aventureiros

requisição:

{
  "nome": "Melotigas",
  "capacidadeInventario": 3,
  "classe": "GUERREIRO"
}


Consultar um aventureiro - GET

Rota: /api/aventureiros/1

Aplicar dano - POST

Método: POST

Rota: /api/aventureiros/1/dano

requisição:

{
  "quantidade": 30
}

Recuperar energia - POST

Método: POST

Rota: /api/aventureiros/1/recuperacao

requisição:

{
  "quantidade": 20
}

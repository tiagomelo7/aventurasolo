# aventurasolo
Ecossistema para um jogo de AventuraSolo para a matéria de LP2


Diagrama da Atividade 1 - 

<img width="1920" height="1080" alt="DIAGRAMADECLASSEAVENTURASOLO" src="https://github.com/user-attachments/assets/12e64459-111f-459b-b828-bfb5ac69bdf5" />

Explicação da diagramação(chatgpt feelings) - 

O projeto apresenta os relacionamentos entre as classes de um sistema de aventura. Aventureiro e Inventario possuem composição (1→1), pois o aventureiro cria e possui seu próprio inventário. Inventario e Item possuem agregação (1→*), pois os itens são criados externamente e podem existir fora do inventário. Já Aventureiro e Missao possuem associação (1→0..1), pois a missão existe independentemente do aventureiro. Missao e Recompensa são uma agregação (1→1), enquanto Recompensa e Item formam uma associação opcional (1→0..1).

O encapsulamento é garantido principalmente pelo uso de campos private, validações nos construtores e uso estratégico de final. Estados mutáveis, como energia, missão ativa, itens e estado da missão, só podem ser alterados através de métodos que aplicam as regras do domínio, como receberDano(), recuperar(), aceitarMissao(), iniciar() e concluir(). O Inventario também utiliza cópia defensiva no método itens(), evitando que código externo altere diretamente sua lista interna.

Por fim, o código utiliza diferentes formas de tratamento de situações inválidas conforme o significado de cada caso: exceções para argumentos inválidos, clamping para situações normais como dano que reduziria a energia abaixo de zero e booleanos para operações do inventário que podem simplesmente falhar. Além disso, TipoItem, Raridade e EstadoMissao são implementados como enum, garantindo que somente valores previamente definidos possam existir e evitando erros causados por strings inválidas.

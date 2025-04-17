# 📊 Itaú Backend Challenge
ℹ Este projeto é uma API REST desenvolvida em Java utilizando Spring Boot, construída como parte de um desafio técnico backend.

O sistema tem como objetivo principal o registro de transações financeiras e o cálculo de estatísticas em tempo real, com base nas transações recebidas nos últimos 60 segundos.

A arquitetura do projeto foi baseada no padrão MVC (por se tratar de um projeto pequeno), mas com um toque de inspiração nos princípios da Clean Architecture, priorizando separação de responsabilidades e facilidade de manutenção.

> 🔗 Confira o desafio original: [https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior](https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior)

## 📚 Endpoints
<b style="font-size: 150%;">Criar nova transação</b>
<br>
Registra uma nova transação com valor e data/hora.
<br>
• <b>Método:</b> POST<br>• <b>URL:</b> /transacao 
<br>
• <b>Body:</b>
```json
/*
201 Created - Transação aceita
422 Unprocessable Entity - Transação recusada
400 Bad Request - Não compreendido pela API
*/
{
   "valor": 123.45,
   "dataHora": "2025-04-17T15:30:00.000-03:00"
}
```
<b>📝 Observação:</b> Substitua `dataHora` pelo horário atual no formato ISO 8601 com offset.
<br><br>

<b style="font-size: 150%;">Deletar todas as transações</b>
<br>
Remove todas as transações armazenadas.
<br>
• <b>Método:</b> DELETE<br>• <b>URL:</b> /transacao
```json
// 200 Ok
```
<br><br>

<b style="font-size: 150%;">Obter estatísticas</b>
<br>
Calcula estatísticas com base nas transações dos últimos 60 segundos.
<br>
• <b>Método:</b> GET<br>• <b>URL:</b> /estatistica
<br>
• <b>Response:</b>

```json
// 200 Ok
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

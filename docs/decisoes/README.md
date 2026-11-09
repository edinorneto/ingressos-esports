# Registro de decisões

Decisões de arquitetura e de regra de negócio, no formato ADR (Architecture
Decision Record). Cada arquivo explica o contexto, o que foi escolhido, o que
foi descartado e por quê.

## Quando registrar
- A escolha afeta regra de negócio, modelo de dados ou arquitetura.
- Havia mais de uma opção razoável.

## Como registrar
1. Copie `0000-modelo.md` para `NNNN-titulo-curto.md`, com o próximo número.
2. Preencha as seções. Uma página costuma bastar.
3. Decisões não são apagadas. Se mudar, crie um registro novo e marque o
   antigo como "Substituída por NNNN".

## Índice
| Nº | Decisão | Status |
|----|---------|--------|
| [0001](0001-prazo-de-reembolso.md) | Prazo de reembolso baseado no art. 49 do CDC | Aceita |
| [0002](0002-cota-meia-entrada.md) | Cota de meia-entrada controlada pelo Evento | Aceita |

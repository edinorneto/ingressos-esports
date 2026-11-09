# 0002. Cota de meia-entrada controlada pelo Evento

- **Status:** Aceita
- **Data:** 2026-11-09

## Contexto
A Lei 12.933/2013 (art. 1º, § 10) garante meia-entrada em 40% do total de
ingressos disponíveis de cada evento. Têm direito estudantes, pessoas com
deficiência (e um acompanhante) e jovens de 15 a 29 anos de baixa renda.

O sistema precisa saber quando essa cota acabou para parar de vender meia.

## Escolha
A regra fica no `Evento`. Ele conhece a capacidade total e os ingressos
vendidos, então é quem responde "ainda cabe meia?".

- Cota = 40% da capacidade do evento, arredondada para cima
  (1.001 lugares → 401 meias).
- Ao esgotar, o evento lança `CotaMeiaEntradaEsgotadaException`. O comprador
  ainda pode levar inteira.
- `IngressoMeia` continua só calculando o próprio preço.

## Alternativas
- **No `Ingresso`:** um ingresso não enxerga os outros, então não tem como
  contar quantas meias já saíram.
- **Por setor:** a lei fala em total do evento. Cota por setor seria mais
  restritiva que a lei.
- **Arredondar para baixo:** daria menos de 40% em alguns eventos (400 de
  1.001 = 39,96%), abaixo do que a lei garante.

## Porquê
É a classe que tem a informação necessária, então a regra fica num lugar só
e fácil de testar.

Fica para a Fase 4: num evento com cota de 400, duas compras de meia ao
mesmo tempo podem ler "399 vendidas" e as duas passarem, fechando em 401. Em memória isso não aparece; com banco e
várias requisições, sim.

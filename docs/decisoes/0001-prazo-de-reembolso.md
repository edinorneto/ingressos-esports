# 0001. Prazo de reembolso baseado no art. 49 do CDC

- **Status:** Aceita
- **Data:** 2026-11-06
- **Fase do plano:** Fase 4, tema 4 (cancelamento com reembolso)

## Contexto
O plano previa "cancelamento com reembolso até X dias antes do evento", sem
definir X. A venda é 100% online, então a contratação acontece fora do
estabelecimento comercial e atrai o direito de arrependimento.

**Lei 8.078/1990 (CDC), art. 49:**
> O consumidor pode desistir do contrato, no prazo de 7 dias a contar de sua
> assinatura ou do ato de recebimento do produto ou serviço, sempre que a
> contratação de fornecimento de produtos e serviços ocorrer fora do
> estabelecimento comercial, especialmente por telefone ou a domicílio.
>
> Parágrafo único. Se o consumidor exercitar o direito de arrependimento
> previsto neste artigo, os valores eventualmente pagos, a qualquer título,
> durante o prazo de reflexão, serão devolvidos, de imediato, monetariamente
> atualizados.

**Decreto 7.962/2013 (comércio eletrônico), art. 5º:** o fornecedor deve
informar de forma clara os meios para o arrependimento (caput); o consumidor
pode exercê-lo pela mesma ferramenta usada na compra (§ 1º); o arrependimento
rescinde os contratos acessórios sem ônus (§ 2º); o fornecedor comunica de
imediato a operadora do cartão para que a cobrança não seja lançada ou seja
estornada (§ 3º); e confirma de imediato o recebimento do pedido (§ 4º).

### Nuances jurídicas (o ponto não é pacífico)
1. **Ingresso para data certa.** O CDC não traz exceção para serviços de
   lazer com data marcada. A Diretiva europeia 2011/83/UE tem essa exceção
   (art. 16, "l"); o Brasil, não. Por isso Procons tendem a aplicar o art. 49
   a ingressos comprados online, enquanto parte da doutrina e algumas decisões
   judiciais relativizam o direito quando ele inviabiliza a revenda do lugar
   perto do evento. Não há tese vinculante do STJ sobre o tema.
2. **Termo inicial.** O artigo conta o prazo "da assinatura ou do recebimento
   do produto ou serviço". No ingresso digital, contratação e entrega do
   e-ticket costumam coincidir, mas se o e-ticket for emitido depois, a
   leitura mais protetiva conta do recebimento.
3. **Compra a menos de 7 dias do evento.** Depois que o evento começa, o
   serviço foi prestado (ou posto à disposição) e o arrependimento perde o
   objeto. Antes disso, encurtar o prazo por contrato (ex.: "só até 48 h antes")
   não tem base legal e pode ser lido como renúncia de direito, nula pelo
   art. 51, I, do CDC.
4. **Taxa de conveniência.** "Valores pagos a qualquer título" inclui a taxa.
   A licitude da taxa em si foi discutida no STJ (REsp 1.737.428/RS, 3ª Turma),
   mas, no arrependimento, a devolução é integral.
5. **Cancelamento pelo organizador** (adiamento, evento cancelado) é outro
   regime (vício do serviço, arts. 20 e 35 do CDC) e fica fora desta decisão.

## Escolha
O comprador pode cancelar com **reembolso integral** (preço + taxas) enquanto
as duas condições forem verdadeiras:

- não passaram **7 dias corridos** desde a compra paga (ou desde a emissão do
  ingresso, se for posterior); e
- o evento **ainda não começou**.

Em código: `prazoFinal = min(dataCompra + 7 dias, inicioDoEvento)`.
Fora desse prazo, não há reembolso voluntário no MVP. Ao cancelar, o assento
volta para `DISPONIVEL`.

## Alternativas
- **"Até X dias antes do evento" (regra original do plano):** ignora o art. 49.
  Compra feita 30 dias antes ficaria sem os 7 dias de reflexão, e compra feita
  na véspera teria o direito suprimido por contrato.
- **7 dias sempre, mesmo após o evento:** leitura literal extrema; o serviço já
  foi prestado, o que geraria reembolso de algo consumido. Nenhuma corrente
  relevante defende isso.
- **Corte de 24 h ou 48 h antes do evento:** útil para revender o assento, mas
  sem base legal, com risco de abusividade (art. 51, I e IV).
- **Política mais generosa (ex.: reembolso parcial até 48 h antes):** decisão
  comercial legítima, que pode somar ao mínimo legal. Fica para depois do MVP.

## Porquê
- Cumpre o mínimo legal sem inventar exceção que a lei não prevê.
- A regra cabe em uma linha de código e é fácil de testar (bom para a Fase 4:
  testes com datas na fronteira de 7 dias e no início do evento).
- O ponto controverso (compra perto do evento) é resolvido do lado mais
  protetivo ao consumidor, que é o que um Procon cobraria.
- **Custo:** o assento pode voltar à venda muito perto do evento e ficar vazio.
  Isso é risco do negócio, não do consumidor.

> Este registro é uma decisão de projeto de portfólio, não um parecer jurídico.

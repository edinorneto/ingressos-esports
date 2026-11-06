# Roadmap: Plataforma de ingressos para e-sports (Java + Spring Boot)

Objetivo: projeto de portfólio que cubra o núcleo e os diferenciais das vagas
de backend Java júnior. Regra: só entra no projeto código que eu consigo
explicar sem olhar.

Decisões relevantes ficam registradas em [`docs/decisoes/`](decisoes/README.md)
(contexto, escolha, alternativas, porquê). O README da Fase 5 usa esses
registros como estudo de caso.

## Regras de negócio do MVP
- Um assento só pode ser vendido uma vez.
- **Meia-entrada:** cota de 40% do total de ingressos disponíveis para cada
  evento (Lei 12.933/2013, art. 1º, § 10). Ao esgotar a cota, nova meia é
  recusada. A concorrência na cota é tratada na Fase 4.
- **Reembolso:** integral até 7 dias após a compra, limitado ao início do
  evento (CDC, art. 49). Ver [decisão 0001](decisoes/0001-prazo-de-reembolso.md).

## Fase 1: Java além do básico
1. Herança completa: super, classes abstratas, interface x classe abstrata ✅
2. enum (estados do assento: DISPONIVEL, RESERVADO, VENDIDO)
3. Exceções próprias, checked e unchecked (AssentoIndisponivelException,
   CotaMeiaEntradaEsgotadaException)
4. equals e hashCode
5. Map e Set (assentos por setor, ingressos sem duplicata)
6. Comparator e ordenação
7. Lambdas e Streams (filtrar eventos, agrupar assentos, somar vendas, contar
   meias vendidas por evento)
8. BigDecimal para dinheiro, e por que double não serve
9. record e Optional
10. Pacotes, Maven e JUnit 5

Pronto quando: escrevo sem IA um programa em memória que lista eventos,
reserva assentos, impede reserva duplicada, respeita a cota de 40% de
meia-entrada e tem testes.

## Fase 2: Banco de dados e Docker
1. Docker básico: imagem, container, docker compose
2. PostgreSQL rodando em Docker
3. Modelagem: eventos, setores, assentos, reservas, pedidos, pagamentos e
   ingressos (com tipo inteira/meia e CPF do comprador)
4. Constraints: PK, FK, UNIQUE (um ingresso por assento por evento), CHECK
5. Transações: o que garantem e quando usar
6. JDBC puro, só para entender o que o JPA automatiza

Pronto quando: sei explicar cada constraint e o que uma transação garante.

## Fase 3: API com Spring Boot
Cada funcionalidade em uma branch própria, com pull request revisado antes do
merge.

1. HTTP e REST: métodos, status, JSON
2. Projeto pelo Spring Initializr; camadas controller, service, repository
3. Injeção de dependência
4. Spring Data JPA e migrações com Flyway
5. CRUD de eventos e setores; listagem de assentos disponíveis
6. Validação de entrada e tratamento centralizado de erros
7. Swagger, Docker Compose com API e banco
8. Testes de controller e service (JUnit, Mockito)

Pronto quando: a API funciona de ponta a ponta, sobe com um comando e tem
testes.

## Fase 4: Os conceitos que destacam
1. Reserva temporária: disponível → reservado → vendido, expirando em
   10 minutos com job agendado (@Scheduled). **O pagamento também verifica a
   expiração**: reserva vencida é recusada mesmo que o job ainda não tenha
   rodado.
2. Concorrência: dois compradores no mesmo assento, só um consegue. Inclui a
   **cota de meia-entrada**: duas compras simultâneas não podem passar dos 40%.
3. Pagamento simulado idempotente (header Idempotency-Key)
4. Cancelamento com reembolso: até 7 dias após a compra, limitado ao início do
   evento ([decisão 0001](decisoes/0001-prazo-de-reembolso.md))
5. **Limite de ingressos por CPF** por evento, incluindo requisições
   simultâneas do mesmo CPF (duas abas, dois dispositivos)
6. Histórico append-only de pedidos e pagamentos
7. Testes de integração com Testcontainers

Pronto quando: explico e demonstro com testes cada mecanismo.

## Sessão extra: system design
Depois da Fase 4: como um sistema de ingressos funciona em grande escala,
comparando com o que construí.

## Fase 5: Diferenciais
1. Spring Security com JWT: comprador e administrador
2. Cache do mapa de assentos com Redis
3. Mensageria: evento "ingresso emitido" com RabbitMQ
4. GitHub Actions rodando os testes
5. Logs estruturados e Spring Actuator (health e métricas)
6. README como estudo de caso, usando os registros de `docs/decisoes/`

Pronto quando: o projeto está publicado e eu o apresento em 5 minutos.

## Final
Deploy da aplicação em uma nuvem.

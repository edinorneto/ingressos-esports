# Roadmap: Plataforma de ingressos para e-sports (Java + Spring Boot)

Plataforma de venda de ingressos com foco nos problemas reais desse domínio:
assento vendido uma única vez, reserva temporária, concorrência entre
compradores, pagamento idempotente e regras legais (meia-entrada e
direito de arrependimento).

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

## Fase 1: Domínio em memória (Java puro)
1. Tipos de ingresso (inteira, meia, VIP) com hierarquia de classes ✅
2. Estados do assento: DISPONIVEL, RESERVADO, VENDIDO (enum)
3. Erros de negócio como exceções próprias (AssentoIndisponivelException,
   CotaMeiaEntradaEsgotadaException)
4. Igualdade de entidades (equals e hashCode)
5. Assentos por setor e ingressos sem duplicata (Map e Set)
6. Listagens ordenadas e consultas (Comparator, Streams): eventos, assentos
   livres, total vendido, meias vendidas por evento
7. Dinheiro com BigDecimal
8. Objetos de valor com record e retornos com Optional
9. Build com Maven e testes com JUnit 5

Pronto quando: um programa em memória lista eventos, reserva assentos,
impede reserva duplicada, respeita a cota de 40% de meia-entrada e tem
testes.

## Fase 2: Banco de dados e Docker
1. PostgreSQL rodando em Docker (docker compose)
2. Modelagem: eventos, setores, assentos, reservas, pedidos, pagamentos e
   ingressos (com tipo inteira/meia e CPF do comprador)
3. Constraints: PK, FK, UNIQUE (um ingresso por assento por evento), CHECK
4. Transações nas operações críticas (reserva, venda, cancelamento)
5. Acesso com JDBC puro, antes de adotar JPA

Pronto quando: o esquema garante as regras no banco (constraints) e as
operações críticas rodam em transação.

## Fase 3: API com Spring Boot
Cada funcionalidade em uma branch própria, com pull request revisado antes do
merge.

1. API REST em camadas: controller, service, repository
2. Spring Data JPA e migrações com Flyway
3. CRUD de eventos e setores; listagem de assentos disponíveis
4. Validação de entrada e tratamento centralizado de erros
5. Swagger, Docker Compose com API e banco
6. Testes de controller e service (JUnit, Mockito)

Pronto quando: a API funciona de ponta a ponta, sobe com um comando e tem
testes.

## Fase 4: Regras críticas de venda
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

Pronto quando: cada mecanismo é demonstrado por testes.

## Fase 5: Segurança, escala e operação
1. Spring Security com JWT: comprador e administrador
2. Cache do mapa de assentos com Redis
3. Mensageria: evento "ingresso emitido" com RabbitMQ
4. GitHub Actions rodando os testes
5. Logs estruturados e Spring Actuator (health e métricas)
6. README como estudo de caso, usando os registros de `docs/decisoes/`

Pronto quando: o projeto está publicado e documentado.

## Final
Deploy da aplicação em uma nuvem.

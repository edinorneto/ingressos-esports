# Roadmap

## Regras de negócio
- Um assento só pode ser vendido uma vez.
- **Meia-entrada:** até 40% dos ingressos de cada evento (Lei 12.933/2013,
  art. 1º, § 10). Com a cota esgotada, nova meia é recusada.
- **Reembolso:** integral até 7 dias após a compra, desde que o evento ainda
  não tenha começado (CDC, art. 49).
- **Reserva temporária:** o assento fica reservado por 10 minutos. Reserva
  vencida não pode ser paga.
- **Limite por CPF:** número máximo de ingressos por comprador em cada evento.

## Marcos

### 1. Domínio em memória
- [x] Tipos de ingresso: inteira, meia e VIP
- [ ] Estados do assento: disponível, reservado, vendido
- [x] Eventos, setores e assentos
- [ ] Reserva de assento, sem venda duplicada
- [ ] Cota de meia-entrada
- [ ] Testes das regras de reserva e venda

### 2. Persistência
- [ ] PostgreSQL com Docker Compose
- [ ] Modelo de dados: eventos, setores, assentos, reservas, pedidos,
      pagamentos e ingressos
- [ ] Constraints garantindo as regras no banco (ex.: um ingresso por assento)
- [ ] Transações nas operações de reserva, venda e cancelamento

### 3. API REST
- [ ] Spring Boot com Spring Data JPA e Flyway
- [ ] Cadastro de eventos e setores; consulta de assentos disponíveis
- [ ] Validação de entrada e tratamento padronizado de erros
- [ ] Documentação com Swagger
- [ ] API e banco subindo com um comando

### 4. Venda
- [ ] Reserva com expiração automática
- [ ] Compra concorrente: dois compradores no mesmo assento, só um conclui
- [ ] Pagamento idempotente (header `Idempotency-Key`)
- [ ] Cancelamento com reembolso
- [ ] Limite de ingressos por CPF
- [ ] Histórico de pedidos e pagamentos
- [ ] Testes de integração com Testcontainers

### 5. Operação
- [ ] Autenticação com JWT (comprador e administrador)
- [ ] Cache do mapa de assentos com Redis
- [ ] Evento "ingresso emitido" com RabbitMQ
- [ ] CI com GitHub Actions
- [ ] Logs estruturados e Spring Actuator
- [ ] Deploy em nuvem

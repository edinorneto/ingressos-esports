# Ingressos e-sports

Plataforma de venda de ingressos para eventos de e-sports.

Regra central: **um assento só pode ser vendido uma vez.**

## Estado atual
Domínio em Java puro, com dados em memória. A API com Spring Boot vem depois.

## Como rodar
Requisitos: JDK 21 e Maven (ou o Maven embutido do IntelliJ).

```bash
mvn test        # roda os testes
mvn package     # compila e gera o .jar em target/
```

## Estrutura
```
src/main/java/br/com/ingressos/          código da aplicação
src/main/java/br/com/ingressos/dominio/  Evento, Setor, Assento, Reserva, Ingresso
src/test/java/br/com/ingressos/          testes (JUnit 5)
```

## Roadmap
Regras de negócio e próximos passos em [docs/ROADMAP.md](docs/ROADMAP.md).

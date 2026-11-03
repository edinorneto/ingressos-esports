# Ingressos e-sports

Plataforma de venda de ingressos para eventos de e-sports. Projeto de portfólio.

Regra central: **um assento só pode ser vendido uma vez.**

## Estado atual
Fase 1: Java puro, em memória. Spring Boot entra na Fase 3.

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

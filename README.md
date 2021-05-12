# Uso de WebHook para comunicação de microsserviços

(Somente será exposto o POST)

Componentes utilizados:
- Ubuntu 20.04
- Spring Tool Suite
- Spring Boot API 2.4.5
- JDK 11
- https://webhook.site/

Dependências Spring:
- Data JPA
- Validation
- Web
- DevTools
- Maven

### Endpoints

POST</br>

### Requisição

```
POST
http://localhost:8080/webhook
```

### Formato do DTO

evt -> String</br>
execution -> String</br>
String -> String</br>
owner -> int</br>

### HttpStatus

Os codigos de retorno são:
- 500
- 200

### Formato de entrada

```json
// Payload #1
{
    "evt": "ExecutionFinishedWithError",
    "execution": "20201015.111226-ij0uxv",
    "owner": 56,
    "bot": "pje-trt-copia-integral"
}

// Payload #2
{
    "evt": "ReportGenerated",
    "execution": "20201015.111226-ij0uxv",
    "owner": 56,
    "bot": "pje-trt-copia-integral"
}
```

### Formato de saida

Dois modelos de respostas expostos. Um em LOG, outro no retorno da requisição em TEXT.

```text
[ReportGenerated - pje-trt-copia-integral] a execução 20201015.111226-ij0uxv terminou com sucesso.

[ExecutionFinishedWithError - pje-trt-copia-integral] a execução 20201015.111226-ij0uxv terminou com erros.

  ```


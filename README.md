 
## Como rodar a aplicação

### 1 - Criar o arquivo "application.properties" e passar as informações necessárias com base no arquivo "example.application.properties".

<br>

### 2 - Rodar o comando "mvn install" para instalar as dependências do projeto.

<br>

### 3 - Rodar o comando "mvn spring-boot:run" para executar a aplicação.

<br>


# Swagger: http://localhost:8080/v2/api-docs
## Endpoints

### 1 - [POST] /api/auth 
#### 1.1 - Body { "email": "admin@innovation.com.br", "senha": "password" } 
<b>Obs: o usuário "admin@innovation.com.br" com a senha "password" é criado assim que a aplicação é iniciada.</b>
<br>
<br>

### 2 - [GET] /api/users
### 2.1 - Headers Authorizarion Bearer {token}

<br>

### 3 - [POST] /api/users
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body {"name": "your-name", "lastname": "your-lastname", "email": "your-email", password: "your-password"}

<br>

### 3 - [PUT] /api/users/{id}
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body {"name": "your-name", "lastname": "your-lastname", "email": "your-email", password: "your-password"}

<br>

### 3 - [DELETE] /api/users/{id}
### 3.1 - Headers Authorizarion Bearer {token}

<br>
<br>

### 2 - [GET] /api/clients
### 2.1 - Headers Authorizarion Bearer {token}

<br>

### 3 - [POST] /api/clients
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body {"name": "your-client-name","lastname": "your-client-lastname","email": "your-client-email","cpf": "your-client-cpf","phone": "000000000","address": "your-client-address"}

<br>

### 3 - [PUT] /api/clients/{id}
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body  {"name": "your-client-name","lastname": "your-client-lastname","email": "your-client-email","cpf": "your-client-cpf","phone": "000000000","address": "your-client-address"}

<br>

### 3 - [DELETE] /api/clients/{id}
### 3.1 - Headers Authorizarion Bearer {token}

<br>
<br>

### 2 - [GET] /api/orders
### 2.1 - Headers Authorizarion Bearer {token}

<br>

### 3 - [POST] /api/orders
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body {"name": "your-client-name","lastname": "your-client-lastname","email": "your-client-email","cpf": "your-client-cpf","phone": "000000000","address": "your-client-address"}

<br>

### 3 - [PUT] /api/orders/{id}
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body  {"productName": "your-order","price": 30.00,"client": 123}

<br>

### 3 - [DELETE] /api/orders/{id}
### 3.1 - Headers Authorizarion Bearer {token}

<br>
<br>

### 2 - [GET] /api/deliveries
### 2.1 - Headers Authorizarion Bearer {token}

<br>

### 3 - [POST] /api/deliveries
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body {"deliveryName": "your-delivery-name","status": "your-string-status-name","order": 123}

<br>

### 3 - [PUT] /api/deliveries
### 3.1 - Headers Authorizarion Bearer {token}
### 3.2 - Body  {"deliveryName": "your-delivery-name","status": "your-string-status-name","order": 123}

<br>

### 3 - [DELETE] /api/deliveries/{id}
### 3.1 - Headers Authorizarion Bearer {token}

<br>
<br>


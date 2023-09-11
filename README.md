# Desafio Proposto
 Desafio proposto para entrevista tecnica, empresa confidencial


# Tecnologias usadas
Spring boot,
Spring data JPA,
Lombok,
Junit,
Postman,
MySQL Workbench,
Intelijj IDEA 2022.22.

# Informações do projeto
Para esse projeto, como pedia o desafio usei diversos padrões de projetos, além da 
arquitetura SOLID e das boas práticas do clean code, separei em 3 camadas os padroes de projetos para usa-lós 
da melhor forma, segue abaixo padrões que usei a criação das duas apis (ViaCep, e ecommerce)
* criacional (factory, builder, DTOs),
* estrutural (Dependency Injection facade)
* comportamental (strategy)

Foquei principalmente no desaclopamento da lógica e nas boas praticas de single responsabily

# Como usar 
* Para facilitar a execução optei por deixar as duas apis no mesmo pacote, assim rodando uma você poderá acessar todos 
os end-points das duas apis.

* Ela está localizada dentro do pacote ecommerce = package com.desafio.ecommerce.viacep

* Enviarei no email as querys que devem ser executadas no Mysql para que o teste faça efeito.

* Atente-se a porta do seu localHost, por padrão é 8080, mas pode ser alterada

# Para primeira API - VIA CEP
temos apenas 1 método de acesso, sendo ele GET :
http://localhost:8080/api/viacep/{cep}

* o valor é passado por parametro na URL, no lugar do : {cep}

* Ele deve retornar um Json como o exemplo abaixo, contendo as informações do cep passado:

{
    "cep": "06705-230",
    "logradouro": "Rua Américo Floriano de Toledo",
    "complemento": "",
    "bairro": "Jardim Caiapia",
    "localidade": "Cotia",
    "uf": "SP"
} 


# Para Segunda API - ECOMMERCE

  Temos dois métodos de acesso, um GET e um POST

  * O método post : http://localhost:8080/api/ecommerce/salvar
no body da requisição podemos passar um endereço, ou uma Array com diversos endereços
seguindo o mesmo padrão de Json da primeira api, no json contém os seguintes campos:
logradouro, cidade, estado, cep, bairro, emailRealcionado, e numero. Sendo todos eles do tipo
String, apenas o numero como Integer.

* No campo emailRelacionado, ele fará uma verificação se aquele email se encontra na tabela Clientes do MySQL,
caso não exista, ele criará um novo endereço atrelado a esse email que está sendo passado na requisição.

* O método get : http://localhost:8080/api/ecommerce/{email}
  no método get o email que queremos procurar os endereços que estão atrelados a ele
  também está como parametro na URL, então deve ser preenchido de acordo com o email cadastrado anteriormente,
  ele retornará um ou mais email de acordo com o que está salvo na base de dados.

  Enviarei uma collection do postman com os dados;









<div align="center">
  <img src="https://user-images.githubusercontent.com/18688446/156849342-809790ed-df9d-4497-b94e-9cff0540c7a0.png" alt="Ecoleta Logo" /> 
  <br/> 
  <h1>API Crud-Base</h1>
  <h3>Base de CRUD feito em Java com Springboot</h3>
</div>

<p align="center">
    <img src="https://img.shields.io/static/v1?label=Java&message=11&color=DC143C&style=flat-square&logo=Java" alt="Java" />
    <img src="https://img.shields.io/static/v1?label=SpringBoot&message=2.6.4&color=7CFC00&style=flat-square&logo=SpringBoot" alt="SpringBoot" />
    <img src="https://img.shields.io/static/v1?label=Apache Maven&message=3.6.3&color=DC143C&style=flat-square&logo=Apache Maven" alt="Apache Maven" />
    <img src="https://img.shields.io/static/v1?label=PostgreSQL&message=14.2&color=1E90FF&style=flat-square&logo=PostgreSQL&logoColor=1E90FF" alt="PostgreSQL" />

</p>

## Como usar
- Precisará criar um banco de dados com o nome `crud-base` em PostgreSQL, para isso rode o Script localizado na raiz do projeto:
  ```
  $ ./script-create-data-base.sh
  ```

- Após, execute no terminal:
  ```
  $ mvn clean install
  ```

- Entao execute a API pela IDE;

#### Abaixo um exemplo de inserção:

Metodo: ```POST``` </br>
EndPoint: ```localhost:8080/person/create``` </br>
Body:
```json
{
    "name": "Teste",
    "cellphone": "00000000000",
    "phone": "1111111111",
    "address": "Rua teste",
    "email": "test@1223.com"
}
```
Response:
```json
{
    "object": {
        "id": "acca6f1e-444a-4ade-9318-6503a10e0b5b",
        "createdAt": "2022-03-04T18:41:18Z",
        "updatedAt": null,
        "name": "Teste",
        "cellphone": "00000000000",
        "phone": "1111111111",
        "address": "Rua teste",
        "email": "test@1223.com"
    },
    "listObject": null,
    "situation": "SUCCESS",
    "message": "Person created successfully"
}
```
---
## Resultado Final
#### Person
- Banco de dados:
  ![image](https://user-images.githubusercontent.com/18688446/156852703-036646a8-2530-4d0e-9071-0fbfd3b5eabd.png)
- JSON getAll:
```json
{
    "object": null,
    "listObject": [
        [
            {
                "id": "acca6f1e-444a-4ade-9318-6503a10e0b5b",
                "createdAt": "2022-03-04T18:41:18Z",
                "updatedAt": null,
                "name": "Teste",
                "cellphone": "00000000000",
                "phone": "1111111111",
                "address": "Rua teste",
                "email": "test@1223.com"
            }
        ]
    ],
    "situation": "SUCCESS",
    "message": "Person found"
}
```

#### Course
- Banco de dados:
![image](https://user-images.githubusercontent.com/18688446/156853320-f7b2b54c-ca04-4893-b994-216038796667.png)
- JSON getAll:
```json
{
    "object": null,
    "listObject": [
        [
            {
                "id": "dc1e310b-9b87-4132-8309-affb9de95486",
                "createdAt": "2022-03-04T18:56:28Z",
                "updatedAt": null,
                "name": "Tecnologia em Analise e Desenvolvimento de Software",
                "situation": "ACTIVE"
            }
        ]
    ],
    "situation": "SUCCESS",
    "message": "Course found"
}
```
#### Students
- Banco de dados:
![image](https://user-images.githubusercontent.com/18688446/156853599-d8637363-063f-4125-aa0d-f79b08abc435.png)
- JSON getAll:
```json
{
    "object": null,
    "listObject": [
        [
            {
                "id": "92560835-dfa3-47ee-84e7-4c3cd2c464a6",
                "createdAt": "2022-03-04T18:59:43Z",
                "updatedAt": null,
                "course": {
                    "id": "dc1e310b-9b87-4132-8309-affb9de95486",
                    "createdAt": "2022-03-04T18:56:28Z",
                    "updatedAt": null,
                    "name": "Tecnologia em Analise e Desenvolvimento de Software",
                    "situation": "ACTIVE"
                },
                "person": {
                    "id": "acca6f1e-444a-4ade-9318-6503a10e0b5b",
                    "createdAt": "2022-03-04T18:41:18Z",
                    "updatedAt": null,
                    "name": "Teste",
                    "cellphone": "00000000000",
                    "phone": "1111111111",
                    "address": "Rua teste",
                    "email": "test@1223.com"
                }
            }
        ]
    ],
    "situation": "SUCCESS",
    "message": "Students found"
}
```
---
## EndPoints
#### Person
```
/person
├───/getAll
├───/getById
|      └───/{id}
├───/create
├───/update
|      └───/{id}
└───/delete
       └───/{id}
```
#### Course
```
/course
├───/getAll
├───/getById
|      └───/{id}
├───/create
├───/update
|      └───/{id}
└───/delete
       └───/{id}
```
#### Students
```
/students
├───/getAll
├───/getById
|      └───/{id}
├───/create
├───/update
|      └───/{id}
└───/delete
       └───/{id}
```
---
<p align="center">
  Desenvolvido com 💜 por <a href="https://www.linkedin.com/in/rafael-balconi/">RBalconi</a>
</p>

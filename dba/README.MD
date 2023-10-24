# DBA
## Introdução

Repositório responsável por armazenar os principais scripts do banco de dados. Aqui você pode encontrar os scripts de CRUD (Create, Read, Update, Delete) em forma de View e Procedure para reduzir a quantidade de linhas na aplicação e limitar o acesso aos scripts que o mesmo irá utilizar.

## Padrões utilizados

<b>A decidir.</b>

## Tabelas

<h3>
    <b>
        <span style="color:rgb(79, 103, 163)">
            Usuario
        </span>
    </b>
</h3>

Responsável por armazenar os usuários que utilizam o sistema.

<h3>
    <b>
        <span style="color:rgb(79, 103, 163)">
            Estado
        </span>
    </b>
</h3>

Responsável por armazenar dados de tarifa por Estado, bem como a UF e nome do Estado.

<h3>
    <b>
        <span style="color:rgb(79, 103, 163)">
            Residencia
        </span>
    </b>
</h3>

Responsável por armazenar as residências do usuário.

<h3>
    <b>
        <span style="color:rgb(79, 103, 163)">
            Tipo dispositivo
        </span>
    </b>
</h3>

Responsável por armazenar os tipos de dispositivo que o usuário pode cadastrar.

<h3>
    <b>
        <span style="color:rgb(79, 103, 163)">
            Dispositivo
        </span>
    </b>
</h3>

Responsável por os dispositivos que constituiem uma residência.

<h3>
    <b>
        <span style="color:rgb(79, 103, 163)">
            Consumo
        </span>
    </b>
</h3>

Responável por armazenar o consumo dos dispositivos.
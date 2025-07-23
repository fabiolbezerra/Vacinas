# Vacinas

Uma aplicação de exemplo que gerencia ou controla as vacinas de um animal doméstico, criada usando as tecnologias JSF e JPA. Baseada no Java 8.

# Banco de dados

O banco de dados deve ser preparado para a aplicação ser rodada. Então, executar os seguintes _scripts_:
* [Criação](src/docs/criacao.sql) do banco
* [Inicialização](src/docs/inserts.sql) dos dados do banco

## Configurações

Há diferenças de configurações, dependendo da versão do MySQL instalada. 

### Versão 5.X
No pom.xml considere usar a seguinte dependência:

```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.49</version>
</dependency>
```

No persistence.xml considere usar a seguinte configuração de driver:

`<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>`

### Versão 8.X

No pom.xml considere usar a seguinte dependência:

```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

No persistence.xml considere usar a seguinte configuração de driver:

`<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>`

# Ícones nos Botões

Os botões utilizam ícones disponíveis no projeto [**Font Awesome 4**](https://fontawesome.com/v4/icons/).

Neste projeto, foi adotodo o seguinte padrão:
- novo: `icon="fa fa-file-o"`
- salvar: `icon="fa fa-floppy-o"`
- cancelar: `icon="fa fa-ban"`
- editar: `icon="fa fa-pencil"`
- excluir: `icon="fa fa-trash-o"`
- listar: `icon="fa fa-list-alt"`
- vacinas: `icon="fa fa-heart-o"`
- adicionar: `icon="fa fa-plus-square-o"`
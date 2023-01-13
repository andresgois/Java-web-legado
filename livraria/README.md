# Livraria

## Banco
- mysql-farmacia

### Docker
- Instalação e configuração do container do mysql

```
docker container run -e MYSQL_USER=andre -e MYSQL_PASSWORD=123456 -e MYSQL_DATABASE=farmacia -e MYSQL_ROOT_PASSWORD=123456 --name mysql-farmacia -p 3306:3306 mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
- Entra no container
```
mysql -h localhost -u andre -p
```

## Aplicação

![Desktop ou WEB](../img/01_desktopOrWeb.png)
### Em aplicações Desktop
> Cliente Gordo

    - cada cliente tem uma cópia da aplicação
    - regra de negócio em cada cliente
    - atualização um a um
##
### Aplicação WEB
> Cliente magro

    - aplicação central
    - facilita a manuteção e gerenciabilidade

```mermaid
    flowchart LR

    A[Banco] --> B(Servidor)
    B(Servidor) <--> |http| C1[Cliente 1]
    B(Servidor) <--> |http| C2[Cliente 2]
    B(Servidor) <--> |http| C3[Cliente 3]

```

### Frameworks WEB
- JSF
- GWT
- APACHE WICKET
#### JSF
- é um padrão java EE para desenvolvimento web baseado em componentes mantido pelo JCP.
- Especificação JSF - JSR-245
- [JCP](https://jcp.org/en/jsr/detail?id=314)
- JSF é chamado um framework Web baseado em componentes.
- uso de componentes
- desenvolvimento orientado ao evento
- desenvolvimento stateful
##### Implemantações dessa especificação
- Mojarra (Implementação referencial)
- Apache MyFaces
##### Extensões JSF
- [Prime Faces](https://www.primefaces.org/showcase/index.xhtml?jfwid=acf38)
- [RichFaces](http://showcase.richfaces.org/richfaces/component-sample.jsf?demo=select)
- [Ice Faces](http://icefaces-showcase.icesoft.org/showcase.jsf)

## Detalhes da contrução do projeto
- Pré-requisitos
    - Java SE 1.7
    - Eclipse Java EE
    - Apache Tomcat 7
- Projeto Livraria

```mermaid
    flowchart LR

    A[Livro] --> |Muitos para muitos| B[Autor]

```
##### Prepara tomcat
- Com o eclipse aberto
    - Digite ctrl + 3, digite server
    - clique em new server wizard
    - digite tomcat e escolha a versão 7
    - next e escolha onde salva
    - só finalizar
- Criar projeto
    - file 
    - new
    - Dynamic web project
    - coloque o nome do projeto
    - em *Target runtime* coloque Tomcat 7
    - em *Dynamic web module version* coloque 3.0
    - em *Configuration* coloque JavaServer Faces v2.0 project
    - next e na segunda marque pra gerar o web.xml
    - em *Type* coloque disable
    - em *URL Mapping pattenrs* coloque *.xhtml
- .JAR
    - todos os .jars devem fica em WEB-INF > lib 

##### Todo o mapeamento é feito pelo Faces Servlet
- Ao enviar a requisição é delegado o fluxo para a servlet
- O Servlet recebe a chamada e decide qual página ele vai chamar
- O controlador ler o xhtml e instância os componentes declarados
- No fim ele pega os componentes de apresentação e devolve para o navegador

```mermaid
    sequenceDiagram
    livro.xhtml->>localhost: Requisição
    localhost->>Controlador:Faces Servlet
    Controlador->>Visão: xhtml
    Visão->>Modelo: Managed Bean
    Controlador->>livro.xhtml: resposta
```

## Anotações
- *Indica que a classe será gerenciada pelo JSF*
> @ManagedBean
##
```mermaid
    sequenceDiagram
    Alice->>John: Hello John, how are you?
    loop Healthcheck
        John->>John: Fight against hypochondria
    end
    Note right of John: Rational thoughts!
    John-->>Alice: Great!
    John->>Bob: How about you?
    Bob-->>John: Jolly good!
```
##

```mermaid
  graph TD;
      Chrome == request ==>Servlet;
      subgraph tomcat
        subgraph /gerenciador
            Servlet -- Dispatcher --> JSP
        end
      end
      JSP == response ==>Chrome

      style Chrome fill:#ffff80,stroke:#000000,stroke-width:2px,color:#000000
      style JSP fill:#c0c0c0,color:#000000,stroke:#000000
      style Servlet fill:#c0c0c0,color:#000000,stroke:#000000
      style tomcat fill:#ffffff,color:#000000
      style /gerenciador fill:#ffffff,color:#000000, stroke:#000000,stroke-width:2px
```

## Acesso aplicação
- http://localhost:8080/jsf-livraria/livro.xhtml
- http://localhost:8080/jsf-livraria/autor.xhtml
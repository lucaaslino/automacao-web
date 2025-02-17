# Automação Web com Java, Selenium, Cucumber e Allure

Este projeto tem como objetivo realizar testes automatizados de uma aplicação web utilizando **Java**, **Selenium**, **Cucumber** e **Allure**. A solução é construída utilizando o Maven para gerenciamento de dependências e execução dos testes.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para a criação dos testes.
- **Selenium**: Framework utilizado para automação de navegadores.
- **Cucumber**: Framework para testes BDD (Behavior Driven Development), utilizado para escrever os testes em um formato legível.
- **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
- **Allure**: Ferramenta para geração de relatórios bonitos e interativos dos testes realizados.
- **WebDriver Manager**: Para gerenciar os drivers do navegador automaticamente.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

automacao-web/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── automacao/
│ │ │ ├── pages/
│ │ │ └── steps/
│ │ └── resources/
│ │ └── features/
│ └── test/
│ ├── java/
│ │ └── com/
│ │ └── automacao/
│ └── resources/
│ └── testng.xml
└── pom.xml

### Descrição dos Diretórios

- **src/main/java/com/automacao/pages**: Contém as classes de página do projeto, representando as telas e componentes da aplicação.
- **src/main/java/com/automacao/steps**: Contém os passos do Cucumber, que implementam os cenários de testes.
- **src/main/resources/features**: Contém os arquivos `.feature`, onde os cenários de testes são descritos em linguagem Gherkin.
- **src/test/resources/testng.xml**: Arquivo de configuração para o TestNG.

## Configuração do Projeto

### Pré-requisitos

1. **Java**: Versão 23 ou superior instalada.
2. **Maven**: Para gerenciar dependências e build.
3. **Android Studio**: Para configurar o ambiente Android e executar testes em dispositivos reais ou emuladores.
4. **Appium**: Certifique-se de que o Appium está instalado e configurado corretamente.

### Instalação

#### Instalando as Dependências

Dentro do diretório do projeto, execute o comando Maven para instalar as dependências:

```bash
mvn clean install
```

## Executando os Testes

Para executar os testes, use o seguinte comando Maven:

```bash
mvn test
```

## Relatórios

Os relatórios dos testes podem ser visualizados após a execução, usando o Allure. Para gerar e visualizar o relatório, execute:

```bash
mvn allure:serve
```

## Dependências no pom.xml

As principais dependências do projeto incluem:

Cucumber: Para testes BDD.
Selenium: Para integração com o navegador.
Allure: Para relatórios interativos.
WebDriver Manager: Para gerenciar os drivers do navegador automaticamente.

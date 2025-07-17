To‑Do List 
Um ambiente completo de desenvolvimento para criação de uma aplicação de lista de tarefas utilizando Liferay 7.4 e Java 17. Ideal para quem está aprendendo a desenvolver módulos no Liferay e deseja começar com um projeto bem estruturado.

Visão Geral
Este projeto foi desenvolvido para facilitar o desenvolvimento local de aplicações no Liferay, com foco na automação de build e deploy de módulos. Ele oferece:

Estrutura modular organizada por funcionalidade

Scripts para compilar e subir os módulos rapidamente

Ambiente configurado para Java 17

Suporte ao Service Builder para criação de portlets

Pré-requisitos
Antes de começar, certifique-se de ter os seguintes componentes instalados:

Java 17 ou superior

Liferay 7.4 GA123 configurado localmente

Gradle 7 ou superior (ou utilize o wrapper com ./gradlew)

Ant (necessário para o deploy dos módulos)

IDE compatível com OSGi (recomendado: IntelliJ IDEA ou Eclipse)

Como usar
Após realizar o deploy dos módulos, acesse o portal Liferay em:

http://localhost:8080

No menu de aplicativos (Widgets → Samples), procure por Task e utilize a aplicação.

Funcionalidades
Cadastro, edição e exclusão de tarefas

Hierarquia entre tarefas (seleção de tarefa pai)

Upload de imagens associadas às tarefas

Navegação intuitiva entre telas (voltar à lista, cancelar edição)

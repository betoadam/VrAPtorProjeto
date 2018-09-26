Aplicação monolitica com: 
	- vRaptor
	- Tomcat
	- bootstrap
	- JSTL
	
	TO DO List:
	
	Aplicação monolítica

		Objetivo: Criar a aplicação Web monolítica em três camadas (MVC) utilizando o framework VRaptor para controlar a navegação e a estrutura da aplicação.

		Tema: Portfólio pessoal. Deseja-se criar um sistema que permita organizar documentos e ofereça as seguintes funcionalidades:

			Cadastrar a atualizar documentos;																CONCLUIDO
			Categorizar o documento (a nível de sistema);													CONCLUIDO
			Definir tags para o documento (a nível de usuário).												CONCLUIDO
			
		Segurança:
			Permitir a autenticação;																		CONCLUIDO
			Criar níveis de acesso dentro da aplicação, como (Administrador e Usuário);						CONCLUIDO
			
		Model:
			Implementar as classes do modelo da aplicação:													CONCLUIDO
			Aplicar conceitos da orientação a objetos (atributos privados, métodos getters e setters);		CONCLUIDO
			Fazer validações dos atributos com anotações do Bean Validator;									CONCLUIDO
			
		Controller:
			Utilizar o framework VRaptor para controlar a aplicação;										CONCLUIDO
			Configurar os controladores para atuar com URLs em estilo REST;									CONCLUIDO
			Configurar o método de acesso HTTP nos métodos do controlador (@Get, @Post...) 					CONCLUIDO
			Utilizar validadores ao gravar dados de formulários;											CONCLUIDO
			
		View:
			JSP, JSTL.																						CONCLUIDO
			
		Navegação:
			Utilizar URLs de navegação amigáveis;															CONCLUIDO
			
		Exemplos;
			/carro (GET) -> Abre a lista de carros cadastrados;												CONCLUIDO
			/carro/novo (GET) -> Abre o formulário de cadastro dos carros;									CONCLUIDO
			/carro/2 (GET) -> Abre o formulário de edição do carro com ID 2;								CONCLUIDO
			/carro/save (POST) -> Salva o carro.															CONCLUIDO
			
			
			
			
			
			
			
			Métricas de avaliação:

				No aspecto geral, o sistema está funcionando/executando corretamente (20%)?					OK -> 100%
				Aplicou segurança de acesso no sistema (5%)?												OK -> sim com sistema de login
				Utiliza interceptadores (5%)?																OK -> utilizado para redirecionar em caso de usuario não logado
				As URLs estão amigáveis (5%)?																OK -> utilizado a notação @Path para fazer URLs amigaveis
				Permite cadastrar/visualizar/alterar e excluir documentos (15%)?							OK -> sim, sim, sim e sim respectivamente
				Permite definir a categoria do documento (5%)?												OK -> permite na tela de cadastro de documento
				Permite definir tags no documento (5%)?														OK -> permite na tela de cadastro de documento
				Utiliza algum redirecionamento (3%)?														OK -> redirecionamento apos salvar na base de dados para a tela de listagem
				Faz validação baseada no bean validator (5%)?												OK -> utilizado na realização dos cadastros e no login
				Faz validação no estilo fluído (pelo menos 1) (3%)?
				Aplicou restrições de métodos de acesso HTTP (@Get, @Post) (3%)?							OK -> sim nos metodos de gravação e listagem
				Bootstrap (utilização de componentes, layouts e conteúdo do framework)						OK
					Utiliza Alerts (1%)?
					Utiliza Badge (1%)?																		OK -> utilizado nos menus da navbar
					Utiliza Breadcrumb (1%)?																OK -> utilizado nas telas de cadastro e formularios
					Utiliza Button (1%)?																	OK -> utilizado nas telas de cadastro, formulario, login
					Utiliza navbar (1%)?																	OK -> utilizado em todas as telas
					Utiliza tooltips (1%)?																	OK -> utilizado nos botões dos formularios e na tela de login
				Aplicou em estilo em formulários e seus componentes (1%)?									OK -> sim, form-group e form-control
				Aplicou estilo em tabelas (1%)?																OK -> sim, table-striped, thead-dark
				Utilizou algum elemento diferente do bootstrap (1%)?										OK -> sim, utilizado jumbotrone carousel na homepage
				Está persistindo os dados no MongoDB (13%)?													OK -> sim todos os dados são persistidos
				O código-fonte foi colocado em um repositório GIT (4%)?										OK -> sim 
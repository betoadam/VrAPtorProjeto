Aplica��o monolitica com: 
	- vRaptor
	- Tomcat
	- bootstrap
	- JSTL
	
	TO DO List:
	
	Aplica��o monol�tica

		Objetivo: Criar a aplica��o Web monol�tica em tr�s camadas (MVC) utilizando o framework VRaptor para controlar a navega��o e a estrutura da aplica��o.

		Tema: Portf�lio pessoal. Deseja-se criar um sistema que permita organizar documentos e ofere�a as seguintes funcionalidades:

			Cadastrar a atualizar documentos;																CONCLUIDO
			Categorizar o documento (a n�vel de sistema);													CONCLUIDO
			Definir tags para o documento (a n�vel de usu�rio).												CONCLUIDO
			
		Seguran�a:
			Permitir a autentica��o;																		CONCLUIDO
			Criar n�veis de acesso dentro da aplica��o, como (Administrador e Usu�rio);						CONCLUIDO
			
		Model:
			Implementar as classes do modelo da aplica��o:													CONCLUIDO
			Aplicar conceitos da orienta��o a objetos (atributos privados, m�todos getters e setters);		CONCLUIDO
			Fazer valida��es dos atributos com anota��es do Bean Validator;									CONCLUIDO
			
		Controller:
			Utilizar o framework VRaptor para controlar a aplica��o;										CONCLUIDO
			Configurar os controladores para atuar com URLs em estilo REST;									CONCLUIDO
			Configurar o m�todo de acesso HTTP nos m�todos do controlador (@Get, @Post...) 					CONCLUIDO
			Utilizar validadores ao gravar dados de formul�rios;											CONCLUIDO
			
		View:
			JSP, JSTL.																						CONCLUIDO
			
		Navega��o:
			Utilizar URLs de navega��o amig�veis;															CONCLUIDO
			
		Exemplos;
			/carro (GET) -> Abre a lista de carros cadastrados;												CONCLUIDO
			/carro/novo (GET) -> Abre o formul�rio de cadastro dos carros;									CONCLUIDO
			/carro/2 (GET) -> Abre o formul�rio de edi��o do carro com ID 2;								CONCLUIDO
			/carro/save (POST) -> Salva o carro.															CONCLUIDO
			
			
			
			
			
			
			
			M�tricas de avalia��o:

				No aspecto geral, o sistema est� funcionando/executando corretamente (20%)?					OK -> 100%
				Aplicou seguran�a de acesso no sistema (5%)?												OK -> sim com sistema de login
				Utiliza interceptadores (5%)?																OK -> utilizado para redirecionar em caso de usuario n�o logado
				As URLs est�o amig�veis (5%)?																OK -> utilizado a nota��o @Path para fazer URLs amigaveis
				Permite cadastrar/visualizar/alterar e excluir documentos (15%)?							OK -> sim, sim, sim e sim respectivamente
				Permite definir a categoria do documento (5%)?												OK -> permite na tela de cadastro de documento
				Permite definir tags no documento (5%)?														OK -> permite na tela de cadastro de documento
				Utiliza algum redirecionamento (3%)?														OK -> redirecionamento apos salvar na base de dados para a tela de listagem
				Faz valida��o baseada no bean validator (5%)?												OK -> utilizado na realiza��o dos cadastros e no login
				Faz valida��o no estilo flu�do (pelo menos 1) (3%)?
				Aplicou restri��es de m�todos de acesso HTTP (@Get, @Post) (3%)?							OK -> sim nos metodos de grava��o e listagem
				Bootstrap (utiliza��o de componentes, layouts e conte�do do framework)						OK
					Utiliza Alerts (1%)?
					Utiliza Badge (1%)?																		OK -> utilizado nos menus da navbar
					Utiliza Breadcrumb (1%)?																OK -> utilizado nas telas de cadastro e formularios
					Utiliza Button (1%)?																	OK -> utilizado nas telas de cadastro, formulario, login
					Utiliza navbar (1%)?																	OK -> utilizado em todas as telas
					Utiliza tooltips (1%)?																	OK -> utilizado nos bot�es dos formularios e na tela de login
				Aplicou em estilo em formul�rios e seus componentes (1%)?									OK -> sim, form-group e form-control
				Aplicou estilo em tabelas (1%)?																OK -> sim, table-striped, thead-dark
				Utilizou algum elemento diferente do bootstrap (1%)?										OK -> sim, utilizado jumbotrone carousel na homepage
				Est� persistindo os dados no MongoDB (13%)?													OK -> sim todos os dados s�o persistidos
				O c�digo-fonte foi colocado em um reposit�rio GIT (4%)?										OK -> sim 
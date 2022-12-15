
# Sistema Colegial

Um sistema simples para organizar alunos e professores até o ensino médio.

Inicialmente, será necessário criar um usuário manualmente no banco de dados com permissões de ROLE_USER relacionando-o com a tabela tb_roles.

Inicie pela página de login '/colegial/SATO/login.html' para realizar o acesso e obter permissão para utilizar os métodos. Após o login, será redirecionado para uma página de bem-vindo com acesso às outras páginas.

Para criar outros usuários, utilize o endpoint de '/api/v1/users' utilizando o token gerado ao logar, ele será mostrado no console do seu navegador. Passe os parametros 'username', 'password', 'retypePassword' e 'admin', sendo este booleano (true/false).
# teste-unitario-refatoracao
Projeto criado para fazer uma POC sobre teste unitário. Objetivo é exemplificar como um código pode crescer de maneira desorganizada de maneira muito simples.


Implemente:

1 - Crie uma lógica para que:
- Quando a letra inicial do nome do usuário estiver em maiúsculo, o nome do usuário precisa ser gravado com todas as letras em minúsculo.
- Quando a letra inicial do nome do usuário estiver em minúsculo, o nome do usuário precisa ser gravado com todas as letras em maiúsculo.


2 - Crie uma lógica para que:
- Quando o nome começar com a letra Z, ele seja desconsiderado.
- Quando o nome começar com a letra A, ele precisa ser gravado com todas as letras em maiúsculo e todas as letras em minúsculo.


3 - Crie um teste para validar os 2 cenários.

4 - Terminar de implementar tente refatorar o código para ficar mais legível. 


UserService
    getUsers

    addUsers

    formatAndSaveUser

    formatAndSaveUserWithA - faltando teste

    formatOtherUsers - faltando teste


UserServiceTest
    getUsers

    addUser

    formatAndSaveUser
        userService.formatAndSaveUser
        userService.getUsers

    formatAndSaveUser
        getUsers

    formatAndSaveUser
        getUsers
    

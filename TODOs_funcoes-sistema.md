
FUNÇÕES DE CADA ENTIDADE:

Pessoa:
    atr:
        -itens a receber
    FIND: 
        -FindByCpf???
    ADD: anonimo
    UPDT, DISABLE: nos dados da pessoa que faz a ação

Funcionario:
    atr:
        -itens a entregar / entregas a fazer
    FIND:
        -FindByCpf???
    ADD: nos dados da pessoa que faz a ação
        -pessoa -> funcionario:
            -set empresa by CNPJ
            -supervisor é definido pela empresa/gerente
        -pessoa + funcionario
    UPDT, DELETE: nos dados da pessoa que faz a ação

Empresa:
    FIND:
        -findByCNPJ (criar cnpj para empresa/ substituir id?)
        -findAllCarrosByCNPJdaEmpresa: pelos funcionarios da empresa
        -findAllFuncionariosByCNPJdaEmpresa: pelos supervisores e gerente da empresa
    POST:
        -UpdtFuncionarioIdEmpresaByCPF Where funcionario empresa(cnpj) == empresa(cnpf)
    UPDT, DELETE: pela empresa ou administrador do sistema

Carro:
    FIND:
        -findByEmpresa???
    ADD, UPDT, DELETE pela empresa

Entrega:
    atr:
        -itens da entrega
        -entrega-trechos / trechos da entrega
    FIND: pelo entregador, supervisor e empresa
        -by entregador, by tipo-entrega?
    POST: pela empresa? supervisor?
        -definir quem é o entregador
        -definir quais trechos(entrega-trecho) ira tomar para entrega dos itens

Trecho/Entrega-Trecho:
    atr:
        -carro para entrega
    ADD: por quem? motorista? supervisor? empresa

Item:
    FIND:
        -findItemByLocalizador
    ADD: por quem? supervisor? empresa?

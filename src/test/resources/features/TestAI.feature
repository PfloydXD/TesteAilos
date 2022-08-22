Feature: Executar o teste do Desafio QA

  @test01
  Scenario: Testar login usuario bloqueado
    Given Acesso ao link de teste
    When informo login e senha
    Then valido a menssagem de erro

  @test02
  Scenario: Realizar compra completa com mais de um produto
    Given Acesso ao link de teste
    And realizo login
    And adiciono produtos ao carrinho
    When acesso o carrinho
    And preencho os campos necessarios
    Then valido a compra realizada com sucesso

  @test03
  Scenario: Validar valor total de compras
    Given Acesso ao link de teste
    And realizo login
    And adiciono todos os produtos ao carrinho
    When acesso o carrinho
    And preencho os campos necessarios
    Then valido valor total a ser pago

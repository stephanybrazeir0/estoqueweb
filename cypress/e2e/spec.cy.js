/// <reference types="cypress" />

describe("Novo Produto", () => {
  it("Cadastrar um produto", () => {
    cy.visit("http://localhost:8080/cadastrarProduto");

    cy.contains("Novo produto").click();
    cy.get("#descricao").type("Camiseta DACOMP");
    cy.get("#qtd").type(20);
    cy.get("#valor").type("50.00");

    cy.contains("button", "Salvar").click();
  });
});

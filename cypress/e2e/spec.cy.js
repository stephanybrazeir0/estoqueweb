/// <reference types="cypress" />

describe("Novo Produto", () => {
  it("Cadastrar um produto", () => {
    cy.visit("http://127.0.0.1:5500/");

    cy.contains("Novo produto").click();
    cy.get("#codigo").type("000001");
    cy.get("#descricao").type("Camiseta DACOMP");
    cy.get("#quantidade").type(20);
    cy.get("#tipo").select("Produto para revenda");
    cy.get("#venda").type("50.00");

    cy.contains("button", "Salvar").click();
  });
});

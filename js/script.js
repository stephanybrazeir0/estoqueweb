const openModalButton = document.querySelector("#open-modal");
const closeModalButton = document.querySelector("#close-modal");
const saveProduct = document.querySelector("#save-product");
const modal = document.querySelector("#modal-bg");
const fade = document.querySelector("#fade");

const toggleModal = () => {
  modal.classList.toggle("hide");
  fade.classList.toggle("hide");
};

[openModalButton, closeModalButton, fade].forEach((el) => {
  el.addEventListener("click", () => toggleModal());
});

////////////////////////////////////////////////////////////////////////

const filtro = document.querySelector('#buscar');

filtro.addEventListener('input', filtrarProdutos);

function filtrarProdutos(){
  let listaprods = document.querySelectorAll('#bodyTabela tr');
  console.log(listaprods);
  if(filtro.value != ''){
    console.log("entrou");
    for(let prod of listaprods){
      let desc = prod.querySelector('.descricaoProd');
      desc = desc.textContent.toLowerCase();
      let filtroDesc = filtro.value.toLowerCase();
      if(!desc.includes(filtroDesc)){
        prod.style.display = "none";
      }else{
        prod.style.display = "table-row";
      }
    }
  }else{
    for(let prod of listaprods){
      prod.style.display = "table-row";
    }
  }
}

//////////

const form = document.getElementById('formCadastro')

form.addEventListener('submit', event => {
  event.preventDefault();
  const formData = new FormData(form);
  const data = Object.fromEntries(formData);
  const url = new URL("http://localhost:8080/cadastrarProduto")

  fetch(url, {
    method: 'POST',
    headers: {
      'Content-type': 'application/json'
    },
    body: JSON.stringify(data)
  }).then(res => res.json()).then(data => {
    console.log(data);
    render();
    form.reset();
    toggleModal();
    alert("Produto adicionado com sucesso!");
  })
})

//////////

function deletaProduto(id){
  const url = new URL("http://localhost:8080/deletarProduto/"+id)

  fetch(url, {
    method: 'DELETE',
  }).then(res => {
    console.log(res);
    render();
    alert("Produto deletado com sucesso!");
  })
}

//////////

const bodyTabela = document.querySelector('#bodyTabela');

function render(){
  let body = '';
  const url = new URL("http://localhost:8080/listarProdutos")

  fetch(url)
  .then((response) => response.json())
  .then((produtos) => {

    if(produtos.length <= 0){
      body += '<div>Nenhum produto disponível</div>';
    }else{
      produtos.forEach((produto, index) => {
        body += `
          <tr >
            <td>${produto.codProduto}</td>
            <td class="descricaoProd">${produto.descricao}</td>
            <td>R$${produto.valor}</td>
            <td>${produto.qtd}</td>
            <td class="acoes">
              <button class="botao excluir" onclick="deletaProduto(${produto.codProduto})">Excluir</button>
            </td>
          </tr>
        `;
      });
      bodyTabela.innerHTML = body;
    }
  });
}

render();


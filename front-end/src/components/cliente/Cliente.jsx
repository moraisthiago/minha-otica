import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useState } from "react";
import Axios from "axios";

import "./Cliente.css";

function Cliente() {
  const url = "http://localhost:3001/cliente";
  const [cliente, setCliente] = useState({});

  //   function submit(event) {
  //     event.preventDefault();
  //     Axios.post(url, cliente).then((r) => {
  //       setCliente({});
  //       console.log(r);
  //     });
  //   }

  function submit(e) {
    e.preventDefault();

    Axios.get(url + `?cpf=${cliente.cpf}`)
      .then((cpf) => {
        if (cpf.data.length === 0) {
          //Se o e-mail não existir
          Axios.post(url, cliente)
            .then(() => {
              setCliente({});
              alert("Cadastro realizado com sucesso!");
            })
            .catch((error) => {
              console.log(error);
            });
        } else {
          alert("CPF já cadastrado!");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setCliente((values) => ({ ...values, [name]: value }));
  };

  return (
    <Container id="main-container" className="d-grid h-100">
      <Form
        onSubmit={(event) => submit(event)}
        id="cliente-form"
        className="text-center p-3 w-100"
      >
        <h1 className="mb-3 fs-3 fw-normal">Cadastrar Cliente</h1>

        <Form.Group className="mb-3" controlId="nome">
          <Form.Control
            className="position-relative"
            required
            type="text"
            name="nome"
            placeholder="Nome"
            autoComplete="nome"
            size="lg"
            value={cliente.nome || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="cliente-telefone">
          <Form.Control
            className="position-relative"
            required
            type="text"
            name="telefone"
            placeholder="Telefone"
            autoComplete="telefone"
            size="lg"
            value={cliente.telefone || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="cliente-cpf">
          <Form.Control
            className="position-relative"
            type="text"
            required
            name="cpf"
            placeholder="CPF"
            autoComplete="cpf"
            size="lg"
            value={cliente.cpf || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="cliente-endereco">
          <Form.Control
            className="position-relative"
            required
            type="text"
            name="endereco"
            placeholder="Endereço"
            autoComplete="endereco"
            size="lg"
            value={cliente.endereco || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <div className="d-grid">
          <Button type="submit" variant="primary" size="lg">
            Cadastrar
          </Button>
        </div>

        <p className="mt-5 text-muted">&copy; Minha Ótica, 2022</p>
      </Form>
    </Container>
  );
}

export default Cliente;

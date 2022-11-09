import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Table from "react-bootstrap/Table";
import { useState, useEffect } from "react";
// import { IMaskInput } from "react-imask";
import Axios from "axios";

import "./Cliente.css";
import ModalCliente from "../modal/ModalCliente";
import ClienteUpdate from "../teste/Modal/ClienteUpdate";

function Cliente() {
  const url = "http://localhost:8080/cliente";
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
          //Se o CPF não existir
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

  const [data, setData] = useState([]);

  useEffect(() => {
    Axios.get(url).then((json) => setData(json.data));
  }, []);

  console.log(data);

  const renderTable = () => {
    return data?.map((cliente) => {
      return (
        <tr key={cliente.id}>
          <td>{cliente.name}</td>
          <td>{cliente.dateBirth}</td>
          <td>{cliente.cpf}</td>
          <td>{cliente.phone}</td>
          <td>
            <ClienteUpdate
              id={cliente.id}
              show={modalShow}
              onHide={() => setModalShow(false)}
            />
          </td>
          <td>
            {" "}
            <Button onClick={() => handleDelete(cliente.id)}> 🗑️ </Button>{" "}
          </td>
        </tr>
      );
    });
  };
  const [modalShow, setModalShow] = useState(false);

  const handleDelete = (id) => {
    Axios.delete(`${url}/${id}`).then(() => {
      setData((cliente) => [
        ...cliente.filter((nutricionista) => nutricionista.id !== id),
      ]);
      alert("Registro apagado com sucesso!");
    });
  };

  return (
    <Container id="main-container" className="d-grid h-100">
      {/* <Form
        onSubmit={(event) => submit(event)}
        id="cliente-form"
        className="text-center p-3 w-100"
      >
        <h1 className="mb-3 fs-3 fw-normal">Cadastrar Cliente</h1>

        <Form.Group className="mb-3" controlId="cliente-nome">
          <Form.Label>Nome</Form.Label>
          <Form.Control
            className="position-relative"
            required
            minLength={5}
            type="text"
            name="name"
            // placeholder="Insira o nome do cliente"
            autoComplete="nome"
            size="lg"
            value={cliente.name || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="cliente-dateBirth">
          <Form.Label>Data de Nascimento</Form.Label>
          <Form.Control
            className="position-relative"
            required
            type="date"
            name="dateBirth"
            autoComplete="dateBirth"
            size="lg"
            value={cliente.dateBirth || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="cliente-cpf">
          <Form.Label>CPF</Form.Label>
          <Form.Control
            className="position-relative"
            required
            minLength={11}
            maxLength={11}
            type="text"
            name="cpf"
            // as={IMaskInput}
            // mask="000.000.000-00"
            // placeholder="Insira o CPF do cliente"
            autoComplete="cpf"
            size="lg"
            value={cliente.cpf || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="cliente-telefone">
          <Form.Label>Telefone</Form.Label>
          <Form.Control
            className="position-relative"
            required
            minLength={11}
            maxLength={11}
            type="text"
            name="phone"
            // placeholder="Telefone"
            autoComplete="telefone"
            size="lg"
            value={cliente.phone || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <div className="d-grid">
          <Button type="submit" variant="primary" size="lg">
            Cadastrar
          </Button>
        </div>

        <p className="mt-5 text-muted">&copy; Minha Ótica, 2022</p>
      </Form> */}

      <Table striped bordered hover>
        <thead>
          <tr>
            <th scope="row">Nome</th>
            <th scope="row">Nascimento</th>
            <th scope="row">CPF</th>
            <th scope="row">Telefone</th>
          </tr>
        </thead>
        <tbody>{renderTable()}</tbody>
      </Table>
    </Container>
  );
}

export default Cliente;

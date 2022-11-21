import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import Table from "react-bootstrap/Table";
import { useState, useEffect } from "react";
// import { IMaskInput } from "react-imask";
import Axios from "axios";

import ModalCliente from "../modal/ModalCliente";

function ListarClientes() {
  const url = "http://localhost:8080/cliente";

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
          <td>{cliente.birthDate}</td>
          <td>{cliente.cpf}</td>
          <td>{cliente.phone}</td>
          <td>
            <ModalCliente
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
      <h2>Lista de Clientes</h2>
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

export default ListarClientes;

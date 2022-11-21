import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import Table from "react-bootstrap/Table";
import { useState, useEffect } from "react";
import Axios from "axios";

import ModalOtica from "../modal/ModalOtica";

function ListarOticas() {
  const url = "http://localhost:8080/otica";

  const [data, setData] = useState([]);

  useEffect(() => {
    Axios.get(url).then((json) => setData(json.data));
  }, []);

  const renderTable = () => {
    return data?.map((otica) => {
      return (
        <tr key={otica.id}>
          <td>{otica.name}</td>
          <td>{otica.cnpj}</td>
          <td>{otica.ownerName}</td>
          <td>{otica.managerName}</td>
          <td>
            <ModalOtica
              id={otica.id}
              show={modalShow}
              onHide={() => setModalShow(false)}
            />
          </td>
          <td>
            {" "}
            <Button onClick={() => handleDelete(otica.id)}> 🗑️ </Button>{" "}
          </td>
        </tr>
      );
    });
  };
  const [modalShow, setModalShow] = useState(false);

  const handleDelete = (id) => {
    Axios.delete(`${url}/${id}`).then(() => {
      setData((clientes) => [
        ...clientes.filter((cliente) => cliente.id !== id),
      ]);
      alert("Registro apagado com sucesso!");
    });
  };

  return (
    <Container id="main-container" className="d-grid h-100">
      <h2>Lisa de Óticas</h2>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th scope="row">Nome</th>
            <th scope="row">CNPJ</th>
            <th scope="row">Proprietário</th>
            <th scope="row">Gerente</th>
          </tr>
        </thead>
        <tbody>{renderTable()}</tbody>
      </Table>
    </Container>
  );
}

export default ListarOticas;

import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from "react";
import Axios from "axios";

import "./Otica.css";
import ModalOtica from "../modal/ModalOtica";

function Otica() {
  const url = "http://localhost:3001/oticas";
  const [otica, setOtica] = useState({});

  //   function submit(event) {
  //     event.preventDefault();
  //     Axios.post(url, cliente).then((r) => {
  //       setCliente({});
  //       console.log(r);
  //     });
  //   }

  function submit(e) {
    e.preventDefault();

    Axios.get(url + `?cnpj=${otica.cnpj}`)
      .then((cnpj) => {
        if (cnpj.data.length === 0) {
          Axios.post(url, otica)
            .then(() => {
              setOtica({});
              alert("Cadastro realizado com sucesso!");
            })
            .catch((error) => {
              console.log(error);
            });
        } else {
          alert("CNPJ já cadastrado!");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setOtica((values) => ({ ...values, [name]: value }));
  };

  const [data, setData] = useState([]);

  useEffect(() => {
    Axios.get(url)
      .then(json => setData(json.data))
  }, [])

  const renderTable = () => {
    return data?.map(otica => {
      return (
        <tr key={otica.id}>
          <td>{otica.nome}</td>
          <td>{otica.cnpj}</td>
          <td>{otica.proprietario}</td>
          <td>
            <ModalOtica id={otica.id} show={modalShow} onHide={() => setModalShow(false)} />
          </td>
          <td> <Button onClick={() => handleDelete(otica.id)} > 🗑️ </Button> </td>
        </tr>
      )
    }
    )
  }
  const [modalShow, setModalShow] = useState(false);


  const handleDelete = (id) => {
    Axios.delete(`${url}/${id}`)
      .then(() => {
        setData(cliente => [
          ...cliente.filter(nutricionista => nutricionista.id !== id),
        ]);
        alert('Registro apagado com sucesso!');
      })
  };

  return (
    <Container id="main-container" className="d-grid h-100">
      <Form
        onSubmit={(event) => submit(event)}
        id="otica-form"
        className="text-center p-3 w-100"
      >
        <h1 className="mb-3 fs-3 fw-normal">Cadastrar Ótica</h1>

        <Form.Group className="mb-3" controlId="otica-nome">
          <Form.Control
            className="position-relative"
            required
            type="text"
            name="nome"
            placeholder="Nome da ótica"
            autoComplete="nome"
            size="lg"
            value={otica.nome || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="otica-cnpj">
          <Form.Control
            className="position-relative"
            required
            type="text"
            name="cnpj"
            placeholder="CNPJ"
            autoComplete="cnpj"
            size="lg"
            value={otica.cnpj || ""}
            onChange={handleChange}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="otica-proprietario">
          <Form.Control
            className="position-relative"
            type="text"
            required
            name="proprietario"
            placeholder="Proprietario"
            autoComplete="proprietario"
            size="lg"
            value={otica.proprietario || ""}
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

      <Table striped bordered hover>
        <thead>
          <tr>
            <th scope="row">Nome</th>
            <th scope="row">CNPJ</th>
            <th scope="row">Proprietário</th>
          </tr>
        </thead>
        <tbody>
          {renderTable()}
        </tbody>
      </Table>
    </Container>
  );
}

export default Otica;

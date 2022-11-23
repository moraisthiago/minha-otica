import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from "react";
import Axios from "axios";

import "./Lente.css";
import ModalLente from "../modal/ModalLente";

function Lente() {
    const url = "http://localhost:3001/lentes";
    const [lente, setLente] = useState({});

    function submit(event) {
        event.preventDefault();
        Axios.post(url, lente).then((r) => {
            setLente({});
            alert("Cadastro realizado com sucesso!");
        });
    }


    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setLente((values) => ({ ...values, [name]: value }));
    };

    const [data, setData] = useState([]);

  useEffect(() => {
    Axios.get(url)
      .then(json => setData(json.data))
  }, [])

  const renderTable = () => {
    return data?.map(lente => {
      return (
        <tr key={lente.id}>
          <td>{lente.tipo}</td>
          <td>{lente.valor}</td>
          <td>{lente.laboratorio}</td>
          <td>
            <ModalLente id={lente.id} show={modalShow} onHide={() => setModalShow(false)} />
          </td>
          <td> <Button onClick={() => handleDelete(lente.id)} > 🗑️ </Button> </td>
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
                id="lente-form"
                className="text-center p-3 w-100"
            >
                <h1 className="mb-3 fs-3 fw-normal">Cadastrar Lente</h1>

                <Form.Group className="mb-3" controlId="lente-tipo">
                    <Form.Control
                        className="position-relative"
                        required
                        type="text"
                        name="tipo"
                        placeholder="Tipo"
                        autoComplete="tipo"
                        size="lg"
                        value={lente.tipo || ""}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="lente-valor">
                    <Form.Control
                        className="position-relative"
                        required
                        type="text"
                        placeholder="Valor R$"
                        autoComplete="valor"
                        size="lg"
                        value={lente.valor || ""}
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="lente-laboratorio">
                    <Form.Control
                        className="position-relative"
                        type="text"
                        required
                        name="laboratorio"
                        placeholder="Laboratório"
                        autoComplete="laboratorio"
                        size="lg"
                        value={lente.laboratorio || ""}
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
                        <th scope="row">Tipo</th>
                        <th scope="row">Valor</th>
                        <th scope="row">Laboratório</th>
                    </tr>
                </thead>
                <tbody>
                    {renderTable()}
                </tbody>
            </Table>
        </Container>
    );
}

export default Lente;

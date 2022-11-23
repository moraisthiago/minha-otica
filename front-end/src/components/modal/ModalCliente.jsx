import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Modal from "react-bootstrap/Modal";
import Axios from "axios";

export default function ModalCliente({ id }) {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const url = "http://localhost:8080/cliente";
  const [values, setValues] = useState({});

  useEffect(() => {
    Axios
      .get(url + "/" + id)
      .then((response) => {
        setValues(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  function updatePost() {
    Axios
      .put(url + "/" + id, values)
      .then((response) => {
        setValues(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function handleChange(event) {
    const name = event.target.name;
    const value = event.target.value;
    setValues((values) => ({ ...values, [name]: value }));
  }

  return (
    <>
      <Button onClick={handleShow}>✍️</Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Atualizar Cliente</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form onSubmit={(event) => updatePost(event)}>
            <Form.Group className="mb-6">
              <label>Nome</label>
              <input
                onChange={(event) => handleChange(event)}
                required
                minLength={5}
                id="name"
                name="name"
                type="text"
                className="form-control"
                value={values.name}
                placeholder="Nome do cliente"
              />
            </Form.Group>

            <Form.Group className="mb-6">
              <label>Endereço</label>
              <input
                onChange={(event) => handleChange(event)}
                required
                id="birthDate"
                name="birthDate"
                type="date"
                className="form-control"
                value={values.birthDate}
                placeholder="Endereço"
              />
            </Form.Group>

            <Form.Group className="mb-6">
              <label>CPF</label>
              <input
                onChange={(event) => handleChange(event)}
                required
                minLength={11}
                maxLength={11}
                id="cpf"
                name="cpf"
                type="text"
                className="form-control"
                value={values.cpf}
                placeholder="CPF"
              />
            </Form.Group>

            <Form.Group className="mb-6">
              <label>Telefone</label>
              <input
                onChange={(event) => handleChange(event)}
                required
                minLength={11}
                maxLength={11}
                id="phone"
                name="phone"
                type="text"
                className="form-control"
                value={values.phone}
                placeholder="Telefone"
              />
            </Form.Group>

            <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                Fechar
              </Button>
              <Button
                type="submit"
                variant="primary"
                // onClick={handleClose}
              >
                Salvar
              </Button>
            </Modal.Footer>
          </Form>
        </Modal.Body>
      </Modal>
    </>
  );
}

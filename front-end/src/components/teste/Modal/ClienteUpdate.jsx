import React, { useState, useEffect } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { cpf } from "cpf-cnpj-validator";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import Axios from "axios";

export default function ClienteUpdate({ id }) {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const url = "http://localhost:8080/cliente";
  const [values, setValues] = useState({});

  useEffect(() => {
    Axios.get(url + "/" + id)
      .then((response) => {
        setValues(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  function updatePost() {
    Axios.put(url + "/" + id, values)
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

  const LoginSchema = Yup.object().shape({
    name: Yup.string()
      .min(5, "O nome deve conter, pelo menos, 5 caracteres")
      .required("Insira um nome"),
    dateBirth: Yup.string().required("Insira uma data"),
    cpf: Yup.string()
      .min(11, "O CPF deve conter 11 números")
      .max(11, "O CPF deve conter 11 números")
      .required("Insira um CPF")
      .test((value) => cpf.isValid(value)),
    phone: Yup.string("Apenas números")
      .min(11, "DDD + Número")
      .max(11, "Número inválido")
      .required("Insira um telefone"),
  });

  return (
    <>
      <Button onClick={handleShow}>✍️</Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Atualizar Cliente</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Formik
            initialValues={{ name: "", dateBirth: "", cpf: "", phone: "" }}
            validationSchema={LoginSchema}
            onSubmit={(values) => {
              console.log(values);

              Axios.put(url + "/" + id, values)
                .then((response) => {
                  setValues(response.data);
                })
                .catch((error) => {
                  console.log(error);
                });
            }}
          >
            {({ touched, errors }) => (
              <div>
                <Form>
                  <div className="form-group">
                    <label htmlFor="name">Nome</label>
                    <Field
                      onChange={(event) => handleChange(event)}
                      type="text"
                      name="name"
                      placeholder="Insira o nome do cliente"
                      className={`mt-2 form-control
                          ${touched.name && errors.name ? "is-invalid" : ""}`}
                    />

                    <ErrorMessage
                      component="div"
                      name="name"
                      className="invalid-feedback"
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="dateBirth">Data de Nascimento</label>
                    <Field
                      onChange={(event) => handleChange(event)}
                      type="date"
                      name="dateBirth"
                      className={`mt-2 form-control
                          ${
                            touched.dateBirth && errors.dateBirth
                              ? "is-invalid"
                              : ""
                          }`}
                    />

                    <ErrorMessage
                      component="div"
                      name="dateBirth"
                      className="invalid-feedback"
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="cpf">CPF</label>
                    <Field
                      onChange={(event) => handleChange(event)}
                      type="text"
                      name="cpf"
                      placeholder="Insira o CPF sem pontos ou traços"
                      className={`mt-2 form-control
                          ${touched.cpf && errors.cpf ? "is-invalid" : ""}`}
                    />

                    <ErrorMessage
                      component="div"
                      name="cpf"
                      className="invalid-feedback"
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="phone">Telefone</label>
                    <Field
                      onChange={(event) => handleChange(event)}
                      type="text"
                      name="phone"
                      placeholder="Insira o telefone"
                      className={`mt-2 form-control
                          ${touched.phone && errors.phone ? "is-invalid" : ""}`}
                    />

                    <ErrorMessage
                      component="div"
                      name="phone"
                      className="invalid-feedback"
                    />
                  </div>

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
              </div>
            )}
          </Formik>
        </Modal.Body>
      </Modal>
    </>
  );
}

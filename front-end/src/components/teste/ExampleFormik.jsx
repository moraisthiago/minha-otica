import React from "react";
import Container from "react-bootstrap/Container";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as yup from "yup";
import { cpf } from "cpf-cnpj-validator";
import { useState } from "react";
import Axios from "axios";

import "./ExampleFormik.css";

function ExampleFormik() {
  const url = "http://localhost:8080/cliente";
  const [cliente, setCliente] = useState({});

  function submit(event) {
    event.preventDefault();
    Axios.post(url, cliente).then((r) => {
      setCliente({});
      console.log(r);
    });
  }
  const Schema = yup.object({
    cpf: yup
      .string()
      .required("CPF is required")
      .test((value) => cpf.isValid(value)),
  });

  return (
    <Container id="main-container">
      <Formik
        onSubmit={(event) => submit(event)}
        id="formik"
        initialValues={{ cpf: "" }}
        validationSchema={Schema}
      >
        <div>
          <h1>CPF</h1>
          <Form>
            <div>
              <Field
                name="cpf"
                placeholder="Number CPF"
                value={cliente.cpf || ""}
              />
              <ErrorMessage component="div" name="cpf" />
            </div>
            <button type="submit">Submit</button>
          </Form>
        </div>
      </Formik>
    </Container>
  );
}
export default ExampleFormik;

import React from "react";
import Container from "react-bootstrap/Container";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { cpf } from "cpf-cnpj-validator";
import Axios from "axios";
import "bootstrap/dist/css/bootstrap.css";

import "./CadastrarCliente.css"
import ListarClientes from "./ListarClientes";


const LoginSchema = Yup.object().shape({
  name: Yup.string()
    .min(5, "O nome deve conter, pelo menos, 5 caracteres")
    .required("Insira um nome"),
  birthDate: Yup.string().required("Insira uma data"),
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

class CadastrarCliente extends React.Component {
  render() {
    const url = "http://localhost:8080/cliente";
    return (
      <Container id="main-container" className="d-grid h-100">
        <div id="cliente-form" className="p-3 w-100">
          <Formik
            initialValues={{ name: "", birthDate: "", cpf: "", phone: "" }}
            validationSchema={LoginSchema}
            onSubmit={(values) => {
              console.log(values);

              Axios.post(url, values)
                .then(() => {
                  alert("Cadastro realizado com sucesso!");
                })
                .catch((error) => {
                  console.log(error);
                });
            }}
          >
            {({ touched, errors }) => (
              <div>
                <div className="col-lg-12 text-center">
                  <h1 className="mt-5">Cadastrar Cliente</h1>
                </div>

                <Form>
                  <div className="form-group">
                    <label htmlFor="name">Nome</label>

                    <Field
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
                    <label htmlFor="birthDate">Data de Nascimento</label>
                    <Field
                      type="date"
                      name="birthDate"
                      className={`mt-2 form-control
                          ${
                            touched.birthDate && errors.birthDate
                              ? "is-invalid"
                              : ""
                          }`}
                    />

                    <ErrorMessage
                      component="div"
                      name="birthDate"
                      className="invalid-feedback"
                    />
                  </div>

                  <div className="form-group">
                    <label htmlFor="cpf">CPF</label>
                    <Field
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

                  <div className="text-center">
                    <button
                      style={{
                        "min-width": "130px",
                      }}
                      type="submit"
                      className="mt-5 btn btn-primary btn-block"
                    >
                      Cadastrar
                    </button>
                  </div>
                </Form>
              </div>
            )}
          </Formik>
        </div>
        <ListarClientes></ListarClientes>
      </Container>
    );
  }
}

export default CadastrarCliente;

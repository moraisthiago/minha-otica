import React from "react";
import Container from "react-bootstrap/Container";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { cnpj } from "cpf-cnpj-validator";
import Axios from "axios";
import "bootstrap/dist/css/bootstrap.css";

import "./CadastrarOtica.css";
import ListarOticas from "./ListarOticas";

const LoginSchema = Yup.object().shape({
  name: Yup.string()
    .min(5, "O nome deve conter, pelo menos, 5 caracteres")
    .required("Insira um nome"),
  cnpj: Yup.string()
    .min(14, "O CNPJ deve conter 14 números")
    .max(14, "O CNPJ deve conter 14 números")
    .required("Insira um CNPJ")
    .test((value) => cnpj.isValid(value)),
  ownerName: Yup.string()
    .min(5, "O nome deve conter, pelo menos, 5 caracteres")
    .required("Insira um nome"),
  managerName: Yup.string()
    .min(5, "O nome deve conter, pelo menos, 5 caracteres")
    .required("Insira um nome"),
});

class CadastrarOtica extends React.Component {
  render() {
    const url = "http://localhost:8080/otica";
    return (
      <Container id="main-container" className="d-grid h-100">
        <div id="otica-form" className="p-3 w-100">
          <div className="row">
            <div className="col-lg-12">
              <Formik
                initialValues={{ name: "", cnpj: "", ownerName: "" }}
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
                      <h1 className="mt-5">Cadastrar Ótica</h1>
                    </div>
                    
                    <Form>
                      <div className="form-group">
                        <label htmlFor="name">Nome da Ótica</label>
                        <Field
                          type="text"
                          name="name"
                          placeholder="Insira o nome da ótica"
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
                        <label htmlFor="cnpj">CNPJ</label>
                        <Field
                          type="text"
                          name="cnpj"
                          placeholder="Insira o CNPJ sem pontos ou traços"
                          className={`mt-2 form-control
                          ${touched.cnpj && errors.cnpj ? "is-invalid" : ""}`}
                        />

                        <ErrorMessage
                          component="div"
                          name="cnpj"
                          className="invalid-feedback"
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="ownerName">Proprietário</label>
                        <Field
                          type="text"
                          name="ownerName"
                          placeholder="Insira o o nome do proprietáio"
                          className={`mt-2 form-control
                          ${
                            touched.ownerName && errors.ownerName
                              ? "is-invalid"
                              : ""
                          }`}
                        />

                        <ErrorMessage
                          component="div"
                          name="ownerName"
                          className="invalid-feedback"
                        />
                      </div>

                      <div className="form-group">
                        <label htmlFor="managerName">Gerente</label>
                        <Field
                          type="text"
                          name="managerName"
                          placeholder="Insira o nome do proprietáio"
                          className={`mt-2 form-control
                          ${
                            touched.managerName && errors.managerName
                              ? "is-invalid"
                              : ""
                          }`}
                        />

                        <ErrorMessage
                          component="div"
                          name="managerName"
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
          </div>
        </div>
        <ListarOticas></ListarOticas>
      </Container>
    );
  }
}

export default CadastrarOtica;

import React from "react";
import Container from "react-bootstrap/Container";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { cnpj } from "cpf-cnpj-validator";
import Axios from "axios";
import "bootstrap/dist/css/bootstrap.css";

const LoginSchema = Yup.object().shape({
  name: Yup.string()
    .min(5, "O nome deve conter, pelo menos, 5 caracteres")
    .required("Insira um nome"),
  cnpj: Yup.string()
    .min(14, "O CNPJ deve conter 14 números")
    .max(14, "O CNPJ deve conter 14 números")
    .required("Insira um CNPJ")
    .test((value) => cnpj.isValid(value)),
  owner: Yup.string()
    .min(5, "O nome deve conter, pelo menos, 5 caracteres")
    .required("Insira um nome"),
});

class OticaExample extends React.Component {
  render() {
    const url = "http://localhost:8080/otica";
    return (
      <Container id="main-container">
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <Formik
                initialValues={{ name: "", cnpj: "", owner: "" }}
                validationSchema={LoginSchema}
                onSubmit={(values) => {
                  console.log(values);

                  Axios.get(url + `?cnpj=${values.cnpj}`)
                    .then((cnpj) => {
                      if (cnpj.data.length === 0) {
                        Axios.post(url, values)
                          .then(() => {
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
                }}
              >
                {({ touched, errors }) => (
                  <div>
                    <div className="row mb-5">
                      <div className="col-lg-12 text-center">
                        <h1 className="mt-5">Cadastrar Ótica</h1>
                      </div>
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
                        <label htmlFor="owner">Proprietário</label>
                        <Field
                          type="text"
                          name="owner"
                          placeholder="Insira o o nome do proprietáio"
                          className={`mt-2 form-control
                          ${touched.owner && errors.owner ? "is-invalid" : ""}`}
                        />

                        <ErrorMessage
                          component="div"
                          name="owner"
                          className="invalid-feedback"
                        />
                      </div>

                      <button
                        type="submit"
                        className="btn btn-primary btn-block mt-4"
                      >
                        Cadastrar
                      </button>
                    </Form>
                  </div>
                )}
              </Formik>
            </div>
          </div>
        </div>
      </Container>
    );
  }
}

export default OticaExample;

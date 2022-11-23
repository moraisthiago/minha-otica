import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import Axios from "axios";

export default function ModalOtica({ id }) {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const url = "http://localhost:8080/otica";
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
        setValues(values => ({ ...values, [name]: value }))
    }

    return (
        <>
            <Button onClick={handleShow}>
                ✍️
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Atualizar Ótica</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={(event) => updatePost(event)}>
                        <Form.Group className="mb-6">
                            <label>Nome</label>
                            <input onChange={(event) => handleChange(event)}
                                id='name' name='name' type='text' className='form-control'
                                value={values.name} placeholder='Nome da ótica' />
                        </Form.Group>

                        <Form.Group className="mb-6">
                            <label>CNPJ</label>
                            <input onChange={(event) => handleChange(event)}
                                id='cnpj' name='cnpj' type='text' className='form-control'
                                value={values.cnpj} placeholder='CNPJ' />
                        </Form.Group>

                        <Form.Group className="mb-6">
                            <label>Proprietário</label>
                            <input onChange={(event) => handleChange(event)}
                                id='ownerName' name='ownerName' type='text' className='form-control'
                                value={values.ownerName} placeholder='Nome do proprietário' />
                        </Form.Group>

                        <Form.Group className="mb-6">
                            <label>Gerente</label>
                            <input onChange={(event) => handleChange(event)}
                                id='managerName' name='managerName' type='text' className='form-control'
                                value={values.managerName} placeholder='Nome do proprietário' />
                        </Form.Group>

                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>
                                Fechar
                            </Button>
                            <Button type="submit" variant="primary" onClick={handleClose}>
                                Salvar
                            </Button>
                        </Modal.Footer>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    );
}
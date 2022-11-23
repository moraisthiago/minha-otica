import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import axios from "axios";

export default function ModalLente({ id }) {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const baseUrl = "http://localhost:3001/lentes";
    const [values, setValues] = useState({});

    useEffect(() => {
        axios.get(baseUrl + "/" + id)
            .then((response) => {
                setValues(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    }, [id]);

    function updatePost() {
        axios.put(baseUrl + "/" + id, values)
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
                    <Modal.Title>Atualizar Lente</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={(event) => updatePost(event)}>
                        <Form.Group className="mb-6">
                            <label>Tipo</label>
                            <input onChange={(event) => handleChange(event)}
                                id='tipo' name='tipo' type='text' className='form-control'
                                value={values.tipo} placeholder='Tipo da lente' />
                        </Form.Group>

                        <Form.Group className="mb-6">
                            <label>Valor</label>
                            <input onChange={(event) => handleChange(event)}
                                id='valor' name='valor' type='text' className='form-control'
                                value={values.valor} placeholder='Valor' />
                        </Form.Group>

                        <Form.Group className="mb-6">
                            <label>Laboratório</label>
                            <input onChange={(event) => handleChange(event)}
                                id='laboratório' name='laboratório' type='text' className='form-control'
                                value={values.laboratorio} placeholder='Laboratório' />
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
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import CadastrarCliente from "../Cliente/CadastrarCliente";

import Header from "../header/Header";
import CadastrarOtica from "../Otica/CadastrarOtica";


function Rotas() {
  return (
    <BrowserRouter>
      <Header></Header>
      <Routes>
        <Route path="/" exact element={<CadastrarCliente />} />
        <Route path="/cliente/cadastro" element={<CadastrarCliente />} />
        <Route path="/otica/cadastro" element={<CadastrarOtica />} />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;

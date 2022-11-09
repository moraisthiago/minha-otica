import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Cliente from "../cliente/Cliente";
import Header from "../header/Header";
import Lente from "../lente/Lente";
import Otica from "../otica/Otica";
import ClienteExample from "../teste/Cliente/ClienteExample";
import OticaExample from "../teste/Otica/OticaExample";

function Rotas() {
  return (
    <BrowserRouter>
      <Header></Header> 
      <Routes>
        <Route path="/" exact element={<Cliente />} />
        <Route path="/cliente/cadastro" element={<ClienteExample />} />
        <Route path="/cliente/listar" element={<Cliente />} />
        <Route path="/lente/listar" element={<Lente />} />
        <Route path="/otica/cadastro" element={<OticaExample />} />
        <Route path="/otica/listar" element={<Otica />} />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;

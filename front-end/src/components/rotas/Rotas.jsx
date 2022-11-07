import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Cliente from "../cliente/Cliente";
import Header from "../header/Header";
import Lente from "../lente/Lente";
import Otica from "../otica/Otica";

function Rotas() {
  return (
    <BrowserRouter>
      <Header></Header> 
      <Routes>
        <Route path="/" exact element={<Cliente />} />
        <Route path="/clientes" element={<Cliente />} />
        <Route path="/lentes" element={<Lente />} />
        <Route path="/oticas" element={<Otica />} />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;

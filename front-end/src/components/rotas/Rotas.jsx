import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Cliente from "../cliente/Cliente";
import Header from "../header/Header";

function Rotas() {
  return (
    <BrowserRouter>
      <Header></Header> 
      <Routes>
        <Route path="/" exact element={<Cliente />} />
        <Route path="/cliente" element={<Cliente />} />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;

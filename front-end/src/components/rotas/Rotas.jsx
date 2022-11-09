import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Cliente from "../cliente/Cliente";
import Header from "../header/Header";
import Lente from "../lente/Lente";
import Otica from "../otica/Otica";
import ExampleFormik from "../teste/ExampleFormik";

function Rotas() {
  return (
    <BrowserRouter>
      <Header></Header> 
      <Routes>
        <Route path="/" exact element={<Cliente />} />
        <Route path="/formik" element={<ExampleFormik />} />
        <Route path="/cliente" element={<Cliente />} />
        <Route path="/lente" element={<Lente />} />
        <Route path="/otica" element={<Otica />} />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;

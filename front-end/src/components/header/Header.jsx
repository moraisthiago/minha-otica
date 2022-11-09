import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { NavLink } from "react-router-dom";

function Header() {
  return (
    <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand>Minha Ótica</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav>
            <NavLink className="nav-link" to="/cliente/cadastro">
              Cadastrar Cliente
            </NavLink>
          </Nav>
          <Nav>
            <NavLink className="nav-link" to="/cliente/listar">
              Listar Clientes
            </NavLink>
          </Nav>
          {/* <Nav>
            <NavLink className="nav-link" to="/lente/listar">
              Listar Lentes
            </NavLink>
          </Nav> */}
          <Nav>
            <NavLink className="nav-link" to="/otica/cadastro">
              Cadastrar Ótica
            </NavLink>
          </Nav>
          <Nav>
            <NavLink className="nav-link" to="/otica/listar">
              Listar Óticas
            </NavLink>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;

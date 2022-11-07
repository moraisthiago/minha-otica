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
            <NavLink className="nav-link" to="/clientes" >Cliente</NavLink>
          </Nav>
          <Nav>
            <NavLink className="nav-link" to="/lentes" >Lente</NavLink>
          </Nav>
          <Nav>
            <NavLink className="nav-link" to="/oticas" >Ótica</NavLink>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;

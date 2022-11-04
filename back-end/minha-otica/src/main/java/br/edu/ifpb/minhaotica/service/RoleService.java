package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.RoleDTO;
import br.edu.ifpb.minhaotica.model.Role;
import br.edu.ifpb.minhaotica.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository _roleRepository;

    public List<Role> findAll() {
        return _roleRepository.findAll();
    }

    public ResponseEntity<Role> findById(UUID id) {
        Optional<Role> role = _roleRepository.findById(id);

        if (role.isPresent()) {
            return new ResponseEntity<Role>(role.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Role save(RoleDTO roleDTO) {
        Role newRole = new Role();

        newRole.setName(roleDTO.getName());

        return _roleRepository.save(newRole);
    }

    public ResponseEntity<Role> update(UUID id, RoleDTO newRoleDTO) {
        Optional<Role> oldRole = _roleRepository.findById(id);

        if (oldRole.isPresent()) {
            Role role = oldRole.get();

            role.setName(newRoleDTO.getName());

            _roleRepository.save(role);

            return new ResponseEntity<Role>(role, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Role> role = _roleRepository.findById(id);

        if (role.isPresent()) {
            _roleRepository.delete(role.get());

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

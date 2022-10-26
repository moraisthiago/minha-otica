package br.edu.ifpb.minhaotica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.minhaotica.dto.UserDTO;
import br.edu.ifpb.minhaotica.model.User;
import br.edu.ifpb.minhaotica.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository _userRepository;

    public List<User> findAll() {
        return _userRepository.findAll();
    }

    public ResponseEntity<User> findById(UUID id) {
        Optional<User> user = _userRepository.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public User save(UserDTO userDTO) {
        User newUser = new User();

        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());

        return _userRepository.save(newUser);
    }

    public ResponseEntity<User> update(UUID id, UserDTO newUserDTO) {
        Optional<User> oldUser = _userRepository.findById(id);

        if (oldUser.isPresent()) {
            User user = oldUser.get();

            user.setEmail(newUserDTO.getEmail());
            user.setPassword(newUserDTO.getPassword());

            _userRepository.save(user);

            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<User> user = _userRepository.findById(id);

        if (user.isPresent()) {
            _userRepository.delete(user.get());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = _userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
        return user;
    }
}

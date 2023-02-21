package our.war.help.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import our.war.help.model.ERole;
import our.war.help.model.Role;
import our.war.help.model.User;
import our.war.help.repository.RoleRepository;
import our.war.help.repository.UserRepository;
import our.war.help.security.JwtUtils;
import our.war.help.security.pojo.JwtResponse;
import our.war.help.security.pojo.LoginRequest;
import our.war.help.service.UserDetailsImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtils jwtUtils;
    @InjectMocks
    private UsersController usersController;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setFirstName("John2");
        user.setLastName("Doe2");
        user.setEmail("johndoe2@example.com");
        user.setPassword("password1234");
        Set<Role> roles = new HashSet<>();
        Optional<Role> role1 = roleRepository.findByName(ERole.ROLE_USER);
        role1.ifPresent(roles::add);
        user.setRoles(roles);

        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(user);
    }

    @Test
    public void authUser() {
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(new UserDetailsImpl(1L, "test10@example.com", "password10", Collections.emptyList()));
        when(authenticationManager.authenticate(any())).thenReturn(authentication);

        when(jwtUtils.generateJwtToken(any())).thenReturn("dummyJwtToken");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@example.com");
        loginRequest.setPassword("password");

        ResponseEntity<JwtResponse> response = usersController.authUser(loginRequest);

        JwtResponse jwtResponse = response.getBody();
        assertNotNull(jwtResponse);
        assertEquals("dummyJwtToken", jwtResponse.getToken());
        assertEquals(1L, jwtResponse.getId());
        assertEquals("test10@example.com", jwtResponse.getEmail());

        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals(authentication, SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    @Transactional
    void registerUser() {

        Role role = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

        User savedUser = userRepository.findByEmail("johndoe2@example.com");
        if (savedUser == null) {
            throw new RuntimeException("User not found");
        }
        assertTrue(savedUser.getRoles().contains(role));
    }
}
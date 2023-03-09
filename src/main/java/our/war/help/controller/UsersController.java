package our.war.help.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import our.war.help.model.ERole;
//import our.war.help.model.Role;
//import our.war.help.model.User;
//import our.war.help.repository.RoleRepository;
//import our.war.help.repository.UserRepository;
//import our.war.help.security.JwtUtils;
//import our.war.help.security.pojo.JwtResponse;
//import our.war.help.security.pojo.LoginRequest;
//import our.war.help.security.pojo.MessageResponse;
//import our.war.help.security.pojo.SignupRequest;
//import our.war.help.service.UserDetailsImpl;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/auth")
//@Api("controller witch show work swagger")
////@CrossOrigin(origins = "*", maxAge = 3600)
//public class UsersController {
//    private final AuthenticationManager authenticationManager;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtUtils jwtUtils;
//
//    @Autowired
//    public UsersController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtUtils = jwtUtils;
//    }
//
//    @PostMapping("/signin")
//    @ApiOperation("Authenticate user")
//    public ResponseEntity<JwtResponse> authUser(@RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(
//                        loginRequest.getEmail(),
//                        loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        JwtResponse jwtResponse = new JwtResponse(
//                jwtUtils.generateJwtToken(authentication),
//                userDetails.getId(),
//                userDetails.getEmail(),
//                roles);
//
//        return ResponseEntity.ok(jwtResponse);
//    }
//
//
//    @PostMapping("/signup")
//    @ApiOperation("register user")
//    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
//
//        if (userRepository.existsByEmail(signupRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is exist"));
//        }
//
//        User user = new User();
//        user.setFirstName(signupRequest.getFirstName());
//        user.setLastName(signupRequest.getLastName());
//        user.setEmail(signupRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
//
//        Set<Role> roles = new HashSet<>();
//
//                if (true) {
//                    Role userRole = roleRepository
//                            .findByName(ERole.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
//                    roles.add(userRole);
//                }
//                if (false) {
//                    Role userRole = roleRepository
//                            .findByName(ERole.ROLE_CLIENT)
//                            .orElseThrow(() -> new RuntimeException("Error, Role CLIENT is not found"));
//                    roles.add(userRole);
//                }
//                if (true) {
//                    Role userRole = roleRepository
//                            .findByName(ERole.ROLE_USER)
//                            .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
//                    roles.add(userRole);
//                }
//
//        user.setRoles(roles);
//        userRepository.save(user);
//        return ResponseEntity.ok(new MessageResponse("User CREATED"));
//    }
//}

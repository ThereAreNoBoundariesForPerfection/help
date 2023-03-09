package our.war.help.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import our.war.help.model.User;
//import our.war.help.repository.UserRepository;
//
//@Component
//public class CurrentUser {
//    private final UserRepository userRepository;
//
//    //@Autowired
//    public CurrentUser(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User getCurrentUser() {
//        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String email;
//        User user = new User();
//        if (principal instanceof UserDetails) {
//            email = ((UserDetails) principal).getUsername();
//            user = userRepository.findByEmail(email);
//        }
//        return user;
//    }
//}

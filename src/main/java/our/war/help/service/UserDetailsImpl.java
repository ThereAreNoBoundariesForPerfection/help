package our.war.help.service;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import our.war.help.model.User;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Data
//public class UserDetailsImpl implements UserDetails {
//    private static final long serialVersionUID = 1L;
//
//    private final Long id;
//    private final String email;
//    @JsonIgnore
//    private final String password;
//    private final Collection<? extends GrantedAuthority> authorities;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public static UserDetailsImpl build(User user) {
//        return new UserDetailsImpl(
//                user.getId(),
//                user.getEmail(),
//                user.getPassword(),
//                getAuthorities(user));
//    }
//
//    private static List<GrantedAuthority> getAuthorities(User user) {
//        return user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList());
//    }
//}

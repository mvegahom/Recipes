package recipes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import recipes.Error.EmailAlreadyExists;
import recipes.Model.User;
import recipes.Repository.UserRepository;
import recipes.security.WebSecurityConfigurerImpl;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return getUserByEmail(email);
    }

    public User getUserByEmail(String username) {

        return repository.findByUsername(username).orElseThrow(userNotFound(username));
    }

    public User createUser(User user) {

        if (userExist(user.getUsername()))
            throw new EmailAlreadyExists();
        System.out.println(user);
        String rawpassword = user.getPassword();
        System.out.println("rawpassword " + rawpassword);
        user.setPassword(WebSecurityConfigurerImpl.getEncoder().encode(rawpassword));
        System.out.println(user);
        User saved =repository.save(user);
        System.out.println("saved" + saved);
        return saved;
    }

    private Supplier<RuntimeException> userNotFound(String username) {
        return () -> new UsernameNotFoundException(username);
    }

    public boolean userExist(String username) {
        boolean result = false;
        Optional<User> userOpt = repository.findByUsername(username);
        if (userOpt.isPresent()) {
            result = true;
        }
        return result;
    }
}

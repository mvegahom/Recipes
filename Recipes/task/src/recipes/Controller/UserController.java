package recipes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.Model.User;
import recipes.Service.UserService;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody @Valid User user) {
        System.out.println(user);
        service.createUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}

package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Login;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.ValidationUser;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ValidationUser validationUser;
    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "form/registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "form/registration";
        }

        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model, HttpSession sess) {
        model.addAttribute("login", new Login());
        sess.invalidate();
        return "form/login";
    }

    @PostMapping("/login")
    public String login(@Valid Login login, BindingResult result, User user, HttpSession sess) {
        if(result.hasErrors()) {
            return "form/login";
        }

        if(validationUser.checkPassword(login)) {
            user.setEnable(true);
            sess.setAttribute("logInUser", user);
            sess.setAttribute("helloUsername", user.getUsername());
            return "redirect:/";
        } else {
            return "form/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession sess) {
        sess.invalidate();
        return "logout";
    }

//    @GetMapping("/tweet")
//    public String showAllTweet(Model model, HttpSession sess) {
//        model.addAllAttributes("tweetList", Tweet(tweetRepository.findAllByUserUsername(sess.getAttribute("logInUser"))));
//        return "form/registration";
//    }
}

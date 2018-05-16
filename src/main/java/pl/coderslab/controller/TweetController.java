package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create")
    public String createTweet(Model model, HttpSession sess) {

        User user = (User) sess.getAttribute("login");

        if(user != null && user.getEnable()) {
            model.addAttribute("tweet", new Tweet());
            return "form/createTweet";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/create")
    public String tweet(HttpSession sess, @Valid Tweet tweet, BindingResult result) {

        if(result.hasErrors()) {
            return "form/createTweet";
        }
        User user = (User) sess.getAttribute("logInUser");
        tweet.setUser(userRepository.findFirstByUsername(user.getUsername()));

        tweetRepository.save(tweet);
        return "redirect:/";
    }
}

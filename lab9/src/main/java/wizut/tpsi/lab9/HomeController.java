/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.lab9;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
    
    @Autowired
    BlogRepository blog;
    
    @RequestMapping("/")
    public String home(Model model) throws SQLException {
        model.addAttribute("Lista", blog.getAllPosts());
        return "home";
    }
    
    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
        blog.createPost(post);
        return "redirect:/";
    }
    
    @PostMapping("/deletepost")
    public String deletePost(BlogPost post) throws SQLException {
        blog.deletePost(post.getTitle());
        return "redirect:/";
    }
    
}

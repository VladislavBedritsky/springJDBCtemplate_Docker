package com.htp.ex.controller;

import com.htp.ex.model.Author;
import com.htp.ex.model.Book;
import com.htp.ex.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private ServiceProvider serviceProvider;

    @GetMapping
    public String getAuthors (Model model) {
        model.addAttribute("authors",serviceProvider.getAuthorService().findAll());
        return "authors";
    }

    @PostMapping
    public String save (
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        Author author = new Author(name,age);
        serviceProvider.getAuthorService().save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}")
    public String getAuthorById (
            @PathVariable Integer id,
            Model model
    ) {
        model.addAttribute("author",serviceProvider.getAuthorService().findById(id));
        model.addAttribute("author_books",serviceProvider.getBookService().findBooksByAuthorId(id));

        return "author";
    }

    @PostMapping("/update/{id}")
    public String updateBookById (@ModelAttribute("author") Author author) {

        serviceProvider.getAuthorService().update(author);

        return "redirect:/authors/"+author.getId();
    }
}

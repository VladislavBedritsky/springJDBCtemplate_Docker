package com.htp.ex.controller;

import com.htp.ex.model.Author;
import com.htp.ex.model.Book;
import com.htp.ex.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private ServiceProvider serviceProvider;

    @GetMapping
    public String getBooks (Model model) {
        model.addAttribute("books", serviceProvider.getBookService().findAllBooksAndAuthors());
        return "books";
    }

    @PostMapping
    public String saveBook (
            @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam Integer author_id
    ) {

        Author author = serviceProvider.getAuthorService().findById(author_id);

        Book book = new Book(name,price,author);
        serviceProvider.getBookService().save(book);

        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String getBookById (Model model,
                               @PathVariable Integer id) {
        model.addAttribute("book",serviceProvider.getBookService().findBookById(id));

        return "book";
    }

    @PostMapping("/update/{id}")
    public String updateBookById (@ModelAttribute("book") Book book) {

        serviceProvider.getBookService().update(book);

        return "redirect:/books/"+book.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteBookById (@PathVariable Integer id) {

        serviceProvider.getBookService().delete(id);

        return "redirect:/books";
    }

}

package com.example.bookstore.Controller;



import com.example.bookstore.dao.AuthorDao;
import com.example.bookstore.dao.bookDao;
import com.example.bookstore.model.Author;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorDao authorDao;
    private final bookDao bookDao;

    public AuthorController(AuthorDao authorDao, bookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authors/list";
    }

    @GetMapping("/{id}")
    public String viewAuthor(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        model.addAttribute("author", author);
        model.addAttribute("books", bookDao.findByAuthorId(id));
        return "authors/view";
    }

    @GetMapping("/new")
    public String showAuthorForm(Author author) {
        return "authors/add";
    }

    @PostMapping("/add")
    public String addAuthor(@Valid Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "authors/add";
        }
        authorDao.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        model.addAttribute("author", author);
        return "authors/update";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @Valid Author author, 
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            author.setId(id);
            return "authors/update";
        }
        authorDao.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model) {
        
        bookDao.findByAuthorId(id).forEach(book -> bookDao.delete(book.getId()));
        authorDao.delete(id);
        return "redirect:/authors";
    }
}

package com.example.bookstore.Controller;



import com.example.bookstore.dao.AuthorDao;
import com.example.bookstore.dao.bookDao;
import com.example.bookstore.model.book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class bookController {
    private final bookDao bookDao;
    private final AuthorDao authorDao;

    public bookController(bookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books/list";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        book book = bookDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("author", authorDao.findById(book.getAuthorId()).orElse(null));
        return "books/view";
    }

     @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/new")
    public String showBookForm(Model model) {
        model.addAttribute("book", new book());
        model.addAttribute("authors", authorDao.findAll());
        return "books/add";
    }

    @PostMapping("/new")
   public String addBook(@Valid @ModelAttribute("book") book book, 
                     BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("authors", authorDao.findAll());
        return "books/add";
    }
    bookDao.save(book);
    return "redirect:/books";
}


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        book book = bookDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("authors", authorDao.findAll());
        return "books/update";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, 
                       @Valid @ModelAttribute("book") book book,
                       BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("authors", authorDao.findAll());
        return "books/update";
    }
    book.setId(id); // Ensure ID is preserved
    bookDao.save(book);
    return "redirect:/books";
}
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookDao.delete(id);
        return "redirect:/books";
    }
}
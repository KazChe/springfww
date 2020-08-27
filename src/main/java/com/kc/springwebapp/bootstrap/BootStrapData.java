package com.kc.springwebapp.bootstrap;

import com.kc.springwebapp.domain.Author;
import com.kc.springwebapp.domain.Book;
import com.kc.springwebapp.repositories.AuthorRepository;
import com.kc.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author kaz = new Author("kaz", "che");
        Book cupcake = new Book("Rainbow Cupcake", "7777");
        kaz.getBooks().add(cupcake);
        cupcake.getAuthors().add(kaz);

        authorRepository.save(kaz);
        bookRepository.save(cupcake);

        Author kimia = new Author("Kimia", "Chehresa");
        Book fucktrump = new Book("Fuck Trump", "54345");
        kimia.getBooks().add(fucktrump);
        fucktrump.getAuthors().add(kimia);

        authorRepository.save(kimia);
        bookRepository.save(fucktrump);

        System.out.println("Started Bootstrap...");
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Number of authors:" + authorRepository.count());
    }
}

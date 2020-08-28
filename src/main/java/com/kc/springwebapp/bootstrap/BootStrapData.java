package com.kc.springwebapp.bootstrap;

import com.kc.springwebapp.domain.Author;
import com.kc.springwebapp.domain.Book;
import com.kc.springwebapp.domain.Publisher;
import com.kc.springwebapp.repositories.AuthorRepository;
import com.kc.springwebapp.repositories.BookRepository;
import com.kc.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository
    , PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

//        Publisher publisher = new Publisher("Orighty","666 West 95th Overland Park, KS, 66212");
//        publisher.setId(new Long(123));
//        publisherRepository.save(publisher);

        System.out.println("Started Bootstrap...");
        System.out.println("Number of Publishers:" + publisherRepository.count());
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Number of authors:" + authorRepository.count());
    }
}

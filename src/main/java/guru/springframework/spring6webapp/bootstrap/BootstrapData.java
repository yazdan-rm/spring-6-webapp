package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Guru");

        Book ericBook = new Book();
        ericBook.setTitle("Eric Book");
        ericBook.setIsbn("124234");



        Author ericAuthor = authorRepository.save(eric);
        var book = bookRepository.save(ericBook);

        Author testAuthor = new Author();
        eric.setFirstName("tttt");
        eric.setLastName("ffff");

        Book testBook = new Book();
        ericBook.setTitle("wertwer");
        ericBook.setIsbn("435345");


        Author a = authorRepository.save(testAuthor);
        var b = bookRepository.save(testBook);

        testBook.getAuthors().add(testAuthor);
        ericBook.getAuthors().add(eric);

        authorRepository.save(ericAuthor);
        authorRepository.save(testAuthor);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + a);
        System.out.println("Book Count: " + bookRepository.count());
    }
}

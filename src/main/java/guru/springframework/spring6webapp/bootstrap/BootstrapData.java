package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository,
                         PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setFirstName("Eric");
        author1.setLastName("Guru");

        Book book1 = new Book();
        book1.setTitle("Eric Book");
        book1.setIsbn("124234");



        Author savedAuthor1 = authorRepository.save(author1);
        var savedBook1 = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstName("tttt");
        author2.setLastName("ffff");

        Book book2 = new Book();
        book2.setTitle("wertwer");
        book2.setIsbn("435345");


        Author savedAuthor2 = authorRepository.save(author2);
        var savedBook2 = bookRepository.save(book2);

        savedBook1.getAuthors().add(savedAuthor1);
        savedBook2.getAuthors().add(savedAuthor2);

        savedAuthor1.getBooks().add(savedBook1);
        savedAuthor2.getBooks().add(savedBook2);

        Publisher publisher1 = new Publisher();
        publisher1.setAddress("Guru");
        publisher1.setPublisherName("Eric Publisher");
        publisher1.setCity("Guru");
        publisher1.setState("Guru");
        publisher1.setZip("435345");

        var savedPublisher1 = publisherRepository.save(publisher1);
        savedBook1.setPublisher(savedPublisher1);
        savedBook2.setPublisher(savedPublisher1);

        authorRepository.save(savedAuthor1);
        authorRepository.save(savedAuthor2);
        bookRepository.save(savedBook1);
        bookRepository.save(savedBook2);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}

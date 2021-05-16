package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Su nombre");
        publisher.setCity("La Paz");
        publisher.setState("La Paz");

        publisherRepository.save(publisher);

        System.out.println("Publisher contador : " + publisherRepository.count());


        Author alejandro = new Author("Alejandro","Peredo");
        Book libro = new Book("Cortando el nudo","12321445");
        alejandro.getBooks().add(libro);
        libro.getAuthors().add(alejandro);

        libro.setPublisher(publisher);
        publisher.getBooks().add(libro);

        authorRepository.save(alejandro);
        bookRepository.save(libro);
        publisherRepository.save(publisher);

        Author wendy = new Author("Wendy", "Peredo");
        Book libroA = new Book("J2EE Development", "3245353");
        wendy.getBooks().add(libroA);
        libroA.getAuthors().add(wendy);

        libroA.setPublisher(publisher);
        publisher.getBooks().add(libroA);


        authorRepository.save(wendy);
        bookRepository.save(libroA);
        publisherRepository.save(publisher);

        System.out.println("Iniciando en Bootstrap");
        System.out.println("Number of book: " + bookRepository.count());

        System.out.println("Publisher contador : " + publisher.getBooks().size());

        //Publisher pacpako = new Publisher("La voz","Marketing","Donoso Torrez", "San Isidro", "La Paz", "1406");
        //publisherRepository.save(pacpako);


    }
}

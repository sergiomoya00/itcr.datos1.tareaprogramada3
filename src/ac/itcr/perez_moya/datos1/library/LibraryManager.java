/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.library;

import ac.itcr.perez_moya.datos1.collections.SimpleLinkeList;
import ac.itcr.perez_moya.datos1.library.user.Customer;
import ac.itcr.perez_moya.datos1.library.user.Order;
import ac.itcr.perez_moya.datos1.library.user.UserData;
import com.sun.accessibility.internal.resources.accessibility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author samoy
 */
public class LibraryManager {

    List<Book> books = new SimpleLinkeList<>();
    List<Library> libraries = new SimpleLinkeList<>();
    List<UserData> users = new SimpleLinkeList<>();
    List<Customer> customers = new SimpleLinkeList<>();
    List<InventoryEntry> inventory = new SimpleLinkeList<>();
    List<Order> orders = new SimpleLinkeList<>();

    private static final LibraryManager instance;

    public static LibraryManager getInstance() {
        return instance;
    }

    public void removeLibrary(int index) {
        libraries.remove(index);

    }

    static {
        instance = new LibraryManager();
        instance.books.add(new Book() {
            {
                setName("Quijote de la mancha");
                setIssn("123456789");
                setPrice(87.5f);
                setTopic(Topic.Literatura.name());
            }
        });
        instance.books.add(new Book() {
            {
                setName("Introducción a Matemática Discreta");
                setIssn("123456789");
                setPrice(87.5f);
                setTopic(Topic.Matematicas.name());
            }
        });
        instance.books.add(new Book() {
            {
                setName("Biología noveno año");
                setIssn("123456789");
                setPrice(87.5f);
                setTopic(Topic.CienciasNaturales.name());
            }
        });

        instance.libraries.add(new Library() {
            {
                setNameLib("Librería Internacional");
                setPhone("2552-0504");
                setCountry("Costa Rica");
                setLocation("San José, Curridabat");
                

            }
        });

        instance.libraries.add(new Library() {
            {
                setNameLib("Librería Lehman");
                setPhone("2552-6559");
                setCountry("Costa Rica");
                setLocation("Cartago, Occidental");

            }
        });

        instance.libraries.add(new Library() {
            {
                setNameLib("Librería Universal");
                setPhone("2572-3456");
                setCountry("Costa Rica");
                setLocation("San José, San Pedro");

            }
        });

    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void addBook(Book newBook) {

    }
    
    

    public Collection<Book> search(Book newBook) {
        List<Book> results = new ArrayList<>();

        boolean byName = newBook.getName() != null && newBook.getName().length() > 0;
        boolean byType = newBook.getTopic() != null && newBook.getTopic().length() > 0;

        for (Book book : books) {
            boolean add = !(byName || byType);
            if (!add && byName && book.getName().contains(newBook.getName())) {
                add = true;
            }
            if(!add && byType && book.getTopic().contains(newBook.getTopic())) {
                add= true;
            }
             if (add) results.add(book);
        }

        return results;

    }

    public Collection<Library> getLibrarys() {
        return libraries;

    }

    public void addLibrary(Library library) {
        this.libraries.add(library);

    }

}

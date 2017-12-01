package design.onlineReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Library {

    private HashMap<Integer, Book> books;
    private HashMap<String, List<Book>> gener;

    Library() {
        this.books = new HashMap<>();
        this.gener = new HashMap<>();
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            return false;
        }
        books.put(book.getId(), book);
        if (book.getGener() != null) {
            if (gener.containsKey(book.getGener())) {
                gener.get(book.getGener()).add(book);
            } else {
                List<Book> bookList = new ArrayList<>();
                bookList.add(book);
                gener.put(book.getGener(), bookList);
            }
        }
        return true;
    }

    public boolean removeBook(Book book) {
        if (!books.containsKey(book.getId())) {
            return false;
        }
        books.remove(book.getId());
        if (book.getGener() != null) {
            gener.get(book.getGener()).remove(book);
        }
        return true;
    }

    public Book searchBook(String name) {
        Optional<Book> bookOptional = books.entrySet().stream()
                .filter(x -> x.getValue().getName().equalsIgnoreCase(name)).map(y -> y.getValue()).findFirst();
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            return null;
        }
    }

}

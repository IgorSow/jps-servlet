package com.sda.books.infrastructure.memory;

import com.sda.books.domain.model.Book;
import com.sda.books.domain.port.BooksRepository;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryBooksrepository implements BooksRepository {
    private List<Book> bookList;

    public InMemoryBooksrepository(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookList);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookList.stream()
                .filter(e -> StringUtils.contains(e.getAuthor(), author))
                .collect(Collectors.toList());
    }

}

package com.sda.books.application;

import com.sda.books.domain.BooksService;
import com.sda.books.domain.model.Book;
import com.sda.books.domain.port.BooksRepository;
import com.sda.books.infrastructure.memory.InMemoryBooksrepository;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookServlet extends HttpServlet {
    private BooksService booksService;
    private BookViews bookViews;


    @Override
    public void init() throws ServletException {

        List<Book> books = Arrays.asList(new Book(1, "441421", "Ogniem i mieczek", "fajna", "Sienkiewicz", LocalDate.of(1990, 12, 12)),
                new Book(2, "426234134", "Quo vadis", "nudna", "Sienkiewicz", LocalDate.of(1900, 12, 12)),
                new Book(3, "42532134", "AAAA", "gggg", "gggg", LocalDate.of(1940, 1, 12)));
        BooksRepository booksRepository = new InMemoryBooksrepository(books);
        booksService = new BooksService(booksRepository);
        bookViews = new BookViews();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String idBook = request.getParameter("idBook");

        List<Book> bookList = new ArrayList<>();
        Optional<Book> book;
        if (StringUtils.isNoneEmpty(idBook)) {

            book = booksService.findById(Integer.parseInt(idBook));
            bookList.add(book.get());


        } else {

            bookList = StringUtils.isEmpty(author) ?
                    booksService.findAll() :
                    booksService.findByauthor(author);
        }
        request.setAttribute("books", bookList);
        request.setAttribute("authorFilter", StringUtils.isNotEmpty(author));
        request.getRequestDispatcher("WEB-INF/jsp/bookList.jsp").forward(request, response);
//        bookViews.printBooks(response.getWriter(), bookList);
//        response.setContentType("text/html");

    }

}

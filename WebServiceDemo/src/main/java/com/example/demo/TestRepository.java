package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import com.example.pen.Pen;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.example.book.Book;

@Component
public class TestRepository {
    private static final Map<String, Book> books = new HashMap<>();
    private static final Map<String, Pen> pens = new HashMap<>();

    @PostConstruct
    public void initData() {
        Book harryPotterI = new Book();
        harryPotterI.setIsbn("9573317249");
        harryPotterI.setName("哈利波特：神秘的魔法石");;
        harryPotterI.setAuthor("J. K. 羅琳");
        harryPotterI.setPublishing("1997");
        harryPotterI.setEdition(1);

        books.put(harryPotterI.getIsbn(), harryPotterI);

        Book iceAndFireI = new Book();
        iceAndFireI.setIsbn("9789861856216");
        iceAndFireI.setName("冰與火之歌：權力遊戲");;
        iceAndFireI.setAuthor("喬治馬汀");
        iceAndFireI.setPublishing("2011");
        iceAndFireI.setEdition(1);

        books.put(iceAndFireI.getIsbn(), iceAndFireI);

        Book lordOfRingsI = new Book();
        lordOfRingsI.setIsbn("9789570841008");
        lordOfRingsI.setName("魔戒首部曲：魔戒現身");;
        lordOfRingsI.setAuthor("托爾金");
        lordOfRingsI.setPublishing("2001");
        lordOfRingsI.setEdition(1);

        books.put(lordOfRingsI.getIsbn(), lordOfRingsI);

        Pen pen1 = new Pen();
        pen1.setId("A");
        pen1.setAuthor("JN_A");
        Pen pen2 = new Pen();
        pen2.setId("B");
        pen2.setAuthor("JN_B");
        pens.put("A", pen1);
        pens.put("B", pen2);
    }

    public Book findBookByIsbn(String isbn) {
        Assert.notNull(isbn, "The isbn must not be null!");
        return books.get(isbn);
    }

    public Pen findPenByIsbn(String id) {
        Assert.notNull(id, "The id must not be null!");
        return pens.get(id);
    }
}
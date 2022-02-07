package com.nighthawk.csa.data.AkshayCBTests;

import java.util.ArrayList;

public class Unit9A {
    public static class Book

    {

        String title;

        String author;

        String desc;


        public Book(String t, String a)

        {

            title = t;

            author = a;

            desc = title + ", written by " + author;

        }

        public String getAuthor() {
            return author;
        }

        public String getDesc() {
            return desc;
        }

        public void printBookInfo()

        {
            System.out.println(title + ", written by " + author);

        }

    }

    public static class PictureBook extends Book {
        String illustrator;

        public PictureBook(String t, String a, String i) {
            super(t, a);
            illustrator = i;
            desc = title + ", written by " + author + " and illustrated by " + illustrator;
        }

        @Override
        public void printBookInfo() {
            System.out.println(title + ", written by " + author + " and illustrated by " + illustrator);
        }

    }


    public static class BookListing {
        double price;
        Book book;

        public BookListing(Book book, double price) {
            super();
            this.price = price;
            this.book = book;
        }

        public void printDescription() {
            System.out.println(book.getDesc() +  ", " + price);
        }

    }

    public static void main(String[] args) {
        PictureBook myBook = new PictureBook("Peter and Wendy", "J.M. Barrie", "F.D. Bedford");

        myBook.printBookInfo();

        ArrayList<Book> myLibrary = new ArrayList<Book>();

        Book book1 = new Book("Frankenstein", "Mary Shelley");
        PictureBook book2 = new PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");

        myLibrary.add(book1);
        myLibrary.add(book2);

        BookListing listing1 = new BookListing(book1, 10.99);
        listing1.printDescription();

        BookListing listing2 = new BookListing(book2, 12.99);
        listing2.printDescription();

    }
}

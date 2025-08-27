package com.handson.usecase.dto;
import java.awt.print.Book;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "bookstore")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLBookstoreDTO {
    @XmlElement(name = "book")
    private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
    
    
}
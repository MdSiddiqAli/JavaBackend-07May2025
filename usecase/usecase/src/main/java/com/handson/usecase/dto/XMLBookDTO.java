package com.handson.usecase.dto;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLBookDTO {
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "author")
    private String author;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
    
    
    
}
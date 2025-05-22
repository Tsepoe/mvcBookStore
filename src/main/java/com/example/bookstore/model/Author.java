package com.example.bookstore.model;

//@Table(name = "Authors")
public class Author {
 private Long id;
 private String name;
 private String bio;

    public Author(){}

    public Author(Long id, String name, String bio) {
    this.id = id;
    this.name = name;
    this.bio = bio;
}
   public Long getId(){
     return this.id;
   } 

   public void setId(long id){
     this.id = id;
   }
 
   public String getName(){
     return this.name;
   } 

   public void setName(String name){
     this.name = name;
   }

   public String getBio(){
     return this.bio;
   } 

   public void setBio(String bio){
     this.bio = bio;
   }

    public String toString() {
		return "Author(Name: " + this.name + ", Bio: " + this.bio + ")";
	}

}

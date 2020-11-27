package com.model;

public class User {
	private int id;
	private String name;
    private String email; 
    private String fvlang;
    
    
    public User() {
	
	}
	public User(int id, String name, String email, String fvlang) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.fvlang = fvlang;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFvlang() {
		return fvlang;
	}
	public void setFvlang(String fvlang) {
		this.fvlang = fvlang;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", fvlang=" + fvlang + "]";
	}
    
    
	
    
    
    
}

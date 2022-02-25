package com.russell.dojosninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   
    @NotBlank(message="Dojo name is required!")
    @Size(min = 2, max = 200, message="Dojo name must be between 2-200 characters")
    private String name;

    
    
   // This will not allow the createdAt column to be updated after creation
   @Column(updatable=false)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date createdAt;
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date updatedAt;
    
  @PrePersist
  protected void onCreate(){
      this.createdAt = new Date();
  }
  @PreUpdate
  protected void onUpdate(){
      this.updatedAt = new Date();
  }
    
  //empty constructor
  public Dojo() {}
  
  
  //loaded Constructor (Source, Generate Constructor using fields, dont need id, updated or created at)
  public Dojo(String name) {
	this.name = name;
  }
  
  
  //ONE TO MANY CODE BELOW
  //a dojo can have many ninjas, so we can ninjas in a list
  @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
  private List<Ninja> ninjas;


  //GENERATE GETTERS AND SETTERS (SELECT ALL)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	  

  
}


package com.senso.gate.sensoApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Contact {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank(message = "O campo nome é obrigatorio")
   private String name;

   @NotBlank(message = "O campo email é obrigatorio")
   private String email;

   @NotBlank(message = "O campo phone é obrigatorio")
   private String phone;
   
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
   
   public String getPhone() {
		return phone;
   }
   
   public void setPhone(String phone) {
		this.phone = phone;
   }
}
package br.com.project.bookapi.entity;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;

@DynamoDBDocument
@AllArgsConstructor
public class Person {
    private String fullName;
    private Date birthday;
    private Long cpf;
    
	@DynamoDBAttribute(attributeName = "fullName")
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    @DynamoDBAttribute(attributeName = "birthday")
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    @DynamoDBAttribute(attributeName = "cpf")
    public Long getCpf() { return cpf; }
    public void setCpf(Long cpf) { this.cpf = cpf; }

 }
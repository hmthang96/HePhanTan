package com.bootcamp.springboot.app.student.models.documents;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;



@ApiModel(value = "Student entity", description = "Complete data of an entity Student")
@Document(collection = "students")
public class Student {

  @ApiModelProperty(value = "The id of the student", required = false)
  private String id;

  @ApiModelProperty(value = "The fullName of the student", required = true)
  private String fullName;

  @ApiModelProperty(value = "The gender of the student", required = true)
  private String gender;

  @ApiModelProperty(value = "The birthDate of the student", required = true)
  private Date birthDate;

  @ApiModelProperty(value = "The typeOfDocument of the student", required = true)
  private String typeOfDocument;

  @ApiModelProperty(value = "The numberOfDocument of the student", required = true)
  private Integer numberOfDocument;

  

  public Student() {
    super();
  }
  
  /** Extra javadoc (ignored). */
  public Student(String fullName, String gender, Date birthDate, String typeOfDocument,
      Integer numberOfDocument) {
    this.fullName = fullName;
    this.gender = gender;
    this.birthDate = birthDate;
    this.typeOfDocument = typeOfDocument;
    this.numberOfDocument = numberOfDocument;
  }

  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getTypeOfDocument() {
    return typeOfDocument;
  }

  public void setTypeOfDocument(String typeOfDocument) {
    this.typeOfDocument = typeOfDocument;
  }

  public Integer getNumberOfDocument() {
    return numberOfDocument;
  }

  public void setNumberOfDocument(Integer numberOfDocument) {
    this.numberOfDocument = numberOfDocument;
  }



}

package com.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Plan_Category")
public class PlanCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_Id")
	private Integer categoryId;
	
	@Column(name = "Category_Name")
	private String  categoryName;
	
	@Column(name = "Category_Active")
	private String activeSw;
	
	@Column(name = "Category_CreatedBy")
	private String createdBy;
	
	@Column(name = "Category_UpdatedBy")
	private String updatedBy;
	
	@CreationTimestamp
	@Column(name = "Category_CreatedDate")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "Category_UpdatedDate")
	private LocalDate updatedDate;
}

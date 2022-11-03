package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producttypes")
public class ProductType extends BaseEntity{
	
	
	@Column(name = "name", unique = true)
	@NotEmpty
	@Size(max = 50, min = 3)
    String name;
}

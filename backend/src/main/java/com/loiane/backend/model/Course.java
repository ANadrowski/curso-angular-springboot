package com.loiane.backend.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loiane.backend.enums.Category;
import com.loiane.backend.enums.Status;
import com.loiane.backend.enums.converters.CategoryConverter;
import com.loiane.backend.enums.converters.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data //Essa anotação gera os getters e setters (entre outras coisas)
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?") //Essa anotação altera o comportamento do deleteById.
@Where(clause = "status = 'Ativo'")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull 
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull 
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @NotNull 
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "course_id")
    private List<Lesson> lessons = new ArrayList<>();
}

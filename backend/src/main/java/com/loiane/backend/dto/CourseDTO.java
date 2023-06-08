package com.loiane.backend.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/*
 * Este é um record e está disponível a partir do Java 14.
 * No record, todos os dados devem ser passados dento do construtor,
 * e não existe setters. Já a recuperação dos dados pode ser feita
 * através dos getters.
 * 
 * Trata-se de uma classe imutável do Java.
 * 
 * Outra diferença para uma classe normal é que os métodos 
 * getters não usam o prefixo get, portanto devemos acessar diretamente
 * pelo nome da propriedade.
 */

public record CourseDTO(
    @JsonProperty("_id") Long id, 
    @NotBlank @NotNull @Length(min = 5, max = 100) String name, 
    @NotBlank @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") String category) {
}

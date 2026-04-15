package br.com.alura.adopet.api.dto.pet;

import jakarta.validation.constraints.NotNull;

public record ListarPetDTO(
        @NotNull Long idPet,
        @NotNull Boolean adotado
) {
}
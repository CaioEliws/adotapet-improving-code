package br.com.alura.adopet.api.validation.pet;

import br.com.alura.adopet.api.dto.pet.ListarPetDTO;

public interface ValidacaoListarPet {

    void validar(ListarPetDTO dto);

}
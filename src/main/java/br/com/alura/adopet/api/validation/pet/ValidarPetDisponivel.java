package br.com.alura.adopet.api.validation.pet;

import br.com.alura.adopet.api.dto.pet.ListarPetDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarPetDisponivel implements ValidacaoListarPet {

    @Override
    public void validar(ListarPetDTO dto) {
        if (dto.adotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}
package br.com.alura.adopet.api.validation.pet;

import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidacaoPetDisponivelTest {

    @InjectMocks
    private ValidacaoPetDisponivel validacao;

    @Mock
    private PetRepository petRepository;

    @Mock
    private Pet pet;

    @Mock
    private SolicitacaoAdocaoDTO dto;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {

        // ARRANGE
        SolicitacaoAdocaoDTO dto = new SolicitacaoAdocaoDTO(
                7l,
                2l,
                "Motivo qualquer"
        );


        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(false);

        //ASSERT + ACT
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoPet() {

        // ARRANGE
        SolicitacaoAdocaoDTO dto = new SolicitacaoAdocaoDTO(
                7l,
                2l,
                "Motivo qualquer"
        );


        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);

        //ASSERT + ACT
        Assertions.assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }

}













//package br.com.alura.adopet.api.validation.pet;
//
//import br.com.alura.adopet.api.dto.adocao.SolicitacaoAdocaoDTO;
//import br.com.alura.adopet.api.model.Pet;
//import br.com.alura.adopet.api.repository.PetRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.lang.reflect.Field;
//
//@ExtendWith(MockitoExtension.class)
//class ValidacaoPetDisponivelTest {
//
//    @InjectMocks
//    private ValidacaoPetDisponivel validacao;
//
//    @Mock
//    private PetRepository petRepository;
//
//    @Test
//    void deveriaPermitirSolicitacaoDeAdocaoPet() throws Exception {
//        // ARRANGE
//        SolicitacaoAdocaoDTO dto = new SolicitacaoAdocaoDTO(
//                7L,
//                2L,
//                "Motivo qualquer"
//        );
//
//        Pet pet = new Pet();
//        setField(pet, "adotado", false);
//
//        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
//
//        // ACT + ASSERT
//        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
//    }
//
//    private void setField(Object target, String fieldName, Object value) throws Exception {
//        Field field = target.getClass().getDeclaredField(fieldName);
//        field.setAccessible(true);
//        field.set(target, value);
//    }
//}
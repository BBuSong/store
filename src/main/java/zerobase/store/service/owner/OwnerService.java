package zerobase.store.service.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.store.domain.SignUpForm;
import zerobase.store.domain.model.Owner;
import zerobase.store.domain.repository.OwnerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public Optional<Owner> findByIdAndEmail(Long id, String email) {
        return ownerRepository.findByIdAndEmail(id, email);
    }

    public Optional<Owner> findValidOwner(String email,String password) {
        return ownerRepository.findByEmailAndPasswordAndVerifyIsTrue(email, password);
    }

    public Owner signUp(SignUpForm form) {
        return ownerRepository.save(Owner.from(form));
    }

    public boolean isEmailExist(String email) {
        return ownerRepository.findByEmail(email).isPresent();
    }



}

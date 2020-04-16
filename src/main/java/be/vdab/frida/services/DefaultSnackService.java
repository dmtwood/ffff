package be.vdab.frida.services;

import be.vdab.frida.domain.Snack;
import be.vdab.frida.repositories.SnackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
class DefaultSnackService implements SnackService {
    private final SnackRepository snackRepository;
    DefaultSnackService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }
    @Override
    public void update(Snack snack) {
        snackRepository.update(snack);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Snack> findByBeginNaam(String beginNaam) {
        return snackRepository.findByBeginNaam(beginNaam);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Snack> findById(long id) {
        return snackRepository.findById(id);
    }
}

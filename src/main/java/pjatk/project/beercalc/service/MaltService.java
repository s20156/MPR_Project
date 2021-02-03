package pjatk.project.beercalc.service;

import org.springframework.stereotype.Service;
import pjatk.project.beercalc.model.Malt;
import pjatk.project.beercalc.repository.MaltRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaltService {
    private MaltRepository maltRepository;

    public MaltService(MaltRepository maltRepository) {
        this.maltRepository = maltRepository;
    }

    public List<Malt> findAll(){
        return maltRepository.findAll();
    }

    public Optional<Malt> findById(Long id) {
        return maltRepository.findById(id);
    }

    public Malt saveMalt(Malt malt) {
        return maltRepository.save(malt);
    }
}

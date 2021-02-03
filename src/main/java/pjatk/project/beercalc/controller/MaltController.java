package pjatk.project.beercalc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjatk.project.beercalc.model.Malt;
import pjatk.project.beercalc.service.MaltService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/malt")
public class MaltController {
    private MaltService maltService;

    public MaltController(MaltService maltService) {
        this.maltService = maltService;
    }

    @GetMapping
    public ResponseEntity<List<Malt>> findAll() {
        List<Malt> all = maltService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Malt>> findById(@PathVariable Long id) {
        Optional<Malt> byId = maltService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Malt> saveMalt(@RequestBody Malt malt) {
        return ResponseEntity.ok(maltService.saveMalt(malt));
    }
}

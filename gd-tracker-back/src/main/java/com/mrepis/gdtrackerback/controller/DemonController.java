package com.mrepis.gdtrackerback.controller;

import com.mrepis.gdtrackerback.model.Demon;
import com.mrepis.gdtrackerback.repository.DemonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demons")
public class DemonController {
    private final DemonRepository demonRepository;

    public DemonController(DemonRepository demonRepository) {
        this.demonRepository = demonRepository;
    }

    @GetMapping
    public Iterable<Demon> getAllDemons() {
        return demonRepository.findAll();
    }

    @PostMapping
    public Demon addDemon(@RequestBody Demon demon) {
        return demonRepository.save(demon);
    }

    @GetMapping("/{id}")
    public Demon getDemonById(@PathVariable Long id) {
        return demonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Level not found for id : " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteDemon(@PathVariable Long id) {
        demonRepository.deleteById(id);
    }


}

package com.mrepis.gdtrackerback.controller;

import com.mrepis.gdtrackerback.model.Demon;
import com.mrepis.gdtrackerback.repository.DemonRepository;
import com.mrepis.gdtrackerback.service.DemonService;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demons")
public class DemonController {
    private final DemonRepository demonRepository;
    private final DemonService demonService;

    public DemonController(DemonRepository demonRepository, DemonService demonService) {
        this.demonRepository = demonRepository;
        this.demonService = demonService;
    }

    @GetMapping
    public Iterable<Demon> getAllDemons() {
        return demonRepository.findAll();
    }

    @PostMapping
    public Demon addDemon(@RequestBody Demon demon) {
        return demonService.saveDemon(demon);
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

//    @PostMapping
//    public Iterable<Demon> importDemons(@RequestPart FilePart filePart) {
//
//    }


}

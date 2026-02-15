package com.mrepis.gdtrackerback.service;

import com.mrepis.gdtrackerback.model.Demon;
import com.mrepis.gdtrackerback.repository.DemonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class DemonService {
    private final DemonRepository repository;

    public DemonService(DemonRepository repository) {
        this.repository = repository;
    }

    public Demon saveDemon(Demon demon) {
        if (demon.getAttempts() < 0) {
            throw new IllegalArgumentException("Attempts can't be lower than 0.");
        }
        return repository.save(demon);
    }

    public Double calculateAverageEnjoyment() {
        List<Demon> demons = repository.findAll();
        if (demons.isEmpty()) return 0.0;

        return demons.stream()
                .mapToInt(Demon::getEnjoyment)
                .average()
                .orElse(0.0);
    }

    public Double calculateAverageAttempts() {
        List<Demon> demons = repository.findAll();
        if (demons.isEmpty()) return 0.0;

        return demons.stream()
                .mapToInt(Demon::getAttempts)
                .average()
                .orElse(0.0);
    }

    public Integer calculateTotalAttempts() {
        List<Demon> demons = repository.findAll();
        if (demons.isEmpty()) return 0;

        return demons.stream()
                .mapToInt(Demon::getAttempts)
                .sum();
    }

    public long getDaysSinceLast() {
        List<Demon> demons = repository.findAll();
        if (demons.isEmpty()) return 0;

        LocalDate lastDate = demons.stream()
                .map(Demon::getCompletionDate)
                .toList()
                .getLast();

        return ChronoUnit.DAYS.between(lastDate, LocalDate.now());
    }

    public long getDaysSinceFirst() {
        List<Demon> demons = repository.findAll();
        if (demons.isEmpty()) return 0;

        LocalDate firstDate = demons.stream()
                .map(Demon::getCompletionDate)
                .toList()
                .getFirst();

        return ChronoUnit.DAYS.between(firstDate, LocalDate.now());
    }

    public long calculateLongestBreak() {
        List<LocalDate> dates = repository.findAll().stream()
                .map(Demon::getCompletionDate)
                .filter(Objects::nonNull)
                .sorted()
                .toList();
        if (dates.size() < 2) return 0;

        long longestBreak = 0;

        for (int i = 0; i < dates.size() - 1; i++) {
            long breakDuration = ChronoUnit.DAYS.between(dates.get(i), dates.get(i+1));

            if (breakDuration > longestBreak) {
                longestBreak = breakDuration;
            }
        }

        return longestBreak;
    }

}

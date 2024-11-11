package com.CME.backend.repository;

import com.CME.backend.model.instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface instrumentRepository extends JpaRepository<instrument, String> {
    instrument findByinstrument_idIgnoreCase(String instrument_id);
}

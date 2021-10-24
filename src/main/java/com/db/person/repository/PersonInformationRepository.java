package com.db.person.repository;

import com.db.person.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInformationRepository extends JpaRepository<PersonEntity, Long> {
}

package com.example.tp1.repositories;

import com.example.tp1.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IBlocRepository  extends JpaRepository<Bloc, Long> {

    Iterable<Long> idBloc(long idBloc);
}

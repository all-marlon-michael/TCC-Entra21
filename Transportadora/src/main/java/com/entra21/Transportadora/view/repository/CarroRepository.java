package com.entra21.Transportadora.view.repository;

import com.entra21.Transportadora.model.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
    public Optional<List<CarroEntity>> findAllByEmpresa_Cnpj(String cnpj);
    public Optional<CarroEntity> findByPlaca(String placa);
}


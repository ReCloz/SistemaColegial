package com.ricardoclaro.colegial.repository;

import com.ricardoclaro.colegial.entity.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {
}

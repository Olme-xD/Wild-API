package com.olme.WildAPI;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WildRepository extends JpaRepository<Wild, Long> {
    @Query(value = "SELECT * FROM wild s WHERE s.wild_id = :id", nativeQuery = true)
    List<Wild> getWildAnimalsById(long id);

    @Query(value = "SELECT * FROM wild s WHERE s.age >= :age", nativeQuery = true)
    List<Wild> getWildAnimalsByAge(@Param("age") double age);

    @Query(value = "SELECT * FROM wild s WHERE s.name LIKE %:name%", nativeQuery = true)
    List<Wild> getWildAnimalsByName(@Param("name") String name);

    Wild findByHabitat(String habitat);
}

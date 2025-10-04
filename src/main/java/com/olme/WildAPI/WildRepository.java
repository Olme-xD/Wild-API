package com.olme.WildAPI;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WildRepository extends JpaRepository<Wild, Long> {
    List<Wild> getWildAnimalsById(long id);

    @Query(value = "select * from wild s where s.age >= ?4", nativeQuery = true)
    List<Wild> getWildAnimalsByAge(double age);

    @Query(value = "select * from wild s where s.name like %?1% ", nativeQuery = true)
    List<Wild> getWildAnimalsByName(String name);

    void saveAll(Wild name, String description, String breed, double age);

    Wild findByHabitat(String habitat);
}

package com.asma.parfums.repos;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.asma.parfums.entities.Marque;
import com.asma.parfums.entities.Parfum;



@RepositoryRestResource(path = "REST")
public interface ParfumRepository extends JpaRepository<Parfum, Long> {
	
	List<Parfum> findByParfumName(String parfumName);
	List<Parfum> findByParfumNameContains(String parfumName); 
	//@Query("select p from Parfum p where p.parfumName like %?1 and p.parfumPrice > ?2")
	//List<Parfum> findByNomPrix (String nom, Double prix);
	
	@Query("select p from Parfum p where p.parfumName like %:nom and p.parfumPrice > :prix")
     List<Parfum> findByNamePrice (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select p from Parfum p where p.marque = ?1")
	List<Parfum> findByMarque (Marque marque);
	
	
    List<Parfum> findByMarqueIdMarque(Long id);
    
    List<Parfum> findByOrderByParfumNameAsc();
   
    @Query("select p from Parfum p order by p.parfumName ASC, p.parfumPrice DESC")
    List<Parfum> trierParfumsNomsPrix ();


}

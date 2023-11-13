package com.asma.parfums.service;

import java.util.List;

import com.asma.parfums.entities.Marque;
import com.asma.parfums.entities.Parfum;

public interface ParfumService {

	Parfum saveParfum(Parfum p);
	Parfum updateParfum(Parfum p);
	void deleteParfum(Parfum p);
	void deleteParfumById(Long id);
	Parfum getParfum(Long id);
	List<Parfum> getAllParfums();	
	List<Parfum> findByParfumName(String parfumName);
	List<Parfum> findByParfumNameContains(String parfumName); 
	List<Parfum> findByNamePrice (String nom, Double prix);
	List<Parfum> findByMarque (Marque marque);
	List<Parfum> findByMarqueIdMarque(Long id);
	List<Parfum> findByOrderByParfumNameAsc();
	List<Parfum> trierParfumsNomsPrix ();


}

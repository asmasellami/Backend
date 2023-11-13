package com.asma.parfums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asma.parfums.entities.Marque;
import com.asma.parfums.entities.Parfum;
import com.asma.parfums.repos.ParfumRepository;



@Service
public class ParfumServiceImpl implements ParfumService {
	
	@Autowired
	ParfumRepository parfumRepository;


	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);

	}

	@Override
	public Parfum updateParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public void deleteParfum(Parfum p) {
		parfumRepository.delete(p);
		
	}

	@Override
	public void deleteParfumById(Long id) {
		parfumRepository.deleteById(id);
		
		
	}

	@Override
	public Parfum getParfum(Long id) {
		return parfumRepository.findById(id).get();
	}

	@Override
	public List<Parfum> getAllParfums() {
		return parfumRepository.findAll();

	}

	@Override
	public List<Parfum> findByParfumName(String parfumName) {
		return parfumRepository.findByParfumName(parfumName);
	}
	@Override
	public List<Parfum> findByParfumNameContains(String parfumName) {
		return parfumRepository.findByParfumNameContains(parfumName);
	}
	
	
	@Override
	public List<Parfum> findByNamePrice (String nom, Double prix) {
	return parfumRepository.findByNamePrice(nom, prix);
	}


	@Override
	public List<Parfum> findByMarque(Marque marque) {
		return parfumRepository.findByMarque( marque);
	}

	@Override
	public List<Parfum> findByMarqueIdMarque(Long id) {
		return parfumRepository.findByMarqueIdMarque(id);
	}
	
	@Override
	public List<Parfum> findByOrderByParfumNameAsc() {
	return parfumRepository.findByOrderByParfumNameAsc();
	}

	@Override
	public List<Parfum> trierParfumsNomsPrix() {
		return parfumRepository.trierParfumsNomsPrix();
	}

}

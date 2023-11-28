package com.asma.parfums.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asma.parfums.entities.Marque;
import com.asma.parfums.entities.Parfum;
import com.asma.parfums.repos.ImageRepository;
import com.asma.parfums.repos.ParfumRepository;



@Service
public class ParfumServiceImpl implements ParfumService {
	
	@Autowired
	ParfumRepository parfumRepository;
	
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);

	}

	/*@Override
	public Parfum updateParfum(Parfum p) {
		return parfumRepository.save(p);
	}*/
	
	
	@Override
	public Parfum updateParfum(Parfum p) {
		
		//Long oldParfImageId = this.getParfum(p.getIdParfum()).getImage().getIdImage();
		
		//Long newParfImageId = p.getImage().getIdImage();
		
		Parfum parfUpdated = parfumRepository.save(p);
		
		//if (oldParfImageId != newParfImageId) // si l'image a été modifiée
			
			//imageRepository.deleteById(oldParfImageId);
		
		return parfUpdated;
	}
	
	

	@Override
	public void deleteParfum(Parfum p) {
		parfumRepository.delete(p);
		
	}

	/*@Override
	public void deleteParfumById(Long id) {
		parfumRepository.deleteById(id);
		
		
	}*/
	
	@Override
	public void deleteParfumById(Long id) {
		Parfum p = getParfum(id);
		// suuprimer l'image avant de supprimer le parfum
		try {
			Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + p.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

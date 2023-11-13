package com.asma.parfums.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asma.parfums.entities.Parfum;
import com.asma.parfums.service.ParfumService;


@RestController
@RequestMapping("/ApiProjet")
@CrossOrigin
public class ParfumRESTController {

	@Autowired
	ParfumService parfumService;

	@RequestMapping(method=RequestMethod.GET)

	public List<Parfum> getAllParfums() {

		return parfumService.getAllParfums();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Parfum getProduitById(@PathVariable("id") Long id) {
		return parfumService.getParfum(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Parfum createProduit(@RequestBody Parfum parfum) {
	return parfumService.saveParfum(parfum);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Parfum updateProduit(@RequestBody Parfum parfum) {
	return parfumService.updateParfum(parfum);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		parfumService.deleteParfumById(id);
	}
	
	@RequestMapping(value="/nomParf/{idMarque}",method = RequestMethod.GET)
	public List<Parfum> getParfumsByMarqueId(@PathVariable("idMarque") Long idMarque) {
	return parfumService.findByMarqueIdMarque(idMarque);
	}
	
	@RequestMapping(value="/parfsByName/{nom}",method = RequestMethod.GET)
	public List<Parfum> findByNomProduitContains(@PathVariable("nom") String nom) {
	return parfumService.findByParfumNameContains(nom);
	}
}

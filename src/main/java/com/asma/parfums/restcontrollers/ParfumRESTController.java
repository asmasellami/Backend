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

	@RequestMapping(path ="all",method=RequestMethod.GET)
	public List<Parfum> getAllParfums() {

		return parfumService.getAllParfums();
	}

	@RequestMapping(value ="/getbyid/{id}", method = RequestMethod.GET)
	public Parfum getParfumById(@PathVariable("id") Long id) {
		return parfumService.getParfum(id);
	}

	@RequestMapping(path="/addParf",method = RequestMethod.POST)
	public Parfum createParfum(@RequestBody Parfum parfum) {
	return parfumService.saveParfum(parfum);
	}
	
	@RequestMapping(path="/updateParf",method = RequestMethod.PUT)
	public Parfum updateParfum(@RequestBody Parfum parfum) {
	return parfumService.updateParfum(parfum);
	}

	
	@RequestMapping(value="/delParf/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/delParf/{id}")
	public void deleteParfum(@PathVariable("id") Long id)
	{
		parfumService.deleteParfumById(id);
	}
	
	@RequestMapping(value="/nomParf/{idMarque}",method = RequestMethod.GET)
	public List<Parfum> getParfumsByMarqueId(@PathVariable("idMarque") Long idMarque) {
	return parfumService.findByMarqueIdMarque(idMarque);
	}
	
	@RequestMapping(value="/parfsByName/{nom}",method = RequestMethod.GET)
	public List<Parfum> findByNomParfumContains(@PathVariable("nom") String nom) {
	return parfumService.findByParfumNameContains(nom);
	}
}

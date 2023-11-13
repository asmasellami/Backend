package com.asma.parfums;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.asma.parfums.entities.Marque;
import com.asma.parfums.entities.Parfum;
import com.asma.parfums.repos.ParfumRepository;

@SpringBootTest
class ParfumsApplicationTests {

	@Autowired
	private ParfumRepository parfumRepository;
	
	@Test
	public void testCreateParfum() {
	Parfum prod = new Parfum("si",380.000,new Date());
	parfumRepository.save(prod);
	}
	
	@Test
	public void testFindParfum()
	{
		Parfum p = parfumRepository.findById(2L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdateParfum()
	{
	Parfum p = parfumRepository.findById(2L).get();
	p.setParfumPrice(200.0);
	parfumRepository.save(p);
	}

	
	@Test
	public void testDeleteParfum()
	{
		parfumRepository.deleteById(1L);;
	}
	 
	@Test
	public void testListerTousParfums()
	{
	List<Parfum> prods = parfumRepository.findAll();
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	
	
	 @Test
	 public void testFindByNomProduit()
	 {
	 List<Parfum> prods = parfumRepository.findByParfumName("Sauvage");
	 for (Parfum p : prods)
	 {
	 System.out.println(p);
	 }
	 }

	 @Test
	 public void testFindByParfumNameContains ()
	 {
	 List<Parfum> prods=parfumRepository.findByParfumNameContains("s");
	 for (Parfum p : prods)
	 {
	 System.out.println(p);
	 } }
	 
	 
	 @Test
	 public void testfindByNamePrice()
	 {
	 List<Parfum> prods = parfumRepository.findByNamePrice("si", 380.000);
	 for (Parfum p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 
	 @Test
	 public void testfindByMarque()
	 {
	 Marque marq = new Marque();
	 marq.setIdMarque(1L);
	 List<Parfum> prods = parfumRepository.findByMarque(marq);
	 for (Parfum p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
		@Test
		public void findByMarqueId() {
			List<Parfum> prods = parfumRepository.findByMarqueIdMarque(1L);
			for (Parfum p : prods) {
				System.out.println(p);
			}
		}
	 
		@Test
		public void testfindByOrderByNameParfumAsc()
		{
		List<Parfum> prods = parfumRepository.findByOrderByParfumNameAsc();
		for (Parfum p : prods)
		{
		System.out.println(p);
		}
		}

		
		@Test
		public void testTrierParfumsNomsPrix()
		{
		List<Parfum> prods = parfumRepository.trierParfumsNomsPrix();
		for (Parfum p : prods)
		{
		System.out.println(p);
		}
		}
}

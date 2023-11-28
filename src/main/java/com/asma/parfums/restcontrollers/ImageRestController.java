package com.asma.parfums.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.asma.parfums.entities.Image;
import com.asma.parfums.entities.Parfum;
import com.asma.parfums.service.ImageService;
import com.asma.parfums.service.ParfumService;

@RestController
@RequestMapping("/ApiProjet/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 ImageService imageService ;
	 
	 @Autowired
	 ParfumService parfumService ;
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageParf/{idParf}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idParf") Long idParf) 
	        throws IOException {
	 return imageService.uplaodImageParf(file,idParf);
	 }
	 
	 
	@RequestMapping(value = "/getImagesParf/{idParf}" , method = RequestMethod.GET)
	 public List<Image> getImagesParf(@PathVariable("idParf") Long idParf) 
	throws IOException {
	 return imageService.getImagesParParf(idParf);
	 }
	
	 @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile file,@PathVariable("id") Long id) throws IOException {
		 Parfum p = parfumService.getParfum(id);
		 p.setImagePath(id+".jpg");

		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
				 , file.getBytes());
		 parfumService.saveParfum(p);

	 }
	 
	 @RequestMapping(value = "/loadfromFS/{id}" ,method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Parfum p = parfumService.getParfum(id);
		 return	 Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	 }


	 
}

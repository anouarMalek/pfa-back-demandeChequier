package com.pfa.demandeChequier.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.demandeChequier.entities.Beneficiaire;
import com.pfa.demandeChequier.exceptions.ConflictException;
import com.pfa.demandeChequier.exceptions.NotFoundException;
import com.pfa.demandeChequier.services.BeneficiaireService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BeneficiaireController {

	@Autowired
	BeneficiaireService service;


	@PostMapping("/beneficiaire")
	@ResponseStatus(HttpStatus.CREATED)
	public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire)  throws ConflictException
	{
		return service.addBeneficiaire(beneficiaire);
	}



	@GetMapping("/beneficiaire")
	@ResponseStatus(HttpStatus.OK)
	public Beneficiaire getBeneficiaires(@RequestParam(value="id") Long id)  throws NotFoundException
	{

		return service.getBeneficiaire(id);
	}



	@DeleteMapping("/beneficiaire/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBeneficiaire(@PathVariable(value="id") Long id)  throws NotFoundException
	{
		service.deleteBeneficiaire(id);
	}



}

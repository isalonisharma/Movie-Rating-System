package com.moviecatalogmicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalogmicroservice.models.Catalog;
import com.moviecatalogmicroservice.services.CatalogService;

@RestController
public class CatalogController {

	@Autowired
	private CatalogService catalogService;

	@RequestMapping("users/{userId}/catalog")
	public List<Catalog> getCatalogItem(@PathVariable("userId") Long userId) {
		List<Catalog> listCatalog = catalogService.getCatalogItem(userId);
		return listCatalog;
	}

}

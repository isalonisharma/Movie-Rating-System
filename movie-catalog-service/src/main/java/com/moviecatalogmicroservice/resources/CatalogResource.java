package com.moviecatalogmicroservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalogmicroservice.models.Catalog;
import com.moviecatalogmicroservice.services.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private CatalogService catalogService;

	@RequestMapping("/{userId}")
	public List<Catalog> getCatalogItem(@PathVariable("userId") String userId) {
		List<Catalog> listCatalog = catalogService.getCatalogItem(userId);
		return listCatalog;
	}

}

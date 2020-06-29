package com.moviecatalogmicroservice.services;

import java.util.List;

import com.moviecatalogmicroservice.models.Catalog;

public interface CatalogService {
	List<Catalog> getCatalogItem(String userId);
}
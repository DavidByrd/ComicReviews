package com.wecancodeit.comicreviews.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ComicRepository {

	private Map<Long, Comic> comicList = new HashMap<>();

	public ComicRepository() {
		Comic saga = new Comic(1L, "Saga", "Saga description", "Saga review");
		Comic theAmazingSpiderMan = new Comic(2L, "The Amazing Spider-Man", "The Amazing-SpiderMan description",
				"The Amazing-SpiderMan review");
		Comic invincible = new Comic(3L, "Invincible", "Invincible description", "Invincible review");

		comicList.put(saga.getId(), saga);
		comicList.put(theAmazingSpiderMan.getId(), theAmazingSpiderMan);
		comicList.put(invincible.getId(), invincible);

	}
//Testing Constructor
	public ComicRepository(Comic... comics) {
		for (Comic comic : comics) {
			comicList.put(comic.getId(), comic);
		}
	}

	public Comic findOne(long comicId) {

		return comicList.get(comicId);
	}

	public Collection<Comic> findAll() {

		return comicList.values();
	}

}

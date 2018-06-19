package com.wecancodeit.comicreviews.demo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComicController {

	@Resource
	ComicRepository comicRepo;

	@RequestMapping("/show-comics")
	public String findAllComics(Model model) {
		model.addAttribute("ComicReviews", comicRepo.findAll());
		return "ComicReviews";

	}

	@RequestMapping("/ComicReviews")
	public String findOneComic(@RequestParam(value = "comicId") Long comicId, Model model) {
		model.addAttribute("ComicReviews", comicRepo.findOne(comicId));
		return "ComicReview";

	}

}

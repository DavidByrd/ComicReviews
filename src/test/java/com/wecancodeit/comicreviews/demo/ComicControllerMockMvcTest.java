package com.wecancodeit.comicreviews.demo;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ComicController.class)
public class ComicControllerMockMvcTest {



	@Resource
	private MockMvc mvc;

	@Mock
	private Comic firstComic;

	@Mock
	private Comic secondComic;

	@MockBean
	private ComicRepository repository;

	@Test
	public void shouldBeOkayForAllComics() throws Exception {
		mvc.perform(get("/show-comics")).andExpect(status().isOk());

	}

	@Test
	public void shouldRouteToAllComicsView() throws Exception {
		mvc.perform(get("/show-comics")).andExpect(view().name(is("ComicReviews")));

	}

	@Test
	public void shouldPutAllComicsIntoModel() throws Exception {
		Collection<Comic> allComics = asList(firstComic, secondComic);
		when(repository.findAll()).thenReturn(allComics);
		mvc.perform(get("/show-comics")).andExpect(model().attribute("ComicReviews", is(allComics)));

	}

	@Test
	public void shouldBeOkayForASingleComic() throws Exception {
		mvc.perform(get("/ComicReviews?comicId=1")).andExpect(status().isOk());

	}

	@Test
	public void shouldRoutToASingleCourseView() throws Exception {
		mvc.perform(get("/ComicReviews?comicId=1")).andExpect(view().name(is("ComicReview")));

	}

	@Test
	public void shouldPutASIngComicIntoTheModel() throws Exception {
		when(repository.findOne(1L)).thenReturn(firstComic);

		mvc.perform(get("/ComicReviews?comicId=1")).andExpect(model().attribute("ComicsReview", is(firstComic)));

	}

}

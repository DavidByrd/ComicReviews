package com.wecancodeit.comicreviews.demo;

public class Comic {

	private long comicId;
	private String title;
	private String description;
	private String review;

	public Comic(long comicId, String title, String description, String review) {
		this.comicId = comicId;
		this.title = title;
		this.description = description;
		this.review = review;
	}

	public Long getId() {

		return comicId;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public String getReview() {
		
		return review;
	}
	
	

}

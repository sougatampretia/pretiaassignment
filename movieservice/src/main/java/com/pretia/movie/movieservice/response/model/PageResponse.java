package com.pretia.movie.movieservice.response.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * This is the Response Model for the service which returns any paged response
 * @author Sougata Maitra
 *
 * @param <T>
 */
@ApiModel(description = "Generic response for all paginated resources. ")
public class PageResponse <T>{
	
	@ApiModelProperty(notes = "Current Page Number")
	int page;
	@ApiModelProperty(notes = "Records per page")
	int per_page;
	@ApiModelProperty(notes = "Total Number of Records")
	long total;
	@ApiModelProperty(notes = "Total Number of Pages")
	int total_pages;
	@ApiModelProperty(notes = "Containts Records list")
	List<T> data;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	

}

package com.example.Tour_Booking.common;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableRequest {
    private int pageNumber;

    private int pageSize;

    private String sortBy;

    private String sortOrder;

    public Sort getSort(){
        return Sort.by(sortOrder.equals("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy));
    }

    public Pageable toPageable(){
        return PageRequest.of(pageNumber, pageSize,getSort());
    }

    public PageableRequest(int pageNumber, int pageSize, String sortBy, String sortOrder){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}

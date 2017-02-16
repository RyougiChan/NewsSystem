package com.news.dao;

import java.util.List;

import com.news.entity.Admin;

public interface AdminDAO {
	
	List<?> search (Admin admin);
	
}

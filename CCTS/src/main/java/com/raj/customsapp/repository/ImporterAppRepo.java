package com.raj.customsapp.repository;

import java.util.List;
import com.raj.customsapp.model.ImporterApplication;

public interface ImporterAppRepo {

	void save(ImporterApplication app);
	List<ImporterApplication> findAll();
	public void update(ImporterApplication imp);
	public ImporterApplication getApp(int id);
}


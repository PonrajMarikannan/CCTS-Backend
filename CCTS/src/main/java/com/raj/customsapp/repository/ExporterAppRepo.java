package com.raj.customsapp.repository;

import java.util.List;
import com.raj.customsapp.model.ExporterApplication;

public interface ExporterAppRepo {

	void save(ExporterApplication app);
	List<ExporterApplication> findAll();
	public void update(ExporterApplication ship);
	public ExporterApplication getApp(int id);
	List<ExporterApplication> findShipStatus(int userId);
}


package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.OrganizerRequest;
import com.example.demo.dto.OrganizerResponse;
import com.example.demo.entity.Organizer;

public interface OrganizerService {
	public OrganizerResponse createOrganizer(OrganizerRequest req);

	public OrganizerResponse getOrganizer(long id);

	public Page<Organizer> searchOrganizers(String q, int page, int size);
}

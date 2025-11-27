package com.example.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrganizerRequest;
import com.example.demo.dto.OrganizerResponse;
import com.example.demo.entity.Organizer;
import com.example.demo.entity.Status;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.OrganizerRepository;
import com.example.demo.service.OrganizerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

	private final OrganizerRepository organizerRepository;
	private final ModelMapper modelMapper;

	@Override
	public OrganizerResponse createOrganizer(OrganizerRequest organizerRequest) {

		if (organizerRepository.existsByEmail(organizerRequest.getEmail())) {
			throw new DuplicateResourceException("Email already exists!");
		}
		
		Organizer organizer = modelMapper.map(organizerRequest, Organizer.class);
		organizer.setOrganizerCode(generateOrganizerCode());
		organizer.setStatus(Status.ACTIVE);
		Organizer savedOrganizer = organizerRepository.save(organizer);
		return modelMapper.map(savedOrganizer, OrganizerResponse.class);
	}

	@Override
	public OrganizerResponse getOrganizer(long id) {
		Organizer existedOrganizer = organizerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
		return modelMapper.map(existedOrganizer, OrganizerResponse.class);
	}

	@Override
	public Page<Organizer> searchOrganizers(String q, int page, int size) {
		return organizerRepository.search(q, PageRequest.of(page, size));
	}

	private String generateOrganizerCode() {
		Long maxId = organizerRepository.findMaxId();
		Long nextId = maxId + 1;
		return String.format("ORG%05d", nextId);
	}

}

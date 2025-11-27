package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrganizerRequest;
import com.example.demo.dto.OrganizerResponse;
import com.example.demo.entity.Organizer;
import com.example.demo.service.OrganizerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {
	private final OrganizerService organizerService;

	@PostMapping
	public ResponseEntity<OrganizerResponse> create(@Valid @RequestBody OrganizerRequest req) {
		OrganizerResponse organizer = organizerService.createOrganizer(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(organizer);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrganizerResponse> getOne(@PathVariable long id) {
		return ResponseEntity.ok(organizerService.getOrganizer(id));
	}

	@GetMapping("/search")
	public ResponseEntity<Page<Organizer>> search(@RequestParam String q, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		return ResponseEntity.ok(organizerService.searchOrganizers(q, page, size));
	}
}

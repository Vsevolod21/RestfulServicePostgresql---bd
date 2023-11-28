package com.example.restfulservicepostgre.controller;

import com.example.restfulservicepostgre.model.Profile;
import com.example.restfulservicepostgre.model.ProfileRequest;
import com.example.restfulservicepostgre.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {

        this.profileService = profileService;
    }

    @GetMapping("/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {

        return profileService.getProfile(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody ProfileRequest request) {
        profileService.createProfile(
                request.firstName(),
                request.lastName(),
                request.age()
        );
    }

    @PutMapping("/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(@Valid @RequestBody ProfileRequest request,
                              @PathVariable int personId) {
        profileService.updateProfile(
                request.firstName(),
                request.lastName(),
                request.age(),
                personId
        );
    }

    @DeleteMapping("/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        profileService.deleteProfile(personId);
    }

}

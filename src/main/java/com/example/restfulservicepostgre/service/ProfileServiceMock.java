package com.example.restfulservicepostgre.service;

import com.example.restfulservicepostgre.exception.ProfileNotFoundException;
import com.example.restfulservicepostgre.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceMock implements ProfileService {
    @Override
    public Profile getProfile(int personId) {
        if (personId == 123) {
            return new Profile(personId,
                    "Vsevolod",
                    "Kononenko",
                    23);
        } else {
            throw new ProfileNotFoundException(personId);
        }
    }

    @Override
    public void createProfile(String firstName, String secondName, int age) {

    }

    @Override
    public void updateProfile(String firstName, String secondName, int age, int id) {

    }

    @Override
    public void deleteProfile(int id) {

    }


}


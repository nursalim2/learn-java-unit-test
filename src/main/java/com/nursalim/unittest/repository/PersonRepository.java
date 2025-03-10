package com.nursalim.unittest.repository;

import com.nursalim.unittest.data.Person;

public interface PersonRepository {
    Person selectById(String id);

    void insert(Person person);
}

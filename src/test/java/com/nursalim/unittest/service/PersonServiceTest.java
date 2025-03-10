package com.nursalim.unittest.service;

import com.nursalim.unittest.data.Person;
import com.nursalim.unittest.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    public void testGetPersonNotFound() {
        assertThrows(IllegalArgumentException.class, () -> personService.get("not found"));
    }

    @Test
    public void testGetPersonSuccess() {
        when(personRepository.selectById("nursalim")).thenReturn(new Person("nursalim", "Nursalim"));
        var person = personService.get("nursalim");

        assertNotNull(person);
        assertEquals("nursalim", person.getId());
        assertEquals("Nursalim", person.getName());
    }

    @Test
    public void testCreatePersonSuccess(){
        var person = personService.register("Nursalim");
        assertNotNull(person);
        assertEquals("Nursalim", person.getName());
        assertNotNull(person.getId());

        verify(personRepository, times(1))
                .insert(new Person(person.getId(), person.getName()));
    }
}

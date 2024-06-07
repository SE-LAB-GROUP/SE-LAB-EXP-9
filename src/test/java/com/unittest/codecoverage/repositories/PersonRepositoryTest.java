package com.unittest.codecoverage.repositories;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.unittest.codecoverage.models.Gender;
import com.unittest.codecoverage.models.Person;

public class PersonRepositoryTest {

    private PersonRepository repository = new PersonRepository();

    @Test
    public void testInsert_shouldThrowNullPointerExceptionWhenPersonIsNull() {
        Person person = null;

        assertThatThrownBy(() -> repository.insert(person))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("person can't be null");
    }

    @Test
    public void testInsert_shouldInsertPersonSuccessfully() {
        Person person = new Person();
        person.setName("Name");
        person.setAge(21);
        person.setGender(Gender.M);

        Person result = repository.insert(person);

        assertEquals(person, result);
    }

    @Test
    public void testUpdate_shouldThrowNullPointerExceptionWhenPersonIsNull() {
        Person person = null;

        assertThatThrownBy(() -> repository.update(person))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("person can't be null");
    }

    @Test
    public void testUpdate_shouldUpdatePersonSuccessfully() {
        Person person = new Person();
        person.setName("UpdatedName");
        person.setAge(25);
        person.setGender(Gender.F);

        // Ensure no exception is thrown
        repository.update(person);
    }

    @Test
    public void testDelete_shouldThrowNullPointerExceptionWhenNameIsNull() {
        String name = null;

        assertThatThrownBy(() -> repository.delete(name))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("name can't be null");
    }

    @Test
    public void testDelete_shouldDeletePersonSuccessfully() {
        String name = "NameToDelete";

        // Ensure no exception is thrown
        repository.delete(name);
    }

    @Test
    public void testGet_shouldThrowNullPointerExceptionWhenNameIsNull() {
        String name = null;

        assertThatThrownBy(() -> repository.get(name))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("name can't be null");
    }

    @Test
    public void testGet_shouldReturnNullWhenPersonNotFound() {
        String name = "NameToGet";

        Person result = repository.get(name);

        assertNull(result);
    }
}

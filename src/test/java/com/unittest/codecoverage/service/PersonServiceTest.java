package com.unittest.codecoverage.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unittest.codecoverage.exceptions.PersonException;
import com.unittest.codecoverage.models.Gender;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import com.unittest.codecoverage.services.PersonService;
import com.unittest.codecoverage.services.impl.PersonServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    PersonService service = new PersonServiceImpl();
    @Mock
    PersonRepository repository;

    @Test
    public void testInsert_shouldInsertPersonWithSuccessWhenAllPersonsInfoIsFilled() {
        Person person = new Person();
        person.setName("Name");
        person.setAge(21);
        person.setGender(Gender.M);

        when(repository.insert(any(Person.class))).thenReturn(person);

        service.insert(person);
    }

    @Test
    public void testInsert_shouldThrowPersonExceptionWhenPersonIsNull() {

        List<String> expectedErrors = Lists.newArrayList("Name is required", "Gender is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = null;

        assertThatThrownBy(() -> service.insert(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

    @Test
    public void testInsert_shouldThrowPersonExceptionWhenPersonNameIsNull() {

        List<String> expectedErrors = Lists.newArrayList("Name is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = new Person();
        person.setGender(Gender.M);

        assertThatThrownBy(() -> service.insert(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

    @Test
    public void testInsert_shouldThrowPersonExceptionWhenPersonNameIsBlank() {

        List<String> expectedErrors = Lists.newArrayList("Name is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = new Person();
        person.setGender(Gender.M);
        person.setName(" ");

        assertThatThrownBy(() -> service.insert(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

    @Test
    public void testInsert_shouldThrowPersonExceptionWhenPersonGenderIsNull() {

        List<String> expectedErrors = Lists.newArrayList("Gender is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = new Person();
        person.setName("Name");
        person.setGender(null);

        assertThatThrownBy(() -> service.insert(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

    @Test
    public void testGet_shouldReturnPersonWhenNameIsValid() {
        Person expectedPerson = new Person();
        String name = "Name";
        expectedPerson.setName("Name");
        expectedPerson.setAge(21);
        expectedPerson.setGender(Gender.M);

        when(repository.get(name)).thenReturn(expectedPerson);

        Person result = service.get(name);

        assertEquals(expectedPerson, result);
    }

    @Test
    public void testGet_shouldThrowPersonExceptionWhenNameIsNull() {
        String name = null;

        assertThatThrownBy(() -> service.get(name))
                .isInstanceOf(PersonException.class)
                .hasMessage("Name is required");
    }

    @Test
    public void testGet_shouldThrowPersonExceptionWhenNameIsBlank() {
        String name = " ";

        assertThatThrownBy(() -> service.get(name))
                .isInstanceOf(PersonException.class)
                .hasMessage("Name is required");
    }

    @Test
    public void testDelete_shouldDeletePersonWhenNameIsValid() {
        String name = "ValidName";

        // No return value to verify for delete, just ensuring no exceptions are thrown
        service.delete(name);
    }

    @Test
    public void testDelete_shouldThrowPersonExceptionWhenNameIsNull() {
        String name = null;

        assertThatThrownBy(() -> service.delete(name))
                .isInstanceOf(PersonException.class)
                .hasMessage("Name is required");
    }

    @Test
    public void testDelete_shouldThrowPersonExceptionWhenNameIsBlank() {
        String name = " ";

        assertThatThrownBy(() -> service.delete(name))
                .isInstanceOf(PersonException.class)
                .hasMessage("Name is required");
    }


    @Test
    public void testUpdate_shouldUpdatePersonSuccessfullyWhenAllPersonsInfoIsFilled() {
        Person person = new Person();
        person.setName("UpdatedName");
        person.setAge(25);
        person.setGender(Gender.F);

        // No return value to verify for update, just ensuring no exceptions are thrown
        service.update(person);
    }

    @Test
    public void testUpdate_shouldThrowPersonExceptionWhenPersonIsNull() {
        List<String> expectedErrors = Lists.newArrayList("Name is required", "Gender is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = null;

        assertThatThrownBy(() -> service.update(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

    @Test
    public void testUpdate_shouldThrowPersonExceptionWhenPersonNameIsNull() {
        List<String> expectedErrors = Lists.newArrayList("Name is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = new Person();
        person.setGender(Gender.F);

        assertThatThrownBy(() -> service.update(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

    @Test
    public void testUpdate_shouldThrowPersonExceptionWhenPersonGenderIsNull() {
        List<String> expectedErrors = Lists.newArrayList("Gender is required");
        String expectedMessage = String.join(";", expectedErrors);
        Person person = new Person();
        person.setName("UpdatedName");
        person.setGender(null);

        assertThatThrownBy(() -> service.update(person))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);
    }

}

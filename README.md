# Report


### PersonRepositoryTest

Test Insert Method:
Ensures that NullPointerException is thrown when a null Person is passed.
Ensures that a valid Person is successfully inserted and returned.

Test Update Method:
Ensures that NullPointerException is thrown when a null Person is passed.
Ensures that a valid Person is successfully updated (no exception is thrown).

Test Delete Method:
Ensures that NullPointerException is thrown when a null name is passed.
Ensures that a valid name is successfully deleted (no exception is thrown).

Test Get Method:
Ensures that NullPointerException is thrown when a null name is passed.
Ensures that the method returns null when the Person is not found.


### PersonServiceTest
testUpdate_shouldUpdatePersonWithSuccessWhenAllPersonsInfoIsFilled:
Tests that the update method successfully updates a Person object when all required information is provided.

testUpdate_shouldThrowPersonExceptionWhenPersonIsNull:
Tests that the update method throws a PersonException when a null person is passed.

testUpdate_shouldThrowPersonExceptionWhenPersonNameIsNull:
Tests that the update method throws a PersonException when the person's name is null.

testUpdate_shouldThrowPersonExceptionWhenPersonGenderIsNull:
Tests that the update method throws a PersonException when the person's gender is null.

testGet_shouldReturnPersonWhenNameIsValid:
Tests that the get method returns the correct Person object when a valid name is provided.

testGet_shouldThrowPersonExceptionWhenNameIsNull:
Tests that the get method throws a PersonException when the name is null.

testGet_shouldThrowPersonExceptionWhenNameIsBlank:
Tests that the get method throws a PersonException when the name is blank.

testDelete_shouldDeletePersonWhenNameIsValid:
Tests that the delete method successfully deletes a Person object when a valid name is provided.

testDelete_shouldThrowPersonExceptionWhenNameIsNull:
Tests that the delete method throws a PersonException when the name is null.

testDelete_shouldThrowPersonExceptionWhenNameIsBlank:
Tests that the delete method throws a PersonException when the name is blank.

testUpdate_shouldUpdatePersonSuccessfullyWhenAllPersonsInfoIsFilled:
Tests that the update method successfully updates a Person object when all required information is provided.
This test ensures that no exceptions are thrown when the Person object is valid.

testUpdate_shouldThrowPersonExceptionWhenPersonIsNull:
Tests that the update method throws a PersonException when a null person is passed.
The expected error messages and exception message are defined.

testUpdate_shouldThrowPersonExceptionWhenPersonNameIsNull:
Tests that the update method throws a PersonException when the person's name is null.
The expected error message is defined.

testUpdate_shouldThrowPersonExceptionWhenPersonGenderIsNull:
Tests that the update method throws a PersonException when the person's gender is null.
The expected error message is defined.

package com.vagdeviitsol.fitwala;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;


@Transactional

public class JPASpecificationIntegrationTest {

	 @Autowired
	    private UserRepository repository;

	    private Search userJohn;
	    private Search userTom;

	    @Before(value = "")
	    public void init() {
	        userJohn = new Search();
	        userJohn.setFirstName("John");
	        userJohn.setLastName("Doe");
	        userJohn.setEmail("john@doe.com");
	        userJohn.setAge(22);
	        repository.save(userJohn);

	        userTom = new Search();
	        userTom.setFirstName("Tom");
	        userTom.setLastName("Doe");
	        userTom.setEmail("tom@doe.com");
	        userTom.setAge(26);
	        repository.save(userTom);
	    }
	    @Test
	    public void givenLast_whenGettingListOfUsers_thenCorrect() {
	        UserSpecification spec = new UserSpecification();
	        SearchCriteria sc= new SearchCriteria("lastName",":","doe");
	        List<Search> results = repository.findAll();

	        assertThat(userJohn, isIn(results));
	        assertThat(userTom, isIn(results));
	    }
		private void assertThat(Search userTom2, Object in) {
			// TODO Auto-generated method stub

		}
		private Object isIn(List<Search> results) {
			// TODO Auto-generated method stub
			return null;
		}
}

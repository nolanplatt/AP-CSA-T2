package com.nighthawk.csa.data.SQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    /*
    This class has an instance of Java Persistence API (JPA)
    -- @Autowired annotation. Allows Spring to resolve and inject collaborating beans into our bean.
    -- Spring Data JPA will generate a proxy instance
    -- Below are some CRUD methods that we can use with our database
    */
    @Service
    @Transactional
    public class PersonSqlRepository {

        @Autowired
        private PersonJpaRepository jpa;

        public  List<Person>listAll() {
            return jpa.findAll();
        }

        // custom query to find anything containing term in name or email ignoring case
        public  List<Person>listLike(String term) {
            return jpa.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrSportContainingIgnoreCase(term, term, term);
        }

        // custom query to find anything containing term in name or email ignoring case
        public  List<Person>listLikeNative(String term) {
            String like_term = String.format("%%%s%%",term);  // Like required % rappers
            return jpa.findByLikeTermNative(like_term);
        }

        public void save(Person person) {
            jpa.save(person);
        }

        public Person get(long id) {
            return jpa.findById(id).get();
        }

        public void delete(long id) {
            jpa.deleteById(id);
        }
    }
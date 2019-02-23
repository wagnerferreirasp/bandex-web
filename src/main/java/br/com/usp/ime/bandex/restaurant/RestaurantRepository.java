package br.com.usp.ime.bandex.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wagner on 21/11/16.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

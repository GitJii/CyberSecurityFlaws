/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Order;


/**
 *
 * @author Jaakko-PC
 */

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}

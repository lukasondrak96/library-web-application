package com.lukasondrak.libraryinformationsystem.features.loanofitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanOfItemRepository extends JpaRepository<LoanOfItem, Long> {

}

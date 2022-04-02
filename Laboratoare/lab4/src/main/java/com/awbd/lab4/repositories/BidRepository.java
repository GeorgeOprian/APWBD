package com.awbd.lab4.repositories;

import com.awbd.lab4.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}

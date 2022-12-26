package com.example.ooadexam.repositories;

import com.example.ooadexam.models.UserBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBillRepository extends CrudRepository<UserBill, Long> {
}

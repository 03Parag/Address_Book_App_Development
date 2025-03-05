package com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Repository;

import com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
}

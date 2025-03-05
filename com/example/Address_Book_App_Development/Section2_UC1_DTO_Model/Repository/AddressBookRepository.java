package com.example.Address_Book_App_Development.Section2_UC1_DTO_Model.Repository;

import com.example.Address_Book_App_Development.Section2_UC1_DTO_Model.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
}


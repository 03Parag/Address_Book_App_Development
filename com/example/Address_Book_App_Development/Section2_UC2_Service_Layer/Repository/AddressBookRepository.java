package com.example.Address_Book_App_Development.Section2_UC2_Service_Layer.Repository;

import com.example.Address_Book_App_Development.Section2_UC2_Service_Layer.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
    // Additional custom queries can be added here if needed
}

package com.example.Address_Book_App_Development.Section2_UC3_Store.Repository;

import com.example.Address_Book_App_Development.Section2_UC3_Store.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
    // Custom query methods can be added if needed
}


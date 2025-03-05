package com.example.Address_Book_App_Development.Section2_UC2_Service_Layer.Service;

import com.example.Address_Book_App_Development.Section2_UC2_Service_Layer.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section2_UC2_Service_Layer.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    // Get all address book entries
    public List<AddressBookModel> getAllEntries() {
        return addressBookRepository.findAll();
    }

    // Get an address book entry by ID
    public AddressBookModel getEntryById(Long id) {
        Optional<AddressBookModel> addressBook = addressBookRepository.findById(id);
        return addressBook.orElse(null);  // Return null if not found
    }

    // Save or update address book entry
    public AddressBookModel saveOrUpdateEntry(AddressBookModel addressBook) {
        return addressBookRepository.save(addressBook);
    }

    // Delete address book entry by ID
    public void deleteEntry(Long id) {
        addressBookRepository.deleteById(id);
    }
}

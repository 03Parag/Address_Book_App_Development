package com.example.Address_Book_App_Development.Section2_UC3_Store.Service;

import com.example.Address_Book_App_Development.Section2_UC3_Store.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section2_UC3_Store.DTO.AddressBookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    // In-memory storage for AddressBook
    private List<AddressBookModel> addressBookList = new ArrayList<>();
    private Long nextId = 1L;

    // Get all address book entries
    public List<AddressBookModel> getAllEntries() {
        return addressBookList;
    }

    // Get an address book entry by ID
    public AddressBookModel getEntryById(Long id) {
        for (AddressBookModel addressBook : addressBookList) {
            if (addressBook.getId().equals(id)) {
                return addressBook;
            }
        }
        return null;  // Return null if not found
    }

    // Save or update address book entry
    public AddressBookModel saveOrUpdateEntry(AddressBookDTO addressBookDTO) {
        AddressBookModel addressBook = new AddressBookModel();
        addressBook.setId(nextId++);
        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());

        addressBookList.add(addressBook);
        return addressBook;
    }

    // Update address book entry by ID
    public AddressBookModel updateEntry(Long id, AddressBookDTO addressBookDTO) {
        AddressBookModel existingAddressBook = getEntryById(id);
        if (existingAddressBook != null) {
            existingAddressBook.setName(addressBookDTO.getName());
            existingAddressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            existingAddressBook.setEmail(addressBookDTO.getEmail());
            return existingAddressBook;
        }
        return null;
    }

    // Delete address book entry by ID
    public boolean deleteEntry(Long id) {
        AddressBookModel addressBook = getEntryById(id);
        if (addressBook != null) {
            addressBookList.remove(addressBook);
            return true;
        }
        return false;
    }
}


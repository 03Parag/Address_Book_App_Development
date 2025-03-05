package com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Service;

import com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private List<AddressBookModel> addressBook = new ArrayList<>();

    public List<AddressBookModel> getAllAddressBookEntries() {
        return addressBook;
    }

    public AddressBookModel getAddressBookEntryByName(String name) {
        Optional<AddressBookModel> addressBookEntry = addressBook.stream().filter(entry -> entry.getName().equals(name)).findFirst();
        return addressBookEntry.orElse(null);
    }

    public AddressBookModel createOrUpdateAddressBookEntry(AddressBookModel addressBookEntry) {
        deleteAddressBookEntry(addressBookEntry.getName());
        addressBook.add(addressBookEntry);
        return addressBookEntry;
    }

    public void deleteAddressBookEntry(String name) {
        addressBook.removeIf(entry -> entry.getName().equals(name));
    }
}

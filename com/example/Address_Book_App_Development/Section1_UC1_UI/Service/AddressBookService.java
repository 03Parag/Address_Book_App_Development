package com.example.Address_Book_App_Development.Section1_UC1_UI.Service;

import com.example.Address_Book_App_Development.Section1_UC1_UI.Model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    // In-memory storage for address book entries
    private List<AddressBookModel> addressBookEntries = new ArrayList<>();

    // Add a new address book entry
    public AddressBookModel addAddressBookEntry(AddressBookModel entry) {
        addressBookEntries.add(entry);
        return entry;
    }

    // Get all address book entries
    public List<AddressBookModel> getAllAddressBookEntries() {
        return addressBookEntries;
    }

    // Get a specific address book entry by name
    public AddressBookModel getAddressBookEntryByName(String name) {
        Optional<AddressBookModel> entry = addressBookEntries.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst();
        return entry.orElse(null);
    }

    // Delete an address book entry by name
    public boolean deleteAddressBookEntry(String name) {
        return addressBookEntries.removeIf(e -> e.getName().equalsIgnoreCase(name));
    }

    // Update an existing address book entry
    public AddressBookModel updateAddressBookEntry(String name, AddressBookModel updatedEntry) {
        AddressBookModel existingEntry = getAddressBookEntryByName(name);
        if (existingEntry != null) {
            existingEntry.setPhoneNumber(updatedEntry.getPhoneNumber());
            existingEntry.setEmail(updatedEntry.getEmail());
            existingEntry.setAddress(updatedEntry.getAddress());
            return existingEntry;
        }
        return null;
    }
}

package com.example.Address_Book_App_Development.Section1_UC1_UI.Controller;

import com.example.Address_Book_App_Development.Section1_UC1_UI.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section1_UC1_UI.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Add a new address book entry (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressBookModel addAddressBookEntry(@RequestBody AddressBookModel addressBookEntry) {
        return addressBookService.addAddressBookEntry(addressBookEntry);
    }

    // Get all address book entries (GET)
    @GetMapping
    public List<AddressBookModel> getAllAddressBookEntries() {
        return addressBookService.getAllAddressBookEntries();
    }

    // Get an address book entry by name (GET)
    @GetMapping("/{name}")
    public AddressBookModel getAddressBookEntryByName(@PathVariable String name) {
        return addressBookService.getAddressBookEntryByName(name);
    }

    // Update an existing address book entry (PUT)
    @PutMapping("/{name}")
    public AddressBookModel updateAddressBookEntry(@PathVariable String name,
                                                   @RequestBody AddressBookModel updatedEntry) {
        return addressBookService.updateAddressBookEntry(name, updatedEntry);
    }

    // Delete an address book entry by name (DELETE)
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddressBookEntry(@PathVariable String name) {
        addressBookService.deleteAddressBookEntry(name);
    }
}

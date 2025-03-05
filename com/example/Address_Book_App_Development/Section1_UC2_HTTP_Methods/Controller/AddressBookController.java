package com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Controller;

import com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section1_UC2_HTTP_Methods.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Get all address book entries (GET)
    @GetMapping
    public ResponseEntity<List<AddressBookModel>> getAllAddressBookEntries() {
        List<AddressBookModel> addressBookEntries = addressBookService.getAllAddressBookEntries();
        return new ResponseEntity<>(addressBookEntries, HttpStatus.OK);
    }

    // Get address book entry by name (GET)
    @GetMapping("/{name}")
    public ResponseEntity<AddressBookModel> getAddressBookEntryByName(@PathVariable String name) {
        AddressBookModel addressBookEntry = addressBookService.getAddressBookEntryByName(name);
        if (addressBookEntry != null) {
            return new ResponseEntity<>(addressBookEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create or update an address book entry (POST)
    @PostMapping
    public ResponseEntity<AddressBookModel> createOrUpdateAddressBookEntry(@RequestBody AddressBookModel addressBookEntry) {
        AddressBookModel savedAddressBookEntry = addressBookService.createOrUpdateAddressBookEntry(addressBookEntry);
        return new ResponseEntity<>(savedAddressBookEntry, HttpStatus.CREATED);
    }

    // Update address book entry by name (PUT)
    @PutMapping("/{name}")
    public ResponseEntity<AddressBookModel> updateAddressBookEntry(@PathVariable String name, @RequestBody AddressBookModel addressBookEntry) {
        addressBookEntry.setName(name);
        AddressBookModel updatedAddressBookEntry = addressBookService.createOrUpdateAddressBookEntry(addressBookEntry);
        return new ResponseEntity<>(updatedAddressBookEntry, HttpStatus.OK);
    }

    // Delete address book entry by name (DELETE)
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteAddressBookEntry(@PathVariable String name) {
        addressBookService.deleteAddressBookEntry(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

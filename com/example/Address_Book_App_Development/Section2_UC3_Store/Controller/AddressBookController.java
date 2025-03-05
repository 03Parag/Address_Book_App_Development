package com.example.Address_Book_App_Development.Section2_UC3_Store.Controller;

import com.example.Address_Book_App_Development.Section2_UC3_Store.DTO.AddressBookDTO;
import com.example.Address_Book_App_Development.Section2_UC3_Store.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section2_UC3_Store.Service.AddressBookService;
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
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        List<AddressBookModel> addressBooks = addressBookService.getAllEntries();
        return new ResponseEntity<>(addressBooks, HttpStatus.OK);
    }

    // Get address book entry by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getEntryById(@PathVariable Long id) {
        AddressBookModel addressBook = addressBookService.getEntryById(id);
        if (addressBook != null) {
            return new ResponseEntity<>(addressBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new address book entry (POST)
    @PostMapping
    public ResponseEntity<AddressBookModel> createAddressBookEntry(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel savedEntry = addressBookService.saveOrUpdateEntry(addressBookDTO);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    // Update address book entry by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateAddressBook(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel updatedEntry = addressBookService.updateEntry(id, addressBookDTO);
        if (updatedEntry != null) {
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete address book entry by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressBook(@PathVariable Long id) {
        boolean isDeleted = addressBookService.deleteEntry(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

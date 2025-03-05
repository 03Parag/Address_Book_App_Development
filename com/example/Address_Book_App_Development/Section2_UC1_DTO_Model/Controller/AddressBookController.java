package com.example.Address_Book_App_Development.Section2_UC1_DTO_Model.Controller;

import com.example.Address_Book_App_Development.Section2_UC1_DTO_Model.DTO.AddressBookDTO;
import com.example.Address_Book_App_Development.Section2_UC1_DTO_Model.Model.AddressBookModel;
import com.example.Address_Book_App_Development.Section2_UC1_DTO_Model.Service.AddressBookService;
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

    // Create or update an address book entry (POST)
    @PostMapping
    public ResponseEntity<AddressBookModel> createOrUpdateEntry(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel addressBook = new AddressBookModel();
        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());

        AddressBookModel savedEntry = addressBookService.saveOrUpdateEntry(addressBook);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    // Update address book entry by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookModel addressBook = addressBookService.getEntryById(id);
        if (addressBook != null) {
            addressBook.setName(addressBookDTO.getName());
            addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            addressBook.setEmail(addressBookDTO.getEmail());

            AddressBookModel updatedEntry = addressBookService.saveOrUpdateEntry(addressBook);
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete address book entry by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        addressBookService.deleteEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

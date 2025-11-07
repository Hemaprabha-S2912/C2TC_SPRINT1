package com.tnsif.certificateServicesprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.certificateServicesprint1.Certificate;
import com.tnsif.certificateServicesprint1.service.CertificateService;

import jakarta.persistence.NoResultException;

@RestController
public class CertificateController {

    @Autowired
    private CertificateService c;  // creating object for CertificateService for method mapping

    // GET all certificates
    @GetMapping("/certificateservice")
    public List<Certificate> list() {
        return c.listAll();
    }

    // POST - Add new certificate
    @PostMapping("/certificateservice")
    public void add(@RequestBody Certificate c1) {
        c.save(c1);
    }

    // GET - Get certificate by ID
    @GetMapping("/certificateservice/{id}")
    public ResponseEntity<Certificate> get(@PathVariable Integer id) {
        try {
            Certificate c2 = c.get(id);
            return new ResponseEntity<Certificate>(c2, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Delete certificate by ID
    @DeleteMapping("/certificateservice/{id}")
    public void delete(@PathVariable Integer id) {
        c.delete(id);
    }

    // PUT - Update certificate by ID
    @PutMapping("/certificateservice/{id}")
    public ResponseEntity<Certificate> update(@PathVariable Integer id, @RequestBody Certificate update_c) {
        try {
            Certificate exist_c = c.get(id);

            exist_c.setC_name(update_c.getC_name());
            exist_c.setIssuedBy(update_c.getIssuedBy());
            exist_c.setIssueDate(update_c.getIssueDate());
            exist_c.setExpiryDate(update_c.getExpiryDate());
            exist_c.setCourse(update_c.getCourse());
            exist_c.setStudentName(update_c.getStudentName());

            c.update(exist_c);
            return new ResponseEntity<Certificate>(exist_c, HttpStatus.OK);

        } catch (NoResultException e) {
            return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
        }
    }
}

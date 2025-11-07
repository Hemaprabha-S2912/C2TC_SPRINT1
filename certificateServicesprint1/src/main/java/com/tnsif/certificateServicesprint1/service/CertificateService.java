package com.tnsif.certificateServicesprint1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tnsif.certificateServicesprint1.Certificate;
import com.tnsif.certificateServicesprint1.repository.CertificateRepository;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository repo;

    public List<Certificate> listAll() {
        return repo.findAll();
    }

    public void save(Certificate c) {
        repo.save(c);
    }

    public Certificate get(Integer cid) {
        return repo.findById(cid).orElse(null);
    }

    public void delete(Integer cid) {
        repo.deleteById(cid);
    }

    public void update(Certificate c) {
        repo.save(c);
    }
}

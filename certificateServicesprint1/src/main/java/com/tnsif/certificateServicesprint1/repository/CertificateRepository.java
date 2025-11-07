package com.tnsif.certificateServicesprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.certificateServicesprint1.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
}

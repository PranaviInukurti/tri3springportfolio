package com.nighthawk.spring_portfolio.mvc.upload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}
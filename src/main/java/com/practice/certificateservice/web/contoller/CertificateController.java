package com.practice.certificateservice.web.contoller;

import com.practice.certificateservice.service.CertificateService;
import com.practice.certificateservice.service.CertificateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class CertificateController {

    private final CertificateServiceImpl certificateService;

    @GetMapping("cert/{name}")
    public ResponseEntity<byte[]> getCertificate(@PathVariable String name) {
        byte[] pdf = certificateService.createCertificate(name);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdf.length)
                .body(pdf);
    }

    @GetMapping("cert/download/{name}")
    public ResponseEntity<byte[]> uploadCertificateSec(@PathVariable String name) {
        byte[] pdf = certificateService.createCertificate(name);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdf.length)
                .header("Content-Disposition", "attachment; filename=" + name + ".pdf")
                .body(pdf);
    }
}

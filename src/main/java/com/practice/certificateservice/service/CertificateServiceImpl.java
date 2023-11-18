package com.practice.certificateservice.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

    private final Configuration configuration;

    @SneakyThrows
    @Override
    public byte[] createCertificate(String name) {

        String html = createHtml(name);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ConverterProperties converterProperties = new ConverterProperties();

        HtmlConverter.convertToPdf(html, out, converterProperties);
        return out.toByteArray();
    }

    @SneakyThrows
    private String createHtml(String name) {
        StringWriter writer = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);
        configuration.getTemplate("Congratulations.ftlh")
                .process(model, writer);
        return writer.getBuffer().toString();
    }

}

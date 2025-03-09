package com.tcaputi.back.caccorporationserver.service;

import com.tcaputi.back.caccorporationserver.entity.Client;
import com.tcaputi.back.caccorporationserver.entity.Invoice;
import com.tcaputi.back.caccorporationserver.repository.ClientRepository;
import com.tcaputi.back.caccorporationserver.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, ClientRepository clientRepository) {
        this.invoiceRepository = invoiceRepository;
        this.clientRepository = clientRepository;
    }

    public Invoice createInvoice(UUID clientId, Long amount, LocalDateTime dueDate) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Invoice invoice = new Invoice(client, "INV-" + UUID.randomUUID(), amount, dueDate);
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getClientInvoices(UUID clientId) {
        return invoiceRepository.findByClientId(clientId);
    }

    public Invoice markAsPaid(UUID invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoice.setPaid(true);
        return invoiceRepository.save(invoice);
    }
}
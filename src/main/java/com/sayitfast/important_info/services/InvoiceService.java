package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Invoice;
import com.sayitfast.important_info.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    //Return list of invoices
    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    //SAve new invoice
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    //get by id
    public Optional<Invoice> findById(int id) {
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }

}

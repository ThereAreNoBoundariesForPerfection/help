package our.war.help.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import our.war.help.config.FormatterDateForDataBase;
import our.war.help.exception.PaymentNotFoundException;
import our.war.help.model.Payment;
import our.war.help.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class PaymentsController {
    private final PaymentRepository paymentRepository;
    private final FormatterDateForDataBase formatterDateForDataBase;

    @Autowired
    public PaymentsController(PaymentRepository paymentRepository, FormatterDateForDataBase formatterDateForDataBase) {
        this.paymentRepository = paymentRepository;
        this.formatterDateForDataBase = formatterDateForDataBase;
    }

    @PostMapping("/payments")
    // @ApiOperation("create new payments")
    public ResponseEntity<Void> newPayments(@RequestBody Payment payment) {
        payment.setDate(formatterDateForDataBase.formatterDefault(LocalDateTime.now()));
        paymentRepository.save(payment);
        return ok().build();
    }

    @GetMapping("/payments")
    //@ApiOperation("get all payments")
    public List<Payment> getAllPayments() throws PaymentNotFoundException {
        List<Payment> payments = paymentRepository.findAll();
        if (!payments.isEmpty()) {
            return payments;
        }
        throw new PaymentNotFoundException("Payments not found");
    }

    @GetMapping("/payments/{id}")
    //@ApiOperation("get all payments by id")
    public List<Payment> getAllPaymentsById(@PathVariable Long id) throws PaymentNotFoundException {
        List<Payment> payments = paymentRepository.findAllById(Collections.singleton(id));
        if (!payments.isEmpty()) {
            return payments;
        }
        throw new PaymentNotFoundException("Payments not found");
    }
}

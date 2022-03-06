package br.com.marques.payrollapi.controllers;

import br.com.marques.payrollapi.domain.Payroll;
import br.com.marques.payrollapi.domain.User;
import br.com.marques.payrollapi.feignClients.UserFeign;
import br.com.marques.payrollapi.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
        return  ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));
    }
}

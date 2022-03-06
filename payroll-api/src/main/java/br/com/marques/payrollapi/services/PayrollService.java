package br.com.marques.payrollapi.services;

import br.com.marques.payrollapi.domain.Payroll;
import br.com.marques.payrollapi.domain.User;
import br.com.marques.payrollapi.feignClients.UserFeign;
import br.com.marques.payrollapi.services.exceptions.UserNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;

    @Autowired
    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            User user = feign.findById(workerId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            }
        }catch (FeignException.NotFound ex) {
            throw new UserNotFoundException("Object Not Found");
        }catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}

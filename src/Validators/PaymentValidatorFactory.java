package Validators;

import java.util.ArrayList;
import java.util.List;

public class PaymentValidatorFactory {
    public Iterable<PaymentValidatorBase> GetValidators() {
        List<PaymentValidatorBase> validators = new ArrayList<PaymentValidatorBase>();
        validators.add(new BankCardValidator());
        return validators;
    }
}

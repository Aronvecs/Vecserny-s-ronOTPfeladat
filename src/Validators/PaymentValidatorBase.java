package Validators;


import Classes.Payment;

public abstract class PaymentValidatorBase {
    public abstract boolean Validate(Payment line);
    public abstract String NotValid(Payment line);
}

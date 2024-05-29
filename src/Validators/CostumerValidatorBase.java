package Validators;

import Classes.Costumer;

public abstract class CostumerValidatorBase {
    public abstract boolean Validate(Costumer line);
    public abstract String NotValid(Costumer line);
}

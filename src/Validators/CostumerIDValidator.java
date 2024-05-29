package Validators;

import Classes.Costumer;

public class CostumerIDValidator extends CostumerValidatorBase {

    @Override
    public boolean Validate(Costumer line) {
        return line.getId().length()<2;
    }

    @Override
    public String NotValid(Costumer line) {
        return "This " + line.getId() +" is not a valid ID";
    }
}

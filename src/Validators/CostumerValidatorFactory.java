package Validators;

import java.util.ArrayList;
import java.util.List;

public class CostumerValidatorFactory {
    public Iterable<CostumerValidatorBase> GetValidators() {
        List<CostumerValidatorBase> validators = new ArrayList<>();
        validators.add(new CostumerIDValidator());
        return validators;
    }
}

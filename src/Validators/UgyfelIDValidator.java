package Validators;

public class UgyfelIDValidator extends ValidatorBase {

    @Override
    public boolean Validate(String line) {
        return line.length()>2;
    }
}

package org.talentboost.validators;

public class AlphanumericCharactersAndSpaceValidator extends Validator {
    private static final String PATERN = "^[a-zA-Z0-9\\s]+";

    private static AlphanumericCharactersAndSpaceValidator instance = null;

    private AlphanumericCharactersAndSpaceValidator() {
    };

    public static AlphanumericCharactersAndSpaceValidator getInstance() {
        if (instance == null) {
            instance = new AlphanumericCharactersAndSpaceValidator();
        }
        return instance;
    }

    @Override
    protected String getPattern() {
        return PATERN;
    }
}

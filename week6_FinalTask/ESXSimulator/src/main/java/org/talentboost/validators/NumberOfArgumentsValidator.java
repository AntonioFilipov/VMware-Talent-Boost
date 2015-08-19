package org.talentboost.validators;

import java.util.List;

public class NumberOfArgumentsValidator {
    public static boolean validate(List<String> cmdargs, int numberOfCommandArguments) {
        int numberOfInputArguments = cmdargs.size();

        if (numberOfInputArguments != numberOfCommandArguments) {
            return false;
        }

        return true;
    }
}

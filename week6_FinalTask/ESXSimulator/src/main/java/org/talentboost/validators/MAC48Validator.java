package org.talentboost.validators;

public class MAC48Validator extends Validator{

    private static final String PATTERN = "^([0-9A-Fa-f]{2}[-]){5}[0-9A-Fa-f]{2}$";
    private static MAC48Validator instance = null;
    
    private MAC48Validator(){};
    
    public static MAC48Validator getInstance(){
        if(instance == null) {
            instance = new MAC48Validator();
         }
         return instance;
    }
    
    @Override
    protected String getPattern() {
        return PATTERN;
    }
    
}

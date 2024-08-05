package org.example.masalfood.Business.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class RealEmailValidator implements ConstraintValidator<RealEmail, String> {

    private static final String EMAIL_PATTERN =
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private Pattern pattern;

    @Override
    public void initialize(RealEmail constraintAnnotation) {
        pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || !pattern.matcher(email).matches()) {
            return false;
        }
        return isEmailDomainValid(email);
    }

    private boolean isEmailDomainValid(String email) {
        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String domain = parts[1];

        try {
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
            DirContext ctx = new InitialDirContext(env);
            Attributes attributes = ctx.getAttributes(domain, new String[]{"MX"});
            return attributes.get("MX") != null;
        } catch (NamingException e) {
            return false;
        }
    }
}

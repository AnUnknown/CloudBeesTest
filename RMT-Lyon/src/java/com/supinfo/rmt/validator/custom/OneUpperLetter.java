
package com.supinfo.rmt.validator.custom;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Francois
 *
 */
@Pattern(regexp = ".*[A-Z].*", message = "Il faut au moins 1 caractere en majuscule")
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface OneUpperLetter {

    String message() default "Votre mot de passe n'est pas assez fort";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

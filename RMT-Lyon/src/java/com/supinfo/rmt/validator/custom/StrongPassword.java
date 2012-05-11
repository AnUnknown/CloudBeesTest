package com.supinfo.rmt.validator.custom;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Francois
 */
@NotNull
@Size(min=6)
@OneUpperLetter
@OneLowerLetter
@OneNumber
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface StrongPassword {

    String message() default "Votre mot de passe n'est pas assez fort";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

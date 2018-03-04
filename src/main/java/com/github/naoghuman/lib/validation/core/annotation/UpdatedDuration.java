/**
 * Copyright (C) 2018 - 2018 Naoghuman
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see &lt;http://www.gnu.org/licenses/&gt;.
 */
package com.github.naoghuman.lib.validation.core.annotation;

import com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The annotation {@code UpdatedDuration} lets the developer verify if a given 
 * {@link java.time.LocalDateTime} is between in a {@link java.time.Duration} 
 * which starts with {@link java.time.LocalDateTime#now()} and ends with 
 * {@code weeks()}.<br>
 * If a given {@code LocalDateTime} is in the range from the {@code Duration} then 
 * the validated entity can be flagged as {@code 'Updated'}.
 * <p>
 * For example given is:<br>
 * TODO
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 * @see    java.time.LocalDateTime#now()
 */
@Target({ FIELD, LOCAL_VARIABLE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UpdatedDurationValidator.class)
public @interface UpdatedDuration {
    
    /**
     * Returns the message key for the message if 
     * {@link com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator} 
     * verify that the checked {@link java.time.LocalDateTime} is in the defined 
     * {@link java.time.Duration}.
     * <p>
     * The message for the key can be found in:<br>
     *  - {@code com.github.naoghuman.lib.validation.core.ValidationMessages.properties}
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @return the message key.
     * @see    com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator
     * @see    java.time.Duration
     * @see    java.time.LocalDateTime
     */
    public String message() default "{com.github.naoghuman.lib.validation.core.annotation.updatedduration.message}"; // NOI18N
    
    /**
     * The attribute {@code groups} allows the specification of validation groups, 
     * to which this constraint belongs.
     * <p>
     * This must be default an empty array of type Class&lt;?&gt;.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @return the groups which should be validate.
     */
    public Class<?>[] groups() default { };
    
    /**
     * The attribute {@code payload} can be used by clients of the {@code Bean Validation API} 
     * to assign custom payload objects to a constraint. This attribute is not used by the API 
     * itself.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @return the payload which should be validate.
     */
    public Class<? extends Payload>[] payload() default { };
    
    /**
     * The attribute {@code weeks} defines the end-point from the {@link java.time.Duration} 
     * which starts with {@link java.time.LocalDateTime#now()}.
     * <br>
     * If a given {@code LocalDateTime} is in the range from the {@code Duration} then the 
     * validated entity can be flagged as {@code 'Updated'}.
     * <p>
     * Default value is {@code 4} weeks.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @return the end-point from the {@code Duration} in weeks.
     * @see    java.time.LocalDateTime#now()
     */
    public int weeks() default 4;
    
}

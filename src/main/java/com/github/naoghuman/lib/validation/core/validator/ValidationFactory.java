/**
 * Copyright (C) 2018 - 2018 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.validation.core.validator;

import java.util.Optional;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Simple factory class which alloweds momentary to access an initialized instance 
 * from a {@link javax.validation.Validator} using the factory defaults for message 
 * interpolator, traversable resolver and constraint validator factory.
 * 
 * @author Naoghuman
 * @since  0.2.0
 * @see    javax.validation.Validator
 */
public final class ValidationFactory {
    
    private static final Optional<ValidationFactory> INSTANCE = Optional.of(new ValidationFactory());

    /**
     * Returns a singleton instance from the class {@code ValidationFactory}.
     *
     * @author Naoghuman
     * @since  0.2.0
     * @return a singleton instance from this class {@code ValidationFactory}.
     */
    public static final ValidationFactory getDefault() {
        return INSTANCE.get();
    }
    
    private ValidatorFactory validatorFactory;
    private Validator        validator;

    private ValidationFactory() {
        this.initialize();
    }
    
    private void initialize() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator        = validatorFactory.getValidator();
    }
    
    /**
     * Returns an initialized {@link Validator} instance using the
     * factory defaults for message interpolator, traversable resolver
     * and constraint validator factory.
     * <p>
     * Validator instances can be pooled and shared by the implementation.
     *
     * @author Naoghuman
     * @since  0.2.0
     * @return an initialized {@code Validator} instance.
     */
    public Validator getValidator() {
        return validator;
    }
    
}

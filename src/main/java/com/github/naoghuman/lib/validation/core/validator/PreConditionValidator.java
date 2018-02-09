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

import java.util.Objects;
import java.util.Optional;

/**
 * This {@code Class} contains different methods to validate if an {@link java.lang.Object} 
 * conforms specific behaviours or not. For example if an {@code Object} is {@code NULL} or not.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @see    java.lang.Object
 */
public final class PreConditionValidator {
    
    private static final Optional<PreConditionValidator> INSTANCE = Optional.of(new PreConditionValidator());

    /**
     * Returns a singleton instance from the class {@code PreConditionValidator}.
     *
     * @author Naoghuman
     * @since  0.2.0
     * @return a singleton instance from this class {@code PreConditionValidator}.
     */
    public static final PreConditionValidator getDefault() {
        return INSTANCE.get();
    }

    private PreConditionValidator() {
        
    }
    
    /**
     * Delegates to {@link java.util.Objects#isNull(java.lang.Object)}. Returns 
     * {@code TRUE} if the provided reference is {@code NULL} otherwise {@code FALSE}.
     * 
     * @author  Naoghuman
     * @since   0.2.0
     * @apiNote This method exists to be used as a {@link java.util.function.Predicate}, 
     *          {@code filter(Objects::isNull)}.
     * @param   obj a reference which will be checked against {@code NULL}.
     * @return  {@code TRUE} if the provided reference is {@code NULL} otherwise
     *          {@code FALSE}.
     */
    public boolean isNull(final Object obj) {
        return Objects.isNull(obj);
    }
    
    /**
     * Delegates to {@link java.util.Objects#nonNull(java.lang.Object)}. Returns 
     * {@code TRUE} if the provided reference is {@code NON-NULL} otherwise {@code FALSE}.
     * 
     * @author  Naoghuman
     * @since   0.2.0
     * @apiNote This method exists to be used as a {@link java.util.function.Predicate},
     *          {@code filter(Objects::nonNull)}.
     * @param   obj a reference which will be checked against {@code NULL}.
     * @return  {@code TRUE} if the provided reference is {@code NON-NULL} otherwise
     *          {@code FALSE}.
     */
    public boolean nonNull(final Object obj) {
        return Objects.nonNull(obj);
    }
    
    /**
     * Validates if the attribute {@code value} isn't {@code NULL}.
     *
     * @author Naoghuman
     * @since  0.1.0
     * @param  value the attribute which should be validated.
     * @param  <T>   the type of the reference.
     * @throws NullPointerException if {@code (value == NULL)}.
     */
    public <T> void requireNonNull(final T value) throws NullPointerException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL"); // NOI18N
    }
    
    /**
     * Validates if the attribute {@code value} isn't {@code NULL} and not {@code EMPTY}.
     *
     * @author Naoghuman
     * @since  0.1.0
     * @param  value the attribute which should be validated.
     * @throws NullPointerException     if {@code (value        == NULL)}.
     * @throws IllegalArgumentException if {@code (value.trim() == EMPTY)}.
     */
    public void requireNonNullAndNotEmpty(final String value) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL"); // NOI18N
        
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("The attribute [value] can't be EMPTY"); // NOI18N
        }
    }
    
}

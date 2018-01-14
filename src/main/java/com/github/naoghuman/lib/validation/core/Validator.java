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
package com.github.naoghuman.lib.validation.core;

import java.util.Objects;

/**
 * This {@code Interface} contains different default methods to validate if an 
 * {@link java.lang.Object} conforms specific behaviours or not. For example if 
 * an {@code Object} is {@code NULL} or not.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    java.lang.Object
 */
public interface Validator {
    
    /**
     * Validates if the attribute {@code value} isn't {@code NULL}.
     *
     * @author Naoghuman
     * @since  0.1.0
     * @param  value the attribute which should be validated.
     * @param  <T>   the type of the reference.
     * @throws NullPointerException if {@code (value == NULL)}.
     */
    public default <T> void requireNonNull(T value) throws NullPointerException {
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
    public default void requireNonNullAndNotEmpty(String value) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL"); // NOI18N
        
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("The attribute [value] can't be EMPTY"); // NOI18N
        }
    }
    
}

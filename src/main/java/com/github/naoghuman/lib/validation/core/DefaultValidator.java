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

import java.util.Optional;

/**
 * An implementation from the {@code Interface} {@link com.github.naoghuman.lib.validation.core.Validator} 
 * which allowed access to the different {@code validation} methods in the {@code Interface}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.validation.core.Validator
 */
public class DefaultValidator implements Validator {
    
    private static final Optional<DefaultValidator> INSTANCE = Optional.of(new DefaultValidator());

    /**
     * Returns a singleton instance from the class {@code DefaultValidator}.
     *
     * @author Naoghuman
     * @since  0.1.0
     * @return a singleton instance from this class {@code DefaultValidator}.
     */
    public static final DefaultValidator getDefault() {
        return INSTANCE.get();
    }

    private DefaultValidator() {

    }
    
}
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
package com.github.naoghuman.lib.validation.core.validator;

import java.lang.annotation.Annotation;
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
     * Returns {@code TRUE} if an annotation from the specified type is <em>present</em> 
     * on given class otherwise {@code FALSE}. This method is designed primarily for 
     * convenient access to marker annotations.
     * <p>
     * This method simple delegates to {@link java.lang.Class#isAnnotationPresent(java.lang.Class)}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @param  annotation the Class object corresponding to the annotation type.
     * @param  classToCheck the object which should be checked if the given annotation 
     *         type is present on the instance or not.
     * @return {@code TRUE} if an annotation from the specified annotation type is 
     *         present on given instance otherwise {@code FALSE}.
     * @see    java.lang.Class#isAnnotationPresent(java.lang.Class)
     */
    public boolean isAnnotationPresent(final Class<? extends Annotation> annotation, final Class classToCheck) {
        return classToCheck.isAnnotationPresent(annotation);
    }
    
    /**
     * Delegates to {@link java.util.Objects#isNull(java.lang.Object)}. Returns 
     * {@code TRUE} if the provided reference is {@code NULL} otherwise {@code FALSE}.
     * <p>
     * This method exists to be used as a {@link java.util.function.Predicate}, 
     * {@code filter(Objects::isNull)}.
     * 
     * @author Naoghuman
     * @since  0.2.0
     * @param  obj a reference which will be checked against {@code NULL}.
     * @return {@code TRUE} if the provided reference is {@code NULL} otherwise
     *         {@code FALSE}.
     */
    public boolean isNull(final Object obj) {
        return Objects.isNull(obj);
    }
    
    /**
     * Delegates to {@link java.util.Objects#nonNull(java.lang.Object)}. Returns 
     * {@code TRUE} if the provided reference is {@code NON-NULL} otherwise {@code FALSE}.
     * <p>
     * This method exists to be used as a {@link java.util.function.Predicate},
     * {@code filter(Objects::nonNull)}.
     * 
     * @author Naoghuman
     * @since  0.2.0
     * @param  obj a reference which will be checked against {@code NULL}.
     * @return {@code TRUE} if the provided reference is {@code NON-NULL} otherwise
     *         {@code FALSE}.
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

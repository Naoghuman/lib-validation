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

import com.github.naoghuman.lib.validation.core.annotation.NewDuration;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The {@code Validator} for the annotation {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration}.
 * <p>
 * Returns {@code TRUE} if the to checked {@link java.time.LocalDateTime} is between 
 * the defined {@link java.time.Duration} which starts with {@link java.time.LocalDateTime#now()} 
 * and ends with {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration#valueInDays()}.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @see    com.github.naoghuman.lib.validation.core.annotation.NewDuration
 * @see    com.github.naoghuman.lib.validation.core.annotation.NewDuration#valueInDays()
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 */
public final class NewDurationValidator implements ConstraintValidator<NewDuration, LocalDateTime> {

    private Duration duration;

    @Override
    public void initialize(final NewDuration newDuration) {
        duration = Duration.ofDays(newDuration.valueInDays());
    }

    @Override
    public boolean isValid(final LocalDateTime localDateTime, final ConstraintValidatorContext constraintValidatorContext) {
        // null values are valid
        if (localDateTime == null) {
            return true;
        }
        
        final LocalDateTime now     = LocalDateTime.now();
        final Duration      between = Duration.between(localDateTime, now);
        final boolean       isValid = (between.getSeconds() <= duration.getSeconds());

        return isValid;
    }
    
}

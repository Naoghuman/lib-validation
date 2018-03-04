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
package com.github.naoghuman.lib.validation.core.annotation;

import java.time.LocalDateTime;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Naoghuman
 * @since  0.3.0
 */
public class UpdatedDurationTest {
    
    private class EntityWith4Weeks {
        @UpdatedDuration() // default = 4 weeks
        public LocalDateTime generationTime;
    }
    
    private static ValidatorFactory validatorFactory;
    private static Validator        validator;
    
    public UpdatedDurationTest() {
        
    }
    
    @BeforeClass
    public static void setup() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator        = validatorFactory.getValidator();
    }
    
    @AfterClass
    public static void tearDown() {
        validatorFactory = null;
        validator        = null;
    }
    
    @Test
    public void durationIsLesser4Weeks() {
        EntityWith4Weeks entityWith4Weeks = new EntityWith4Weeks();
        entityWith4Weeks.generationTime  = LocalDateTime.now().minusDays(28).plusHours(1);
        
        Set<ConstraintViolation<EntityWith4Weeks>> violations = validator.validate(entityWith4Weeks);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void durationIsEquals4Weeks() {
        EntityWith4Weeks entityWith4Weeks = new EntityWith4Weeks();
        entityWith4Weeks.generationTime  = LocalDateTime.now().minusDays(28);
        
        Set<ConstraintViolation<EntityWith4Weeks>> violations = validator.validate(entityWith4Weeks);
        
        assertTrue(violations.isEmpty());
    }

    @Test
    public void durationIsGreater4WeeksThrowsConstraintViolation() {
        EntityWith4Weeks entityWith4Weeks = new EntityWith4Weeks();
        entityWith4Weeks.generationTime  = LocalDateTime.now().minusDays(28).minusMinutes(1);
        
        Set<ConstraintViolation<EntityWith4Weeks>> violations = validator.validate(entityWith4Weeks);
        
        assertFalse(violations.isEmpty());
        assertEquals(violations.size(), 1);
        assertEquals(
                violations.iterator().next().getMessage(),
                "{com.github.naoghuman.lib.validation.core.annotation.updatedduration.message}");
    }
    
}

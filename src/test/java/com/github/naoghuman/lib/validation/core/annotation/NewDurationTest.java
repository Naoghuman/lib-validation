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
 * @since  0.2.0
 */
public class NewDurationTest {
    
    private class EntityWith3Days {
        @NewDuration(valueInDays = 3)
        public LocalDateTime generationTime;
    }
    
    private static ValidatorFactory validatorFactory;
    private static Validator        validator;
    
    public NewDurationTest() {
        
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
    public void durationIsLesser3Days() {
        EntityWith3Days entityWith3Days = new EntityWith3Days();
        entityWith3Days.generationTime  = LocalDateTime.now().minusDays(2).minusHours(1);
        
        Set<ConstraintViolation<EntityWith3Days>> violations = validator.validate(entityWith3Days);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void durationIsEquals3Days() {
        EntityWith3Days entityWith3Days = new EntityWith3Days();
        entityWith3Days.generationTime  = LocalDateTime.now().minusDays(3);
        
        Set<ConstraintViolation<EntityWith3Days>> violations = validator.validate(entityWith3Days);
        
        assertTrue(violations.isEmpty());
    }

    @Test
    public void durationIsGreater3DaysThrowsConstraintViolation() {
        EntityWith3Days entityWith3Days = new EntityWith3Days();
        entityWith3Days.generationTime  = LocalDateTime.now().minusDays(3).minusMinutes(1);
        
        Set<ConstraintViolation<EntityWith3Days>> violations = validator.validate(entityWith3Days);
        
        assertFalse(violations.isEmpty());
        assertEquals(violations.size(), 1);
        assertEquals(
                violations.iterator().next().getMessage(),
                "{com.github.naoghuman.lib.validation.core.annotation.newduration.message}");
    }
    
}

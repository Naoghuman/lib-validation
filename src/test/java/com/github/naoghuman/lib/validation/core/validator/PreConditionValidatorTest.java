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

import java.awt.Label;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public class PreConditionValidatorTest {
    
    public PreConditionValidatorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDefault() {
        PreConditionValidator instance = PreConditionValidator.getDefault();
        assertNotNull(instance);
    }
    
    @Test
    public void testIsNullTRUE() {
        Label value = null; // <-----------
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        assertTrue(instance.isNull(value));
    }
    
    @Test
    public void testIsNullFALSE() {
        Label value = new Label(); // <-----------
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        assertFalse(instance.isNull(value));
    }

    @Test(expected = NullPointerException.class)
    public void testRequireNonNullThrowNullPointerException() {
        Label value = null; // <-----------
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        instance.requireNonNull(value);
    }

    @Test
    public void testRequireNonNull() {
        Label value = new Label("hello");
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        instance.requireNonNull(value);
    }

    @Test(expected = NullPointerException.class)
    public void testRequireNonNullAndNotEmptyThrowNullPointerException() {
        String value = null; // <-----------
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        instance.requireNonNullAndNotEmpty(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRequireNonNullAndNotEmptyThrowIllegalArgumentException() {
        String value = ""; // <-----------
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        instance.requireNonNullAndNotEmpty(value);
    }

    @Test
    public void testRequireNonNullAndNotEmpty() {
        String value = "hallo"; // <-----------
        
        PreConditionValidator instance = PreConditionValidator.getDefault();
        instance.requireNonNullAndNotEmpty(value);
    }

    
}

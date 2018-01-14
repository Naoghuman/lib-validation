/*
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

import java.awt.Label;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ValidatorTest {
    
    public ValidatorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void testRequireNonNullThrowNullPointerException() {
        Label value = null; // <-----------
        
        Validator instance = new ValidatorImpl();
        instance.requireNonNull(value);
    }

    @Test
    public void testRequireNonNull() {
        Label value = new Label("hello");
        
        Validator instance = new ValidatorImpl();
        instance.requireNonNull(value);
    }

    @Test(expected = NullPointerException.class)
    public void testRequireNonNullAndNotEmptyThrowNullPointerException() {
        String value = null; // <-----------
        
        Validator instance = new ValidatorImpl();
        instance.requireNonNullAndNotEmpty(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRequireNonNullAndNotEmptyThrowIllegalArgumentException() {
        String value = ""; // <-----------
        
        Validator instance = new ValidatorImpl();
        instance.requireNonNullAndNotEmpty(value);
    }

    @Test
    public void testRequireNonNullAndNotEmpty() {
        String value = "hallo";
        Validator instance = new ValidatorImpl();
        instance.requireNonNullAndNotEmpty(value);
    }

    public class ValidatorImpl implements Validator {
    }
    
}

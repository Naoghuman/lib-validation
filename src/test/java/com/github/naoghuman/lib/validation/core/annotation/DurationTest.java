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

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public class DurationTest {
    
    public DurationTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void durationIsLesser3DaysTRUE() {
        int      days         = 3;
        Duration durationDays = Duration.ofDays(days);
        
        LocalDateTime now  = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.now().minusDays(2).minusHours(1);
        Duration durationBetween = Duration.between(past, now);
        assertTrue(durationBetween.getSeconds() < durationDays.getSeconds());
        
        past = LocalDateTime.now().minusDays(2).minusHours(23).minusMinutes(59);
        durationBetween = Duration.between(past, now);
        assertTrue(durationBetween.getSeconds() < durationDays.getSeconds());
    }

    @Test
    public void durationIsEquals3DaysTRUE() {
        int      days         = 3;
        Duration durationDays = Duration.ofDays(days);
        
        LocalDateTime now  = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.now().minusDays(3);
        Duration durationBetween = Duration.between(past, now);
        assertTrue(durationBetween.getSeconds() == durationDays.getSeconds());
    }

    @Test
    public void durationIsGreater3DaysTRUE() {
        int      days         = 3;
        Duration durationDays = Duration.ofDays(days);
        
        LocalDateTime now  = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.now().minusDays(3).minusSeconds(20);
        Duration durationBetween = Duration.between(past, now);
        assertTrue(durationBetween.getSeconds() > durationDays.getSeconds());
    }

    @Test
    public void durationIsLesser3DaysWithMillisTRUE() {
        int      days         = 3;
        Duration durationDays = Duration.ofDays(days);
        
        LocalDateTime now  = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.now().minusDays(2).minusHours(23).minusMinutes(59);
        
        long          millis    = past.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        LocalDateTime converted = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
        
        Duration durationBetween = Duration.between(converted, now);
        assertTrue(durationBetween.getSeconds() < durationDays.getSeconds());
    }
    
}

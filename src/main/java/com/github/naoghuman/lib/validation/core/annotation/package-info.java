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
/**
 * Contains the annotations from the library {@code Lib-Validation}.
 * <p>
 * The annotation {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration} 
 * allowed to verifiy if a given {@link java.time.LocalDateTime} in a defined range which 
 * starts with ({@link java.time.LocalDateTime#now()} - 
 * {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration#days()})
 * and ends with {@link java.time.LocalDateTime#now()}. If the checks return {@code TRUE} 
 * an entity can be flagged as {@code New}.
 * <p>
 * The annotation {@link com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration} 
 * is similar to {@code NewDuration} expected that the range counts in {@code weeks}. If the 
 * check returns {@code TRUE} an entity can be flagged as {@code Updated}.
 * 
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.validation.core.annotation.NewDuration
 * @see    com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration
 * @see    java.time.LocalDateTime
 * @see    java.time.LocalDateTime#now()
 */
package com.github.naoghuman.lib.validation.core.annotation;

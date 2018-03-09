Lib-Validation
===



Intention
---

Lib-Validation is a library for `easy` validating in a [JavaFX] &amp; [Maven] application 
during the integration from [Bean Validation 2.0] ([JSR 380]).

_Image:_ [UML] Lib-Validation v0.3.0  
![UML-diagram_Lib-Validation_v0.3.0_2018-03-09_05-36.png][UML-diagram_Lib-Validation_v0.3.0_2018-03-09_05-36]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

Current `version` is `0.2.0` (02.11.2018 / MM.dd.yyyy).



Content
---

* [Examples](#Examples)
    - [TODO How to ...](#HoTo)
* [Background informations](#BaIn)
    - [TODO More about JSR 380](#MoAbJSR)
    - [TODO More about Bean Validation 2.0](#MoAbBeVa)
* [Api](#Api)
    - [com.github.naoghuman.lib.validation.core.annotation.NewDuration](#NeDu)
    - [com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration](#UpDu)
    - [com.github.naoghuman.lib.validation.core.validator.NewDurationValidator](#NeDuVa)
    - [com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator](#UpDuVa)
    - [com.github.naoghuman.lib.validation.core.validator.ValidationFactory](#NeDuVa)
    - [com.github.naoghuman.lib.validation.core.validator.PreConditionValidator](#PrCoVa)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---

### TODO How to ...<a name="HoTo" />

TODO



Background informations<a name="BaIn" />
---

In this section I want give you some more background informations about the 
topics `JSR 380` and `Bean Validation 2.0`.

### TODO More about JSR 380<a name="MoAbJSR" />

[JSR 380] (Java Specification Request) aims at evolving the Bean Validation specification 
by leveraging Java 8 language constructs for the purposes of validation.

With this specification of the Java API for bean validation, part of JavaEE and JavaSE, 
which ensures that the properties of a bean meet specific criteria, using annotations 
such as @NotNull, @Min, and @Max.

`Hibernate Validator 6.0.7.Final is the [JSR 380 Reference Implementation: Reference Guide].


### TODO More about Bean Validation 2.0<a name="MoAbBeVa" />

TODO



Api<a name="Api" />
---

### com.github.naoghuman.lib.validation.core.annotation.NewDuration<a name="NeDu" />

```java
/**
 * The annotation {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration} 
 * lets the developer verify if a given {@link java.time.LocalDateTime} is in the range 
 * from a {@link java.time.Duration} which starts with ({@link java.time.LocalDateTime#now()} 
 * - {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration#days()}) and ends 
 * with {@link java.time.LocalDateTime#now()}.
 * <br>
 * If a given {@code LocalDateTime} is in the range then the validated entity can be flagged 
 * as {@code 'New'}.
 * <p>
 * For example given is:<br>
 * TODO
 * 
 * @author  Naoghuman
 * @since   0.2.0
 * @version 0.3.0
 * @see     java.time.Duration
 * @see     java.time.LocalDateTime
 * @see     java.time.LocalDateTime#now()
 */
@Target({ FIELD, LOCAL_VARIABLE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NewDurationValidator.class)
public @interface NewDuration
```

```java
/**
 * Returns the message key for the message if the validator verify that the 
 * checked {@link java.time.LocalDateTime} is in the range from the defined 
 * {@link java.time.Duration}.
 * <p>
 * The message for the key can be found in:<br>
 *  - {@code com.github.naoghuman.lib.validation.core.ValidationMessages.properties}
 * 
 * @author Naoghuman
 * @since  0.2.0
 * @return the message key.
 * @see    com.github.naoghuman.lib.validation.core.validator.NewDurationValidator
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 */
public String message() default "{com.github.naoghuman.lib.validation.core.annotation.newduration.message}"; // NOI18N
```

```java
/**
 * The attribute {@code groups} allows the specification of validation groups, 
 * to which this constraint belongs.
 * <p>
 * This must be default an empty array of type Class&lt;?&gt;.
 * 
 * @author Naoghuman
 * @since  0.2.0
 * @return the groups which should be validate.
 */
public Class<?>[] groups() default { };
```

```java
/**
 * The attribute {@code payload} can be used by clients of the {@code Bean Validation API} 
 * to assign custom payload objects to a constraint. This attribute is not used by the API 
 * itself.
 * 
 * @author Naoghuman
 * @since  0.2.0
 * @return the payload which should be validate.
 */
public Class<? extends Payload>[] payload() default { };
```

```java
/**
 * The attribute {@code days} defines the start-point from the {@link java.time.Duration} 
 * which is ({@link java.time.LocalDateTime#now()} - 
 * {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration#days()}) and 
 * ends with {@link java.time.LocalDateTime#now()}.
 * <p>
 * Default value is {@code 3} days.
 * 
 * @author  Naoghuman
 * @since   0.2.0
 * @version 0.3.0
 * @return  the start-point from the {@code Duration} in days.
 * @see     java.time.Duration
 * @see     java.time.LocalDateTime#now()
 */
public int days() default 3;
```


### com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration<a name="UpDu" />

```java
/**
 * The annotation {@link com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration} 
 * lets the developer verify if a given {@link java.time.LocalDateTime} is in the range 
 * from a {@link java.time.Duration} which starts with ({@link java.time.LocalDateTime#now()} 
 * - {@link com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration#weeks()}) and 
 * ends with {@link java.time.LocalDateTime#now()}.
 * <br>
 * If a given {@code LocalDateTime} is in the range then the validated entity can be flagged 
 * as {@code 'Updated'}.
 * <p>
 * For example given is:<br>
 * TODO
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 * @see    java.time.LocalDateTime#now()
 */
@Target({ FIELD, LOCAL_VARIABLE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UpdatedDurationValidator.class)
public @interface UpdatedDuration
```

```java
/**
 * Returns the message key for the message if 
 * {@link com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator} 
 * verify that the checked {@link java.time.LocalDateTime} is in the defined 
 * {@link java.time.Duration}.
 * <p>
 * The message for the key can be found in:<br>
 *  - {@code com.github.naoghuman.lib.validation.core.ValidationMessages.properties}
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the message key.
 * @see    com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 */
public String message() default "{com.github.naoghuman.lib.validation.core.annotation.updatedduration.message}"; // NOI18N
```

```java
/**
 * The attribute {@code groups} allows the specification of validation groups, 
 * to which this constraint belongs.
 * <p>
 * This must be default an empty array of type Class&lt;?&gt;.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the groups which should be validate.
 */
public Class<?>[] groups() default { };
```

```java
/**
 * The attribute {@code payload} can be used by clients of the {@code Bean Validation API} 
 * to assign custom payload objects to a constraint. This attribute is not used by the API 
 * itself.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the payload which should be validate.
 */
public Class<? extends Payload>[] payload() default { };
```

```java
/**
 * The attribute {@code weeks} defines the start-point from the {@link java.time.Duration} 
 * which is ({@link java.time.LocalDateTime#now()} - 
 * {@link com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration#weeks()}) and 
 * ends with {@link java.time.LocalDateTime#now()}.
 * <p>
 * Default value is {@code 4} weeks.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the start-point from the {@code Duration} in weeks.
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime#now()
 */
public int weeks() default 4;
```


### com.github.naoghuman.lib.validation.core.validator.NewDurationValidator<a name="NeDuVa" />

```java
/**
 * The {@code validator} for the annotation {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration}.
 * <p>
 * Returns {@code TRUE} if the to checked {@link java.time.LocalDateTime} is in the range from  
 * the defined {@link java.time.Duration} which starts with {@link java.time.LocalDateTime#now()} 
 * and ends with {@link com.github.naoghuman.lib.validation.core.annotation.NewDuration#days()}.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @see    com.github.naoghuman.lib.validation.core.annotation.NewDuration
 * @see    com.github.naoghuman.lib.validation.core.annotation.NewDuration#days()
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 */
public final class NewDurationValidator implements ConstraintValidator<NewDuration, LocalDateTime>
```


### com.github.naoghuman.lib.validation.core.validator.UpdatedDurationValidator<a name="UpDuVa" />

```java
/**
 * The {@code Validator} for the annotation {@link com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration}.
 * <p>
 * Returns {@code TRUE} if the to checked {@link java.time.LocalDateTime} is between 
 * the defined {@link java.time.Duration} which starts with {@link java.time.LocalDateTime#now()} 
 * and ends with {@link com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration#weeks()}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration
 * @see    com.github.naoghuman.lib.validation.core.annotation.UpdatedDuration#weeks()
 * @see    java.time.Duration
 * @see    java.time.LocalDateTime
 * @see    java.time.LocalDateTime#now()
 */
public final class UpdatedDurationValidator implements ConstraintValidator<UpdatedDuration, LocalDateTime>
```


### com.github.naoghuman.lib.validation.core.validator.ValidationFactory<a name="NeDuVa" />

```java
/**
 * Simple factory class which alloweds momentary to access an initialized instance 
 * from a {@link javax.validation.Validator} using the factory defaults for message 
 * interpolator, traversable resolver and constraint validator factory.
 * 
 * @author Naoghuman
 * @since  0.2.0
 * @see    javax.validation.Validator
 */
public final class ValidationFactory
```

```java
private static final Optional<ValidationFactory> INSTANCE = Optional.of(new ValidationFactory());

    /**
 * Returns a singleton instance from the class {@code ValidationFactory}.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @return a singleton instance from this class {@code ValidationFactory}.
 */
public static final ValidationFactory getDefault()
```

```java
/**
 * Returns an initialized {@link Validator} instance using the
 * factory defaults for message interpolator, traversable resolver
 * and constraint validator factory.
 * <p>
 * Validator instances can be pooled and shared by the implementation.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @return an initialized {@code Validator} instance.
 */
public Validator getValidator()
```


### com.github.naoghuman.lib.validation.core.validator.PreConditionValidator<a name="NeDuVa" />

```java
/**
 * This {@code Class} contains different methods to validate if an {@link java.lang.Object} 
 * conforms specific behaviours or not. For example if an {@code Object} is {@code NULL} or not.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @see    java.lang.Object
 */
public final class PreConditionValidator
```

```java
/**
 * Returns a singleton instance from the class {@code PreConditionValidator}.
 *
 * @author Naoghuman
 * @since  0.2.0
 * @return a singleton instance from this class {@code PreConditionValidator}.
 */
public static final PreConditionValidator getDefault()
```

```java
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
public boolean isAnnotationPresent(final Class<? extends Annotation> annotation, final Class classToCheck)
```

```java
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
public boolean isNull(final Object obj)
```

```java
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
public boolean nonNull(final Object obj)
```

```java
/**
 * Validates if the attribute {@code value} isn't {@code NULL}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @param  value the attribute which should be validated.
 * @param  <T>   the type of the reference.
 * @throws NullPointerException if {@code (value == NULL)}.
 */
public <T> void requireNonNull(final T value) throws NullPointerException
```

```java
/**
 * Validates if the attribute {@code value} isn't {@code NULL} and not {@code EMPTY}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @param  value the attribute which should be validated.
 * @throws NullPointerException     if {@code (value        == NULL)}.
 * @throws IllegalArgumentException if {@code (value.trim() == EMPTY)}.
 */
public void requireNonNullAndNotEmpty(final String value) throws NullPointerException, IllegalArgumentException
```



Download<a name="Download" />
---

Current `version` is `0.1.0`. Main points in this release are:
* This is a minor update.
* New is the annotation `NewDuration` and the corresponding validator `NewDurationValidator`.

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-validation</artifactId>
        <version>0.2.0</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.2.0 (02.11.2018 / MM.dd.yyyy))]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Validation]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [lib-validation-0.2.0.jar](#Installation).

In the library are following libraries registered as dependencies:
* The library [hibernate-validator-6.0.7.Final.jar](#Installation).
  * Included is the library [classmate-1.3.1.jar].
  * Included is the library [jboss-logging.3.3.0.jar].
  * Included is the library [validation-api-2.0.1.jar].
* The library [hibernate-validator-annotation-processor-6.0.7.Final.jar](#Installation).
* The library [javax.el-2.2.6.jar](#Installation).
* The library [javax.el-api-3.0.0.jar](#Installation).



Installation<a name="Installation" />
---

##### Install the project in your preferred IDE

* If not installed download the [JRE 8] or the [JDK 8].
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for 
  the development.
* Download or clone [Lib-Validation].
* Open the projects in your IDE and run them.

> __Hint__  
> To work best with [FXML] files in a [JavaFX] application download [JavaFX Scene Builder]
> supported by [Gluon].



Documentation<a name="Documentation" />
---

* In section [Api](#Api) you can see the main point(s) to access the functionality 
  in this library.
* For additional information see the [JavaDoc] in the library itself.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Validation` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Validation` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[UML-diagram_Lib-Validation_v0.3.0_2018-03-09_05-36]:https://user-images.githubusercontent.com/8161815/37190787-16612a4a-235c-11e8-9b9c-0979ec6201a9.png



[//]: # (Links)
[Bean Validation 2.0]:http://beanvalidation.org/
[classmate-1.3.1.jar]:https://github.com/FasterXML/java-classmate
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[Gluon]:http://gluonhq.com/
[hibernate-validator-6.0.7.Final.jar]:http://hibernate.org/validator/
[hibernate-validator-annotation-processor-6.0.7.Final.jar]:http://hibernate.org/validator/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-validation/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://gluonhq.com/products/scene-builder/
[javax.el-2.2.6.jar]:https://mvnrepository.com/artifact/org.glassfish.web/javax.el
[javax.el-api-3.0.0.jar]:https://mvnrepository.com/artifact/javax.el/javax.el-api
[jboss-logging.3.3.0.jar]:https://mvnrepository.com/artifact/org.jboss.logging/jboss-logging
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[JSR 380]:https://jcp.org/en/jsr/detail?id=380
[JSR 380 Reference Implementation: Reference Guide]:https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#preface
[Lib-Validation]:https://github.com/Naoghuman/lib-validation
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Validation]:https://github.com/Naoghuman/lib-validation/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.1.0 (01.15.2018 / MM.dd.yyyy))]:https://github.com/Naoghuman/lib-validation/releases/tag/v0.1.0
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
[validation-api-2.0.1.jar]:https://mvnrepository.com/artifact/javax.validation/validation-api

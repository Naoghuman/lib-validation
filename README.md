Lib-Validation
===



Intention
---

Lib-Validation is a library for `easy` validating in a [JavaFX] &amp; [Maven] application 
during the integration from [Bean Validation 2.0] ([JSR 380]).

_Image:_ [UML] Lib-Validation v0.1.0  
![UML-diagram_Lib-Validation_v0.1.0_2018-01-15_05-43.png][UML-diagram_Lib-Validation_v0.1.0_2018-01-15_05-43]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

Current `version` is `0.1.0` (01.15.2018 / MM.dd.yyyy).



Content
---

* [Examples](#Examples)
    - [TODO How to ...](#HoTo)
* [Background informations](#BaIn)
    - [TODO More about JSR 380](#MoAbJSR)
    - [TODO More about Bean Validation 2.0](#MoAbBeVa)
* [Api](#Api)
    - [com.github.naoghuman.lib.validation.core.Validator](#InVa)
    - [com.github.naoghuman.lib.validation.core.ValidatorFacade](#ClVaFa)
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

### com.github.naoghuman.lib.validation.core.Validator<a name="InVa" />

```java
/**
 * This {@code Interface} contains different default methods to validate if an 
 * {@link java.lang.Object} conforms specific behaviours or not. For example if 
 * an {@code Object} is {@code NULL} or not.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    java.lang.Object
 */
public interface Validator
```

```java
/**
 * Delegates to {@link java.util.Objects#isNull(java.lang.Object)}. Returns 
 * {@code TRUE} if the provided reference is {@code NULL} otherwise {@code FALSE}.
 * 
 * @author  Naoghuman
 * @since   0.2.0
 * @apiNote This method exists to be used as a {@link java.util.function.Predicate}, 
 *          {@code filter(Objects::isNull)}.
 * @param   obj a reference which will be checked against {@code NULL}.
 * @return  {@code TRUE} if the provided reference is {@code NULL} otherwise
 *          {@code FALSE}.
 */
public default boolean isNull(final Object obj)
```

```java
/**
 * Delegates to {@link java.util.Objects#nonNull(java.lang.Object)}. Returns 
 * {@code TRUE} if the provided reference is {@code NON-NULL} otherwise {@code FALSE}.
 * 
 * @author  Naoghuman
 * @since   0.2.0
 * @apiNote This method exists to be used as a {@link java.util.function.Predicate},
 *          {@code filter(Objects::nonNull)}.
 * @param   obj a reference which will be checked against {@code NULL}.
 * @return  {@code TRUE} if the provided reference is {@code NON-NULL} otherwise
 *          {@code FALSE}.
 */
public default boolean nonNull(final Object obj)
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
public default <T> void requireNonNull(T value) throws NullPointerException
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
public default void requireNonNullAndNotEmpty(String value) throws NullPointerException, IllegalArgumentException
```


### com.github.naoghuman.lib.validation.core.ValidatorFacade<a name="ClVaFa" />

```java
/**
 * An implementation from the {@code Interface} {@link com.github.naoghuman.lib.validation.core.Validator} 
 * which allowed access to the different {@code validation} methods from the {@code Interface}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.validation.core.Validator
 */
public class ValidatorFacade implements Validator
```

```java
/**
 * Returns a singleton instance from the class {@code ValidatorFacade}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @return a singleton instance from this class {@code ValidatorFacade}.
 */
public static final ValidatorFacade getDefault()
```



Download<a name="Download" />
---

Current `version` is `0.1.0`. Main points in this release are:
* This is a mayor update.
* The hole library :) .
* With the interface `Validator` the developer can validate different default 
  behaivours from objects.
* With the class `ValidatorFacade` the developer can access the methods from the 
  interface Validator.

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-validation</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.1.0 (01.15.2018 / MM.dd.yyyy))]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Validation]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [lib-validation-0.1.0.jar](#Installation).

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
[UML-diagram_Lib-Validation_v0.1.0_2018-01-15_05-43]:https://user-images.githubusercontent.com/8161815/34957064-43a4a724-fa2c-11e7-88dc-1f1240a57cfb.png



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

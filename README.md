Lib-Validation
===



Intention
---

Lib-Validation is a library for `easy` validating in a [JavaFX] &amp; [Maven] application.

_Image:_ [UML] Lib-Validation v0.1.0  
![UML-diagram_Lib-Validation_v0.1.0_2018-01-15_05-43.png][UML-diagram_Lib-Validation_v0.1.0_2018-01-15_05-43]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

Current `version` is `0.1.0` (01.15.2018 / MM.dd.yyyy).



Content
---

* [Examples](#Examples)
    - [How to ...](#HoTo)
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

### How to ...<a name="HoTo" />

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
 * which allowed access to the different {@code validation} methods in the {@code Interface}.
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



Installation<a name="Installation" />
---

##### Install the project in your preferred IDE

* If not installed download the [JRE 8] or the [JDK 8].
    - Optional: To work better with [FXML] files in a [JavaFX] application 
      download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for 
  the development.
* Download or clone [Lib-Validation].
* Open the projects in your IDE and run them.



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
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-validation/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Validation]:https://github.com/Naoghuman/lib-validation
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Validation]:https://github.com/Naoghuman/lib-validation/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.1.0 (01.15.2018 / MM.dd.yyyy))]:https://github.com/Naoghuman/lib-validation/releases/tag/v0.1.0
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language

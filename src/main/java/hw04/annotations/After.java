package hw04.annotations;

import java.lang.annotation.*;

@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface After {
}

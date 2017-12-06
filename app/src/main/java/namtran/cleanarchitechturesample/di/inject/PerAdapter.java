package namtran.cleanarchitechturesample.di.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A custom scoping annotation that specifies that the lifespan of a dependency be the same as that
 * of an Adapter Recyclerview.
 *
 * This is used to annotate dependencies that behave like a singleton within the lifespan of an
 * Adapter instead of the entire Application Activity or Fragment .
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerAdapter {
}

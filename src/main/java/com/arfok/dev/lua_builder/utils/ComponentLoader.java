package com.arfok.dev.lua_builder.utils;

import com.arfok.dev.lua_builder.component.ILuaComponent;

import java.util.Objects;

/**
 * This class loads all the subclasses implementing
 * {@link com.arfok.dev.lua_builder.component.ILuaComponent}
 * then it checks the path to load the classes and create new instance of them.
 *
 */
public class ComponentLoader {

    /**
     * Load a new lua component {@link ILuaComponent} with its parameters as a classes array
     * and the class defining the lua component.
     *
     * @param clazz the lua component to load.
     * @param parameters the constructor parameters associated.
     * @return the instance of the lua component which has been created.
     */
    public static ILuaComponent loadComponent(Class<?> clazz, Class<?>... parameters) {
        Objects.requireNonNull(clazz);
        if (!clazz.isInterface() && ILuaComponent.class.isAssignableFrom(clazz)) {
            return (ILuaComponent) loadClass(clazz, parameters);
        }

        return null;
    }

    /**
     * Load an instance of {@link ILuaComponent} with the name of this one :
     * <ul>
     *     <li>Function</li>
     *     <li>Variable</li>
     * </ul>
     * and returns the instance associated.
     *
     * @param componentName the name of the lua component.
     * @return the instance of the lua component created.
     */
    public static ILuaComponent loadComponent(String componentName) {
        Class<?> componentClazz = loadClass(componentName);
        return loadComponent(componentClazz);
    }

    /**
     * Create a new {@link Object} instance from the class and its constructor
     * parameters defined as an array of <code>Class<?>...</code>.
     * Then returns the instance generated or null if no constructors have been
     * defined into the class.
     *
     * @param clazz the clazz {@link Class<?>} to load.
     * @param parameters the constructor parameters associated to the class.
     * @return the corresponding instance, else <code>null</code> if the loading has failed.
     */
    public static Object loadClass(Class<?> clazz, Class<?>... parameters) {
        try {
            return clazz.getDeclaredConstructor(parameters);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /**
     * Load a class {@link Class} with name given in parameter.
     * Return the associated class or null if no class can be found.
     *
     * @param className the class' name to load.
     * @return the class object or null if it's failed.
     */
    public static Class<?> loadClass(String className) {
        try {
            return ClassLoader.getSystemClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}

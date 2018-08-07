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

    public static ILuaComponent loadComponent(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        if (!clazz.isInterface() && ILuaComponent.class.isAssignableFrom(clazz)) {
            return (ILuaComponent) loadClass(clazz);
        }

        return null;
    }

    public static ILuaComponent loadComponent(String componentName) {
        Class<?> componentClazz = loadClass(componentName);
        return loadComponent(componentClazz);
    }

    public static Object loadClass(Class<?> clazz, Class<?>... parameters) {
        try {
            return clazz.getDeclaredConstructor(parameters);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Class<?> loadClass(String className) {
        try {
            return ClassLoader.getSystemClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}

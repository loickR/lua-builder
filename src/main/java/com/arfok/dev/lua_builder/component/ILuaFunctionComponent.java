package com.arfok.dev.lua_builder.component;

/**
 * {@inheritDoc ILuaComponent}.
 *
 * This interface the properties of a lua function component.
 * It has for super class {@link ILuaComponent} and adds an additionnal method
 * <code>
 *     String[] parameters();
 * </code>
 *
 * which defined all the parameters of the new lua function declared.
 *
 */
public interface ILuaFunctionComponent extends ILuaComponent {

    /**
     * Defined all the parameters of the new lua function
     * declared.
     *
     * @return the list of parameters associated to the function.
     */
    String[] parameters();
}

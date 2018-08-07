package com.arfok.dev.lua_builder.template;

/**
 * This interface describes how a new lua component must be
 * defined in the project file when it's writing by the
 * {@link com.arfok.dev.lua_builder.generator.LuaCodeCreator} then make a standard
 * indentation of the code generated.
 *
 */
@FunctionalInterface
public interface ILuaComponentTemplate {

    /**
     * Define the main writing for a {@link com.arfok.dev.lua_builder.component.ILuaComponent}
     * and indents correctly the code line associated.
     *
     * @return a string describing the componentTemplate of the component.
     */
    String template();
}

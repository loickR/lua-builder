package com.arfok.dev.lua_builder.component.variable;

import com.arfok.dev.lua_builder.component.ILuaComponent;
import com.arfok.dev.lua_builder.template.ILuaComponentTemplate;

/**
 * Defines a new lua variable as a component :
 * <ul>
 *     <li>variableName : the name of the variable component.</li>
 *     <li>value : the value associated to this component.</li>
 *     <li>type : local or global, if global then this field is filled with the empty string</li>
 * </ul>
 *
 * The lua variable component is defined as following :
 * {@code type} {@code variableName} = {@code value}
 *
 * Example :
 * local a = 6
 *
 * Then variableName is equal to "a", value equals to 6 and tyle equals to the keyword "local".
 */
public class LuaVariableComponent implements ILuaComponent {

    private final String variableName;

    private final String value;

    private final String type;

    public LuaVariableComponent(String variableName, String value, String type) {
        this.variableName = variableName;
        this.value = value;
        this.type = type;
    }

    @Override
    public String name() {
        return variableName;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public ILuaComponentTemplate componentTemplate() {
        return () -> type() + " " + name() + " = " + value();
    }
}

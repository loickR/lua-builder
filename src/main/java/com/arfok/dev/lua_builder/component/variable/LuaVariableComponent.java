package com.arfok.dev.lua_builder.component.variable;

import com.arfok.dev.lua_builder.component.ILuaComponent;

public class LuaVariableComponent implements ILuaComponent {

    private final String variableName;

    private final String type;

    public LuaVariableComponent(String variableName, String type) {
        this.variableName = variableName;
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
}

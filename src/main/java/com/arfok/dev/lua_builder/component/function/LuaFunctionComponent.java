package com.arfok.dev.lua_builder.component.function;

import com.arfok.dev.lua_builder.component.ILuaFunctionComponent;

public class LuaFunctionComponent implements ILuaFunctionComponent {

    private final String functionName;

    private final String[] parameters;

    private final String type;

    public LuaFunctionComponent(String functionName, String[] parameters, String type) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.type = type;
    }

    @Override
    public String name() {
        return functionName;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public String[] parameters() {
        return parameters;
    }
}

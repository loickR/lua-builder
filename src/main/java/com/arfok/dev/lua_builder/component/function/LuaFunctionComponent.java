package com.arfok.dev.lua_builder.component.function;

import com.arfok.dev.lua_builder.component.ILuaFunctionComponent;
import com.arfok.dev.lua_builder.template.ILuaComponentTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Defines a lua function as following :
 *
 * {@code type} function {@code name}({@code parameters})
 *    -- some implementation
 * end
 *
 * where the properties are described as :
 * <ul>
 *     <li>type : local or global, if global then the empty String should be used</li>
 *     <li>name : the name of the function</li>
 *     <li>parameters : an array (defined as varargs) listing all the parameters
 *     (can be empty if no parameters are defined)</li>
 * </ul>
 *
 * exemple :
 * <code type="lua">
 * function test(a, b)
 *    -- some implementation
 * end
 * </code>
 *
 *
 * then type is the empty string, name is equal to "test" then parameters is filled with
 * "a" and "b" values : {@code parameters = ["a", "b"]}.
 */
public class LuaFunctionComponent implements ILuaFunctionComponent {

    private final String functionName;

    private final String[] parameters;

    private final String type;

    private final String body;

    public LuaFunctionComponent(String functionName, String[] parameters,
                                String type, String body) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.type = type;
        this.body = body;
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
    public String value() {
        return body;
    }

    @Override
    public ILuaComponentTemplate componentTemplate() {
        String parameters = Arrays.stream(parameters()).collect(Collectors.joining(", "));
        return () -> type() + " function " + name() + "(" + parameters + ")\n"
                + " " + value() + "\n"
                + "end";
    }

    @Override
    public String[] parameters() {
        return parameters;
    }
}

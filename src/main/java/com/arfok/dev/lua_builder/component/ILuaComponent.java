package com.arfok.dev.lua_builder.component;

/**
 * This interface defines the properties of an lua object.
 * It is common for all new objects created, it can be associated with :
 * <ul>
 *     <li>lua function declaration</li>
 *     <li>global lua variable declaration</li>
 *     <li>local lua variable declaration</li>
 *     <li>lua array declaration</li>
 * </ul>
 *
 * All classes defining the properties listed above must implement this interface.
 * For example, in order to define a new lua component the following must be declared like this :
 *
 * <code>
 *     public class MyLuaComponent implements LuaComponent {
 *
 *         public String name() {
 *             //...
 *         }
 *
 *         public String type() {
 *             //...
 *         }
 *     }
 * </code>
 */
public interface ILuaComponent {

    /**
     * Name of the lua component defined by the class implementing this interface.
     *
     * @return the specific name of the new lua component declared.
     */
    String name();

    /**
     * The type of the lua component declared :
     * <ul>
     *     <li>local,</li>
     *     <li>global (returns the empty String).</li>
     * </ul>
     *
     * @return the specific type associated.
     */
    String type();

    /**
     * The value of the new lua variable component.
     * <code>
     *     local a = 5
     * </code>
     *
     * then "a" is the name of the component and 5 the value associated.
     *
     * In the case it's a function component then this property corresponds to
     * the body of the function.
     *
     * @return the value associated to the new component.
     */
    String value();
}

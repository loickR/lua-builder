package com.arfok.dev.lua_builder.generator;

import com.arfok.dev.lua_builder.component.ILuaComponent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * This class generates the real lua pieces of code defined by the {@link ILuaComponent}
 * and the sub-classes implementing it.
 *
 */
public class LuaCodeCreator {

    private final LuaProjectDefiner projectDefiner;

    public LuaCodeCreator(LuaProjectDefiner projectDefiner) {
        this.projectDefiner = projectDefiner;
    }

    /**
     * Take a list of lua components as <code>List<{@link ILuaComponent}> </code>
     * then write into it to the project file associated.
     *
     * @param luaComponents the list of lua components.
     */
    public void generateLuaCode(List<ILuaComponent> luaComponents) {
        try {
            File luaProjectFile = projectDefiner.setAndGetLuaProject();
            try (BufferedWriter writer = Files.newBufferedWriter(luaProjectFile.toPath())) {
                for (ILuaComponent component : luaComponents) {
                    writer.append(component.componentTemplate().template()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

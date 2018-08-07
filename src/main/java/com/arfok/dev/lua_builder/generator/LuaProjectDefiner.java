package com.arfok.dev.lua_builder.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LuaProjectDefiner {

    private static LuaProjectDefiner INSTANCE;

    private final String projectName;

    /**
     * Create a new instance of the lua project in order to
     * generate the specific files associated.
     *
     * @param projectName the path of the project (included the name of the project).
     */
    private LuaProjectDefiner(String projectName) {
        this.projectName = projectName;
    }

    public static LuaProjectDefiner getInstance(String projectName) {
        if (INSTANCE == null) {
            INSTANCE = new LuaProjectDefiner(projectName);
        }

        return INSTANCE;
    }

    /**
     * Check if an existing project has already been created, if it's the case then
     * the method return directly the {@link File} associated defined as the project
     * folder.
     * If not, then the function creates a new file object to define the lua project.
     * The method throws an {@link IllegalStateException} if the creation of the new project
     * failed else it returns the new Folder created.
     *
     * @return the lua project file associated.
     * @throws IOException if the creation of the lua is not possible.
     */
    public File setAndGetLuaProject() throws IOException {
        final File luaProjectFile = new File(projectName);
        final Path projetPath = Paths.get(projectName);
        if (Files.exists(projetPath)) {
            return luaProjectFile;
        }

        if(luaProjectFile.createNewFile()) {
            try (BufferedWriter writer = Files.newBufferedWriter(projetPath)) {
                writer.append("");
                return luaProjectFile;
            }
        }

        throw new IllegalStateException("Unable to generate the new lua project.");
    }

    /**
     * Get the lua project defined as property of the LuaProjectDefiner class.
     *
     * @return the path of the lua project.
     */
    public String getProjectName() {
        return projectName;
    }
}

/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderPerformanceMetrics;
import de.vw.mib.graphics.shader.ShaderProgram;
import java.util.List;

public interface ShaderManager
extends ResourceManager {
    default public ShaderPerformanceMetrics getPerformanceMetrics() {
    }

    default public CachePerformanceMetrics getShaderCacheUsage() {
    }

    default public int getShadingLanguage() {
    }

    default public int getShaderProgramMaxVertexUniformVectors() {
    }

    default public int getShaderProgramMaxFragmentUniformVectors() {
    }

    default public int getShaderProgramMaxVaryingVectors() {
    }

    default public int getShaderProgramMaxVertexAttributes() {
    }

    default public Shader createShader(int n, int n2) {
    }

    default public Shader getShader(int n, int n2, List list) {
    }

    default public ShaderProgram createShaderProgram() {
    }

    default public String loadShaderSourceFromFile(String string) {
    }
}


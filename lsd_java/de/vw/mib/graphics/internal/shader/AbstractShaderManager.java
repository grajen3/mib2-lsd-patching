/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.shader.ShaderCache;
import de.vw.mib.graphics.internal.shader.ShaderFactory;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderCompileException;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderPerformanceMetrics;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public abstract class AbstractShaderManager
extends AbstractResource
implements ShaderManager,
GraphicsListener {
    private static final boolean ENABLE_SHADER_CACHE = System.getProperty("de.vw.mib.graphics.shader.disablecache") == null;
    private final ShaderPerformanceMetrics performanceMetrics = new ShaderPerformanceMetrics();
    private final ShaderFactory shaderFactory = new ShaderFactory();
    private final ShaderCache shaderCache = new ShaderCache();

    public AbstractShaderManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
        graphics3D.addListener(this);
    }

    @Override
    public void dispose() {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.removeListener(this);
        super.dispose();
    }

    @Override
    public final ShaderPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public final CachePerformanceMetrics getShaderCacheUsage() {
        return new CachePerformanceMetrics(this.shaderCache.size(), this.shaderCache.getByteSize(), this.shaderCache.getMaximumCacheSizeBytes(), this.shaderCache.hits(), this.shaderCache.misses());
    }

    @Override
    public abstract int getShadingLanguage() {
    }

    @Override
    public abstract int getShaderProgramMaxVertexUniformVectors() {
    }

    @Override
    public abstract int getShaderProgramMaxFragmentUniformVectors() {
    }

    @Override
    public abstract int getShaderProgramMaxVaryingVectors() {
    }

    @Override
    public abstract int getShaderProgramMaxVertexAttributes() {
    }

    @Override
    public abstract Shader createShader(int n, int n2) {
    }

    @Override
    public final Shader getShader(int n, int n2, List list) {
        Shader shader;
        Shader shader2 = shader = ENABLE_SHADER_CACHE ? this.shaderCache.get(n, n2, list) : null;
        if (shader == null) {
            try {
                shader = this.createShader(n, n2);
                shader.setSource(list);
                shader.compile();
                this.shaderCache.put(n, n2, list, shader);
            }
            catch (ShaderCompileException shaderCompileException) {
                shader.dispose();
                throw shaderCompileException;
            }
        }
        return shader;
    }

    @Override
    public abstract ShaderProgram createShaderProgram() {
    }

    @Override
    public final String loadShaderSourceFromFile(String string) {
        return this.shaderFactory.readShaderSourceFromFile(string);
    }

    @Override
    public final void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
        if (bl) {
            this.performanceMetrics.clear();
        }
    }
}


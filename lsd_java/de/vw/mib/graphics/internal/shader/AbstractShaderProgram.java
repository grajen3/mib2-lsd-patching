/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Matrix2f;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderPerformanceMetrics;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.graphics.shader.ShaderVariable;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractShaderProgram
extends AbstractResource
implements ShaderProgram {
    private static final int SHADER_LIST_INITIAL_CAPACITY;
    private final ShaderManager shaderManager;
    private final List shaders;
    private final Map vertexAttributes;
    private final Map uniforms;
    private VertexAttributeBinding vertexAttributeBinding;
    private boolean linked;

    public AbstractShaderProgram(Graphics3D graphics3D, Logger logger, ShaderManager shaderManager) {
        super(graphics3D, logger);
        this.shaderManager = shaderManager;
        this.shaders = new ArrayList(2);
        this.vertexAttributes = new HashMap();
        this.uniforms = new HashMap();
        this.vertexAttributeBinding = null;
        this.linked = false;
        this.updateAllocationStatistics(this.shaderManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.shaderManager.getPerformanceMetrics(), false);
        super.dispose();
    }

    protected final void updateAllocationStatistics(ShaderPerformanceMetrics shaderPerformanceMetrics, boolean bl) {
        shaderPerformanceMetrics.allocatedShaderPrograms = shaderPerformanceMetrics.allocatedShaderPrograms + (bl ? 1 : -1);
    }

    @Override
    public int getByteSize() {
        throw new NotYetImplementedException();
    }

    protected final ShaderManager getShaderManager() {
        return this.shaderManager;
    }

    @Override
    public void attachShader(Shader shader) {
        this.shaders.add(shader);
    }

    @Override
    public final List getShaders() {
        return this.shaders;
    }

    @Override
    public final VertexAttributeBinding getVertexAttributeBinding() {
        return this.vertexAttributeBinding;
    }

    @Override
    public void setVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        this.vertexAttributeBinding = vertexAttributeBinding;
    }

    @Override
    public final boolean isLinked() {
        return this.linked;
    }

    protected final void setLinked(boolean bl) {
        this.linked = bl;
    }

    @Override
    public abstract void link() {
    }

    @Override
    public final Map getVertexAttributes() {
        return this.vertexAttributes;
    }

    @Override
    public final ShaderVariable getVertexAttribute(String string) {
        return (ShaderVariable)this.vertexAttributes.get(string);
    }

    protected final ShaderVariable addVertexAttribute(String string, int n, int n2, int n3) {
        ShaderVariable shaderVariable = new ShaderVariable(0, string, n, n2, n3);
        this.vertexAttributes.put(string, shaderVariable);
        return shaderVariable;
    }

    @Override
    public final int getVertexAttributeIndex(String string) {
        ShaderVariable shaderVariable = this.getVertexAttribute(string);
        return shaderVariable != null ? shaderVariable.getLocation() : -1;
    }

    @Override
    public abstract void setVertexAttribute(int n, float f2) {
    }

    @Override
    public abstract void setVertexAttribute(int n, float f2, float f3) {
    }

    @Override
    public final void setVertexAttribute(int n, Tuple2f tuple2f) {
        this.setVertexAttribute(n, tuple2f.x, tuple2f.y);
    }

    @Override
    public abstract void setVertexAttribute(int n, float f2, float f3, float f4) {
    }

    @Override
    public final void setVertexAttribute(int n, Tuple3f tuple3f) {
        this.setVertexAttribute(n, tuple3f.x, tuple3f.y, tuple3f.z);
    }

    @Override
    public abstract void setVertexAttribute(int n, float f2, float f3, float f4, float f5) {
    }

    @Override
    public final void setVertexAttribute(int n, Tuple4f tuple4f) {
        this.setVertexAttribute(n, tuple4f.x, tuple4f.y, tuple4f.z, tuple4f.w);
    }

    @Override
    public final Map getUniforms() {
        return this.uniforms;
    }

    @Override
    public final ShaderVariable getUniform(String string) {
        return (ShaderVariable)this.uniforms.get(string);
    }

    protected final ShaderVariable addUniform(String string, int n, int n2, int n3) {
        ShaderVariable shaderVariable = new ShaderVariable(1, string, n, n2, n3);
        this.uniforms.put(string, shaderVariable);
        return shaderVariable;
    }

    @Override
    public final int getUniformIndex(String string) {
        ShaderVariable shaderVariable = this.getUniform(string);
        return shaderVariable != null ? shaderVariable.getLocation() : -1;
    }

    @Override
    public final void setUniform(int n, boolean bl) {
        this.setUniform(n, bl ? 1 : 0);
    }

    @Override
    public final void setUniform(int n, boolean bl, boolean bl2) {
        this.setUniform(n, bl ? 1 : 0, bl2 ? 1 : 0);
    }

    @Override
    public final void setUniform(int n, boolean bl, boolean bl2, boolean bl3) {
        this.setUniform(n, bl ? 1 : 0, bl2 ? 1 : 0, bl3 ? 1 : 0);
    }

    @Override
    public final void setUniform(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.setUniform(n, bl ? 1 : 0, bl2 ? 1 : 0, bl3 ? 1 : 0, bl4 ? 1 : 0);
    }

    @Override
    public abstract void setUniform(int n, int n2) {
    }

    @Override
    public abstract void setUniform(int n, int[] nArray) {
    }

    @Override
    public abstract void setUniform(int n, int n2, int n3) {
    }

    @Override
    public abstract void setUniform(int n, int n2, int n3, int n4) {
    }

    @Override
    public abstract void setUniform(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public abstract void setUniform(int n, float f2) {
    }

    @Override
    public abstract void setUniform(int n, float[] fArray) {
    }

    @Override
    public abstract void setUniform(int n, float f2, float f3) {
    }

    @Override
    public final void setUniform(int n, Tuple2f tuple2f) {
        this.setUniform(n, tuple2f.x, tuple2f.y);
    }

    @Override
    public abstract void setUniform(int n, Tuple2f[] tuple2fArray) {
    }

    @Override
    public abstract void setUniform(int n, float f2, float f3, float f4) {
    }

    @Override
    public final void setUniform(int n, Tuple3f tuple3f) {
        this.setUniform(n, tuple3f.x, tuple3f.y, tuple3f.z);
    }

    @Override
    public abstract void setUniform(int n, Tuple3f[] tuple3fArray) {
    }

    @Override
    public abstract void setUniform(int n, float f2, float f3, float f4, float f5) {
    }

    @Override
    public final void setUniform(int n, Tuple4f tuple4f) {
        this.setUniform(n, tuple4f.x, tuple4f.y, tuple4f.z, tuple4f.w);
    }

    @Override
    public abstract void setUniform(int n, Tuple4f[] tuple4fArray) {
    }

    @Override
    public abstract void setUniform(int n, Matrix2f matrix2f) {
    }

    @Override
    public abstract void setUniform(int n, Matrix2f[] matrix2fArray) {
    }

    @Override
    public abstract void setUniform(int n, Matrix3f matrix3f) {
    }

    @Override
    public abstract void setUniform(int n, Matrix3f[] matrix3fArray) {
    }

    @Override
    public abstract void setUniform(int n, Matrix4f matrix4f) {
    }

    @Override
    public abstract void setUniform(int n, Matrix4f[] matrix4fArray) {
    }

    public void bind() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            ShaderPerformanceMetrics shaderPerformanceMetrics = this.getShaderManager().getPerformanceMetrics();
            ++shaderPerformanceMetrics.shaderProgramBinds;
        }
    }
}


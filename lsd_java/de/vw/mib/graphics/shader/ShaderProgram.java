/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Matrix2f;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderVariable;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;
import java.util.Map;

public interface ShaderProgram
extends Resource,
Cacheable {
    public static final int INVALID_INDEX;

    default public void attachShader(Shader shader) {
    }

    default public List getShaders() {
    }

    default public VertexAttributeBinding getVertexAttributeBinding() {
    }

    default public void setVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
    }

    default public boolean isLinked() {
    }

    default public void link() {
    }

    default public Map getVertexAttributes() {
    }

    default public ShaderVariable getVertexAttribute(String string) {
    }

    default public int getVertexAttributeIndex(String string) {
    }

    default public void setVertexAttribute(int n, float f2) {
    }

    default public void setVertexAttribute(int n, float f2, float f3) {
    }

    default public void setVertexAttribute(int n, Tuple2f tuple2f) {
    }

    default public void setVertexAttribute(int n, float f2, float f3, float f4) {
    }

    default public void setVertexAttribute(int n, Tuple3f tuple3f) {
    }

    default public void setVertexAttribute(int n, float f2, float f3, float f4, float f5) {
    }

    default public void setVertexAttribute(int n, Tuple4f tuple4f) {
    }

    default public Map getUniforms() {
    }

    default public ShaderVariable getUniform(String string) {
    }

    default public int getUniformIndex(String string) {
    }

    default public void setUniform(int n, boolean bl) {
    }

    default public void setUniform(int n, boolean bl, boolean bl2) {
    }

    default public void setUniform(int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void setUniform(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void setUniform(int n, int n2) {
    }

    default public void setUniform(int n, int[] nArray) {
    }

    default public void setUniform(int n, int n2, int n3) {
    }

    default public void setUniform(int n, int n2, int n3, int n4) {
    }

    default public void setUniform(int n, int n2, int n3, int n4, int n5) {
    }

    default public void setUniform(int n, float f2) {
    }

    default public void setUniform(int n, float[] fArray) {
    }

    default public void setUniform(int n, float f2, float f3) {
    }

    default public void setUniform(int n, Tuple2f tuple2f) {
    }

    default public void setUniform(int n, Tuple2f[] tuple2fArray) {
    }

    default public void setUniform(int n, float f2, float f3, float f4) {
    }

    default public void setUniform(int n, Tuple3f tuple3f) {
    }

    default public void setUniform(int n, Tuple3f[] tuple3fArray) {
    }

    default public void setUniform(int n, float f2, float f3, float f4, float f5) {
    }

    default public void setUniform(int n, Tuple4f tuple4f) {
    }

    default public void setUniform(int n, Tuple4f[] tuple4fArray) {
    }

    default public void setUniform(int n, Matrix2f matrix2f) {
    }

    default public void setUniform(int n, Matrix2f[] matrix2fArray) {
    }

    default public void setUniform(int n, Matrix3f matrix3f) {
    }

    default public void setUniform(int n, Matrix3f[] matrix3fArray) {
    }

    default public void setUniform(int n, Matrix4f matrix4f) {
    }

    default public void setUniform(int n, Matrix4f[] matrix4fArray) {
    }
}


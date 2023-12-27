/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.GraphicsPerformanceMetrics;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawableManager;
import de.vw.mib.graphics.effect.EffectManager;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.material.MaterialManager;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.model.Model;
import de.vw.mib.graphics.scene.SceneManager;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.TextureManager;
import java.nio.Buffer;

public interface Graphics3D
extends Disposable {
    public static final int BLEND_FACTOR_ZERO;
    public static final int BLEND_FACTOR_ONE;
    public static final int BLEND_FACTOR_SRC_COLOR;
    public static final int BLEND_FACTOR_ONE_MINUS_SRC_COLOR;
    public static final int BLEND_FACTOR_DST_COLOR;
    public static final int BLEND_FACTOR_ONE_MINUS_DST_COLOR;
    public static final int BLEND_FACTOR_SRC_ALPHA;
    public static final int BLEND_FACTOR_ONE_MINUS_SRC_ALPHA;
    public static final int BLEND_FACTOR_DST_ALPHA;
    public static final int BLEND_FACTOR_ONE_MINUS_DST_ALPHA;
    public static final int BLEND_FACTOR_SRC_ALPHA_SATURATE;
    public static final int BLEND_FACTOR_CONSTANT_COLOR;
    public static final int BLEND_FACTOR_ONE_MINUS_CONSTANT_COLOR;
    public static final int BLEND_FACTOR_CONSTANT_ALPHA;
    public static final int BLEND_FACTOR_ONE_MINUS_CONSTANT_ALPHA;
    public static final int BLEND_EQUATION_ADD;
    public static final int BLEND_EQUATION_SUBTRACT;
    public static final int BLEND_EQUATION_REVERSE_SUBTRACT;
    public static final int COMPARE_NEVER;
    public static final int COMPARE_LESS;
    public static final int COMPARE_EQUAL;
    public static final int COMPARE_LESS_EQUAL;
    public static final int COMPARE_GREATER;
    public static final int COMPARE_GREATER_EQUAL;
    public static final int COMPARE_NOT_EQUAL;
    public static final int COMPARE_ALWAYS;
    public static final int STENCIL_KEEP;
    public static final int STENCIL_ZERO;
    public static final int STENCIL_REPLACE;
    public static final int STENCIL_INCREMENT;
    public static final int STENCIL_INCREMENT_WRAP;
    public static final int STENCIL_DECREMENT;
    public static final int STENCIL_DECREMENT_WRAP;
    public static final int STENCIL_INVERT;
    public static final int VERTEX_WINDING_CLOCKWISE;
    public static final int VERTEX_WINDING_COUNTERCLOCKWISE;
    public static final int CULL_FACE_FRONT;
    public static final int CULL_FACE_BACK;
    public static final int CULL_FACE_FRONT_AND_BACK;
    public static final int MATRIX_VIEW;
    public static final int MATRIX_PROJECTION;

    default public void addListener(GraphicsListener graphicsListener) {
    }

    default public void removeListener(GraphicsListener graphicsListener) {
    }

    default public Surface getSurface() {
    }

    default public void flush() {
    }

    default public void finish() {
    }

    default public void readPixels(int n, int n2, int n3, int n4, Buffer buffer) {
    }

    default public boolean arePerformanceMetricsEnabled() {
    }

    default public void setPerformanceMetricsEnabled(boolean bl) {
    }

    default public GraphicsPerformanceMetrics getPerformanceMetrics() {
    }

    default public void reset() {
    }

    default public boolean areFrameBuffersSupported() {
    }

    default public FrameBufferManager getFrameBufferManager() {
    }

    default public FrameBuffer getFrameBuffer() {
    }

    default public void setFrameBuffer(FrameBuffer frameBuffer) {
    }

    default public boolean isColorBufferRedChannelEnabled() {
    }

    default public boolean isColorBufferGreenChannelEnabled() {
    }

    default public boolean isColorBufferBlueChannelEnabled() {
    }

    default public boolean isColorBufferAlphaChannelEnabled() {
    }

    default public void setColorBufferEnabled(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public boolean isDepthBufferEnabled() {
    }

    default public void setDepthBufferEnabled(boolean bl) {
    }

    default public int isStencilBufferEnabled() {
    }

    default public void setStencilBufferEnabled(int n) {
    }

    default public boolean isDitheringEnabled() {
    }

    default public void setDitheringEnabled(boolean bl) {
    }

    default public void getViewport(Rectangle rectangle) {
    }

    default public void setViewport(Rectangle rectangle) {
    }

    default public void setViewport(int n, int n2, int n3, int n4) {
    }

    default public float getDepthRangeNear() {
    }

    default public float getDepthRangeFar() {
    }

    default public void setDepthRange(float f2, float f3) {
    }

    default public void clearColorBuffer(Color4f color4f) {
    }

    default public void clearDepthBuffer(float f2) {
    }

    default public void clearStencilBuffer(int n) {
    }

    default public void clearColorDepthBuffer(Color4f color4f, float f2) {
    }

    default public void clearColorDepthStencilBuffer(Color4f color4f, float f2, int n) {
    }

    default public void getScissor(Rectangle rectangle) {
    }

    default public void setScissor(Rectangle rectangle) {
    }

    default public void setAbsScissor(Rectangle rectangle) {
    }

    default public void getAbsScissor(Rectangle rectangle) {
    }

    default public void setScissor(int n, int n2, int n3, int n4) {
    }

    default public void setAbsScissor(int n, int n2, int n3, int n4) {
    }

    default public boolean isScissorTestEnabled() {
    }

    default public void setScissorTestEnabled(boolean bl) {
    }

    default public int getAlphaTestFunction() {
    }

    default public float getAlphaTestReferenceValue() {
    }

    default public void setAlphaTest(int n, float f2) {
    }

    default public boolean isAlphaTestEnabled() {
    }

    default public void setAlphaTestEnabled(boolean bl) {
    }

    default public int getDepthTestFunction() {
    }

    default public void setDepthTestFunction(int n) {
    }

    default public boolean isDepthTestEnabled() {
    }

    default public void setDepthTestEnabled(boolean bl) {
    }

    default public int getStencilTestFunction() {
    }

    default public int getStencilTestReferenceValue() {
    }

    default public int getStencilTestMask() {
    }

    default public void setStencilTest(int n, int n2, int n3) {
    }

    default public boolean isStencilTestEnabled() {
    }

    default public void setStencilTestEnabled(boolean bl) {
    }

    default public int getStencilFailOperation() {
    }

    default public int getStencilZFailOperation() {
    }

    default public int getStencilZPassOperation() {
    }

    default public void setStencilOperation(int n, int n2, int n3) {
    }

    default public int getBlendFactorSourceRGB() {
    }

    default public int getBlendFactorDestinationRGB() {
    }

    default public int getBlendFactorSourceAlpha() {
    }

    default public int getBlendFactorDestinationAlpha() {
    }

    default public void setBlendFactorsSeparate(int n, int n2, int n3, int n4) {
    }

    default public boolean isBlendColorAvailable() {
    }

    default public void getBlendColor(Color4f color4f) {
    }

    default public void setBlendColor(Color4f color4f) {
    }

    default public int getBlendEquation() {
    }

    default public void setBlendEquation(int n) {
    }

    default public int getBlendEquationRGB() {
    }

    default public int getBlendEquationAlpha() {
    }

    default public void setBlendEquationSeparate(int n, int n2) {
    }

    default public boolean isBlendingEnabled() {
    }

    default public void setBlendingEnabled(boolean bl) {
    }

    default public int getFrontFaceWinding() {
    }

    default public void setFrontFaceWinding(int n) {
    }

    default public int getCullFace() {
    }

    default public void setCullFace(int n) {
    }

    default public boolean isCullingEnabled() {
    }

    default public void setCullingEnabled(boolean bl) {
    }

    default public float getMinimumLineWidth() {
    }

    default public float getMaximumLineWidth() {
    }

    default public float getLineWidth() {
    }

    default public void setLineWidth(float f2) {
    }

    default public float getMinimumPointSize() {
    }

    default public float getMaximumPointSize() {
    }

    default public float getPointSize() {
    }

    default public void setPointSize(float f2) {
    }

    default public Graphics3D resetMatrix(int n) {
    }

    default public Graphics3D multiplyMatrix(int n, Transform transform) {
    }

    default public Graphics3D translateMatrix(int n, float f2, float f3, float f4) {
    }

    default public Graphics3D rotateMatrix(int n, float f2, float f3, float f4, float f5) {
    }

    default public Graphics3D scaleMatrix(int n, float f2, float f3, float f4) {
    }

    default public Graphics3D pushMatrix(int n) {
    }

    default public Graphics3D popMatrix(int n) {
    }

    default public TextureManager getTextureManager() {
    }

    default public void setTexture(int n, Texture texture) {
    }

    default public boolean areShadersSupported() {
    }

    default public ShaderManager getShaderManager() {
    }

    default public void setShaderProgram(ShaderProgram shaderProgram) {
    }

    default public MeshManager getMeshManager() {
    }

    default public Mesh getMesh() {
    }

    default public void setMesh(Mesh mesh) {
    }

    default public void getViewTransformation(Transform transform) {
    }

    default public void setViewTransformation(Transform transform) {
    }

    default public void getProjectionTransformation(Matrix4f matrix4f) {
    }

    default public void setProjectionTransformation(Matrix4f matrix4f) {
    }

    default public void draw() {
    }

    default public void draw(Primitives primitives) {
    }

    default public EffectManager getEffectManager() {
    }

    default public DrawableManager getDrawableManager() {
    }

    default public MaterialManager getMaterialManager() {
    }

    default public Model createModel() {
    }

    default public SceneManager getSceneManager() {
    }
}


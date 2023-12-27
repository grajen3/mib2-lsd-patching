/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.internal.AbstractGraphics3D;
import de.vw.mib.graphics.internal.effect.shader.lighting.BlinnPhongLightingShaderEffect;
import de.vw.mib.graphics.internal.gl.GLConfiguration;
import de.vw.mib.graphics.internal.gl.GLFrameBuffer;
import de.vw.mib.graphics.internal.gl.GLFrameBufferManager;
import de.vw.mib.graphics.internal.gl.GLMesh;
import de.vw.mib.graphics.internal.gl.GLMeshManager;
import de.vw.mib.graphics.internal.gl.GLPBufferSurface;
import de.vw.mib.graphics.internal.gl.GLShaderManager;
import de.vw.mib.graphics.internal.gl.GLShaderProgram;
import de.vw.mib.graphics.internal.gl.GLSurface;
import de.vw.mib.graphics.internal.gl.GLTexture;
import de.vw.mib.graphics.internal.gl.GLTextureManager;
import de.vw.mib.graphics.internal.state.TextureUnitState;
import de.vw.mib.graphics.light.Light;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.TextureManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.nio.Buffer;
import java.util.StringTokenizer;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;

public final class GLGraphics3D
extends AbstractGraphics3D {
    private static final boolean MONITOR_NATIVE_MATRIX_STACKS;
    private static final boolean AA_ENABLED;
    private static final boolean FSAA_ENABLED;
    public static final int COMPONENTS_OR_FLOATS_PER_VECTOR;
    private static final boolean NATIVE_MATRIX_OPS;
    public static final boolean FIXED_FUNCTION_PIPELINE;
    public static final boolean GLES20_SUBSET;
    private final Logger logger;
    private GLContext glContext;
    private GL gl;
    private GLConfiguration config;
    private int lastError;
    private boolean fboExtensionAvailable;
    private boolean integerIndicesSupported;
    private float lineWidthMin;
    private float lineWidthMax;
    private float pointSizeMin;
    private float pointSizeMax;
    private int lightsMax;
    private int clipPlanesMax;
    private int modelViewMatrixStackDepthMax;
    private int projectionMatrixStackDepthMax;
    private int textureMatrixStackDepthMax;
    private int selectedMatrixMode;
    private int selectedTextureUnit;
    private GLFrameBufferManager frameBufferManager;
    private GLTextureManager textureManager;
    private GLShaderManager shaderManager;
    private GLMeshManager meshManager;
    private boolean[] textureChanged;
    private boolean shaderProgramChanged;
    private boolean meshChanged;
    private Matrix4f tempMatrix = new Matrix4f();
    private float[] temp4f = new float[4];
    private float[] tempMatrix4f = new float[16];
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLGraphics3D;

    public GLGraphics3D(Logger logger, GLContext gLContext, GLConfiguration gLConfiguration) {
        this.logger = logger;
        this.glContext = gLContext;
        this.gl = gLContext.getGL();
        this.config = gLConfiguration;
    }

    public GLGraphics3D(GLGraphics3D gLGraphics3D, GLContext gLContext) {
        super(gLGraphics3D);
        this.logger = gLGraphics3D.logger;
        this.glContext = gLGraphics3D.glContext;
        this.gl = gLGraphics3D.gl;
        this.config = gLGraphics3D.config;
        this.frameBufferManager = gLGraphics3D.frameBufferManager;
        this.meshManager = gLGraphics3D.meshManager;
        this.shaderManager = gLGraphics3D.shaderManager;
        this.textureManager = gLGraphics3D.textureManager;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }

    boolean checkGLError() {
        this.lastError = this.gl.glGetError();
        return this.lastError == 0;
    }

    String printGLError(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("() failed with code: 0x");
        stringBuilder.append(Integer.toHexString(this.lastError));
        stringBuilder.append(" (");
        switch (this.lastError) {
            case 0: {
                stringBuilder.append("No error");
                break;
            }
            case 1280: {
                stringBuilder.append("Invalid enum");
                break;
            }
            case 1281: {
                stringBuilder.append("Invalid value");
                break;
            }
            case 1282: {
                stringBuilder.append("Invalid operation");
                break;
            }
            case 1283: {
                stringBuilder.append("Stack overflow");
                break;
            }
            case 1284: {
                stringBuilder.append("Stack underflow");
                break;
            }
            case 1285: {
                stringBuilder.append("Out of memory");
                break;
            }
            default: {
                stringBuilder.append("Unknown");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public GL getGL() {
        return this.gl;
    }

    public GLContext getContext() {
        return this.glContext;
    }

    public GLConfiguration getConfig() {
        return this.config;
    }

    public GLSurface getGLSurface() {
        return (GLSurface)this.getSurface();
    }

    public void printGLCapabilities() {
        int[] nArray;
        int[] nArray2;
        int[] nArray3;
        Object object;
        this.logger.trace(256, "OpenGL Information:");
        this.logger.trace(256, "------------------------------------------");
        String string = this.gl.glGetString(7936);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetString"));
        }
        LogMessage logMessage = this.logger.trace(256);
        logMessage.append("Vendor: ").append(string).log();
        String string2 = this.gl.glGetString(7937);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetString"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Renderer: ").append(string2).log();
        String string3 = this.gl.glGetString(7938);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetString"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Version: ").append(string3).log();
        String string4 = this.gl.glGetString(7939);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetString"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Extensions: ").log();
        if (string4 != null) {
            object = new StringTokenizer(string4, " ");
            while (((StringTokenizer)object).hasMoreTokens()) {
                logMessage = this.logger.trace(256);
                logMessage.append("\t").append(((StringTokenizer)object).nextToken()).log();
            }
        } else {
            logMessage = this.logger.trace(256);
            logMessage.append("\tNone").log();
        }
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            object = new int[]{0};
            this.gl.glGetIntegerv(3378, (int[])object, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            logMessage = this.logger.trace(256);
            logMessage.append("Number of clipping planes: ").append((int)object[0]).log();
        }
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            object = new int[]{0};
            this.gl.glGetIntegerv(3377, (int[])object, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            logMessage = this.logger.trace(256);
            logMessage.append("Number of lights: ").append((int)object[0]).log();
        }
        object = new int[]{0};
        this.gl.glGetIntegerv(3379, (int[])object, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Maximum texture size: ").append((int)object[0]).log();
        if (!GLES20_SUBSET) {
            nArray3 = new int[]{0};
            this.gl.glGetIntegerv(-494665728, nArray3, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            logMessage = this.logger.trace(256);
            logMessage.append("Number of texture units: ").append(nArray3[0]).log();
        }
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            nArray3 = new int[]{0};
            this.gl.glGetIntegerv(3382, nArray3, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            logMessage = this.logger.trace(256);
            logMessage.append("Modelview matrix stack depth: ").append(nArray3[0]).log();
            nArray2 = new int[]{0};
            this.gl.glGetIntegerv(3385, nArray2, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            logMessage = this.logger.trace(256);
            logMessage.append("Texture matrix stack depth: ").append(nArray2[0]).log();
            nArray = new int[]{0};
            this.gl.glGetIntegerv(3384, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            logMessage = this.logger.trace(256);
            logMessage.append("Projection matrix stack depth: ").append(nArray[0]).log();
        }
        nArray3 = new int[]{0};
        this.gl.glGetIntegerv(3414, nArray3, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Depth buffer size: ").append(nArray3[0]).log();
        nArray2 = new int[]{0};
        this.gl.glGetIntegerv(1284177920, nArray2, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Maximum vertex shader texture image units: ").append(nArray2[0]).log();
        nArray = new int[]{0};
        this.gl.glGetIntegerv(1921515520, nArray, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Maximum fragment shader texture image units: ").append(nArray[0]).log();
        int[] nArray4 = new int[]{0};
        this.gl.glGetIntegerv(1300955136, nArray4, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Maximum combined texture image units: ").append(nArray4[0]).log();
        int[] nArray5 = new int[]{0};
        this.gl.glGetIntegerv(1770520576, nArray5, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Maximum vertex shader attributes: ").append(nArray5[0]).log();
        int[] nArray6 = new int[]{0};
        this.gl.glGetIntegerv(-394002432, nArray6, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        logMessage = this.logger.trace(256);
        logMessage.append("Maximum renderbuffer size: ").append(nArray6[0]).log();
    }

    public void bind(GLSurface gLSurface) {
        int[] nArray;
        Object object;
        Object object2;
        if (this.logger.isTraceEnabled(256) && this.getGLSurface() == null) {
            this.printGLCapabilities();
        }
        String string = this.gl.glGetString(7939);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetString"));
        }
        if (string != null) {
            object2 = new StringTokenizer(string, " ");
            while (((StringTokenizer)object2).hasMoreTokens()) {
                object = ((StringTokenizer)object2).nextToken();
                if (((String)object).equals("GL_EXT_framebuffer_object")) {
                    this.fboExtensionAvailable = true;
                }
                if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET || !((String)object).equals("GL_OES_element_index_uint")) continue;
                this.integerIndicesSupported = true;
            }
        }
        if (GLES20_SUBSET) {
            this.fboExtensionAvailable = true;
        }
        object2 = new float[]{0.0f, 0.0f};
        this.gl.glGetFloatv(1854144512, (float[])object2, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        this.lineWidthMin = (float)object2[0];
        this.lineWidthMax = (float)object2[1];
        object = new float[]{0.0f, 0.0f};
        this.gl.glGetFloatv(1837367296, (float[])object, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
        }
        this.pointSizeMin = (float)object[0];
        this.pointSizeMax = (float)object[1];
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            nArray = new int[]{0};
            this.gl.glGetIntegerv(3377, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.lightsMax = nArray[0];
        } else {
            this.lightsMax = BlinnPhongLightingShaderEffect.MAX_LIGHTS;
        }
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            nArray = new int[]{0};
            this.gl.glGetIntegerv(3378, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.clipPlanesMax = nArray[0];
        } else {
            this.clipPlanesMax = 0;
        }
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            nArray = new int[]{0};
            this.gl.glGetIntegerv(3382, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.modelViewMatrixStackDepthMax = nArray[0];
            int[] nArray2 = new int[]{0};
            this.gl.glGetIntegerv(3384, nArray2, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.projectionMatrixStackDepthMax = nArray2[0];
            int[] nArray3 = new int[]{0};
            this.selectTextureUnit(0);
            this.gl.glGetIntegerv(3385, nArray3, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.textureMatrixStackDepthMax = nArray3[0];
        }
        super.bind(gLSurface);
    }

    @Override
    public void unbind() {
        super.unbind();
    }

    @Override
    public void reset() {
        int n = this.getTextureManager().getMaxTextureUnits();
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.gl.glShadeModel(7425);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glShadeModel"));
            }
        }
        if (!GLES20_SUBSET) {
            // empty if block
        }
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET && NATIVE_MATRIX_OPS) {
            int n2;
            int[] nArray = new int[]{0};
            this.selectMatrixMode(0);
            this.gl.glGetIntegerv(2979, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            for (n2 = nArray[0]; n2 > 1; --n2) {
                this.gl.glPopMatrix();
            }
            this.selectMatrixMode(1);
            this.gl.glGetIntegerv(2980, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            for (n2 = nArray[0]; n2 > 1; --n2) {
                this.gl.glPopMatrix();
            }
            this.selectMatrixMode(2);
            for (n2 = 0; n2 < n; ++n2) {
                this.selectTextureUnit(n2);
                this.gl.glGetIntegerv(2981, nArray, 0);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
                }
                for (int i2 = nArray[0]; i2 > 1; --i2) {
                    this.gl.glPopMatrix();
                }
            }
        }
        if (this.textureChanged == null) {
            this.textureChanged = new boolean[n];
            for (int i3 = 0; i3 < this.textureChanged.length; ++i3) {
                this.textureChanged[i3] = false;
            }
        }
        super.reset();
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectMatrixMode(0);
        }
        this.selectTextureUnit(0);
    }

    @Override
    public void beginFrame() {
        super.beginFrame();
    }

    @Override
    public void endFrame() {
        super.endFrame();
        if (MONITOR_NATIVE_MATRIX_STACKS && FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            int[] nArray = new int[]{0, 0, 0};
            this.gl.glGetIntegerv(2979, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.gl.glGetIntegerv(2980, nArray, 1);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            this.selectTextureUnit(0);
            this.gl.glGetIntegerv(2981, nArray, 2);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            if (nArray[0] > 1 || nArray[1] > 1 || nArray[2] > 1) {
                LogMessage logMessage = this.logger.warn(256);
                logMessage.append("Matrix Stack Depths:");
                logMessage.append(" ModelView = ").append(nArray[0]);
                logMessage.append(", Projection = ").append(nArray[1]);
                logMessage.append(", Texture = ").append(nArray[2]);
                logMessage.log();
            }
        }
    }

    @Override
    public void flush() {
        this.gl.glFlush();
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glFlush"));
        }
    }

    @Override
    public void finish() {
        this.gl.glFinish();
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glFinish"));
        }
    }

    @Override
    public void readPixels(int n, int n2, int n3, int n4, Buffer buffer) {
        this.gl.glReadPixels(n, n2, n3, n4, 6408, 5121, buffer);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glReadPixels"));
        }
    }

    private void drawBufferSurface(PBufferSurface pBufferSurface) {
        if (!$assertionsDisabled && !(pBufferSurface instanceof GLPBufferSurface)) {
            throw new AssertionError((Object)"bufferSurface must be instance of GLPBufferSurface");
        }
        GLPBufferSurface gLPBufferSurface = (GLPBufferSurface)pBufferSurface;
        int n = gLPBufferSurface.getTextureId();
        if (n == 0) {
            int[] nArray = new int[]{0};
            this.gl.glGenTextures(1, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGenTextures"));
            }
            n = nArray[0];
            gLPBufferSurface.setTextureId(n);
        }
        this.gl.glBindTexture(3553, n);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBindTexture"));
        }
        this.gl.glBindTexture(3553, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBindTexture"));
        }
    }

    @Override
    public boolean areFrameBuffersSupported() {
        return this.fboExtensionAvailable;
    }

    @Override
    public FrameBufferManager getFrameBufferManager() {
        if (this.frameBufferManager == null) {
            this.frameBufferManager = new GLFrameBufferManager(this);
        }
        return this.frameBufferManager;
    }

    @Override
    protected void frameBufferChanged(FrameBuffer frameBuffer) {
        if (!$assertionsDisabled && !(frameBuffer instanceof GLFrameBuffer)) {
            throw new AssertionError((Object)"frameBuffer must be instance of GLFrameBuffer");
        }
        GLFrameBuffer gLFrameBuffer = (GLFrameBuffer)frameBuffer;
        gLFrameBuffer.bind();
    }

    @Override
    protected void colorBufferEnabledChanged(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.gl.glColorMask(bl, bl2, bl3, bl4);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glColorMask"));
        }
    }

    @Override
    protected void depthBufferEnabledChanged(boolean bl) {
        this.gl.glDepthMask(bl);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glDepthMask"));
        }
    }

    @Override
    protected void stencilBufferEnabledChanged(int n) {
        this.gl.glStencilMask(n);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glStencilMask"));
        }
    }

    @Override
    protected void ditheringEnabledChanged(boolean bl) {
        if (bl) {
            this.gl.glEnable(3024);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glEnable"));
            }
        } else {
            this.gl.glDisable(3024);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glDisable"));
            }
        }
    }

    @Override
    protected void viewportChanged(int n, int n2, int n3, int n4) {
        this.gl.glViewport(n, n2, n3, n4);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glViewport"));
        }
    }

    @Override
    protected void depthRangeChanged(float f2, float f3) {
        this.gl.glDepthRange(f2, f3);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glDepthRange"));
        }
    }

    @Override
    public void clearColorBuffer(Color4f color4f) {
        super.clearColorBuffer(color4f);
        this.gl.glClearColor(color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha());
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearColor"));
        }
        this.gl.glClear(16384);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClear"));
        }
    }

    @Override
    public void clearDepthBuffer(float f2) {
        super.clearDepthBuffer(f2);
        this.gl.glClearDepth(f2);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearDepth"));
        }
        this.gl.glClear(256);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClear"));
        }
    }

    @Override
    public void clearStencilBuffer(int n) {
        super.clearStencilBuffer(n);
        this.gl.glClearStencil(n);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearStencil"));
        }
        this.gl.glClear(1024);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClear"));
        }
    }

    @Override
    public void clearColorDepthBuffer(Color4f color4f, float f2) {
        super.clearColorDepthBuffer(color4f, f2);
        this.gl.glClearColor(color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha());
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearColor"));
        }
        this.gl.glClearDepth(f2);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearDepth"));
        }
        this.gl.glClear(16640);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClear"));
        }
    }

    @Override
    public void clearColorDepthStencilBuffer(Color4f color4f, float f2, int n) {
        super.clearColorDepthStencilBuffer(color4f, f2, n);
        this.gl.glClearColor(color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha());
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearColor"));
        }
        this.gl.glClearDepth(f2);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearDepth"));
        }
        this.gl.glClearStencil(n);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClearStencil"));
        }
        this.gl.glClear(17664);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glClear"));
        }
    }

    @Override
    protected void scissorChanged(int n, int n2, int n3, int n4) {
        this.gl.glScissor(n, n2, n3, n4);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glScissor"));
        }
    }

    @Override
    protected void scissorTestEnabledChanged(boolean bl) {
        if (bl) {
            this.gl.glEnable(3089);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glEnable"));
            }
        } else {
            this.gl.glDisable(3089);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glDisable"));
            }
        }
    }

    private static int mapGLCompareFunc(int n) {
        switch (n) {
            case 0: {
                return 512;
            }
            case 1: {
                return 513;
            }
            case 2: {
                return 514;
            }
            case 3: {
                return 515;
            }
            case 4: {
                return 516;
            }
            case 5: {
                return 518;
            }
            case 6: {
                return 517;
            }
            case 7: {
                return 519;
            }
        }
        throw new IllegalArgumentException("Invalid compare function");
    }

    @Override
    protected void alphaTestChanged(int n, float f2) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.gl.glAlphaFunc(GLGraphics3D.mapGLCompareFunc(n), f2);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glAlphaFunc"));
            }
        }
    }

    @Override
    protected void alphaTestEnableChanged(boolean bl) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            if (bl) {
                this.gl.glEnable(3008);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
            } else {
                this.gl.glDisable(3008);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
            }
        }
    }

    @Override
    protected void depthTestFunctionChanged(int n) {
        this.gl.glDepthFunc(GLGraphics3D.mapGLCompareFunc(n));
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glDepthFunc"));
        }
    }

    @Override
    protected void depthTestEnableChanged(boolean bl) {
        if (bl) {
            this.gl.glEnable(2929);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glEnable"));
            }
        } else {
            this.gl.glDisable(2929);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glDisable"));
            }
        }
    }

    @Override
    protected void stencilTestChanged(int n, int n2, int n3) {
        this.gl.glStencilFunc(GLGraphics3D.mapGLCompareFunc(n), n2, n3);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glStencilFunc"));
        }
    }

    @Override
    protected void stencilTestEnableChanged(boolean bl) {
        if (bl) {
            this.gl.glEnable(2960);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glEnable"));
            }
        } else {
            this.gl.glDisable(2960);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glDisable"));
            }
        }
    }

    private static int mapGLStencilOp(int n) {
        switch (n) {
            case 0: {
                return 7680;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 7681;
            }
            case 3: {
                return 7682;
            }
            case 4: {
                return 126156800;
            }
            case 5: {
                return 7683;
            }
            case 6: {
                return 0x8850000;
            }
            case 7: {
                return 5386;
            }
        }
        throw new IllegalArgumentException("Invalid stencil operation");
    }

    @Override
    protected void stencilOperationChanged(int n, int n2, int n3) {
        this.gl.glStencilOp(GLGraphics3D.mapGLStencilOp(n), GLGraphics3D.mapGLStencilOp(n2), GLGraphics3D.mapGLStencilOp(n3));
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glStencilOp"));
        }
    }

    private static int mapGLBlendFactor(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 768;
            }
            case 3: {
                return 769;
            }
            case 4: {
                return 774;
            }
            case 5: {
                return 775;
            }
            case 6: {
                return 770;
            }
            case 7: {
                return 771;
            }
            case 8: {
                return 772;
            }
            case 9: {
                return 773;
            }
            case 10: {
                return 776;
            }
            case 11: {
                return 0x1800000;
            }
            case 12: {
                return 0x2800000;
            }
            case 13: {
                return 0x3800000;
            }
            case 14: {
                return 0x4800000;
            }
        }
        throw new IllegalArgumentException("Invalid blending factor");
    }

    @Override
    protected void blendFactorsChanged(int n, int n2) {
        this.gl.glBlendFunc(GLGraphics3D.mapGLBlendFactor(n), GLGraphics3D.mapGLBlendFactor(n2));
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBlendFunc"));
        }
    }

    @Override
    protected boolean isBlendFuncSeparateAvailable() {
        return true;
    }

    @Override
    protected void blendFactorsSeparateChanged(int n, int n2, int n3, int n4) {
        this.gl.glBlendFuncSeparate(GLGraphics3D.mapGLBlendFactor(n), GLGraphics3D.mapGLBlendFactor(n2), GLGraphics3D.mapGLBlendFactor(n3), GLGraphics3D.mapGLBlendFactor(n4));
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBlendFuncSeparate"));
        }
    }

    @Override
    public boolean isBlendColorAvailable() {
        return true;
    }

    @Override
    protected void blendColorChanged(Color4f color4f) {
        this.gl.glBlendColor(color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha());
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBlendColor"));
        }
    }

    private static int mapGLBlendEquation(int n) {
        switch (n) {
            case 0: {
                return 0x6800000;
            }
            case 1: {
                return 0xA800000;
            }
            case 2: {
                return 0xB800000;
            }
        }
        throw new IllegalArgumentException("Invalid blending equation");
    }

    @Override
    public boolean isBlendEquationAvailable() {
        return true;
    }

    @Override
    protected void blendEquationChanged(int n) {
        this.gl.glBlendEquation(GLGraphics3D.mapGLBlendEquation(n));
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBlendEquation"));
        }
    }

    @Override
    protected boolean isBlendEquationSeparateAvailable() {
        return true;
    }

    @Override
    protected void blendEquationSeparateChanged(int n, int n2) {
        this.gl.glBlendEquationSeparate(GLGraphics3D.mapGLBlendEquation(n), GLGraphics3D.mapGLBlendEquation(n2));
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glBlendEquationSeparate"));
        }
    }

    @Override
    protected void blendingEnabledChanged(boolean bl) {
        if (bl) {
            this.gl.glEnable(3042);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glEnable"));
            }
        } else {
            this.gl.glDisable(3042);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glDisable"));
            }
        }
    }

    @Override
    protected void frontFaceWindingChanged(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 2304;
                break;
            }
            case 1: {
                n2 = 2305;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid front face winding");
            }
        }
        this.gl.glFrontFace(n2);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glFrontFace"));
        }
    }

    @Override
    protected void cullFaceChanged(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1028;
                break;
            }
            case 1: {
                n2 = 1029;
                break;
            }
            case 2: {
                n2 = 1032;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid cull face");
            }
        }
        this.gl.glCullFace(n2);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glCullFace"));
        }
    }

    @Override
    protected void cullingEnabledChanged(boolean bl) {
        if (bl) {
            this.gl.glEnable(2884);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glEnable"));
            }
        } else {
            this.gl.glDisable(2884);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glDisable"));
            }
        }
    }

    @Override
    protected void colorChanged(Color4f color4f) {
        this.colorAlphaChanged(color4f, this.state.rasterizerState.alpha);
    }

    @Override
    protected void alphaChanged(float f2) {
        this.colorAlphaChanged(this.state.rasterizerState.color, f2);
    }

    private void colorAlphaChanged(Color4f color4f, float f2) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.gl.glColor4f(color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha() * f2);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glColor4f"));
            }
        }
    }

    @Override
    public float getMinimumLineWidth() {
        return this.lineWidthMin;
    }

    @Override
    public float getMaximumLineWidth() {
        return this.lineWidthMax;
    }

    @Override
    protected void lineWidthChanged(float f2) {
        this.gl.glLineWidth(f2);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glLineWidth"));
        }
    }

    @Override
    public float getMinimumPointSize() {
        return this.pointSizeMin;
    }

    @Override
    public float getMaximumPointSize() {
        return this.pointSizeMax;
    }

    @Override
    protected void pointSizeChanged(float f2) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.gl.glPointSize(f2);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glPointSize"));
            }
        }
    }

    @Override
    protected void materialChanged(Material material) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            material.getAmbientColor().get(this.temp4f);
            this.gl.glMaterialfv(1028, 4608, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glMaterialfv"));
            }
            material.getDiffuseColor().get(this.temp4f);
            this.gl.glMaterialfv(1028, 4609, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glMaterialfv"));
            }
            material.getSpecularColor().get(this.temp4f);
            this.gl.glMaterialfv(1028, 4610, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glMaterialfv"));
            }
            material.getEmissiveColor().get(this.temp4f);
            this.gl.glMaterialfv(1028, 5632, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glMaterialfv"));
            }
            this.gl.glMaterialf(1028, 5633, material.getShininess());
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glMaterialf"));
            }
        }
    }

    @Override
    public int getMaxLights() {
        return this.lightsMax;
    }

    @Override
    protected void lightingEnabledChanged(boolean bl) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            if (bl) {
                this.gl.glEnable(2896);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
            } else {
                this.gl.glDisable(2896);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
            }
        }
    }

    @Override
    protected void lightingAmbientColorChanged(Color4f color4f) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            color4f.get(this.temp4f);
            this.gl.glLightModelfv(2899, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightModelfv"));
            }
        }
    }

    @Override
    protected void lightChanged(int n, Light light) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            light.getAmbientColor().get(this.temp4f);
            this.gl.glLightfv(16384 + n, 4608, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightfv"));
            }
            light.getDiffuseColor().get(this.temp4f);
            this.gl.glLightfv(16384 + n, 4609, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightfv"));
            }
            light.getSpecularColor().get(this.temp4f);
            this.gl.glLightfv(16384 + n, 4610, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightfv"));
            }
            light.getPosition().get(this.temp4f);
            this.gl.glLightfv(16384 + n, 4611, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightfv"));
            }
            light.getSpotDirection().get(this.temp4f);
            this.gl.glLightfv(16384 + n, 4612, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightfv"));
            }
            this.gl.glLightf(16384 + n, 4613, light.getSpotExponent());
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightf"));
            }
            this.gl.glLightf(16384 + n, 4614, light.getSpotCutoffAngle());
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightf"));
            }
            this.gl.glLightf(16384 + n, 4615, light.getConstantAttenuation());
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightf"));
            }
            this.gl.glLightf(16384 + n, 4616, light.getLinearAttenuation());
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightf"));
            }
            this.gl.glLightf(16384 + n, 4617, light.getQuadraticAttenuation());
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLightf"));
            }
        }
    }

    @Override
    protected void lightEnabledChanged(int n, boolean bl) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            if (bl) {
                this.gl.glEnable(16384 + n);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
            } else {
                this.gl.glDisable(16384 + n);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
            }
        }
    }

    @Override
    public int getMaxClipPlanes() {
        return this.clipPlanesMax;
    }

    @Override
    protected void clipPlaneChanged(int n, float[] fArray) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            if (!NATIVE_MATRIX_OPS) {
                this.viewTransformationChanged(this.state.vertexState.viewTransform.peek());
                this.projectionTransformationChanged(this.state.projectionState.projectionTransform.peek());
            }
            this.gl.glClipPlane(12288 + n, new double[]{fArray[0], fArray[1], fArray[2], fArray[3]}, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glClipPlane"));
            }
        }
    }

    @Override
    protected void clipPlaneEnabledChanged(int n, boolean bl) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            if (bl) {
                this.gl.glEnable(12288 + n);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
            } else {
                this.gl.glDisable(12288 + n);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
            }
        }
    }

    private void selectMatrixMode(int n) {
        if (this.selectedMatrixMode != n) {
            int n2;
            switch (n) {
                case 0: {
                    n2 = 5888;
                    break;
                }
                case 1: {
                    n2 = 5889;
                    break;
                }
                case 2: 
                case 3: 
                case 4: 
                case 5: {
                    n2 = 5890;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid matrix mode");
                }
            }
            this.gl.glMatrixMode(n2);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glMatrixMode"));
            }
            this.selectedMatrixMode = n;
        }
    }

    private void setGLMatrix(Matrix4f matrix4f) {
        matrix4f.get(this.tempMatrix4f);
        this.gl.glLoadMatrixf(this.tempMatrix4f, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glLoadMatrixf"));
        }
    }

    protected void getMatrix(int n, float[] fArray) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 2982;
                break;
            }
            case 1: {
                n2 = 2983;
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                this.selectTextureUnit(n - 2);
                n2 = 2984;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid matrix mode");
            }
        }
        this.gl.glGetFloatv(n2, fArray, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glGetFloatv"));
        }
    }

    @Override
    public Graphics3D getMatrix(int n, Matrix4f matrix4f) {
        if (!NATIVE_MATRIX_OPS) {
            return super.getMatrix(n, matrix4f);
        }
        if (n >= 2 && n <= 5) {
            this.selectTextureUnit(n - 2);
        }
        this.getMatrix(n, this.tempMatrix4f);
        matrix4f.set(this.tempMatrix4f);
        return this;
    }

    @Override
    public Graphics3D setMatrix(int n, Matrix4f matrix4f) {
        if (!NATIVE_MATRIX_OPS) {
            return super.setMatrix(n, matrix4f);
        }
        switch (n) {
            case 0: {
                this.viewTransformationChanged(matrix4f);
                break;
            }
            case 1: {
                this.projectionTransformationChanged(matrix4f);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                this.textureTransformationChanged(n - 2, matrix4f);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid matrix mode");
            }
        }
        return this;
    }

    @Override
    public Graphics3D resetMatrix(int n) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            return super.resetMatrix(n);
        }
        if (n >= 2 && n <= 5) {
            this.selectTextureUnit(n - 2);
        }
        this.selectMatrixMode(n);
        this.gl.glLoadIdentity();
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glLoadIdentity"));
        }
        return this;
    }

    @Override
    public Graphics3D multiplyMatrix(int n, Matrix4f matrix4f) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            return super.multiplyMatrix(n, matrix4f);
        }
        if (n >= 2 && n <= 5) {
            this.selectTextureUnit(n - 2);
        }
        this.selectMatrixMode(n);
        matrix4f.get(this.tempMatrix4f);
        this.gl.glMultMatrixf(this.tempMatrix4f, 0);
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glMultMatrixf"));
        }
        return this;
    }

    @Override
    public Graphics3D multiplyMatrix(int n, Transform transform) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            return super.multiplyMatrix(n, transform);
        }
        return this.multiplyMatrix(n, transform.getAsMatrix());
    }

    @Override
    public Graphics3D translateMatrix(int n, float f2, float f3, float f4) {
        if (f2 != 0.0f || f3 != 0.0f || f4 != 0.0f) {
            if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
                return super.translateMatrix(n, f2, f3, f4);
            }
            if (n >= 2 && n <= 5) {
                this.selectTextureUnit(n - 2);
            }
            this.selectMatrixMode(n);
            this.gl.glTranslatef(f2, f3, f4);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glTranslatef"));
            }
        }
        return this;
    }

    @Override
    public Graphics3D rotateMatrix(int n, float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
                return super.rotateMatrix(n, f2, f3, f4, f5);
            }
            if (n >= 2 && n <= 5) {
                this.selectTextureUnit(n - 2);
            }
            this.selectMatrixMode(n);
            this.gl.glRotatef(f2, f3, f4, f5);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glRotatef"));
            }
        }
        return this;
    }

    @Override
    public Graphics3D scaleMatrix(int n, float f2, float f3, float f4) {
        if (f2 != 1.0f || f3 != 1.0f || f4 != 1.0f) {
            if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
                return super.scaleMatrix(n, f2, f3, f4);
            }
            if (n >= 2 && n <= 5) {
                this.selectTextureUnit(n - 2);
            }
            this.selectMatrixMode(n);
            this.gl.glScalef(f2, f3, f4);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glScalef"));
            }
        }
        return this;
    }

    @Override
    public Graphics3D pushMatrix(int n) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            return super.pushMatrix(n);
        }
        if (n >= 2 && n <= 5) {
            this.selectTextureUnit(n - 2);
        }
        this.selectMatrixMode(n);
        if (MONITOR_NATIVE_MATRIX_STACKS) {
            int n2;
            int n3;
            int[] nArray = new int[]{0};
            switch (n) {
                case 0: {
                    n3 = 2979;
                    n2 = this.modelViewMatrixStackDepthMax;
                    break;
                }
                case 1: {
                    n3 = 2980;
                    n2 = this.projectionMatrixStackDepthMax;
                    break;
                }
                case 2: 
                case 3: 
                case 4: 
                case 5: {
                    n3 = 2981;
                    n2 = this.textureMatrixStackDepthMax;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid matrix mode");
                }
            }
            this.gl.glGetIntegerv(n3, nArray, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glGetIntegerv"));
            }
            if (nArray[0] == n2) {
                LogMessage logMessage = this.getLogger().error(256);
                logMessage.append("Native matrix stack #").append(n3);
                logMessage.append(" overflow: ").append(nArray[0]).append("/").append(n2);
                logMessage.log();
            }
        }
        this.gl.glPushMatrix();
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glPushMatrix"));
        }
        return this;
    }

    @Override
    public Graphics3D popMatrix(int n) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            return super.popMatrix(n);
        }
        if (n >= 2 && n <= 5) {
            this.selectTextureUnit(n - 2);
        }
        this.selectMatrixMode(n);
        this.gl.glPopMatrix();
        if (!$assertionsDisabled && !this.checkGLError()) {
            throw new AssertionError((Object)this.printGLError("glPopMatrix"));
        }
        return this;
    }

    @Override
    public TextureManager getTextureManager() {
        if (this.textureManager == null) {
            this.textureManager = new GLTextureManager(this);
        }
        return this.textureManager;
    }

    public void selectTextureUnit(int n) {
        if (this.selectedTextureUnit != n) {
            this.gl.glActiveTexture(-1065091072 + n);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glActiveTexture"));
            }
            this.selectedTextureUnit = n;
        }
    }

    @Override
    protected void textureChanged(int n, Texture texture) {
        if (texture != null) {
            this.textureChanged[n] = true;
        } else {
            GLTexture gLTexture = (GLTexture)this.state.texturingState.textureUnitStates[n].texture;
            if (gLTexture != null) {
                gLTexture.unbind(n);
            }
        }
    }

    @Override
    protected void textureTransformationChanged(int n, Matrix4f matrix4f) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectTextureUnit(n);
            this.selectMatrixMode(2 + n);
            this.setGLMatrix(matrix4f);
        }
    }

    @Override
    protected void textureWrappingChanged(int n, int n2, int n3) {
    }

    @Override
    protected void textureFilteringChanged(int n, int n2, int n3, int n4) {
    }

    @Override
    protected void textureBlendingChanged(int n, int n2) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            int n3;
            switch (n2) {
                case 0: {
                    n3 = 8448;
                    break;
                }
                case 1: {
                    n3 = 7681;
                    break;
                }
                case 2: {
                    n3 = 8449;
                    break;
                }
                case 3: {
                    n3 = 3042;
                    break;
                }
                case 4: {
                    n3 = 260;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid texture blending mode");
                }
            }
            this.selectTextureUnit(n);
            this.gl.glTexEnvf(8960, 8704, n3);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glTexEnvf"));
            }
        }
    }

    @Override
    protected void textureBlendColorChanged(int n, Color4f color4f) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectTextureUnit(n);
            this.temp4f[0] = color4f.getRed();
            this.temp4f[1] = color4f.getGreen();
            this.temp4f[2] = color4f.getBlue();
            this.temp4f[3] = color4f.getAlpha();
            this.gl.glTexEnvfv(8960, 8705, this.temp4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glTexEnvf"));
            }
        }
    }

    private static int mapGLTextureAddressGenerationMode(int n) {
        switch (n) {
            case 0: {
                return 310706176;
            }
            case 1: {
                return 293928960;
            }
        }
        throw new IllegalArgumentException("Invalid texture address generation mode");
    }

    @Override
    protected void textureAddressGenerationModeChanged(int n, int n2) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectTextureUnit(n);
            int n3 = GLGraphics3D.mapGLTextureAddressGenerationMode(n2);
            this.gl.glTexGeni(8192, 9472, n3);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glTexGeni"));
            }
            this.gl.glTexGeni(8193, 9472, n3);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glTexGeni"));
            }
            this.gl.glTexGeni(8194, 9472, n3);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glTexGeni"));
            }
        }
    }

    @Override
    protected void textureAddressGenerationEnabledChanged(int n, boolean bl) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectTextureUnit(n);
            if (bl) {
                this.gl.glEnable(3168);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
                this.gl.glEnable(3169);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
                this.gl.glEnable(3170);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glEnable"));
                }
            } else {
                this.gl.glDisable(3168);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
                this.gl.glDisable(3169);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
                this.gl.glDisable(3170);
                if (!$assertionsDisabled && !this.checkGLError()) {
                    throw new AssertionError((Object)this.printGLError("glDisable"));
                }
            }
        }
    }

    @Override
    public boolean areShadersSupported() {
        return !FIXED_FUNCTION_PIPELINE || GLES20_SUBSET;
    }

    @Override
    public ShaderManager getShaderManager() {
        if (this.areShadersSupported()) {
            if (this.shaderManager == null) {
                this.shaderManager = new GLShaderManager(this);
            }
            return this.shaderManager;
        }
        throw new UnsupportedOperationException("Shaders not supported in FFP mode");
    }

    @Override
    protected void shaderProgramChanged(ShaderProgram shaderProgram) {
        if (shaderProgram != null) {
            this.shaderProgramChanged = true;
        } else {
            GLShaderProgram gLShaderProgram = (GLShaderProgram)this.state.shaderState.shaderProgram;
            if (gLShaderProgram != null) {
                gLShaderProgram.unbind();
            }
        }
    }

    @Override
    public MeshManager getMeshManager() {
        if (this.meshManager == null) {
            this.meshManager = new GLMeshManager(this);
        }
        return this.meshManager;
    }

    @Override
    protected void meshChanged(Mesh mesh) {
        if (mesh != null && this.state.shaderState.shaderProgram != null) {
            this.meshChanged = true;
        } else {
            GLMesh gLMesh = (GLMesh)this.state.vertexState.currentMesh;
            if (gLMesh != null) {
                gLMesh.unbind();
            }
        }
    }

    @Override
    protected void viewTransformationChanged(Matrix4f matrix4f) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectMatrixMode(0);
            this.setGLMatrix(matrix4f);
        }
    }

    @Override
    protected void projectionTransformationChanged(Matrix4f matrix4f) {
        if (FIXED_FUNCTION_PIPELINE && !GLES20_SUBSET) {
            this.selectMatrixMode(1);
            this.setGLMatrix(matrix4f);
        }
    }

    @Override
    public void setOrthographicProjection(float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            super.setOrthographicProjection(f2, f3, f4, f5, f6, f7);
        } else {
            this.selectMatrixMode(1);
            this.gl.glLoadIdentity();
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLoadIdentity"));
            }
            this.gl.glOrtho(f2, f3, f4, f5, f6, f7);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glOrthof"));
            }
        }
    }

    @Override
    public void setPerspectiveProjection(float f2, float f3, float f4, float f5) {
        if (!FIXED_FUNCTION_PIPELINE || GLES20_SUBSET || !NATIVE_MATRIX_OPS) {
            super.setPerspectiveProjection(f2, f3, f4, f5);
        } else {
            this.selectMatrixMode(1);
            Camera.setPerspectiveProjection(this.tempMatrix, f2, f3, f4, f5);
            this.tempMatrix.get(this.tempMatrix4f);
            this.gl.glLoadMatrixf(this.tempMatrix4f, 0);
            if (!$assertionsDisabled && !this.checkGLError()) {
                throw new AssertionError((Object)this.printGLError("glLoadMatrixf"));
            }
        }
    }

    public boolean isIntegerIndicesSupported() {
        if (GLES20_SUBSET) {
            return this.integerIndicesSupported;
        }
        return true;
    }

    @Override
    public void draw(Primitives primitives) {
        Object object;
        int n;
        int n2 = this.getTextureManager().getMaxTextureUnits();
        if (FIXED_FUNCTION_PIPELINE && !NATIVE_MATRIX_OPS) {
            this.viewTransformationChanged(this.state.vertexState.viewTransform.peek());
            this.projectionTransformationChanged(this.state.projectionState.projectionTransform.peek());
            for (int i2 = 0; i2 < n2; ++i2) {
                this.textureTransformationChanged(i2, this.state.texturingState.textureUnitStates[i2].textureTransform.peek());
            }
        }
        GLMesh gLMesh = (GLMesh)this.state.vertexState.currentMesh;
        for (n = 0; n < n2; ++n) {
            object = this.state.texturingState.textureUnitStates[n];
            GLTexture gLTexture = (GLTexture)((TextureUnitState)object).texture;
            if (gLTexture == null) continue;
            gLTexture.bind(n);
            this.textureChanged[n] = false;
        }
        n = 0;
        if (this.shaderProgramChanged) {
            if (this.state.shaderState.shaderProgram != null) {
                object = (GLShaderProgram)this.state.shaderState.shaderProgram;
                ((GLShaderProgram)object).bind();
                n = 1;
            }
            this.shaderProgramChanged = false;
        }
        if (this.meshChanged || n != 0) {
            if (gLMesh != null && this.state.shaderState.shaderProgram != null) {
                gLMesh.bind(((GLShaderProgram)this.state.shaderState.shaderProgram).getVertexAttributeBinding().getVertexFormat());
            }
            this.meshChanged = false;
        }
        if (gLMesh != null) {
            boolean bl;
            boolean bl2 = bl = primitives.getType() == 0 && this.getShaderManager().getShadingLanguage() == 1;
            if (bl) {
                this.gl.glEnable(1636302848);
                this.gl.glEnable(1116078080);
            }
            gLMesh.draw(primitives);
            if (bl) {
                this.gl.glDisable(1636302848);
                this.gl.glDisable(1116078080);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLGraphics3D == null ? (class$de$vw$mib$graphics$internal$gl$GLGraphics3D = GLGraphics3D.class$("de.vw.mib.graphics.internal.gl.GLGraphics3D")) : class$de$vw$mib$graphics$internal$gl$GLGraphics3D).desiredAssertionStatus();
        MONITOR_NATIVE_MATRIX_STACKS = System.getProperty("de.vw.mib.graphics.gl.monitornativematrixstacks") != null;
        NATIVE_MATRIX_OPS = System.getProperty("de.vw.mib.graphics.gl.nativematrixops") != null;
        FIXED_FUNCTION_PIPELINE = System.getProperty("de.vw.mib.graphics.jsr231.ffp") != null;
        GLES20_SUBSET = System.getProperty("de.vw.mib.graphics.jsr231.disablegles20subset") == null;
    }
}


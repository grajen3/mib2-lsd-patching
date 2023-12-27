/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLShader;
import de.vw.mib.graphics.internal.gl.GLShaderProgram;
import de.vw.mib.graphics.internal.shader.AbstractShaderManager;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderProgram;
import javax.media.opengl.GL;

public final class GLShaderManager
extends AbstractShaderManager {
    private final int shadingLanguage;
    private int varyingVectorsMax;
    private int vertexUniformVectorsMax;
    private int fragmentUniformVectorsMax;
    private int vertexAttribsMax;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLShaderManager;

    public GLShaderManager(GLGraphics3D gLGraphics3D) {
        super(gLGraphics3D, gLGraphics3D.getLogger());
        GL gL = gLGraphics3D.getGL();
        String string = gL.glGetString(7937);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetString"));
        }
        String string2 = gL.glGetString(7938);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetString"));
        }
        if (string2.indexOf("OpenGL ES 2.0") != -1 || string2.indexOf("OpenGL ES 3.") != -1) {
            this.shadingLanguage = 0;
        } else if (string2.indexOf("2.") != -1 || string2.indexOf("3.") != -1 || string2.indexOf("4.") != -1) {
            this.shadingLanguage = 1;
        } else {
            throw new UnsupportedOperationException(new StringBuffer().append("Unknown Shading Language: ").append(string2).toString());
        }
        int[] nArray = new int[]{0};
        gL.glGetIntegerv(1770520576, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
        }
        this.vertexAttribsMax = nArray[0];
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    @Override
    public int getShadingLanguage() {
        return this.shadingLanguage;
    }

    @Override
    public int getShaderProgramMaxVertexUniformVectors() {
        return this.vertexUniformVectorsMax;
    }

    @Override
    public int getShaderProgramMaxFragmentUniformVectors() {
        return this.fragmentUniformVectorsMax;
    }

    @Override
    public int getShaderProgramMaxVaryingVectors() {
        return this.varyingVectorsMax;
    }

    @Override
    public int getShaderProgramMaxVertexAttributes() {
        return this.vertexAttribsMax;
    }

    @Override
    public Shader createShader(int n, int n2) {
        return new GLShader(this, n, n2);
    }

    @Override
    public ShaderProgram createShaderProgram() {
        return new GLShaderProgram(this);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLShaderManager == null ? (class$de$vw$mib$graphics$internal$gl$GLShaderManager = GLShaderManager.class$("de.vw.mib.graphics.internal.gl.GLShaderManager")) : class$de$vw$mib$graphics$internal$gl$GLShaderManager).desiredAssertionStatus();
    }
}


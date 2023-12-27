/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLShader;
import de.vw.mib.graphics.internal.gl.GLShaderManager;
import de.vw.mib.graphics.internal.shader.AbstractShaderProgram;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Matrix2f;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderCreateException;
import de.vw.mib.graphics.shader.ShaderLinkException;
import de.vw.mib.graphics.shader.ShaderVariable;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.List;
import javax.media.opengl.GL;

public final class GLShaderProgram
extends AbstractShaderProgram {
    private static GLShaderProgram bound;
    private final GL gl;
    private final int shaderProgramId;
    private static float[] tempFloatArray;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLShaderProgram;

    public GLShaderProgram(GLShaderManager gLShaderManager) {
        super(gLShaderManager.getGraphics3D(), gLShaderManager.getLogger(), gLShaderManager);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        this.shaderProgramId = this.gl.glCreateProgram();
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glCreateProgram"));
        }
        if (this.shaderProgramId == 0) {
            throw new ShaderCreateException("glCreateProgram() returned 0");
        }
        if (this.getLogger().isTraceEnabled(0x800000)) {
            LogMessage logMessage = this.getLogger().trace(0x800000);
            logMessage.append("Created shader program #").append(this.shaderProgramId).log();
        }
    }

    @Override
    public void dispose() {
        if (this.isBound()) {
            this.unbind();
        }
        this.gl.glDeleteProgram(this.shaderProgramId);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDeleteProgram"));
        }
        if (this.getLogger().isTraceEnabled(0x800000)) {
            LogMessage logMessage = this.getLogger().trace(0x800000);
            logMessage.append("Deleted shader program #").append(this.shaderProgramId).log();
        }
        super.dispose();
    }

    protected GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public int getShaderProgramId() {
        return this.shaderProgramId;
    }

    @Override
    public void attachShader(Shader shader) {
        if (!$assertionsDisabled && !(shader instanceof GLShader)) {
            throw new AssertionError((Object)"Shader must be instance of GLShader");
        }
        GLShader gLShader = (GLShader)shader;
        this.gl.glAttachShader(this.shaderProgramId, gLShader.getShaderId());
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glAttachShader"));
        }
        if (this.getLogger().isTraceEnabled(0x800000)) {
            LogMessage logMessage = this.getLogger().trace(0x800000);
            logMessage.append("Attached shader #").append(gLShader.getShaderId()).append(" to shader program #").append(this.shaderProgramId).log();
        }
        super.attachShader(shader);
    }

    @Override
    public void setVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.setVertexAttributeBinding(vertexAttributeBinding);
        VertexFormat vertexFormat = vertexAttributeBinding.getVertexFormat();
        int n = vertexFormat.getVertexAttributeCount();
        for (int i2 = 0; i2 < n; ++i2) {
            String string = vertexAttributeBinding.getBinding(i2);
            this.gl.glBindAttribLocation(this.shaderProgramId, i2, string);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindAttribLocation"));
            }
        }
    }

    @Override
    public void link() {
        long l;
        boolean bl;
        Logger logger = this.getLogger();
        LogMessage logMessage = logger.isTraceEnabled(0x800000) ? logger.trace(0x800000) : null;
        boolean bl2 = bl = logMessage != null && logger.isTraceEnabled(128);
        if (bl) {
            this.gl.glGetError();
        }
        long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        this.gl.glLinkProgram(this.shaderProgramId);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glLinkProgram"));
        }
        if (bl) {
            this.gl.glGetError();
        }
        long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("Linked shader program #").append(this.shaderProgramId);
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        int[] nArray = new int[]{0};
        this.gl.glGetProgramiv(this.shaderProgramId, -2104819712, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
        }
        if (nArray[0] != 1) {
            int[] nArray2 = new int[]{0};
            this.gl.glGetProgramiv(this.shaderProgramId, -2071265280, nArray2, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
            }
            String string = "No error reported in shader program log";
            if (nArray2[0] > 0) {
                byte[] byArray = new byte[nArray2[0]];
                this.gl.glGetProgramInfoLog(this.shaderProgramId, byArray.length, nArray2, 0, byArray, 0);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramInfoLog"));
                }
                string = new String(byArray);
            }
            throw new ShaderLinkException(string);
        }
        this.getActiveAttributes();
        this.getActiveUniforms();
        if (logger.isTraceEnabled(0x800000)) {
            this.validate();
        }
        List list = this.getShaders();
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            GLShader gLShader = (GLShader)list.get(i2);
            gLShader.setLinked(true);
        }
        this.setLinked(true);
    }

    private void getActiveAttributes() {
        Logger logger = this.getLogger();
        boolean bl = logger.isTraceEnabled(0x800000);
        LogMessage logMessage = null;
        int[] nArray = new int[]{0};
        this.gl.glGetProgramiv(this.shaderProgramId, -1987379200, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
        }
        int n = nArray[0];
        if (bl) {
            logMessage = logger.trace(0x800000);
            logMessage.append("Active vertex attributes for shader program #").append(this.shaderProgramId).append(": ").append(n).log();
        }
        int[] nArray2 = new int[]{0};
        this.gl.glGetProgramiv(this.shaderProgramId, -1970601984, nArray2, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
        }
        int n2 = nArray2[0];
        byte[] byArray = new byte[n2];
        int[] nArray3 = new int[]{0};
        int[] nArray4 = new int[]{0};
        int[] nArray5 = new int[]{0};
        for (int i2 = 0; i2 < n; ++i2) {
            this.gl.glGetActiveAttrib(this.shaderProgramId, i2, n2, nArray3, 0, nArray4, 0, nArray5, 0, byArray, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetActiveAttrib"));
            }
            String string = new String(byArray, 0, nArray3[0]);
            int n3 = GLShaderProgram.mapGLDataType(nArray5[0]);
            int n4 = nArray4[0];
            int n5 = this.gl.glGetAttribLocation(this.shaderProgramId, string);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetAttribLocation"));
            }
            ShaderVariable shaderVariable = this.addVertexAttribute(string, n3, n4, n5);
            if (!bl) continue;
            logMessage = logger.trace(0x800000);
            logMessage.append("Vertex attribute #").append(i2).append(": name '").append(shaderVariable.getName()).append("' type ").append(shaderVariable.getDataTypeName()).append(" count ").append(shaderVariable.getCount()).append(" location ").append(shaderVariable.getLocation()).log();
        }
    }

    private void getActiveUniforms() {
        Logger logger = this.getLogger();
        boolean bl = logger.isTraceEnabled(0x800000);
        LogMessage logMessage = null;
        int[] nArray = new int[]{0};
        this.gl.glGetProgramiv(this.shaderProgramId, -2037710848, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
        }
        int n = nArray[0];
        if (bl) {
            logMessage = logger.trace(0x800000);
            logMessage.append("Active uniforms for shader program #").append(this.shaderProgramId).append(": ").append(n).log();
        }
        int[] nArray2 = new int[]{0};
        this.gl.glGetProgramiv(this.shaderProgramId, -2020933632, nArray2, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
        }
        int n2 = nArray2[0];
        byte[] byArray = new byte[n2];
        int[] nArray3 = new int[]{0};
        int[] nArray4 = new int[]{0};
        int[] nArray5 = new int[]{0};
        for (int i2 = 0; i2 < n; ++i2) {
            this.gl.glGetActiveUniform(this.shaderProgramId, i2, n2, nArray3, 0, nArray4, 0, nArray5, 0, byArray, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetActiveUniform"));
            }
            String string = new String(byArray, 0, nArray3[0]);
            int n3 = GLShaderProgram.mapGLDataType(nArray5[0]);
            int n4 = nArray4[0];
            int n5 = this.gl.glGetUniformLocation(this.shaderProgramId, string);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetUniformLocation"));
            }
            ShaderVariable shaderVariable = this.addUniform(string, n3, n4, n5);
            if (!bl) continue;
            logMessage = logger.trace(0x800000);
            logMessage.append("Uniform #").append(i2).append(": name '").append(shaderVariable.getName()).append("' type ").append(shaderVariable.getDataTypeName()).append(" count ").append(shaderVariable.getCount()).append(" location ").append(shaderVariable.getLocation()).log();
        }
    }

    private void validate() {
        Logger logger = this.getLogger();
        this.gl.glValidateProgram(this.shaderProgramId);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glValidateProgram"));
        }
        int[] nArray = new int[]{0};
        this.gl.glGetProgramiv(this.shaderProgramId, -2088042496, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
        }
        if (nArray[0] != 1) {
            Object object;
            int[] nArray2 = new int[]{0};
            this.gl.glGetProgramiv(this.shaderProgramId, -2071265280, nArray2, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramiv"));
            }
            String string = "No error reported in shader program log";
            if (nArray2[0] > 0) {
                object = new byte[nArray2[0]];
                this.gl.glGetProgramInfoLog(this.shaderProgramId, ((Object)object).length, nArray2, 0, (byte[])object, 0);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetProgramInfoLog"));
                }
                string = new String((byte[])object);
            }
            object = logger.warn(0x800000);
            object.append("Validation failed for Shader program #").append(this.shaderProgramId).append(": ").append(string).log();
        } else if (logger.isTraceEnabled(0x800000)) {
            LogMessage logMessage = logger.trace(0x800000);
            logMessage.append("Shader program #").append(this.shaderProgramId).append(" validation successful").log();
        }
    }

    public boolean isBound() {
        return bound == this;
    }

    @Override
    public void bind() {
        if (!this.isBound()) {
            Logger logger = this.getLogger();
            this.gl.glUseProgram(this.shaderProgramId);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUseProgram"));
            }
            if (logger.isTraceEnabled(0x800000) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(0x800000);
                logMessage.append("Bound shader program #").append(this.shaderProgramId).log();
            }
            bound = this;
            super.bind();
        }
    }

    public void unbind() {
        if (this.isBound()) {
            Logger logger = this.getLogger();
            this.gl.glUseProgram(0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUseProgram"));
            }
            if (logger.isTraceEnabled(0x800000) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(0x800000);
                logMessage.append("Unbound shader program #").append(this.shaderProgramId).log();
            }
            bound = null;
        }
    }

    @Override
    public void setVertexAttribute(int n, float f2) {
        this.bind();
        this.gl.glVertexAttrib1f(n, f2);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glVertexAttrib1f"));
        }
    }

    @Override
    public void setVertexAttribute(int n, float f2, float f3) {
        this.bind();
        this.gl.glVertexAttrib2f(n, f2, f3);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glVertexAttrib2f"));
        }
    }

    @Override
    public void setVertexAttribute(int n, float f2, float f3, float f4) {
        this.bind();
        this.gl.glVertexAttrib3f(n, f2, f3, f4);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glVertexAttrib3f"));
        }
    }

    @Override
    public void setVertexAttribute(int n, float f2, float f3, float f4, float f5) {
        this.bind();
        this.gl.glVertexAttrib4f(n, f2, f3, f4, f5);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glVertexAttrib4f"));
        }
    }

    @Override
    public void setUniform(int n, int n2) {
        this.bind();
        this.gl.glUniform1i(n, n2);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform1i"));
        }
    }

    @Override
    public void setUniform(int n, int n2, int n3) {
        this.bind();
        this.gl.glUniform2i(n, n2, n3);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform2i"));
        }
    }

    @Override
    public void setUniform(int n, int n2, int n3, int n4) {
        this.bind();
        this.gl.glUniform3i(n, n2, n3, n4);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform3i"));
        }
    }

    @Override
    public void setUniform(int n, int n2, int n3, int n4, int n5) {
        this.bind();
        this.gl.glUniform4i(n, n2, n3, n4, n5);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform4i"));
        }
    }

    @Override
    public void setUniform(int n, int[] nArray) {
        this.bind();
        this.gl.glUniform1iv(n, nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform1fv"));
        }
    }

    @Override
    public void setUniform(int n, float f2) {
        this.bind();
        this.gl.glUniform1f(n, f2);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform1f"));
        }
    }

    @Override
    public void setUniform(int n, float[] fArray) {
        this.bind();
        this.gl.glUniform1fv(n, fArray.length, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform1fv"));
        }
    }

    @Override
    public void setUniform(int n, float f2, float f3) {
        this.bind();
        this.gl.glUniform2f(n, f2, f3);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform2f"));
        }
    }

    @Override
    public void setUniform(int n, Tuple2f[] tuple2fArray) {
        int n2 = tuple2fArray.length;
        float[] fArray = GLShaderProgram.getTempFloatArray(n2 * 2);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            tuple2fArray[n3].get(fArray, n4);
            ++n3;
            n4 += 2;
        }
        this.bind();
        this.gl.glUniform2fv(n, n2, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform2fv"));
        }
    }

    @Override
    public void setUniform(int n, float f2, float f3, float f4) {
        this.bind();
        this.gl.glUniform3f(n, f2, f3, f4);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform3f"));
        }
    }

    @Override
    public void setUniform(int n, Tuple3f[] tuple3fArray) {
        int n2 = tuple3fArray.length;
        float[] fArray = GLShaderProgram.getTempFloatArray(n2 * 3);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            tuple3fArray[n3].get(fArray, n4);
            ++n3;
            n4 += 3;
        }
        this.bind();
        this.gl.glUniform3fv(n, n2, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform3fv"));
        }
    }

    @Override
    public void setUniform(int n, float f2, float f3, float f4, float f5) {
        this.bind();
        this.gl.glUniform4f(n, f2, f3, f4, f5);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform4f"));
        }
    }

    @Override
    public void setUniform(int n, Tuple4f[] tuple4fArray) {
        int n2 = tuple4fArray.length;
        float[] fArray = GLShaderProgram.getTempFloatArray(n2 * 4);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            tuple4fArray[n3].get(fArray, n4);
            ++n3;
            n4 += 4;
        }
        this.bind();
        this.gl.glUniform4fv(n, n2, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniform4fv"));
        }
    }

    @Override
    public void setUniform(int n, Matrix2f matrix2f) {
        float[] fArray = GLShaderProgram.getTempFloatArray(4);
        matrix2f.get(fArray);
        this.bind();
        this.gl.glUniformMatrix2fv(n, 1, false, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniformMatrix2fv"));
        }
    }

    @Override
    public void setUniform(int n, Matrix2f[] matrix2fArray) {
        int n2 = matrix2fArray.length;
        float[] fArray = GLShaderProgram.getTempFloatArray(n2 * 4);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            matrix2fArray[n3].get(fArray, n4);
            ++n3;
            n4 += 4;
        }
        this.bind();
        this.gl.glUniformMatrix2fv(n, n2, false, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniformMatrix2fv"));
        }
    }

    @Override
    public void setUniform(int n, Matrix3f matrix3f) {
        float[] fArray = GLShaderProgram.getTempFloatArray(9);
        matrix3f.get(fArray);
        this.bind();
        this.gl.glUniformMatrix3fv(n, 1, false, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniformMatrix3fv"));
        }
    }

    @Override
    public void setUniform(int n, Matrix3f[] matrix3fArray) {
        int n2 = matrix3fArray.length;
        float[] fArray = GLShaderProgram.getTempFloatArray(n2 * 9);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            matrix3fArray[n3].get(fArray, n4);
            ++n3;
            n4 += 9;
        }
        this.bind();
        this.gl.glUniformMatrix3fv(n, n2, false, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniformMatrix3fv"));
        }
    }

    @Override
    public void setUniform(int n, Matrix4f matrix4f) {
        float[] fArray = GLShaderProgram.getTempFloatArray(16);
        matrix4f.get(fArray);
        this.bind();
        this.gl.glUniformMatrix4fv(n, 1, false, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniformMatrix4fv"));
        }
    }

    @Override
    public void setUniform(int n, Matrix4f[] matrix4fArray) {
        int n2 = matrix4fArray.length;
        float[] fArray = GLShaderProgram.getTempFloatArray(n2 * 16);
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            matrix4fArray[n3].get(fArray, n4);
            ++n3;
            n4 += 16;
        }
        this.bind();
        this.gl.glUniformMatrix4fv(n, n2, false, fArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glUniformMatrix4fv"));
        }
    }

    private static int mapGLDataType(int n) {
        switch (n) {
            case 5126: {
                return 0;
            }
            case 35664: {
                return 1;
            }
            case 35665: {
                return 2;
            }
            case 35666: {
                return 3;
            }
            case 35674: {
                return 4;
            }
            case 35675: {
                return 5;
            }
            case 35676: {
                return 6;
            }
            case 5124: {
                return 7;
            }
            case 35667: {
                return 8;
            }
            case 35668: {
                return 9;
            }
            case 35669: {
                return 10;
            }
            case 35670: {
                return 11;
            }
            case 35671: {
                return 12;
            }
            case 35672: {
                return 13;
            }
            case 35673: {
                return 14;
            }
            case 35678: {
                return 15;
            }
            case 35680: {
                return 16;
            }
        }
        throw new IllegalArgumentException("Invalid data type");
    }

    private static float[] getTempFloatArray(int n) {
        if (tempFloatArray == null || tempFloatArray.length < n) {
            tempFloatArray = new float[n];
        }
        return tempFloatArray;
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLShaderProgram == null ? (class$de$vw$mib$graphics$internal$gl$GLShaderProgram = GLShaderProgram.class$("de.vw.mib.graphics.internal.gl.GLShaderProgram")) : class$de$vw$mib$graphics$internal$gl$GLShaderProgram).desiredAssertionStatus();
        tempFloatArray = null;
    }
}


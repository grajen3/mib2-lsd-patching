/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLShaderManager;
import de.vw.mib.graphics.internal.shader.AbstractShader;
import de.vw.mib.graphics.shader.FragmentShader;
import de.vw.mib.graphics.shader.ShaderCompileException;
import de.vw.mib.graphics.shader.ShaderCreateException;
import de.vw.mib.graphics.shader.VertexShader;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.List;
import javax.media.opengl.GL;

public final class GLShader
extends AbstractShader
implements FragmentShader,
VertexShader {
    private final GL gl;
    private final int shaderId;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLShader;

    public GLShader(GLShaderManager gLShaderManager, int n, int n2) {
        super(gLShaderManager.getGraphics3D(), gLShaderManager.getLogger(), gLShaderManager, n, n2);
        int n3;
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        switch (n) {
            case 0: {
                n3 = 831193088;
                break;
            }
            case 1: {
                n3 = 814415872;
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                throw new UnsupportedOperationException("Unsupported shader type");
            }
            default: {
                throw new IllegalArgumentException("Invalid  shader type");
            }
        }
        this.shaderId = this.gl.glCreateShader(n3);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glCreateShader"));
        }
        if (this.shaderId == 0) {
            throw new ShaderCreateException("glCreateShader() returned 0");
        }
        if (this.getLogger().isTraceEnabled(0x800000)) {
            LogMessage logMessage = this.getLogger().trace(0x800000);
            logMessage.append("Created shader #").append(this.shaderId).append(" type 0x").append(Integer.toHexString(n3)).log();
        }
    }

    @Override
    public void dispose() {
        this.gl.glDeleteShader(this.shaderId);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDeleteShader"));
        }
        if (this.getLogger().isTraceEnabled(0x800000)) {
            LogMessage logMessage = this.getLogger().trace(0x800000);
            logMessage.append("Deleted shader #").append(this.shaderId).log();
        }
        super.dispose();
    }

    protected GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public int getShaderId() {
        return this.shaderId;
    }

    @Override
    public void compile() {
        long l;
        Logger logger = this.getLogger();
        LogMessage logMessage = logger.isTraceEnabled(0x800000) ? logger.trace(0x800000) : null;
        boolean bl = logMessage != null && logger.isTraceEnabled(128);
        List list = this.getSource();
        Object[] objectArray = new String[list.size()];
        list.toArray(objectArray);
        this.gl.glShaderSource(this.shaderId, objectArray.length, (String[])objectArray, null, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glShaderSource"));
        }
        if (bl) {
            this.gl.glGetError();
        }
        long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        this.gl.glCompileShader(this.shaderId);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glCompileShader"));
        }
        if (bl) {
            this.gl.glGetError();
        }
        long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("Compiled shader #").append(this.shaderId);
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        int[] nArray = new int[]{0};
        this.gl.glGetShaderiv(this.shaderId, -2121596928, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetShaderiv"));
        }
        if (nArray[0] != 1) {
            int[] nArray2 = new int[]{0};
            this.gl.glGetShaderiv(this.shaderId, -2071265280, nArray2, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetShaderiv"));
            }
            String string = "No error reported in shader log";
            if (nArray2[0] > 0) {
                byte[] byArray = new byte[nArray2[0]];
                this.gl.glGetShaderInfoLog(this.shaderId, byArray.length, nArray2, 0, byArray, 0);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetShaderInfoLog"));
                }
                string = new String(byArray);
            }
            if (logMessage != null) {
                logger.trace(0x800000, "Erroneous shader source:");
                int n = 1;
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    List list2 = GLShader.splitByWholeSeparatorPreserveAllTokens((String)list.get(i2), "\r\n");
                    for (int i3 = 0; i3 < list2.size(); ++i3) {
                        logMessage = logger.trace(0x800000);
                        logMessage.append(n++).append(": ").append((String)list2.get(i3)).log();
                    }
                }
            }
            throw new ShaderCompileException(string);
        }
        this.setCompiled(true);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLShader == null ? (class$de$vw$mib$graphics$internal$gl$GLShader = GLShader.class$("de.vw.mib.graphics.internal.gl.GLShader")) : class$de$vw$mib$graphics$internal$gl$GLShader).desiredAssertionStatus();
    }
}


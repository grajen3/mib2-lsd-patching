/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLIndexBuffer;
import de.vw.mib.graphics.internal.gl.GLMesh$VertexArray;
import de.vw.mib.graphics.internal.gl.GLMeshManager;
import de.vw.mib.graphics.internal.gl.GLVertexBuffer;
import de.vw.mib.graphics.internal.mesh.AbstractMesh;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping$VertexStream;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.mesh.VertexFormat$VertexAttribute;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.List;
import javax.media.opengl.GL;

public final class GLMesh
extends AbstractMesh {
    private static GLMesh bound;
    private static VertexFormat currentVertexFormat;
    private static int selectedClientTextureUnit;
    private static GLMesh$VertexArray[] vertexArrays;
    private final GL gl;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLMesh;

    public GLMesh(GLMeshManager gLMeshManager, List list, int n, int n2, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, IndexBuffer indexBuffer, BoundingVolume boundingVolume) {
        super(gLMeshManager.getGLGraphics3D(), gLMeshManager.getLogger(), gLMeshManager, list, n, n2, list2, vertexBufferStreamMapping, indexBuffer, boundingVolume);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        if (vertexArrays == null) {
            vertexArrays = new GLMesh$VertexArray[gLGraphics3D.getShaderManager().getShaderProgramMaxVertexAttributes()];
            for (int i2 = 0; i2 < vertexArrays.length; ++i2) {
                GLMesh.vertexArrays[i2] = new GLMesh$VertexArray(i2);
            }
        }
    }

    @Override
    public void dispose() {
        if (this.isBound()) {
            this.unbind();
        }
        super.dispose();
    }

    protected GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public boolean isBound() {
        return bound == this;
    }

    public void bind(VertexFormat vertexFormat) {
        Logger logger = this.getLogger();
        if (!this.isBound() || currentVertexFormat == null || !currentVertexFormat.equals(vertexFormat)) {
            int n = vertexFormat.getVertexAttributeCount();
            if (n <= vertexArrays.length) {
                int n2;
                boolean bl = logger.isTraceEnabled(2048) && logger.isTraceEnabled(64);
                boolean bl2 = !GLGraphics3D.FIXED_FUNCTION_PIPELINE || GLGraphics3D.GLES20_SUBSET;
                VertexBufferStreamMapping vertexBufferStreamMapping = this.getVertexBufferStreamMapping();
                for (n2 = 0; n2 < n; ++n2) {
                    VertexFormat$VertexAttribute vertexFormat$VertexAttribute = vertexFormat.getVertexAttribute(n2);
                    VertexBufferStreamMapping$VertexStream vertexBufferStreamMapping$VertexStream = vertexBufferStreamMapping.getVertexStream(vertexFormat$VertexAttribute.semantic, vertexFormat$VertexAttribute.set);
                    GLMesh$VertexArray gLMesh$VertexArray = vertexArrays[n2];
                    if (vertexBufferStreamMapping$VertexStream != null) {
                        if (gLMesh$VertexArray.vertexStream == null || !gLMesh$VertexArray.vertexStream.equals(vertexBufferStreamMapping$VertexStream)) {
                            GLVertexBuffer gLVertexBuffer = (GLVertexBuffer)vertexBufferStreamMapping$VertexStream.getVertexBuffer();
                            VertexFormat$VertexAttribute vertexFormat$VertexAttribute2 = vertexBufferStreamMapping$VertexStream.getVertexAttribute();
                            int n3 = GLMesh.mapGLVertexElementType(vertexFormat$VertexAttribute2.elementType);
                            int n4 = vertexFormat$VertexAttribute2.elementCount;
                            int n5 = gLVertexBuffer.getVertexFormat().getVertexSize();
                            int n6 = vertexFormat$VertexAttribute2.offset;
                            int n7 = vertexFormat$VertexAttribute2.semantic;
                            int n8 = vertexFormat$VertexAttribute2.set;
                            gLVertexBuffer.bind();
                            if (bl2) {
                                this.gl.glVertexAttribPointer(n2, n4, n3, false, n5, n6);
                                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glVertexAttribPointer"));
                                }
                            } else {
                                this.bindVertexArrayLegacy(n7, n8, n4, n3, n5, n6);
                            }
                            if (bl) {
                                LogMessage logMessage = logger.trace(2048);
                                logMessage.append("Bound vertex buffer #").append(gLVertexBuffer.getBufferId()).append(" to vertex attribute index ").append(n2).append(" elementCount ").append(n4).append(" type 0x").append(Integer.toHexString(n3)).append(" normalized ").append(false).append(" stride ").append(n5).append(" offset ").append(n6).append(" semantic ").append(n7).append(" set ").append(n8);
                            }
                            gLMesh$VertexArray.vertexStream = vertexBufferStreamMapping$VertexStream;
                        }
                        if (gLMesh$VertexArray.enabled) continue;
                        if (bl2) {
                            this.gl.glEnableVertexAttribArray(n2);
                            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glEnableVertexAttribArray"));
                            }
                        } else {
                            this.enableVertexArrayLegacy(gLMesh$VertexArray.vertexStream.vertexAttribute.semantic, gLMesh$VertexArray.vertexStream.vertexAttribute.set);
                        }
                        gLMesh$VertexArray.enabled = true;
                        continue;
                    }
                    if (!gLMesh$VertexArray.enabled) continue;
                    this.unbindBuffer(n2);
                }
                for (n2 = n; n2 < vertexArrays.length && GLMesh.vertexArrays[n2].enabled; ++n2) {
                    this.unbindBuffer(n2);
                }
            } else {
                LogMessage logMessage = logger.error(2048);
                logMessage.append("GLMesh.bind(): Provided vertex attributes (").append(n).append(") exceeds maximum vertex attributes (").append(vertexArrays.length).append(")").log();
            }
            GLIndexBuffer gLIndexBuffer = (GLIndexBuffer)this.getIndexBuffer();
            if (gLIndexBuffer != null) {
                gLIndexBuffer.bind();
            }
            bound = this;
            currentVertexFormat = vertexFormat;
            super.bind();
        }
    }

    public void selectClientTextureUnit(int n) {
        if (selectedClientTextureUnit != n) {
            this.gl.glClientActiveTexture(-1065091072 + n);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glClientActiveTexture"));
            }
            selectedClientTextureUnit = n;
        }
    }

    private void bindVertexArrayLegacy(int n, int n2, int n3, int n4, int n5, int n6) {
        switch (n) {
            case 0: {
                this.gl.glVertexPointer(n3, n4, n5, n6);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glVertexPointer"));
                }
                break;
            }
            case 1: {
                this.gl.glNormalPointer(n4, n5, n6);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glNormalPointer"));
                }
                break;
            }
            case 2: {
                this.gl.glColorPointer(n3, n4, n5, n6);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glColorPointer"));
                }
                break;
            }
            case 3: {
                this.selectClientTextureUnit(n2);
                this.gl.glTexCoordPointer(n3, n4, n5, n6);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexCoordPointer"));
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("No matching legacy call");
            }
        }
    }

    private void enableVertexArrayLegacy(int n, int n2) {
        switch (n) {
            case 0: {
                this.gl.glEnableClientState(1954545664);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glEnableClientState"));
                }
                break;
            }
            case 1: {
                this.gl.glEnableClientState(1971322880);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glEnableClientState"));
                }
                break;
            }
            case 2: {
                this.gl.glEnableClientState(1988100096);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glEnableClientState"));
                }
                break;
            }
            case 3: {
                this.selectClientTextureUnit(n2);
                this.gl.glEnableClientState(0x78800000);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glEnableClientState"));
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("No matching legacy call");
            }
        }
    }

    public void unbind() {
        if (this.isBound()) {
            for (int i2 = 0; i2 < vertexArrays.length; ++i2) {
                this.unbindBuffer(i2);
            }
            bound = null;
            currentVertexFormat = null;
        }
    }

    private void unbindBuffer(int n) {
        GLMesh$VertexArray gLMesh$VertexArray = vertexArrays[n];
        if (gLMesh$VertexArray.enabled) {
            if (!GLGraphics3D.FIXED_FUNCTION_PIPELINE || GLGraphics3D.GLES20_SUBSET) {
                this.gl.glDisableVertexAttribArray(n);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisableVertexAttribArray"));
                }
            } else {
                this.unbindVertexArrayLegacy(gLMesh$VertexArray.vertexStream.vertexAttribute.semantic, gLMesh$VertexArray.vertexStream.vertexAttribute.set);
            }
            gLMesh$VertexArray.enabled = false;
            gLMesh$VertexArray.vertexStream = null;
        }
    }

    private void unbindVertexArrayLegacy(int n, int n2) {
        switch (n) {
            case 0: {
                this.gl.glDisableClientState(1954545664);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisableClientState"));
                }
                break;
            }
            case 1: {
                this.gl.glDisableClientState(1971322880);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisableClientState"));
                }
                break;
            }
            case 2: {
                this.gl.glDisableClientState(1988100096);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisableClientState"));
                }
                break;
            }
            case 3: {
                this.selectClientTextureUnit(n2);
                this.gl.glDisableClientState(0x78800000);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisableClientState"));
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("No matching legacy call");
            }
        }
    }

    @Override
    public void draw(Primitives primitives) {
        long l;
        long l2;
        boolean bl;
        Logger logger = this.getLogger();
        LogMessage logMessage = logger.isTraceEnabled(2048) ? logger.trace(2048) : null;
        boolean bl2 = bl = logMessage != null && logger.isTraceEnabled(128);
        if (bl) {
            this.gl.glGetError();
        }
        int n = GLMesh.mapGLPrimitiveType(primitives.getType());
        if (primitives.isIndexed()) {
            GLIndexBuffer gLIndexBuffer = (GLIndexBuffer)this.getIndexBuffer();
            if (gLIndexBuffer == null) {
                throw new IllegalStateException("No indexbuffer defined");
            }
            int n2 = GLMesh.mapGLIndexElementType(gLIndexBuffer.getIndexFormat());
            l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            this.gl.glDrawElements(n, primitives.getIndexCount(), n2, primitives.getStartIndex() * gLIndexBuffer.getIndexSize());
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDrawElements"));
            }
            if (bl) {
                this.gl.glGetError();
            }
            long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("glDrawElements(").append(primitives.getCount()).append(" indexed primitives type 0x").append(Integer.toHexString(n)).append(" with ").append(primitives.getIndexCount()).append(" sequential indices format 0x").append(Integer.toHexString(n2)).append(" starting at index ").append(primitives.getStartIndex() * gLIndexBuffer.getIndexSize()).append(")");
            }
        } else {
            l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            this.gl.glDrawArrays(n, primitives.getMinVertex(), primitives.getVertexCount());
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDrawArrays"));
            }
            if (bl) {
                this.gl.glGetError();
            }
            long l4 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            if (logMessage != null) {
                logMessage.append("glDrawArrays(").append(primitives.getCount()).append(" nonindexed primitives type 0x").append(Integer.toHexString(n)).append(" with ").append(primitives.getVertexCount()).append(" sequential elements starting at vertex ").append(primitives.getMinVertex()).append(")");
            }
        }
        if (logMessage != null) {
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        super.draw(primitives);
    }

    private static int mapGLPrimitiveType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
        }
        throw new IllegalArgumentException("Invalid primitive type");
    }

    private static int mapGLVertexElementType(int n) {
        switch (n) {
            case 0: {
                return 5121;
            }
            case 1: {
                return 5120;
            }
            case 2: {
                return 5123;
            }
            case 3: {
                return 5126;
            }
        }
        throw new IllegalArgumentException("Invalid vertex element type");
    }

    private static int mapGLIndexElementType(int n) {
        switch (n) {
            case 0: {
                return 5121;
            }
            case 1: {
                return 5123;
            }
            case 2: {
                return 5125;
            }
        }
        throw new IllegalArgumentException("Invalid index element type");
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLMesh == null ? (class$de$vw$mib$graphics$internal$gl$GLMesh = GLMesh.class$("de.vw.mib.graphics.internal.gl.GLMesh")) : class$de$vw$mib$graphics$internal$gl$GLMesh).desiredAssertionStatus();
    }
}


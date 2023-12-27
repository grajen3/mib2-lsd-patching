/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexFormat$VertexAttribute;
import de.vw.mib.util.StringBuilder;

public final class VertexBufferStreamMapping$VertexStream {
    public final int index;
    public final VertexBuffer vertexBuffer;
    public final VertexFormat$VertexAttribute vertexAttribute;

    public VertexBufferStreamMapping$VertexStream(int n, VertexBuffer vertexBuffer, VertexFormat$VertexAttribute vertexFormat$VertexAttribute) {
        this.index = n;
        this.vertexBuffer = vertexBuffer;
        this.vertexAttribute = vertexFormat$VertexAttribute;
    }

    public Object clone() {
        try {
            VertexFormat$VertexAttribute vertexFormat$VertexAttribute = (VertexFormat$VertexAttribute)super.clone();
            return vertexFormat$VertexAttribute;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.index);
        hashCodeBuilder.append(this.vertexBuffer);
        hashCodeBuilder.append(this.vertexAttribute);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            VertexBufferStreamMapping$VertexStream vertexBufferStreamMapping$VertexStream = (VertexBufferStreamMapping$VertexStream)object;
            return this.index == vertexBufferStreamMapping$VertexStream.index && this.vertexBuffer.equals(vertexBufferStreamMapping$VertexStream.vertexBuffer) && this.vertexAttribute.equals(vertexBufferStreamMapping$VertexStream.vertexAttribute);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[index=").append(this.index);
        stringBuilder.append(",vertexBuffer=").append(this.vertexBuffer);
        stringBuilder.append(",vertexAttribute=").append(this.vertexAttribute);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public VertexBuffer getVertexBuffer() {
        return this.vertexBuffer;
    }

    public VertexFormat$VertexAttribute getVertexAttribute() {
        return this.vertexAttribute;
    }
}


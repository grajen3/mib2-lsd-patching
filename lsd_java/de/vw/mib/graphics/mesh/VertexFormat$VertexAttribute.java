/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class VertexFormat$VertexAttribute
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public final int index;
    public final int offset;
    public final int elementType;
    public final int elementCount;
    public final int semantic;
    public final int set;

    public VertexFormat$VertexAttribute(int n, int n2, int n3, int n4, int n5, int n6) {
        this.index = n;
        this.offset = n2;
        this.elementType = n3;
        this.elementCount = n4;
        this.semantic = n5;
        this.set = n6;
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
        hashCodeBuilder.append(this.offset);
        hashCodeBuilder.append(this.elementType);
        hashCodeBuilder.append(this.elementCount);
        hashCodeBuilder.append(this.semantic);
        hashCodeBuilder.append(this.set);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            VertexFormat$VertexAttribute vertexFormat$VertexAttribute = (VertexFormat$VertexAttribute)object;
            return this.offset == vertexFormat$VertexAttribute.offset && this.elementType == vertexFormat$VertexAttribute.elementType && this.elementCount == vertexFormat$VertexAttribute.elementCount && this.semantic == vertexFormat$VertexAttribute.semantic && this.set == vertexFormat$VertexAttribute.set;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[index=").append(this.index);
        stringBuilder.append(",offset=").append(this.offset);
        stringBuilder.append(",elementType=").append(this.elementType);
        stringBuilder.append(",elementCount=").append(this.elementCount);
        stringBuilder.append(",semantic=").append(this.semantic);
        stringBuilder.append(",set=").append(this.set);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


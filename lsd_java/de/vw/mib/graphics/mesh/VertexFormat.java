/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.graphics.mesh.VertexFormat$VertexAttribute;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class VertexFormat
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public static final int VERTEX_ATTRIBUTE_ELEMENT_TYPE_UNSIGNED_BYTE;
    public static final int VERTEX_ATTRIBUTE_ELEMENT_TYPE_BYTE;
    public static final int VERTEX_ATTRIBUTE_ELEMENT_TYPE_SHORT;
    public static final int VERTEX_ATTRIBUTE_ELEMENT_TYPE_FLOAT;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_POSITION;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_NORMAL;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_COLOR;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_TEXTURE_COORDINATE;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_POINT_SIZE;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_TANGENT;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_BINORMAL;
    public static final int VERTEX_ATTRIBUTE_SEMANTIC_COUNT;
    private static final int ATTRIBUTE_LIST_INITIAL_CAPACITY;
    private static final int ATTRIBUTE_INDICES_MAP_INITIAL_CAPACITY;
    private List vertexAttributes = new ArrayList(7);
    private IntIntMap vertexAttributeIndices = new IntIntOptHashMap(7);
    private int vertexSize = 0;

    public Object clone() {
        try {
            VertexFormat vertexFormat = (VertexFormat)super.clone();
            int n = this.vertexAttributes.size();
            vertexFormat.vertexAttributes = new ArrayList(n);
            for (int i2 = 0; i2 < n; ++i2) {
                vertexFormat.vertexAttributes.add(((VertexFormat$VertexAttribute)this.vertexAttributes.get(i2)).clone());
            }
            return vertexFormat;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.vertexAttributes);
        hashCodeBuilder.append(this.vertexSize);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            VertexFormat vertexFormat = (VertexFormat)object;
            return ((Object)this.vertexAttributes).equals(vertexFormat.vertexAttributes) && this.vertexSize == vertexFormat.vertexSize;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[attributes=").append(this.vertexAttributes);
        stringBuilder.append(",size=").append(this.vertexSize);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getVertexSize() {
        return this.vertexSize;
    }

    public int getVertexAttributeCount() {
        return this.vertexAttributes.size();
    }

    public void addVertexAttribute(int n, int n2, int n3, int n4) {
        int n5 = this.vertexAttributes.size();
        int n6 = (n3 & 0xFFFF0000) << 16 | n4 & 0xFFFF0000;
        if (this.vertexAttributeIndices.containsKey(n6)) {
            throw new IllegalStateException("A vertex attribute with the same semantic and set already defined");
        }
        this.vertexAttributeIndices.put(n6, n5);
        int n7 = this.vertexAttributes.size();
        this.vertexAttributes.add(new VertexFormat$VertexAttribute(n7, this.vertexSize, n, n2, n3, n4));
        this.vertexSize += this.getElementTypeSize(n) * n2;
    }

    public void addVertexAttribute(int n, int n2, int n3) {
        this.addVertexAttribute(n, n2, n3, 0);
    }

    public VertexFormat$VertexAttribute getVertexAttribute(int n) {
        return (VertexFormat$VertexAttribute)this.vertexAttributes.get(n);
    }

    public int getVertexAttributeIndex(int n, int n2) {
        int n3 = (n & 0xFFFF0000) << 16 | n2 & 0xFFFF0000;
        if (this.vertexAttributeIndices.containsKey(n3)) {
            return this.vertexAttributeIndices.get(n3);
        }
        return -1;
    }

    public int getVertexAttributeIndex(int n) {
        return this.getVertexAttributeIndex(n, 0);
    }

    public boolean containsVertexAttribute(int n) {
        for (int i2 = this.vertexAttributes.size() - 1; i2 >= 0; --i2) {
            VertexFormat$VertexAttribute vertexFormat$VertexAttribute = (VertexFormat$VertexAttribute)this.vertexAttributes.get(i2);
            if (vertexFormat$VertexAttribute.semantic != n) continue;
            return true;
        }
        return false;
    }

    public int getElementTypeSize(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 4;
            }
        }
        throw new IllegalArgumentException("Invalid element type");
    }
}


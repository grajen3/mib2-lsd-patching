/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public class Primitives
implements Serializable {
    private static final long serialVersionUID;
    public static final int PRIMITIVE_TYPE_POINT;
    public static final int PRIMITIVE_TYPE_LINE;
    public static final int PRIMITIVE_TYPE_LINE_STRIP;
    public static final int PRIMITIVE_TYPE_LINE_LOOP;
    public static final int PRIMITIVE_TYPE_TRIANGLE;
    public static final int PRIMITIVE_TYPE_TRIANGLE_STRIP;
    public static final int PRIMITIVE_TYPE_TRIANGLE_FAN;
    private int type;
    private int minVertex;
    private int maxVertex;
    private int startIndex;
    private int indexCount;

    public Primitives(int n, int n2, int n3) {
        this(n, n2, n3, 0, 0);
    }

    public Primitives(int n, int n2, int n3, int n4, int n5) {
        this.type = n;
        this.minVertex = n2;
        this.maxVertex = n3;
        this.startIndex = n4;
        this.indexCount = n5;
    }

    protected Primitives() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[type=").append(this.type);
        stringBuilder.append(",minVertex=").append(this.minVertex);
        stringBuilder.append(",maxVertex=").append(this.maxVertex);
        stringBuilder.append(",startIndex=").append(this.startIndex);
        stringBuilder.append(",indexCount=").append(this.indexCount);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final int getByteSize() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int n) {
        this.type = n;
    }

    public final int getCount() {
        return Primitives.getPrimitiveCount(this.type, this.isIndexed() ? this.getIndexCount() : this.getVertexCount());
    }

    public final int getMinVertex() {
        return this.minVertex;
    }

    public final void setMinVertex(int n) {
        this.minVertex = n;
    }

    public final int getMaxVertex() {
        return this.maxVertex;
    }

    public final void setMaxVertex(int n) {
        this.maxVertex = n;
    }

    public final int getVertexCount() {
        return this.maxVertex - this.minVertex + 1;
    }

    public final boolean isIndexed() {
        return this.indexCount > 0;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final void setStartIndex(int n) {
        this.startIndex = n;
    }

    public final int getIndexCount() {
        return this.indexCount;
    }

    public final void setIndexCount(int n) {
        this.indexCount = n;
    }

    private static int getPrimitiveCount(int n, int n2) {
        switch (n) {
            case 0: {
                return n2;
            }
            case 1: {
                return n2 / 2;
            }
            case 2: {
                return n2 - 1;
            }
            case 3: {
                return n2;
            }
            case 4: {
                return n2 / 3;
            }
            case 5: 
            case 6: {
                return n2 - 2;
            }
        }
        throw new IllegalArgumentException("Invalid primitive type");
    }
}


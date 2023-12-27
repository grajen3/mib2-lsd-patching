/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping$VertexStream;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.mesh.VertexFormat$VertexAttribute;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public final class VertexBufferStreamMapping {
    private static final int VERTEXSTREAM_LIST_INITIAL_CAPACITY;
    private static final int VERTEX_ATTRIBUTES_MAP_INITIAL_CAPACITY;
    private final List vertexStreams = new ArrayList(10);
    private IntObjectMap vertexAttributesMap = new IntObjectOptHashMap(10);

    public VertexBufferStreamMapping() {
    }

    public VertexBufferStreamMapping(VertexBuffer vertexBuffer) {
        this();
        this.addVertexStreams(vertexBuffer);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[vertexStreams=").append(this.vertexStreams);
        stringBuilder.append(",vertexAttributesMap=").append(this.vertexAttributesMap);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getVertexStreamCount() {
        return this.vertexStreams.size();
    }

    public void addVertexStream(VertexBuffer vertexBuffer, int n) {
        int n2 = this.vertexStreams.size();
        VertexFormat vertexFormat = vertexBuffer.getVertexFormat();
        VertexFormat$VertexAttribute vertexFormat$VertexAttribute = vertexFormat.getVertexAttribute(n);
        int n3 = (vertexFormat$VertexAttribute.semantic & 0xFFFF0000) << 16 | vertexFormat$VertexAttribute.set & 0xFFFF0000;
        if (this.vertexAttributesMap.containsKey(n3)) {
            throw new IllegalStateException("A vertex attribute with the same semantic and set already defined");
        }
        VertexBufferStreamMapping$VertexStream vertexBufferStreamMapping$VertexStream = new VertexBufferStreamMapping$VertexStream(n2, vertexBuffer, vertexFormat$VertexAttribute);
        this.vertexAttributesMap.put(n3, vertexBufferStreamMapping$VertexStream);
        this.vertexStreams.add(vertexBufferStreamMapping$VertexStream);
    }

    public void addVertexStreams(VertexBuffer vertexBuffer) {
        VertexFormat vertexFormat = vertexBuffer.getVertexFormat();
        int n = vertexFormat.getVertexAttributeCount();
        for (int i2 = 0; i2 < n; ++i2) {
            this.addVertexStream(vertexBuffer, i2);
        }
    }

    public void removeVertexStream(int n) {
        this.vertexStreams.remove(n);
    }

    public VertexBufferStreamMapping$VertexStream getVertexStream(int n) {
        return (VertexBufferStreamMapping$VertexStream)this.vertexStreams.get(n);
    }

    public VertexBufferStreamMapping$VertexStream getVertexStream(int n, int n2) {
        int n3 = (n & 0xFFFF0000) << 16 | n2 & 0xFFFF0000;
        return (VertexBufferStreamMapping$VertexStream)this.vertexAttributesMap.get(n3);
    }
}


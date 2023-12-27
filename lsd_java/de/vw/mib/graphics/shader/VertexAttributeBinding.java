/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.util.StringBuilder;

public final class VertexAttributeBinding {
    private static final int VERTEX_ATTRIBUTE_BINDING_MAP_INITIAL_CAPACITY;
    private final VertexFormat vertexFormat;
    private final IntObjectMap vertexAttributeBindings;

    public VertexAttributeBinding(VertexFormat vertexFormat) {
        this.vertexFormat = vertexFormat;
        this.vertexAttributeBindings = new IntObjectOptHashMap(10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[vertexFormat=").append(this.vertexFormat);
        stringBuilder.append(",vertexAttributeBindings=").append(this.vertexAttributeBindings);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public VertexFormat getVertexFormat() {
        return this.vertexFormat;
    }

    public int getVertexAttributeBindingCount() {
        return this.vertexAttributeBindings.size();
    }

    public void addBinding(int n, int n2, String string) {
        int n3 = this.vertexFormat.getVertexAttributeIndex(n, n2);
        this.vertexAttributeBindings.put(n3, string);
    }

    public void addBinding(int n, String string) {
        this.addBinding(n, 0, string);
    }

    public String getBinding(int n) {
        return (String)this.vertexAttributeBindings.get(n);
    }

    public void removeBinding(int n) {
        this.vertexAttributeBindings.remove(n);
    }
}


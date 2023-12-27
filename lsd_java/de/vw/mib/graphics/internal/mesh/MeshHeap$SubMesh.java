/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.Disposable;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;

public final class MeshHeap$SubMesh
extends Primitives
implements Cacheable,
Disposable,
PooledObject {
    private static final long serialVersionUID;
    private final ObjectPool pool;
    private Mesh mesh;
    private long id;

    public MeshHeap$SubMesh(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",id=0x").append(Long.toHexString(this.id));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.mesh = null;
    }

    @Override
    public void dispose() {
        this.pool.releaseObject(this);
    }

    public Mesh getMesh() {
        return this.mesh;
    }

    protected void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    public long getId() {
        return this.id;
    }

    protected void setId(long l) {
        this.id = l;
    }

    public void setVertexData(ByteBuffer byteBuffer, int n) {
        VertexBuffer vertexBuffer = this.getMesh().getVertexBuffer(0);
        vertexBuffer.setContent(this.getMinVertex() * vertexBuffer.getVertexSize(), n, byteBuffer);
    }

    public void setVertexData(ByteBuffer byteBuffer) {
        this.setVertexData(byteBuffer, byteBuffer.remaining());
    }

    public void setIndexData(ByteBuffer byteBuffer, int n) {
        IndexBuffer indexBuffer = this.getMesh().getIndexBuffer();
        indexBuffer.setContent(this.getStartIndex() * indexBuffer.getIndexSize(), n, byteBuffer);
    }

    public void setIndexData(ByteBuffer byteBuffer) {
        this.setIndexData(byteBuffer, byteBuffer.remaining());
    }
}


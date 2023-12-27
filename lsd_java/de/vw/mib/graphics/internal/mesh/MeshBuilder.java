/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.Disposable;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.mesh.AbstractGeometryBuffer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder$VertexAttributeIndex;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.mesh.VertexFormat$VertexAttribute;
import de.vw.mib.graphics.texture.TextureCoordinate2f;
import de.vw.mib.graphics.util.NIO;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;
import java.util.List;

public final class MeshBuilder
implements Disposable {
    public static final int FLOAT_SIZE_BYTES;
    public static final int INT_SIZE_BYTES;
    public static final int COLOR4B_SIZE_BYTES;
    private final List vertexFormats;
    private final int maxVertices;
    private final int vertexArrayCount;
    private ByteBuffer[] vertexArrays;
    private IntObjectMap vertexAttributeMap;
    private int minVertex;
    private int maxVertex;
    private final int indexFormat;
    private final int maxIndices;
    private int minIndex;
    private int maxIndex;
    private ByteBuffer indexArray;
    private int primitiveType;
    private int primitiveCount;

    public MeshBuilder(List list, int n) {
        this(list, n, 0, 0);
    }

    public MeshBuilder(List list, int n, int n2, int n3) {
        int n4;
        this.vertexFormats = list;
        this.maxVertices = n;
        this.indexFormat = n2;
        this.maxIndices = n3;
        if (n > 0) {
            this.vertexArrayCount = list.size();
            this.vertexArrays = new ByteBuffer[this.vertexArrayCount];
            n4 = 0;
            for (int i2 = 0; i2 < this.vertexArrayCount; ++i2) {
                VertexFormat vertexFormat = (VertexFormat)list.get(i2);
                int n5 = vertexFormat.getVertexSize() * n;
                this.vertexArrays[i2] = NIO.createJavaByteBuffer(n5);
                n4 += vertexFormat.getVertexAttributeCount();
            }
            this.vertexAttributeMap = new IntObjectOptHashMap(n4);
        } else {
            this.vertexArrayCount = 0;
        }
        if (n3 > 0) {
            n4 = AbstractGeometryBuffer.getIndexSize(n2) * n3;
            this.indexArray = NIO.createJavaByteBuffer(n4);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
    }

    public VertexFormat getVertexFormat(int n) {
        return (VertexFormat)this.vertexFormats.get(n);
    }

    public int getVertexSize() {
        int n = 0;
        for (int i2 = this.vertexFormats.size() - 1; i2 >= 0; --i2) {
            VertexFormat vertexFormat = (VertexFormat)this.vertexFormats.get(i2);
            n += vertexFormat.getVertexSize();
        }
        return n;
    }

    public int getMaxVertices() {
        return this.maxVertices;
    }

    public int getIndexFormat() {
        return this.indexFormat;
    }

    public int getMaxIndices() {
        return this.maxIndices;
    }

    public boolean hasIndices() {
        return this.maxIndices > 0;
    }

    public int getPrimitiveType() {
        return this.primitiveType;
    }

    public int getVertexCount() {
        return this.maxVertex - this.minVertex;
    }

    public int getVertexArrayCount() {
        return this.vertexArrayCount;
    }

    public ByteBuffer getVertexArray(int n) {
        return this.vertexArrays[n];
    }

    public ByteBuffer getVertexArray() {
        return this.getVertexArray(0);
    }

    public int getIndexCount() {
        return this.maxIndex - this.minIndex;
    }

    public ByteBuffer getIndexArray() {
        return this.indexArray;
    }

    public void beginGeometry(int n, int n2, int n3) {
        this.primitiveType = n;
        this.primitiveCount = 0;
        this.minVertex = n2;
        this.maxVertex = n2;
        if (this.maxVertices > 0) {
            for (int i2 = 0; i2 < this.vertexArrays.length; ++i2) {
                this.vertexArrays[i2].clear();
            }
        }
        this.minIndex = n3;
        this.maxIndex = n3;
        if (this.maxIndices > 0) {
            this.indexArray.clear();
        }
    }

    public void beginGeometry(int n, int n2) {
        this.beginGeometry(n, n2, 0);
    }

    public void endGeometry() {
        if (this.maxVertices > 0) {
            for (int i2 = 0; i2 < this.vertexArrays.length; ++i2) {
                this.vertexArrays[i2].flip();
            }
        }
        if (this.maxIndices > 0) {
            this.indexArray.flip();
        }
    }

    public void beginVertex() {
    }

    public void endVertex() {
        for (int i2 = 0; i2 < this.vertexArrays.length; ++i2) {
            VertexFormat vertexFormat = (VertexFormat)this.vertexFormats.get(i2);
            this.vertexArrays[i2].position(this.vertexArrays[i2].position() + vertexFormat.getVertexSize());
        }
        ++this.maxVertex;
    }

    private void setVertexAttribute(MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex, float f2) {
        ByteBuffer byteBuffer = this.vertexArrays[meshBuilder$VertexAttributeIndex.vertexArrayIndex];
        int n = byteBuffer.position();
        int n2 = meshBuilder$VertexAttributeIndex.vertexAttribute.offset;
        byteBuffer.putFloat(n + n2, f2);
    }

    private void setVertexAttribute(MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex, int n) {
        ByteBuffer byteBuffer = this.vertexArrays[meshBuilder$VertexAttributeIndex.vertexArrayIndex];
        int n2 = byteBuffer.position();
        int n3 = meshBuilder$VertexAttributeIndex.vertexAttribute.offset;
        byteBuffer.putInt(n2 + n3, n);
    }

    private void setVertexAttribute(MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex, float f2, float f3) {
        ByteBuffer byteBuffer = this.vertexArrays[meshBuilder$VertexAttributeIndex.vertexArrayIndex];
        int n = byteBuffer.position();
        int n2 = meshBuilder$VertexAttributeIndex.vertexAttribute.offset;
        byteBuffer.putFloat(n + n2 + 0, f2);
        byteBuffer.putFloat(n + n2 + 4, f3);
    }

    private void setVertexAttribute(MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex, float f2, float f3, float f4) {
        ByteBuffer byteBuffer = this.vertexArrays[meshBuilder$VertexAttributeIndex.vertexArrayIndex];
        int n = byteBuffer.position();
        int n2 = meshBuilder$VertexAttributeIndex.vertexAttribute.offset;
        byteBuffer.putFloat(n + n2 + 0, f2);
        byteBuffer.putFloat(n + n2 + 4, f3);
        byteBuffer.putFloat(n + n2 + 8, f4);
    }

    private void setVertexAttribute(MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex, float f2, float f3, float f4, float f5) {
        ByteBuffer byteBuffer = this.vertexArrays[meshBuilder$VertexAttributeIndex.vertexArrayIndex];
        int n = byteBuffer.position();
        int n2 = meshBuilder$VertexAttributeIndex.vertexAttribute.offset;
        byteBuffer.putFloat(n + n2 + 0, f2);
        byteBuffer.putFloat(n + n2 + 4, f3);
        byteBuffer.putFloat(n + n2 + 8, f4);
        byteBuffer.putFloat(n + n2 + 12, f5);
    }

    private MeshBuilder$VertexAttributeIndex getVertexAttributeIndex(int n, int n2, int n3, int n4) {
        int n5 = (n3 & 0xFFFF0000) << 16 | n4 & 0xFFFF0000;
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = (MeshBuilder$VertexAttributeIndex)this.vertexAttributeMap.get(n5);
        if (meshBuilder$VertexAttributeIndex == null) {
            for (int i2 = 0; i2 < this.vertexArrayCount && meshBuilder$VertexAttributeIndex == null; ++i2) {
                VertexFormat vertexFormat = (VertexFormat)this.vertexFormats.get(i2);
                int n6 = vertexFormat.getVertexAttributeIndex(n3, n4);
                if (n6 == -1) continue;
                VertexFormat$VertexAttribute vertexFormat$VertexAttribute = vertexFormat.getVertexAttribute(n6);
                if (vertexFormat$VertexAttribute.elementType != n || vertexFormat$VertexAttribute.elementCount != n2) continue;
                meshBuilder$VertexAttributeIndex = new MeshBuilder$VertexAttributeIndex(i2, vertexFormat$VertexAttribute);
                this.vertexAttributeMap.put(n5, meshBuilder$VertexAttributeIndex);
                break;
            }
            if (meshBuilder$VertexAttributeIndex == null) {
                throw new IllegalArgumentException("No vertex attribute matches the element type, element count and semantic");
            }
        }
        return meshBuilder$VertexAttributeIndex;
    }

    private MeshBuilder$VertexAttributeIndex getVertexAttributeIndex(int n, int n2, int n3) {
        return this.getVertexAttributeIndex(n, n2, n3, 0);
    }

    public void setVertexPosition(float f2, float f3) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 2, 0);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2, f3);
    }

    public void setVertexPosition(Point2f point2f) {
        this.setVertexPosition(point2f.x, point2f.y);
    }

    public void setVertexPosition(float f2, float f3, float f4) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 3, 0);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2, f3, f4);
    }

    public void setVertexPosition(Point3f point3f) {
        this.setVertexPosition(point3f.x, point3f.y, point3f.z);
    }

    public void setVertexPosition(float f2, float f3, float f4, float f5) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 4, 0);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2, f3, f4, f5);
    }

    public void setVertexNormal(float f2, float f3) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 2, 1);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2, f3);
    }

    public void setVertexNormal(Tuple2f tuple2f) {
        this.setVertexNormal(tuple2f.x, tuple2f.y);
    }

    public void setVertexNormal(float f2, float f3, float f4) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 3, 1);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2, f3, f4);
    }

    public void setVertexNormal(Tuple3f tuple3f) {
        this.setVertexNormal(tuple3f.x, tuple3f.y, tuple3f.z);
    }

    public void setVertexColor(int n, Color4f color4f) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 4, 2, n);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, color4f.getRed(), color4f.getGreen(), color4f.getBlue(), color4f.getAlpha());
    }

    public void setVertexColor(int n, Color4b color4b) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(0, 4, 2, n);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, color4b.getRGBA());
    }

    public void setVertexColor(int n, int n2) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(0, 4, 2, n);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, n2);
    }

    public void setVertexTextureCoordinate(int n, float f2, float f3) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 2, 3, n);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2, f3);
    }

    public void setVertexTextureCoordinate(int n, TextureCoordinate2f textureCoordinate2f) {
        this.setVertexTextureCoordinate(n, textureCoordinate2f.getU(), textureCoordinate2f.getV());
    }

    public void setVertexPointSize(float f2) {
        MeshBuilder$VertexAttributeIndex meshBuilder$VertexAttributeIndex = this.getVertexAttributeIndex(3, 1, 4);
        this.setVertexAttribute(meshBuilder$VertexAttributeIndex, f2);
    }

    public void addIndex(byte by) {
        byte by2 = (byte)(this.minVertex + by & 0xFF);
        this.indexArray.put(by2);
        ++this.maxIndex;
    }

    public void addIndex(short s) {
        short s2 = (short)(this.minVertex + s & 0xFFFF0000);
        this.indexArray.putShort(s2);
        ++this.maxIndex;
    }

    public void addIndex(int n) {
        int n2 = this.minVertex + n;
        this.indexArray.putInt(n2);
        ++this.maxIndex;
    }
}


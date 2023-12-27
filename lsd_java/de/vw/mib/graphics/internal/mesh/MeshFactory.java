/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.tesselation.CircleGraphMeshTesselator;
import de.vw.mib.graphics.internal.mesh.tesselation.CircularSectorMeshTesselator;
import de.vw.mib.graphics.internal.mesh.tesselation.LineMeshTesselator;
import de.vw.mib.graphics.internal.mesh.tesselation.MeshTesselator;
import de.vw.mib.graphics.internal.mesh.tesselation.PointMeshTesselator;
import de.vw.mib.graphics.internal.mesh.tesselation.SolidMeshTesselator;
import de.vw.mib.graphics.math.AbstractTuple;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.mesh.GeometryBuffer;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.texture.TextureCoordinate2f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class MeshFactory {
    private static final int COLOR_BLACK_ARGB;
    private static final int COLOR_RED_ARGB;
    private static final int COLOR_GREEN_ARGB;
    private static final int COLOR_BLUE_ARGB;
    private static final int COLOR_YELLOW_ARGB;
    private static final int COLOR_MAGENTA_ARGB;
    private static final int COLOR_CYAN_ARGB;
    private static final int COLOR_WHITE_ARGB;
    private final MeshManager meshManager;
    private static final float[] AXIS_POSITIONS;
    private static final int AXIS_POSITIONS_ELEMENT_TYPE;
    private static final int AXIS_POSITIONS_ELEMENT_SIZE;
    private static final int[] AXIS_COLORS;
    private static final int AXIS_COLORS_ELEMENT_TYPE;
    private static final int AXIS_COLORS_ELEMENT_SIZE;
    private static final int AXIS_PRIMITIVE_TYPE;
    private static final float[] SQUARE_POSITIONS;
    private static final int SQUARE_POSITIONS_ELEMENT_TYPE;
    private static final int SQUARE_POSITIONS_ELEMENT_SIZE;
    private static final float[] SQUARE_NORMALS;
    private static final int SQUARE_NORMALS_ELEMENT_TYPE;
    private static final int SQUARE_NORMALS_ELEMENT_SIZE;
    private static final int[] SQUARE_COLORS;
    private static final int SQUARE_COLORS_ELEMENT_TYPE;
    private static final int SQUARE_COLORS_ELEMENT_SIZE;
    private static final float[] SQUARE_TEXCOORDS;
    private static final int SQUARE_TEXCOORDS_ELEMENT_TYPE;
    private static final int SQUARE_TEXCOORDS_ELEMENT_SIZE;
    private static final int SQUARE_PRIMITIVE_TYPE;
    private static final float[] BOX_POSITIONS;
    private static final int BOX_POSITIONS_ELEMENT_TYPE;
    private static final int BOX_POSITIONS_ELEMENT_SIZE;
    private static final int[] BOX_COLORS;
    private static final int BOX_COLORS_ELEMENT_TYPE;
    private static final int BOX_COLORS_ELEMENT_SIZE;
    private static final byte[] BOX_INDICES;
    private static final int BOX_INDICES_ELEMENT_TYPE;
    private static final int BOX_INDICES_ELEMENT_SIZE;
    private static final int BOX_PRIMITIVE_TYPE;
    private static final float[] CUBE_POSITIONS;
    private static final int CUBE_POSITIONS_ELEMENT_TYPE;
    private static final int CUBE_POSITIONS_ELEMENT_SIZE;
    private static final float[] CUBE_NORMALS;
    private static final int CUBE_NORMALS_ELEMENT_TYPE;
    private static final int CUBE_NORMALS_ELEMENT_SIZE;
    private static final int[] CUBE_COLORS;
    private static final int CUBE_COLORS_ELEMENT_TYPE;
    private static final int CUBE_COLORS_ELEMENT_SIZE;
    private static final float[] CUBE_TEXCOORDS;
    private static final int CUBE_TEXCOORDS_ELEMENT_TYPE;
    private static final int CUBE_TEXCOORDS_ELEMENT_SIZE;
    private static final byte[] CUBE_INDICES;
    private static final int CUBE_INDICES_ELEMENT_TYPE;
    private static final int CUBE_INDICES_ELEMENT_SIZE;
    private static final int CUBE_PRIMITIVE_TYPE;

    public MeshFactory(MeshManager meshManager) {
        this.meshManager = meshManager;
    }

    public Mesh createReferenceCoordinatesMesh(boolean bl, boolean bl2) {
        int n;
        Object object;
        int n2 = AXIS_POSITIONS.length / 3;
        BoundingVolume boundingVolume = MeshFactory.createMeshBoundingVolume();
        ArrayList arrayList = new ArrayList(2);
        if (bl) {
            object = new VertexFormat();
            ((VertexFormat)object).addVertexAttribute(3, 3, 0);
            if (bl2) {
                ((VertexFormat)object).addVertexAttribute(0, 4, 2);
            }
            arrayList.add(object);
        } else {
            object = new VertexFormat();
            ((VertexFormat)object).addVertexAttribute(3, 3, 0);
            arrayList.add(object);
            if (bl2) {
                VertexFormat vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(0, 4, 2);
                arrayList.add(vertexFormat);
            }
        }
        object = new MeshBuilder(arrayList, n2);
        ((MeshBuilder)object).beginGeometry(1, 0);
        for (n = 0; n < n2; ++n) {
            float f2 = AXIS_POSITIONS[n * 3 + 0];
            float f3 = AXIS_POSITIONS[n * 3 + 1];
            float f4 = AXIS_POSITIONS[n * 3 + 2];
            ((MeshBuilder)object).beginVertex();
            ((MeshBuilder)object).setVertexPosition(f2, f3, f4);
            if (bl2) {
                int n3 = AXIS_COLORS[n];
                ((MeshBuilder)object).setVertexColor(0, n3);
            }
            ((MeshBuilder)object).endVertex();
            boundingVolume.union(f2, f3, f4);
        }
        ((MeshBuilder)object).endGeometry();
        n = ((MeshBuilder)object).getVertexArrayCount();
        ArrayList arrayList2 = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            VertexFormat vertexFormat = ((MeshBuilder)object).getVertexFormat(i2);
            ByteBuffer byteBuffer = ((MeshBuilder)object).getVertexArray(i2);
            VertexBuffer vertexBuffer = this.meshManager.createVertexBuffer(n2, vertexFormat, 1);
            vertexBuffer.setContent(byteBuffer);
            arrayList2.add(vertexBuffer);
        }
        ArrayList arrayList3 = new ArrayList(1);
        arrayList3.add(new Primitives(((MeshBuilder)object).getPrimitiveType(), 0, ((MeshBuilder)object).getVertexCount() - 1));
        VertexBufferStreamMapping vertexBufferStreamMapping = new VertexBufferStreamMapping();
        int n4 = bl ? ((VertexFormat)arrayList.get(0)).getVertexAttributeCount() : n;
        for (int i3 = 0; i3 < n4; ++i3) {
            vertexBufferStreamMapping.addVertexStream((VertexBuffer)arrayList2.get(bl ? 0 : i3), bl ? i3 : 0);
        }
        return this.meshManager.createMesh(arrayList3, n2, arrayList2, vertexBufferStreamMapping, boundingVolume);
    }

    public Mesh createRectangleMesh(float f2, float f3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n;
        Object object;
        int n2 = SQUARE_POSITIONS.length / 2;
        BoundingVolume boundingVolume = MeshFactory.createMeshBoundingVolume();
        ArrayList arrayList = new ArrayList(4);
        if (bl) {
            object = new VertexFormat();
            ((VertexFormat)object).addVertexAttribute(3, 2, 0);
            if (bl2) {
                ((VertexFormat)object).addVertexAttribute(3, 3, 1);
            }
            if (bl4) {
                ((VertexFormat)object).addVertexAttribute(0, 4, 2);
            }
            if (bl3) {
                ((VertexFormat)object).addVertexAttribute(3, 2, 3, 0);
            }
            arrayList.add(object);
        } else {
            VertexFormat vertexFormat;
            object = new VertexFormat();
            ((VertexFormat)object).addVertexAttribute(3, 2, 0);
            arrayList.add(object);
            if (bl2) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(3, 3, 1);
                arrayList.add(vertexFormat);
            }
            if (bl4) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(0, 4, 2);
                arrayList.add(vertexFormat);
            }
            if (bl3) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(3, 2, 3, 0);
                arrayList.add(vertexFormat);
            }
        }
        object = new MeshBuilder(arrayList, n2);
        ((MeshBuilder)object).beginGeometry(6, 0);
        for (n = 0; n < n2; ++n) {
            float f4;
            float f5;
            float f6 = SQUARE_POSITIONS[n * 2 + 0] * f2;
            float f7 = SQUARE_POSITIONS[n * 2 + 1] * f3;
            ((MeshBuilder)object).beginVertex();
            ((MeshBuilder)object).setVertexPosition(f6, f7);
            if (bl2) {
                f5 = SQUARE_NORMALS[n * 3 + 0];
                f4 = SQUARE_NORMALS[n * 3 + 1];
                float f8 = SQUARE_NORMALS[n * 3 + 2];
                ((MeshBuilder)object).setVertexNormal(f5, f4, f8);
            }
            if (bl4) {
                int n3 = SQUARE_COLORS[n];
                ((MeshBuilder)object).setVertexColor(0, n3);
            }
            if (bl3) {
                f5 = SQUARE_TEXCOORDS[n * 2 + 0];
                f4 = SQUARE_TEXCOORDS[n * 2 + 1];
                ((MeshBuilder)object).setVertexTextureCoordinate(0, f5, f4);
            }
            ((MeshBuilder)object).endVertex();
            boundingVolume.union(f6, f7, 0.0f);
        }
        ((MeshBuilder)object).endGeometry();
        n = ((MeshBuilder)object).getVertexArrayCount();
        ArrayList arrayList2 = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            VertexFormat vertexFormat = ((MeshBuilder)object).getVertexFormat(i2);
            ByteBuffer byteBuffer = ((MeshBuilder)object).getVertexArray(i2);
            VertexBuffer vertexBuffer = this.meshManager.createVertexBuffer(n2, vertexFormat, 1);
            vertexBuffer.setContent(byteBuffer);
            arrayList2.add(vertexBuffer);
        }
        ArrayList arrayList3 = new ArrayList(1);
        arrayList3.add(new Primitives(((MeshBuilder)object).getPrimitiveType(), 0, ((MeshBuilder)object).getVertexCount() - 1));
        VertexBufferStreamMapping vertexBufferStreamMapping = new VertexBufferStreamMapping();
        int n4 = bl ? ((VertexFormat)arrayList.get(0)).getVertexAttributeCount() : n;
        for (int i3 = 0; i3 < n4; ++i3) {
            vertexBufferStreamMapping.addVertexStream((VertexBuffer)arrayList2.get(bl ? 0 : i3), bl ? i3 : 0);
        }
        return this.meshManager.createMesh(arrayList3, n2, arrayList2, vertexBufferStreamMapping, boundingVolume);
    }

    public Mesh createWireBoxMesh(float f2, float f3, float f4, boolean bl) {
        Object object;
        int n;
        Object object2;
        int n2 = BOX_POSITIONS.length / 3;
        int n3 = BOX_INDICES.length;
        BoundingVolume boundingVolume = MeshFactory.createMeshBoundingVolume();
        ArrayList arrayList = new ArrayList(4);
        boolean bl2 = false;
        if (bl) {
            object2 = new VertexFormat();
            ((VertexFormat)object2).addVertexAttribute(3, 3, 0);
            arrayList.add(object2);
        } else {
            object2 = new VertexFormat();
            ((VertexFormat)object2).addVertexAttribute(3, 3, 0);
            arrayList.add(object2);
        }
        object2 = new MeshBuilder(arrayList, n2, 0, n3);
        ((MeshBuilder)object2).beginGeometry(1, 0);
        for (n = 0; n < n2; ++n) {
            float f5 = BOX_POSITIONS[n * 3 + 0] * f2;
            float f6 = BOX_POSITIONS[n * 3 + 1] * f3;
            float f7 = BOX_POSITIONS[n * 3 + 2] * f4;
            ((MeshBuilder)object2).beginVertex();
            ((MeshBuilder)object2).setVertexPosition(f5, f6, f7);
            ((MeshBuilder)object2).endVertex();
            boundingVolume.union(f5, f6, 0.0f);
        }
        for (n = 0; n < n3; ++n) {
            ((MeshBuilder)object2).addIndex(BOX_INDICES[n]);
        }
        ((MeshBuilder)object2).endGeometry();
        n = ((MeshBuilder)object2).getVertexArrayCount();
        ArrayList arrayList2 = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            VertexFormat vertexFormat = ((MeshBuilder)object2).getVertexFormat(i2);
            object = ((MeshBuilder)object2).getVertexArray(i2);
            VertexBuffer vertexBuffer = this.meshManager.createVertexBuffer(n2, vertexFormat, 1);
            vertexBuffer.setContent((ByteBuffer)object);
            arrayList2.add(vertexBuffer);
        }
        IndexBuffer indexBuffer = this.meshManager.createIndexBuffer(((MeshBuilder)object2).getIndexCount(), ((MeshBuilder)object2).getIndexFormat(), 1);
        indexBuffer.setContent(((MeshBuilder)object2).getIndexArray());
        ArrayList arrayList3 = new ArrayList(1);
        arrayList3.add(new Primitives(((MeshBuilder)object2).getPrimitiveType(), 0, ((MeshBuilder)object2).getVertexCount() - 1, 0, n3));
        object = new VertexBufferStreamMapping();
        int n4 = bl ? ((VertexFormat)arrayList.get(0)).getVertexAttributeCount() : n;
        for (int i3 = 0; i3 < n4; ++i3) {
            ((VertexBufferStreamMapping)object).addVertexStream((VertexBuffer)arrayList2.get(bl ? 0 : i3), bl ? i3 : 0);
        }
        return this.meshManager.createMesh(arrayList3, n2, arrayList2, (VertexBufferStreamMapping)object, n3, indexBuffer, boundingVolume);
    }

    public Mesh createSolidCubeMesh(float f2, float f3, float f4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n;
        Object object;
        int n2 = CUBE_POSITIONS.length / 3;
        int n3 = CUBE_INDICES.length;
        BoundingVolume boundingVolume = MeshFactory.createMeshBoundingVolume();
        ArrayList arrayList = new ArrayList(4);
        if (bl) {
            object = new VertexFormat();
            ((VertexFormat)object).addVertexAttribute(3, 3, 0);
            if (bl2) {
                ((VertexFormat)object).addVertexAttribute(3, 3, 1);
            }
            if (bl4) {
                ((VertexFormat)object).addVertexAttribute(0, 4, 2);
            }
            if (bl3) {
                ((VertexFormat)object).addVertexAttribute(3, 2, 3, 0);
            }
            arrayList.add(object);
        } else {
            VertexFormat vertexFormat;
            object = new VertexFormat();
            ((VertexFormat)object).addVertexAttribute(3, 3, 0);
            arrayList.add(object);
            if (bl2) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(3, 3, 1);
                arrayList.add(vertexFormat);
            }
            if (bl4) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(0, 4, 2);
                arrayList.add(vertexFormat);
            }
            if (bl3) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(3, 2, 3, 0);
                arrayList.add(vertexFormat);
            }
        }
        object = new MeshBuilder(arrayList, n2, 0, n3);
        ((MeshBuilder)object).beginGeometry(4, 0);
        for (n = 0; n < n2; ++n) {
            float f5 = CUBE_POSITIONS[n * 3 + 0] * f2;
            float f6 = CUBE_POSITIONS[n * 3 + 1] * f3;
            float f7 = CUBE_POSITIONS[n * 3 + 2] * f4;
            ((MeshBuilder)object).beginVertex();
            ((MeshBuilder)object).setVertexPosition(f5, f6, f7);
            if (bl4) {
                int n4 = CUBE_COLORS[n];
                ((MeshBuilder)object).setVertexColor(0, n4);
            }
            ((MeshBuilder)object).endVertex();
            boundingVolume.union(f5, f6, 0.0f);
        }
        for (n = 0; n < n3; ++n) {
            ((MeshBuilder)object).addIndex(CUBE_INDICES[n]);
        }
        ((MeshBuilder)object).endGeometry();
        n = ((MeshBuilder)object).getVertexArrayCount();
        ArrayList arrayList2 = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            VertexFormat vertexFormat = ((MeshBuilder)object).getVertexFormat(i2);
            ByteBuffer byteBuffer = ((MeshBuilder)object).getVertexArray(i2);
            VertexBuffer vertexBuffer = this.meshManager.createVertexBuffer(n2, vertexFormat, 1);
            vertexBuffer.setContent(byteBuffer);
            arrayList2.add(vertexBuffer);
        }
        IndexBuffer indexBuffer = this.meshManager.createIndexBuffer(((MeshBuilder)object).getIndexCount(), ((MeshBuilder)object).getIndexFormat(), 1);
        indexBuffer.setContent(((MeshBuilder)object).getIndexArray());
        ArrayList arrayList3 = new ArrayList(1);
        arrayList3.add(new Primitives(((MeshBuilder)object).getPrimitiveType(), 0, ((MeshBuilder)object).getVertexCount() - 1, 0, n3));
        VertexBufferStreamMapping vertexBufferStreamMapping = new VertexBufferStreamMapping();
        int n5 = bl ? ((VertexFormat)arrayList.get(0)).getVertexAttributeCount() : n;
        for (int i3 = 0; i3 < n5; ++i3) {
            vertexBufferStreamMapping.addVertexStream((VertexBuffer)arrayList2.get(bl ? 0 : i3), bl ? i3 : 0);
        }
        return this.meshManager.createMesh(arrayList3, n2, arrayList2, vertexBufferStreamMapping, n3, indexBuffer, boundingVolume);
    }

    public Mesh createPointMesh(Point3f[] point3fArray, boolean bl) {
        PointMeshTesselator pointMeshTesselator = new PointMeshTesselator(bl, point3fArray.length);
        try {
            pointMeshTesselator.initialize();
            pointMeshTesselator.tesselatePointMesh(point3fArray);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, pointMeshTesselator);
    }

    public Mesh createLineMesh(Point2f[] point2fArray, boolean bl) {
        LineMeshTesselator lineMeshTesselator = new LineMeshTesselator(false, point2fArray.length);
        try {
            lineMeshTesselator.initialize();
            lineMeshTesselator.tesselateLineMesh(point2fArray, bl);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, lineMeshTesselator);
    }

    public Mesh createLineMesh(Point3f[] point3fArray, boolean bl) {
        LineMeshTesselator lineMeshTesselator = new LineMeshTesselator(false, point3fArray.length);
        try {
            lineMeshTesselator.initialize();
            lineMeshTesselator.tesselateLineMesh(point3fArray, bl);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, lineMeshTesselator);
    }

    public Mesh createUniformSolidGridMesh(float f2, float f3, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        int n3 = 10000;
        SolidMeshTesselator solidMeshTesselator = new SolidMeshTesselator(bl, 10000, bl2, bl3);
        try {
            solidMeshTesselator.initialize();
            solidMeshTesselator.tesselateUniformGridMesh(f2, f3, n, n2);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, solidMeshTesselator);
    }

    public Mesh createUniformPointGridMesh(float f2, float f3, int n, int n2, boolean bl) {
        int n3 = 10000;
        PointMeshTesselator pointMeshTesselator = new PointMeshTesselator(bl, 10000);
        try {
            pointMeshTesselator.initialize();
            pointMeshTesselator.tesselateUniformPointGridMesh(f2, f3, n, n2);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, pointMeshTesselator);
    }

    public Mesh createCircularSectorMesh(float f2, float f3, float f4, int n, boolean bl, boolean bl2) {
        int n2 = 10000;
        CircularSectorMeshTesselator circularSectorMeshTesselator = new CircularSectorMeshTesselator(bl, 10000, bl2);
        try {
            circularSectorMeshTesselator.initialize();
            circularSectorMeshTesselator.tesselateCircularSectorMesh(f2, f3, f4, n);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, circularSectorMeshTesselator);
    }

    public Mesh createCircleGraphMesh(float[] fArray, float f2, int n, boolean bl, boolean bl2) {
        int n2 = 10000;
        CircleGraphMeshTesselator circleGraphMeshTesselator = new CircleGraphMeshTesselator(bl, 10000, bl2);
        try {
            circleGraphMeshTesselator.initialize();
            circleGraphMeshTesselator.tesselateCircleGraphMesh(fArray, f2, n);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, circleGraphMeshTesselator);
    }

    public Mesh createBarGraphMesh() {
        throw new NotYetImplementedException();
    }

    public Mesh createCylinderMesh(int n, int n2, boolean bl) {
        throw new NotYetImplementedException();
    }

    public Mesh createSolidSphereMesh(float f2, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        int n3 = 10000;
        SolidMeshTesselator solidMeshTesselator = new SolidMeshTesselator(bl, 10000, bl2, bl3);
        try {
            solidMeshTesselator.initialize();
            solidMeshTesselator.tesselateSolidSphereMesh(f2, n, n2);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, solidMeshTesselator);
    }

    public Mesh createSolidSphereMesh(float f2, int n, boolean bl, boolean bl2, boolean bl3) {
        return this.createSolidSphereMesh(f2, n / 2, n, bl, bl2, bl3);
    }

    public Mesh createPointSphereMesh(float f2, int n, int n2, boolean bl) {
        int n3 = 10000;
        PointMeshTesselator pointMeshTesselator = new PointMeshTesselator(bl, 10000);
        try {
            pointMeshTesselator.initialize();
            pointMeshTesselator.tesselatePointSphereMesh(f2, n, n2);
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            // empty catch block
        }
        return MeshFactory.wrapTesselatedMesh(this.meshManager, pointMeshTesselator);
    }

    public Mesh createPointSphereMesh(float f2, int n, boolean bl) {
        return this.createPointSphereMesh(f2, n / 2, n, bl);
    }

    private static BoundingVolume createMeshBoundingVolume() {
        return new AxisAlignedBox();
    }

    private static Mesh wrapVertexArrays(MeshManager meshManager, int n, List list, List list2, List list3, List list4, List list5, int n2, IntArrayList intArrayList, BoundingVolume boundingVolume) {
        Object object;
        int n3;
        int n4 = list2.size();
        int n5 = intArrayList.size();
        MeshBuilder meshBuilder = new MeshBuilder(list, n4, n2, n5);
        meshBuilder.beginGeometry(n, 0, 0);
        for (n3 = 0; n3 < n4; ++n3) {
            AbstractTuple abstractTuple;
            meshBuilder.beginVertex();
            Point3f point3f = (Point3f)list2.get(n3);
            meshBuilder.setVertexPosition(point3f);
            boundingVolume.union(point3f);
            if (list3 != null) {
                abstractTuple = (Vector3f)list3.get(n3);
                meshBuilder.setVertexNormal((Tuple3f)abstractTuple);
            }
            if (list4 != null) {
                abstractTuple = (Color4f)list4.get(n3);
                meshBuilder.setVertexColor(0, (Color4f)abstractTuple);
            }
            if (list5 != null) {
                abstractTuple = (TextureCoordinate2f)list5.get(n3);
                meshBuilder.setVertexTextureCoordinate(0, (TextureCoordinate2f)abstractTuple);
            }
            meshBuilder.endVertex();
        }
        block6: for (n3 = 0; n3 < n5; ++n3) {
            int n6 = intArrayList.get(n3);
            switch (n2) {
                case 0: {
                    meshBuilder.addIndex((byte)(n6 & 0xFF));
                    continue block6;
                }
                case 1: {
                    meshBuilder.addIndex((short)(n6 & 0xFFFF0000));
                    continue block6;
                }
                case 2: {
                    meshBuilder.addIndex(n6);
                    continue block6;
                }
                default: {
                    throw new IllegalArgumentException("Invalid index format");
                }
            }
        }
        meshBuilder.endGeometry();
        n3 = meshBuilder.getVertexArrayCount();
        ArrayList arrayList = new ArrayList(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            object = meshBuilder.getVertexFormat(i2);
            ByteBuffer byteBuffer = meshBuilder.getVertexArray(i2);
            VertexBuffer vertexBuffer = meshManager.createVertexBuffer(n4, (VertexFormat)object, 1);
            vertexBuffer.setContent(byteBuffer);
            arrayList.add(vertexBuffer);
        }
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(new Primitives(meshBuilder.getPrimitiveType(), 0, meshBuilder.getVertexCount() - 1));
        object = new VertexBufferStreamMapping();
        boolean bl = list.size() == 1;
        int n7 = bl ? ((VertexFormat)list.get(0)).getVertexAttributeCount() : n3;
        for (int i3 = 0; i3 < n7; ++i3) {
            ((VertexBufferStreamMapping)object).addVertexStream((VertexBuffer)arrayList.get(bl ? 0 : i3), bl ? i3 : 0);
        }
        return meshManager.createMesh(arrayList2, n4, arrayList, (VertexBufferStreamMapping)object, boundingVolume);
    }

    private static Mesh wrapTesselatedMesh(MeshManager meshManager, MeshTesselator meshTesselator) {
        GeometryBuffer geometryBuffer;
        int n;
        int n2 = meshTesselator.getVertexCount();
        int n3 = meshTesselator.getVertexArrayCount();
        ArrayList arrayList = new ArrayList(n3);
        for (n = 0; n < n3; ++n) {
            geometryBuffer = meshManager.createVertexBuffer(n2, meshTesselator.getVertexFormat(n), 1);
            geometryBuffer.setContent(meshTesselator.getVertexArray(n));
            arrayList.add(geometryBuffer);
        }
        n = meshTesselator.getIndexCount();
        geometryBuffer = null;
        if (meshTesselator.hasIndices()) {
            geometryBuffer = meshManager.createIndexBuffer(n, meshTesselator.getIndexFormat(), 1);
            geometryBuffer.setContent(meshTesselator.getIndexArray());
        }
        ArrayList arrayList2 = new ArrayList(1);
        VertexBufferStreamMapping vertexBufferStreamMapping = new VertexBufferStreamMapping();
        boolean bl = n3 > 1;
        int n4 = bl ? meshTesselator.getVertexFormat(0).getVertexAttributeCount() : n3;
        for (int i2 = 0; i2 < n4; ++i2) {
            vertexBufferStreamMapping.addVertexStream((VertexBuffer)arrayList.get(bl ? 0 : i2), bl ? i2 : 0);
        }
        if (meshTesselator.hasIndices()) {
            arrayList2.add(new Primitives(meshTesselator.getPrimitiveType(), 0, n2 - 1, 0, n));
            return meshManager.createMesh(arrayList2, n2, arrayList, vertexBufferStreamMapping, n, (IndexBuffer)geometryBuffer);
        }
        arrayList2.add(new Primitives(meshTesselator.getPrimitiveType(), 0, n2 - 1));
        return meshManager.createMesh(arrayList2, n2, arrayList, vertexBufferStreamMapping);
    }

    static {
        AXIS_POSITIONS = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        AXIS_COLORS = new int[]{65535, 65535, 0xFF00FF, 0xFF00FF, -16776961, -16776961};
        SQUARE_POSITIONS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        SQUARE_NORMALS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
        SQUARE_COLORS = new int[]{-1, -1, -1, -1};
        SQUARE_TEXCOORDS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        BOX_POSITIONS = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        BOX_COLORS = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        BOX_INDICES = new byte[]{0, 1, 1, 2, 2, 3, 3, 0, 4, 5, 5, 6, 6, 7, 7, 4, 0, 4, 1, 5, 2, 6, 3, 7};
        CUBE_POSITIONS = new float[]{0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        CUBE_NORMALS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 32959, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
        CUBE_COLORS = new int[]{255, 0xFF00FF, 65535, -16776961, 65535, -65281, -16711681, -1, 65535, -16776961, -16711681, -1, 255, 0xFF00FF, 65535, -65281, 255, 65535, 65535, -16711681, 0xFF00FF, -16776961, -65281, -1};
        CUBE_TEXCOORDS = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        CUBE_INDICES = new byte[]{0, 1, 2, 1, 3, 2, 6, 7, 5, 6, 5, 4, 8, 9, 10, 9, 10, 11, 12, 13, 14, 13, 14, 15, 17, 16, 18, 17, 18, 19, 20, 21, 22, 21, 22, 23};
    }
}


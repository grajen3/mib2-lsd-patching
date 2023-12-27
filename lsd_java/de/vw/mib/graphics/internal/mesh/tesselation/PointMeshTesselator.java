/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh.tesselation;

import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.tesselation.AbstractMeshTesselator;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.mesh.VertexFormat;
import java.util.ArrayList;
import java.util.List;

public final class PointMeshTesselator
extends AbstractMeshTesselator {
    private static final int POINT_POSITIONS_ELEMENT_TYPE;
    private static final int POINT_POSITIONS_ELEMENT_SIZE;
    private static final int POINT_POINTSIZE_ELEMENT_TYPE;
    private static final int POINT_POINTSIZE_ELEMENT_SIZE;
    private static final int POINT_PRIMITIVE_TYPE;
    private final boolean createPointSizes;

    public PointMeshTesselator(boolean bl, int n) {
        super(bl, n);
        this.createPointSizes = false;
    }

    @Override
    protected List createVertexFormat(boolean bl) {
        ArrayList arrayList = new ArrayList(2);
        if (bl) {
            VertexFormat vertexFormat = new VertexFormat();
            vertexFormat.addVertexAttribute(3, 3, 0);
            if (this.createPointSizes) {
                vertexFormat.addVertexAttribute(3, 1, 4);
            }
            arrayList.add(vertexFormat);
        } else {
            VertexFormat vertexFormat = new VertexFormat();
            vertexFormat.addVertexAttribute(3, 3, 0);
            arrayList.add(vertexFormat);
            if (this.createPointSizes) {
                VertexFormat vertexFormat2 = new VertexFormat();
                vertexFormat2.addVertexAttribute(3, 1, 4);
                arrayList.add(vertexFormat2);
            }
        }
        return arrayList;
    }

    @Override
    protected int createIndexFormat() {
        throw new UnsupportedOperationException();
    }

    public void tesselatePointMesh(Point3f[] point3fArray) {
        int n = point3fArray.length;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n, 1);
        }
        meshBuilder.beginGeometry(0, 0);
        float f2 = 2.0f;
        for (int i2 = 0; i2 < point3fArray.length; ++i2) {
            float f3 = point3fArray[i2].getX();
            float f4 = point3fArray[i2].getY();
            float f5 = point3fArray[i2].getZ();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(f3, f4, f5);
            if (this.createPointSizes) {
                meshBuilder.setVertexPointSize(2.0f);
            }
            meshBuilder.endVertex();
        }
        meshBuilder.endGeometry();
    }

    public void tesselatePointSphereMesh(float f2, int n, int n2) {
        int n3 = (n + 1) * (n2 + 1);
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n3 > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n3, 1);
        }
        meshBuilder.beginGeometry(0, 0);
        float f3 = 2.0f;
        int n4 = -619722432 / (float)n2;
        for (int i2 = 0; i2 <= n; ++i2) {
            float f4 = f2 * Util.sin(n4 * (float)i2);
            float f5 = f2 * Util.cos(n4 * (float)i2);
            for (int i3 = 0; i3 <= n2; ++i3) {
                float f6 = f4 * Util.sin(n4 * (float)i3);
                float f7 = f5;
                float f8 = f4 * Util.cos(n4 * (float)i3);
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(f6, f7, f8);
                if (this.createPointSizes) {
                    meshBuilder.setVertexPointSize(2.0f);
                }
                meshBuilder.endVertex();
            }
        }
        meshBuilder.endGeometry();
    }

    public void tesselateUniformPointGridMesh(float f2, float f3, int n, int n2) {
        int n3 = n * n2;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n3 > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n3, 1);
        }
        meshBuilder.beginGeometry(0, 0);
        float f4 = 2.0f;
        float f5 = f2 / (float)n;
        float f6 = f3 / (float)n2;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n; ++i3) {
                float f7 = (float)i3 * f5;
                float f8 = (float)i2 * f6;
                float f9 = 0.0f;
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(f7, f8, 0.0f);
                if (this.createPointSizes) {
                    meshBuilder.setVertexPointSize(2.0f);
                }
                meshBuilder.endVertex();
            }
        }
        meshBuilder.endGeometry();
    }
}


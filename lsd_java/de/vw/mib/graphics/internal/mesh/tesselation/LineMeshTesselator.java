/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh.tesselation;

import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.tesselation.AbstractMeshTesselator;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.mesh.VertexFormat;
import java.util.ArrayList;
import java.util.List;

public final class LineMeshTesselator
extends AbstractMeshTesselator {
    private static final int LINE_POSITIONS_ELEMENT_TYPE;
    private static final int LINE_POSITIONS_ELEMENT_SIZE;
    private static final int LINE_PRIMITIVE_TYPE;
    private static final int LINE_PRIMITIVE_TYPE_CLOSED;

    public LineMeshTesselator(boolean bl, int n) {
        super(bl, n);
    }

    @Override
    protected List createVertexFormat(boolean bl) {
        ArrayList arrayList = new ArrayList(1);
        VertexFormat vertexFormat = new VertexFormat();
        vertexFormat.addVertexAttribute(3, 3, 0);
        arrayList.add(vertexFormat);
        return arrayList;
    }

    @Override
    protected int createIndexFormat() {
        throw new UnsupportedOperationException();
    }

    public void tesselateLineMesh(Point2f[] point2fArray, boolean bl) {
        int n = point2fArray.length;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n, 1);
        }
        meshBuilder.beginGeometry(bl ? 3 : 2, 0);
        for (int i2 = 0; i2 < point2fArray.length; ++i2) {
            float f2 = point2fArray[i2].getX();
            float f3 = point2fArray[i2].getY();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(f2, f3, 0.0f);
            meshBuilder.endVertex();
        }
        meshBuilder.endGeometry();
    }

    public void tesselateLineMesh(Point3f[] point3fArray, boolean bl) {
        int n = point3fArray.length;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        meshBuilder.beginGeometry(bl ? 3 : 2, 0);
        for (int i2 = 0; i2 < point3fArray.length; ++i2) {
            float f2 = point3fArray[i2].getX();
            float f3 = point3fArray[i2].getY();
            float f4 = point3fArray[i2].getZ();
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(f2, f3, f4);
            meshBuilder.endVertex();
        }
        meshBuilder.endGeometry();
    }
}


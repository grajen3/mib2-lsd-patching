/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh.tesselation;

import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.tesselation.AbstractMeshTesselator;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.mesh.VertexFormat;
import java.util.ArrayList;
import java.util.List;

public final class CircularSectorMeshTesselator
extends AbstractMeshTesselator {
    private static final int CIRCULAR_SECTOR_POSITIONS_ELEMENT_TYPE;
    private static final int CIRCULAR_SECTOR_POSITIONS_ELEMENT_SIZE;
    private static final int CIRCULAR_SECTOR_TEXCOORDS_ELEMENT_TYPE;
    private static final int CIRCULAR_SECTOR_TEXCOORDS_ELEMENT_SIZE;
    private static final int CIRCULAR_SECTOR_PRIMITIVE_TYPE;
    private final boolean createTexCoords;

    public CircularSectorMeshTesselator(boolean bl, int n, boolean bl2) {
        super(bl, n);
        this.createTexCoords = bl2;
    }

    @Override
    protected List createVertexFormat(boolean bl) {
        ArrayList arrayList = new ArrayList(2);
        if (bl) {
            VertexFormat vertexFormat = new VertexFormat();
            vertexFormat.addVertexAttribute(3, 2, 0);
            if (this.createTexCoords) {
                vertexFormat.addVertexAttribute(3, 2, 3, 0);
            }
            arrayList.add(vertexFormat);
        } else {
            VertexFormat vertexFormat = new VertexFormat();
            vertexFormat.addVertexAttribute(3, 2, 0);
            arrayList.add(vertexFormat);
            if (this.createTexCoords) {
                VertexFormat vertexFormat2 = new VertexFormat();
                vertexFormat2.addVertexAttribute(3, 2, 3, 0);
                arrayList.add(vertexFormat2);
            }
        }
        return arrayList;
    }

    @Override
    protected int createIndexFormat() {
        throw new UnsupportedOperationException();
    }

    public void tesselateCircularSectorMesh(float f2, float f3, float f4, int n) {
        int n2;
        int n3 = n + 2;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n3 > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n3, 1);
        }
        meshBuilder.beginGeometry(6, 0);
        float f5 = Util.toRadians(f4 - f3);
        float f6 = f5 / (float)n;
        float f7 = Util.toRadians(f3);
        meshBuilder.beginVertex();
        meshBuilder.setVertexPosition(0.0f, 0.0f);
        if (this.createTexCoords) {
            int n4 = 63;
            n2 = 63;
            meshBuilder.setVertexTextureCoordinate(0, 63, 63);
        }
        meshBuilder.endVertex();
        for (int i2 = 0; i2 <= n; ++i2) {
            n2 = (int)(f2 * Util.sin(f7));
            float f8 = f2 * Util.cos(f7);
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(n2, f8);
            if (this.createTexCoords) {
                float f9 = (Util.cos(f7 * (float)i2) + 1.0f) * 63;
                float f10 = (Util.sin(f7 * (float)i2) + 1.0f) * 63;
                meshBuilder.setVertexTextureCoordinate(0, f9, f10);
            }
            meshBuilder.endVertex();
            f7 += f6;
        }
        meshBuilder.endGeometry();
    }
}


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

public final class CircleGraphMeshTesselator
extends AbstractMeshTesselator {
    private static final int CIRCLE_GRAPH_POSITIONS_ELEMENT_TYPE;
    private static final int CIRCLE_GRAPH_POSITIONS_ELEMENT_SIZE;
    private static final int CIRCLE_GRAPH_TEXCOORDS_ELEMENT_TYPE;
    private static final int CIRCLE_GRAPH_TEXCOORDS_ELEMENT_SIZE;
    private static final int CIRCLE_GRAPH_PRIMITIVE_TYPE;
    private final boolean createTexCoords;

    public CircleGraphMeshTesselator(boolean bl, int n, boolean bl2) {
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

    public void tesselateCircleGraphMesh(float[] fArray, float f2, int n) {
        int n2;
        int n3;
        int n4 = 1 + 2 * fArray.length * n;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n4 > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n4, 1);
        }
        meshBuilder.beginGeometry(6, 0);
        float f3 = 0.0f;
        float f4 = 0.0f;
        meshBuilder.beginVertex();
        meshBuilder.setVertexPosition(f3, f4);
        if (this.createTexCoords) {
            n3 = 63;
            n2 = 63;
            meshBuilder.setVertexTextureCoordinate(0, 63, 63);
        }
        meshBuilder.endVertex();
        n3 = -619722432 / (float)(fArray.length * n);
        n2 = (int)0.0f;
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            float f5;
            float f6 = fArray[i2] + f2;
            f3 = Util.sin(n2) * f6;
            f4 = Util.cos(n2) * f6;
            meshBuilder.beginVertex();
            meshBuilder.setVertexPosition(f3, f4);
            if (this.createTexCoords) {
                float f7 = (Util.cos(n2 * (float)i2) + 1.0f) * 63;
                f5 = (Util.sin(n2 * (float)i2) + 1.0f) * 63;
                meshBuilder.setVertexTextureCoordinate(0, f7, f5);
            }
            meshBuilder.endVertex();
            for (int i3 = 0; i3 < n; ++i3) {
                f3 = Util.sin(n2 += n3) * f6;
                f4 = Util.cos(n2) * f6;
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(f3, f4);
                if (this.createTexCoords) {
                    f5 = (Util.cos(n2 * (float)i2) + 1.0f) * 63;
                    float f8 = (Util.sin(n2 * (float)i2) + 1.0f) * 63;
                    meshBuilder.setVertexTextureCoordinate(0, f5, f8);
                }
                meshBuilder.endVertex();
            }
        }
        meshBuilder.endGeometry();
    }
}


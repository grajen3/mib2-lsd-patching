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
import java.util.Random;

public final class SolidMeshTesselator
extends AbstractMeshTesselator {
    private static final int SOLID_POSITIONS_ELEMENT_TYPE;
    private static final int SOLID_POSITIONS_ELEMENT_SIZE;
    private static final int SOLID_NORMALS_ELEMENT_TYPE;
    private static final int SOLID_NORMALS_ELEMENT_SIZE;
    private static final int SOLID_TEXCOORDS_ELEMENT_TYPE;
    private static final int SOLID_TEXCOORDS_ELEMENT_SIZE;
    private static final int SOLID_PRIMITIVE_TYPE;
    private static final int SOLID_INDICES_ELEMENT_TYPE;
    private final boolean createNormals;
    private final boolean createTexCoords;

    public SolidMeshTesselator(boolean bl, int n, boolean bl2, boolean bl3) {
        super(bl, n, n);
        this.createNormals = bl2;
        this.createTexCoords = bl3;
    }

    @Override
    protected List createVertexFormat(boolean bl) {
        ArrayList arrayList = new ArrayList(3);
        if (bl) {
            VertexFormat vertexFormat = new VertexFormat();
            vertexFormat.addVertexAttribute(3, 3, 0);
            if (this.createNormals) {
                vertexFormat.addVertexAttribute(3, 3, 1);
            }
            if (this.createTexCoords) {
                vertexFormat.addVertexAttribute(3, 2, 3, 0);
            }
            arrayList.add(vertexFormat);
        } else {
            VertexFormat vertexFormat;
            VertexFormat vertexFormat2 = new VertexFormat();
            vertexFormat2.addVertexAttribute(3, 3, 0);
            arrayList.add(vertexFormat2);
            if (this.createNormals) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(3, 3, 1);
                arrayList.add(vertexFormat);
            }
            if (this.createTexCoords) {
                vertexFormat = new VertexFormat();
                vertexFormat.addVertexAttribute(3, 2, 3, 0);
                arrayList.add(vertexFormat);
            }
        }
        return arrayList;
    }

    @Override
    protected int createIndexFormat() {
        return 1;
    }

    public void tesselateUniformGridMesh(float f2, float f3, int n, int n2) {
        int n3;
        int n4;
        int n5 = n * n2;
        int n6 = (n2 - 1) * (2 + 2 * n);
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n5 > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n5, 1);
        }
        if (n6 > meshBuilder.getMaxIndices()) {
            throw new InsufficientSpaceException(n6, 1);
        }
        boolean bl = false;
        Random random = null;
        float f4 = f2 / (float)n;
        float f5 = f3 / (float)n2;
        meshBuilder.beginGeometry(5, 0);
        for (n4 = 0; n4 < n2; ++n4) {
            for (n3 = 0; n3 < n; ++n3) {
                float f6;
                float f7;
                float f8 = (float)n3 * f4;
                float f9 = (float)n4 * f5;
                float f10 = 0.0f;
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(f8, f9, f10);
                if (this.createNormals) {
                    f7 = 0.0f;
                    f6 = 0.0f;
                    float f11 = 1.0f;
                    meshBuilder.setVertexNormal(0.0f, 0.0f, 1.0f);
                }
                if (this.createTexCoords) {
                    f7 = (float)(n3 + 1) / (float)n;
                    f6 = (float)(n4 + 1) / (float)n2;
                    meshBuilder.setVertexTextureCoordinate(0, f7, f6);
                }
                meshBuilder.endVertex();
            }
        }
        for (n4 = 0; n4 < n2 - 1; ++n4) {
            meshBuilder.addIndex((short)(n4 * n));
            for (n3 = 0; n3 < n; ++n3) {
                meshBuilder.addIndex((short)(n4 * n + n3));
                meshBuilder.addIndex((short)((n4 + 1) * n + n3));
            }
            meshBuilder.addIndex((short)((n4 + 1) * n + (n - 1)));
        }
        meshBuilder.endGeometry();
    }

    public void tesselateSolidSphereMesh(float f2, int n, int n2) {
        int n3;
        int n4 = (n + 1) * (n2 + 1);
        int n5 = n * n2 * 3 * 2;
        MeshBuilder meshBuilder = this.getMeshBuilder();
        if (n4 > meshBuilder.getMaxVertices()) {
            throw new InsufficientSpaceException(n4, 1);
        }
        if (n5 > meshBuilder.getMaxIndices()) {
            throw new InsufficientSpaceException(n5, 1);
        }
        meshBuilder.beginGeometry(5, 0);
        int n6 = -619722432 / (float)n2;
        for (n3 = 0; n3 <= n; ++n3) {
            float f3 = f2 * Util.sin(n6 * (float)n3);
            float f4 = f2 * Util.cos(n6 * (float)n3);
            for (int i2 = 0; i2 <= n2; ++i2) {
                float f5;
                float f6;
                float f7 = f3 * Util.sin(n6 * (float)i2);
                float f8 = f4;
                float f9 = f3 * Util.cos(n6 * (float)i2);
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(f7, f8, f9);
                if (this.createNormals) {
                    f6 = f7 / f2;
                    f5 = f8 / f2;
                    float f10 = f9 / f2;
                    meshBuilder.setVertexNormal(f6, f5, f10);
                }
                if (this.createTexCoords) {
                    f6 = (float)i2 / (float)n2;
                    f5 = (1.0f - (float)n3) / (float)(n - 1);
                    meshBuilder.setVertexTextureCoordinate(0, f6, f5);
                }
                meshBuilder.endVertex();
            }
        }
        for (n3 = 0; n3 < n; ++n3) {
            for (int i3 = 0; i3 < n2; ++i3) {
                meshBuilder.addIndex((short)(n3 * (n2 + 1) + i3));
                meshBuilder.addIndex((short)((n3 + 1) * (n2 + 1) + i3));
                meshBuilder.addIndex((short)((n3 + 1) * (n2 + 1) + (i3 + 1)));
                meshBuilder.addIndex((short)(n3 * (n2 + 1) + i3));
                meshBuilder.addIndex((short)((n3 + 1) * (n2 + 1) + (i3 + 1)));
                meshBuilder.addIndex((short)(n3 * (n2 + 1) + (i3 + 1)));
            }
        }
        meshBuilder.endGeometry();
    }
}


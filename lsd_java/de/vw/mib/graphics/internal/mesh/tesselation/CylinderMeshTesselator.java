/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh.tesselation;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.mesh.tesselation.AbstractMeshTesselator;
import java.util.List;

public final class CylinderMeshTesselator
extends AbstractMeshTesselator {
    public CylinderMeshTesselator(boolean bl, int n) {
        super(bl, n);
    }

    @Override
    protected List createVertexFormat(boolean bl) {
        throw new NotYetImplementedException();
    }

    @Override
    protected int createIndexFormat() {
        throw new UnsupportedOperationException();
    }
}


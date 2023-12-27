/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.surface;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.surface.SurfaceFormat;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractSurface
extends AbstractResource
implements Surface {
    private final int surfaceFormat;

    protected AbstractSurface(Graphics3D graphics3D, Logger logger, int n) {
        super(graphics3D, logger);
        this.surfaceFormat = n;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public final int getByteSize() {
        return SurfaceFormat.getSurfaceSize(this.surfaceFormat, this.getWidth(), this.getHeight());
    }

    @Override
    public final int getSurfaceFormat() {
        return this.surfaceFormat;
    }

    @Override
    public abstract int getWidth() {
    }

    @Override
    public abstract int getHeight() {
    }

    @Override
    public abstract void setSize(int n, int n2) {
    }
}


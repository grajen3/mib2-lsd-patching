/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Resource;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractResource
implements Resource {
    private Graphics3D g3d;
    private final Logger logger;
    private boolean disposed;

    public AbstractResource(Graphics3D graphics3D, Logger logger) {
        this.g3d = graphics3D;
        this.logger = logger;
        this.disposed = false;
    }

    @Override
    public void dispose() {
        if (this.disposed) {
            throw new IllegalStateException("Resource is already disposed");
        }
        this.disposed = true;
    }

    @Override
    public final Graphics3D getGraphics3D() {
        return this.g3d;
    }

    protected final void setGraphics3D(Graphics3D graphics3D) {
        this.g3d = graphics3D;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.remote.EntityBackRef;

public class AbstractRemoteFrontend
implements ITraceFrontendListener {
    private TraceFrontend frontend;
    private boolean doQuit;

    public AbstractRemoteFrontend(TraceFrontend traceFrontend) {
        this.frontend = traceFrontend;
        this.doQuit = false;
    }

    public boolean start() {
        this.frontend.registerListener(this);
        return true;
    }

    public void stop() {
        this.frontend.unregisterListener(this);
    }

    @Override
    public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
        EntityBackRef entityBackRef = (EntityBackRef)this.frontend.getAttachment(traceEntityURI);
        if (entityBackRef == null) {
            return;
        }
        entityBackRef.getHandler().requestFilterLevelExtUri(new TraceEntityURI(traceEntityURI.getType(), entityBackRef.getExtId()), s);
    }

    @Override
    public void executeCallback(int n, byte[] byArray) {
        EntityBackRef entityBackRef = (EntityBackRef)this.frontend.getAttachment(new TraceEntityURI(4, n));
        if (entityBackRef == null) {
            return;
        }
        entityBackRef.getHandler().executeCallbackExtUri(entityBackRef.getExtId(), byArray);
    }

    @Override
    public synchronized void requestQuit() {
        this.doQuit = true;
        super.notifyAll();
    }

    public synchronized boolean waitForQuit() {
        while (!this.doQuit) {
            try {
                super.wait();
            }
            catch (InterruptedException interruptedException) {
                return false;
            }
        }
        return true;
    }
}


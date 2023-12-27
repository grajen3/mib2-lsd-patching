/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.internal.LscControllerImpl;

class LscControllerImpl$1
implements Runnable {
    private final /* synthetic */ LscControllerImpl this$0;

    LscControllerImpl$1(LscControllerImpl lscControllerImpl) {
        this.this$0 = lscControllerImpl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LscControllerImpl.LOG.normal(2, "Start of LSC thread.");
        try {
            this.this$0.coordinateTheLsc();
        }
        catch (Exception exception) {
            LscControllerImpl.LOG.fatal(2, "LSC thread crashed.", exception);
        }
        finally {
            LscControllerImpl.LOG.normal(2, "End of LSC thread.");
        }
    }
}


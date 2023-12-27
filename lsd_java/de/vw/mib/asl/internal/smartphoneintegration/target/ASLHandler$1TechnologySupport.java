/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler;

class ASLHandler$1TechnologySupport {
    private boolean hardware = false;
    private boolean software = false;
    private final /* synthetic */ ASLHandler this$0;

    public ASLHandler$1TechnologySupport(ASLHandler aSLHandler) {
        this.this$0 = aSLHandler;
    }

    boolean isSupportedByHardware() {
        return this.hardware;
    }

    void setHardwareSupport(boolean bl) {
        this.hardware = bl;
    }

    boolean isSupportedBySoftware() {
        return this.software;
    }

    void setSoftwareSupport(boolean bl) {
        this.software = bl;
    }
}


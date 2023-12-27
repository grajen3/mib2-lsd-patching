/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.log4mib.LogMessage;

public abstract class PPoiAbstractHsmTarget
extends AbstractResettableAslHsmTarget {
    public PPoiAbstractHsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    public PPoiAbstractHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    public void myTrace(AbstractHsmState abstractHsmState, String string) {
        if (!this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            return;
        }
        String string2 = "";
        if (abstractHsmState != null) {
            string2 = super.getClass().toString();
            string2 = string2.substring(string2.lastIndexOf(46) + 1);
        }
        this.trace().append("[PPoiHsmTarget]  State:").append(string2).append("  - ").append(string).log();
    }

    public LogMessage makeTrace(AbstractHsmState abstractHsmState) {
        String string = "";
        if (abstractHsmState != null) {
            string = super.getClass().toString();
            string = string.substring(string.lastIndexOf(46) + 1);
        }
        return this.trace().append("[PPoiHsmTarget]  State:").append(string).append("  - ");
    }

    public LogMessage makeError(AbstractHsmState abstractHsmState) {
        String string = "";
        if (abstractHsmState != null) {
            string = super.getClass().toString();
            string = string.substring(string.lastIndexOf(46) + 1);
        }
        return this.error().append("[PPoiHsmTarget]  State:").append(string).append("  - ");
    }

    public void myError(AbstractHsmState abstractHsmState, String string) {
        if (!this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            return;
        }
        String string2 = "";
        if (abstractHsmState != null) {
            string2 = super.getClass().toString();
            string2 = string2.substring(string2.lastIndexOf(46) + 1);
        }
        this.error().append("[PPoiHsmTarget]  State:").append(string2).append("  - ").append(string).log();
    }
}


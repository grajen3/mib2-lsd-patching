/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace;

import de.vw.mib.asl.internal.testmode.helper.trace.LogClassifier;
import de.vw.mib.log4mib.LogManagerDiagListener;

public class LogSubClassifier {
    private LogClassifier mParent = null;
    private final int mId;
    private final String mName;
    private boolean mActive = false;

    public LogSubClassifier(LogClassifier logClassifier, int n, String string, boolean bl) {
        this.mParent = logClassifier;
        this.mId = n;
        this.mName = string;
        this.mActive = bl;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        if (this.mName != null) {
            return this.mName;
        }
        return "null";
    }

    public boolean isActive() {
        return this.mActive;
    }

    public void setActive(boolean bl) {
        this.mActive = bl;
    }

    public void toggleState(LogManagerDiagListener logManagerDiagListener) {
        this.mActive = !this.mActive;
        this.mParent.updateSubClassifierMask(logManagerDiagListener);
    }
}


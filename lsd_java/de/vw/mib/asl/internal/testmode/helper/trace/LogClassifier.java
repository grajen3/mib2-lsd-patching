/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace;

import de.vw.mib.asl.internal.testmode.TestmodeServiceManagerImpl;
import de.vw.mib.asl.internal.testmode.helper.trace.LogRoot;
import de.vw.mib.asl.internal.testmode.helper.trace.LogSubClassifier;
import de.vw.mib.asl.internal.testmode.helper.trace.TraceHelper;
import de.vw.mib.log4mib.LogManagerDiagListener;

public final class LogClassifier {
    private final String mName;
    private final int mId;
    private LogSubClassifier[] mSubClassifierInfoArray = null;

    public LogClassifier(LogRoot logRoot, int n, String string) {
        this.mName = string;
        this.mId = n;
    }

    public String getName() {
        if (this.mName != null) {
            return this.mName;
        }
        return "null";
    }

    public int getId() {
        return this.mId;
    }

    public LogSubClassifier[] getSubClassifierInfoArray() {
        if (this.mSubClassifierInfoArray == null) {
            String[] stringArray = TraceHelper.getSubClassifierNames(this.mId);
            int n = TraceHelper.getSubClassifierMask(this.mId);
            this.mSubClassifierInfoArray = new LogSubClassifier[stringArray.length];
            int n2 = -1;
            boolean bl = false;
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                n2 = 1 << i2;
                bl = (n2 & n) != 0;
                this.mSubClassifierInfoArray[i2] = new LogSubClassifier(this, n2, stringArray[i2], bl);
            }
        }
        return this.mSubClassifierInfoArray;
    }

    public void updateSubClassifierMask(LogManagerDiagListener logManagerDiagListener) {
        int n = 0;
        for (int i2 = 0; i2 < this.mSubClassifierInfoArray.length; ++i2) {
            if (!this.mSubClassifierInfoArray[i2].isActive()) continue;
            n += this.mSubClassifierInfoArray[i2].getId();
        }
        TraceHelper.setSubClassifierMask(this.mId, n);
        TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().updateLogManagerDiagListener(logManagerDiagListener);
    }
}


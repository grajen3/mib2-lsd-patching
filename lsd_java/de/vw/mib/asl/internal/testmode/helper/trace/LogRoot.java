/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.testmode.TestmodeServiceManagerImpl;
import de.vw.mib.asl.internal.testmode.helper.trace.LogClassifier;
import de.vw.mib.asl.internal.testmode.helper.trace.TraceHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogManagerDiagListener;

public class LogRoot
implements LogManagerDiagListener {
    private LogClassifier[] mClassifierInfoArray;

    public LogRoot() {
        this.initClassifierNameList();
        TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().registerLogManagerDiagListener(this);
    }

    private void initClassifierNameList() {
        int[] nArray = TraceHelper.getClassifierIds();
        String[] stringArray = TraceHelper.getClassifierNames();
        this.mClassifierInfoArray = new LogClassifier[stringArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.mClassifierInfoArray[i2] = new LogClassifier(this, nArray[i2], stringArray[i2]);
        }
    }

    public LogClassifier[] getClassifierInfoArray() {
        return this.mClassifierInfoArray;
    }

    public void toggleMainLoggingState() {
        TraceHelper.setLoggingEnabled(!TraceHelper.isLoggingEnabled());
    }

    public boolean getMainLoggingState() {
        return TraceHelper.isLoggingEnabled();
    }

    public boolean getTcpSinkState() {
        return TraceHelper.getTcpSinkState();
    }

    public void toggleTcpSinkState() {
        TraceHelper.setTcpSinkState(!this.getTcpSinkState());
    }

    public boolean getFileSinkState() {
        return TraceHelper.getFileSinkState();
    }

    public void toggleFileSinkState() {
        TraceHelper.setFileSinkState(!this.getFileSinkState());
    }

    public boolean getSerialSinkState() {
        return TraceHelper.getSerialSinkState();
    }

    public void toggleSerialSinkState() {
        TraceHelper.setSerialSinkState(!this.getSerialSinkState());
    }

    @Override
    public void logMangerSettingsUpdated() {
        this.initClassifierNameList();
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setInt(0, -3);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1115101952, eventGeneric);
    }
}


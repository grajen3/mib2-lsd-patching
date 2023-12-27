/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.diag;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.diag.DiagnoseDatapoolObserver$1;

public interface DiagnoseDatapoolObserver {
    public static final DiagnoseDatapoolObserver EMPTY_OBSERVER = new DiagnoseDatapoolObserver$1();
    public static final byte STEP_VALUE_CHANGE_REQUEST;
    public static final byte STEP_VALUE_CHANGED_AND_NOTIFY_OBSERVERS;
    public static final byte STEP_VALUE_CHANGED_NO_OBSERVERS;
    public static final byte STEP_VALUE_CHANGED_DIRECT_AND_NOTIFY_OBSERVERS;
    public static final byte STEP_VALUE_CHANGED_DIRECT_NO_OBSERVERS;

    default public void datapoolUpdate(byte by, int n, int n2, AppDefinition appDefinition, String string) {
    }

    default public void dirtyDatapool(int n, AppDefinition appDefinition) {
    }
}


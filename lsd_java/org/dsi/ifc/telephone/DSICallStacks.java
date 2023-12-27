/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;

public interface DSICallStacks
extends DSIBase {
    public static final String VERSION;
    public static final int RT_DELETEALL;
    public static final int RT_DELETEENTRY;
    public static final int RT_RESETMISSEDCALLINDICATOR;
    public static final int RT_REVERTCALLSTACKS;
    public static final int ATTR_ISREVERTED;
    public static final int ATTR_LASTANSWEREDNUMBERS;
    public static final int ATTR_LASTDIALEDNUMBERS;
    public static final int ATTR_MISSEDNUMBERS;
    public static final int ATTR_MEDATAVALIDITY;
    public static final int ATTR_MISSEDCALLINDICATOR;
    public static final int CALLSTACKS_LD;
    public static final int CALLSTACKS_RC;
    public static final int CALLSTACKS_MC;
    public static final int CALLSTACKS_ALL;
    public static final int DATAVALIDITY_DATAVALID;
    public static final int DATAVALIDITY_DATAINVALID;
    public static final int CALLSTACKORIGIN_ME;
    public static final int CALLSTACKORIGIN_MU;

    default public void deleteAll(int n) {
    }

    default public void deleteEntry(int n, int n2) {
    }

    default public void resetMissedCallIndicator() {
    }

    default public void revertCallstacks(boolean bl) {
    }
}


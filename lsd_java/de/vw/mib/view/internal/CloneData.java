/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.widgets.interfaces.WidgetCloneData;
import de.vw.mib.widgets.models.WidgetModel;

public class CloneData
implements WidgetCloneData {
    public static final int ROOT_MASTER_ID;
    public CloneData next;
    public CloneData master;
    public final WidgetModel[] widgets;
    public final int masterId;

    public CloneData(int n, int n2) {
        Preconditions.checkArgument(n >= 1, "CloneDate has to contains at least one widget.");
        this.widgets = new WidgetModel[n];
        this.masterId = n2;
        this.master = this;
    }

    public static void add(CloneData cloneData, CloneData cloneData2) {
        if (cloneData != null) {
            cloneData2.next = cloneData.next;
            cloneData.next = cloneData2;
            cloneData2.master = cloneData;
        }
    }

    public static void remove(CloneData cloneData, CloneData cloneData2) {
        CloneData cloneData3 = cloneData;
        while (cloneData3 != null) {
            if (cloneData3.next == cloneData2) {
                cloneData3.next = cloneData2.next;
                cloneData2.next = null;
                return;
            }
            cloneData3 = cloneData3.next;
        }
    }
}


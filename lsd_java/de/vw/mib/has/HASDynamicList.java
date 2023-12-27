/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASList;

public interface HASDynamicList
extends HASList {
    default public void setSize(int n) {
    }

    default public void refresh(int n, int n2) {
    }

    default public HASList disableFetching() {
    }
}


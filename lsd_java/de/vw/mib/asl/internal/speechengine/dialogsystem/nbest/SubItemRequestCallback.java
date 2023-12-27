/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.nbest;

import org.dsi.ifc.speechrec.NBestList;

public interface SubItemRequestCallback {
    default public void getSubItemsResponse(int n, NBestList nBestList) {
    }
}


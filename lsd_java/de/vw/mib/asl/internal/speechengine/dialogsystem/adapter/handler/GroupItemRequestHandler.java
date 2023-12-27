/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import org.dsi.ifc.speechrec.NBestList;

public interface GroupItemRequestHandler {
    default public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
    }
}


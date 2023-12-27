/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.nbest;

import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequestCallback;

public interface SubItemRequest {
    default public void getSubItems(int n, SubItemRequestCallback subItemRequestCallback) {
    }
}


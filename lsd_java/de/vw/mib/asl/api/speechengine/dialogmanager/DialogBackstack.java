/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstackListener;

public interface DialogBackstack {
    default public void back() {
    }

    default public void clear() {
    }

    default public void register(DialogBackstackListener dialogBackstackListener) {
    }

    default public void unregister(DialogBackstackListener dialogBackstackListener) {
    }

    default public void push(DialogBackHandler dialogBackHandler) {
    }
}


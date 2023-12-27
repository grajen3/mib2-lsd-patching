/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back;

import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStack;

public interface BackStackListener {
    default public void onBackStackChanged(BackStack backStack) {
    }
}


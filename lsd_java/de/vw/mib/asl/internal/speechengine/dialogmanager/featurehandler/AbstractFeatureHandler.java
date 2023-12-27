/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;

public abstract class AbstractFeatureHandler
implements FeatureHandler {
    @Override
    public boolean handleDone() {
        return false;
    }

    @Override
    public boolean updateDone() {
        return false;
    }
}


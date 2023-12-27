/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;

public class PopupActivatingGlobalProfileChangeListener
implements GlobalProfileChangeListener {
    private static final boolean SHOW;
    private static final boolean HIDE;
    private final ASLPropertyManager aslPropertyManager;

    public PopupActivatingGlobalProfileChangeListener(ASLPropertyManager aSLPropertyManager, AslPersistenceSyncApi aslPersistenceSyncApi) {
        this.aslPropertyManager = aSLPropertyManager;
        this.installPopup(aslPersistenceSyncApi.isProfileChangeRunning());
    }

    @Override
    public void onProfileChangeStarted() {
        this.installPopup(true);
    }

    @Override
    public void onProfileChangeCompleted() {
        this.installPopup(false);
    }

    private void installPopup(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(1244798976, bl);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.api.system.SharedSystemCommonPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.system.SharedSystemCommonPersistenceImpl$1;
import de.vw.mib.asl.internal.impl.system.SharedSystemCommonPersistenceImpl$2;
import de.vw.mib.asl.internal.impl.system.SharedSystemCommonPersistenceImpl$3;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SharedSystemCommonPersistenceImpl
implements SharedSystemCommonPersistence {
    private final SystemCommonPersistenceService systemCommonPersistenceService;
    private final Set childListeners = new HashSet();
    private final Set pendingCallbacks = new HashSet();
    private SystemCommon systemCommon;
    private AbstractProfileChangeHandler profileChangeListener;

    public SharedSystemCommonPersistenceImpl(SystemCommonPersistenceService systemCommonPersistenceService) {
        this.systemCommonPersistenceService = systemCommonPersistenceService;
        this.profileChangeListener = this.createProfileChangeListener();
        this.systemCommonPersistenceService.addProfileChangeListener(this.profileChangeListener);
    }

    @Override
    public void addProfileChangeListener(ProfileChangeListener profileChangeListener) {
        this.childListeners.add(profileChangeListener);
    }

    @Override
    public long getBitfieldLanguagesThatWereSetBefore() {
        this.assureDataIsLoaded();
        return this.systemCommon.getBitfieldLanguagesThatWereSetBefore();
    }

    @Override
    public int getDisplayBrigtness() {
        this.assureDataIsLoaded();
        return this.systemCommon.getDisplayBrightness();
    }

    @Override
    public boolean isAcousticTouchscreenFeedback() {
        this.assureDataIsLoaded();
        return this.systemCommon.isAcousticTouchscreenFeedback();
    }

    @Override
    public void setAcousticTouchscreenFeedback(boolean bl) {
        this.assureDataIsLoaded();
        this.systemCommon.setAcousticTouchscreenFeedback(bl);
    }

    @Override
    public void setBitfieldLanguagesThatWereSetBefore(long l) {
        this.assureDataIsLoaded();
        this.systemCommon.setBitfieldLanguagesThatWereSetBefore(l);
    }

    @Override
    public void setDisplayBrightness(int n) {
        this.assureDataIsLoaded();
        this.systemCommon.setDisplayBrightness(n);
    }

    void unloadData() {
        this.systemCommon = null;
    }

    void prepareProfileChangeForChildListeners() {
        if (this.childListeners.isEmpty()) {
            this.profileChangeListener.notifyReadyForProfileSwitch();
        } else {
            this.pendingCallbacks.addAll(this.childListeners);
            Iterator iterator = this.childListeners.iterator();
            while (iterator.hasNext()) {
                ProfileChangeListener profileChangeListener = (ProfileChangeListener)iterator.next();
                profileChangeListener.prepareForProfileChange(this.createPreparationCallback(profileChangeListener));
            }
        }
    }

    void changeProfileForChildListeners() {
        if (this.childListeners.isEmpty()) {
            this.profileChangeListener.notifyProfileChanged(true);
        } else {
            this.pendingCallbacks.addAll(this.childListeners);
            Iterator iterator = this.childListeners.iterator();
            while (iterator.hasNext()) {
                ProfileChangeListener profileChangeListener = (ProfileChangeListener)iterator.next();
                profileChangeListener.changeProfile(this.createProfileChangeCallback(profileChangeListener));
            }
        }
    }

    void onReadyForProfileChangeCallback(ProfileChangeListener profileChangeListener) {
        this.pendingCallbacks.remove(profileChangeListener);
        if (this.pendingCallbacks.isEmpty()) {
            this.profileChangeListener.notifyReadyForProfileSwitch();
        }
    }

    void onProfileChangeCallback(ProfileChangeListener profileChangeListener) {
        this.pendingCallbacks.remove(profileChangeListener);
        if (this.pendingCallbacks.isEmpty()) {
            this.profileChangeListener.notifyProfileChanged(true);
        }
    }

    private ProfileChangeCallback createPreparationCallback(ProfileChangeListener profileChangeListener) {
        return new SharedSystemCommonPersistenceImpl$1(this, profileChangeListener);
    }

    private ProfileChangeCallback createProfileChangeCallback(ProfileChangeListener profileChangeListener) {
        return new SharedSystemCommonPersistenceImpl$2(this, profileChangeListener);
    }

    private void assureDataIsLoaded() {
        if (this.systemCommon == null) {
            this.systemCommon = this.systemCommonPersistenceService.loadSystemCommon();
        }
    }

    private AbstractProfileChangeHandler createProfileChangeListener() {
        return new SharedSystemCommonPersistenceImpl$3(this);
    }
}


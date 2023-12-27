/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.state;

import de.vw.mib.asl.api.itunes.ASLItunesTargetIds;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.itunes.ITunesHandler;
import de.vw.mib.asl.internal.itunes.state.ITunesStateActive;
import de.vw.mib.asl.internal.itunes.state.ITunesStateDeviceConnected;
import de.vw.mib.asl.internal.itunes.state.ITunesStateDeviceConnectedIdle;
import de.vw.mib.asl.internal.itunes.state.ITunesStateDeviceConnectedTransfering;
import de.vw.mib.asl.internal.itunes.state.ITunesStateDeviceNotConnected;
import de.vw.mib.asl.internal.itunes.state.ITunesStateDeviceNotConnectedIdle;
import de.vw.mib.asl.internal.itunes.state.ITunesStateDeviceNotConnectedProcessing;
import de.vw.mib.asl.internal.itunes.state.ITunesStateTop;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.media.DSIRadioTaggingListener;

public class ITunesTarget
extends AbstractASLHsmTarget {
    final HsmState mStateTop;
    final HsmState mStateActive;
    final HsmState mStateDeviceConnected;
    final HsmState mStateDeviceNotConnected;
    final HsmState mStateDeviceConnectedIdle;
    final HsmState mStateDeviceConnectedTransfering;
    final HsmState mStateDeviceNotConnectedIdle;
    final HsmState mStateDeviceNotConnectedProcessing;
    private DSIRadioTagging dsiRadioTagging;
    private DSIRadioTaggingListener dsiRadioTaggingListener;
    protected boolean processing;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTagging;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTaggingListener;

    public ITunesTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.mStateTop = new ITunesStateTop(this, this.hsm, "stateTop", this.getWorkStateParent());
        this.mStateActive = new ITunesStateActive(this, this.hsm, "stateActive", this.mStateTop);
        this.mStateDeviceConnected = new ITunesStateDeviceConnected(this, this.hsm, "stateDeviceConnected", this.mStateActive);
        this.mStateDeviceNotConnected = new ITunesStateDeviceNotConnected(this, this.hsm, "stateDeviceNotConnected", this.mStateActive);
        this.mStateDeviceConnectedIdle = new ITunesStateDeviceConnectedIdle(this, this.hsm, "stateDeviceConnectedIdle", this.mStateDeviceConnected);
        this.mStateDeviceConnectedTransfering = new ITunesStateDeviceConnectedTransfering(this, this.hsm, "stateDeviceConnectedTransfering", this.mStateDeviceConnected);
        this.mStateDeviceNotConnectedIdle = new ITunesStateDeviceNotConnectedIdle(this, this.hsm, "stateDeviceNotConnectedIdle", this.mStateDeviceNotConnected);
        this.mStateDeviceNotConnectedProcessing = new ITunesStateDeviceNotConnectedProcessing(this, this.hsm, "stateDeviceNotConnectedProcessing", this.mStateDeviceNotConnected);
        this.dsiRadioTagging = null;
        this.dsiRadioTaggingListener = null;
        this.processing = false;
        this.hsm.verbose = false;
    }

    @Override
    public int getDefaultTargetId() {
        return ASLItunesTargetIds.ASL_ITUNES_TARGET;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.mStateTop;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 8192;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    public void initializeDSI() {
        this.dsiRadioTagging = (DSIRadioTagging)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$media$DSIRadioTagging == null ? (class$org$dsi$ifc$media$DSIRadioTagging = ITunesTarget.class$("org.dsi.ifc.media.DSIRadioTagging")) : class$org$dsi$ifc$media$DSIRadioTagging);
        this.dsiRadioTaggingListener = (DSIRadioTaggingListener)AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$media$DSIRadioTaggingListener == null ? (class$org$dsi$ifc$media$DSIRadioTaggingListener = ITunesTarget.class$("org.dsi.ifc.media.DSIRadioTaggingListener")) : class$org$dsi$ifc$media$DSIRadioTaggingListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$media$DSIRadioTaggingListener == null ? (class$org$dsi$ifc$media$DSIRadioTaggingListener = ITunesTarget.class$("org.dsi.ifc.media.DSIRadioTaggingListener")) : class$org$dsi$ifc$media$DSIRadioTaggingListener, this.dsiRadioTaggingListener);
        ITunesHandler.setTarget(this);
    }

    public void setNotifications() {
        this.dsiRadioTagging.setNotification(new int[]{1}, (DSIListener)this.dsiRadioTaggingListener);
    }

    public void registerObservers() {
        this.addObserver(-576847872);
        this.addObserver(-442630144);
        this.addObserver(-409075712);
        this.addObserver(-543293440);
        this.addObserver(-526516224);
    }

    public DSIRadioTagging getDSIRadioTagging() {
        return this.dsiRadioTagging;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer$1;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer;
import de.vw.mib.asl.internal.pictureviewer.StateHMIBrowser;
import de.vw.mib.asl.internal.pictureviewer.StateIdle;
import de.vw.mib.asl.internal.pictureviewer.StateShowLastActivePicture;
import de.vw.mib.asl.internal.pictureviewer.StateTop;
import de.vw.mib.asl.internal.pictureviewer.browser.AbstractPictureViewerBrowser;
import de.vw.mib.asl.internal.pictureviewer.browser.HMIPictureViewerBrowser;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public final class HsmTargetPictureViewer
extends AbstractASLHsmTarget {
    private final PictureViewer _pictureViewer;
    private final StateTop statePictureViewerTop;
    private final StateIdle stateIdle;
    private final StateShowLastActivePicture stateShowLastActivePicture;
    private final StateHMIBrowser stateHMIBrowser;
    private final AbstractPictureViewerBrowser _browser;
    private final String _classname = super.getClass().getName();
    static /* synthetic */ Class class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService;

    public HsmTargetPictureViewer(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".HsmTargetPictureViewer()").log();
        }
        this.statePictureViewerTop = new StateTop(this, this.hsm, "StateTop", this.getWorkStateParent());
        this.stateIdle = new StateIdle(this, this.hsm, "StateIdle", this.statePictureViewerTop);
        this.stateShowLastActivePicture = new StateShowLastActivePicture(this, this.hsm, "StateShowLastActivePicture", this.stateIdle);
        this.stateHMIBrowser = new StateHMIBrowser(this, this.hsm, "StateHMIBrowser", this.stateIdle);
        this._pictureViewer = new PictureViewer(this);
        this._browser = new HMIPictureViewerBrowser(this);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService == null ? (class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService = HsmTargetPictureViewer.class$("de.vw.mib.asl.api.pictureviewer.services.PictureViewerControlService")) : class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService, new HsmTargetPictureViewer$1(this));
    }

    @Override
    public int getDefaultTargetId() {
        return -1863904256;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 128;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.statePictureViewerTop;
    }

    public PictureViewer getPictureViewer() {
        return this._pictureViewer;
    }

    public AbstractPictureViewerBrowser getBrowser() {
        return this._browser;
    }

    public void transToIdle() {
        try {
            this.getHsm().trans(this.stateIdle);
        }
        catch (Exception exception) {
            this.error("exception in transToIdle");
        }
    }

    public boolean isLastSource() {
        return this.stateShowLastActivePicture.isLastSource();
    }

    public void transToStateShowLastActivePicture(boolean bl, PictureSourceInfo pictureSourceInfo) {
        this.stateShowLastActivePicture.setLastSource(bl);
        this.stateShowLastActivePicture.setLastPictureSourceInfo(pictureSourceInfo);
        if (this.stateShowLastActivePicture.isValid()) {
            try {
                this.getHsm().trans(this.stateShowLastActivePicture);
            }
            catch (Exception exception) {
                this.error(exception);
            }
        } else {
            this.trace("gracefully suppressed transition to stateShowLastActivePicture");
            this.getPictureViewer().resetSource();
            try {
                this.getHsm().trans(this.stateIdle);
            }
            catch (Exception exception) {
                this.error(exception);
            }
        }
    }

    public void resetRestorePicture() {
        this.stateShowLastActivePicture.setLastSource(false);
    }

    public void transToStateHMIBrowser() {
        try {
            this.getHsm().trans(this.stateHMIBrowser);
        }
        catch (Exception exception) {
            this.error("exception in transToStateHMIBrowser");
        }
    }

    public void receiveEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getSenderTargetId() == -1058336256 && this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".receiveEvent() from ASL_FILEBROWSER_TARGET: ").append(eventGeneric.toString()).log();
        }
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


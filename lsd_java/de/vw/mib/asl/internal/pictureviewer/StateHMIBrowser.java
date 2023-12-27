/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateHMIBrowser
extends AbstractHsmState {
    private final HsmTargetPictureViewer _target;
    private final String _classname = super.getClass().getName();

    public StateHMIBrowser(HsmTargetPictureViewer hsmTargetPictureViewer, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = hsmTargetPictureViewer;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append(this._classname).append(".handle(HSM_ENTRY)").log();
                break;
            }
            case 4: {
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append(this._classname).append(".handle(HSM_EXIT)").log();
                break;
            }
            case 1073742911: {
                this.restorePicture();
                this._target.getBrowser().handleClosingBrowser();
                break;
            }
            case 0x40000441: {
                this._target.getBrowser().handleDisplayPicture(eventGeneric.getInt(0));
                this._target.transToIdle();
                break;
            }
            case 0x40000444: {
                this._target.getBrowser().handleOpenFolder(eventGeneric.getInt(0));
                break;
            }
            case 0x40000443: {
                this._target.getBrowser().handleMoveFolderUp(eventGeneric);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void restorePicture() {
        FileBrowserSourceInfo fileBrowserSourceInfo;
        PictureSourceInfo pictureSourceInfo = this._target.getBrowser().getPictureSourceInfoBeforeBrowsing();
        if (pictureSourceInfo != null && (fileBrowserSourceInfo = this._target.getPictureViewer().checkFileBrowserSourceInfo(pictureSourceInfo.getHMISourceId(), pictureSourceInfo.getUniqueMediaID())) != null && this.isPictureViewerAvailable(fileBrowserSourceInfo, pictureSourceInfo)) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append("StateHMIBrowser.handle()/ASLPictureViewerServiceConstants.CLOSING_BROWSER: picture.path=").append(pictureSourceInfo).append(" sourceInfo.active.mountPoint=").append(fileBrowserSourceInfo.getActiveMedium().mountPoint).log();
            }
            this._target.getPictureViewer().getPictureFile().restoreFromSettings();
            this._target.getBrowser().activateSource(fileBrowserSourceInfo, fileBrowserSourceInfo.getPartitionByUniqueMediaID(pictureSourceInfo.getUniqueMediaID()));
            this._target.transToStateShowLastActivePicture(true, pictureSourceInfo);
        }
    }

    private boolean isPictureViewerAvailable(FileBrowserSourceInfo fileBrowserSourceInfo, PictureSourceInfo pictureSourceInfo) {
        return fileBrowserSourceInfo.getDevice().getMedium(fileBrowserSourceInfo.getPartitionByUniqueMediaID(pictureSourceInfo.getUniqueMediaID())).getCurrentState().isPictureViewerAvailable();
    }
}


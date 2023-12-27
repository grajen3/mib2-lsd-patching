/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateIdle
extends AbstractHsmState {
    private final HsmTargetPictureViewer _target;
    private final String _classname = super.getClass().getName();

    public StateIdle(HsmTargetPictureViewer hsmTargetPictureViewer, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = hsmTargetPictureViewer;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".handle(HSM_ENTRY)").log();
                }
                this._target.getPictureViewer().displaySettings();
                break;
            }
            case 4: {
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append(this._classname).append(".handle(HSM_EXIT)").log();
                break;
            }
            case 0x40000445: {
                this._target.getBrowser().handleOpeningBrowser();
                this._target.getBrowser().storePicture();
                this._target.transToStateHMIBrowser();
                break;
            }
            case 1073742911: {
                this._target.getBrowser().handleClosingBrowser();
                break;
            }
            case 1073744338: {
                this._target.getBrowser().handleActivateBrowsingSource(eventGeneric.getInt(0));
                break;
            }
            case 1073742910: {
                this._target.getBrowser().storePicture();
                this._target.resetRestorePicture();
                this._target.getBrowser().handleActivateSource(eventGeneric.getInt(0));
                break;
            }
            case 0x40000440: {
                this._target.getPictureViewer().handleDisplayNextPicture();
                break;
            }
            case 0x40000442: {
                this._target.getPictureViewer().handleDisplayPreviousPicture();
                break;
            }
            case 0x40000446: {
                this._target.getPictureViewer().handleSetZoomLevel(eventGeneric);
                break;
            }
            case 0x40000447: {
                this._target.getPictureViewer().handleSetSlideShowMode(eventGeneric);
                break;
            }
            case 0x40000449: {
                this._target.getPictureViewer().handleToggleSlideshowRepeatState();
                break;
            }
            case 0x40000448: {
                this._target.getPictureViewer().handleSetSlideShowTimer(eventGeneric);
                break;
            }
            case 4300050: {
                this._target.getPictureViewer().handleSpeedDisclaimerShown(eventGeneric);
                break;
            }
            default: {
                if (this._target.getBrowser().receive(eventGeneric)) break;
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


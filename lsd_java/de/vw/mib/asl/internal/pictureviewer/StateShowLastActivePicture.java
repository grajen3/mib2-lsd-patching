/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;

public class StateShowLastActivePicture
extends AbstractHsmState {
    private final HsmTargetPictureViewer _target;
    private boolean _bLastSource = false;
    private final String _classname = super.getClass().getName();
    private PictureSourceInfo _lastPictureSourceInfo = null;
    private boolean gotSourceList;

    public StateShowLastActivePicture(HsmTargetPictureViewer hsmTargetPictureViewer, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = hsmTargetPictureViewer;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".StateShowLastActivePicture()").log();
        }
    }

    public PictureSourceInfo getLastPictureSourceInfo() {
        return this._lastPictureSourceInfo;
    }

    public void setLastPictureSourceInfo(PictureSourceInfo pictureSourceInfo) {
        this._lastPictureSourceInfo = pictureSourceInfo;
    }

    public boolean isLastSource() {
        return this._bLastSource;
    }

    boolean isValid() {
        return this.getLastPictureSourceInfo() != null && this.getLastPictureSourceInfo().getPictureIndex() != -1;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.gotSourceList = false;
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".handle(HSM_ENTRY): ").append(this.getLastPictureSourceInfo()).log();
                }
                if (this.isValid()) break;
                this._target.error("unexpected Transition to idle in HSM_ENTRY!");
                this._target.getPictureViewer().resetSource();
                this._target.transToIdle();
                break;
            }
            case 4: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".handle(HSM_EXIT)").log();
                }
                this.setLastPictureSourceInfo(null);
                break;
            }
            case 2500016: {
                if (this.gotSourceList) break;
                this.gotSourceList = true;
                this._target.getBrowser().handleUpdateSourceList((FileBrowserSourceList)eventGeneric.getObject(0));
                FileBrowserSourceInfo fileBrowserSourceInfo = this._target.getPictureViewer().checkLastActiveSource();
                if (fileBrowserSourceInfo != null) {
                    this._bLastSource = true;
                    int n = fileBrowserSourceInfo.getPartitionByUniqueMediaID(this._target.getPictureViewer().getSettings().getUniqueMediaID());
                    this._target.getBrowser().activateSource(fileBrowserSourceInfo, n);
                    break;
                }
                this._bLastSource = false;
                this._target.getPictureViewer().resetSource();
                this._target.transToIdle();
                break;
            }
            case 2500029: {
                this._target.receiveEvent(eventGeneric);
                boolean bl = eventGeneric.getBoolean(1);
                this._target.getBrowser().responseOpenDirectoryAbsoluteByPath(bl, (Path)eventGeneric.getObject(2));
                if (bl) break;
                this._target.transToIdle();
                this._target.getBrowser().requestStopSession();
                break;
            }
            case 2500030: {
                this._target.receiveEvent(eventGeneric);
                this._target.getBrowser().getFileCountResult(eventGeneric.getBoolean(1), eventGeneric.getInt(2));
                if (this._target.getPictureViewer().getPictureFile().getElementIndex() != this._lastPictureSourceInfo.getPictureIndex()) {
                    this._target.error("LSM would not have worked!");
                }
                if (this._target.getPictureViewer().getListSize() >= this._lastPictureSourceInfo.getPictureIndex()) break;
                this._target.getBrowser().requestStopSession();
                this._target.transToIdle();
                break;
            }
            case 2500024: {
                this._target.receiveEvent(eventGeneric);
                this._target.getBrowser().getViewWindowResult(eventGeneric.getBoolean(1), eventGeneric.getInt(2), (BrowsedFileSet)eventGeneric.getObject(3));
                if (this._target.getPictureViewer().getPictureFile().getElementIndex() != this._lastPictureSourceInfo.getPictureIndex()) {
                    this._target.error("LSM would not have worked!");
                }
                if (!this._target.getPictureViewer().checkLastActivePicture(this._lastPictureSourceInfo.getPictureIndex())) {
                    this._target.getBrowser().requestStopSession();
                }
                this._target.transToIdle();
                break;
            }
            case 2500031: {
                this._target.receiveEvent(eventGeneric);
                String[] stringArray = this._target.getPictureViewer().getPictureFile().getPath();
                Path path = new Path("", stringArray);
                this._target.getBrowser().handleSetContentFilterResult(eventGeneric.getBoolean(1), path);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void setLastSource(boolean bl) {
        this._bLastSource = bl;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer$Reset;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateTop
extends AbstractHsmState {
    private final HsmTargetPictureViewer _target;
    private final String _classname = super.getClass().getName();

    StateTop(HsmTargetPictureViewer hsmTargetPictureViewer, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = hsmTargetPictureViewer;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".handle(HSM_ENTRY)").log();
                }
                ServiceManager.persistence.registerSharedPersistable(this._target.getPictureViewer().getSettings());
                ServiceManager.persistence.loadPersistable(5007, 0, this._target.getPictureViewer().getSettings());
                ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new PictureViewer$Reset(this._target.getPictureViewer()), FactoryResetComponents.MEDIA);
                this._target.getPictureViewer().getHmiNotifier().notifyPictureDisplayed(true);
                this._target.getPictureViewer().getPictureFile().restoreFromSettings();
                this._target.transToStateShowLastActivePicture(false, this._target.getPictureViewer().getSettings().getPictureSourceInfo());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


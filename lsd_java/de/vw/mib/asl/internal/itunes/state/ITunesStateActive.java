/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.state;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.ITunesHandler;
import de.vw.mib.asl.internal.itunes.state.ITunesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.media.TagInformation;

public final class ITunesStateActive
extends AbstractHsmState {
    private final ITunesTarget mTarget;
    private int deviceConnected = 0;

    ITunesStateActive(ITunesTarget iTunesTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = iTunesTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                if (this.deviceConnected == 1) {
                    this.trans(this.mTarget.mStateDeviceConnected);
                    break;
                }
                this.trans(this.mTarget.mStateDeviceNotConnected);
                break;
            }
            case 4: {
                break;
            }
            case 40669: {
                int n = eventGeneric.getInt(0);
                ITunesHandler.getITunesController().loadItunesDatabase(n);
                break;
            }
            case 40677: {
                int n = eventGeneric.getInt(0);
                ITunesHandler.getITunesController().resetSettings(n);
                break;
            }
            case 40679: {
                ITunesHandler.getITunesController().resetAll();
                break;
            }
            case 40662: {
                int n = eventGeneric.getInt(0);
                ITunesHandler.getITunesController().sendAllTags(n);
                break;
            }
            case 40676: {
                int n = eventGeneric.getInt(0);
                TagInformation tagInformation = (TagInformation)eventGeneric.getObject(1);
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES : ").append("activate tag ").append(" instance = ").append(n).append(" taginfo = ").append(tagInformation.toString()).log();
                }
                ITunesHandler.getITunesController().checkIfTaggable(n, tagInformation);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiRadioTaggingUpdateCompatibleDevAvail(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("  ITUNES  ").append("Device Connection status  = ").append(n).log();
        }
        this.deviceConnected = n;
        ITunesHandler.getITunesController().setDeviceConnectedStatus(n);
        try {
            if (this.deviceConnected == 1) {
                if (ITunesHandler.getITunesController().isFirstTagAfterStartupOrAfterDeviceConnected()) {
                    ITunesHandler.getITunesController().setFirstTagAfterStartupOrAfterDeviceConnected(false);
                }
                this.trans(this.mTarget.mStateDeviceConnected);
            } else {
                if (this.deviceConnected == 2) {
                    if (ServiceManager.logger2.isTraceEnabled(8192)) {
                        ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Device connected is not supported : ").append(n).log();
                    }
                } else {
                    if (ServiceManager.logger2.isTraceEnabled(8192)) {
                        ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Error condition device disconnected : ").append(n).log();
                    }
                    if (ITunesHandler.getITunesController().isTagTransferToDeviceStarted()) {
                        ITunesHandler.getITunesController().updateResult(23);
                        ITunesHandler.getITunesController().setTagTransferToDeviceStarted(false);
                    }
                    if (this.deviceConnected == 0) {
                        ITunesHandler.getITunesController().setFirstTagAfterStartupOrAfterDeviceConnected(true);
                    }
                }
                this.trans(this.mTarget.mStateDeviceNotConnected);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}


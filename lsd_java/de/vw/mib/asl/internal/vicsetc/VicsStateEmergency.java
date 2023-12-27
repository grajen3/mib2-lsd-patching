/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.vicsetc.PhoneticStringUtils;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public class VicsStateEmergency
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateEmergency(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateEmergency", this);
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateEmergency", this);
                this.target.emergencyHandler.handleEmergencyEnterContext();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateEmergency", this);
                break;
            }
            case 1079341883: {
                this.target.stateMain.transStateMain();
                break;
            }
            case 1079341869: {
                this.target.emergencyHandler.handleEmegrencyMenuPressedNext();
                break;
            }
            case 1079341870: {
                this.target.emergencyHandler.handleEmergencyMenuPressedPrev();
                break;
            }
            case 1079341874: {
                this.target.emergencyHandler.handleEmergencyTrafficMessageSelected(eventGeneric);
                break;
            }
            case 1079341873: {
                this.target.emergencyHandler.handleEmergencyPressedPlay();
                break;
            }
            case 100101: {
                this.target.emergencyHandler.handleSpeechPromptStarted();
                break;
            }
            case 100100: {
                this.target.emergencyHandler.handleSpeechPromptFinished();
                break;
            }
            case 1079341891: {
                this.target.emergencyHandler.handleEmergencyEnterContextAfterUpdate(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateEmergency", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.emergencyHandler.emergencyMenuResourcesLoaded.remove(new Integer(n));
        if (bl) {
            this.target.emergencyHandler.emergencyMenuResourceList.add(resourceInformation);
        }
        if (this.target.emergencyHandler.emergencyMenuResourcesLoaded.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.emergencyHandler.emergencyMenuResourceList.isEmpty() && this.target.emergencyHandler.emergencyMenuResourceList.size() > this.target.emergencyHandler.emergencyMenuResourceIndex) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.emergencyHandler.emergencyMenuResourceList.get(this.target.emergencyHandler.emergencyMenuResourceIndex);
                String string = PhoneticStringUtils.extractPhonemeString(resourceInformation2.getPhoneticString(), this.target);
                String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation2.getPhoneticString(), this.target);
                boolean bl2 = !StringUtil.isEmpty(string);
                VicsTarget.writeIntegerToDatapool(1268405504, bl2 ? 0 : 2);
                VicsTarget.writeStringToDatapool(1956271360, string);
                VicsTarget.writeStringToDatapool(-2103814912, string2);
                VicsTarget.writeResourceLocatorToDatapool(2107266304, resourceInformation2.getResourceLocator());
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("Emergency menu resource index is out of bounds. Index: ").append(this.target.emergencyHandler.emergencyMenuResourceIndex).append("ListSize: ").append(this.target.emergencyHandler.emergencyMenuResourceList.size()).toString(), this);
            }
            this.target.traceMsg("Quit wait state.", this);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }
}


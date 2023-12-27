/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.vicsetc.PhoneticStringUtils;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public class VicsStateEmergencyDetails
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateEmergencyDetails(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateEmergencyDetails", this);
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateEmergencyDetails", this);
                this.target.emergencyHandler.handleEmergencyEnterDetails();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateEmergencyDetails", this);
                break;
            }
            case 1079341871: {
                this.target.emergencyHandler.handleEmergencySubViewPressedNext();
                break;
            }
            case 1079341872: {
                this.target.emergencyHandler.handleEmergencySubViewPressedPrev();
                break;
            }
            case 1079341873: {
                this.target.emergencyHandler.handleEmergencyDetailsPressedPlay();
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
            case 100109: {
                this.target.emergencyHandler.handleEmergencyCheckIfCurrentMessageExpired();
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateEmergencyDetails", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.emergencyHandler.emergencyDetailResourcesLoaded.remove(new Integer(n));
        if (bl) {
            this.target.emergencyHandler.emergencyDetailsResourceList.add(resourceInformation);
        }
        if (this.target.emergencyHandler.emergencyDetailResourcesLoaded.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.emergencyHandler.emergencyDetailsResourceList.isEmpty() && this.target.emergencyHandler.emergencyDetailsResourceList.size() > this.target.emergencyHandler.emergencyDetailsResourceIndex) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.emergencyHandler.emergencyDetailsResourceList.get(this.target.emergencyHandler.emergencyDetailsResourceIndex);
                String string = PhoneticStringUtils.extractPhonemeString(resourceInformation2.getPhoneticString(), this.target);
                String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation2.getPhoneticString(), this.target);
                boolean bl2 = !StringUtil.isEmpty(string);
                VicsTarget.writeIntegerToDatapool(1268405504, bl2 ? 0 : 2);
                VicsTarget.writeStringToDatapool(1956271360, string);
                VicsTarget.writeStringToDatapool(-2103814912, string2);
                VicsTarget.writeResourceLocatorToDatapool(2124043520, resourceInformation2.getResourceLocator());
                if (bl2 && !this.target.emergencyHandler.isEnterContextAfterUpdate) {
                    VicsTarget.writeIntegerToDatapool(1268405504, 1);
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(714757376);
                }
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("Emergency details resource index is out of bounds. Index: ").append(this.target.emergencyHandler.emergencyDetailsResourceIndex).append("ListSize: ").append(this.target.emergencyHandler.emergencyDetailsResourceList.size()).toString(), this);
            }
            this.target.traceMsg("Quit wait state.", this);
            this.target.quitModelWaitState(1587172608, 0);
        }
    }
}


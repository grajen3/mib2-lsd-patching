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

public class VicsStateDsrcDetails
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateDsrcDetails(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateDsrcDetails", this);
                this.target.dsrcHandler.handleDsrcEnterDetails();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateDsrcDetails", this);
                break;
            }
            case 1079341865: {
                this.target.dsrcHandler.handleDsrcSubViewPressedNext();
                break;
            }
            case 1079341866: {
                this.target.dsrcHandler.handleDsrcSubViewPressedPrev();
                break;
            }
            case 1079341867: {
                this.target.dsrcHandler.handleDsrcDetailsPressedPlay();
                break;
            }
            case 100101: {
                this.target.dsrcHandler.handleSpeechPromptStarted();
                break;
            }
            case 100100: {
                this.target.dsrcHandler.handleSpeechPromptFinished();
                break;
            }
            case 100107: {
                this.target.dsrcHandler.handleDsrcCheckIfCurrentMessageExpired();
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateDsrcDetails", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.dsrcHandler.dsrcDetailsResourcesLoad.remove(new Integer(n));
        if (bl) {
            this.target.dsrcHandler.dsrcDetailsResourceList.add(resourceInformation);
        }
        if (this.target.dsrcHandler.dsrcDetailsResourcesLoad.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.dsrcHandler.dsrcDetailsResourceList.isEmpty() && this.target.dsrcHandler.dsrcDetailsResourceList.size() > this.target.dsrcHandler.dsrcDetailsResourceIndex) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.dsrcHandler.dsrcDetailsResourceList.get(this.target.dsrcHandler.dsrcDetailsResourceIndex);
                String string = PhoneticStringUtils.extractPhonemeString(resourceInformation2.getPhoneticString(), this.target);
                String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation2.getPhoneticString(), this.target);
                boolean bl2 = !StringUtil.isEmpty(string);
                VicsTarget.writeIntegerToDatapool(1117410560, bl2 ? 0 : 2);
                VicsTarget.writeStringToDatapool(1939494144, string);
                VicsTarget.writeStringToDatapool(-2103814912, string2);
                VicsTarget.writeResourceLocatorToDatapool(2056934656, resourceInformation2.getResourceLocator());
                if (bl2 && !this.target.dsrcHandler.isEnterContextAfterUpdate) {
                    VicsTarget.writeIntegerToDatapool(1117410560, 1);
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(681202944);
                }
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("DSRC details resource index is out of bounds. Index: ").append(this.target.dsrcHandler.dsrcDetailsResourceIndex).append("ListSize: ").append(this.target.dsrcHandler.dsrcDetailsResourceList.size()).toString(), this);
            }
            this.target.traceMsg("Quit wait state.", this);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }
}


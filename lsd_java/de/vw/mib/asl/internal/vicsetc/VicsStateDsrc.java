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

public class VicsStateDsrc
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateDsrc(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateDsrc", this);
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateDsrc", this);
                this.target.dsrcHandler.handleDsrcEnterContext();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateDsrc", this);
                break;
            }
            case 1079341881: {
                this.target.stateMain.transStateMain();
                break;
            }
            case 1079341863: {
                this.target.dsrcHandler.handleDsrcMenuPressedNext();
                break;
            }
            case 1079341864: {
                this.target.dsrcHandler.handleDsrcMenuPressedPrev();
                break;
            }
            case 1079341867: {
                this.target.dsrcHandler.handleDsrcPressedPlay();
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
            case 1079341868: {
                this.target.dsrcHandler.handleDsrcTrafficMessageSelected(eventGeneric);
                break;
            }
            case 1079341889: {
                this.target.dsrcHandler.handleDsrcEnterContextAfterUpdate(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateDsrc", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.dsrcHandler.dsrcMenuResourcesLoad.remove(new Integer(n));
        if (bl) {
            this.target.dsrcHandler.dsrcMenuResourceList.add(resourceInformation);
        }
        if (this.target.dsrcHandler.dsrcMenuResourcesLoad.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.dsrcHandler.dsrcMenuResourceList.isEmpty() && this.target.dsrcHandler.dsrcMenuResourceList.size() > this.target.dsrcHandler.dsrcMenuResourceIndex) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.dsrcHandler.dsrcMenuResourceList.get(this.target.dsrcHandler.dsrcMenuResourceIndex);
                String string = PhoneticStringUtils.extractPhonemeString(resourceInformation2.getPhoneticString(), this.target);
                String string2 = PhoneticStringUtils.extractPhonemeAlphabet(resourceInformation2.getPhoneticString(), this.target);
                boolean bl2 = !StringUtil.isEmpty(string);
                VicsTarget.writeIntegerToDatapool(1117410560, bl2 ? 0 : 2);
                VicsTarget.writeStringToDatapool(1939494144, string);
                VicsTarget.writeStringToDatapool(-2103814912, string2);
                VicsTarget.writeResourceLocatorToDatapool(2040157440, resourceInformation2.getResourceLocator());
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("DSRC menu resource index is out of bounds. Index: ").append(this.target.dsrcHandler.dsrcMenuResourceIndex).append("ListSize: ").append(this.target.dsrcHandler.dsrcMenuResourceList.size()).toString(), this);
            }
            this.target.traceMsg("Quit wait state.", this);
            this.target.quitModelWaitState(1553618176, 0);
        }
    }
}


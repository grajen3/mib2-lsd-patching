/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;

public class VicsStateFmGraphicDetails
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateFmGraphicDetails(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
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
                this.target.traceMsg("HSM_START - VicsStateFmGraphicDetails", this);
                this.target.fmGraphicHandler.handleFmGraphicEnterDetails();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateFmGraphicDetails", this);
                break;
            }
            case 1079341858: {
                this.target.fmGraphicHandler.handleFmGraphicSubViewPressedNext();
                break;
            }
            case 1079341859: {
                this.target.fmGraphicHandler.handleFmGraphicSubViewPressedPrev();
                break;
            }
            case 1079341860: {
                this.target.fmGraphicHandler.handleFmGraphicDetailsToggleShortcut();
                break;
            }
            case 100108: {
                this.target.fmGraphicHandler.handleFmGraphicCheckIfCurrentMessageExpired();
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateFmGraphicDetails", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.fmGraphicHandler.fmGraphicDetailResourcesLoaded.remove(new Integer(n));
        if (bl) {
            this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.add(resourceInformation);
        }
        if (this.target.fmGraphicHandler.fmGraphicDetailResourcesLoaded.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.isEmpty() && this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.size() > this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.get(this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex);
                VicsTarget.writeResourceLocatorToDatapool(2090489088, resourceInformation2.getResourceLocator());
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("FMGraphic details resource index is out of bounds. Index: ").append(this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex).append("ListSize: ").append(this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.size()).toString(), this);
            }
            this.target.traceMsg("Quit wait state.", this);
            this.target.quitModelWaitState(1536840960, 0);
        }
    }
}


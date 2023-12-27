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

public class VicsStateFmGraphic
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateFmGraphic(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateFmGraphic", this);
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateFmGraphic", this);
                this.target.fmGraphicHandler.handleFmGraphicEnterContext();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateFmGraphic", this);
                break;
            }
            case 1079341880: {
                this.target.stateMain.transStateMain();
                break;
            }
            case 1079341856: {
                this.target.fmGraphicHandler.handleFmGraphicMenuPressedNext();
                break;
            }
            case 1079341857: {
                this.target.fmGraphicHandler.handleFmGraphicMenuPressedPrev();
                break;
            }
            case 1079341855: {
                this.target.fmGraphicHandler.handleFmGraphicTrafficMessageSelected(eventGeneric);
                break;
            }
            case 1079341888: {
                this.target.fmGraphicHandler.handleShortcutEnterContextAfterUpdate(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateFmGraphic", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        boolean bl = this.target.fmGraphicHandler.fmGraphicMenuResourcesLoaded.remove(new Integer(n));
        if (bl) {
            this.target.fmGraphicHandler.fmGraphicsMenuResourceList.add(resourceInformation);
        }
        if (this.target.fmGraphicHandler.fmGraphicMenuResourcesLoaded.isEmpty() && this.target.fmGraphicHandler.fmGraphicsMenuResourceList.size() > this.target.fmGraphicHandler.fmGraphicMenuResourceIndex) {
            this.target.traceMsg("Last resource received.", this);
            if (!this.target.fmGraphicHandler.fmGraphicsMenuResourceList.isEmpty()) {
                ResourceInformation resourceInformation2 = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsMenuResourceList.get(this.target.fmGraphicHandler.fmGraphicMenuResourceIndex);
                VicsTarget.writeResourceLocatorToDatapool(2073711872, resourceInformation2.getResourceLocator());
                this.target.traceMsg("Resources for shown message updated.", this);
            } else {
                this.target.traceMsg(new StringBuffer().append("FMGraphic menu resource index is out of bounds. Index: ").append(this.target.fmGraphicHandler.fmGraphicMenuResourceIndex).append("ListSize: ").append(this.target.fmGraphicHandler.fmGraphicsMenuResourceList.size()).toString(), this);
            }
            this.target.traceMsg("Quit wait state.", this);
            this.target.quitModelWaitState(1536840960, 0);
        }
    }
}


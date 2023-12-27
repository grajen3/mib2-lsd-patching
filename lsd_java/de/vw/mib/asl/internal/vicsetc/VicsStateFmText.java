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

public class VicsStateFmText
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateFmText(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateFmText", this);
                break;
            }
            case 3: {
                this.target.traceMsg("HSM_START - VicsStateFmText", this);
                this.target.fmTextHandler.handleFmTextEnterContext();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateFmText", this);
                break;
            }
            case 1079341879: {
                this.target.stateMain.transStateMain();
                break;
            }
            case 1079341824: {
                this.target.fmTextHandler.handleFmTextTrafficMessageSelected(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateFmText", this);
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.target.traceMsg(new StringBuffer().append("Received resource information! \ncontentId: ").append(n).append("\nResource: ").append(resourceInformation).toString(), this);
        this.target.traceResourceInformation(resourceInformation);
        this.target.fmTextHandler.fmTextResourcesLoaded.remove(new Integer(n));
        Object[] objectArray = this.target.fmTextHandler.fmTextDetailsResourceList.getSize() > 0 ? this.target.fmTextHandler.fmTextDetailsResourceList.getDSIObjects() : new Object[]{};
        Object[] objectArray2 = this.target.updateResourceInformationInList(resourceInformation, objectArray);
        this.target.fmTextHandler.fmTextDetailsResourceList.updateList(objectArray2);
        if (this.target.fmTextHandler.fmTextResourcesLoaded.isEmpty()) {
            this.target.traceMsg("Last resource received.", this);
            VicsTarget.writeIntegerToDatapool(312104192, 0);
            this.target.traceMsg("Resources for shown message updated.", this);
        }
    }
}


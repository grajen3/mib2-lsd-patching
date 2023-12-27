/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.destinput;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.destinput.HsmTargetDestList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmTargetDestList$1
extends AbstractHsmState {
    private boolean isServiceStateListenerAdded;
    private final /* synthetic */ HsmTargetDestList this$0;

    HsmTargetDestList$1(HsmTargetDestList hsmTargetDestList, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmTargetDestList;
        super(hsm, string, hsmState);
        this.isServiceStateListenerAdded = false;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.traceState(this, "HSM_ENTRY");
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(HsmTargetDestList.class$org$dsi$ifc$navigation$DSINavigation == null ? (HsmTargetDestList.class$org$dsi$ifc$navigation$DSINavigation = HsmTargetDestList.class$("org.dsi.ifc.navigation.DSINavigation")) : HsmTargetDestList.class$org$dsi$ifc$navigation$DSINavigation, this.this$0);
                }
                this.this$0.addObservers(HsmTargetDestList.OBSERVER);
                break;
            }
            case 4: {
                this.this$0.traceState(this, "HSM_EXIT");
                this.this$0.removeObservers(HsmTargetDestList.OBSERVER);
                break;
            }
            case 0x40000204: {
                this.this$0.traceState(this, "SAVE_DESTINATION_LIST");
                this.this$0.myTourList.save();
                break;
            }
            case 1073742341: {
                this.this$0.traceState(this, "TRIM_DESTINATION_LIST");
                this.this$0.myTourList.trim();
                break;
            }
            case 1073742335: {
                this.this$0.traceState(this, "REPLACE_FINAL_DESTINATION");
                this.this$0.myTourList.replaceFinalDest();
                break;
            }
            case 0x40000200: {
                this.this$0.traceState(this, "REPLACE_INTERMEDIATE_DESTINATION");
                this.this$0.myTourList.replaceInterDest();
                break;
            }
            case 1073742339: {
                this.this$0.traceState(this, "RESTORE_DESTINATION_LIST");
                this.this$0.myTourList.restore();
                break;
            }
            case 0x40000202: {
                this.this$0.traceState(this, "EXCHANGE_DESTINATION_INTERMEDIATE_DESTINATION");
                this.this$0.myTourList.exchangeInterAndDest();
                break;
            }
            case 1073742337: {
                this.this$0.traceState(this, "DELETE_INTERMEDIATE_DESTINATION");
                this.this$0.myTourList.deleteIntermediateDest();
                this.this$0.sendInternalEvent(1917522944, 109510912);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


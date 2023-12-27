/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.internal.impl.testmode.TestModeServicesProvider;
import de.vw.mib.asl.internal.testmode.BoundingBoxService;
import de.vw.mib.asl.internal.testmode.BoundingBoxTarget;
import de.vw.mib.asl.internal.testmode.HsmTestmode;
import de.vw.mib.asl.internal.testmode.RenderInfoTarget;
import de.vw.mib.asl.internal.testmode.RenderingInfoService;
import de.vw.mib.asl.internal.testmode.TestModeServices;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmTestmode$1
extends AbstractHsmState {
    private final /* synthetic */ HsmTestmode this$0;

    HsmTestmode$1(HsmTestmode hsmTestmode, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmTestmode;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        TestModeServices testModeServices = TestModeServicesProvider.getTestModeServices();
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.addObserver(-1257963456);
                break;
            }
            case 4: {
                this.this$0.removeObserver(-1257963456);
                break;
            }
            case 3: {
                new BoundingBoxTarget(testModeServices).run();
                new RenderInfoTarget(testModeServices).run();
                this.setupBoundingBoxServiceListener(testModeServices.getDesktopManager(), testModeServices.getSystemApi());
                this.setupRenderInfoServiceListener(testModeServices.getDesktopManager(), testModeServices.getSystemApi());
                this.trans(this.this$0.stateTestmodeInactive);
                break;
            }
            case 1073743285: {
                boolean bl;
                boolean bl2 = bl = 1 == eventGeneric.getInt(0);
                if (bl) {
                    this.trans(this.this$0.stateTestmodeActive);
                    break;
                }
                this.trans(this.this$0.stateTestmodeInactive);
                break;
            }
            default: {
                hsmState = this.this$0.getWorkStateParent();
            }
        }
        return hsmState;
    }

    private void setupBoundingBoxServiceListener(DesktopManager desktopManager, ASLSystemAPI aSLSystemAPI) {
        BoundingBoxService boundingBoxService = new BoundingBoxService(desktopManager);
        aSLSystemAPI.addKeyListener(4, boundingBoxService);
        aSLSystemAPI.addKeyListener(23, boundingBoxService);
        aSLSystemAPI.addKeyListener(34, boundingBoxService);
    }

    private void setupRenderInfoServiceListener(DesktopManager desktopManager, ASLSystemAPI aSLSystemAPI) {
        RenderingInfoService renderingInfoService = new RenderingInfoService(desktopManager);
        aSLSystemAPI.addKeyListener(5, renderingInfoService);
    }
}


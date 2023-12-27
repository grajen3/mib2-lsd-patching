/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.swdl2;

import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.internal.download.swdl2.CancelCustomerDownloadProcess$1;
import de.vw.mib.asl.internal.download.swdl2.Preconditions;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;

public class CancelCustomerDownloadProcess {
    private static final boolean SUCCESSFUL_RESULT;
    private static final boolean VALET_PARKING_STATE_ON;
    private final DSISwdlProgress dsiSwdlProgress;

    public CancelCustomerDownloadProcess(DSISwdlProgress dSISwdlProgress) {
        Preconditions.checkArgumentNotNull(dSISwdlProgress);
        this.dsiSwdlProgress = dSISwdlProgress;
    }

    public void initValetParkingListener(ValetParkingService valetParkingService) {
        this.verifyValetParkingState(valetParkingService.getCurrentValetParkingState());
        valetParkingService.addListener(this.createValetParkingListener());
    }

    void verifyValetParkingState(boolean bl) {
        if (bl) {
            this.dsiSwdlProgress.handleUserSelection(1, "", 2);
        }
    }

    private ValetParkingListener createValetParkingListener() {
        return new CancelCustomerDownloadProcess$1(this);
    }
}


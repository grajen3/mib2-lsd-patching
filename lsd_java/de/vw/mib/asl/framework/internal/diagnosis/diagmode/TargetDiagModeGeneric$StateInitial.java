/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode;

import de.vw.mib.asl.framework.internal.diagnosis.diagmode.TargetDiagModeGeneric;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class TargetDiagModeGeneric$StateInitial
extends AbstractHsmState {
    static final int EV_DIAG_MODE_STOP_TEST_PICTURE;
    private final /* synthetic */ TargetDiagModeGeneric this$0;

    TargetDiagModeGeneric$StateInitial(TargetDiagModeGeneric targetDiagModeGeneric, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = targetDiagModeGeneric;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 4300030: {
                this.this$0.resultDeleteMemory = 0;
                this.this$0.stateDeleteMemory = 2;
                this.this$0.dsiDiagnoseSystem.resultRoutine(0, 0, 3, this.this$0.stateDeleteMemory, this.this$0.resultDeleteMemory);
                break;
            }
            case 100001: {
                this.this$0.diagModeGenTestPicture.updateTestPictureDisplay(0);
                break;
            }
        }
        return hsmState;
    }

    public void dsiDiagnoseSystemUpdateDiagnosticValueChanged(int n, long l, int n2) {
        if (n2 == 1) {
            this.this$0.diagModeGenDiagnosticValueChanged.diagnosticValueChanged(n, l);
        }
    }

    public void dsiDiagnoseSystemRequestRoutine(int n, int n2, int n3, int[] nArray) {
        switch (n3) {
            case 1: {
                this.startSystemRequestRoutine(n, n2, nArray);
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                this.resultSystemRequestRoutine(n, n2);
                break;
            }
            default: {
                ServiceManager.logger.error(16384).append("DIAGNOSTIC dsiDiagnoseSystemRequestRoutine: Invalid parameter -action-.").log();
            }
        }
    }

    public void dsiDiagnoseSystemRequestActuatorTest(int n, int n2, int n3, int n4, int[] nArray) {
        switch (n3) {
            case 0: {
                this.startSystemRequestActuatorTest(n, n2, n4, nArray);
                break;
            }
            case 1: {
                this.stopSystemRequestActuatorTest(n, n2, n4, nArray);
                break;
            }
            default: {
                ServiceManager.logger.error(16384).append("DIAGNOSTIC dsiDiagnoseSystemRequestActuatorTest: Invalid parameter -action-.").log();
            }
        }
    }

    private void startSystemRequestRoutine(int n, int n2, int[] nArray) {
        switch (n2) {
            case 0: {
                this.startSystemRequestRoutineDeleteMemory(n, nArray);
                break;
            }
            case 1: {
                this.startSystemRequestRoutineReserPmlPassword(n);
                break;
            }
            default: {
                ServiceManager.logger.error(16384).append("DIAGNOSTIC startSystemRequestRoutine: Invalid parameter -routine-.").log();
            }
        }
    }

    private void startSystemRequestRoutineDeleteMemory(int n, int[] nArray) {
        int n2;
        if (null != nArray && nArray.length > 0) {
            this.this$0.resultDeleteMemory = 2;
            this.this$0.stateDeleteMemory = 1;
            n2 = 0;
            this.this$0.diagModeGenDeleteMemory.deleteMemory(nArray[0]);
        } else {
            this.this$0.resultDeleteMemory = 1;
            n2 = 3;
            ServiceManager.logger.error(16384).append("DIAGNOSTIC startSystemRequestRoutine: Invalid parameter -options-.").log();
        }
        this.this$0.dsiDiagnoseSystem.acknowledgeRoutine(n, 0, 1, n2);
    }

    private void startSystemRequestRoutineReserPmlPassword(int n) {
        this.this$0.diagModeGenPmlPassword.updatePmlPassword(true);
        this.this$0.dsiDiagnoseSystem.acknowledgeRoutine(n, 1, 1, 0);
        this.resultSystemRequestRoutineReserPmlPassword(0);
    }

    private void resultSystemRequestRoutine(int n, int n2) {
        switch (n2) {
            case 0: {
                this.resultSystemRequestRoutineDeleteMemory(n);
                break;
            }
            case 1: {
                this.resultSystemRequestRoutineReserPmlPassword(n);
                break;
            }
            default: {
                ServiceManager.logger.error(16384).append("DIAGNOSTIC resultSystemRequestRoutine: Invalid parameter -routine-.").log();
            }
        }
    }

    private void resultSystemRequestRoutineDeleteMemory(int n) {
        this.this$0.dsiDiagnoseSystem.resultRoutine(n, 0, 3, this.this$0.stateDeleteMemory, this.this$0.resultDeleteMemory);
    }

    private void resultSystemRequestRoutineReserPmlPassword(int n) {
        this.this$0.dsiDiagnoseSystem.resultRoutine(n, 1, 3, 2, 0);
    }

    private void startSystemRequestActuatorTest(int n, int n2, int n3, int[] nArray) {
        switch (n2) {
            case 0: {
                this.startSystemRequestRemoteControlMode(n, n3, nArray);
                break;
            }
            case 1: {
                this.startSystemRequestPictureDisplay(n, n3, nArray);
                break;
            }
            case 3: {
                this.startSystemRequestSourceSwitch(n, n3, nArray);
                break;
            }
        }
    }

    private void startSystemRequestRemoteControlMode(int n, int n2, int[] nArray) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(376);
        this.this$0.triggerObserver(-2125524480, null);
        this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 0, 0, n2, nArray, 0);
    }

    private void startSystemRequestPictureDisplay(int n, int n2, int[] nArray) {
        if (null != nArray && nArray.length > 0) {
            this.this$0.diagModeGenTestPicture.updateTestPictureDisplay(nArray[0]);
            if (n2 > 0 && n2 < 255) {
                this.this$0.stopTimer(-1585053440);
                this.this$0.startTimer(-1585053440, (long)n2 * 0, false);
            }
            this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 1, 0, n2, nArray, 0);
        } else {
            this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 1, 0, n2, nArray, 3);
            ServiceManager.logger.error(16384).append("DIAGNOSTIC startSystemRequestPictureDisplay: Invalid parameter -params-.").log();
        }
    }

    private void startSystemRequestSourceSwitch(int n, int n2, int[] nArray) {
        if (null != nArray && nArray.length > 0) {
            if (this.this$0.diagModeGenSourceSwitch.triggerSourceSwitch(nArray[0])) {
                this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 3, 0, n2, nArray, 0);
            } else {
                this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 3, 0, n2, nArray, 4);
            }
        } else {
            this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 3, 0, n2, nArray, 3);
            ServiceManager.logger.error(16384).append("DIAGNOSTIC startSystemRequestActuatorTest: Invalid parameter -params-.").log();
        }
    }

    private void stopSystemRequestActuatorTest(int n, int n2, int n3, int[] nArray) {
        switch (n2) {
            case 0: {
                this.stopSystemRequestRemoteControlMode(n, n3, nArray);
                break;
            }
            case 1: {
                this.stopSystemRequestPictureDisplay(n, n3, nArray);
                break;
            }
            case 3: {
                this.stopSystemRequestSourceSwitch(n, n3, nArray);
                break;
            }
        }
    }

    private void stopSystemRequestRemoteControlMode(int n, int n2, int[] nArray) {
        this.this$0.triggerObserver(-2108747264, null);
        this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 0, 1, n2, nArray, 0);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(393);
    }

    private void stopSystemRequestPictureDisplay(int n, int n2, int[] nArray) {
        this.this$0.stopTimer(0);
        this.this$0.diagModeGenTestPicture.updateTestPictureDisplay(0);
        this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 1, 1, n2, nArray, 0);
    }

    private void stopSystemRequestSourceSwitch(int n, int n2, int[] nArray) {
        this.this$0.dsiDiagnoseSystem.acknowledgeActuatorTest(n, 3, 1, n2, nArray, 0);
    }
}


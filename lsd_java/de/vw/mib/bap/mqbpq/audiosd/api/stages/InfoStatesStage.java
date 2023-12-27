/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoStates_Status;

public abstract class InfoStatesStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoStates_Status;

    protected final InfoStates_Status dequeueBAPEntity() {
        return (InfoStates_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoStates_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoStates_Status = InfoStatesStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoStates_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoStates_Status);
    }

    @Override
    public int getFunctionId() {
        return 28;
    }

    protected final int getPlayerState() {
        return this.context.getInteger(29, 0);
    }

    protected final int getRemoteControlPlayerState() {
        return this.context.getInteger(30, 0);
    }

    protected final int getConnectedMitsumiAdapter() {
        return this.context.getInteger(7, 0);
    }

    protected final int getSystemOnOffState() {
        return this.context.getInteger(1632, 5);
    }

    protected final int getCurrrentAudioSourceState() {
        return this.context.getInteger(9, 0);
    }

    protected final int getCurrentAudioImportSource() {
        return this.context.getInteger(11, 0);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    protected final int getJukeboxDeletionState() {
        return this.context.getInteger(2734, 0);
    }

    protected final int getPhoneBluetoothState() {
        return this.context.getInteger(2908, 2);
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCDContentType() {
        return this.context.getInteger(3520, 0);
    }

    protected final int getSatTunerState() {
        return this.context.getInteger(1291, 1);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final boolean getIsDVDRegionCodeMismatch() {
        return this.context.getBoolean(152, false);
    }

    protected abstract void tunerInitialAutostoreFinished() {
    }

    protected abstract void tunerInitialAutoStoreCanceled() {
    }

    protected abstract void tunerInitialAutoStoreStarted() {
    }

    protected abstract void systemCdDvdReadError() {
    }

    protected abstract void systemCdTemperatureWarning() {
    }

    protected abstract void systemCdDvdDeviceError() {
    }

    protected abstract void systemCdDvdLoading() {
    }

    protected abstract void systemCdDvdLoadingFinished() {
    }

    protected abstract void systemSD1DeviceError() {
    }

    protected abstract void systemSD1Loading() {
    }

    protected abstract void systemSD1LoadingFinished() {
    }

    protected abstract void systemSD1ReadError() {
    }

    protected abstract void systemSD2DeviceError() {
    }

    protected abstract void systemSD2Loading() {
    }

    protected abstract void systemSD2LoadingFinished() {
    }

    protected abstract void systemSD2ReadError() {
    }

    protected abstract void systemUSBReadError() {
    }

    protected abstract void systemUsbLoading() {
    }

    protected abstract void systemUsbLoadingFinished() {
    }

    protected abstract void systemUsbDeviceError() {
    }

    protected abstract void systemCdDvdEjected() {
    }

    protected abstract void systemStartDiag() {
    }

    protected abstract void systemEndDiag() {
    }

    @Override
    public boolean hmiEvent(int n) {
        switch (n) {
            case 216: {
                this.tunerInitialAutostoreFinished();
                break;
            }
            case 202: {
                this.tunerInitialAutoStoreCanceled();
                break;
            }
            case 201: {
                this.tunerInitialAutoStoreStarted();
                break;
            }
            case 401: {
                this.systemCdDvdReadError();
                break;
            }
            case 389: {
                this.systemCdTemperatureWarning();
                break;
            }
            case 407: {
                this.systemCdDvdDeviceError();
                break;
            }
            case 404: {
                this.systemCdDvdLoading();
                break;
            }
            case 402: {
                this.systemCdDvdLoadingFinished();
                break;
            }
            case 415: {
                this.systemSD1DeviceError();
                break;
            }
            case 416: {
                this.systemSD1Loading();
                break;
            }
            case 417: {
                this.systemSD1LoadingFinished();
                break;
            }
            case 418: {
                this.systemSD1ReadError();
                break;
            }
            case 366: {
                this.systemSD2DeviceError();
                break;
            }
            case 367: {
                this.systemSD2Loading();
                break;
            }
            case 368: {
                this.systemSD2LoadingFinished();
                break;
            }
            case 369: {
                this.systemSD2ReadError();
                break;
            }
            case 383: {
                this.systemUSBReadError();
                break;
            }
            case 381: {
                this.systemUsbLoading();
                break;
            }
            case 382: {
                this.systemUsbLoadingFinished();
                break;
            }
            case 380: {
                this.systemUsbDeviceError();
                break;
            }
            case 406: {
                this.systemCdDvdEjected();
                break;
            }
            case 376: {
                this.systemStartDiag();
                break;
            }
            case 393: {
                this.systemEndDiag();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{29, 30, 7, 1632, 9, 11, 8, 2734, 2908, 1470, 3520, 1291, 1324, 152};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, null, -1);
        int[] nArray2 = new int[]{216, 202, 201, 401, 389, 407, 404, 402, 415, 416, 417, 418, 366, 367, 368, 369, 383, 381, 382, 380, 406, 376, 393};
        bAPStageInitializer.observeHMIEvents(this, nArray2);
    }

    @Override
    public final void setDelegate(BAPStageContext bAPStageContext) {
        this.context = bAPStageContext;
    }

    protected final BAPFunctionControllerDelegate getDelegate() {
        return this.context;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.customInitialization(bAPStageInitializer);
        return null;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 15: {
                this.setIsInitializing((Boolean)object);
                break;
            }
        }
    }

    protected abstract void setIsInitializing(Boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


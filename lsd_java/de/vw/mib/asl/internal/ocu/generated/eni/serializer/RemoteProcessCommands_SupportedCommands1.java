/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessCommands_SupportedCommands1
implements BAPEntity {
    public boolean postponeEcuUpdateSupportedDf3_4;
    public boolean rejectEcuUpdateSupportedDf3_4;
    public boolean confirmEcuUpdateSupportedDf3_4;
    public boolean authenticateMainUserSPinSupportedDf3_4;
    public boolean postponeOnlineUpdateDownloadSupportedDf3_4;
    public boolean rejectOnlineUpdateDownloadSupportedDf3_4;
    public boolean confirmOnlineUpdateDownloadSupportedDf3_4;
    public boolean getVTanSupportedDf3_4;

    public RemoteProcessCommands_SupportedCommands1() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessCommands_SupportedCommands1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.postponeEcuUpdateSupportedDf3_4 = false;
        this.rejectEcuUpdateSupportedDf3_4 = false;
        this.confirmEcuUpdateSupportedDf3_4 = false;
        this.authenticateMainUserSPinSupportedDf3_4 = false;
        this.postponeOnlineUpdateDownloadSupportedDf3_4 = false;
        this.rejectOnlineUpdateDownloadSupportedDf3_4 = false;
        this.confirmOnlineUpdateDownloadSupportedDf3_4 = false;
        this.getVTanSupportedDf3_4 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessCommands_SupportedCommands1 remoteProcessCommands_SupportedCommands1 = (RemoteProcessCommands_SupportedCommands1)bAPEntity;
        return this.postponeEcuUpdateSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.postponeEcuUpdateSupportedDf3_4 && this.rejectEcuUpdateSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.rejectEcuUpdateSupportedDf3_4 && this.confirmEcuUpdateSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.confirmEcuUpdateSupportedDf3_4 && this.authenticateMainUserSPinSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.authenticateMainUserSPinSupportedDf3_4 && this.postponeOnlineUpdateDownloadSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.postponeOnlineUpdateDownloadSupportedDf3_4 && this.rejectOnlineUpdateDownloadSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.rejectOnlineUpdateDownloadSupportedDf3_4 && this.confirmOnlineUpdateDownloadSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.confirmOnlineUpdateDownloadSupportedDf3_4 && this.getVTanSupportedDf3_4 == remoteProcessCommands_SupportedCommands1.getVTanSupportedDf3_4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RemoteProcessCommands_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.postponeEcuUpdateSupportedDf3_4);
        bitStream.pushBoolean(this.rejectEcuUpdateSupportedDf3_4);
        bitStream.pushBoolean(this.confirmEcuUpdateSupportedDf3_4);
        bitStream.pushBoolean(this.authenticateMainUserSPinSupportedDf3_4);
        bitStream.pushBoolean(this.postponeOnlineUpdateDownloadSupportedDf3_4);
        bitStream.pushBoolean(this.rejectOnlineUpdateDownloadSupportedDf3_4);
        bitStream.pushBoolean(this.confirmOnlineUpdateDownloadSupportedDf3_4);
        bitStream.pushBoolean(this.getVTanSupportedDf3_4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.postponeEcuUpdateSupportedDf3_4 = bitStream.popFrontBoolean();
        this.rejectEcuUpdateSupportedDf3_4 = bitStream.popFrontBoolean();
        this.confirmEcuUpdateSupportedDf3_4 = bitStream.popFrontBoolean();
        this.authenticateMainUserSPinSupportedDf3_4 = bitStream.popFrontBoolean();
        this.postponeOnlineUpdateDownloadSupportedDf3_4 = bitStream.popFrontBoolean();
        this.rejectOnlineUpdateDownloadSupportedDf3_4 = bitStream.popFrontBoolean();
        this.confirmOnlineUpdateDownloadSupportedDf3_4 = bitStream.popFrontBoolean();
        this.getVTanSupportedDf3_4 = bitStream.popFrontBoolean();
    }
}


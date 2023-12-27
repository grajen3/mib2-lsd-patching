/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio;

import de.vw.mib.asl.api.radio.AppAdapterTunerAutoStoreGlobalWizardPageCallback;
import de.vw.mib.asl.api.radio.AppAdapterTunerTileLCallback;
import java.util.ArrayList;

public interface ASLRadioAPI {
    default public void updateStationIndices(long l, int n) {
    }

    default public boolean isWavebandAvailable(int n) {
    }

    default public int convertRadioBandHAS2ASL(int n) {
    }

    default public void tuneSDARSStation(int n) {
    }

    default public boolean isChannelAvailable(int n) {
    }

    default public void prepareRadioText(boolean bl, ArrayList arrayList) {
    }

    default public ArrayList getSDARSChannelInfo(ArrayList arrayList) {
    }

    default public void updateTravelLinkSubscriptions(int n, int n2, int n3, int n4, int n5) {
    }

    default public void updateTravelLinkSubscriptions() {
    }

    default public void startInitialAutostore() {
    }

    default public void stopInitialAutostore() {
    }

    default public void activateWaveband(int n) {
    }

    default public void activateWavebandAlways(int n) {
    }

    default public void setAppAdapterTunerAutoStoreGlobalWizardPageCallbackInstance(AppAdapterTunerAutoStoreGlobalWizardPageCallback appAdapterTunerAutoStoreGlobalWizardPageCallback) {
    }

    default public boolean isTaggedStationChanged() {
    }

    default public void setAppAdapterTunerTileLCallbackInstance(AppAdapterTunerTileLCallback appAdapterTunerTileLCallback) {
    }

    default public void radioTileLCioIntentRegistrationFinished() {
    }

    default public boolean isRadioActive() {
    }
}


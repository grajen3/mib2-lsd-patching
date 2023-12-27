/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public interface DSINADReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseAbortNetworkRegistration(int n) {
    }

    default public void responseAbortNetworkSearch(int n) {
    }

    default public void responseChangeSIMCode(int n, int n2) {
    }

    default public void responseSIMPINRequired(int n) {
    }

    default public void updateSIMPINRequired(boolean bl, int n) {
    }

    default public void responseNetworkRegistration(int n) {
    }

    default public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    default public void responseUnlockSIM(int n) {
    }

    default public void responseCheckSIMPINCode(int n) {
    }

    default public void responseRestoreFactorySettings(int n) {
    }

    default public void responseTelPower(int n) {
    }

    default public void responseSetAutomaticPinEntryActive(int n) {
    }

    default public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
    }

    default public void updateAutomaticPinEntryActive(boolean bl, int n) {
    }

    default public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    default public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
    }

    default public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
    }

    default public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
    }

    default public void updateNetworkType(int n, int n2) {
    }

    default public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
    }

    default public void updateSignalQuality(int n, int n2) {
    }

    default public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


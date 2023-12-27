/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.util.Util;

public class CoreServiceAdapterListenerImpl
implements CoreServiceAdapterListener {
    @Override
    public void resetToFactorySettingsResponse(int n, String string, int n2) {
        if (n2 == 0) {
            CoreServiceImplFactory.getPersistence().clear();
            CoreServiceImplFactory.getStatusHandler().resetToFactorySettings();
            CoreServiceImplFactory.getCoreServiceController().clear();
            Object[] objectArray = CoreServiceImplFactory.getCoreServiceController().getDeviceList();
            if (!Util.isNullOrEmpty(objectArray) && objectArray.length > 1) {
                int n3 = objectArray.length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    CoreServiceAdapter coreServiceAdapter;
                    if (objectArray[i2].isMainDevice() || n != objectArray[i2].getDeviceID() || (coreServiceAdapter = CoreServiceFactory.getAdapterRegister().getAdapterWithID(objectArray[i2].getDeviceID())) == null) continue;
                    coreServiceAdapter.forceOwnerValidation(false, null);
                    CoreServiceImplFactory.getAuthentication().deleteMainUserName(false);
                }
            }
        }
        if (CoreServiceImplFactory.getFactoryResetHandler().isResetFactorySettingsInProcess()) {
            CoreServiceImplFactory.getFactoryResetHandler().responseResetToFactorSettings(n, string, n2);
        } else {
            CoreServiceImplFactory.getCoreServiceNotifier().resetToFactorSettingsResponse(n, string, n2 == 0 ? 0 : 2);
        }
    }

    @Override
    public void validateOwnerResponse(User user, int n) {
        block3: {
            block4: {
                User[] userArray = null;
                OnlineUser onlineUser = null;
                if (user != null) {
                    userArray = new User[]{user};
                    CoreServiceImplFactory.getCoreServiceController().updateUserList(userArray, user.getDeviceID());
                    onlineUser = CoreServiceImplFactory.getCoreServiceController().getClientUserWithID(user.getUserID());
                }
                CoreServiceImplFactory.getCoreServiceController().CarNetPinVerificationResponse(onlineUser, n);
                if (n != 0) break block3;
                Object[] objectArray = CoreServiceImplFactory.getCoreServiceController().getDeviceList();
                if (Util.isNullOrEmpty(objectArray) || objectArray.length <= 1) break block4;
                int n2 = objectArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    CoreServiceAdapter coreServiceAdapter;
                    if (objectArray[i2].isMainDevice() || (coreServiceAdapter = CoreServiceFactory.getAdapterRegister().getAdapterWithID(objectArray[i2].getDeviceID())) == null) continue;
                    coreServiceAdapter.forceOwnerValidation(true, null);
                }
                break block3;
            }
            Object[] objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList();
            if (Util.isNullOrEmpty(objectArray) || objectArray.length <= 1) break block3;
            int n3 = objectArray.length;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (objectArray[i3] == CoreServiceFactory.getAdapterRegister().getMainAdapter()) continue;
                objectArray[i3].forceOwnerValidation(true, null);
            }
        }
    }

    @Override
    public void verifyOwnerResponse(int n) {
        CoreServiceImplFactory.getCoreServiceNotifier().validateUserResponse(n);
    }

    @Override
    public void forceOwnerValidationResponse(int n) {
    }

    @Override
    public void serviceStateResponse(Service service) {
        CoreServiceImplFactory.getCoreServiceNotifier().setStateResponse(service != null ? CoreServiceImplFactory.getCoreServiceController().getClientServiceWithID(service.getServiceID()) : null);
    }

    @Override
    public void getServiceURLResponse(String string, String string2, int n) {
        CoreServiceImplFactory.getCoreServiceNotifier().getServiceURLResponse(string, string2, n);
    }

    @Override
    public void resetToFactorSettingsWithServiceNameResponse(int n, String string, int n2) {
        if (n2 == 0) {
            CoreServiceImplFactory.getCoreServiceController().resetToFactorySettings();
        }
        CoreServiceImplFactory.getCoreServiceNotifier().resetToFactorSettingsWithServiceNameResponse(n, string, n2);
    }

    @Override
    public void checkServiceStatusResponse(String string, int n) {
        CoreServiceImplFactory.getCoreServiceNotifier().checkAuthenticationResponse(!Util.isNullOrEmpty(string) ? string : "", n);
    }

    @Override
    public void sendPrivacyModeStatusResponse(int n, int n2) {
        CoreServiceImplFactory.getPrivacyModeHandler().responsePrivacyMode(n, n2);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIOnlineServiceRegistrationReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class DSIOnlineServiceRegistrationDispatcher
extends AbstractDispatcher
implements DSIOnlineServiceRegistrationReply {
    private DSIOnlineServiceRegistrationReplyService service = new DSIOnlineServiceRegistrationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineServiceRegistrationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = DSIOnlineServiceRegistrationDispatcher.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getOnlineApplicationListResponse(oSRApplicationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getOnlineApplicationResponse(oSRApplication);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.activateLicenseResponse(oSRLicense, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setCredentialResponse(String string, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setCredentialResponse(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void downloadResponse(String string, String string2, String string3, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.downloadResponse(string, string2, string3, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.downloadRawResponse(string, string2, string3, resourceLocator, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void validateOwnerResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.validateOwnerResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void checkOwnersVerificationResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.checkOwnersVerificationResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.createUserWithPairingCodeResponse(string, oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.createUserWithUserPasswordResponse(string, oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void checkPasswordResponse(OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.checkPasswordResponse(oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.checkPairingCodeResponse(oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setPrivacyFlagsResponse(oSRUser);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setAutoLoginResponse(oSRUser, oSRDeviceArray, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void loginResponse(OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.loginResponse(oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void logoutResponse(OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.logoutResponse(oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.logoutAuthSchemeResult(string, oSRUserArray, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getUsersResponse(oSRUserArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.removeUserResponse(oSRUser, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.performPortalRegistrationResponse(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.precheckOnlineServiceServiceIDResponse(string, oSRServiceState);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.precheckOnlineServiceSymbolicNameResponse(string, oSRServiceState);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.precheckOnlineServiceResponse(string, oSRServiceStateArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getLicenseResponse(n, oSRLicense);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getLicensesResponse(n, bl, bl2, oSRLicenseArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getProfileFolderResponse(n, string, oSRUser, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getCredentialsFromHeaderResponse(n, n2, n3, string, string2, string3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getCredentialsFromAuthSchemeResponse(n, n2, string, string2, string3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getServiceURLResponse(int n, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getServiceURLResponse(n, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetToFactorySettingsResponse(String string, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.resetToFactorySettingsResponse(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(1, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateApplicationState(oSRNotifyPropertiesArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateApplicationState(oSRNotifyPropertiesArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(9, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateServices(oSRNotifyPropertiesSLArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateServices(oSRNotifyPropertiesSLArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(5, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateCoreProfileInfo(oSRUser, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateCoreProfileInfo(oSRUser, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(4, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateExternalProfileInfo(string, oSRUser, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateExternalProfileInfo(string, oSRUser, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(3, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateDeviceEnumerator(oSRDevice, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateDeviceEnumerator(oSRDevice, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(6, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateServiceState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateServiceState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(7, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateServiceList(oSRServiceListEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateServiceList(oSRServiceListEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(10, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateServiceRegistration(string, oSRServiceRegistration, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateServiceRegistration(string, oSRServiceRegistration, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setServiceStateResponse(oSRServiceState);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setDemandStateServiceIDResponse(String string, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setDemandStateServiceIDResponse(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setServiceStateSymbolicNameResponse(oSRServiceState);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setActivePrivacyCategoryMaskResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setActivePrivacyCategoryMaskResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void submitServiceStateChangesToBackendResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.submitServiceStateChangesToBackendResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(8, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileResetAll(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.profileResetAll(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setGPSUseModeResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setGPSUseModeResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setInventoryFinishedResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setInventoryFinishedResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSPINRequired(String string, String string2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    this.confirmNotificationListener(11, dSIOnlineServiceRegistrationListener);
                    dSIOnlineServiceRegistrationListener.updateSPINRequired(string, string2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)iterator.next();
                    dSIOnlineServiceRegistrationListener.updateSPINRequired(string, string2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSPINResponse(String string, String string2, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.setSPINResponse(string, string2, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.getSPINHashResult(string, string2, n, string3, string4, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    dSIOnlineServiceRegistrationListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineServiceRegistrationListener dSIOnlineServiceRegistrationListener = (DSIOnlineServiceRegistrationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineServiceRegistrationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineServiceRegistrationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineServiceRegistrationListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
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


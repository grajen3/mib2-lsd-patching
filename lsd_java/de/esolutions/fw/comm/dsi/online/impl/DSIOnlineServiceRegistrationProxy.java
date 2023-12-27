/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineServiceRegistration;
import de.esolutions.fw.comm.dsi.online.DSIOnlineServiceRegistrationC;
import de.esolutions.fw.comm.dsi.online.DSIOnlineServiceRegistrationReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$1;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$10;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$11;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$2;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$3;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$4;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$5;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$6;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$7;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$8;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy$9;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public class DSIOnlineServiceRegistrationProxy
implements DSIOnlineServiceRegistration,
DSIOnlineServiceRegistrationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOnlineServiceRegistration");
    private Proxy proxy;

    public DSIOnlineServiceRegistrationProxy(int n, DSIOnlineServiceRegistrationReply dSIOnlineServiceRegistrationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b10fa662-6bb6-5db6-845e-7be3bb6673a6", n, "51f17e6e-13ee-5816-946b-c5393a6dc0e0", "dsi.online.DSIOnlineServiceRegistration");
        DSIOnlineServiceRegistrationReplyService dSIOnlineServiceRegistrationReplyService = new DSIOnlineServiceRegistrationReplyService(dSIOnlineServiceRegistrationReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlineServiceRegistrationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void getOnlineApplicationList() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void getOnlineApplication(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setOnlineApplicationState(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void activateLicense(OSRLicense oSRLicense) {
        DSIOnlineServiceRegistrationProxy$1 dSIOnlineServiceRegistrationProxy$1 = new DSIOnlineServiceRegistrationProxy$1(this, oSRLicense);
        this.proxy.remoteCallMethod((short)179, dSIOnlineServiceRegistrationProxy$1);
    }

    @Override
    public void setDemandState(String string, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setDemandStateServiceID(String string, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)195, genericSerializable);
    }

    @Override
    public void setApplicationProperties(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        DSIOnlineServiceRegistrationProxy$2 dSIOnlineServiceRegistrationProxy$2 = new DSIOnlineServiceRegistrationProxy$2(this, string, oSRApplicationPropertiesArray);
        this.proxy.remoteCallMethod((short)12, dSIOnlineServiceRegistrationProxy$2);
    }

    @Override
    public void addOrUpdateApplicationProperty(String string, OSRApplicationProperties oSRApplicationProperties) {
        DSIOnlineServiceRegistrationProxy$3 dSIOnlineServiceRegistrationProxy$3 = new DSIOnlineServiceRegistrationProxy$3(this, string, oSRApplicationProperties);
        this.proxy.remoteCallMethod((short)87, dSIOnlineServiceRegistrationProxy$3);
    }

    @Override
    public void setCredential(String string, String string2, String string3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void download(String string, String string2, String string3, long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)211, genericSerializable);
    }

    @Override
    public void downloadRaw(String string, String string2, String string3, long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)212, genericSerializable);
    }

    @Override
    public void validateOwner(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void validateOwnerForce(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)174, genericSerializable);
    }

    @Override
    public void checkOwnersVerification() {
        this.proxy.remoteCallMethod((short)33, null);
    }

    @Override
    public void createUserWithPairingCode(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)58, genericSerializable);
    }

    @Override
    public void createUserWithUserPassword(String string, String string2, String string3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)60, genericSerializable);
    }

    @Override
    public void checkPassword(OSRUser oSRUser, String string, boolean bl) {
        DSIOnlineServiceRegistrationProxy$4 dSIOnlineServiceRegistrationProxy$4 = new DSIOnlineServiceRegistrationProxy$4(this, oSRUser, string, bl);
        this.proxy.remoteCallMethod((short)147, dSIOnlineServiceRegistrationProxy$4);
    }

    @Override
    public void checkPairingCode(OSRUser oSRUser, String string, boolean bl) {
        DSIOnlineServiceRegistrationProxy$5 dSIOnlineServiceRegistrationProxy$5 = new DSIOnlineServiceRegistrationProxy$5(this, oSRUser, string, bl);
        this.proxy.remoteCallMethod((short)145, dSIOnlineServiceRegistrationProxy$5);
    }

    @Override
    public void setPrivacyFlags(OSRUser oSRUser, int n) {
        DSIOnlineServiceRegistrationProxy$6 dSIOnlineServiceRegistrationProxy$6 = new DSIOnlineServiceRegistrationProxy$6(this, oSRUser, n);
        this.proxy.remoteCallMethod((short)169, dSIOnlineServiceRegistrationProxy$6);
    }

    @Override
    public void setAutoLogin(OSRUser oSRUser, OSRDevice[] oSRDeviceArray) {
        DSIOnlineServiceRegistrationProxy$7 dSIOnlineServiceRegistrationProxy$7 = new DSIOnlineServiceRegistrationProxy$7(this, oSRUser, oSRDeviceArray);
        this.proxy.remoteCallMethod((short)167, dSIOnlineServiceRegistrationProxy$7);
    }

    @Override
    public void login(OSRUser oSRUser) {
        DSIOnlineServiceRegistrationProxy$8 dSIOnlineServiceRegistrationProxy$8 = new DSIOnlineServiceRegistrationProxy$8(this, oSRUser);
        this.proxy.remoteCallMethod((short)154, dSIOnlineServiceRegistrationProxy$8);
    }

    @Override
    public void logout(OSRUser oSRUser) {
        DSIOnlineServiceRegistrationProxy$9 dSIOnlineServiceRegistrationProxy$9 = new DSIOnlineServiceRegistrationProxy$9(this, oSRUser);
        this.proxy.remoteCallMethod((short)156, dSIOnlineServiceRegistrationProxy$9);
    }

    @Override
    public void logoutAuthScheme(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)75, genericSerializable);
    }

    @Override
    public void getUsers(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)70, genericSerializable);
    }

    @Override
    public void removeUser(OSRUser oSRUser) {
        DSIOnlineServiceRegistrationProxy$10 dSIOnlineServiceRegistrationProxy$10 = new DSIOnlineServiceRegistrationProxy$10(this, oSRUser);
        this.proxy.remoteCallMethod((short)165, dSIOnlineServiceRegistrationProxy$10);
    }

    @Override
    public void performPortalRegistration(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void getLicense(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)62, genericSerializable);
    }

    @Override
    public void getLicenses(boolean bl, boolean bl2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)64, genericSerializable);
    }

    @Override
    public void precheckOnlineServiceServiceID(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)161, genericSerializable);
    }

    @Override
    public void precheckOnlineServiceSymbolicName(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)163, genericSerializable);
    }

    @Override
    public void precheckOnlineService(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)159, genericSerializable);
    }

    @Override
    public void getProfileFolder(OSRUser oSRUser, String string) {
        DSIOnlineServiceRegistrationProxy$11 dSIOnlineServiceRegistrationProxy$11 = new DSIOnlineServiceRegistrationProxy$11(this, oSRUser, string);
        this.proxy.remoteCallMethod((short)151, dSIOnlineServiceRegistrationProxy$11);
    }

    @Override
    public void getCredentialsFromHeader(int n, String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)90, genericSerializable);
    }

    @Override
    public void getCredentialsFromAuthScheme(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)88, genericSerializable);
    }

    @Override
    public void getServiceURL(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)92, genericSerializable);
    }

    @Override
    public void resetToFactorySettings(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void setLanguage(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)116, genericSerializable);
    }

    @Override
    public void setServiceState(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)201, genericSerializable);
    }

    @Override
    public void setServiceStateSymbolicName(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)203, genericSerializable);
    }

    @Override
    public void setActivePrivacyCategoryMask(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)193, genericSerializable);
    }

    @Override
    public void submitServiceStateChangesToBackend() {
        this.proxy.remoteCallMethod((short)205, null);
    }

    @Override
    public void profileChange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)185, genericSerializable);
    }

    @Override
    public void profileCopy(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)188, genericSerializable);
    }

    @Override
    public void profileReset(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)189, genericSerializable);
    }

    @Override
    public void profileResetAll() {
        this.proxy.remoteCallMethod((short)191, null);
    }

    @Override
    public void setGPSUseMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)197, genericSerializable);
    }

    @Override
    public void setInventoryFinished(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)199, genericSerializable);
    }

    @Override
    public void setSPIN(String string, String string2, String string3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)217, genericSerializable);
    }

    @Override
    public void getSPINHash(String string, String string2, int n, String string3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)215, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }
}


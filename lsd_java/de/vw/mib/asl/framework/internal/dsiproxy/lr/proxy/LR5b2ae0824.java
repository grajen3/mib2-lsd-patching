/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.DSIOnlineTourImportListener;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public final class LR5b2ae0824
extends AbstractProxy
implements DSIOnlineTourImportListener,
DSIOnlineServiceRegistrationListener {
    private static final Method[] JMS = new Method[58];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5b2ae0824(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void indicateToursAvailable(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(0, "org.dsi.ifc.online.DSIOnlineTourImportListener", 2089381133, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseTourDownload(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(1, "org.dsi.ifc.online.DSIOnlineTourImportListener", 1456500983, 1687814400), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateTourDownloadFinished(int n, String string, String string2, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(2, "org.dsi.ifc.online.DSIOnlineTourImportListener", 1612614981, -107814524), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(3, "org.dsi.ifc.online.DSIOnlineTourImportListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(4, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1689832120, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileResetAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(5, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 283450095, 1687814400), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b2ae0824.gjm(6, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1184260366, 1043255048), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(7, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1089708026, 1676164096), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b2ae0824.gjm(8, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1112303269, 1043255048), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRApplicationArray;
            this.h.invoke(this, LR5b2ae0824.gjm(9, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1529563979, -361269682), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRApplication;
            this.h.invoke(this, LR5b2ae0824.gjm(10, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 497086991, 748367570), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRLicense;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(11, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1540605847, -1674355153), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setCredentialResponse(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(12, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 788543462, -645498553), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void downloadResponse(String string, String string2, String string3, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(13, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1580974021, 1865490124), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = resourceLocator;
            objectArray[4] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(14, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1447407186, 375633124), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void validateOwnerResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(15, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 320168772, 1687814400), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void checkOwnersVerificationResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(16, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1494567687, 1687814400), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = oSRUser;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(17, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 514455952, -47799197), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = oSRUser;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(18, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1227650578, -47799197), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void checkPasswordResponse(OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(19, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1719435837, -1197579402), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(20, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -2082971407, -1197579402), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRUser;
            this.h.invoke(this, LR5b2ae0824.gjm(21, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 937896594, -1185929098), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = oSRUser;
            objectArray[1] = oSRDeviceArray;
            objectArray[2] = nArray;
            this.h.invoke(this, LR5b2ae0824.gjm(22, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1899269791, -1232668240), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void loginResponse(OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(23, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1072785844, -1197579402), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void logoutResponse(OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(24, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1617307680, -1197579402), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = oSRUserArray;
            objectArray[2] = nArray;
            this.h.invoke(this, LR5b2ae0824.gjm(25, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 156807689, -1898581697), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRUserArray;
            this.h.invoke(this, LR5b2ae0824.gjm(26, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 675106117, -68790916), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(27, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1158865754, -1197579402), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(28, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1543847827, -645498553), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = oSRServiceState;
            this.h.invoke(this, LR5b2ae0824.gjm(29, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1236465776, -1750220564), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = oSRServiceState;
            this.h.invoke(this, LR5b2ae0824.gjm(30, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1894839315, -1750220564), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = oSRServiceStateArray;
            this.h.invoke(this, LR5b2ae0824.gjm(31, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1932133151, -671105604), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = oSRLicense;
            this.h.invoke(this, LR5b2ae0824.gjm(32, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -503349284, -1597567792), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(bl2);
            objectArray[3] = oSRLicenseArray;
            this.h.invoke(this, LR5b2ae0824.gjm(33, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1636552389, 879382636), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = oSRUser;
            objectArray[3] = string2;
            this.h.invoke(this, LR5b2ae0824.gjm(34, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1747636013, 1590952076), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = string;
            objectArray[4] = string2;
            objectArray[5] = string3;
            this.h.invoke(this, LR5b2ae0824.gjm(35, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 322117536, 962051051), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            objectArray[3] = string2;
            objectArray[4] = string3;
            this.h.invoke(this, LR5b2ae0824.gjm(36, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -205970165, 34843543), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getServiceURLResponse(int n, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            this.h.invoke(this, LR5b2ae0824.gjm(37, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1187844767, 1383775559), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void resetToFactorySettingsResponse(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(38, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1715610685, -645498553), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRNotifyPropertiesArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(39, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 2137921049, -1992762834), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRNotifyPropertiesSLArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(40, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1126821242, -789921790), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(41, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1147867799, -1813711490), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = oSRUser;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(42, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 416308979, -1539323744), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = oSRDevice;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(43, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 405542802, -564372616), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServiceState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(44, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1163860774, 1676164096), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRServiceListEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(45, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -539878327, 117412439), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = oSRServiceRegistration;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(46, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -92379170, -1187482232), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRServiceState;
            this.h.invoke(this, LR5b2ae0824.gjm(47, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 885126861, -892169136), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDemandStateServiceIDResponse(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(48, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -2110328134, -645498553), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRServiceState;
            this.h.invoke(this, LR5b2ae0824.gjm(49, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1318191228, -892169136), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setActivePrivacyCategoryMaskResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(50, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 1613404152, 1687814400), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void submitServiceStateChangesToBackendResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(51, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 551307374, 1687814400), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setGPSUseModeResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(52, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1739677383, 1687814400), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setInventoryFinishedResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(53, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -2101050451, 1687814400), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSPINRequired(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b2ae0824.gjm(54, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -1082944636, -1028403557), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSPINResponse(String string, String string2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(55, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", 2051202392, 1775039192), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = string3;
            objectArray[4] = string4;
            objectArray[5] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b2ae0824.gjm(56, "org.dsi.ifc.online.DSIOnlineServiceRegistrationListener", -120096487, -1895266515), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}


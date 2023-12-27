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
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.DSIOnlineTourImport;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public final class LR57d2d6bac
extends AbstractProxy
implements DSIOnlineTourImport,
DSIOnlineServiceRegistration {
    private static final Method[] JMS = new Method[64];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR57d2d6bac(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void startTourDownload(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(0, "org.dsi.ifc.online.DSIOnlineTourImport", -145350591, 1687814400), 0, objectArray);
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
    public void dismissTourDownload() {
        try {
            this.h.invoke(this, LR57d2d6bac.gjm(1, "org.dsi.ifc.online.DSIOnlineTourImport", 524926414, 17), 1, ZOA);
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
    public void acknowledgeTourImport(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(2, "org.dsi.ifc.online.DSIOnlineTourImport", 1322702238, 1687814400), 2, objectArray);
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
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR57d2d6bac.gjm(3, "org.dsi.ifc.online.DSIOnlineTourImport", -501696838, -904616957), -1, objectArray);
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
    public void setNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR57d2d6bac.gjm(4, "org.dsi.ifc.online.DSIOnlineTourImport", -501696838, 1805755651), -1, objectArray);
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
    public void setNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR57d2d6bac.gjm(5, "org.dsi.ifc.online.DSIOnlineTourImport", -501696838, -864245041), -1, objectArray);
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
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR57d2d6bac.gjm(6, "org.dsi.ifc.online.DSIOnlineTourImport", 1300919239, -904616957), -1, objectArray);
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
    public void clearNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR57d2d6bac.gjm(7, "org.dsi.ifc.online.DSIOnlineTourImport", 1300919239, 1805755651), -1, objectArray);
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
    public void clearNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR57d2d6bac.gjm(8, "org.dsi.ifc.online.DSIOnlineTourImport", 1300919239, -864245041), -1, objectArray);
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
    public void download(String string, String string2, String string3, long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = RuntimeUtil.valueOf(l);
            objectArray[4] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR57d2d6bac.gjm(9, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -37086635, 150862110), 9, objectArray);
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
    public void setLanguage(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(10, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 1328833814, -633848249), 10, objectArray);
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
    public void getLicenses(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR57d2d6bac.gjm(11, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 1027930799, -647458158), 11, objectArray);
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
    public void resetToFactorySettings(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(12, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 951627279, -633848249), 12, objectArray);
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
    public void profileChange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(13, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 787086500, 1687814400), 13, objectArray);
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
    public void profileCopy(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57d2d6bac.gjm(14, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 867405578, 1676164096), 14, objectArray);
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
    public void profileReset(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(15, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1689832120, 1687814400), 15, objectArray);
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
    public void profileResetAll() {
        try {
            this.h.invoke(this, LR57d2d6bac.gjm(16, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 283450095, 17), 16, ZOA);
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
    public void getOnlineApplicationList() {
        try {
            this.h.invoke(this, LR57d2d6bac.gjm(17, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -100204145, 17), 17, ZOA);
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
    public void getOnlineApplication(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(18, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1134657013, -633848249), 18, objectArray);
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
    public void setOnlineApplicationState(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(19, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 195807875, -645498553), 19, objectArray);
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
    public void activateLicense(OSRLicense oSRLicense) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRLicense;
            this.h.invoke(this, LR57d2d6bac.gjm(20, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 1130521705, -1645927889), 20, objectArray);
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
    public void setDemandState(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d2d6bac.gjm(21, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1185064222, 372504021), 21, objectArray);
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
    public void setDemandStateServiceID(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d2d6bac.gjm(22, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 556432781, 372504021), 22, objectArray);
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
    public void setApplicationProperties(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = oSRApplicationPropertiesArray;
            this.h.invoke(this, LR57d2d6bac.gjm(23, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -695076871, -1734349525), 23, objectArray);
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
    public void addOrUpdateApplicationProperty(String string, OSRApplicationProperties oSRApplicationProperties) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = oSRApplicationProperties;
            this.h.invoke(this, LR57d2d6bac.gjm(24, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 764710497, 11096598), 24, objectArray);
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
    public void setCredential(String string, String string2, String string3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            this.h.invoke(this, LR57d2d6bac.gjm(25, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -823088909, -937887090), 25, objectArray);
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
    public void downloadRaw(String string, String string2, String string3, long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = RuntimeUtil.valueOf(l);
            objectArray[4] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR57d2d6bac.gjm(26, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -179515465, 150862110), 26, objectArray);
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
    public void validateOwner(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(27, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1305896243, -633848249), 27, objectArray);
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
    public void validateOwnerForce(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d2d6bac.gjm(28, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 594857115, -1653679357), 28, objectArray);
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
    public void checkOwnersVerification() {
        try {
            this.h.invoke(this, LR57d2d6bac.gjm(29, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -120598068, 17), 29, ZOA);
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
    public void createUserWithPairingCode(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR57d2d6bac.gjm(30, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1107788151, -412271469), 30, objectArray);
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
    public void createUserWithUserPassword(String string, String string2, String string3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            this.h.invoke(this, LR57d2d6bac.gjm(31, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -388613450, -937887090), 31, objectArray);
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
    public void checkPassword(OSRUser oSRUser, String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = oSRUser;
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d2d6bac.gjm(32, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 947812056, 1924175970), 32, objectArray);
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
    public void checkPairingCode(OSRUser oSRUser, String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = oSRUser;
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d2d6bac.gjm(33, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 576555754, 1924175970), 33, objectArray);
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
    public void setPrivacyFlags(OSRUser oSRUser, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(34, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -698394512, -1197579402), 34, objectArray);
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
    public void setAutoLogin(OSRUser oSRUser, OSRDevice[] oSRDeviceArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = oSRDeviceArray;
            this.h.invoke(this, LR57d2d6bac.gjm(35, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 764131517, -733368144), 35, objectArray);
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
    public void login(OSRUser oSRUser) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRUser;
            this.h.invoke(this, LR57d2d6bac.gjm(36, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -554621690, -1185929098), 36, objectArray);
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
    public void logout(OSRUser oSRUser) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRUser;
            this.h.invoke(this, LR57d2d6bac.gjm(37, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -15230786, -1185929098), 37, objectArray);
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
    public void logoutAuthScheme(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(38, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 204557651, -633848249), 38, objectArray);
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
    public void getUsers(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(39, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -952744843, -633848249), 39, objectArray);
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
    public void removeUser(OSRUser oSRUser) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = oSRUser;
            this.h.invoke(this, LR57d2d6bac.gjm(40, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -461866175, -1185929098), 40, objectArray);
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
    public void performPortalRegistration(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(41, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -76395630, -633848249), 41, objectArray);
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
    public void getLicense(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(42, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -2134721209, -633848249), 42, objectArray);
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
    public void precheckOnlineServiceServiceID(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR57d2d6bac.gjm(43, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -396582102, -412271469), 43, objectArray);
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
    public void precheckOnlineServiceSymbolicName(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR57d2d6bac.gjm(44, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 263346034, -412271469), 44, objectArray);
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
    public void precheckOnlineService(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(45, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 312464690, -633848249), 45, objectArray);
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
    public void getProfileFolder(OSRUser oSRUser, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = oSRUser;
            objectArray[1] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(46, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 917430887, -964352318), 46, objectArray);
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
    public void getCredentialsFromHeader(int n, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            this.h.invoke(this, LR57d2d6bac.gjm(47, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1303948162, -785441950), 47, objectArray);
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
    public void getCredentialsFromAuthScheme(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(48, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1834074364, 1687814400), 48, objectArray);
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
    public void getServiceURL(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57d2d6bac.gjm(49, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -440110457, -633848249), 49, objectArray);
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
    public void setServiceState(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(50, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -746190676, -645498553), 50, objectArray);
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
    public void setServiceStateSymbolicName(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(51, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 1342189756, -645498553), 51, objectArray);
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
    public void setActivePrivacyCategoryMask(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(52, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -2422076, 1687814400), 52, objectArray);
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
    public void submitServiceStateChangesToBackend() {
        try {
            this.h.invoke(this, LR57d2d6bac.gjm(53, "org.dsi.ifc.online.DSIOnlineServiceRegistration", -1085445472, 17), 53, ZOA);
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
    public void setGPSUseMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57d2d6bac.gjm(54, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 934852803, 1687814400), 54, objectArray);
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
    public void setInventoryFinished(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57d2d6bac.gjm(55, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 565738745, -1653679357), 55, objectArray);
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
    public void setSPIN(String string, String string2, String string3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            this.h.invoke(this, LR57d2d6bac.gjm(56, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 430854006, -937887090), 56, objectArray);
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
    public void getSPINHash(String string, String string2, int n, String string3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = string3;
            this.h.invoke(this, LR57d2d6bac.gjm(57, "org.dsi.ifc.online.DSIOnlineServiceRegistration", 990966574, 1197881598), 57, objectArray);
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


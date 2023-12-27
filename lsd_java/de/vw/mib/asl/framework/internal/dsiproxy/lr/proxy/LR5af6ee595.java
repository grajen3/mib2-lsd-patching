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
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DSIObexAuthenticationListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public final class LR5af6ee595
extends AbstractProxy
implements DSIObexAuthenticationListener,
DSIBluetoothListener {
    private static final Method[] JMS = new Method[37];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5af6ee595(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void authenticationRequired(int n, boolean bl, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            this.h.invoke(this, LR5af6ee595.gjm(0, "org.dsi.ifc.bluetooth.DSIObexAuthenticationListener", -1401150119, -2126547318), 0, objectArray);
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
    public void indAuthentication(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5af6ee595.gjm(1, "org.dsi.ifc.bluetooth.DSIObexAuthenticationListener", -1399390727, -1653679357), 1, objectArray);
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
            this.h.invoke(this, LR5af6ee595.gjm(2, "org.dsi.ifc.bluetooth.DSIObexAuthenticationListener", -1459926625, 1276482132), -1, objectArray);
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
    public void responseAbortConnectService(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(3, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 791301879, 1687814400), 3, objectArray);
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
    public void responseAbortInquiry(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(4, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -853947732, 1687814400), 4, objectArray);
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
    public void responseAcceptIncomingServiceRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(5, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1591880825, 1687814400), 5, objectArray);
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
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5af6ee595.gjm(6, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -2117606393, -1940116817), 6, objectArray);
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
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5af6ee595.gjm(7, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -786374391, -1940116817), 7, objectArray);
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
    public void responseDisconnectService(String string, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(8, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -1384741530, -1261696176), 8, objectArray);
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
    public void responseGetServices(String string, String string2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(9, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1214343282, 1775039192), 9, objectArray);
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
    public void responseInquiry(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(10, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -1141579369, 1676164096), 10, objectArray);
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
    public void responsePasskeyResponse(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(11, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 64718302, -1028403557), 11, objectArray);
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
    public void responseRemoveAuthentication(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(12, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1913703260, -1028403557), 12, objectArray);
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
    public void responseRestoreFactorySettings(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(13, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -183871736, 1687814400), 13, objectArray);
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
    public void responseSetA2DPUserSetting(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(14, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1555261904, 1687814400), 14, objectArray);
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
    public void responseSetAccessibleMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(15, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -1345647740, 1687814400), 15, objectArray);
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
    public void responseSwitchBTState(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(16, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1602570287, 1687814400), 16, objectArray);
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
    public void removeAuthenticationNoSupport(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR5af6ee595.gjm(17, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -2024791288, -412271469), 17, objectArray);
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
    public void updateAccessibleMode(int n, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(18, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 401778201, 2077903511), 18, objectArray);
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
    public void updateBTState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(19, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -348907653, 1676164096), 19, objectArray);
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
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = discoveredDevice;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(20, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 562696491, -1731158612), 20, objectArray);
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
    public void updateHUCandBTHSState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(21, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 524331834, 1676164096), 21, objectArray);
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
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = requestIncomingService;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(22, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 2122488918, 2060355064), 22, objectArray);
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
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = masterRoleRequestStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(23, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1873406284, 2063346321), 23, objectArray);
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
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = passkeyStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(24, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1640392707, -1835867533), 24, objectArray);
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
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = reconnectInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(25, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -1765024466, 1938659861), 25, objectArray);
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
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceRequestStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(26, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -2084968325, 447167116), 26, objectArray);
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
    public void updateSupportedBTProfiles(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5af6ee595.gjm(27, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1994142832, 1676164096), 27, objectArray);
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
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trustedDeviceArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(28, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -2073035240, -654191265), 28, objectArray);
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
    public void updateUserFriendlyName(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(29, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -1623319545, -645498553), 29, objectArray);
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
    public void updateA2DPUserSetting(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(30, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -195480594, -1665395196), 30, objectArray);
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
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(31, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1161554031, -2048300200), 31, objectArray);
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
    public void deviceDisonnectionInfo(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(32, "org.dsi.ifc.bluetooth.DSIBluetoothListener", 1284229802, -1028403557), 32, objectArray);
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
    public void serviceRejectNoSupport(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR5af6ee595.gjm(33, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -274720693, -412271469), 33, objectArray);
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
    public void responseReconnectSuspend(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(34, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -1154091044, 1687814400), 34, objectArray);
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
    public void responseSetPriorizedDeviceReconnect(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5af6ee595.gjm(35, "org.dsi.ifc.bluetooth.DSIBluetoothListener", -571040912, 1687814400), 35, objectArray);
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


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
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public final class LR5c5d292d7
extends AbstractProxy
implements DSIDataConnectionListener,
DSIWLANListener {
    private static final Method[] JMS = new Method[28];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5c5d292d7(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(0, "org.dsi.ifc.networking.DSIDataConnectionListener", -691460226, 1676164096), 0, objectArray);
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
    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dataConnectionStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(1, "org.dsi.ifc.networking.DSIDataConnectionListener", 98607167, -557795602), 1, objectArray);
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
    public void updateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = connectionStateInformationStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(2, "org.dsi.ifc.networking.DSIDataConnectionListener", -137858421, 371672439), 2, objectArray);
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
    public void updateErrorState(ApplicationErrorStruct applicationErrorStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = applicationErrorStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(3, "org.dsi.ifc.networking.DSIDataConnectionListener", -2022221548, -1788336694), 3, objectArray);
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
    public void forceDisconnectResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(4, "org.dsi.ifc.networking.DSIDataConnectionListener", -1107724121, 1687814400), 4, objectArray);
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
            this.h.invoke(this, LR5c5d292d7.gjm(5, "org.dsi.ifc.networking.DSIDataConnectionListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateRole(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(6, "org.dsi.ifc.networking.DSIWLANListener", 1419992046, 1676164096), 6, objectArray);
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
    public void updateRFActive(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(7, "org.dsi.ifc.networking.DSIWLANListener", -1738494879, 1676164096), 7, objectArray);
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
    public void updateNodeList(Node[] nodeArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nodeArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(8, "org.dsi.ifc.networking.DSIWLANListener", 516475510, -1433648127), 8, objectArray);
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
    public void updateProfile(Profile profile, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = profile;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(9, "org.dsi.ifc.networking.DSIWLANListener", 354903188, 157363125), 9, objectArray);
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
    public void updateWlanEnabled(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(10, "org.dsi.ifc.networking.DSIWLANListener", 194335701, -1665395196), 10, objectArray);
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
    public void updateStartupState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(11, "org.dsi.ifc.networking.DSIWLANListener", -230556853, 1676164096), 11, objectArray);
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
    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = stringArray;
            objectArray[1] = stringArray2;
            objectArray[2] = nArray;
            objectArray[3] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(12, "org.dsi.ifc.networking.DSIWLANListener", -2009793518, -1335562314), 12, objectArray);
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
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = discoveredNetwork;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(13, "org.dsi.ifc.networking.DSIWLANListener", 1916271163, 650376921), 13, objectArray);
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
    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(14, "org.dsi.ifc.networking.DSIWLANListener", 1124120327, 1775039192), 14, objectArray);
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
    public void responseFactoryReset(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(15, "org.dsi.ifc.networking.DSIWLANListener", -1155270539, 1687814400), 15, objectArray);
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
    public void responseSetRole(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(16, "org.dsi.ifc.networking.DSIWLANListener", -333799527, 1687814400), 16, objectArray);
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
    public void responseSetRFActive(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(17, "org.dsi.ifc.networking.DSIWLANListener", 810334792, 1687814400), 17, objectArray);
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
    public void responseSetProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(18, "org.dsi.ifc.networking.DSIWLANListener", 2104008372, 1687814400), 18, objectArray);
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
    public void responseNetworkSearch(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(19, "org.dsi.ifc.networking.DSIWLANListener", 715197625, 1676164096), 19, objectArray);
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
    public void responseAbortSearch(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(20, "org.dsi.ifc.networking.DSIWLANListener", 1818542762, 1687814400), 20, objectArray);
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
    public void responseConnectNetwork(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(21, "org.dsi.ifc.networking.DSIWLANListener", -94731521, -1028403557), 21, objectArray);
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
    public void responseDisconnectNetwork(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(22, "org.dsi.ifc.networking.DSIWLANListener", 638198622, -1028403557), 22, objectArray);
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
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(23, "org.dsi.ifc.networking.DSIWLANListener", 416550005, -1028403557), 23, objectArray);
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
    public void responseActivateWps(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(24, "org.dsi.ifc.networking.DSIWLANListener", 998964319, 1687814400), 24, objectArray);
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
    public void updateWPSRunning(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c5d292d7.gjm(25, "org.dsi.ifc.networking.DSIWLANListener", -1007703292, 1676164096), 25, objectArray);
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
    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c5d292d7.gjm(26, "org.dsi.ifc.networking.DSIWLANListener", 1754431610, -1028403557), 26, objectArray);
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


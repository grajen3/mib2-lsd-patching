/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.proxy;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$PT;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.util.BitSet;
import org.dsi.ifc.base.DSIListener;

final class NotificationDatapool {
    private static final IntObjectMap[] NOTIF_DP_MX = new IntObjectMap[176];
    static /* synthetic */ Class class$java$lang$Integer;

    static void getAvailable(BitSet bitSet, int n, int n2) {
        IntObjectMap intObjectMap = NotificationDatapool.getDatapool(n, n2);
        IntIterator intIterator = intObjectMap.keyIterator();
        while (intIterator.hasNext()) {
            bitSet.set(intIterator.next());
        }
    }

    static void trigger(int n, int n2, DSIListener dSIListener, BitSet bitSet) {
        IntObjectMap intObjectMap = NotificationDatapool.getDatapool(n, n2);
        MultipleMethodAccessibleObject multipleMethodAccessibleObject = ServiceManager.reflectionFactory.getListenersMmao(n);
        int[] nArray = Cfg$PT.getNotifications(n);
        int n3 = 0;
        while (0 <= (n3 = bitSet.nextSetBit(n3))) {
            try {
                Object[] objectArray = (Object[])intObjectMap.get(n3);
                if (null != objectArray) {
                    multipleMethodAccessibleObject.invoke(nArray[n3], dSIListener, objectArray);
                }
            }
            catch (InvocationTargetException invocationTargetException) {
                ServiceManager.loggerDSIProxy.error().attachThrowable(invocationTargetException.getTargetException()).log();
            }
            ++n3;
        }
    }

    static Object[] update(int n, int n2, int n3, Object[] objectArray) {
        IntObjectMap intObjectMap = NotificationDatapool.getDatapool(n, n2);
        return (Object[])intObjectMap.put(n3, objectArray);
    }

    static void cleanup(int n, int n2) {
        NotificationDatapool.getDatapool(n, n2).clear();
    }

    static void cleanup(int n, int n2, Object[] objectArray) {
        IntObjectMap intObjectMap = NotificationDatapool.getDatapool(n, n2);
        int[] nArray = Cfg$PT.getNotificationAttrs(n);
        if (objectArray.length == 1) {
            intObjectMap.clear();
        } else if (objectArray[0].getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = NotificationDatapool.class$("java.lang.Integer")) : class$java$lang$Integer)) {
            int n3 = (Integer)objectArray[0];
            int n4 = Utils.getNotificationAttrIndex(n3, nArray);
            intObjectMap.remove(n4);
        } else {
            int[] nArray2 = (int[])objectArray[0];
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                int n5 = Utils.getNotificationAttrIndex(nArray2[i2], nArray);
                intObjectMap.remove(n5);
            }
        }
    }

    private static IntObjectMap getDatapool(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        IntObjectMap intObjectMap = NOTIF_DP_MX[n3];
        if (intObjectMap == null) {
            NotificationDatapool.NOTIF_DP_MX[n3] = intObjectMap = new IntObjectOptHashMap();
        }
        return intObjectMap;
    }

    private NotificationDatapool() {
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.ClassWarehouse;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Identifier;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ClassWarehouseImpl
implements ClassWarehouse {
    private WeakReference mMap = new WeakReference(null);
    static /* synthetic */ Class array$B;

    private Map getMap() {
        Map map = (Map)this.mMap.get();
        if (map == null) {
            map = new ObjectObjectOptHashMap();
            map.put(new Identifier(-687821311, 1L), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.CodingImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.AdaptationImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.AdaptationLateImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.CarFuncAdapImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.CarFuncListCanImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.CarFuncListBapImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.VirtualCameraPosImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.HmiFunctionBlockTblImpl");
            map.put(new Identifier(-536825343, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.DashboardDisplayConfigImpl");
            map.put(new Identifier(906042371, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.LoadSpeedThresholdImpl");
            map.put(new Identifier(906042371, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.LoadSystemLanguagesImpl");
            map.put(new Identifier(906042371, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.LoadFurtherDataImpl");
            map.put(new Identifier(906042371, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.EcoHmiImpl");
            map.put(new Identifier(906042371, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.InCarCommunicationImpl");
            map.put(new Identifier(553765890, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.IdentificationImpl");
            map.put(new Identifier(0, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.RegionCodeImpl");
            map.put(new Identifier(-1945800920, 0), "de.vw.mib.asl.framework.internal.diagnosis.variant.high2.InformationImpl");
            this.mMap = new WeakReference(map);
        }
        return map;
    }

    @Override
    public Access createAccessObject(int n, long l, byte[] byArray) {
        Identifier identifier;
        Map map = this.getMap();
        String string = (String)map.get(identifier = new Identifier(n, l));
        if (string == null) {
            throw new RuntimeException(new StringBuffer().append("unknown namespace-key combination: ").append(n).append("/").append(l).toString());
        }
        return (Access)this.newInstance(string, byArray);
    }

    private Object newInstance(String string, byte[] byArray) {
        try {
            Class clazz = Class.forName(string);
            try {
                Constructor constructor = clazz.getConstructor(new Class[]{array$B == null ? (array$B = ClassWarehouseImpl.class$("[B")) : array$B});
                try {
                    Object object = constructor.newInstance(new Object[]{byArray});
                    return object;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    throw new RuntimeException("Couldn't instantiate the given class", illegalArgumentException);
                }
                catch (InstantiationException instantiationException) {
                    throw new RuntimeException("Couldn't instantiate the given class", instantiationException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new RuntimeException("Couldn't instantiate the given class", illegalAccessException);
                }
                catch (InvocationTargetException invocationTargetException) {
                    throw new RuntimeException("Couldn't instantiate the given class", invocationTargetException);
                }
            }
            catch (SecurityException securityException) {
                throw new RuntimeException("Couldn't find the right constructor for the given class", securityException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new RuntimeException("Couldn't find the right constructor for the given class", noSuchMethodException);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Couldn't find the given class", classNotFoundException);
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


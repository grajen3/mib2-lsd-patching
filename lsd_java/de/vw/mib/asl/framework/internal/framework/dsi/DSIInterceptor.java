/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class DSIInterceptor
implements DSIProxyInterceptor {
    protected int getDSIServiceMethodId(Class clazz, String string) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(clazz.getName(), string);
    }

    protected int getDSIServiceMethodId(Class clazz, String string, Class[] classArray) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(clazz.getName(), string, classArray);
    }

    protected int getDSIListenerMethodId(Class clazz, String string) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.getListenersMmao(n).getIndex(clazz.getName(), string);
    }

    protected int getDSIListenerMethodId(Class clazz, String string, Class[] classArray) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.getListenersMmao(n).getIndex(clazz.getName(), string, classArray);
    }

    protected DSIBase getService(Target target, Class clazz) {
        return ServiceManager.dsiServiceLocator.getService(target, clazz);
    }

    protected DSIBase getService(Target target, Class clazz, int n) {
        return ServiceManager.dsiServiceLocator.getService(target, clazz, n);
    }

    protected DSIListener getResponseListener(Class clazz) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return Constants.RES_LISTENER_SKELETON_MX[Utils.getInstDepObjIdx(n, 0)];
    }

    protected DSIListener getResponseListener(Class clazz, int n) {
        Utils.checkDSIListenerType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        return Constants.RES_LISTENER_SKELETON_MX[Utils.getInstDepObjIdx(n2, n)];
    }

    protected DSIListener getNotificationListener(Class clazz) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return Constants.NOTIF_LISTENER_SKELETON_MX[Utils.getInstDepObjIdx(n, 0)];
    }

    protected DSIListener getNotificationListener(Class clazz, int n) {
        Utils.checkDSIListenerType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        return Constants.NOTIF_LISTENER_SKELETON_MX[Utils.getInstDepObjIdx(n2, n)];
    }

    @Override
    public boolean before(String string, int n, int n2, Object[] objectArray) {
        return true;
    }

    @Override
    public void after(String string, int n, int n2, Object[] objectArray) {
    }
}


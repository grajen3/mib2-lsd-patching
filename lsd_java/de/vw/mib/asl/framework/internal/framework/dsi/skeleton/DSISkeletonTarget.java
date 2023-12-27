/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.skeleton;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSINotificationListenerInvokationHandler;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSIResponseListenerInvocationHandler;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public final class DSISkeletonTarget
extends AbstractASLTarget
implements ServiceListener {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private static final String OSGI_SERVICE_FILTER;
    private final Object[] dsiServices = new Object[176];
    private final CowArray[] listenerInterceptors = new CowArray[176];
    private final ServiceRegistration[] listenerProxyRegistrations = new ServiceRegistration[176];
    private final BundleContext bundleCtx;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public DSISkeletonTarget(BundleContext bundleContext, GenericEvents genericEvents) {
        super(genericEvents, 577048832, "hsmtask");
        this.bundleCtx = bundleContext;
    }

    public void startPeer() {
        this.bundleCtx.addServiceListener(this, "(&(!(objectClass=org.dsi.ifc.base.DSIListener*))(objectClass=org.dsi.ifc.*))");
        ServiceReference[] serviceReferenceArray = this.bundleCtx.getServiceReferences(null, "(&(!(objectClass=org.dsi.ifc.base.DSIListener*))(objectClass=org.dsi.ifc.*))");
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(1, serviceReferenceArray[i2]);
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        this.serviceChanged(serviceEvent.getType(), serviceEvent.getServiceReference());
    }

    public Object[] getListenerInterceptors(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        CowArray cowArray = this.listenerInterceptors[n3];
        return null != cowArray ? cowArray.getArray() : EMPTY_ARRAY;
    }

    public void addListenerInterceptor(int n, int n2, DSIProxyInterceptor dSIProxyInterceptor) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        CowArray cowArray = this.listenerInterceptors[n3];
        if (null == cowArray) {
            this.listenerInterceptors[n3] = cowArray = new CowArray();
        }
        cowArray.addIfNotAlreadyIn(dSIProxyInterceptor);
    }

    public void removeListenerInterceptor(int n, int n2, DSIProxyInterceptor dSIProxyInterceptor) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        CowArray cowArray = this.listenerInterceptors[n3];
        if (null != cowArray) {
            cowArray.remove(dSIProxyInterceptor);
        }
    }

    private void serviceChanged(int n, ServiceReference serviceReference) {
        Object object = this.bundleCtx.getService(serviceReference);
        if (object instanceof DSIBase) {
            String[] stringArray = (String[])serviceReference.getProperty("objectClass");
            Object object2 = serviceReference.getProperty("DEVICE_INSTANCE");
            if (null == object2 || !(object2 instanceof Integer)) {
                String string = new StringBuffer().append("The service ").append(serviceReference).append(" does not have a device instance property.").toString();
                this.error(string);
                throw new DSIProxyException(string);
            }
            int n2 = (Integer)object2;
            block4: for (int i2 = 0; i2 < stringArray.length; ++i2) {
                int n3 = Utils.getTypeIndex(stringArray[i2]);
                if (0 > n3) {
                    this.error().append("The service ").append(stringArray[i2]).append(" is unknown and will be ignored.").log();
                    continue;
                }
                if (n2 >= RuntimeGeneratedConstants.INST_NMBS[n3]) {
                    this.error().append("The service ").append(stringArray[i2]).append(" has an unexpected device instance id ").append(n2).append(" and will be ignored.").log();
                    continue;
                }
                switch (n) {
                    case 1: {
                        this.register(n3, n2);
                        this.addService(n3, n2, object);
                        continue block4;
                    }
                    case 4: {
                        this.unregister(n3, n2);
                        this.removeService(n3, n2);
                        continue block4;
                    }
                }
            }
        }
    }

    public int getListenerMethodIndex(int n, String string, Class[] classArray) {
        return ServiceManager.reflectionFactory.getListenersMmao(n).getIndex(RuntimeGeneratedConstants.LISTENER_TS_NS[n], string, classArray);
    }

    public DSIListener getNotificationListener(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        DSIListener dSIListener = Constants.NOTIF_LISTENER_SKELETON_MX[n3];
        if (dSIListener == null) {
            DSINotificationListenerInvokationHandler dSINotificationListenerInvokationHandler = new DSINotificationListenerInvokationHandler(this, n, n2);
            Constants.NOTIF_LISTENER_SKELETON_MX[n3] = dSIListener = ServiceManager.reflectionFactory.newListenersProxy(n, Constants.PROXY_OAP, dSINotificationListenerInvokationHandler);
        }
        return dSIListener;
    }

    @Override
    public int getClassifier() {
        return 0x1008000;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    public void serviceInvoke(int n, int n2, int n3, int n4, Object[] objectArray) {
        try {
            Object object = this.dsiServices[Utils.getInstDepObjIdx(n3, n4)];
            if (object == null) {
                LogMessage logMessage = this.error().append("DSI service not registered: ");
                Utils.appendInstance(logMessage, RuntimeGeneratedConstants.SERVICE_TS_NS[n3], n4).log();
            } else {
                MultipleMethodAccessibleObject multipleMethodAccessibleObject = ServiceManager.reflectionFactory.getServicesMmao(n3);
                if (Utils.isTraceEnabled(n3)) {
                    Utils.traceServiceInvoke(n3, n4, n, Utils.getRuntimeServiceMethodName(n3, n2), objectArray);
                }
                multipleMethodAccessibleObject.invoke(n2, object, objectArray);
            }
        }
        catch (InvocationTargetException invocationTargetException) {
            this.error(invocationTargetException.getTargetException());
        }
    }

    private void register(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        if (this.listenerProxyRegistrations[n3] == null) {
            ServiceRegistration serviceRegistration;
            DSIListener dSIListener;
            DSIResponseListenerInvocationHandler dSIResponseListenerInvocationHandler = new DSIResponseListenerInvocationHandler(this, n, n2);
            Constants.RES_LISTENER_SKELETON_MX[n3] = dSIListener = ServiceManager.reflectionFactory.newListenersProxy(n, Constants.PROXY_OAP, dSIResponseListenerInvocationHandler);
            Hashtable hashtable = new Hashtable(2);
            ((Dictionary)hashtable).put("DEVICE_NAME", RuntimeGeneratedConstants.LISTENER_TS_NS[n]);
            ((Dictionary)hashtable).put("DEVICE_INSTANCE", RuntimeUtil.valueOf(n2));
            this.listenerProxyRegistrations[n3] = serviceRegistration = this.bundleCtx.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSISkeletonTarget.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)dSIListener, (Dictionary)hashtable);
        }
    }

    private void unregister(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        if (this.listenerProxyRegistrations[n3] != null) {
            this.listenerProxyRegistrations[n3].unregister();
            this.listenerProxyRegistrations[n3] = null;
            Constants.RES_LISTENER_SKELETON_MX[n3] = null;
        }
    }

    private void addService(int n, int n2, Object object) {
        this.dsiServices[Utils.getInstDepObjIdx((int)n, (int)n2)] = object;
        try {
            this.send(DSIProxyTarget.createServiceRegisteredEvent(n, n2));
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    private void removeService(int n, int n2) {
        this.dsiServices[Utils.getInstDepObjIdx((int)n, (int)n2)] = null;
        try {
            this.send(DSIProxyTarget.createServiceUnregisteredEvent(n, n2));
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
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


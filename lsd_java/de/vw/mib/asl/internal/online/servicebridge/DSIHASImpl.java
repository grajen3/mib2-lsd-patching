/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.servicebridge;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.servicebridge.OnlineServiceBridge;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.DSIHASListener;
import org.dsi.ifc.has.HASDataContainer;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class DSIHASImpl
implements DSIHAS,
ServiceListener {
    private static Logger logger;
    protected int instance;
    CowArray responseListeners = new CowArray();
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHASListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public DSIHASImpl(int n) {
        this.instance = n;
        String string = new StringBuffer().append("(&(DEVICE_NAME=").append((class$org$dsi$ifc$has$DSIHASListener == null ? (class$org$dsi$ifc$has$DSIHASListener = DSIHASImpl.class$("org.dsi.ifc.has.DSIHASListener")) : class$org$dsi$ifc$has$DSIHASListener).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(DEVICE_INSTANCE=").append(this.instance).append("))").toString();
        try {
            ServiceManager.bundleContext.addServiceListener(this, string);
            ServiceReference[] serviceReferenceArray = ServiceManager.bundleContext.getServiceReferences((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSIHASImpl.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), string);
            for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
                this.responseListeners.add(ServiceManager.bundleContext.getService(serviceReferenceArray[i2]));
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            logger.error(16384, "", invalidSyntaxException);
        }
        OnlineServiceBridge.setDSIHASImpl(this);
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void hmiReady() {
        OnlineServiceBridge.getOnlineServiceBridgeController().setHmiReady(true);
    }

    @Override
    public void actionResult(int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
        OnlineServiceBridge.getOnlineServiceBridgeController().updateActionResult(n, n2, hASDataContainerArray, n3);
    }

    @Override
    public void propertyUpdate(int n, HASDataContainer[] hASDataContainerArray, int n2) {
        OnlineServiceBridge.getOnlineServiceBridgeController().updateProperty(n, hASDataContainerArray, n2);
    }

    @Override
    public void subscribeResult(int n, int n2) {
        OnlineServiceBridge.getOnlineServiceBridgeController().updateSubscribe(n, n2);
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (serviceEvent.getType() == 1) {
            ServiceReference serviceReference = serviceEvent.getServiceReference();
            this.responseListeners.add(ServiceManager.bundleContext.getService(serviceReference));
        } else if (serviceEvent.getType() == 4) {
            ServiceReference serviceReference = serviceEvent.getServiceReference();
            this.responseListeners.remove(ServiceManager.bundleContext.getService(serviceReference));
        }
    }

    public void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) {
        try {
            Object[] objectArray = this.responseListeners.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DSIHASListener)objectArray[i2]).actionRequest(n, n2, hASDataContainerArray);
            }
        }
        catch (Exception exception) {
            logger.error(16384, "", exception);
        }
    }

    public void subscribeRequest(int n, int n2) {
        try {
            Object[] objectArray = this.responseListeners.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DSIHASListener)objectArray[i2]).subscribeRequest(n, n2);
            }
        }
        catch (Exception exception) {
            logger.error(16384, "", exception);
        }
    }

    public void unsubscribeRequest(int n) {
        try {
            Object[] objectArray = this.responseListeners.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DSIHASListener)objectArray[i2]).unsubscribeRequest(n);
            }
        }
        catch (Exception exception) {
            logger.error(16384, "", exception);
        }
    }

    public void unsubscribeAllRequest() {
        try {
            Object[] objectArray = this.responseListeners.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DSIHASListener)objectArray[i2]).unsubscribeAllRequest();
            }
        }
        catch (Exception exception) {
            logger.error(16384, "", exception);
        }
    }

    public void getPropertyRequest(int n) {
        try {
            Object[] objectArray = this.responseListeners.getArray();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                ((DSIHASListener)objectArray[i2]).getPropertyRequest(n);
            }
        }
        catch (Exception exception) {
            logger.error(16384, "", exception);
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


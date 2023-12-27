/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.browser;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.common.component.AbstractComponent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.upnp.DSIUPNPBrowser;

public abstract class AbstractBrowser
extends AbstractComponent {
    private static int[] OBSERVER = new int[0];
    private static final int[] ATTR_MEDIA_CTRL_BROWSER = new int[]{2, 1};
    private DSIUPNPBrowser mDsiMediaCtrlBrowser;
    private DSIListener mDsiMediaCtrlBrowserListener;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPBrowserListener;

    public AbstractBrowser(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 352459520;
    }

    protected DSIUPNPBrowser getDSI() {
        return this.mDsiMediaCtrlBrowser;
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMediaCtrlBrowser = (DSIUPNPBrowser)dSIProxy.getService(this, class$org$dsi$ifc$upnp$DSIUPNPBrowser == null ? (class$org$dsi$ifc$upnp$DSIUPNPBrowser = AbstractBrowser.class$("org.dsi.ifc.upnp.DSIUPNPBrowser")) : class$org$dsi$ifc$upnp$DSIUPNPBrowser);
        this.mDsiMediaCtrlBrowserListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$upnp$DSIUPNPBrowserListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPBrowserListener = AbstractBrowser.class$("org.dsi.ifc.upnp.DSIUPNPBrowserListener")) : class$org$dsi$ifc$upnp$DSIUPNPBrowserListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$upnp$DSIUPNPBrowserListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPBrowserListener = AbstractBrowser.class$("org.dsi.ifc.upnp.DSIUPNPBrowserListener")) : class$org$dsi$ifc$upnp$DSIUPNPBrowserListener, this.mDsiMediaCtrlBrowserListener);
        this.mDsiMediaCtrlBrowser.setNotification(ATTR_MEDIA_CTRL_BROWSER, this.mDsiMediaCtrlBrowserListener);
    }

    private void unregisterDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$upnp$DSIUPNPBrowserListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPBrowserListener = AbstractBrowser.class$("org.dsi.ifc.upnp.DSIUPNPBrowserListener")) : class$org$dsi$ifc$upnp$DSIUPNPBrowserListener, this.mDsiMediaCtrlBrowserListener);
        this.mDsiMediaCtrlBrowser = null;
        this.mDsiMediaCtrlBrowserListener = null;
    }

    @Override
    public int getClassifier() {
        return 8;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerDSI();
                this.addObservers(OBSERVER);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 318905088, -1568276224);
                eventGeneric2.setObject(0, this);
                this.sendSafe(eventGeneric2);
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                this.unregisterDSI();
                break;
            }
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


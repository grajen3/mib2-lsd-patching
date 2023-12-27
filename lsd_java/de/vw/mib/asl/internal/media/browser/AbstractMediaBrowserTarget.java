/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBrowser;

public abstract class AbstractMediaBrowserTarget
extends AbstractMediaTarget
implements MediaListObserver {
    private static final int[] ATTR_MEDIA_BROWSER = new int[]{4, 3, 1, 2, 5, 8, 7, 6};
    private DSIMediaBrowser mDsiMediaBrowser;
    private DSIListener mDsiMediaBrowserListener;
    private final int mInstanceID;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowserListener;

    public AbstractMediaBrowserTarget(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string);
        this.mInstanceID = n;
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    @Override
    public abstract int getDefaultTargetId() {
    }

    public DSIMediaBrowser getDSI() {
        return this.mDsiMediaBrowser;
    }

    public int getInstanceId() {
        return this.mInstanceID;
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMediaBrowser = (DSIMediaBrowser)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = AbstractMediaBrowserTarget.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, this.mInstanceID);
        this.mDsiMediaBrowserListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMediaBrowserListener == null ? (class$org$dsi$ifc$media$DSIMediaBrowserListener = AbstractMediaBrowserTarget.class$("org.dsi.ifc.media.DSIMediaBrowserListener")) : class$org$dsi$ifc$media$DSIMediaBrowserListener);
        this.mDsiMediaBrowser.setNotification(ATTR_MEDIA_BROWSER, this.mDsiMediaBrowserListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$media$DSIMediaBrowserListener == null ? (class$org$dsi$ifc$media$DSIMediaBrowserListener = AbstractMediaBrowserTarget.class$("org.dsi.ifc.media.DSIMediaBrowserListener")) : class$org$dsi$ifc$media$DSIMediaBrowserListener, this.mInstanceID, this.mDsiMediaBrowserListener);
    }

    private void unregisterDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$media$DSIMediaBrowserListener == null ? (class$org$dsi$ifc$media$DSIMediaBrowserListener = AbstractMediaBrowserTarget.class$("org.dsi.ifc.media.DSIMediaBrowserListener")) : class$org$dsi$ifc$media$DSIMediaBrowserListener, this.mInstanceID, this.mDsiMediaBrowserListener);
        this.mDsiMediaBrowser = null;
        this.mDsiMediaBrowserListener = null;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerDSI();
                EventGeneric eventGeneric2 = this.newEvent(279909120, -1534721792);
                eventGeneric2.setObject(0, this);
                this.sendSafe(eventGeneric2);
                this.powerOn();
                break;
            }
            case 107: {
                this.unregisterDSI();
                this.powerOff();
                break;
            }
        }
    }

    protected void powerOn() {
    }

    protected void powerOff() {
    }

    protected String getBrowserName() {
        return new StringBuffer().append("[").append(MediaBrowserHelper.getInstanceIdStr(this.getInstanceId())).append("] ").toString();
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


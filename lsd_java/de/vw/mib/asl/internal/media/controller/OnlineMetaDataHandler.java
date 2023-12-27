/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.controller.OnlineMetaDataHandler$1;
import de.vw.mib.asl.internal.media.controller.OnlineMetaDataHandler$2;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DSIMetadataService;

public class OnlineMetaDataHandler
extends AbstractMediaTarget {
    private static int[] OBSERVER = new int[]{155076864};
    private DSIMetadataService mDsiMetaData;
    private DSIListener mDsiMetaDataListener;
    private boolean mOnlineLookupEnabled;
    private final IntObjectMap eventQueue = new IntObjectOptHashMap();
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataService;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataServiceListener;

    public OnlineMetaDataHandler(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getComponentId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getDefaultTargetId() {
        return 514790144;
    }

    private void setNotifications() {
        this.mDsiMetaData.setNotification(1, this.mDsiMetaDataListener);
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMetaData = (DSIMetadataService)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = OnlineMetaDataHandler.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService);
        this.mDsiMetaDataListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMetadataServiceListener == null ? (class$org$dsi$ifc$media$DSIMetadataServiceListener = OnlineMetaDataHandler.class$("org.dsi.ifc.media.DSIMetadataServiceListener")) : class$org$dsi$ifc$media$DSIMetadataServiceListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$media$DSIMetadataServiceListener == null ? (class$org$dsi$ifc$media$DSIMetadataServiceListener = OnlineMetaDataHandler.class$("org.dsi.ifc.media.DSIMetadataServiceListener")) : class$org$dsi$ifc$media$DSIMetadataServiceListener, this.mDsiMetaDataListener);
    }

    private void unregisterDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$media$DSIMetadataServiceListener == null ? (class$org$dsi$ifc$media$DSIMetadataServiceListener = OnlineMetaDataHandler.class$("org.dsi.ifc.media.DSIMetadataServiceListener")) : class$org$dsi$ifc$media$DSIMetadataServiceListener, this.mDsiMetaDataListener);
        this.mDsiMetaData = null;
        this.mDsiMetaDataListener = null;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerDSI();
                this.setNotifications();
                this.addObservers(OBSERVER);
                this.registerService(-926536448, true);
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                this.unregisterDSI();
                break;
            }
            case 4800009: {
                OnlineMetaDataHandler$1 onlineMetaDataHandler$1 = new OnlineMetaDataHandler$1(this);
                boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceConfigured(onlineMetaDataHandler$1);
                if (bl) {
                    ASLOnlineFactory.getOnlineCoreServices().checkOnlineServiceStatus(onlineMetaDataHandler$1, new OnlineMetaDataHandler$2(this));
                    break;
                }
                this.enableOnlineLookup(false);
                break;
            }
            case 3000008: {
                String string = eventGeneric.getString(0);
                String string2 = eventGeneric.getString(1);
                String string3 = eventGeneric.getString(2);
                int n = eventGeneric.getInt(3);
                this.mDsiMetaData.requestCoverArt(n, new CoverartInfo(string2, string, string3));
                eventGeneric.setBlocked(true);
                this.eventQueue.put(n, eventGeneric);
                break;
            }
        }
    }

    private void enableOnlineLookup(boolean bl) {
        if (this.mOnlineLookupEnabled != bl) {
            this.mOnlineLookupEnabled = bl;
            if (bl) {
                this.mDsiMetaData.enableOnlineLookup();
            } else {
                this.mDsiMetaData.disableOnlineLookup();
            }
        }
    }

    public void dsiMetadataServiceUpdateOnlineLookupStatus(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.mOnlineLookupEnabled = n == 1;
    }

    public void dsiMetadataServiceResponseCoverArt(int n, ResourceLocator resourceLocator) {
        EventGeneric eventGeneric = (EventGeneric)this.eventQueue.remove(n);
        if (eventGeneric != null) {
            eventGeneric.setObject(4, resourceLocator);
            eventGeneric.setResult(resourceLocator == null ? 12 : 0);
            this.sendBackSafe(eventGeneric);
        }
    }

    public void dsiMetadataServiceAsyncException(int n, String string, int n2) {
        if (n2 == 1000) {
            // empty if block
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

    static /* synthetic */ void access$000(OnlineMetaDataHandler onlineMetaDataHandler, boolean bl) {
        onlineMetaDataHandler.enableOnlineLookup(bl);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.common.component.AbstractComponent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.upnp.DSIUPNPPlayer;

public abstract class AbstractPlayer
extends AbstractComponent {
    private static int[] OBSERVER = new int[0];
    private static final int[] ATTR_MEDIA_CTRL_PLAYER = new int[]{1, 2, 5, 6, 7};
    private DSIUPNPPlayer mDsiMediaCtrlPlayer;
    private DSIListener mDsiMediaCtrlPlayerListener;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPPlayer;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPPlayerListener;

    public AbstractPlayer(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 335682304;
    }

    protected DSIUPNPPlayer getDSI() {
        return this.mDsiMediaCtrlPlayer;
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMediaCtrlPlayer = (DSIUPNPPlayer)dSIProxy.getService(this, class$org$dsi$ifc$upnp$DSIUPNPPlayer == null ? (class$org$dsi$ifc$upnp$DSIUPNPPlayer = AbstractPlayer.class$("org.dsi.ifc.upnp.DSIUPNPPlayer")) : class$org$dsi$ifc$upnp$DSIUPNPPlayer);
        this.mDsiMediaCtrlPlayerListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$upnp$DSIUPNPPlayerListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPPlayerListener = AbstractPlayer.class$("org.dsi.ifc.upnp.DSIUPNPPlayerListener")) : class$org$dsi$ifc$upnp$DSIUPNPPlayerListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$upnp$DSIUPNPPlayerListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPPlayerListener = AbstractPlayer.class$("org.dsi.ifc.upnp.DSIUPNPPlayerListener")) : class$org$dsi$ifc$upnp$DSIUPNPPlayerListener, this.mDsiMediaCtrlPlayerListener);
        this.mDsiMediaCtrlPlayer.setNotification(ATTR_MEDIA_CTRL_PLAYER, this.mDsiMediaCtrlPlayerListener);
    }

    private void unregisterDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$upnp$DSIUPNPPlayerListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPPlayerListener = AbstractPlayer.class$("org.dsi.ifc.upnp.DSIUPNPPlayerListener")) : class$org$dsi$ifc$upnp$DSIUPNPPlayerListener, this.mDsiMediaCtrlPlayerListener);
        this.mDsiMediaCtrlPlayer = null;
        this.mDsiMediaCtrlPlayerListener = null;
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
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 318905088, -1585053440);
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


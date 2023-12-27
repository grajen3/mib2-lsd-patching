/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.playback.LanguageSettings;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBase;
import org.dsi.ifc.media.DSIMediaPlayer;

public abstract class AbstractPlayerTarget
extends AbstractMediaTarget {
    private static final int[] ATTR_MEDIA_PLAYER = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 18, 10, 11, 12, 13, 14, 15, 16, 17};
    private DSIMediaPlayer mDsiMediaPlayer;
    private DSIListener mDsiMediaPlayerListener;
    private static final int[] ATTR_MEDIA_BASE = new int[]{1, 2, 5};
    private DSIMediaBase mDsiMediaBase;
    private DSIListener mDsiMediaBaseListener;
    protected final LanguageSettings mLanguageSettings = new LanguageSettings();
    private static int[] OBSERVER = new int[]{-938999744, 419430464, 436207680};
    public static final int EV_MEDIA_ASL_VIEWANGLE_TIMER;
    public static final int EV_DIAG_RECEIVE_REGIONCODE_DATA;
    public static final int EV_MEDIA_EXTERNAL_PAUSED;
    public static final int EV_CANCEL;
    private static final int RT_RESTORE_LANGUAGE;
    private static final int RT_FACTORY_SETTINGS;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayer;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayerListener;

    public DSIMediaPlayer getDSI() {
        return this.mDsiMediaPlayer;
    }

    protected DSIMediaBase getDsiMediaBase() {
        return this.mDsiMediaBase;
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMediaBase = (DSIMediaBase)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase);
        this.mLanguageSettings.setDsiMediaBase(this.mDsiMediaBase);
        this.mDsiMediaBaseListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener, this.mDsiMediaBaseListener);
        this.mDsiMediaPlayer = (DSIMediaPlayer)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer);
        this.mDsiMediaPlayerListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener, this.mDsiMediaPlayerListener);
    }

    private void unregisterDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener, this.mDsiMediaBaseListener);
        this.mDsiMediaBase = null;
        this.mDsiMediaBaseListener = null;
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = AbstractPlayerTarget.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener, this.mDsiMediaPlayerListener);
        this.mDsiMediaPlayer = null;
        this.mDsiMediaPlayerListener = null;
    }

    private void setNotifications() {
        this.mDsiMediaBase.setNotification(ATTR_MEDIA_BASE, this.mDsiMediaBaseListener);
        this.mDsiMediaPlayer.setNotification(ATTR_MEDIA_PLAYER, this.mDsiMediaPlayerListener);
        this.mLanguageSettings.invalidate();
    }

    public AbstractPlayerTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerDSI();
                this.setNotifications();
                this.addObservers(OBSERVER);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(1083965440);
                eventGeneric2.setInt(0, this.getTargetId());
                eventGeneric2.setInt(1, 11);
                eventGeneric2.setString(2, "NO_LANGUAGE");
                eventGeneric2.setString(3, "de.vw.mib.asl.internal.media.playback.AbstractPlayerTarget");
                this.sendSafe(eventGeneric2);
                EventGeneric eventGeneric3 = this.newEvent(279909120, -1568276224);
                eventGeneric3.setObject(0, this);
                this.sendSafe(eventGeneric3);
                this.powerOn();
                if (!this.isRegisteredForResponse(RT_FACTORY_SETTINGS)) break;
                this.fireResponse(true, "Player received PowerOn");
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                this.unregisterDSI();
                break;
            }
            case 40003: {
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                this.mLanguageSettings.setPreferredLanguage(string, n);
                break;
            }
            default: {
                this.handleEvent(eventGeneric);
            }
        }
    }

    protected abstract void handleEvent(EventGeneric eventGeneric) {
    }

    protected abstract void powerOn() {
    }

    public void rqRestoreLSCLanguageAsPreferred(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_RESTORE_LANGUAGE, responseHandler)) {
            if (this.mDsiMediaBase != null) {
                this.mLanguageSettings.restoreLSCLanguageAsPreferred();
            }
            this.fireResponse(true, RT_RESTORE_LANGUAGE);
        }
    }

    public void rqFactorySettings(int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_FACTORY_SETTINGS, responseHandler)) {
            this.getDsiMediaBase().requestResetFactorySettings(n);
        }
    }

    public void dsiMediaBaseResponseResetFactorySettings(int n, boolean bl) {
        this.fireResponse(bl, RT_FACTORY_SETTINGS);
    }

    public void dsiMediaBaseUpdatePreferredLanguage(String string, int n) {
        if (n == 1) {
            this.mLanguageSettings.handleUpdatePreferredLanguage(string);
        } else {
            this.mLanguageSettings.invalidate();
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

    static {
        RT_RESTORE_LANGUAGE = AbstractPlayerTarget.assignRequestId();
        RT_FACTORY_SETTINGS = AbstractPlayerTarget.assignRequestId();
    }
}


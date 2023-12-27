/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.sound.AbstractASLHsmSoundTarget;
import de.vw.mib.asl.internal.sound.HsmSoundMediaRouterHandling$StateSoundMediaRouterInit;
import de.vw.mib.asl.internal.sound.HsmSoundMediaRouterHandling$StateSoundMediaRouterMain;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;
import org.dsi.ifc.media.DSIMediaRouterListener;

public final class HsmSoundMediaRouterHandling
extends AbstractASLHsmSoundTarget {
    protected DSIAudioManagement dsiAudioManagement;
    protected DSIAudioManagementListener dsiAudioManagementListener;
    protected DSIMediaRouter dsiMediaRouter;
    protected DSIMediaRouterListener dsiMediaRouterListener;
    protected final HsmState stateInit;
    protected final HsmState stateMain;
    HsmSoundMediaRouterHandling target;
    protected final AudioRoute[] mediaRoutes;
    protected final int dummyDIOPhoneRinger;
    private static final IntObjectOptHashMap AUDIO_ROUTES_MAP = new IntObjectOptHashMap(25);
    static IntSet startedMLConnections;
    static IntSet startedCarPlayConnections;
    static IntSet startedAndroidAutoConnections;
    static boolean internalMedia;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouter;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouterListener;

    protected void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAudioManagement = (DSIAudioManagement)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = HsmSoundMediaRouterHandling.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement);
        this.dsiMediaRouter = (DSIMediaRouter)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaRouter == null ? (class$org$dsi$ifc$media$DSIMediaRouter = HsmSoundMediaRouterHandling.class$("org.dsi.ifc.media.DSIMediaRouter")) : class$org$dsi$ifc$media$DSIMediaRouter);
        this.dsiAudioManagementListener = (DSIAudioManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundMediaRouterHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener);
        this.dsiMediaRouterListener = (DSIMediaRouterListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$media$DSIMediaRouterListener == null ? (class$org$dsi$ifc$media$DSIMediaRouterListener = HsmSoundMediaRouterHandling.class$("org.dsi.ifc.media.DSIMediaRouterListener")) : class$org$dsi$ifc$media$DSIMediaRouterListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundMediaRouterHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener, this.dsiAudioManagementListener);
    }

    public int getRoute(AudioRoute[] audioRouteArray) {
        if (audioRouteArray == null) {
            return 0;
        }
        for (int i2 = 0; i2 < audioRouteArray.length; ++i2) {
            AudioRoute audioRoute = audioRouteArray[i2];
            if (audioRoute.getRoutingInput() == 1 && audioRoute.getRoutingOutput() == 1) {
                return 1;
            }
            if (audioRoute.getRoutingInput() == 3 && audioRoute.getRoutingOutput() == 1) {
                return 3;
            }
            if (audioRoute.getRoutingInput() == 4 && audioRoute.getRoutingOutput() == 1) {
                return 4;
            }
            if (audioRoute.getRoutingInput() == 5 && audioRoute.getRoutingOutput() == 1) {
                return 5;
            }
            if (audioRoute.getRoutingInput() != 33 || audioRoute.getRoutingOutput() != 1) continue;
            return 33;
        }
        return 0;
    }

    void setRoutes(int n) {
        AudioRoute[] audioRouteArray = (AudioRoute[])AUDIO_ROUTES_MAP.get(n);
        if (audioRouteArray != null) {
            this.setAudioRoutes(audioRouteArray);
        } else if (SoundUtil.isEntSource(n) && !SoundUtil.isSmartphoneEntertainmentSource(n) && !internalMedia) {
            this.setAudioRoutes(this.mediaRoutes);
        } else if (this.isTraceEnabled()) {
            this.trace().append("[SoundMediaRouter] no route to set for connection ").append(n).log();
        }
    }

    void setAudioRoutes(AudioRoute[] audioRouteArray) {
        if (this.isTraceEnabled()) {
            this.trace().append("[SoundMediaRouter] setAudioRoutes ").append(Arrays.toString(audioRouteArray)).log();
        }
        this.dsiMediaRouter.setAudioRoutes(audioRouteArray);
    }

    public HsmSoundMediaRouterHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new HsmSoundMediaRouterHandling$StateSoundMediaRouterInit(this, this.hsm, "SoundMediaRouterInit", this.getWorkStateParent());
        this.stateMain = new HsmSoundMediaRouterHandling$StateSoundMediaRouterMain(this, this.hsm, "SoundMediaRouterMain", this.stateInit);
        this.target = this;
        this.mediaRoutes = new AudioRoute[]{new AudioRoute(1, 1, 0)};
        this.dummyDIOPhoneRinger = 95;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getDefaultTargetId() {
        return -1271589632;
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
        AUDIO_ROUTES_MAP.put(154, new AudioRoute[]{new AudioRoute(11, 3, 0)});
        AUDIO_ROUTES_MAP.put(151, new AudioRoute[]{new AudioRoute(19, 5, 0)});
        AUDIO_ROUTES_MAP.put(152, new AudioRoute[]{new AudioRoute(12, 4, 0)});
        AUDIO_ROUTES_MAP.put(162, new AudioRoute[]{new AudioRoute(4, 1, 0)});
        AUDIO_ROUTES_MAP.put(153, new AudioRoute[]{new AudioRoute(26, 23, 0)});
        AUDIO_ROUTES_MAP.put(163, new AudioRoute[]{new AudioRoute(26, 23, 0)});
        AUDIO_ROUTES_MAP.put(SoundUtil.getConnectionCarPlayRingtone(), new AudioRoute[]{new AudioRoute(4, 1, 0)});
        AUDIO_ROUTES_MAP.put(160, new AudioRoute[]{new AudioRoute(14, 3, 0)});
        AUDIO_ROUTES_MAP.put(158, new AudioRoute[]{new AudioRoute(5, 1, 0)});
        AUDIO_ROUTES_MAP.put(156, new AudioRoute[]{new AudioRoute(5, 1, 0)});
        AUDIO_ROUTES_MAP.put(159, new AudioRoute[]{new AudioRoute(26, 24, 0)});
        AUDIO_ROUTES_MAP.put(240, new AudioRoute[]{new AudioRoute(3, 1, 0)});
        AUDIO_ROUTES_MAP.put(242, new AudioRoute[]{new AudioRoute(17, 3, 0)});
        AUDIO_ROUTES_MAP.put(243, new AudioRoute[]{new AudioRoute(16, 4, 0)});
        AUDIO_ROUTES_MAP.put(245, new AudioRoute[]{new AudioRoute(26, 25, 0)});
        AUDIO_ROUTES_MAP.put(244, new AudioRoute[]{new AudioRoute(17, 3, 0)});
        AUDIO_ROUTES_MAP.put(170, new AudioRoute[]{new AudioRoute(31, 3, 0)});
        AUDIO_ROUTES_MAP.put(168, new AudioRoute[]{new AudioRoute(32, 4, 0)});
        AUDIO_ROUTES_MAP.put(167, new AudioRoute[]{new AudioRoute(33, 1, 0)});
        AUDIO_ROUTES_MAP.put(169, new AudioRoute[]{new AudioRoute(26, 34, 0)});
        AUDIO_ROUTES_MAP.put(116, new AudioRoute[]{new AudioRoute(9, 3, 0)});
        AUDIO_ROUTES_MAP.put(117, new AudioRoute[]{new AudioRoute(9, 3, 0)});
        AUDIO_ROUTES_MAP.put(104, new AudioRoute[]{new AudioRoute(18, 5, 0)});
        AUDIO_ROUTES_MAP.put(99, new AudioRoute[]{new AudioRoute(18, 5, 0)});
        AUDIO_ROUTES_MAP.put(113, new AudioRoute[]{new AudioRoute(26, 22, 0)});
        AUDIO_ROUTES_MAP.put(112, new AudioRoute[]{new AudioRoute(10, 4, 0)});
        startedMLConnections = new IntOptHashSet(5);
        startedCarPlayConnections = new IntOptHashSet(5);
        startedAndroidAutoConnections = new IntOptHashSet(5);
        internalMedia = true;
    }
}


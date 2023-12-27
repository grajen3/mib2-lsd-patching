/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.sound;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public final class MirrorLinkAudioHandler {
    private final String classname;
    private boolean mirrorLinkAudioConnectionActive = false;
    private boolean mirrorLinkEntertainmentActive = false;
    private final MirrorLinkTarget target;

    public MirrorLinkAudioHandler(MirrorLinkTarget mirrorLinkTarget) {
        this.classname = "MirrorLinkAudioHandler";
        this.target = mirrorLinkTarget;
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    public void registerAtEntertainmentManager() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkAudioHandler").append(".registerAtEntertainmentManager()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(-899934976);
        ((EventGeneric)object).setInt(0, 9);
        this.getTarget().sendSafe((EventGeneric)object);
    }

    public void sendEntertainmentActivation(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkAudioHandler").append(new StringBuffer().append(".sendEntertainmentActivation(").append(bl).append(")").toString()).log();
        }
        int n = bl ? -1067707136 : -1050929920;
        this.getTarget().sendSafe(ServiceManager.mGenericEventFactory.newEvent(n));
        int n2 = bl ? 924081408 : 940858624;
        this.getTarget().sendSafe(ServiceManager.mGenericEventFactory.newEvent(n2));
        this.mirrorLinkAudioConnectionActive = bl;
    }

    public void handleAslApiEntertainmentAudioActivate() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkAudioHandler").append(".handleAslApiEntertainmentAudioActivate()").log();
        }
        this.entertainmentAudioActivate();
    }

    public void handleAslApiEntertainmentAudioActivateStartup() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkAudioHandler").append(".handleAslApiEntertainmentAudioActivateStartup()").log();
        }
        this.entertainmentAudioActivate();
        this.entertainmentAudioSetVolumeLock();
    }

    public void handleAslApiEntertainmentAudioDeactivate() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkAudioHandler").append(".handleAslApiEntertainmentAudioDeactivate()").log();
        }
        this.entertainmentAudioDeactivate();
    }

    private void entertainmentAudioActivate() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setInt(0, 240);
        eventGeneric.setBoolean(1, false);
        eventGeneric.setBoolean(2, true);
        eventGeneric.setSenderEventId(-1551499008);
        this.getTarget().sendSafe(eventGeneric);
    }

    public void entertainmentAudioDeactivate() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkAudioHandler").append(".entertainmentAudioDeactivate()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(67714304);
        ((EventGeneric)object).setInt(0, 240);
        ((EventGeneric)object).setSenderEventId(-1534721792);
        this.getTarget().sendSafe((EventGeneric)object);
        int n = 940858624;
        this.getTarget().sendSafe(ServiceManager.mGenericEventFactory.newEvent(n));
    }

    public void entertainmentAudioSetVolumeLock() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkAudioHandler").append(".entertainmentAudioSetVolumeLock()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(185154816);
        ((EventGeneric)object).setInt(0, 240);
        this.getTarget().sendSafe((EventGeneric)object);
    }

    public void entertainmentAudioSetVolumeRelease() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkAudioHandler").append(".entertainmentAudioSetVolumeRelease()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(201932032);
        ((EventGeneric)object).setInt(0, 240);
        this.getTarget().sendSafe((EventGeneric)object);
    }

    public void requestAudioConnection(int n, boolean bl) {
        int n2;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkAudioHandler").append(".requestAudioConnection(").append(n).append(new StringBuffer().append(", ").append(bl).append(")").toString()).log();
        }
        if (240 == (n2 = this.getAudioHMIFromMirrorLinkAudioDSI(n))) {
            if (bl) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-916712192);
                eventGeneric.setInt(0, 0);
                eventGeneric.setInt(1, 9);
                this.getTarget().sendSafe(eventGeneric);
            }
            this.setMirrorLinkEntertainmentActive(true);
        } else if (n2 != 0) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
            eventGeneric.setInt(0, n2);
            eventGeneric.setSenderEventId(-1551499008);
            this.getTarget().sendSafe(eventGeneric);
        } else if (this.getTarget().isTraceEnabled()) {
            this.getTarget().warn().append("Unknown audio connection label: ").append(n2).log();
        }
    }

    public void releaseAudioConnection(int n) {
        int n2;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkAudioHandler").append(".releaseAudioConnection()").log();
        }
        if (240 == (n2 = this.getAudioHMIFromMirrorLinkAudioDSI(n))) {
            this.setMirrorLinkEntertainmentActive(false);
        } else if (n2 != 0) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric.setInt(0, n2);
            eventGeneric.setSenderEventId(-1534721792);
            this.getTarget().sendSafe(eventGeneric);
        }
    }

    public boolean isMirrorLinkAudioConnectionActive() {
        return this.mirrorLinkAudioConnectionActive;
    }

    public boolean isMirrorLinkEntertainmentActive() {
        return this.mirrorLinkEntertainmentActive;
    }

    public void setMirrorLinkEntertainmentActive(boolean bl) {
        this.mirrorLinkEntertainmentActive = bl;
    }

    public int getAudioHMIFromMirrorLinkAudioDSI(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 240;
                break;
            }
            case 1: {
                n2 = 241;
                break;
            }
            case 2: {
                n2 = 242;
                break;
            }
            case 3: {
                n2 = 244;
                break;
            }
            case 4: {
                n2 = 243;
                break;
            }
            case 6: {
                n2 = 245;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public int getMirrorLinkAudioConnectionDSIFromAudioHMI(int n) {
        int n2;
        switch (n) {
            case 240: {
                n2 = 0;
                break;
            }
            case 241: {
                n2 = 1;
                break;
            }
            case 242: {
                n2 = 2;
                break;
            }
            case 244: {
                n2 = 3;
                break;
            }
            case 243: {
                n2 = 4;
                break;
            }
            case 245: {
                n2 = 6;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    public int getAudioConnectionForAppCategory(int n) {
        int n2 = 0;
        switch (n) {
            case 131072: {
                n2 = 1;
                break;
            }
            case -268435424: 
            case 196608: 
            case 196609: 
            case 196610: 
            case 196611: {
                n2 = 0;
                break;
            }
            case 327680: {
                n2 = 2;
                break;
            }
            case -268435440: 
            case -65520: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public boolean checkIfAudioConnectionForAppRequired(int n, int n2) {
        return n != 0 ? n2 != this.getAudioConnectionForAppCategory(n) : n2 != 240;
    }
}


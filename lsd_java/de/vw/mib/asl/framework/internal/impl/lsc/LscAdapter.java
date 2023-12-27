/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.LscAdapter$ListenerId;
import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;

public class LscAdapter {
    private static final int SKINMODE_DAYNIGHT_CHANGE_RESULT;
    private static final int SKIN_CHANGE_RESULT;
    private static final int LANGUAGE_CHANGE_RESULT;
    private static final int UNSPECIFIED_SENDER;
    private final IntObjectMap changerCallbacks = new IntObjectOptHashMap();
    private final EventDispatcherHSM eventDispatcher;
    private final EventFactory eventFactory;
    private final Logger log;

    public LscAdapter(EventDispatcherHSM eventDispatcherHSM, EventFactory eventFactory, Logger logger) {
        Preconditions.checkArgumentNotNull(eventDispatcherHSM, "Argument >eventDispatcher< must not be null!");
        Preconditions.checkArgumentNotNull(eventFactory, "Argument >eventFactory< must not be null!");
        Preconditions.checkArgumentNotNull(logger, "Argument >log< must not be null!");
        this.eventDispatcher = eventDispatcherHSM;
        this.eventFactory = eventFactory;
        this.log = logger;
    }

    public void handleChangeResult(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (n == 1151074304) {
            this.processLanguageChangeResult(eventGeneric);
        } else if (n == 1218183168) {
            this.processSkinChangeResult(eventGeneric);
        } else if (n == 1184628736) {
            this.processSkinModeResult(eventGeneric);
        }
    }

    private void processSkinModeResult(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        boolean bl = eventGeneric.getBoolean(1);
        int n2 = eventGeneric.getInt(2);
        this.setSkinModeChangeResult(n, n2, bl);
    }

    private void setSkinModeChangeResult(int n, int n2, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(" Calling setSkinModeChangeResult for transaction: ").append(n).toString());
        }
        this.checkChangeIsPendig(n, "skin-mode");
        SkinmodeChanger skinmodeChanger = (SkinmodeChanger)this.changerCallbacks.remove(n);
        skinmodeChanger.setChangeResult(n, bl, n2);
    }

    private void processSkinChangeResult(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        boolean bl = eventGeneric.getBoolean(1);
        int n2 = eventGeneric.getInt(2);
        this.setSkinChangeResult(n, n2, bl);
    }

    private void setSkinChangeResult(int n, int n2, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(" Calling setSkinChangeResult for transaction: ").append(n).append(" result=").append(bl).append(" newSkin=").append(n2).toString());
        }
        this.checkChangeIsPendig(n, "skin");
        SkinChanger skinChanger = (SkinChanger)this.changerCallbacks.remove(n);
        skinChanger.setChangeResult(n, bl, n2);
    }

    private void setLanguageChangeResult(int n, String string, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(" Calling setLanguageChangeResult for transaction: ").append(n).append(" result=").append(bl).append(" lang=").append(string).toString());
        }
        this.checkChangeIsPendig(n, "language");
        LanguageChanger languageChanger = (LanguageChanger)this.changerCallbacks.remove(n);
        languageChanger.setChangeResult(n, bl, string);
    }

    private void processLanguageChangeResult(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        boolean bl = eventGeneric.getBoolean(1);
        String string = eventGeneric.getString(2);
        this.setLanguageChangeResult(n, string, bl);
    }

    public void onNewLanguage(LanguageChanger languageChanger, int n, int n2, String string) {
        this.checkCallbackNotNull(languageChanger);
        this.checkChangeNotPending(n, "language");
        this.checkLanguageNotNull(string);
        this.changerCallbacks.put(n, languageChanger);
        LscAdapter$ListenerId lscAdapter$ListenerId = new LscAdapter$ListenerId(n2);
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(" Changing to language=").append(string).append(", ").append(lscAdapter$ListenerId).append(", changeId=").append(n).toString());
            this.trace(new StringBuffer().append("Combined Type was: ").append(n2).append(" extracted Listener type:").append(lscAdapter$ListenerId.type).append(" target:  ").append(lscAdapter$ListenerId.aslTargetId).toString());
        }
        this.send(this.createChangeLanguageEvent(string, n, lscAdapter$ListenerId));
    }

    private EventGeneric createChangeLanguageEvent(String string, int n, LscAdapter$ListenerId lscAdapter$ListenerId) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(0, lscAdapter$ListenerId.aslTargetId, 1134297088);
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        eventGeneric.setInt(2, lscAdapter$ListenerId.type);
        return eventGeneric;
    }

    public void onNewSkin(SkinChanger skinChanger, int n, int n2, int n3) {
        this.checkCallbackNotNull(skinChanger);
        this.checkChangeNotPending(n, "skin");
        LscAdapter$ListenerId lscAdapter$ListenerId = new LscAdapter$ListenerId(n2);
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(" Changing to skin=").append(n3).append(", ").append(lscAdapter$ListenerId).append(", changeId=").append(n).toString());
        }
        this.changerCallbacks.put(n, skinChanger);
        this.send(this.createChangeSkinEvent(n3, n, lscAdapter$ListenerId));
    }

    private EventGeneric createChangeSkinEvent(int n, int n2, LscAdapter$ListenerId lscAdapter$ListenerId) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(0, lscAdapter$ListenerId.aslTargetId, 1201405952);
        eventGeneric.setInt(0, n2);
        eventGeneric.setInt(1, n);
        eventGeneric.setInt(2, lscAdapter$ListenerId.type);
        return eventGeneric;
    }

    public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2, int n3) {
        boolean bl;
        this.checkCallbackNotNull(skinmodeChanger);
        this.checkChangeNotPending(n, "skin-mode");
        LscAdapter$ListenerId lscAdapter$ListenerId = new LscAdapter$ListenerId(n2);
        boolean bl2 = bl = n3 == 0;
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(" Changing to skinmode=").append(n3).append(", ").append(lscAdapter$ListenerId).append(", changeId=").append(n).toString());
        }
        this.changerCallbacks.put(n, skinmodeChanger);
        this.send(this.createChangeSkinModeEvent(bl, n, lscAdapter$ListenerId));
    }

    private EventGeneric createChangeSkinModeEvent(boolean bl, int n, LscAdapter$ListenerId lscAdapter$ListenerId) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(0, lscAdapter$ListenerId.aslTargetId, 1167851520);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setInt(2, lscAdapter$ListenerId.type);
        return eventGeneric;
    }

    private void send(EventGeneric eventGeneric) {
        this.eventDispatcher.sendSafe(eventGeneric);
    }

    private void trace(String string) {
        this.log.trace(64).append("[AslTargetLscTNGBullhorn]").append(string).log();
    }

    private boolean isTraceEnabled() {
        return this.log.isTraceEnabled(64);
    }

    private void checkChangeNotPending(int n, String string) {
        if (!this.changerCallbacks.containsKey(n)) {
            return;
        }
        String string2 = new StringBuffer().append("Unable to perform ").append(string).append(" change with change-id >").append(n).append("< cause a change with this change-id is pending!").toString();
        throw new IllegalStateException(string2);
    }

    private void checkChangeIsPendig(int n, String string) {
        if (this.changerCallbacks.containsKey(n)) {
            return;
        }
        String string2 = new StringBuffer().append("Unable to process ").append(string).append(" change result, cause no ").append(string).append(" change is pending with change-id:").append(n).toString();
        throw new IllegalStateException(string2);
    }

    private void checkLanguageNotNull(String string) {
        Preconditions.checkArgumentNotNull(string, "Argument >language< must not be null!");
    }

    private void checkCallbackNotNull(Object object) {
        Preconditions.checkArgumentNotNull(object, "Argument >callback< must not be null!");
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.DSIMediaBase;

public class LanguageSettings {
    private int lscTransactionId = -1;
    private String lscLanguage;
    private String lscLanguageOrig;
    private DSIMediaBase dsiMediaBase;
    private String lastUpdatedLanguage = null;

    LanguageSettings() {
    }

    public void invalidate() {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("de.vw.mib.asl.internal.media.playback.LanguageSettings.invalidate()").log();
        }
        this.lastUpdatedLanguage = null;
    }

    public void handleUpdatePreferredLanguage(String string) {
        this.lastUpdatedLanguage = string;
        if (this.lscTransactionId != -1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
            eventGeneric.setInt(0, this.lscTransactionId);
            eventGeneric.setBoolean(1, this.lscLanguage.equals(string));
            eventGeneric.setString(2, this.lscLanguageOrig);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
            this.lscTransactionId = -1;
        }
    }

    public void restoreLSCLanguageAsPreferred() {
        if (!Util.isNullOrEmpty(this.lscLanguage)) {
            this.setPreferredLanguage(this.lscLanguage, -1);
        }
    }

    public void setPreferredLanguage(String string, int n) {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("de.vw.mib.asl.internal.media.playback.LanguageSettings.setPreferredLanguage(language=").append(string).append(", lscTransactionId=").append(n).append(")").log();
        }
        if (n != -1) {
            this.lscLanguageOrig = string;
            this.lscTransactionId = n;
            this.lscLanguage = ServiceManager.configManagerDiag.getLanguageReplacement(string);
        }
        if (!string.equals(this.lastUpdatedLanguage) && !string.equals("NO_LANGUAGE")) {
            this.dsiMediaBase.setPreferredLanguage(this.lscLanguage);
        } else {
            this.handleUpdatePreferredLanguage(string);
        }
    }

    void setDsiMediaBase(DSIMediaBase dSIMediaBase) {
        this.dsiMediaBase = dSIMediaBase;
    }
}


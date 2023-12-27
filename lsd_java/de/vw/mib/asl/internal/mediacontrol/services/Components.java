/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.internal.mediacontrol.components.browser.Browser;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;
import de.vw.mib.util.Util;

public class Components {
    private Player mPlayer = null;
    private Browser mBrowser = null;
    public static final int PLAYER;
    public static final int BROWSER;
    public static final int ALL;

    public Player getPlayer() {
        return this.mPlayer;
    }

    void setPlayer(Player player) {
        this.mPlayer = player;
    }

    public Browser getBrowser() {
        return this.mBrowser;
    }

    void setBrowser(Browser browser) {
        this.mBrowser = browser;
    }

    public static String getComponentsStr(int n) {
        String string = "";
        if (n == -1) {
            return "ALL";
        }
        if (Util.isBitSet(1, n)) {
            string = new StringBuffer().append(string).append("|PLAYER").toString();
        }
        if (Util.isBitSet(2, n)) {
            string = new StringBuffer().append(string).append("|BROWSER").toString();
        }
        if (string.trim().length() == 0) {
            return "NONE";
        }
        return string.substring(1);
    }
}


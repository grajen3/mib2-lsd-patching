/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class LeagueEntry {
    public int seekID;
    public int contentLink;
    public String leagueName;
    public String leagueNameAbbrevation;

    public LeagueEntry() {
        this.seekID = 0;
        this.contentLink = 0;
        this.leagueName = "";
        this.leagueNameAbbrevation = "";
    }

    public LeagueEntry(int n, int n2, String string, String string2) {
        this.seekID = n;
        this.contentLink = n2;
        this.leagueName = string;
        this.leagueNameAbbrevation = string2;
    }

    public int getSeekID() {
        return this.seekID;
    }

    public int getContentLink() {
        return this.contentLink;
    }

    public String getLeagueName() {
        return this.leagueName;
    }

    public String getLeagueNameAbbrevation() {
        return this.leagueNameAbbrevation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("LeagueEntry");
        stringBuffer.append('(');
        stringBuffer.append("seekID");
        stringBuffer.append('=');
        stringBuffer.append(this.seekID);
        stringBuffer.append(',');
        stringBuffer.append("contentLink");
        stringBuffer.append('=');
        stringBuffer.append(this.contentLink);
        stringBuffer.append(',');
        stringBuffer.append("leagueName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.leagueName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("leagueNameAbbrevation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.leagueNameAbbrevation);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


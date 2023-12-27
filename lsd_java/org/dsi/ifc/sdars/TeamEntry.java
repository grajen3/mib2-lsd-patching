/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class TeamEntry {
    public int seekID;
    public int contentLink;
    public int leagueLink;
    public String teamName;
    public String teamNameAbbrevation;
    public String teamNameNick;

    public TeamEntry() {
        this.seekID = 0;
        this.contentLink = 0;
        this.leagueLink = 0;
        this.teamName = "";
        this.teamNameAbbrevation = "";
        this.teamNameNick = "";
    }

    public TeamEntry(int n, int n2, int n3, String string, String string2, String string3) {
        this.seekID = n;
        this.contentLink = n2;
        this.leagueLink = n3;
        this.teamName = string;
        this.teamNameAbbrevation = string2;
        this.teamNameNick = string3;
    }

    public int getSeekID() {
        return this.seekID;
    }

    public int getContentLink() {
        return this.contentLink;
    }

    public int getLeagueLink() {
        return this.leagueLink;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getTeamNameAbbrevation() {
        return this.teamNameAbbrevation;
    }

    public String getTeamNameNick() {
        return this.teamNameNick;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("TeamEntry");
        stringBuffer.append('(');
        stringBuffer.append("seekID");
        stringBuffer.append('=');
        stringBuffer.append(this.seekID);
        stringBuffer.append(',');
        stringBuffer.append("contentLink");
        stringBuffer.append('=');
        stringBuffer.append(this.contentLink);
        stringBuffer.append(',');
        stringBuffer.append("leagueLink");
        stringBuffer.append('=');
        stringBuffer.append(this.leagueLink);
        stringBuffer.append(',');
        stringBuffer.append("teamName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.teamName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("teamNameAbbrevation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.teamNameAbbrevation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("teamNameNick");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.teamNameNick);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


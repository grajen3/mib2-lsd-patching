/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.sports;

public class Team {
    private int sportsId = -1;
    private String teamName = "";

    public Team(int n, String string) {
        this.sportsId = n;
        this.teamName = string;
    }

    public int getSportsId() {
        return this.sportsId;
    }

    public void setSportsId(int n) {
        this.sportsId = n;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String string) {
        this.teamName = string;
    }

    public String toString() {
        return new StringBuffer().append("Team id - ").append(this.sportsId).append("Team Name - ").append(this.teamName).toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homescreen;

public class HomeScreenPages$Page {
    public static final HomeScreenPages$Page NON = new HomeScreenPages$Page("NO_PAGE");
    public static final HomeScreenPages$Page LEFT = new HomeScreenPages$Page("LEFT_PAGE");
    public static final HomeScreenPages$Page RIGHT = new HomeScreenPages$Page("RIGHT_PAGE");
    private final String name;

    private HomeScreenPages$Page(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}


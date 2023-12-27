/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.commons;

import de.esolutions.fw.util.config.query.ConfigPathQuery;

public class PriorityParser {
    public static final int DISABLED;

    public static int parse(ConfigPathQuery configPathQuery, String string, int n, boolean bl) {
        int n2 = n;
        String string2 = configPathQuery.getStringValue(string);
        if (string2 == null) {
            n2 = configPathQuery.getIntegerValue(string, n2);
        } else {
            String string3 = string2.toLowerCase();
            if (string3.equals("min")) {
                n2 = 1;
            } else if (string3.equals("max")) {
                n2 = 10;
            } else if (string3.equals("norm")) {
                n2 = 5;
            }
        }
        if (bl && n2 == -1) {
            return -1;
        }
        if (n2 < 1) {
            n2 = 1;
        } else if (n2 > 10) {
            n2 = 10;
        }
        return n2;
    }
}


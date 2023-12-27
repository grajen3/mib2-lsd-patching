/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.id;

public final class IdHelper {
    private IdHelper() {
    }

    public static String getResult(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "OK";
                break;
            }
            case 1: {
                string = "NOTHANDLED";
                break;
            }
            case 2: {
                string = "WRONGSTATE";
                break;
            }
            case 3: {
                string = "EXCEPTION";
                break;
            }
            case 4: {
                string = "WRONGSLOTTYPE";
                break;
            }
            case 5: {
                string = "NOTFOUND";
                break;
            }
            case 6: {
                string = "NO_OWNER";
                break;
            }
            case 7: {
                string = "UNKNOWN_TARGET";
                break;
            }
            case 8: {
                string = "UNKNOWN_SERVICE";
                break;
            }
            case 9: {
                string = "NOT_SUPPORTED";
                break;
            }
            case 10: {
                string = "WRONG_ARGUMENTS";
                break;
            }
            case 1000: {
                string = "PRIVATE";
                break;
            }
            default: {
                string = new StringBuffer().append("Unknown(").append(n).append(")").toString();
            }
        }
        return string;
    }
}


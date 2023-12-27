/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;

public class URISyntaxException
extends Exception {
    private String input;
    private int index;

    public URISyntaxException(String string, String string2, int n) {
        super(string2);
        if (string == null || string2 == null) {
            throw new NullPointerException();
        }
        if (n < -1) {
            throw new IllegalArgumentException();
        }
        this.input = string;
        this.index = n;
    }

    public URISyntaxException(String string, String string2) {
        super(string2);
        if (string == null || string2 == null) {
            throw new NullPointerException();
        }
        this.input = string;
        this.index = -1;
    }

    public int getIndex() {
        return this.index;
    }

    public String getReason() {
        return super.getMessage();
    }

    public String getInput() {
        return this.input;
    }

    @Override
    public String getMessage() {
        String string = super.getMessage();
        if (this.index != -1) {
            return Msg.getString("K0326", new String[]{string, Integer.toString(this.index), this.input});
        }
        return Msg.getString("K0327", new String[]{string, this.input});
    }
}


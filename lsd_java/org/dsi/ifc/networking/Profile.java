/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class Profile {
    public int identifier;
    public String name;
    public String[] keys;
    public short keyNumber;
    public boolean sSIDBroadcast;
    public String sSID;
    public int cryptoModel;
    public int authenticationModel;
    public boolean active;
    public int channel;

    public Profile() {
        this.identifier = 0;
        this.name = null;
        this.keys = null;
        this.keyNumber = 0;
        this.sSIDBroadcast = false;
        this.sSID = null;
        this.cryptoModel = 0;
        this.authenticationModel = 0;
        this.active = false;
        this.channel = 0;
    }

    public Profile(int n, String string, String[] stringArray, short s, boolean bl, String string2, int n2, int n3, boolean bl2, int n4) {
        this.identifier = n;
        this.name = string;
        this.keys = stringArray;
        this.keyNumber = s;
        this.sSIDBroadcast = bl;
        this.sSID = string2;
        this.cryptoModel = n2;
        this.authenticationModel = n3;
        this.active = bl2;
        this.channel = n4;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public String[] getKeys() {
        return this.keys;
    }

    public short getKeyNumber() {
        return this.keyNumber;
    }

    public boolean isSSIDBroadcast() {
        return this.sSIDBroadcast;
    }

    public String getSSID() {
        return this.sSID;
    }

    public int getCryptoModel() {
        return this.cryptoModel;
    }

    public int getAuthenticationModel() {
        return this.authenticationModel;
    }

    public boolean isActive() {
        return this.active;
    }

    public int getChannel() {
        return this.channel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("Profile");
        stringBuffer.append('(');
        stringBuffer.append("identifier");
        stringBuffer.append('=');
        stringBuffer.append(this.identifier);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("keys");
        stringBuffer.append('[');
        if (this.keys != null) {
            stringBuffer.append(this.keys.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.keys != null) {
            int n = this.keys.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.keys[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.keys);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("keyNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.keyNumber);
        stringBuffer.append(',');
        stringBuffer.append("sSIDBroadcast");
        stringBuffer.append('=');
        stringBuffer.append(this.sSIDBroadcast);
        stringBuffer.append(',');
        stringBuffer.append("sSID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sSID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("cryptoModel");
        stringBuffer.append('=');
        stringBuffer.append(this.cryptoModel);
        stringBuffer.append(',');
        stringBuffer.append("authenticationModel");
        stringBuffer.append('=');
        stringBuffer.append(this.authenticationModel);
        stringBuffer.append(',');
        stringBuffer.append("active");
        stringBuffer.append('=');
        stringBuffer.append(this.active);
        stringBuffer.append(',');
        stringBuffer.append("channel");
        stringBuffer.append('=');
        stringBuffer.append(this.channel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


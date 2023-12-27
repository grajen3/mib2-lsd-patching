/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.Token;

public class ConflictMatch {
    public Token token;
    public Country country;
    public int type;

    public ConflictMatch() {
        this.token = null;
        this.country = null;
        this.type = 0;
    }

    public ConflictMatch(Token token, Country country, int n) {
        this.token = token;
        this.country = country;
        this.type = n;
    }

    public Token getToken() {
        return this.token;
    }

    public Country getCountry() {
        return this.country;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("ConflictMatch");
        stringBuffer.append('(');
        stringBuffer.append("token");
        stringBuffer.append('=');
        stringBuffer.append(this.token);
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append(this.country);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


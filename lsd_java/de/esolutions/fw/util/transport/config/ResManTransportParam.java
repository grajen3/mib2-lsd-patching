/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.config.query.IConfigQuery;
import java.io.File;

public class ResManTransportParam {
    private String path;

    public static ResManTransportParam create(IConfigQuery iConfigQuery) {
        String string = iConfigQuery.getStringValue("resman.path");
        if (string == null) {
            return null;
        }
        if (string.charAt(0) != File.separatorChar) {
            String string2 = iConfigQuery.getStringValue("resman.root_path");
            if (string2 == null) {
                return null;
            }
            string = new StringBuffer().append(string2).append(File.separatorChar).append(string).toString();
        }
        return new ResManTransportParam(string);
    }

    private ResManTransportParam(String string) {
        this.path = string;
    }

    public String getPath() {
        return this.path;
    }

    public String toString() {
        return new StringBuffer().append("[ResMan:").append(this.path).append("]").toString();
    }
}


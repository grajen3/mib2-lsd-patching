/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle$1;
import java.util.ResourceBundle;

public class PropertyResourceBundle
extends ResourceBundle {
    final Properties resources = new Properties();

    public PropertyResourceBundle(InputStream inputStream) {
        this.resources.load(inputStream);
    }

    @Override
    public Enumeration getKeys() {
        if (this.parent == null) {
            return this.resources.keys();
        }
        return new PropertyResourceBundle$1(this);
    }

    @Override
    public Object handleGetObject(String string) {
        return this.resources.get(string);
    }
}


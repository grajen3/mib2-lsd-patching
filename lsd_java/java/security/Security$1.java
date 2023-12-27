/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;

final class Security$1
implements PrivilegedAction {
    Security$1() {
    }

    @Override
    public Object run() {
        String string;
        int n = 1;
        while ((string = Security.getProperty(new StringBuffer("security.provider.").append(n++).toString())) != null) {
            try {
                Class clazz = Class.forName(string, true, ClassLoader.getSystemClassLoader());
                Provider provider = (Provider)clazz.newInstance();
                Security.access$1(provider, Security.access$0().size() + 1);
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {}
        }
        return null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.adapter;

import de.vw.mib.asl.framework.internal.dsiproxy.adapter.MethodResolver;
import java.lang.reflect.Method;

final class DSITypePrefixMethodResolver
implements MethodResolver {
    private static final String METHOD_PREFIX;
    private static final int METHOD_PREFIX_LENGTH;
    private static final int TYPE_NAME_START_SKIP;
    private static final int TYPE_NAME_END_SKIP;

    DSITypePrefixMethodResolver() {
    }

    @Override
    public String resolveName(Object object, Class clazz, Method method) {
        String string = clazz.getName();
        String string2 = method.getName();
        int n = string.lastIndexOf(46);
        string = string.substring(n + 1 + TYPE_NAME_START_SKIP, string.length() - TYPE_NAME_END_SKIP);
        StringBuffer stringBuffer = new StringBuffer(METHOD_PREFIX_LENGTH + string.length() + string2.length());
        stringBuffer.append("dsi");
        stringBuffer.append(string);
        n = stringBuffer.length();
        stringBuffer.append(string2);
        stringBuffer.setCharAt(n, Character.toUpperCase(string2.charAt(0)));
        return stringBuffer.toString();
    }

    static {
        METHOD_PREFIX_LENGTH = "dsi".length();
        TYPE_NAME_START_SKIP = "DSI".length();
        TYPE_NAME_END_SKIP = "Listener".length();
    }
}


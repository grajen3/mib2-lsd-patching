/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.DynamicLookupHelper;
import java.lang.reflect.Field;

public class ProcAddressHelper {
    public static final String PROCADDRESS_VAR_PREFIX;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$com$sun$gluegen$runtime$ProcAddressHelper;

    public static void resetProcAddressTable(Object object, DynamicLookupHelper dynamicLookupHelper) {
        Class clazz = object.getClass();
        Field[] fieldArray = clazz.getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            String string = fieldArray[i2].getName();
            if (!string.startsWith("_addressof_")) continue;
            int n = "_addressof_".length();
            String string2 = string.substring(n);
            try {
                Field field = fieldArray[i2];
                if (!$assertionsDisabled && field.getType() != Long.TYPE) {
                    throw new AssertionError();
                }
                long l = dynamicLookupHelper.dynamicLookupFunction(string2);
                field.setLong(object, l);
                continue;
            }
            catch (Exception exception) {
                throw new RuntimeException(new StringBuffer().append("Can not get proc address for method \"").append(string2).append("\": Couldn't set value of field \"").append(string).append("\" in class ").append(clazz.getName()).toString(), exception);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$com$sun$gluegen$runtime$ProcAddressHelper == null ? (class$com$sun$gluegen$runtime$ProcAddressHelper = ProcAddressHelper.class$("com.sun.gluegen.runtime.ProcAddressHelper")) : class$com$sun$gluegen$runtime$ProcAddressHelper).desiredAssertionStatus();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.DeprecatedListTransformer;
import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.log4mib.LogMessage;

class ASLListFactoryImpl
implements ASLListFactory {
    private final Services services;

    ASLListFactoryImpl(Services services) {
        this.services = services;
    }

    @Override
    public GenericASLList createGenericASLList(ItemTransformer itemTransformer, int n, String string, String string2) {
        return new GenericASLList(this.services, itemTransformer, n, string, string2);
    }

    @Override
    public DirectWindowList createDirectWindowList(ItemTransformer itemTransformer, int n, String string, String string2) {
        return new DirectWindowList(this.services, itemTransformer, n, string, string2);
    }

    @Override
    public ItemTransformer getDeprecatedTransformer(int n, String string, String string2, String string3, String string4) {
        ItemTransformer itemTransformer;
        LogMessage logMessage;
        block7: {
            ClassLoader classLoader = super.getClass().getClassLoader();
            if (null == classLoader) {
                classLoader = Thread.currentThread().getContextClassLoader();
            }
            if (null == classLoader) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
            if (null != (logMessage = this.services.getASLListLog().warn())) {
                logMessage.append("TransformerUtil: Request for deprecated list [listId=").append(n).append(", name=\"");
                logMessage.append(string3).append('.');
                logMessage.append(string4).append("\"]; transformer ");
            }
            try {
                Class clazz = classLoader.loadClass(new StringBuffer().append(string).append(string2).toString());
                itemTransformer = (ItemTransformer)clazz.newInstance();
                if (null != logMessage) {
                    logMessage.append("available");
                }
            }
            catch (Exception exception) {
                itemTransformer = DeprecatedListTransformer.INSTANCE;
                if (null == logMessage) break block7;
                logMessage.append("NOT available, using dummy");
            }
        }
        if (null != logMessage) {
            logMessage.append(" [transformer=").append(string2).append("]").log();
        }
        return itemTransformer;
    }
}


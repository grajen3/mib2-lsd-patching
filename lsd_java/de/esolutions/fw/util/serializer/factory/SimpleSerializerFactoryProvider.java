/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactoryProvider;
import de.esolutions.fw.util.serializer.factory.LEDefaultSerializerFactory;
import java.util.HashMap;
import java.util.Map;

public class SimpleSerializerFactoryProvider
implements ISerializerFactoryProvider {
    protected Map procMap;
    protected Map nodeMap;
    protected String myProcName;

    public SimpleSerializerFactoryProvider(String string) {
        this.myProcName = string;
        this.procMap = new HashMap();
        this.nodeMap = new HashMap();
    }

    public void addConnection(String string, String string2, String string3, boolean bl) {
        Boolean bl2 = new Boolean(bl);
        this.procMap.put(new StringBuffer().append(string).append(":").append(string2).toString(), bl2);
        this.nodeMap.put(new StringBuffer().append(string).append(":").append(string3).append(":").append(string2).toString(), bl2);
    }

    @Override
    public ISerializerFactory createSerializerFactory(String string, String string2) {
        String string3 = new StringBuffer().append(string).append(":").append(string2).toString();
        Boolean bl = (Boolean)this.procMap.get(string3);
        if (bl == null) {
            throw new SerializerFactoryException(new StringBuffer().append("no serializer found for proc ").append(string3).toString());
        }
        if (bl.booleanValue()) {
            return new LEDefaultSerializerFactory();
        }
        return new BEDefaultSerializerFactory();
    }

    @Override
    public ISerializerFactory createMySerializerFactory(String string, String string2) {
        String string3 = new StringBuffer().append(string).append(":").append(string2).append(":").append(this.myProcName).toString();
        Boolean bl = (Boolean)this.nodeMap.get(string3);
        if (bl == null) {
            throw new SerializerFactoryException(new StringBuffer().append("no serializer found for node ").append(string3).toString());
        }
        if (bl.booleanValue()) {
            return new LEDefaultSerializerFactory();
        }
        return new BEDefaultSerializerFactory();
    }
}


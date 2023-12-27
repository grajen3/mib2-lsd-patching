/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.id.AbstractStringIdentifierGenerator;
import org.apache.commons.id.StringIdentifierGenerator;

public class CompositeIdentifierGenerator
extends AbstractStringIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID;
    private final StringIdentifierGenerator[] identifierGenerators;

    public static StringIdentifierGenerator getInstance(StringIdentifierGenerator[] stringIdentifierGeneratorArray) {
        if (stringIdentifierGeneratorArray == null) {
            throw new IllegalArgumentException("Generator array must not be null");
        }
        if (stringIdentifierGeneratorArray.length == 0) {
            throw new IllegalArgumentException("Generator array must not be empty");
        }
        StringIdentifierGenerator[] stringIdentifierGeneratorArray2 = new StringIdentifierGenerator[stringIdentifierGeneratorArray.length];
        for (int i2 = 0; i2 < stringIdentifierGeneratorArray.length; ++i2) {
            if (stringIdentifierGeneratorArray[i2] == null) {
                throw new IllegalArgumentException("Generators must not be null");
            }
            stringIdentifierGeneratorArray2[i2] = stringIdentifierGeneratorArray[i2];
        }
        return new CompositeIdentifierGenerator(stringIdentifierGeneratorArray2);
    }

    public static StringIdentifierGenerator getInstance(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Generator collection must not be null");
        }
        if (collection.size() == 0) {
            throw new IllegalArgumentException("Generator collection must not be empty");
        }
        StringIdentifierGenerator[] stringIdentifierGeneratorArray = new StringIdentifierGenerator[collection.size()];
        int n = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            stringIdentifierGeneratorArray[n] = (StringIdentifierGenerator)iterator.next();
            if (stringIdentifierGeneratorArray[n] == null) {
                throw new IllegalArgumentException("Generators must not be null");
            }
            ++n;
        }
        return new CompositeIdentifierGenerator(stringIdentifierGeneratorArray);
    }

    public CompositeIdentifierGenerator(StringIdentifierGenerator[] stringIdentifierGeneratorArray) {
        this.identifierGenerators = stringIdentifierGeneratorArray;
    }

    @Override
    public String nextStringIdentifier() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.identifierGenerators.length; ++i2) {
            stringBuffer.append(this.identifierGenerators[i2].nextStringIdentifier());
        }
        return stringBuffer.toString();
    }

    @Override
    public long maxLength() {
        long l = 0L;
        for (int i2 = 0; i2 < this.identifierGenerators.length; ++i2) {
            l += this.identifierGenerators[i2].maxLength();
        }
        return l;
    }

    @Override
    public long minLength() {
        long l = 0L;
        for (int i2 = 0; i2 < this.identifierGenerators.length; ++i2) {
            l += this.identifierGenerators[i2].minLength();
        }
        return l;
    }

    public StringIdentifierGenerator[] getIdentifierGenerators() {
        int n = this.identifierGenerators.length;
        StringIdentifierGenerator[] stringIdentifierGeneratorArray = new StringIdentifierGenerator[n];
        System.arraycopy((Object)this.identifierGenerators, 0, (Object)stringIdentifierGeneratorArray, 0, n);
        return stringIdentifierGeneratorArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.FeatureDataLocation;
import de.vw.mib.asl.internal.system.abtfeatures.IntegerValueParser;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetter;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.log4mib.Logger;

public class AbtFeatureParser {
    private static final String LOGGER_PREFIX;
    private final IntegerValueParser intParser = new IntegerValueParser();
    private final IntSet appliedFeatures = new IntOptHashSet();
    private final Logger logger;
    private final IntObjectMap valueSetterMappings;

    public AbtFeatureParser(ValueSetterFactory valueSetterFactory, Logger logger) {
        this.checkConstructorArguments(valueSetterFactory, logger);
        this.logger = logger;
        this.valueSetterMappings = valueSetterFactory.createValueSetterMappings();
    }

    public FeatureDataLocation parse(byte[] byArray) {
        if (this.checkIsDataValid(byArray)) {
            this.parseValidData(byArray);
            return this.parseAdditinalLocationData(byArray);
        }
        return FeatureDataLocation.createNoDataLocation();
    }

    boolean wasFeatureApplied(int n) {
        return this.appliedFeatures.contains(n);
    }

    private FeatureDataLocation parseAdditinalLocationData(byte[] byArray) {
        boolean bl;
        boolean bl2 = bl = byArray.length % 4 == 3;
        if (bl) {
            byte by = byArray[byArray.length - 2];
            byte by2 = byArray[byArray.length - 1];
            return FeatureDataLocation.createLocation(by, by2);
        }
        return FeatureDataLocation.createNoDataLocation();
    }

    private void parseValidData(byte[] byArray) {
        int n = this.calcFeatureCount(byArray);
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = i2 * 4 + 1;
            int n3 = this.intParser.parse(this.extractValueBytes(byArray, n2));
            byte[] byArray2 = this.extractValueBytes(byArray, n2 + 2);
            this.parseSingleFeature(n3, byArray2);
        }
    }

    private byte[] extractValueBytes(byte[] byArray, int n) {
        byte[] byArray2 = new byte[2];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, 2);
        return byArray2;
    }

    private int calcFeatureCount(byte[] byArray) {
        return byArray.length / 4;
    }

    private void parseSingleFeature(int n, byte[] byArray) {
        if (this.valueSetterMappings.containsKey(n)) {
            ValueSetter valueSetter = (ValueSetter)this.valueSetterMappings.get(n);
            this.applyFeatureValue(n, byArray, valueSetter);
        } else {
            this.logger.warn(2048, new StringBuffer().append("[AbtFeatureParser] Skipping feature ").append(n).append(" since it is unknown.").toString());
        }
    }

    private void applyFeatureValue(int n, byte[] byArray, ValueSetter valueSetter) {
        try {
            valueSetter.parse(byArray);
            this.appliedFeatures.add(n);
        }
        catch (Exception exception) {
            this.logger.error(2048, new StringBuffer().append("[AbtFeatureParser] Error while parsing feature ").append(n).append(": ").append(exception.getMessage()).toString(), exception);
        }
    }

    private boolean checkIsDataValid(byte[] byArray) {
        boolean bl;
        if (byArray == null) {
            this.logger.error(2048, "[AbtFeatureParser] Cannot parse data since it is null.");
            return false;
        }
        boolean bl2 = bl = byArray.length % 4 == 1 || byArray.length % 4 == 3;
        if (!bl) {
            this.logger.error(2048, "[AbtFeatureParser] Cannot parse data since it has the wrong length.");
            return false;
        }
        return true;
    }

    private void checkConstructorArguments(ValueSetterFactory valueSetterFactory, Logger logger) {
        if (valueSetterFactory == null) {
            throw new IllegalArgumentException("ValueSetterFactory must not be null.");
        }
        if (logger == null) {
            throw new IllegalArgumentException("Logger must not be null.");
        }
    }
}


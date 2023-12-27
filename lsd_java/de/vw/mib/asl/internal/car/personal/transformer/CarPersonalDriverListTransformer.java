/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal.transformer;

import de.vw.mib.asl.internal.car.personal.DriverListElement;
import generated.de.vw.mib.asl.internal.car.personal.transformer.AbstractCarPersonalDriverListTransformer;

public class CarPersonalDriverListTransformer
extends AbstractCarPersonalDriverListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                return ((DriverListElement)object).isActive;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((DriverListElement)object).userProfileName;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 3: {
                return ((DriverListElement)object).posValue;
            }
            case 2: {
                return ((DriverListElement)object).userType;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}


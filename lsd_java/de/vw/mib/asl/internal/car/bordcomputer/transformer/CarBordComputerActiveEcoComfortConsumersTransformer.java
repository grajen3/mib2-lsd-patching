/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarEcoConsumerIdCollector;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerActiveEcoComfortConsumersTransformer;

public class CarBordComputerActiveEcoComfortConsumersTransformer
extends AbstractCarBordComputerActiveEcoComfortConsumersTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return CarBordComputerActiveEcoComfortConsumersTransformer.checkingConsumerIds(((CarEcoConsumerIdCollector)object).consumerId);
            }
            case 1: {
                return ((CarEcoConsumerIdCollector)object).rangeValue;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }

    public static int checkingConsumerIds(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 12: {
                return 12;
            }
            case 13: {
                return 13;
            }
            case 14: {
                return 14;
            }
            case 15: {
                return 15;
            }
            case 16: {
                return 16;
            }
            case 17: {
                return 17;
            }
            case 18: {
                return 18;
            }
        }
        return 0;
    }
}


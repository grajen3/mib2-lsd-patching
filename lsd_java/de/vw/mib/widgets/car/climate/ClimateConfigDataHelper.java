/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.climate;

import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.internal.ServiceManager;

public final class ClimateConfigDataHelper {
    private static final int LOG_CLASSIFIER;
    private static final String LOG_PREFIX;
    private static final int INDEX_TYPE_BACKGROUND;
    private static final int INDEX_TYPE_BUTTON;
    private static final Logger LOGGER;

    public static int[] determineBackgroundIndicesByAspect(int n, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        return ClimateConfigDataHelper.determineIndicesByAspect(n, genericCarAdjusterConfigData, 0);
    }

    public static int[] determineButtonIndicesByAspect(int n, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        return ClimateConfigDataHelper.determineIndicesByAspect(n, genericCarAdjusterConfigData, 1);
    }

    private static int[] determineIndicesByAspect(int n, GenericCarAdjusterConfigData genericCarAdjusterConfigData, int n2) {
        IntIntOptHashMap intIntOptHashMap = new IntIntOptHashMap();
        switch (n) {
            case -1: 
            case 0: 
            case 1: {
                break;
            }
            default: {
                LOGGER.error(128).append("[ClimateConfigDataHelper]: ").append("Unknown aspect defined in widget [aspect=").append(n).append("].").log();
                return intIntOptHashMap.valuesToArray();
            }
        }
        if (genericCarAdjusterConfigData == null || !genericCarAdjusterConfigData.isDeserialized()) {
            return intIntOptHashMap.valuesToArray();
        }
        int n3 = -1;
        switch (n2) {
            case 0: {
                n3 = genericCarAdjusterConfigData.getBackgroundDefinitionCount() - 1;
                break;
            }
            case 1: {
                n3 = genericCarAdjusterConfigData.getButtonDefinitionCount() - 1;
                break;
            }
            default: {
                return intIntOptHashMap.valuesToArray();
            }
        }
        block17: while (n3 >= 0) {
            int n4 = -1;
            int n5 = -1;
            switch (n2) {
                case 0: {
                    n4 = genericCarAdjusterConfigData.getCorrespondingAspectIdForBackground(n3);
                    n5 = genericCarAdjusterConfigData.getBackgroundId(n3);
                    break;
                }
                case 1: {
                    n4 = genericCarAdjusterConfigData.getCorrespondingAspectIdForButton(n3);
                    n5 = genericCarAdjusterConfigData.getButtonId(n3);
                    break;
                }
                default: {
                    break block17;
                }
            }
            switch (n4) {
                case 1: {
                    if (n != 0) break;
                    intIntOptHashMap.put(n5, n3);
                    break;
                }
                case 2: {
                    if (n != -1) break;
                    intIntOptHashMap.put(n5, n3);
                    break;
                }
                case 3: {
                    if (n != 1) break;
                    intIntOptHashMap.put(n5, n3);
                    break;
                }
                case 0: {
                    intIntOptHashMap.put(n5, n3);
                    break;
                }
                default: {
                    LOGGER.error(128).append("[ClimateConfigDataHelper]: ").append("Unknown aspect defined in configuration file [aspect=").append(n4).append("].").log();
                }
            }
            --n3;
        }
        return intIntOptHashMap.valuesToArray();
    }

    private ClimateConfigDataHelper() {
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}


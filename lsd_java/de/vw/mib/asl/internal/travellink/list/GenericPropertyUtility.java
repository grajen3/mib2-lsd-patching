/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.list;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.list.DefaultValues;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.Constants;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;
import org.dsi.ifc.travellink.Values;

public final class GenericPropertyUtility {
    public static int getInt(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (n3 == -9999 && ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getInt : Searching key ").append(n).append(" is not available in key array ").log();
                }
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesInt && valuesArray[n3].valuesInt.length > n2) {
                    return valuesArray[n3].valuesInt[n2];
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getInt : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return DefaultValues.getDefaultIntValueIfRequired(n);
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getInt : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return DefaultValues.getDefaultIntValueIfRequired(n);
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getInt : GPContainer is null or key or valueIntPos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return DefaultValues.getDefaultIntValueIfRequired(n);
    }

    public static long getLong(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (n3 == -9999 && ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getLong : Searching key ").append(n).append(" is not available in key array ").log();
                }
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesLong && valuesArray[n3].valuesLong.length > n2) {
                    return valuesArray[n3].valuesLong[n2];
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getLong : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return DefaultValues.getDefaultLongValueIfRequired(n);
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getLong : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return DefaultValues.getDefaultLongValueIfRequired(n);
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getLong : GPContainer is null or key or valueIntPos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return DefaultValues.getDefaultLongValueIfRequired(n);
    }

    public static float getFloat(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesFloat && valuesArray[n3].valuesFloat.length > n2) {
                    return valuesArray[n3].valuesFloat[n2];
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getFloat : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return -163636026;
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getFloat : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return -163636026;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getFloat : GPContainer is null or key or valueFloatPos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return -163636026;
    }

    public static double getDouble(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesDouble && valuesArray[n3].valuesDouble.length > n2) {
                    return valuesArray[n3].valuesDouble[n2];
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDouble : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return DefaultValues.getDefaultDoubleValueIfRequired(n);
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDouble : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return DefaultValues.getDefaultDoubleValueIfRequired(n);
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDouble : GPContainer is null or key or valueDoublePos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return DefaultValues.getDefaultDoubleValueIfRequired(n);
    }

    public static boolean getBoolean(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesBoolean && valuesArray[n3].valuesBoolean.length > n2) {
                    return valuesArray[n3].valuesBoolean[n2];
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getBoolean : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return false;
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getBoolean : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return false;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getBoolean : GPContainer is null or key or valueBooleanPos is less than zero ").log();
        }
        return false;
    }

    public static String getString(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesString && valuesArray[n3].valuesString.length > n2) {
                    if (null != valuesArray[n3].valuesString[n2]) {
                        return valuesArray[n3].valuesString[n2];
                    }
                    return DefaultValues.getDefaultStringValueIfRequired(n);
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getString : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return DefaultValues.getDefaultStringValueIfRequired(n);
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getString : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return DefaultValues.getDefaultStringValueIfRequired(n);
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getString : GPContainer is null or key or valueIntPos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return DefaultValues.getDefaultStringValueIfRequired(n);
    }

    public static ResourceLocator getResourceLocator(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesResourceLocator && valuesArray[n3].valuesResourceLocator.length > n2) {
                    if (null != valuesArray[n3].valuesResourceLocator[n2]) {
                        return valuesArray[n3].valuesResourceLocator[n2];
                    }
                    return Constants.INVALID_RESOURCE_LOCATOR_VALUE;
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getResourceLocator : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return Constants.INVALID_RESOURCE_LOCATOR_VALUE;
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getResourceLocator : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return Constants.INVALID_RESOURCE_LOCATOR_VALUE;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getResourceLocator : GPContainer is null or key or valueIntPos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return Constants.INVALID_RESOURCE_LOCATOR_VALUE;
    }

    public static TravelLinkDate getDate(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0 && n2 >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n3 = GenericPropertyUtility.getIndex(n, nArray);
                if (GenericPropertyUtility.isValidValue(n3, n2, valuesArray) && null != valuesArray[n3].valuesDate && valuesArray[n3].valuesDate.length > n2) {
                    if (null != valuesArray[n3].valuesDate[n2]) {
                        return valuesArray[n3].valuesDate[n2];
                    }
                    return Constants.INVALID_DATE_VALUE;
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDate : Data not available. So, Invalid value is returned for the key ").append(n).log();
                }
                return Constants.INVALID_DATE_VALUE;
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDate : Either keys array or values array is null. So, Invalid value is returned for the key ").append(n).log();
            }
            return Constants.INVALID_DATE_VALUE;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDate : GPContainer is null or key or valueIntPos is less than zero. So, Invalid value is returned for the key ").append(n).log();
        }
        return Constants.INVALID_DATE_VALUE;
    }

    public static TravelLinkDate[] getDateArray(int n, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null && n >= 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            Values[] valuesArray = genericPropertyContainer.getValues();
            if (nArray != null && valuesArray != null) {
                int n2 = GenericPropertyUtility.getIndex(n, nArray);
                if (n2 > -1 && n2 < valuesArray.length && null != valuesArray[n2]) {
                    return valuesArray[n2].getValuesDate();
                }
                return null;
            }
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDateArray : Either keys array or values array is null. So, Null is returned for the key ").append(n).log();
            }
            return null;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getDateArray : GPContainer is null or key or valueIntPos is less than zero. So, Null is returned for the key ").append(n).log();
        }
        return null;
    }

    public static int getIndex(int n, int[] nArray) {
        if (nArray != null) {
            if (n >= 0) {
                for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                    if (nArray[i2] != n) continue;
                    return i2;
                }
            } else {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility : getIndex : ").append(" Key = ").append(n).append("- is less than zero ").log();
            }
        } else {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility : getIndex : ").append(" Key array is null ").append(n).log();
        }
        return -9999;
    }

    public static String getStringFromValues(int n, int n2, Values[] valuesArray) {
        if (GenericPropertyUtility.isValidValue(n, n2, valuesArray) && null != valuesArray[n].valuesString && valuesArray[n].valuesString.length > n2) {
            if (null != valuesArray[n].valuesString[n2]) {
                return valuesArray[n].valuesString[n2];
            }
            return "";
        }
        return null;
    }

    public static int getIntFromValues(int n, int n2, Values[] valuesArray) {
        if (GenericPropertyUtility.isValidValue(n, n2, valuesArray) && null != valuesArray[n].valuesInt && valuesArray[n].valuesInt.length > n2) {
            return valuesArray[n].valuesInt[n2];
        }
        return -9999;
    }

    public static ResourceLocator getResourceLocator(int n, int n2, Values[] valuesArray) {
        if (GenericPropertyUtility.isValidValue(n, n2, valuesArray) && null != valuesArray[n].valuesResourceLocator && valuesArray[n].valuesResourceLocator.length > n2) {
            return valuesArray[n].valuesResourceLocator[n2];
        }
        return null;
    }

    public static boolean isValidValue(int n, int n2, Values[] valuesArray) {
        return null != valuesArray && n >= 0 && valuesArray.length > n && null != valuesArray[n] && n2 >= 0;
    }

    public static GenericPropertyContainer getGPCForSpecificKeyValueInt(int n, int n2, GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && n >= 0 && n < 60 && n2 != -9999) {
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                if (genericPropertyContainerArray[i2] != null && genericPropertyContainerArray[i2].getValues() != null && genericPropertyContainerArray[i2].getValues()[n].valuesInt[0] != -9999) {
                    if (genericPropertyContainerArray[i2].getValues()[n].valuesInt[0] != n2) continue;
                    return genericPropertyContainerArray[i2];
                }
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility: getGenericPropertyContainerForSpecificKeyValueInt : NULL or invalid values inside Generic property container").log();
                }
                return null;
            }
        } else {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility: getGenericPropertyContainerForSpecificKeyValueInt : Generic property container array is null or Invalid keys or values in parameter").log();
            }
            return null;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility: getGenericPropertyContainerForSpecificKeyValueInt : returns null ").log();
        }
        return null;
    }

    public static int getKeyPositionInGPC(GenericPropertyContainer genericPropertyContainer, int n) {
        if (genericPropertyContainer != null && genericPropertyContainer.getKeys() != null && genericPropertyContainer.getKeys().length > 0) {
            int[] nArray = genericPropertyContainer.getKeys();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != n) continue;
                return i2;
            }
        } else {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility: getKeyPositionInGPC : Key Position not found and return 0 ").log();
            }
            return -9999;
        }
        return -9999;
    }

    public static boolean checkKeyHoldsSpecificValueInt(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        int n3 = -1;
        if (genericPropertyContainer != null && genericPropertyContainer.getValues() != null) {
            int[] nArray = null;
            int n4 = -1;
            nArray = genericPropertyContainer.getKeys();
            n4 = GenericPropertyUtility.getIndex(n, nArray);
            if (genericPropertyContainer.getValues()[n4].valuesInt != null && (n3 = genericPropertyContainer.getValues()[n4].valuesInt[0]) == n2) {
                return true;
            }
        }
        return false;
    }

    public static GenericPropertyContainer[] getCopy(GenericPropertyContainer[] genericPropertyContainerArray) {
        GenericPropertyContainer[] genericPropertyContainerArray2 = null;
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length >= 0) {
            genericPropertyContainerArray2 = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                genericPropertyContainerArray2[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("GenericPropertyUtility: copy : Either source Generic property container is null or SourceContainers length is equals or less than zero").log();
        }
        return genericPropertyContainerArray2;
    }

    public static GenericPropertyContainer getCopy(GenericPropertyContainer genericPropertyContainer) {
        int n;
        Object[] objectArray;
        GenericPropertyContainer genericPropertyContainer2 = new GenericPropertyContainer();
        if (genericPropertyContainer.keys != null && genericPropertyContainer.keys.length >= 0) {
            objectArray = new int[genericPropertyContainer.keys.length];
            for (n = 0; n < genericPropertyContainer.keys.length; ++n) {
                objectArray[n] = genericPropertyContainer.keys[n];
            }
            genericPropertyContainer2.keys = objectArray;
        }
        if (genericPropertyContainer.values != null && genericPropertyContainer.values.length >= 0) {
            objectArray = new Values[genericPropertyContainer.values.length];
            for (n = 0; n < genericPropertyContainer.values.length; ++n) {
                int n2;
                if (genericPropertyContainer.values[n] == null) continue;
                objectArray[n] = (int)new Values();
                if (genericPropertyContainer.values[n].valuesInt != null && genericPropertyContainer.values[n].valuesInt.length >= 0) {
                    objectArray[n].valuesInt = new int[genericPropertyContainer.values[n].valuesInt.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesInt.length; ++n2) {
                        objectArray[n].valuesInt[n2] = genericPropertyContainer.values[n].valuesInt[n2];
                    }
                }
                if (genericPropertyContainer.values[n].valuesLong != null && genericPropertyContainer.values[n].valuesLong.length >= 0) {
                    objectArray[n].valuesLong = new long[genericPropertyContainer.values[n].valuesLong.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesLong.length; ++n2) {
                        objectArray[n].valuesLong[n2] = genericPropertyContainer.values[n].valuesLong[n2];
                    }
                }
                if (genericPropertyContainer.values[n].valuesString != null && genericPropertyContainer.values[n].valuesString.length >= 0) {
                    objectArray[n].valuesString = new String[genericPropertyContainer.values[n].valuesString.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesString.length; ++n2) {
                        if (null == genericPropertyContainer.values[n].valuesString[n2]) continue;
                        objectArray[n].valuesString[n2] = new String(genericPropertyContainer.values[n].valuesString[n2]);
                    }
                }
                if (genericPropertyContainer.values[n].valuesFloat != null && genericPropertyContainer.values[n].valuesFloat.length >= 0) {
                    objectArray[n].valuesFloat = new float[genericPropertyContainer.values[n].valuesFloat.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesFloat.length; ++n2) {
                        objectArray[n].valuesFloat[n2] = genericPropertyContainer.values[n].valuesFloat[n2];
                    }
                }
                if (genericPropertyContainer.values[n].valuesDouble != null && genericPropertyContainer.values[n].valuesDouble.length >= 0) {
                    objectArray[n].valuesDouble = new double[genericPropertyContainer.values[n].valuesDouble.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesDouble.length; ++n2) {
                        objectArray[n].valuesDouble[n2] = genericPropertyContainer.values[n].valuesDouble[n2];
                    }
                }
                if (genericPropertyContainer.values[n].valuesBoolean != null && genericPropertyContainer.values[n].valuesBoolean.length >= 0) {
                    objectArray[n].valuesBoolean = new boolean[genericPropertyContainer.values[n].valuesBoolean.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesBoolean.length; ++n2) {
                        objectArray[n].valuesBoolean[n2] = genericPropertyContainer.values[n].valuesBoolean[n2];
                    }
                }
                if (genericPropertyContainer.values[n].valuesResourceLocator != null && genericPropertyContainer.values[n].valuesResourceLocator.length >= 0) {
                    objectArray[n].valuesResourceLocator = new ResourceLocator[genericPropertyContainer.values[n].valuesResourceLocator.length];
                    for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesResourceLocator.length; ++n2) {
                        if (null == genericPropertyContainer.values[n].valuesResourceLocator[n2]) continue;
                        objectArray[n].valuesResourceLocator[n2] = new ResourceLocator();
                        objectArray[n].valuesResourceLocator[n2].id = genericPropertyContainer.values[n].valuesResourceLocator[n2].id;
                        objectArray[n].valuesResourceLocator[n2].url = genericPropertyContainer.values[n].valuesResourceLocator[n2].url;
                    }
                }
                if (genericPropertyContainer.values[n].valuesDate == null || genericPropertyContainer.values[n].valuesDate.length < 0) continue;
                objectArray[n].valuesDate = new TravelLinkDate[genericPropertyContainer.values[n].valuesDate.length];
                for (n2 = 0; n2 < genericPropertyContainer.values[n].valuesDate.length; ++n2) {
                    if (null == genericPropertyContainer.values[n].valuesDate[n2]) continue;
                    objectArray[n].valuesDate[n2] = new TravelLinkDate();
                    objectArray[n].valuesDate[n2].day = genericPropertyContainer.values[n].valuesDate[n2].day;
                    objectArray[n].valuesDate[n2].hour = genericPropertyContainer.values[n].valuesDate[n2].hour;
                    objectArray[n].valuesDate[n2].minute = genericPropertyContainer.values[n].valuesDate[n2].minute;
                    objectArray[n].valuesDate[n2].month = genericPropertyContainer.values[n].valuesDate[n2].month;
                    objectArray[n].valuesDate[n2].second = genericPropertyContainer.values[n].valuesDate[n2].second;
                    objectArray[n].valuesDate[n2].year = genericPropertyContainer.values[n].valuesDate[n2].year;
                }
            }
            genericPropertyContainer2.values = (Values[])objectArray;
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility: getcopy() : Either source Generic property container is null or SourceContainers length is equals or less than zero").log();
        }
        return genericPropertyContainer2;
    }

    public static GenericPropertyContainer getFlatCopy(GenericPropertyContainer genericPropertyContainer, int n) {
        int n2;
        Object[] objectArray;
        GenericPropertyContainer genericPropertyContainer2 = new GenericPropertyContainer();
        if (genericPropertyContainer.keys != null && genericPropertyContainer.keys.length >= 0) {
            objectArray = new int[genericPropertyContainer.keys.length];
            for (n2 = 0; n2 < genericPropertyContainer.keys.length; ++n2) {
                objectArray[n2] = genericPropertyContainer.keys[n2];
            }
            genericPropertyContainer2.keys = objectArray;
        }
        if (genericPropertyContainer.values != null && genericPropertyContainer.values.length >= 0) {
            objectArray = new Values[genericPropertyContainer.values.length];
            for (n2 = 0; n2 < genericPropertyContainer.values.length; ++n2) {
                if (genericPropertyContainer.values[n2] == null) continue;
                objectArray[n2] = (int)new Values();
                if (genericPropertyContainer.values[n2].valuesInt != null && genericPropertyContainer.values[n2].valuesInt.length > n) {
                    objectArray[n2].valuesInt = new int[1];
                    objectArray[n2].valuesInt[0] = genericPropertyContainer.values[n2].valuesInt[n];
                }
                if (genericPropertyContainer.values[n2].valuesLong != null && genericPropertyContainer.values[n2].valuesLong.length > n) {
                    objectArray[n2].valuesLong = new long[1];
                    objectArray[n2].valuesLong[0] = genericPropertyContainer.values[n2].valuesLong[n];
                }
                if (genericPropertyContainer.values[n2].valuesString != null && genericPropertyContainer.values[n2].valuesString.length > n && null != genericPropertyContainer.values[n2].valuesString[n]) {
                    objectArray[n2].valuesString = new String[1];
                    objectArray[n2].valuesString[0] = new String(genericPropertyContainer.values[n2].valuesString[n]);
                }
                if (genericPropertyContainer.values[n2].valuesFloat != null && genericPropertyContainer.values[n2].valuesFloat.length > n) {
                    objectArray[n2].valuesFloat = new float[1];
                    objectArray[n2].valuesFloat[0] = genericPropertyContainer.values[n2].valuesFloat[n];
                }
                if (genericPropertyContainer.values[n2].valuesDouble != null && genericPropertyContainer.values[n2].valuesDouble.length > n) {
                    objectArray[n2].valuesDouble = new double[1];
                    objectArray[n2].valuesDouble[0] = genericPropertyContainer.values[n2].valuesDouble[n];
                }
                if (genericPropertyContainer.values[n2].valuesBoolean != null && genericPropertyContainer.values[n2].valuesBoolean.length > n) {
                    objectArray[n2].valuesBoolean = new boolean[1];
                    objectArray[n2].valuesBoolean[0] = genericPropertyContainer.values[n2].valuesBoolean[n];
                }
                if (genericPropertyContainer.values[n2].valuesResourceLocator != null && genericPropertyContainer.values[n2].valuesResourceLocator.length > n && null != genericPropertyContainer.values[n2].valuesResourceLocator[n]) {
                    objectArray[n2].valuesResourceLocator = new ResourceLocator[1];
                    objectArray[n2].valuesResourceLocator[0] = new ResourceLocator();
                    objectArray[n2].valuesResourceLocator[0].id = genericPropertyContainer.values[n2].valuesResourceLocator[n].id;
                    objectArray[n2].valuesResourceLocator[0].url = genericPropertyContainer.values[n2].valuesResourceLocator[n].url;
                }
                if (genericPropertyContainer.values[n2].valuesDate == null || genericPropertyContainer.values[n2].valuesDate.length <= n || null == genericPropertyContainer.values[n2].valuesDate[n]) continue;
                objectArray[n2].valuesDate = new TravelLinkDate[1];
                objectArray[n2].valuesDate[0] = new TravelLinkDate();
                objectArray[n2].valuesDate[0].day = genericPropertyContainer.values[n2].valuesDate[n].day;
                objectArray[n2].valuesDate[0].hour = genericPropertyContainer.values[n2].valuesDate[n].hour;
                objectArray[n2].valuesDate[0].minute = genericPropertyContainer.values[n2].valuesDate[n].minute;
                objectArray[n2].valuesDate[0].month = genericPropertyContainer.values[n2].valuesDate[n].month;
                objectArray[n2].valuesDate[0].second = genericPropertyContainer.values[n2].valuesDate[n].second;
                objectArray[n2].valuesDate[0].year = genericPropertyContainer.values[n2].valuesDate[n].year;
            }
            genericPropertyContainer2.values = (Values[])objectArray;
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility: getFlatCopy() : Either source Generic property container is null or SourceContainers length is equals or less than zero").log();
        }
        return genericPropertyContainer2;
    }

    public static GenericPropertyContainer[] checkAndCreateGPC(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        int n2 = GenericPropertyUtility.getSizeOfGenericPropertyContainerArray(n, genericPropertyContainerArray);
        if (genericPropertyContainerArray == null) {
            genericPropertyContainerArray = new GenericPropertyContainer[n2];
        }
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            if (genericPropertyContainerArray[i2] != null) continue;
            genericPropertyContainerArray[i2] = new GenericPropertyContainer();
            if (!ServiceManager.logger2.isTraceEnabled(2)) continue;
            ServiceManager.logger2.error(2).append("GenericPropertyUtility: checkAndCreateGPC() : Element in the position --> ").append(i2).append(" in Generic property container array is null for the requestType --> ").append(n).log();
        }
        return genericPropertyContainerArray;
    }

    public static void updateGPCWithValue(int n, int n2, GenericPropertyContainer genericPropertyContainer) {
        if (genericPropertyContainer != null) {
            int n3 = GenericPropertyUtility.getKeyPositionInGPC(genericPropertyContainer, n);
            if (n3 != -9999) {
                if (genericPropertyContainer.values != null && genericPropertyContainer.values.length > n3) {
                    genericPropertyContainer.values[n3] = new Values();
                    genericPropertyContainer.values[n3].valuesInt = new int[]{n2};
                } else if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.error(2).append("GenericPropertyUtility: updateGPCWithValue :  Values inside container is null or valueInt is null").log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility: updateGPCWithValue : Position of the key is invalid ").log();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GenericPropertyUtility: updateGPCWithValue : Generic property container array is null ").log();
        }
    }

    public static void addListIndex(GenericPropertyContainer genericPropertyContainer, int n) {
        int n2 = 1;
        int n3 = genericPropertyContainer.keys.length + n2;
        int[] nArray = new int[n3];
        nArray[n3 - 1] = -2087282688;
        Values[] valuesArray = new Values[n3];
        valuesArray[n3 - 1] = new Values();
        valuesArray[n3 - 1].valuesInt = new int[]{n};
        for (int i2 = 0; i2 < genericPropertyContainer.keys.length; ++i2) {
            nArray[i2] = genericPropertyContainer.keys[i2];
            valuesArray[i2] = new Values();
            if (genericPropertyContainer.values[i2].valuesInt != null) {
                valuesArray[i2].valuesInt = new int[]{genericPropertyContainer.values[i2].valuesInt[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesString != null) {
                valuesArray[i2].valuesString = new String[]{genericPropertyContainer.values[i2].valuesString[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesBoolean != null) {
                valuesArray[i2].valuesBoolean = new boolean[]{genericPropertyContainer.values[i2].valuesBoolean[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesDate != null) {
                valuesArray[i2].valuesDate = new TravelLinkDate[]{genericPropertyContainer.values[i2].valuesDate[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesDouble != null) {
                valuesArray[i2].valuesDouble = new double[]{genericPropertyContainer.values[i2].valuesDouble[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesFloat != null) {
                valuesArray[i2].valuesFloat = new float[]{genericPropertyContainer.values[i2].valuesFloat[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesLong != null) {
                valuesArray[i2].valuesLong = new long[]{genericPropertyContainer.values[i2].valuesLong[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2].valuesResourceLocator == null) continue;
            valuesArray[i2].valuesResourceLocator = new ResourceLocator[]{genericPropertyContainer.values[i2].valuesResourceLocator[0]};
        }
        genericPropertyContainer.keys = nArray;
        genericPropertyContainer.values = valuesArray;
    }

    public static int getSizeOfGenericPropertyContainerArray(int n, GenericPropertyContainer[] genericPropertyContainerArray) {
        int n2 = 0;
        if (n == 43 || n == 44) {
            n2 = 10;
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length != n2 && ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("GenericPropertyUtility: getSizeOfGenericPropertyContainerArray() :  Expected array length -- ").append(n2).append("  Received array length -- ").append(genericPropertyContainerArray.length).append("  for the request type -- ").append(n).log();
            }
            return n2;
        }
        return n2;
    }
}


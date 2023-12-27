/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.dsi;

import org.dsi.ifc.travellink.GenericProperty;

public final class RequestToAppParameter {
    public int requestType;
    public int functionId;
    public GenericProperty[] functionParams;
    public int maxItemCount;
    public int updateFrequency;
    public int updateCount;
    public int sessionId;

    public RequestToAppParameter(int n, int n2, GenericProperty[] genericPropertyArray, int n3, int n4, int n5, int n6) {
        this.requestType = n;
        this.functionId = n2;
        this.functionParams = genericPropertyArray;
        this.maxItemCount = n3;
        this.updateFrequency = n4;
        this.updateCount = n5;
        this.sessionId = n6;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        RequestToAppParameter requestToAppParameter = (RequestToAppParameter)object;
        if (!this.genericPropertyArrayEquals(requestToAppParameter.functionParams)) {
            return false;
        }
        if (this.maxItemCount != requestToAppParameter.maxItemCount) {
            return false;
        }
        if (this.requestType != requestToAppParameter.requestType) {
            return false;
        }
        if (this.updateCount != requestToAppParameter.updateCount) {
            return false;
        }
        return this.updateFrequency == requestToAppParameter.updateFrequency;
    }

    private boolean genericPropertyArrayEquals(GenericProperty[] genericPropertyArray) {
        if (null == this.functionParams ^ null == genericPropertyArray) {
            return false;
        }
        if (null != this.functionParams && null != genericPropertyArray) {
            if (this.functionParams == genericPropertyArray) {
                return true;
            }
            if (super.getClass() != super.getClass()) {
                return false;
            }
            if (genericPropertyArray.length != this.functionParams.length) {
                return false;
            }
            for (int i2 = 0; i2 < this.functionParams.length; ++i2) {
                int n;
                if (null == this.functionParams[i2] ^ null == genericPropertyArray[i2]) {
                    return false;
                }
                if (null == this.functionParams[i2] || null == genericPropertyArray[i2]) continue;
                if (this.functionParams[i2].key != genericPropertyArray[i2].key) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesString ^ null == genericPropertyArray[i2].valuesString) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesInt ^ null == genericPropertyArray[i2].valuesInt) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesLong ^ null == genericPropertyArray[i2].valuesLong) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesFloat ^ null == genericPropertyArray[i2].valuesFloat) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesBoolean ^ null == genericPropertyArray[i2].valuesBoolean) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesResourceLocator ^ null == genericPropertyArray[i2].valuesResourceLocator) {
                    return false;
                }
                if (null == this.functionParams[i2].valuesDate ^ null == genericPropertyArray[i2].valuesDate) {
                    return false;
                }
                if (null != this.functionParams[i2].valuesString && null != genericPropertyArray[i2].valuesString) {
                    if (this.functionParams[i2].valuesString.length != genericPropertyArray[i2].valuesString.length) {
                        return false;
                    }
                    for (n = 0; n < this.functionParams[i2].valuesString.length; ++n) {
                        if (null == this.functionParams[i2].valuesString[n] ^ null == genericPropertyArray[i2].valuesString[n]) {
                            return false;
                        }
                        if (null == this.functionParams[i2].valuesString[n] || null == genericPropertyArray[i2].valuesString[n] || this.functionParams[i2].valuesString[n].equals(genericPropertyArray[i2].valuesString[n])) continue;
                        return false;
                    }
                }
                if (null != this.functionParams[i2].valuesDate && null != genericPropertyArray[i2].valuesDate) {
                    if (this.functionParams[i2].valuesDate.length != genericPropertyArray[i2].valuesDate.length) {
                        return false;
                    }
                    for (n = 0; n < this.functionParams[i2].valuesDate.length; ++n) {
                        if (null == this.functionParams[i2].valuesDate[n] ^ null == genericPropertyArray[i2].valuesDate[n]) {
                            return false;
                        }
                        if (null == this.functionParams[i2].valuesDate[n] || null == genericPropertyArray[i2].valuesDate[n] || this.functionParams[i2].valuesDate[n].year == genericPropertyArray[i2].valuesDate[n].year && this.functionParams[i2].valuesDate[n].day == genericPropertyArray[i2].valuesDate[n].day && this.functionParams[i2].valuesDate[n].month == genericPropertyArray[i2].valuesDate[n].month && this.functionParams[i2].valuesDate[n].hour == genericPropertyArray[i2].valuesDate[n].hour && this.functionParams[i2].valuesDate[n].minute == genericPropertyArray[i2].valuesDate[n].minute && this.functionParams[i2].valuesDate[n].second == genericPropertyArray[i2].valuesDate[n].second) continue;
                        return false;
                    }
                }
                if (null != this.functionParams[i2].valuesResourceLocator && null != genericPropertyArray[i2].valuesResourceLocator) {
                    if (this.functionParams[i2].valuesResourceLocator.length != genericPropertyArray[i2].valuesResourceLocator.length) {
                        return false;
                    }
                    for (n = 0; n < this.functionParams[i2].valuesResourceLocator.length; ++n) {
                        if (null == this.functionParams[i2].valuesResourceLocator[n] ^ null == genericPropertyArray[i2].valuesResourceLocator[n]) {
                            return false;
                        }
                        if (null == this.functionParams[i2].valuesResourceLocator[n] || null == genericPropertyArray[i2].valuesResourceLocator[n] || this.functionParams[i2].valuesResourceLocator[n].id == genericPropertyArray[i2].valuesResourceLocator[n].id && this.functionParams[i2].valuesResourceLocator[n].url.equals(genericPropertyArray[i2].valuesResourceLocator[n].url)) continue;
                        return false;
                    }
                }
                if (null != this.functionParams[i2].valuesInt && null != genericPropertyArray[i2].valuesInt) {
                    if (this.functionParams[i2].valuesInt.length != genericPropertyArray[i2].valuesInt.length) {
                        return false;
                    }
                    for (n = 0; n < this.functionParams[i2].valuesInt.length; ++n) {
                        if (this.functionParams[i2].valuesInt[n] == genericPropertyArray[i2].valuesInt[n]) continue;
                        return false;
                    }
                }
                if (null != this.functionParams[i2].valuesLong && null != genericPropertyArray[i2].valuesLong) {
                    if (this.functionParams[i2].valuesLong.length != genericPropertyArray[i2].valuesLong.length) {
                        return false;
                    }
                    for (n = 0; n < this.functionParams[i2].valuesLong.length; ++n) {
                        if (this.functionParams[i2].valuesLong[n] == genericPropertyArray[i2].valuesLong[n]) continue;
                        return false;
                    }
                }
                if (null != this.functionParams[i2].valuesFloat && null != genericPropertyArray[i2].valuesFloat) {
                    if (this.functionParams[i2].valuesFloat.length != genericPropertyArray[i2].valuesFloat.length) {
                        return false;
                    }
                    for (n = 0; n < this.functionParams[i2].valuesFloat.length; ++n) {
                        if (this.functionParams[i2].valuesFloat[n] == genericPropertyArray[i2].valuesFloat[n]) continue;
                        return false;
                    }
                }
                if (null == this.functionParams[i2].valuesBoolean || null == genericPropertyArray[i2].valuesBoolean) continue;
                if (this.functionParams[i2].valuesBoolean.length != genericPropertyArray[i2].valuesBoolean.length) {
                    return false;
                }
                for (n = 0; n < this.functionParams[i2].valuesBoolean.length; ++n) {
                    if (this.functionParams[i2].valuesBoolean[n] == genericPropertyArray[i2].valuesBoolean[n]) continue;
                    return false;
                }
            }
        }
        return true;
    }
}


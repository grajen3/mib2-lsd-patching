/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioStationInfoContainerImpl
extends AbstractContainer
implements RadioStationInfoContainer {
    private static final byte ELEMENT_NAME;
    private static final byte ELEMENT_FREQUENCY;
    private static final byte ELEMENT_BAND;
    private static final byte ELEMENT_PI_CODE;
    private static final byte ELEMENT_SHORT_NAME;
    private static final byte ELEMENT_RDS;
    private static final byte ELEMENT_TP;
    private static final byte ELEMENT_FREQUENCY_LABEL;
    private static final byte ELEMENT_SERVICE_ID;
    private static final byte ELEMENT_ENSEMBLE_ID;
    private static final byte ELEMENT_EXTENDED_COUNTRY_CODE;
    private static final byte ELEMENT_SERVICE_COMPONENT_ID;
    private static final byte ELEMENT_STATION_LOGO;
    private static final byte ELEMENT_FM_LINKING_ACTIVE;
    private String attrName;
    private long attrFrequency;
    private int attrBand;
    private int attrPICode;
    private String attrShortName;
    private boolean attrRDS;
    private boolean attrTP;
    private String attrFrequencyLabel;
    private long attrServiceId;
    private int attrEnsembleId;
    private int attrExtendedCountryCode;
    private int attrServiceComponentId;
    private ResourceLocator attrStationLogo;
    private boolean attrFMLinkingActive;

    @Override
    public int getContainerId() {
        return 26;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getName() {
        return this.attrName;
    }

    @Override
    public long getFrequency() {
        return this.attrFrequency;
    }

    @Override
    public int getBand() {
        return this.attrBand;
    }

    @Override
    public int getPICode() {
        return this.attrPICode;
    }

    @Override
    public String getShortName() {
        return this.attrShortName;
    }

    @Override
    public boolean getRDS() {
        return this.attrRDS;
    }

    @Override
    public boolean getTP() {
        return this.attrTP;
    }

    @Override
    public String getFrequencyLabel() {
        return this.attrFrequencyLabel;
    }

    @Override
    public long getServiceId() {
        return this.attrServiceId;
    }

    @Override
    public int getEnsembleId() {
        return this.attrEnsembleId;
    }

    @Override
    public int getExtendedCountryCode() {
        return this.attrExtendedCountryCode;
    }

    @Override
    public int getServiceComponentId() {
        return this.attrServiceComponentId;
    }

    @Override
    public ResourceLocator getStationLogo() {
        return this.attrStationLogo;
    }

    @Override
    public boolean getFMLinkingActive() {
        return this.attrFMLinkingActive;
    }

    @Override
    public boolean isNameSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isFrequencySet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isBandSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isPICodeSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isShortNameSet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public boolean isRDSSet() {
        return this._isElementSet((byte)5);
    }

    @Override
    public boolean isTPSet() {
        return this._isElementSet((byte)6);
    }

    @Override
    public boolean isFrequencyLabelSet() {
        return this._isElementSet((byte)7);
    }

    @Override
    public boolean isServiceIdSet() {
        return this._isElementSet((byte)8);
    }

    @Override
    public boolean isEnsembleIdSet() {
        return this._isElementSet((byte)9);
    }

    @Override
    public boolean isExtendedCountryCodeSet() {
        return this._isElementSet((byte)10);
    }

    @Override
    public boolean isServiceComponentIdSet() {
        return this._isElementSet((byte)11);
    }

    @Override
    public boolean isStationLogoSet() {
        return this._isElementSet((byte)12);
    }

    @Override
    public boolean isFMLinkingActiveSet() {
        return this._isElementSet((byte)13);
    }

    @Override
    public void setName(String string) {
        this.attrName = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setFrequency(long l) {
        this.attrFrequency = l;
        this._setElement((byte)1, true);
    }

    @Override
    public void setBand(int n) {
        this.attrBand = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void setPICode(int n) {
        this.attrPICode = n;
        this._setElement((byte)3, true);
    }

    @Override
    public void setShortName(String string) {
        this.attrShortName = string;
        this._setElement((byte)4, null != string);
    }

    @Override
    public void setRDS(boolean bl) {
        this.attrRDS = bl;
        this._setElement((byte)5, true);
    }

    @Override
    public void setTP(boolean bl) {
        this.attrTP = bl;
        this._setElement((byte)6, true);
    }

    @Override
    public void setFrequencyLabel(String string) {
        this.attrFrequencyLabel = string;
        this._setElement((byte)7, null != string);
    }

    @Override
    public void setServiceId(long l) {
        this.attrServiceId = l;
        this._setElement((byte)8, true);
    }

    @Override
    public void setEnsembleId(int n) {
        this.attrEnsembleId = n;
        this._setElement((byte)9, true);
    }

    @Override
    public void setExtendedCountryCode(int n) {
        this.attrExtendedCountryCode = n;
        this._setElement((byte)10, true);
    }

    @Override
    public void setServiceComponentId(int n) {
        this.attrServiceComponentId = n;
        this._setElement((byte)11, true);
    }

    @Override
    public void setStationLogo(ResourceLocator resourceLocator) {
        this.attrStationLogo = resourceLocator;
        this._setElement((byte)12, null != resourceLocator);
    }

    @Override
    public void setFMLinkingActive(boolean bl) {
        this.attrFMLinkingActive = bl;
        this._setElement((byte)13, true);
    }

    @Override
    public void unsetName() {
        this.attrName = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetFrequency() {
        this.attrFrequency = 0L;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetBand() {
        this.attrBand = 0;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetPICode() {
        this.attrPICode = 0;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetShortName() {
        this.attrShortName = null;
        this._setElement((byte)4, false);
    }

    @Override
    public void unsetRDS() {
        this.attrRDS = false;
        this._setElement((byte)5, false);
    }

    @Override
    public void unsetTP() {
        this.attrTP = false;
        this._setElement((byte)6, false);
    }

    @Override
    public void unsetFrequencyLabel() {
        this.attrFrequencyLabel = null;
        this._setElement((byte)7, false);
    }

    @Override
    public void unsetServiceId() {
        this.attrServiceId = 0L;
        this._setElement((byte)8, false);
    }

    @Override
    public void unsetEnsembleId() {
        this.attrEnsembleId = 0;
        this._setElement((byte)9, false);
    }

    @Override
    public void unsetExtendedCountryCode() {
        this.attrExtendedCountryCode = 0;
        this._setElement((byte)10, false);
    }

    @Override
    public void unsetServiceComponentId() {
        this.attrServiceComponentId = 0;
        this._setElement((byte)11, false);
    }

    @Override
    public void unsetStationLogo() {
        this.attrStationLogo = null;
        this._setElement((byte)12, false);
    }

    @Override
    public void unsetFMLinkingActive() {
        this.attrFMLinkingActive = false;
        this._setElement((byte)13, false);
    }
}


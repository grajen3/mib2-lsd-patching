/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioStationInfoContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioStationInfoContainerMarshaller() {
        super(26);
    }

    @Override
    public HASDataContainer marshal(HASContainer hASContainer) {
        HASDataContainer hASDataContainer;
        int n = this.getMarshallerContainerId();
        if (null == hASContainer) {
            hASDataContainer = null;
        } else {
            if (n != hASContainer.getContainerId()) {
                throw HASException.wrongContainerId(n, hASContainer.getContainerId());
            }
            hASDataContainer = new HASDataContainer();
            hASDataContainer.containerId = n;
            hASDataContainer.elementId = hASContainer.getElementId();
            RadioStationInfoContainer radioStationInfoContainer = (RadioStationInfoContainer)hASContainer;
            ArrayList arrayList = RadioStationInfoContainerMarshaller.borrowArrayList();
            if (radioStationInfoContainer.isNameSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createStringElement(51, radioStationInfoContainer.getName()));
            }
            if (radioStationInfoContainer.isFrequencySet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createLongElement(52, radioStationInfoContainer.getFrequency()));
            }
            if (radioStationInfoContainer.isBandSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createIntElement(53, radioStationInfoContainer.getBand()));
            }
            if (radioStationInfoContainer.isPICodeSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createIntElement(54, radioStationInfoContainer.getPICode()));
            }
            if (radioStationInfoContainer.isShortNameSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createStringElement(79, radioStationInfoContainer.getShortName()));
            }
            if (radioStationInfoContainer.isRDSSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createBooleanElement(80, radioStationInfoContainer.getRDS()));
            }
            if (radioStationInfoContainer.isTPSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createBooleanElement(81, radioStationInfoContainer.getTP()));
            }
            if (radioStationInfoContainer.isFrequencyLabelSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createStringElement(82, radioStationInfoContainer.getFrequencyLabel()));
            }
            if (radioStationInfoContainer.isServiceIdSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createLongElement(83, radioStationInfoContainer.getServiceId()));
            }
            if (radioStationInfoContainer.isEnsembleIdSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createIntElement(84, radioStationInfoContainer.getEnsembleId()));
            }
            if (radioStationInfoContainer.isExtendedCountryCodeSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createIntElement(85, radioStationInfoContainer.getExtendedCountryCode()));
            }
            if (radioStationInfoContainer.isServiceComponentIdSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createIntElement(86, radioStationInfoContainer.getServiceComponentId()));
            }
            if (radioStationInfoContainer.isStationLogoSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createResourceLocatorElement(87, radioStationInfoContainer.getStationLogo()));
            }
            if (radioStationInfoContainer.isFMLinkingActiveSet()) {
                RadioStationInfoContainerMarshaller.add((List)arrayList, RadioStationInfoContainerMarshaller.createBooleanElement(120, radioStationInfoContainer.getFMLinkingActive()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            RadioStationInfoContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 51: {
                ((RadioStationInfoContainer)hASContainer).setName(string);
                break;
            }
            case 79: {
                ((RadioStationInfoContainer)hASContainer).setShortName(string);
                break;
            }
            case 82: {
                ((RadioStationInfoContainer)hASContainer).setFrequencyLabel(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setLongElement(HASContainer hASContainer, int n, long l) {
        switch (n) {
            case 52: {
                ((RadioStationInfoContainer)hASContainer).setFrequency(l);
                break;
            }
            case 83: {
                ((RadioStationInfoContainer)hASContainer).setServiceId(l);
                break;
            }
            default: {
                super.setLongElement(hASContainer, n, l);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 53: {
                ((RadioStationInfoContainer)hASContainer).setBand(n2);
                break;
            }
            case 54: {
                ((RadioStationInfoContainer)hASContainer).setPICode(n2);
                break;
            }
            case 84: {
                ((RadioStationInfoContainer)hASContainer).setEnsembleId(n2);
                break;
            }
            case 85: {
                ((RadioStationInfoContainer)hASContainer).setExtendedCountryCode(n2);
                break;
            }
            case 86: {
                ((RadioStationInfoContainer)hASContainer).setServiceComponentId(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 80: {
                ((RadioStationInfoContainer)hASContainer).setRDS(bl);
                break;
            }
            case 81: {
                ((RadioStationInfoContainer)hASContainer).setTP(bl);
                break;
            }
            case 120: {
                ((RadioStationInfoContainer)hASContainer).setFMLinkingActive(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }

    @Override
    protected void setResourceLocatorElement(HASContainer hASContainer, int n, ResourceLocator resourceLocator) {
        switch (n) {
            case 87: {
                ((RadioStationInfoContainer)hASContainer).setStationLogo(resourceLocator);
                break;
            }
            default: {
                super.setResourceLocatorElement(hASContainer, n, resourceLocator);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioTextContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioTextContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioTextContainerMarshaller() {
        super(52);
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
            RadioTextContainer radioTextContainer = (RadioTextContainer)hASContainer;
            ArrayList arrayList = RadioTextContainerMarshaller.borrowArrayList();
            if (radioTextContainer.isRadioTextSet()) {
                RadioTextContainerMarshaller.add((List)arrayList, RadioTextContainerMarshaller.createStringElement(114, radioTextContainer.getRadioText()));
            }
            if (radioTextContainer.isArtistSet()) {
                RadioTextContainerMarshaller.add((List)arrayList, RadioTextContainerMarshaller.createStringElement(115, radioTextContainer.getArtist()));
            }
            if (radioTextContainer.isAlbumSet()) {
                RadioTextContainerMarshaller.add((List)arrayList, RadioTextContainerMarshaller.createStringElement(116, radioTextContainer.getAlbum()));
            }
            if (radioTextContainer.isTitleSet()) {
                RadioTextContainerMarshaller.add((List)arrayList, RadioTextContainerMarshaller.createStringElement(117, radioTextContainer.getTitle()));
            }
            if (radioTextContainer.isRadioImageSet()) {
                RadioTextContainerMarshaller.add((List)arrayList, RadioTextContainerMarshaller.createResourceLocatorElement(118, radioTextContainer.getRadioImage()));
            }
            if (radioTextContainer.isRadioImageAvailableSet()) {
                RadioTextContainerMarshaller.add((List)arrayList, RadioTextContainerMarshaller.createBooleanElement(119, radioTextContainer.getRadioImageAvailable()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            RadioTextContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 114: {
                ((RadioTextContainer)hASContainer).setRadioText(string);
                break;
            }
            case 115: {
                ((RadioTextContainer)hASContainer).setArtist(string);
                break;
            }
            case 116: {
                ((RadioTextContainer)hASContainer).setAlbum(string);
                break;
            }
            case 117: {
                ((RadioTextContainer)hASContainer).setTitle(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setResourceLocatorElement(HASContainer hASContainer, int n, ResourceLocator resourceLocator) {
        switch (n) {
            case 118: {
                ((RadioTextContainer)hASContainer).setRadioImage(resourceLocator);
                break;
            }
            default: {
                super.setResourceLocatorElement(hASContainer, n, resourceLocator);
            }
        }
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 119: {
                ((RadioTextContainer)hASContainer).setRadioImageAvailable(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }
}


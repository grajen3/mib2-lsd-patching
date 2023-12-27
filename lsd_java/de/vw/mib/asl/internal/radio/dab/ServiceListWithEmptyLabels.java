/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.ServiceInfo;

class ServiceListWithEmptyLabels {
    private int mEntryServiceCounter = 1;
    private int mEntryComponentCounter = 1;
    private final IntObjectMap mMapEnsembleService = new IntObjectOptHashMap();
    private final LongObjectMap mMapServiceComponent = new LongObjectOptHashMap();

    ServiceListWithEmptyLabels() {
    }

    public void labelService(ServiceInfo serviceInfo) {
        LongObjectOptHashMap longObjectOptHashMap = (LongObjectOptHashMap)this.mMapEnsembleService.get(serviceInfo.ensID);
        if (longObjectOptHashMap == null) {
            longObjectOptHashMap = new LongObjectOptHashMap();
            this.mMapEnsembleService.put(serviceInfo.ensID, longObjectOptHashMap);
        }
        if (longObjectOptHashMap.containsKey(serviceInfo.sID)) {
            ServiceInfo serviceInfo2 = (ServiceInfo)longObjectOptHashMap.get(serviceInfo.sID);
            if (serviceInfo.fullName.length() == 0) {
                serviceInfo.fullName = serviceInfo2.fullName;
            }
            if (serviceInfo.shortName.length() == 0) {
                serviceInfo.shortName = serviceInfo2.shortName;
            }
        } else {
            String string = RadioConstants.DAB_DUMMY_NO_FORMATTER.format(this.mEntryServiceCounter);
            if (serviceInfo.fullName.length() == 0) {
                serviceInfo.fullName = new StringBuffer().append("Service ").append(string).toString();
            }
            if (serviceInfo.shortName.length() == 0) {
                serviceInfo.shortName = new StringBuffer().append("Serv. ").append(string).toString();
            }
            longObjectOptHashMap.put(serviceInfo.sID, serviceInfo);
            ++this.mEntryServiceCounter;
        }
    }

    public void labelComponent(ComponentInfo componentInfo) {
        long l = DabTunerState.calcServiceId(componentInfo.ensID, componentInfo.ensECC, componentInfo.sID);
        IntObjectOptHashMap intObjectOptHashMap = (IntObjectOptHashMap)this.mMapServiceComponent.get(l);
        if (intObjectOptHashMap == null) {
            intObjectOptHashMap = new IntObjectOptHashMap();
            this.mMapServiceComponent.put(l, intObjectOptHashMap);
        }
        if (intObjectOptHashMap.containsKey(componentInfo.sCIDI)) {
            ComponentInfo componentInfo2 = (ComponentInfo)intObjectOptHashMap.get(componentInfo.sCIDI);
            componentInfo.fullName = componentInfo2.fullName;
            componentInfo.shortName = componentInfo2.shortName;
        } else {
            componentInfo.fullName = new StringBuffer().append("Service Component ").append(this.mEntryComponentCounter).toString();
            componentInfo.shortName = new StringBuffer().append("Comp. ").append(this.mEntryComponentCounter).toString();
            intObjectOptHashMap.put(componentInfo.sCIDI, componentInfo);
            ++this.mEntryComponentCounter;
        }
    }
}


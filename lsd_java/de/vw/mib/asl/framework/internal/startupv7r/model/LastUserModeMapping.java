/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.log4mib.Logger;

public class LastUserModeMapping {
    private final AbstractWorkUnit[] workUnits;
    private final int[] lumMappings;
    private final Logger logger;

    public LastUserModeMapping(ConfigurationManager configurationManager, Logger logger, AbstractWorkUnit[] abstractWorkUnitArray) {
        this.logger = logger;
        this.workUnits = abstractWorkUnitArray;
        this.lumMappings = configurationManager.getLumMappings();
    }

    public AbstractWorkUnit retrieveWorkUnit(String string) {
        int n = this.retrieveLastContextId(string);
        for (int i2 = 0; i2 < this.lumMappings.length; i2 += 2) {
            int n2 = this.lumMappings[i2 + 0];
            int n3 = this.lumMappings[i2 + 1] - 1;
            if (n3 >= this.workUnits.length) {
                this.logger.error(1, new StringBuffer().append("Last User Mode work unit is out of range ( ").append(n3).append(" )").toString());
                continue;
            }
            if (n2 != n || n3 < 0) continue;
            return this.workUnits[n3];
        }
        return null;
    }

    private int retrieveLastContextId(String string) {
        int n = this.createContentIdToContextEnumerationMapping().get(string);
        return n;
    }

    private ObjectIntMap createContentIdToContextEnumerationMapping() {
        ObjectIntOptHashMap objectIntOptHashMap = new ObjectIntOptHashMap();
        objectIntOptHashMap.put("HMI_NAVI", 1);
        objectIntOptHashMap.put("HMI_TRAFFIC", 3);
        objectIntOptHashMap.put("HMI_MEDIA", 4);
        objectIntOptHashMap.put("HMI_PHONE", 5);
        objectIntOptHashMap.put("HMI_RADIO", 6);
        objectIntOptHashMap.put("HMI_CAR", 9);
        objectIntOptHashMap.put("HMI_PICTUREVIEWER", 11);
        objectIntOptHashMap.put("HMI_INTERNETBROWSER", 15);
        objectIntOptHashMap.put("HMI_MESSAGE", 16);
        objectIntOptHashMap.put("HMI_TVTUNER", 21);
        objectIntOptHashMap.put("HMI_TRAVELLINK", 22);
        objectIntOptHashMap.put("HMI_SMARTPHONEINTEGRATION", 25);
        objectIntOptHashMap.put("HMI_HOMESCREEN", 26);
        return objectIntOptHashMap;
    }
}


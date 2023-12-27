/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import generated.de.vw.mib.asl.internal.ListManager;

public class SpecialMethodLumReady
extends AbstractStartupTask {
    private final StartupServices startupServices;
    private final ConfigurationManagerDiag configurationManager;
    private final ASLPropertyManager propertyManager;
    private final StartupStateServiceImpl startupStateService;

    public SpecialMethodLumReady(StartupServices startupServices) {
        super(startupServices.getLogger());
        this.startupServices = startupServices;
        this.configurationManager = startupServices.getConfigurationManagerDiag();
        this.propertyManager = startupServices.getAslPropertyManager();
        this.startupStateService = startupServices.getStartupStateService();
    }

    @Override
    public void runTask() {
        if (!StartupServiceManager.swdlPowerstateDetected) {
            int n = this.retrieveLastContextId();
            this.propertyManager.valueChangedInteger(1612, n);
            int[] nArray = this.configurationManager.getAvailableSkins4CurrentGuiLanguage();
            Object[] objectArray = new String[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                objectArray[i2] = this.configurationManager.getSkinName(nArray[i2]);
            }
            ListManager.getGenericASLList(1622).updateList(objectArray);
            this.info(new StringBuffer().append("[ASLStartup v8]lastUserMode is:").append(this.resolveLumName(n)).toString());
            this.startupStateService.notifyLastUserModeAvailable();
        }
        this.finish();
    }

    private int retrieveLastContextId() {
        String string;
        ObjectIntMap objectIntMap = this.createContentIdToContextEnumerationMapping();
        if (objectIntMap.containsKey(string = this.startupServices.getSystemStateService().getLastContentId())) {
            return objectIntMap.get(string);
        }
        return 6;
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
        objectIntOptHashMap.put("HMI_VIDEO", 13);
        objectIntOptHashMap.put("HMI_INTERNETBROWSER", 15);
        objectIntOptHashMap.put("HMI_MESSAGE", 16);
        objectIntOptHashMap.put("HMI_TVTUNER", 21);
        objectIntOptHashMap.put("HMI_TRAVELLINK", 22);
        objectIntOptHashMap.put("HMI_SMARTPHONEINTEGRATION", 25);
        objectIntOptHashMap.put("HMI_HOMESCREEN", 26);
        return objectIntOptHashMap;
    }

    private String resolveLumName(int n) {
        String string = "UNKNOWN / ";
        switch (n) {
            case 1: {
                string = "NAVIGATION / ";
                break;
            }
            case 2: {
                string = "MAPDEPRECATED / ";
                break;
            }
            case 3: {
                string = "TRAFFIC / ";
                break;
            }
            case 4: {
                string = "MEDIA / ";
                break;
            }
            case 5: {
                string = "PHONE / ";
                break;
            }
            case 6: {
                string = "TUNER / ";
                break;
            }
            case 7: {
                string = "ADRESSBOOK / ";
                break;
            }
            case 8: {
                string = "SYSTEMSETUP / ";
                break;
            }
            case 9: {
                string = "CAR / ";
                break;
            }
            case 10: {
                string = "TP_MEMO / ";
                break;
            }
            case 11: {
                string = "PICTURE_VIEWER / ";
                break;
            }
            case 12: {
                string = "CLIMATE / ";
                break;
            }
            case 13: {
                string = "VIDEO / ";
                break;
            }
            case 14: {
                string = "FILEBROWSER / ";
                break;
            }
            case 15: {
                string = "INTERNETBROWSER / ";
                break;
            }
            case 16: {
                string = "MESSAGE / ";
                break;
            }
            case 17: {
                string = "HANDBOOK / ";
                break;
            }
            case 18: {
                string = "DMB / ";
                break;
            }
            case 19: {
                string = "TPEG / ";
                break;
            }
            case 20: {
                string = "BT_AUDIO / ";
                break;
            }
            case 21: {
                string = "TV_TUNER / ";
                break;
            }
            case 22: {
                string = "TRAVELLINK / ";
                break;
            }
            case 23: {
                string = "MIRRORLINK / ";
                break;
            }
            case 24: {
                string = "UDGO / ";
                break;
            }
            case 25: {
                string = "SMARTPHONEINTEGRATION / ";
                break;
            }
            case 26: {
                string = "HOME SCREEN / ";
                break;
            }
        }
        return new StringBuffer().append(string).append(n).toString();
    }
}


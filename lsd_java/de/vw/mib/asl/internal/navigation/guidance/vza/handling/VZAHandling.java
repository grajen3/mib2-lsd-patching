/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling;

import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.transformer.VZAIconsCollector;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.VZAHandlingJPN;
import de.vw.mib.dynamicresourcedata.DynamicResourceData;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.trafficregulation.SpeedLimitInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class VZAHandling {
    protected HsmTargetVZA target;
    protected VZAIconsCollector[] signs = new VZAIconsCollector[3];
    private DynamicResourceDataDescription desc = null;
    private DynamicResourceData map = null;
    private DynamicResourceDataDescription descrVZA = null;
    private DynamicResourceData mapVZA = null;
    private VZAHandlingJPN vzaHandlingJPN = null;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA;

    public VZAHandling(HsmTargetVZA hsmTargetVZA) {
        this.target = hsmTargetVZA;
        for (int i2 = 0; i2 < this.signs.length; ++i2) {
            this.signs[i2] = new VZAIconsCollector();
        }
        this.initDynamicResources01();
        this.initDynamicResources02();
        if (this.isSpeedCameraWarningViaVZA()) {
            this.vzaHandlingJPN = new VZAHandlingJPN(hsmTargetVZA);
        }
    }

    private void initDynamicResources01() {
        this.target.traceState("VZAHandling.initDynamicResources01(): STARTING...");
        this.desc = ServiceManager.configManagerDiag.getCountryCodeMappingDescription();
        if (this.desc != null) {
            this.desc.input("Value");
            this.desc.output("DefaultMapping", 0);
            this.map = this.desc.create();
            this.target.traceState("VZAHandling.initDynamicResources01(): SUCCESS...");
        }
        this.target.traceState("VZAHandling.initDynamicResources01(): END.");
    }

    private void initDynamicResources02() {
        this.target.traceState("VZAHandling.initDynamicResources02(): STARTING...");
        this.descrVZA = ServiceManager.configManagerDiag.getVzaMappingDescription();
        if (this.descrVZA != null) {
            this.descrVZA.input("TrafficSignID_AddSign").input("TrafficSignID_MainSign").input("CountryCode");
            this.descrVZA.output("MainSign", -1).output("MainSign_StackBG_DisplayMode", -1).output("MainSign_StackBG_InteractiveMode", -1).output("MainSign_Dynamic", -1).output("AddSign", -1);
            this.mapVZA = this.descrVZA.create();
            this.target.traceState("VZAHandling.initDynamicResources02(): SUCCESS...");
        }
        this.target.traceState("VZAHandling.initDynamicResources02(): END.");
    }

    public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation) {
        this.target.traceState("VZAHandling.updateCurrentTrafficSign() -- Country Dependent VZEVZA");
        int[][] nArray = this.getSortedSigns(trafficSignInformation);
        int[] nArray2 = this.vzaHandlingJPN == null ? this.getWarningSigns(trafficSignInformation) : this.vzaHandlingJPN.getWarningSigns(trafficSignInformation);
        int[][] nArray3 = this.getSortedMergedSigns(nArray, nArray2);
        if (this.desc != null) {
            int[] nArray4 = this.map.map(new int[]{trafficSignInformation.getVariant()});
            this.target.traceState(new StringBuffer("Variants (length): ").append(nArray4.length).toString());
            this.target.traceState("Variants (content): ");
            for (int i2 = 0; i2 < nArray4.length; ++i2) {
                this.target.traceState(new StringBuffer("Index: ").append(i2).append(": ").append(nArray4[i2]).toString());
            }
            if (this.mapVZA != null) {
                String[][] stringArray = this.getAllImagePaths(nArray3, nArray4[0], this.mapVZA);
                VZAIconsCollector vZAIconsCollector = new VZAIconsCollector();
                this.target.traceState("Adding sign one!");
                int n = 0;
                n = this.findPathIndex(n, stringArray);
                this.target.traceState(new StringBuffer().append("currentPathIndex: ").append(n).toString());
                if (n < stringArray.length) {
                    String[] stringArray2 = stringArray[n];
                    vZAIconsCollector = this.createVZAIconsCollector(stringArray2, 0, trafficSignInformation.highestPrioritySpeedLimit);
                }
                VZAIconsCollector vZAIconsCollector2 = new VZAIconsCollector();
                this.target.traceState("Adding sign two!");
                n = this.findPathIndex(n + 1, stringArray);
                this.target.traceState(new StringBuffer().append("currentPathIndex: ").append(n).toString());
                if (n < stringArray.length) {
                    String[] stringArray3 = stringArray[n];
                    vZAIconsCollector2 = this.createVZAIconsCollector(stringArray3, 1, trafficSignInformation.highestPrioritySpeedLimit);
                }
                VZAIconsCollector vZAIconsCollector3 = new VZAIconsCollector();
                this.target.traceState("Adding sign three!");
                n = this.findPathIndex(n + 1, stringArray);
                this.target.traceState(new StringBuffer().append("currentPathIndex: ").append(n).toString());
                if (n < stringArray.length) {
                    String[] stringArray4 = stringArray[n];
                    vZAIconsCollector3 = this.createVZAIconsCollector(stringArray4, 2, trafficSignInformation.highestPrioritySpeedLimit);
                }
                this.signs = new VZAIconsCollector[]{vZAIconsCollector, vZAIconsCollector2, vZAIconsCollector3};
                ListManager.getGenericASLList(-2131750912).updateList(this.signs);
                this.updateInternalAPI();
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append((class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA == null ? (class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA = VZAHandling.class$("de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA")) : class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA).getName());
                    logMessage.append(".dsiTrafficRegulationUpdateCurrentTrafficSign -> Model update ");
                    for (int i3 = 0; i3 < this.signs.length; ++i3) {
                        logMessage.append(this.signs[i3].toString());
                    }
                    logMessage.log();
                }
            } else {
                this.target.traceState("Attempting to fetch resources again...");
                this.initDynamicResources02();
            }
        } else {
            this.target.traceState("ServiceManager.configManagerDiag.getCountryCodeMappingDescription() has returned NULL");
            this.target.traceState("Attempting to fetch resources again...");
            this.initDynamicResources01();
        }
    }

    private void updateInternalAPI() {
        ASLGuidanceVZAVZEIcons[] aSLGuidanceVZAVZEIconsArray = new ASLGuidanceVZAVZEIcons[]{new ASLGuidanceVZAVZEIcons(), new ASLGuidanceVZAVZEIcons(), new ASLGuidanceVZAVZEIcons()};
        for (int i2 = 0; i2 < 3; ++i2) {
            aSLGuidanceVZAVZEIconsArray[i2].setAdditionalIcon(this.signs[i2].additionalIcons);
            aSLGuidanceVZAVZEIconsArray[i2].setAdditionalIconActive(this.signs[i2].isAdditionalIconActive);
            aSLGuidanceVZAVZEIconsArray[i2].setMainIcon(this.signs[i2].mainIcons);
            aSLGuidanceVZAVZEIconsArray[i2].setMainIconActive(this.signs[i2].isMainIconActive);
            aSLGuidanceVZAVZEIconsArray[i2].setSpeedIcon(this.signs[i2].speedIcons);
            aSLGuidanceVZAVZEIconsArray[i2].setSpeedIconActive(this.signs[i2].isSpeedIconActive);
        }
        this.target.getGuidanceAPINotifier().sendEvVZAVZEUpdate(aSLGuidanceVZAVZEIconsArray);
    }

    private int findPathIndex(int n, String[][] stringArray) {
        while (n < stringArray.length && stringArray[n][0].equals("")) {
            ++n;
        }
        return n;
    }

    private String[][] getAllImagePaths(int[][] nArray, int n, DynamicResourceData dynamicResourceData) {
        String[][] stringArray = new String[6][];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringArray[i2] = this.getImagePaths(nArray[i2][1], nArray[i2][0], n, dynamicResourceData);
        }
        return stringArray;
    }

    private int[][] getSortedMergedSigns(int[][] nArray, int[] nArray2) {
        int n;
        int n2 = 6;
        int n3 = 2;
        int[][] nArray3 = new int[n2][n3];
        nArray3[0][0] = nArray2[0];
        nArray3[0][1] = 257;
        nArray3[1][0] = nArray2[1];
        nArray3[1][1] = 257;
        nArray3[2][0] = nArray[0][0];
        nArray3[2][1] = nArray[0][1];
        nArray3[3][0] = nArray[1][0];
        nArray3[3][1] = nArray[1][1];
        nArray3[4][0] = nArray[2][0];
        nArray3[4][1] = nArray[2][1];
        nArray3[5][0] = nArray2[2];
        nArray3[5][1] = 257;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append("[").append(nArray3[i2][0]).append(", ").append(nArray3[i2][1]).append("]").append("  ");
        }
        this.target.traceState(new StringBuffer("mergedSignsFull: ").append(stringBuffer.toString()).toString());
        int[][] nArray4 = new int[n2][n3];
        for (n = 0; n < n2; ++n) {
            nArray4[n][0] = 0;
            nArray4[n][1] = 257;
        }
        n = 0;
        for (int i3 = 0; i3 < n2; ++i3) {
            if (nArray3[i3][0] == 0 || n >= n2) continue;
            nArray4[n][0] = nArray3[i3][0];
            nArray4[n][1] = nArray3[i3][1];
            ++n;
        }
        return nArray4;
    }

    private int[] getWarningSigns(TrafficSignInformation trafficSignInformation) {
        int[] nArray = new int[]{trafficSignInformation.warningSignOne, trafficSignInformation.warningSignTwo, trafficSignInformation.warningSignThree};
        return nArray;
    }

    private String[] getImagePaths(int n, int n2, int n3, DynamicResourceData dynamicResourceData) {
        this.target.traceState(new StringBuffer("getImagePaths( ").append(n).append(", ").append(n2).append(", ").append(n3).append(" )").toString());
        int[] nArray = dynamicResourceData.map(new int[]{n, n2, n3});
        String[] stringArray = new String[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringArray[i2] = dynamicResourceData.mapImagePath(nArray[i2]);
        }
        this.traceImagePaths(stringArray);
        return stringArray;
    }

    private void traceImagePaths(String[] stringArray) {
        this.target.traceState("traceImagePaths");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.target.traceState(new StringBuffer("Index: ").append(i2).append(" ").append(stringArray[i2]).toString());
        }
    }

    private VZAIconsCollector createVZAIconsCollector(String[] stringArray, int n, SpeedLimitInfo speedLimitInfo) {
        VZAIconsCollector vZAIconsCollector;
        this.target.traceState("createVZAIconsCollector()");
        if (n < this.signs.length) {
            this.target.traceState("Old sign exists -> use it for update");
            vZAIconsCollector = this.signs[n];
        } else {
            this.target.traceState("No old sign available -> create new one");
            vZAIconsCollector = new VZAIconsCollector();
        }
        vZAIconsCollector.mainIcons = stringArray[0];
        vZAIconsCollector.bgDisplayMode = stringArray[1];
        vZAIconsCollector.bgInteractiveMode = stringArray[2];
        vZAIconsCollector.speedIcons = stringArray[3];
        vZAIconsCollector.additionalIcons = stringArray[4];
        vZAIconsCollector.isMainIconActive = !vZAIconsCollector.mainIcons.equals("");
        vZAIconsCollector.isAdditionalIconActive = !vZAIconsCollector.additionalIcons.equals("");
        vZAIconsCollector.isSpeedIconActive = !vZAIconsCollector.speedIcons.equals("");
        vZAIconsCollector.speedLimitKmh = this.getSpeedInKmh(speedLimitInfo);
        return vZAIconsCollector;
    }

    protected int[][] getSortedSigns(TrafficSignInformation trafficSignInformation) {
        int[][] nArray = new int[3][2];
        nArray[0][0] = trafficSignInformation.trafficSignOne;
        nArray[0][1] = this.handleAdditionalSignID(trafficSignInformation.additionalSignOne);
        nArray[1][0] = trafficSignInformation.trafficSignTwo;
        nArray[1][1] = this.handleAdditionalSignID(trafficSignInformation.additionalSignTwo);
        nArray[2][0] = trafficSignInformation.trafficSignThree;
        nArray[2][1] = this.handleAdditionalSignID(trafficSignInformation.additionalSignThree);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append((class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA == null ? (class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA = VZAHandling.class$("de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA")) : class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA).getName());
            logMessage.append(".getSortedSigns priority: ");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                logMessage.append("[");
                for (int i3 = 0; i3 < nArray[i2].length; ++i3) {
                    logMessage.append(nArray[i2][i3]);
                    logMessage.append(", ");
                }
                logMessage.append("]");
            }
            logMessage.log();
        }
        return nArray;
    }

    private int getSpeedInKmh(SpeedLimitInfo speedLimitInfo) {
        this.target.traceState("getSpeedInKmh()");
        int n = 1000;
        if (speedLimitInfo != null) {
            n = speedLimitInfo.speedLimit;
            if (speedLimitInfo.speedUnit == 1) {
                this.target.traceState("convert speed from imperial to metric system");
                n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().milesToKm(n);
            }
        } else {
            this.target.traceState("SpeedLimitInfo is null");
        }
        return n;
    }

    private int handleAdditionalSignID(int n) {
        return n == 0 ? 257 : n;
    }

    private boolean isSpeedCameraWarningViaVZA() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(159);
    }

    public void stopDisplayWarningIcon() {
        if (this.vzaHandlingJPN != null) {
            this.vzaHandlingJPN.stopDisplayWarningIcon();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


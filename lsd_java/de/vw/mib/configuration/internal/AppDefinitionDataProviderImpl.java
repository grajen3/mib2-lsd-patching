/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.AppDefinitionData;
import de.vw.mib.app.framework.assembly.AppDefinitionDataProvider;
import de.vw.mib.app.framework.assembly.CioFilterData;
import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.app.framework.assembly.CioIntentData;
import de.vw.mib.app.framework.assembly.CioVisualizationData;
import de.vw.mib.app.framework.assembly.ScreenAreaData;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.configuration.internal.AppDefinitionDataImpl;
import de.vw.mib.configuration.internal.CioFilterDataImpl;
import de.vw.mib.configuration.internal.CioFilterDataImpl$CioFilterEntryImpl;
import de.vw.mib.configuration.internal.CioIntentClassDataImpl;
import de.vw.mib.configuration.internal.CioIntentDataImpl;
import de.vw.mib.configuration.internal.CioVisualizationDataImpl;
import de.vw.mib.configuration.internal.ConfigurationManagerImpl;
import de.vw.mib.configuration.internal.ScreenAreaDataImpl;
import java.util.HashMap;

public class AppDefinitionDataProviderImpl
implements AppDefinitionDataProvider {
    private ConfigurationManagerImpl configurationManager;
    private AppDefinitionData desktopAppDefinitionData = null;
    private CioIntentClassData[] cioIntentClassData = new CioIntentClassData[0];
    private ScreenAreaData[] screenAreaDatas = new ScreenAreaData[0];
    private CioVisualizationDataImpl[] cioVisualisationData;
    private CioIntentDataImpl[] cioIntentDatas;
    private HashMap appName2AppDefinitionDataImpl;
    private CioFilterData[] cioFilterDatas;

    public AppDefinitionDataProviderImpl(ConfigurationManagerImpl configurationManagerImpl) {
        this.configurationManager = configurationManagerImpl;
    }

    private int readCioVisualizationData(String[] stringArray, int[] nArray, int n) {
        int n2 = nArray[n++];
        this.cioVisualisationData = new CioVisualizationDataImpl[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            CioVisualizationDataImpl cioVisualizationDataImpl;
            String string = this.getString(stringArray, nArray[n++]);
            String string2 = this.getString(stringArray, nArray[n++]);
            String string3 = this.getString(stringArray, nArray[n++]);
            String string4 = this.getString(stringArray, nArray[n++]);
            String string5 = this.getString(stringArray, nArray[n++]);
            String string6 = this.getString(stringArray, nArray[n++]);
            String string7 = this.getString(stringArray, nArray[n++]);
            String string8 = this.getString(stringArray, nArray[n++]);
            this.cioVisualisationData[i2] = cioVisualizationDataImpl = new CioVisualizationDataImpl(string, string2, string3, string4, string5, string6, string7, string8);
        }
        return n;
    }

    private int readCioIntentClassData(String[] stringArray, int[] nArray, int n) {
        int n2 = nArray[n++];
        this.cioIntentClassData = new CioIntentClassDataImpl[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            int n4;
            int n5;
            String string = this.getString(stringArray, nArray[n++]);
            boolean bl = nArray[n++] != 0;
            String string2 = this.getString(stringArray, nArray[n++]);
            int n6 = nArray[n++];
            String[] stringArray2 = new String[n6];
            for (n5 = 0; n5 < n6; ++n5) {
                stringArray2[n5] = this.getString(stringArray, nArray[n++]);
            }
            n5 = nArray[n++];
            ObjectIntOptHashMap objectIntOptHashMap = new ObjectIntOptHashMap(n5);
            for (n4 = 0; n4 < n5; ++n4) {
                objectIntOptHashMap.put(this.getString(stringArray, nArray[n++]), nArray[n++]);
            }
            n4 = nArray[n++];
            ObjectIntOptHashMap objectIntOptHashMap2 = new ObjectIntOptHashMap(n4);
            for (n3 = 0; n3 < n4; ++n3) {
                objectIntOptHashMap2.put(this.getString(stringArray, nArray[n++]), nArray[n++]);
            }
            n3 = nArray[n++];
            HashMap hashMap = new HashMap(n3);
            for (int i3 = 0; i3 < n3; ++i3) {
                hashMap.put(this.getString(stringArray, nArray[n++]), this.getString(stringArray, nArray[n++]));
            }
            CioIntentClassDataImpl cioIntentClassDataImpl = new CioIntentClassDataImpl(string, bl, string2, stringArray2, objectIntOptHashMap, objectIntOptHashMap2, hashMap);
            this.cioIntentClassData[i2] = cioIntentClassDataImpl;
        }
        return n;
    }

    private int readScreenAreaData(String[] stringArray, int[] nArray, int n, int n2) {
        ScreenAreaDataImpl screenAreaDataImpl;
        int n3;
        String string;
        int n4;
        int n5 = nArray[n++];
        int n6 = nArray[n++];
        this.screenAreaDatas = new ScreenAreaData[n5 + n6];
        HashMap hashMap = new HashMap();
        for (n4 = 0; n4 < n5; ++n4) {
            string = this.getString(stringArray, nArray[n++]);
            n3 = nArray[n++];
            boolean bl = nArray[n++] != 0;
            screenAreaDataImpl = new ScreenAreaDataImpl(string, "Main", n3, null, bl);
            this.screenAreaDatas[n4] = screenAreaDataImpl;
            hashMap.put(string, screenAreaDataImpl);
        }
        for (n4 = 0; n4 < n6; ++n4) {
            string = this.getString(stringArray, nArray[n++]);
            n3 = nArray[n++];
            String[] stringArray2 = null;
            if (n2 < -4) {
                stringArray2 = new String[nArray[n++]];
                for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                    stringArray2[i2] = this.getString(stringArray, nArray[n++]);
                }
            } else {
                ++n;
            }
            screenAreaDataImpl = new ScreenAreaDataImpl(string, "Popup", n3, stringArray2, false);
            this.screenAreaDatas[n4 + n5] = screenAreaDataImpl;
            hashMap.put(string, screenAreaDataImpl);
        }
        n4 = nArray[n++];
        for (int i3 = 0; i3 < n4; ++i3) {
            String string2 = this.getString(stringArray, nArray[n++]);
            String string3 = this.getString(stringArray, nArray[n++]);
            screenAreaDataImpl = (ScreenAreaDataImpl)hashMap.get(string2);
            ScreenAreaDataImpl screenAreaDataImpl2 = (ScreenAreaDataImpl)hashMap.get(string3);
            if (screenAreaDataImpl == null) continue;
            screenAreaDataImpl.setCoveredScreenArea(screenAreaDataImpl2);
        }
        return n;
    }

    private int readCioIntentData_OlderThanVersion3(String[] stringArray, int[] nArray, int n) {
        int n2 = nArray[n++];
        this.cioIntentDatas = new CioIntentDataImpl[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            CioIntentDataImpl cioIntentDataImpl;
            int n3;
            String string = this.getString(stringArray, nArray[n++]);
            String string2 = this.getString(stringArray, nArray[n++]);
            AppDefinitionData appDefinitionData = (AppDefinitionData)this.appName2AppDefinitionDataImpl.get(stringArray[nArray[n++]]);
            int n4 = nArray[n++];
            CioIntentClassData cioIntentClassData = (n3 = nArray[n++]) < 0 ? null : this.cioIntentClassData[n3];
            int n5 = nArray[n++];
            CioVisualizationDataImpl cioVisualizationDataImpl = n5 < 0 ? null : this.cioVisualisationData[n5];
            int n6 = nArray[n++];
            int n7 = nArray[n++];
            String string3 = this.getString(stringArray, nArray[n++]);
            this.cioIntentDatas[i2] = cioIntentDataImpl = new CioIntentDataImpl(appDefinitionData, n4, string, cioIntentClassData, cioVisualizationDataImpl, string2, n6, n7, string3);
        }
        return n;
    }

    private int readCioIntentData(String[] stringArray, int[] nArray, int n) {
        int n2 = nArray[n++];
        this.cioIntentDatas = new CioIntentDataImpl[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            int n4;
            int n5;
            String string = this.getString(stringArray, nArray[n++]);
            String string2 = this.getString(stringArray, nArray[n++]);
            AppDefinitionData appDefinitionData = (AppDefinitionData)this.appName2AppDefinitionDataImpl.get(stringArray[nArray[n++]]);
            int n6 = nArray[n++];
            CioIntentClassData cioIntentClassData = (n5 = nArray[n++]) < 0 ? null : this.cioIntentClassData[n5];
            int n7 = nArray[n++];
            CioVisualizationData[] cioVisualizationDataArray = new CioVisualizationData[n7 > 0 ? n7 : 0];
            for (n4 = 0; n4 < cioVisualizationDataArray.length; ++n4) {
                cioVisualizationDataArray[n4] = (n3 = nArray[n++]) < 0 ? null : this.cioVisualisationData[n3];
            }
            n4 = nArray[n++];
            n3 = nArray[n++];
            String string3 = this.getString(stringArray, nArray[n++]);
            CioIntentDataImpl cioIntentDataImpl = null;
            if (nArray[n++] > 0) {
                String string4 = this.getString(stringArray, nArray[n++]);
                String string5 = this.getString(stringArray, nArray[n++]);
                cioIntentDataImpl = new CioIntentDataImpl(appDefinitionData, n6, string, cioIntentClassData, cioVisualizationDataArray, string2, n4, n3, string3, string4, string5);
            } else {
                cioIntentDataImpl = new CioIntentDataImpl(appDefinitionData, n6, string, cioIntentClassData, cioVisualizationDataArray, string2, n4, n3, string3);
            }
            this.cioIntentDatas[i2] = cioIntentDataImpl;
        }
        return n;
    }

    private String getString(String[] stringArray, int n) {
        if (n < 0) {
            return null;
        }
        return stringArray[n];
    }

    @Override
    public AppDefinitionData getDesktopAppDefinitionData() {
        if (this.desktopAppDefinitionData == null) {
            AppDefinitionData[] appDefinitionDataArray;
            AppDefinitionData[] appDefinitionDataArray2;
            String string;
            int n;
            int n2;
            String[] stringArray = this.configurationManager.getAppAssemblyStringData();
            int[] nArray = this.configurationManager.getAppAssemblyIntData();
            this.appName2AppDefinitionDataImpl = new HashMap();
            if (stringArray == null || nArray == null) {
                return null;
            }
            int n3 = 0;
            int n4 = (n2 = nArray[n3++]) < 0 ? nArray[n3++] : n2;
            for (n = 0; n < n4; ++n) {
                String string2;
                String string3 = stringArray[nArray[n3++]];
                int n5 = 0;
                int n6 = -1;
                if (n2 < -3) {
                    string2 = stringArray[nArray[n3++]];
                    n5 = nArray[n3++];
                    string = stringArray[nArray[n3++]];
                    n6 = nArray[n3++];
                } else if (n2 < -1) {
                    string2 = stringArray[nArray[n3++]];
                    string = stringArray[nArray[n3++]];
                } else {
                    string2 = string3;
                    string = string3;
                }
                String string4 = stringArray[nArray[n3++]];
                AppDefinitionDataImpl appDefinitionDataImpl = new AppDefinitionDataImpl(string3, string2, n5, n6, string4);
                if (string4.equals("DesktopApp")) {
                    this.desktopAppDefinitionData = appDefinitionDataImpl;
                }
                this.appName2AppDefinitionDataImpl.put(string, appDefinitionDataImpl);
                int n7 = nArray[n3++];
                n3 += 2 * n7;
                n7 = nArray[n3++];
                n3 += n7;
                n7 = nArray[n3++];
                n3 += 2 * n7;
                n7 = nArray[n3++];
                n3 += n7;
                n7 = nArray[n3++];
                n3 += n7;
                n7 = nArray[n3++];
                n3 += n7;
                if (n2 >= 0) continue;
                ++n3;
                if (n2 > -4) {
                    n7 = nArray[n3++];
                    n3 += 2 * n7;
                }
                n7 = nArray[n3++];
                n3 += n7;
            }
            if (n2 < -2) {
                n3 = this.readScreenAreaData(stringArray, nArray, n3, n2);
            }
            if (n2 < 0) {
                n3 = this.readCioVisualizationData(stringArray, nArray, n3);
                n3 = this.readCioIntentClassData(stringArray, nArray, n3);
                n3 = n2 < -3 ? this.readCioIntentData(stringArray, nArray, n3) : this.readCioIntentData_OlderThanVersion3(stringArray, nArray, n3);
            }
            if (n2 < -4) {
                n = nArray[n3++];
                int n8 = nArray[n3++];
                this.cioFilterDatas = new CioFilterData[n8];
                if (n == -1) {
                    for (int i2 = 0; i2 < n8; ++i2) {
                        String string5 = this.getString(stringArray, nArray[n3++]);
                        string = this.getString(stringArray, nArray[n3++]);
                        String string6 = this.getString(stringArray, nArray[n3++]);
                        int n9 = nArray[n3++];
                        int n10 = nArray[n3++];
                        CioFilterDataImpl$CioFilterEntryImpl[] cioFilterDataImpl$CioFilterEntryImplArray = new CioFilterDataImpl$CioFilterEntryImpl[n10];
                        for (int i3 = 0; i3 < n10; ++i3) {
                            String string7 = this.getString(stringArray, nArray[n3++]);
                            appDefinitionDataArray2 = this.getString(stringArray, nArray[n3++]);
                            String string8 = this.getString(stringArray, nArray[n3++]);
                            appDefinitionDataArray = this.getString(stringArray, nArray[n3++]);
                            cioFilterDataImpl$CioFilterEntryImplArray[i3] = new CioFilterDataImpl$CioFilterEntryImpl(string7, (String)appDefinitionDataArray2, string8, (String)appDefinitionDataArray);
                        }
                        this.cioFilterDatas[i2] = new CioFilterDataImpl(string5, string, string6, n9, cioFilterDataImpl$CioFilterEntryImplArray);
                    }
                }
            }
            n3 = n2 < 0 ? 2 : 1;
            for (n = 0; n < n4; ++n) {
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                String string9 = null;
                if (n2 < -3) {
                    int n16 = ++n3;
                    ++n3;
                    string9 = stringArray[nArray[n16]];
                } else if (n2 < -1) {
                    int n17 = ++n3;
                    ++n3;
                    string9 = stringArray[nArray[n17]];
                }
                int n18 = ++n3;
                ++n3;
                String string10 = stringArray[nArray[n18]];
                ++n3;
                if (n2 < -3) {
                    // empty if block
                }
                AppDefinitionDataImpl appDefinitionDataImpl = (AppDefinitionDataImpl)this.appName2AppDefinitionDataImpl.get(string10);
                int n19 = ++n3;
                ++n3;
                int n20 = nArray[n19];
                HashMap hashMap = new HashMap(n20);
                for (n15 = 0; n15 < n20; ++n15) {
                    hashMap.put(stringArray[nArray[n3++]], stringArray[nArray[n3++]]);
                }
                appDefinitionDataImpl.setProvidedContent(hashMap);
                n15 = nArray[n3++];
                String[] stringArray2 = new String[n15];
                for (n14 = 0; n14 < n15; ++n14) {
                    stringArray2[n14] = stringArray[nArray[n3++]];
                }
                appDefinitionDataImpl.setProvidedScreenAreas(stringArray2);
                n14 = nArray[n3++];
                HashMap hashMap2 = new HashMap(n14);
                for (n13 = 0; n13 < n14; ++n13) {
                    hashMap2.put(stringArray[nArray[n3++]], stringArray[nArray[n3++]]);
                }
                appDefinitionDataImpl.setUsedScreenAreas(hashMap2);
                n13 = nArray[n3++];
                appDefinitionDataArray2 = new AppDefinitionData[n13];
                for (n12 = 0; n12 < n13; ++n12) {
                    appDefinitionDataArray2[n12] = (AppDefinitionData)this.appName2AppDefinitionDataImpl.get(stringArray[nArray[n3++]]);
                }
                appDefinitionDataImpl.setMandatoryHostedApps(appDefinitionDataArray2);
                n12 = nArray[n3++];
                appDefinitionDataArray = new AppDefinitionData[n12];
                for (n11 = 0; n11 < n12; ++n11) {
                    appDefinitionDataArray[n11] = (AppDefinitionData)this.appName2AppDefinitionDataImpl.get(stringArray[nArray[n3++]]);
                }
                appDefinitionDataImpl.setOptionalHostedApps(appDefinitionDataArray);
                n11 = nArray[n3++];
                AppDefinitionData[] appDefinitionDataArray3 = new AppDefinitionData[n11];
                for (int i4 = 0; i4 < n11; ++i4) {
                    appDefinitionDataArray3[i4] = (AppDefinitionData)this.appName2AppDefinitionDataImpl.get(stringArray[nArray[n3++]]);
                }
                appDefinitionDataImpl.setLazyStartingHostedApps(appDefinitionDataArray3);
                if (n2 < 0) {
                    int n21;
                    int n22;
                    String string11 = this.getString(stringArray, nArray[n3++]);
                    appDefinitionDataImpl.setAppAdapterClassName(string11);
                    if (n2 > -4) {
                        n22 = nArray[n3++];
                        for (int i5 = 0; i5 < n22; ++i5) {
                            n21 = nArray[n3++];
                            String string12 = this.getString(stringArray, nArray[n3++]);
                            if (string9 == null || !string9.equals(string12)) continue;
                            appDefinitionDataImpl.setAppInstanceId(n21);
                        }
                    }
                    n22 = nArray[n3++];
                    CioIntentData[] cioIntentDataArray = new CioIntentData[n22];
                    for (n21 = 0; n21 < n22; ++n21) {
                        int n23;
                        cioIntentDataArray[n21] = (n23 = nArray[n3++]) < 0 ? null : this.cioIntentDatas[n23];
                    }
                    appDefinitionDataImpl.setCioIntents(cioIntentDataArray);
                    continue;
                }
                appDefinitionDataImpl.setAppAdapterClassName(null);
                appDefinitionDataImpl.setAppInstanceId(-1);
                appDefinitionDataImpl.setAppInstanceName(string10);
                appDefinitionDataImpl.setCioIntents(new CioIntentDataImpl[0]);
            }
        }
        return this.desktopAppDefinitionData;
    }

    @Override
    public CioIntentClassData[] getCioIntentClasses() {
        this.getDesktopAppDefinitionData();
        return this.cioIntentClassData;
    }

    @Override
    public ScreenAreaData[] getDesktopAppScreenAreas() {
        this.getDesktopAppDefinitionData();
        return this.screenAreaDatas;
    }

    @Override
    public CioFilterData[] getCioFilters() {
        this.getDesktopAppDefinitionData();
        return this.cioFilterDatas;
    }
}


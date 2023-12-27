/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal.script;

import de.vw.mib.view.internal.script.AbstractScriptWidget;

public class SelectScript
extends AbstractScriptWidget {
    public static int runScriptScriptAlphabetScriptSelectDeclarationScriptAlphabetScriptSelectBehavior(int n) {
        int n2 = n;
        return n2;
    }

    public static int runScriptScriptCarMainDrivingDataSelectRefuelIconDeclarationScriptCarMainDrivingDataSelectRefuelIconBehavior(int n, int n2, boolean bl, boolean bl2) {
        int n3 = n;
        int n4 = n2;
        boolean bl3 = bl;
        boolean bl4 = bl2;
        int n5 = 0;
        if (n4 == 0) {
            if (bl3 && !bl4) {
                n5 = 1;
            } else {
                switch (n3) {
                    case 1: {
                        n5 = 0;
                        break;
                    }
                    case 4: {
                        n5 = 1;
                        break;
                    }
                    default: {
                        n5 = 0;
                        break;
                    }
                }
            }
        } else {
            n5 = n3 == 3 || n4 == 3 ? 3 : (n3 == 5 || n4 == 5 ? 4 : 2);
        }
        return n5;
    }

    public static int runScriptFilebrowserSourcesContainerWidgetListListItemSourceButtonSourceSourceIdToImageAndNameDeclarationFilebrowserSourcesContainerWidgetListListItemSourceButtonSourceSourceIdToImageAndNameBehavior(boolean bl, boolean bl2, boolean bl3, boolean bl4, int n) {
        boolean bl5 = bl;
        boolean bl6 = bl2;
        boolean bl7 = bl3;
        boolean bl8 = bl4;
        int n2 = n;
        if (n2 == 2 && bl5) {
            return 14;
        }
        if (n2 == 3 && (bl6 || bl7 || bl8)) {
            return 15;
        }
        return n2;
    }

    public static int runScriptHomescreenScriptSelectWidgetActiveTileDeclarationHomescreenScriptSelectWidgetActiveTileBehavior(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        int n5 = 0;
        switch (n3) {
            case 0: {
                if (n4 == 0) {
                    n5 = 0;
                    break;
                }
                n5 = 7;
                break;
            }
            case 1: {
                if (n4 == 0) {
                    n5 = 1;
                    break;
                }
                n5 = 2;
                break;
            }
            case 2: {
                if (n4 == 0) {
                    n5 = 3;
                    break;
                }
                n5 = 4;
                break;
            }
            case 3: {
                if (n4 == 1) {
                    n5 = 5;
                    break;
                }
                n5 = 7;
                break;
            }
            case 4: {
                if (n4 == 1) {
                    n5 = 6;
                    break;
                }
                n5 = 7;
                break;
            }
            default: {
                n5 = 7;
            }
        }
        return n5;
    }

    public static int runScriptMediacontrolBrowserHeadLineContainerBreadCrumbsButtonPathLabelContainerScriptSetTextDeclarationMediacontrolBrowserHeadLineContainerBreadCrumbsButtonPathLabelContainerScriptSetTextBehavior(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = n;
        int n10 = n2;
        int n11 = n3;
        int n12 = n4;
        int n13 = n5;
        int n14 = n6;
        int n15 = n7;
        int n16 = n8;
        int n17 = 0;
        switch (n9) {
            case 0: {
                n17 = n10;
                break;
            }
            case 1: {
                n17 = n11;
                break;
            }
            case 2: {
                n17 = n12;
                break;
            }
            case 3: {
                n17 = n13;
                break;
            }
            case 4: {
                n17 = n14;
                break;
            }
            case 5: {
                n17 = n15;
                break;
            }
            default: {
                n17 = 0;
            }
        }
        return n17 < n16 && n17 > -1 ? n17 : 0;
    }

    public static int runScriptScriptMediacontrolBrowserItemElementSetIconDeclarationScriptMediacontrolBrowserItemElementSetIconBehavior(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        return n3 > n4 ? n4 : 0;
    }

    public static int runScriptScriptMediacontrolTranslateFilterCriteriaDeclarationScriptMediacontrolTranslateFilterCriteriaBehavior(String string, String[] stringArray) {
        String string2 = string;
        String[] stringArray2 = stringArray;
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            if (!stringArray2[i2].equals(string2)) continue;
            return i2;
        }
        return stringArray2.length;
    }

    public static int runScriptScriptMediacontrolMainFullscreenSetProgressbarContainerLayoutAttribDeclarationScriptMediacontrolMainFullscreenSetProgressbarContainerLayoutAttribBehavior(int n) {
        int n2 = n;
        if (n2 < -1071183616) {
            return 0;
        }
        if (n2 < -2131872256) {
            return 1;
        }
        return 2;
    }

    public static int runScriptScriptMediaSourceId2SourceNameDeclarationScriptMediaSourceId2SourceNameBehavior(boolean bl, int n, int n2, boolean bl2, int n3, int n4, int n5) {
        boolean bl3 = bl;
        int n6 = n;
        int n7 = n2;
        boolean bl4 = bl2;
        int n8 = n3;
        int n9 = n4;
        int n10 = n5;
        if (n10 == n7 && bl3) {
            return n6;
        }
        if (n10 == n9 && bl4) {
            return n8;
        }
        return n10;
    }

    public static int runScriptScriptMediaSourceId2SourceIconDeclarationScriptMediaSourceId2SourceIconBehavior(int n, int n2, boolean bl, boolean bl2, int n3, int n4, int n5) {
        int n6;
        int n7 = n;
        int n8 = n2;
        boolean bl3 = bl;
        boolean bl4 = bl2;
        int n9 = n3;
        int n10 = n4;
        int n11 = n5;
        switch (n7) {
            case 1: 
            case 4: {
                n6 = n8 != 10 ? n7 : n11;
                break;
            }
            case 2: {
                n6 = bl3 ? n9 : n7;
                break;
            }
            case 8: {
                n6 = bl4 ? n10 : n7;
                break;
            }
            default: {
                n6 = n7;
            }
        }
        return n6;
    }

    public static int runScriptScriptMediaTranslateFilterCriteriaDeclarationScriptMediaTranslateFilterCriteriaBehavior(String string, String[] stringArray) {
        String string2 = string;
        String[] stringArray2 = stringArray;
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            if (!stringArray2[i2].equals(string2)) continue;
            return i2;
        }
        return stringArray2.length;
    }

    public static int runScriptScriptMediaTranslateFilterCriteriaListItemDeclarationScriptMediaTranslateFilterCriteriaBehavior(String[] stringArray, String string) {
        String string2 = string;
        String[] stringArray2 = stringArray;
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            if (!stringArray2[i2].equals(string2)) continue;
            return i2;
        }
        return stringArray2.length;
    }

    public static int runScriptScriptMediaJukeboxBrowserItemRootSetTextIconDeclarationScriptMediaJukeboxBrowserItemRootSetTextIconBehavior(int n) {
        int n2 = n;
        return n2;
    }

    public static int runScriptScriptMediaSetupImportSourceId2SourceIconDeclarationScriptMediaSetupImportSourceId2SourceIconBehavior(int n, boolean bl, boolean bl2, int n2, int n3) {
        int n4;
        int n5 = n;
        boolean bl3 = bl;
        boolean bl4 = bl2;
        int n6 = n2;
        int n7 = n3;
        switch (n5) {
            case 2: {
                n4 = bl3 ? n6 : n5;
                break;
            }
            case 3: {
                n4 = bl4 ? n7 : n5;
                break;
            }
            default: {
                n4 = n5;
            }
        }
        return n4;
    }

    public static int runScriptScriptMessagePreviewFooterSetButtonBackgroundsDeclarationScriptMessagePreviewFooterSetButtonBackgroundsBehavior(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        return n3 == 1 ? 0 : (n4 == 0 ? 1 : (n4 == n3 - 1 ? 3 : 2));
    }

    public static int runScriptScriptFooterSetButtonBackgroundsDeclarationScriptFooterSetButtonBackgroundsBehavior(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        return n3 == 1 ? 0 : (n4 == 0 ? 1 : (n4 == n3 - 1 ? 3 : 2));
    }

    public static int runScriptNavNewAdrHnQSpellerSpellerContainerSpellerNumericMatchHousenumberDeclarationNavNewAdrHnQSpellerSpellerContainerSpellerNumericMatchHousenumberBehavior(boolean bl) {
        boolean bl2 = bl;
        if (bl2) {
            return 1;
        }
        return 0;
    }

    public static int runScriptScriptNavNewAdrSldeSpellerSwitchAlphabetDeclarationScriptNavNewAdrSldeSpellerSwitchAlphabetBehavior(int n) {
        int n2 = n;
        if (n2 == 1 || n2 == 2) {
            return 1;
        }
        return 0;
    }

    public static int runScriptNavOptionsDatabaseFooterNewConceptControlBarFooterScriptSelectWidgetDeclarationNavOptionsDatabaseFooterNewConceptControlBarFooterScriptSelectWidgetBehavior(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        return n3 == 1 ? 0 : (n4 == 0 ? 0 : 1);
    }

    public static int runScriptNavTourModeHListMainDetailContainerHeadLineSelectHeadlineTextDeclarationNavTourModeHListMainDetailContainerHeadLineSelectHeadlineTextBehavior(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        if (n3 == 1 || n4 == n3) {
            return 1;
        }
        return 0;
    }

    public static int runScriptNavWpmMainContainerSplitScreenContainerHeadlineDropDownButtonContentScriptSelectWidgetDeclarationNavWpmMainContainerSplitScreenContainerHeadlineDropDownButtonContentScriptSelectWidgetBehavior(int n, int n2, int n3) {
        int n4 = n;
        int n5 = n2;
        int n6 = n3;
        if (n6 == 0) {
            if (n4 == 0) {
                return 0;
            }
            if (n4 == 1) {
                return 1;
            }
            return 3;
        }
        if (n5 == 0) {
            return 0;
        }
        if (n5 == 1) {
            return 1;
        }
        if (n5 == 3) {
            return 2;
        }
        return 3;
    }

    public static int runScriptScriptPictureviewerSourceId2SourceNameDeclarationScriptPictureviewerSourceId2SourceNameBehavior(boolean bl, boolean bl2, int n) {
        boolean bl3 = bl;
        boolean bl4 = bl2;
        int n2 = n;
        if (n2 == 2 && bl3) {
            return 10;
        }
        if (n2 == 3 && bl4) {
            return 11;
        }
        if (n2 == 8 && bl3) {
            return 12;
        }
        return n2;
    }

    public static int runScriptParticleBackgroundSelectParameterSetDeclarationParticleBackgroundSelectParameterSetBehavior(boolean bl, String string, String[] stringArray) {
        boolean bl2 = bl;
        String string2 = string;
        String[] stringArray2 = stringArray;
        int n = 0;
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            if (!string2.equals(stringArray2[i2])) continue;
            n = i2 * 2;
            if (bl2) break;
            ++n;
            break;
        }
        return n;
    }

    public static int runScriptSpellerGenericAlphanumericFrontFreeMatchContainerSpellerSpellerScriptSelectWidgetDeclarationSpellerGenericAlphanumericFrontFreeMatchContainerSpellerSpellerScriptSelectWidgetBehavior(int n) {
        int n2 = n;
        if (n2 == 0) {
            return 0;
        }
        return 1;
    }

    public static int runScriptSpellerGenericAlphanumericSetupFreeMatchContainerSpellerSpellerScriptSelectWidgetDeclarationSpellerGenericAlphanumericSetupFreeMatchContainerSpellerSpellerScriptSelectWidgetBehavior(int n) {
        int n2 = n;
        if (n2 == 0) {
            return 0;
        }
        return 1;
    }

    public static int runScriptTunerOverlayAmbiguousLogosContainerScriptSelectWidgetDeclarationTunerOverlayAmbiguousLogosContainerScriptSelectWidgetBehavior(int n, int n2, boolean bl) {
        int n3 = n;
        int n4 = n2;
        boolean bl2 = bl;
        int n5 = 0;
        n5 = bl2 ? n3 : n4;
        switch (n5) {
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
        }
        return 2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc.testmode;

import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import java.util.ArrayList;

public class SkinIdSelector {
    public static final int NOT_FOUND;
    public static final String ARABIC_LANGUAGE;
    private final ConfigurationManager configManagerDiag;
    private final ASLList aslSkinNames;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$list$ASLListManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerDiag;

    public SkinIdSelector(ASLListManager aSLListManager, ConfigurationManagerDiag configurationManagerDiag) {
        Preconditions.checkArgumentNotNull(aSLListManager, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$internal$list$ASLListManager == null ? (class$de$vw$mib$asl$internal$list$ASLListManager = SkinIdSelector.class$("de.vw.mib.asl.internal.list.ASLListManager")) : class$de$vw$mib$asl$internal$list$ASLListManager).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(configurationManagerDiag, new StringBuffer().append("Incoming ").append((class$de$vw$mib$configuration$ConfigurationManagerDiag == null ? (class$de$vw$mib$configuration$ConfigurationManagerDiag = SkinIdSelector.class$("de.vw.mib.configuration.ConfigurationManagerDiag")) : class$de$vw$mib$configuration$ConfigurationManagerDiag).getName()).append(" must not be null!").toString());
        this.configManagerDiag = configurationManagerDiag;
        this.aslSkinNames = aSLListManager.getASLList(1622);
    }

    public int findSkinIdFromSkinNameIndex(int n) {
        String[] stringArray = this.aslSkinNames.getRowValuesAsStrings(n);
        int n2 = this.findAssociatedSkinId(stringArray);
        return n2;
    }

    public int findNewDefaultSkinId(int n) {
        if (!this.configManagerDiag.isLanguageSupportedBySkin("ar_SA", n)) {
            return n;
        }
        int[] nArray = this.configManagerDiag.getAvailableSkins();
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            int n2 = nArray[i2];
            if (n2 >= n || !this.configManagerDiag.isLanguageSupportedBySkin("ar_SA", n2)) continue;
            return nArray[i2 + 1];
        }
        return nArray[0];
    }

    public int getActiveSkinNameIndex(int n, String string) {
        this.updateSkinNames(string);
        int n2 = n;
        if (!this.configManagerDiag.isLanguageSupportedBySkin(string, n)) {
            n2 = this.findLanguageSupportingSkinId(string);
        }
        return n2 == -1 ? n2 : this.findSkinNameIndex(n2);
    }

    private int findLanguageSupportingSkinId(String string) {
        int[] nArray = this.configManagerDiag.getAvailableSkins();
        int n = this.configManagerDiag.getDefaultSkinId();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            if (n2 < n || !this.configManagerDiag.isLanguageSupportedBySkin(string, n2)) continue;
            return n2;
        }
        return -1;
    }

    private int findAssociatedSkinId(String[] stringArray) {
        int n = -1;
        if (this.isListRowItemValid(stringArray)) {
            String string = stringArray[0];
            int[] nArray = this.configManagerDiag.getAvailableSkins();
            n = this.findAssociatedSkinId(string, nArray);
        }
        return n;
    }

    private int findAssociatedSkinId(String string, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            String string2 = this.configManagerDiag.getSkinName(n);
            if (!string.equals(string2)) continue;
            return n;
        }
        return -1;
    }

    private int findSkinNameIndex(int n) {
        String string = this.configManagerDiag.getSkinName(n);
        for (int i2 = 0; i2 < this.aslSkinNames.getSize(); ++i2) {
            String string2 = this.extractSkinName(i2);
            if (!string2.equals(string)) continue;
            return i2;
        }
        return -1;
    }

    private String extractSkinName(int n) {
        String[] stringArray = this.aslSkinNames.getRowValuesAsStrings(n);
        if (this.isListRowItemValid(stringArray)) {
            return stringArray[0];
        }
        return "";
    }

    private boolean isListRowItemValid(String[] stringArray) {
        return stringArray != null && stringArray.length == 1 && stringArray[0] != null;
    }

    private void updateSkinNames(String string) {
        ArrayList arrayList = new ArrayList();
        int[] nArray = this.configManagerDiag.getAvailableSkins();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            if (!this.configManagerDiag.isLanguageSupportedBySkin(string, n)) continue;
            arrayList.add(this.configManagerDiag.getSkinName(n));
        }
        this.aslSkinNames.updateList(arrayList.toArray());
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


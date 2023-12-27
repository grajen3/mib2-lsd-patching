/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.EsamDefinitionDataService;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.configuration.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class EsamDefinitionDataServiceImpl
implements EsamDefinitionDataService,
NvListener {
    private final ArrayList ALL = new ArrayList(0);
    private final ConfigurationManager configurationManager;
    private final Logger logger;
    private final Map category2BlockedCategories = new HashMap();
    private final Map category2CategoriesToClose = new HashMap();
    private final Map member2Category = new HashMap();

    EsamDefinitionDataServiceImpl(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
        this.logger = ServiceManager.loggerFactory.getLogger(4);
        configurationManager.addNvListener(this, 3);
    }

    EsamDefinitionDataServiceImpl(ConfigurationManager configurationManager, File file) {
        this.configurationManager = configurationManager;
        this.logger = ServiceManager.loggerFactory.getLogger(4);
        this.readEsamDefinition(file);
    }

    @Override
    public String getEsamCategoryName(String string) {
        return (String)this.member2Category.get(string);
    }

    @Override
    public Map getEsamMembersAndCategories() {
        return this.member2Category;
    }

    @Override
    public boolean isEsamCategoryBlockedBy(String string, String string2) {
        ArrayList arrayList = (ArrayList)this.category2BlockedCategories.get(string2);
        if (arrayList == null) {
            return false;
        }
        if (arrayList == this.ALL) {
            return true;
        }
        return arrayList.contains(string);
    }

    @Override
    public boolean isEsamCategoryClosing(String string, String string2) {
        ArrayList arrayList = (ArrayList)this.category2CategoriesToClose.get(string);
        if (arrayList == null) {
            return false;
        }
        if (arrayList == this.ALL) {
            return true;
        }
        return arrayList.contains(string2);
    }

    @Override
    public void notifyNvListener(int n) {
        if (n == 3) {
            this.readEsamDefinition(new File(new StringBuffer().append(this.configurationManager.getSkinPath(this.configurationManager.getCurrentSkinId())).append("/").append("esamDefinition").append(".res").toString()));
        }
    }

    private String getString(String[] stringArray, int n) {
        if (n < 0) {
            return null;
        }
        return stringArray[n];
    }

    private Object[] readDataFromObjectSwapperFile(String string) {
        File file = new File(string);
        if (ServiceManager.fileManager != null) {
            try {
                Object[] objectArray = ServiceManager.fileManager.readDataFromObjectSwapperFile(file);
                return objectArray;
            }
            catch (IOException iOException) {
                this.logger.error(2).append("Couldn't read the esam definition file '").append(file.getAbsolutePath()).append("'.").attachThrowable(iOException).log();
            }
        }
        return null;
    }

    private void readEsamDefinition(File file) {
        if (!file.exists()) {
            this.logger.error(2).append("Couldn't read the esam definition file '").append(file.getAbsolutePath()).append("'! File doesn't exist!").log();
            return;
        }
        Object[] objectArray = this.readDataFromObjectSwapperFile(file.getPath());
        if (objectArray == null || objectArray.length < 3) {
            this.logger.error(2).append("Couldn't read the esam definition file '").append(file.getAbsolutePath()).append("'! File is empty!").log();
            return;
        }
        this.category2BlockedCategories.clear();
        this.category2CategoriesToClose.clear();
        this.member2Category.clear();
        String[] stringArray = (String[])objectArray[1];
        int[] nArray = (int[])objectArray[2];
        int n = 1;
        int n2 = nArray[n++];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            String string = this.getString(stringArray, nArray[n++]);
            int n4 = nArray[n++];
            for (n3 = 0; n3 < n4; ++n3) {
                String string2 = this.getString(stringArray, nArray[n++]);
                this.member2Category.put(string2, string);
            }
            if (-1 == (n3 = nArray[n++])) {
                this.category2BlockedCategories.put(string, this.ALL);
            } else if (-2 != n3) {
                int n5 = n3;
                ArrayList arrayList = new ArrayList();
                this.category2BlockedCategories.put(string, arrayList);
                for (int i3 = 0; i3 < n5; ++i3) {
                    String string3 = this.getString(stringArray, nArray[n++]);
                    arrayList.add(string3);
                }
            }
            int n6 = nArray[n++];
            if (-1 == n6) {
                this.category2CategoriesToClose.put(string, this.ALL);
                continue;
            }
            if (-2 == n6) continue;
            int n7 = n6;
            ArrayList arrayList = new ArrayList();
            this.category2CategoriesToClose.put(string, arrayList);
            for (int i4 = 0; i4 < n7; ++i4) {
                String string4 = this.getString(stringArray, nArray[n++]);
                arrayList.add(string4);
            }
        }
    }
}


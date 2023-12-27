/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceService;
import de.vw.mib.asl.homescreen.persistence.TileContent;
import java.util.Iterator;
import java.util.List;

public class TileAppPersistence {
    private final HomescreenPersistenceService persistence;

    public TileAppPersistence(HomescreenPersistenceService homescreenPersistenceService) {
        this.persistence = homescreenPersistenceService;
    }

    public void saveTileApp(String string, int n, long l) {
        TileContent tileContent = this.loadContent(string, n);
        if (tileContent != null) {
            tileContent.setCioIntentId(l);
        } else {
            this.addTileContent(string, n, l);
        }
    }

    public Long getTileApp(String string, int n) {
        TileContent tileContent = this.loadContent(string, n);
        if (tileContent == null) {
            return null;
        }
        return new Long(tileContent.getCioIntentId());
    }

    public void dropTileApps() {
        this.getTileContents().clear();
    }

    private TileContent loadContent(String string, int n) {
        List list = this.getTileContents();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            TileContent tileContent = (TileContent)iterator.next();
            if (n != tileContent.getTileUsageIndex() || !string.equals(tileContent.getTileUsageId())) continue;
            return tileContent;
        }
        return null;
    }

    private List getTileContents() {
        return this.persistence.loadHomescreenInfo().getTileContents();
    }

    private void addTileContent(String string, int n, long l) {
        TileContent tileContent = this.persistence.createTileContent();
        tileContent.setTileUsageId(string);
        tileContent.setTileUsageIndex(n);
        tileContent.setCioIntentId(l);
        this.getTileContents().add(tileContent);
    }
}


package me.rockyhawk.naturalpanels;

import me.rockyhawk.naturalpanels.panel.Panel;

import java.io.File;

public class FileHandler {
    private final Context ctx;

    public FileHandler(Context ctx) {
        this.ctx = ctx;
        reloadPanels();
    }

    public String fileToName(File file){
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }
        return fileName;
    }

    public void reloadPanels() {
        ctx.plugin.panels.clear();

        if (!ctx.plugin.folder.exists()) {
            ctx.plugin.folder.mkdirs(); // Create folder if it doesn't exist
            return;
        }

        File[] files = ctx.plugin.folder.listFiles((dir, name) -> name.endsWith(".yml") || name.endsWith(".yaml"));
        if (files == null) return;

        for (File file : files) {
            ctx.plugin.panels.put(fileToName(file), new Panel(file));
        }
    }
}

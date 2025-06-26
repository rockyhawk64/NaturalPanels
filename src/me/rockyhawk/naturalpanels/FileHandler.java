package me.rockyhawk.naturalpanels;

import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.configuration.file.YamlConfiguration;

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

        loadYamlFilesRecursively(ctx.plugin.folder);
    }

    private void loadYamlFilesRecursively(File directory) {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively enter subfolder
                loadYamlFilesRecursively(file);
            } else if (file.isFile() && (file.getName().endsWith(".yml") || file.getName().endsWith(".yaml"))) {
                // Load YAML config and put into panels map
                ctx.plugin.panels.put(fileToName(file), YamlConfiguration.loadConfiguration(file));
            }
        }
    }
}

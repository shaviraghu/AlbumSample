// This class is written referring to the nice tutorial by Antoine Merle
// @ http://antoine-merle.com/listview-optimisations-part-2-displaying-images-in-your-lists/
// Thanks to him

package com.sample.utilities;

import java.io.File;

import android.content.Context;

public class FileCache {
	private File cacheDir;

    public FileCache(Context context) {
    	//Find the dir to save cached images
        cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url) {
        return new File(cacheDir, String.valueOf(url.hashCode()));
    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
            return;
        for (File f : files)
            f.delete();
    }
}

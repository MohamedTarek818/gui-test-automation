package com.automation.utils;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Helpers for locating files on the classpath (e.g. test data).
 */
public final class ResourceUtils {

    private ResourceUtils() {
    }

    /**
     * @param classpathLocation path relative to the classpath root, e.g. "testdata/sample-image.png"
     * @return absolute file-system path of the resource
     */
    public static String getAbsolutePath(String classpathLocation) {
        URL url = ResourceUtils.class.getClassLoader().getResource(classpathLocation);
        if (url == null) {
            throw new IllegalArgumentException("Resource not found on classpath: " + classpathLocation);
        }
        try {
            return Paths.get(url.toURI()).toAbsolutePath().toString();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Invalid resource URI: " + url, e);
        }
    }
}

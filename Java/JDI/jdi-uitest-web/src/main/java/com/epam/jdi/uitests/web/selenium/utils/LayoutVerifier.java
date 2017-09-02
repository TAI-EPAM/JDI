package com.epam.jdi.uitests.web.selenium.utils;

/*
 * Uses Sikuli API for comparing provided images with specified web browser layout.
 */

import org.sikuli.script.App;
import org.sikuli.script.Region;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class LayoutVerifier {

    private static final Set<String> EXTENSIONS = new HashSet<>(Arrays.asList(".jpg", ".jpeg", ".png"));

    /**
     * Verifies that provided files are in .jpg, .jpeg or .png formats.
     * This is a kind of compulsory measure, as Sikuli handles non-image types incorrectly.
     *
     * @param  pathToImage path to image: C:/Screenshots/img1.jpeg
     */
    public static boolean verifyImageFormat(String pathToImage) {
        int dot = pathToImage.lastIndexOf(".");
        if (dot > 0) {
            String ending = pathToImage.substring(dot);
            return EXTENSIONS.contains(ending.toLowerCase());
        }
        return false;
    }

    /**
     * Returns Match object, if a match was found.
     *
     * @return null, if match was not found.
     */
    public static boolean findMatch(String pathToFile) {
        if (driverFactory.hasRunDrivers()) {
            logger.info("Driver not run");
            return false;
        }
        //App.focus(driverFactory.currentDriverName());
        Region r = App.focusedWindow();
        return r.exists(pathToFile) != null;
    }
}

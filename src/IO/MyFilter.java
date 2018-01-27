package IO;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter{

    @Override
    public boolean accept(File pathname) {

        return pathname.getName().endsWith(".java");
    }
}

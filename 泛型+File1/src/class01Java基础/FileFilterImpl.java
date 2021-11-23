package class01Java基础;

import java.io.File;
import java.io.FileFilter;

/**
 * @author ZhangJunqi
 * @Date 2021/10/11 -23:36
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory ())
            return true;
        return pathname.getName ().toLowerCase ().endsWith (".java");
    }
}

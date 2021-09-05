import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {
    public static void main(String[] args) {
        File filePath = new File("./FileFilterImpl.java");
        FileFilterImpl fileFilterImpl = new FileFilterImpl();
        if (fileFilterImpl.accept(filePath)) {
            System.out.println("Java File");
        } else {
            System.out.println("Not Java File");
        }
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.toString().endsWith(".java");
    }
}
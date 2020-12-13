package ex3_autowiring;

import java.io.FileWriter;

public class OuputerImpl implements Outputer {

    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void writeMessage(String msg) throws Exception {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(msg);

        fileWriter.close();
    }
}

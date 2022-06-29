package Controller;

public class Logger {
    private String classname;

    public Logger(String classname) {
        this.classname = classname;
    }

    public void log(String msg) {
        System.out.println("[" + this.classname + "] " + msg);
    }

    public void error(String msg) {
        System.err.println("[ERROR] [" + this.classname + "] " + msg);
    }
}

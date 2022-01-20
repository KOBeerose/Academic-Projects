public class ThreadedPrint {
    static Thread makeThread(final String id, boolean daemon) {
        Thread t = new Thread(id) {
            public void run() {
                System.out.println(id);
            }
        };
        t.setDaemon(daemon);
        t.start();
        return t;
    }
    public static void main(String[] args) {
        Thread a = makeThread("A", false);
        Thread b = makeThread("B", true);
        System.out.print("End\n");
    }
}
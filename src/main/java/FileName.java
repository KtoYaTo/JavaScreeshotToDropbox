import java.text.SimpleDateFormat;
import java.util.Date;

public class FileName {
    private String fileName;
    private String type = "png";

    FileName() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        fileName = formater.format(date);
    }

    /**
     * Types: png, jpg
     * Write without point.
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName + "." + type;
    }
}

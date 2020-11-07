import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Screenshot {
    final ByteArrayOutputStream output = new ByteArrayOutputStream() {
        @Override
        public synchronized byte[] toByteArray() {
            return this.buf;
        }
    };

    byte[] getScreenshot() throws AWTException, IOException {
        Robot robot = new Robot();
        Rectangle area = new Rectangle((Toolkit.getDefaultToolkit().getScreenSize()));
        BufferedImage buffImage = robot.createScreenCapture(area);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(buffImage, "png", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        byte[] imageByte = os.toByteArray();
        return imageByte;
    }
}

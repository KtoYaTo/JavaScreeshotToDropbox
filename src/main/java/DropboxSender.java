import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.io.*;

public class DropboxSender {
    private static final String ACCESS_TOKEN = "sl.AlB1xJJbEju70PmZqxkgj93_iNzBmq_WnhCnuEhFJiyo7kCb5aIwH7d65LqJ9gla55MzZoKO3VAnEY8K3t7uvh7jfcOMDXYrif13VXFzYMg2ueBqrd7hgFgKePhF68XF4liGZbc";
    private DbxClientV2 client;

    DropboxSender() {
        // Create Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    boolean sendDropboxFile(String name, byte[] image) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(image);
            client.files().uploadBuilder("/"+name).uploadAndFinish(in);
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
        return true;
    }
}

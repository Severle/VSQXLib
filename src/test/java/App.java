import com.severle.VSQX;
import com.severle.factory.VSQXFactory;
import com.severle.writer.Vsq4Writer;

public class App {
    public static void main(String[] args) throws Exception {
        VSQX vsqx = VSQXFactory.getBlankDefaultVSQX();
        Vsq4Writer.write(vsqx, "src/main/resources/test.vsqx");
    }
}

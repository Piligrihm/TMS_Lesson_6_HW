import com.tms.exception.ContainSequanceAtEndException;
import com.tms.exception.ContainSequanceAtStartException;
import com.tms.exception.ContainSequanceException;
import stringFormatter.StringToMyFormat;

public class Task_00 extends StringToMyFormat {
    public static void main(String[] args) {
        String docNumber = "1257-ABC-3948-abc-5b5c";

        try {
            checkCharSequence(docNumber, "abc");
            checkStringStart(docNumber, "555");
            checkStringEnd(docNumber, "1a2b");

        } catch (ContainSequanceException | ContainSequanceAtStartException | ContainSequanceAtEndException e) {
            e.printStackTrace();
        }
    }
}

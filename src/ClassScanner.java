import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Evan on 12/4/2016.
 */
public class ClassScanner {
    protected static ArrayList<Class> ALClass = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {

        Scanner fScan = new Scanner(new File("Classes.txt"));
        while (fScan.hasNextLine())
            scanFile(fScan);

        for(Class e: ALClass) {
            System.out.println(e.toString());
            System.out.println(e.getDays());
        }
        }

    public static void scanFile(Scanner fScan) {
        String title = "",daysletters, days = "", times = "", building = "", prof = "", type = "";
        String temp = "";
        while (fScan.hasNextLine()) {
            String line1 = fScan.nextLine();
            if (line1.contains("<th class=\"ddtitle\" scope=\"colgroup\">")) {
                title = (line1.substring(142, line1.length() - 34));
            }
            if (fScan.nextLine().equals("<td class=\"dddefault\">Class</td>")) {
                times = fScan.nextLine();
                days = fScan.nextLine();
                days = (days.substring(22,days.length()-5));
                fScan.nextLine();
                fScan.nextLine();
                fScan.nextLine();
                prof = fScan.nextLine();
                Scanner pScanner = new Scanner(prof).useDelimiter("<td class=\"dddefault\">");
                prof = pScanner.next();
                try {
                    prof = prof.substring(0,prof.indexOf("(<abbr"));
                } catch (StringIndexOutOfBoundsException e) {
                    prof = "TBA";
                }
                ALClass.add(new Class(title,times.substring(22,times.length()-5),prof,days));
            }
        }
    }
}
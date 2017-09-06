import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Evan on 12/5/2016.
 */
public class GUIController {
    static JFrame jFrame;
    static AL action = new AL();
    static class AL implements ActionListener {
        private JButton lastButtonPressed = new JButton();

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            btn.setEnabled(false);
            String bText = btn.getText();
            if (lastButtonPressed.getText().contains(":")) {
                if (bText.contains(":00")) {
                    bText = bText.substring(0,bText.length()-4)+"15"+bText.substring(bText.length()-2,bText.length());
                }//Stupid replace didnt work
                if (bText.contains("3")) {
                    bText = bText.substring(0,bText.length()-4)+"20"+bText.substring(bText.length()-2,bText.length());
                }

                String text = "";
                btn.setEnabled(false);
                for (String s : times2Names(btn, lastButtonPressed.getText(), bText)) {
                    text += s + "\n\n";
                }
                if(!text.equals("")) {
                    JFrame results = new JFrame();
                    results.setPreferredSize(new Dimension(900, 500));
                    JTextArea textBox = new JTextArea(text);

                    JScrollPane scroll = new JScrollPane (textBox);
                    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


                    Font font = new Font("Courier", Font.BOLD,12);
                    textBox.setFont(font);
                    results.add(scroll,BorderLayout.CENTER);
                    results.pack();
                    results.setLocationRelativeTo(null);
                    results.setVisible(true);
                }
                lastButtonPressed = new JButton();
            }
            lastButtonPressed = btn;
            }
        }


    private static String dayHelper(JButton btn){
        String output = "";
        switch (Integer.parseInt(btn.getName())&5){
            case (0):
                output = "M";
                break;
            case (1):
                output = "T";
                break;
            case (2):
                output = "W";
                break;
            case (3):
                output = "R";
                break;
            case (4):
                output = "F";
                break;
        }
        return output;
    }
    public static ArrayList<String> times2Names(JButton btn, String time1, String time2) {
        Set<String> output1 = new HashSet<>();
        try {
            Scanner fScan = new Scanner(new File("Classes.txt"));
            while (fScan.hasNextLine())
                ClassScanner.scanFile(fScan);

            for (Class c : ClassScanner.ALClass) {
                Scanner timescan = new Scanner(c.getTimes());
                String ftime1 = timescan.next() + timescan.next();
                timescan.next();
                String ftime2 = timescan.nextLine();
                ftime2 = ftime2.replaceAll("\\s","");
                if (ftime1.equals(time1) && ftime2.equals(time2) && (c.getDays().contains(dayHelper(btn))))
                    output1.add("Class Name: "+c.getTitle() + " | Prof: "+c.getProf()+"  | Time: "+c.getTimes()+"  | Days: "+c.getDays()+"  ");
            }

        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
            return new ArrayList<String>(output1);
        }
        return new ArrayList<String>(output1);
    }

    private static String[] times = {"8:30am", "9:00am", "9:30am", "10:00am", "10:30am", "11:00am", "11:30am", "12:00pm", "12:30pm", "1:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm", "7:30pm", "8:00pm"};

    public static void main(String[] args) {
        jFrame = new JFrame();
        jFrame.setPreferredSize(new Dimension(1600,1000));
        jFrame.setResizable(false);
        JLabel jLabel = new JLabel("                                             MONDAY" +
                "                                                                                         TUESDAY" +
                "                                                                                    WEDNESDAY" +
                "                                                                                   THURSDAY" +
                "                                                                                        FRIDAY");
        jFrame.add(jLabel,BorderLayout.NORTH);

        JPanel JGrid = new JPanel(new GridLayout(20,5));
        for (int i = 0; i < 100; i++) {
            JButton btn = new JButton(times[i/5]);
            btn.setName(i+"");
            JGrid.add(btn);
            btn.addActionListener(action);

        }





        jFrame.add(JGrid, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

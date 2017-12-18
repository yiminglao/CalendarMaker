import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.*;

public class CalendarMaker extends JFrame implements ActionListener{

    private JButton display;
    private JButton exit;
    private JTextField yearField;
    private JList<String> months;

    public CalendarMaker()
    {
        setTitle("Calendar Make");
        setSize(300,300);

        JPanel top = new JPanel();
        display = new JButton("Display");
        display.addActionListener(this);
        top.add(display);

        exit = new JButton("Exit");
//        exit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });

        exit.addActionListener(this);
        top.add(exit);

        add(top,BorderLayout.NORTH);

        JPanel bottom = new JPanel();
        GregorianCalendar now = new GregorianCalendar();

        yearField = new JTextField(""+ now.get(Calendar.YEAR));
        bottom.add(new JLabel("year: "));
        bottom.add(yearField);

        add(bottom, BorderLayout.SOUTH);


        String monthList[] = {	"January",   "February",  "March",
                "April",    "May",       "June",
                "July",     "August",    "September",
                "October",  "November",  "December"
        };
        months = new JList<>(monthList);
        months.setSelectedIndex(now.get(Calendar.MONTH));
        JScrollPane scroll = new JScrollPane(months);
        add(scroll);

        months.ensureIndexIsVisible(now.get(Calendar.MONTH));


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);


    }

    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source == display)
        {
            try{
                int month = months.getSelectedIndex();
                int year = Integer.parseInt(yearField.getText());
                MCalendar mc = new MCalendar(month,year);
            }catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(this,"Please enter year");
            }
        }
        else if(source == exit)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new CalendarMaker();
    }
}

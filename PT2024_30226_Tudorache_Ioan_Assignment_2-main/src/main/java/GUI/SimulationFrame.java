package GUI;

import Business_Logic.Scheduler;
import Business_Logic.SimulationManager;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationFrame extends JFrame {
    private JTextField jClientsText;
    private JButton jEnterText;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel9;
    private JPanel jMainPanel;
    private JTextField jMaxArrivalText;
    private JTextField jMaxServiceText;
    private JTextField jMaxSimText;
    private JTextField jMinArrivalText;
    private JTextField jMinServiceText;
    private JTextPane jOutputText;
    private JCheckBox jQueueCheck;
    private JTextField jQueuesText;
    private JScrollPane jScrollPane1;
    private JCheckBox jTimeCheck;
    private static SimulationFrame frame;

    public SimulationFrame() {
        initComponents();
    }

    private void initComponents() {

        jMainPanel = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jClientsText = new JTextField();
        jLabel3 = new JLabel();
        jQueuesText = new JTextField();
        jLabel4 = new JLabel();
        jMaxSimText = new JTextField();
        jLabel5 = new JLabel();
        jMaxArrivalText = new JTextField();
        jLabel6 = new JLabel();
        jMinArrivalText = new JTextField();
        jLabel7 = new JLabel();
        jMaxServiceText = new JTextField();
        jLabel9 = new JLabel();
        jMinServiceText = new JTextField();
        jEnterText = new JButton();
        jScrollPane1 = new JScrollPane();
        jOutputText = new JTextPane();
        jTimeCheck = new JCheckBox();
        jQueueCheck = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMainPanel.setBackground(new Color(0, 204, 204));


        jLabel1.setFont(new Font("Segoe UI", 1, 24));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("QUEUES MANAGEMENT");

        jLabel2.setFont(new Font("Segoe UI", 2, 14));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Number Of Clients:");

        jClientsText.setFont(new Font("Segoe UI", 0, 14));
        jClientsText.setHorizontalAlignment(JTextField.CENTER);
        jClientsText.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new Font("Segoe UI", 2, 14));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Number Of Queues:");

        jQueuesText.setFont(new Font("Segoe UI", 0, 14));
        jQueuesText.setHorizontalAlignment(JTextField.CENTER);
        jQueuesText.setVerifyInputWhenFocusTarget(false);

        jLabel4.setFont(new Font("Segoe UI", 2, 14));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Max Simulation Time:");

        jMaxSimText.setFont(new Font("Segoe UI", 0, 14));
        jMaxSimText.setHorizontalAlignment(JTextField.CENTER);
        jMaxSimText.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new Font("Segoe UI", 2, 14));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Max Arrival Time:");

        jMaxArrivalText.setFont(new Font("Segoe UI", 0, 14));
        jMaxArrivalText.setHorizontalAlignment(JTextField.CENTER);
        jMaxArrivalText.setVerifyInputWhenFocusTarget(false);

        jLabel6.setFont(new Font("Segoe UI", 2, 14));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Min Arrival Time:");

        jMinArrivalText.setFont(new Font("Segoe UI", 0, 14));
        jMinArrivalText.setHorizontalAlignment(JTextField.CENTER);
        jMinArrivalText.setVerifyInputWhenFocusTarget(false);

        jLabel7.setFont(new Font("Segoe UI", 2, 14));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("Max Service Time:");

        jMaxServiceText.setFont(new Font("Segoe UI", 0, 14));
        jMaxServiceText.setHorizontalAlignment(JTextField.CENTER);
        jMaxServiceText.setVerifyInputWhenFocusTarget(false);

        jLabel9.setFont(new Font("Segoe UI", 2, 14));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel9.setText("Min Service Time:");

        jMinServiceText.setFont(new Font("Segoe UI", 0, 14));
        jMinServiceText.setHorizontalAlignment(JTextField.CENTER);
        jMinServiceText.setVerifyInputWhenFocusTarget(false);

        jEnterText.setFont(new Font("Segoe UI", 2, 14));
        jEnterText.setText("Enter");
        jEnterText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jEnterTextActionPerformed(evt);
            }
        });

        jOutputText.setEditable(false);
        jOutputText.setFont(new Font("Segoe UI", 2, 14));
        jOutputText.setFocusable(false);
        jScrollPane1.setViewportView(jOutputText);

        jTimeCheck.setFont(new Font("Segoe UI", 2, 14));
        jTimeCheck.setText("Shortest Time");
        jTimeCheck.setHorizontalAlignment(SwingConstants.CENTER);

        jQueueCheck.setFont(new Font("Segoe UI", 2, 14));
        jQueueCheck.setText("Shortest Queue");
        jQueueCheck.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout jMainPanelLayout = new GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
                jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jClientsText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jQueuesText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jMaxSimText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jMinServiceText, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jMaxServiceText))
                                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jMinArrivalText))
                                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jMaxArrivalText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jQueueCheck, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTimeCheck, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                .addGap(129, 129, 129)
                                                .addComponent(jEnterText, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
        );
        jMainPanelLayout.setVerticalGroup(
                jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jMaxArrivalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jMinArrivalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jMaxServiceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jClientsText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jQueuesText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jMaxSimText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jMinServiceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jMainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTimeCheck)
                                                        .addComponent(jQueueCheck))
                                                .addGap(18, 18, 18)
                                                .addComponent(jEnterText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66))
                                        .addGroup(jMainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jMainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jMainPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jEnterTextActionPerformed(ActionEvent evt) {
        try {

            try {
                SimulationManager.timeLimit = Integer.parseInt(jMaxSimText.getText());
                if (SimulationManager.timeLimit <= 0) {
                    throw new IllegalArgumentException("Time limit must be a positive integer.");
                }

                SimulationManager.maxProcessingTime = Integer.parseInt(jMaxServiceText.getText());
                if (SimulationManager.maxProcessingTime <= 0) {
                    throw new IllegalArgumentException("Maximum processing time must be a positive integer.");
                }

                SimulationManager.minProcessingTime = Integer.parseInt(jMinServiceText.getText());
                if (SimulationManager.minProcessingTime <= 0) {
                    throw new IllegalArgumentException("Minimum processing time must be a positive integer.");
                }

                SimulationManager.maxArrivalTime = Integer.parseInt(jMaxArrivalText.getText());
                if (SimulationManager.maxArrivalTime <= 0) {
                    throw new IllegalArgumentException("Maximum arrival time must be a positive integer.");
                }

                SimulationManager.minArrivalTime = Integer.parseInt(jMinArrivalText.getText());
                if (SimulationManager.minArrivalTime <= 0) {
                    throw new IllegalArgumentException("Minimum arrival time must be a positive integer.");
                }

                SimulationManager.numberOfServers = Integer.parseInt(jQueuesText.getText());
                if (SimulationManager.numberOfServers <= 0) {
                    throw new IllegalArgumentException("Number of servers must be a positive integer.");
                }

                SimulationManager.numberofClients = Integer.parseInt(jClientsText.getText());
                if (SimulationManager.numberofClients <= 0) {
                    throw new IllegalArgumentException("Number of clients must be a positive integer.");
                }
                if (jQueueCheck.isSelected() && jTimeCheck.isSelected()) {
                    throw new IllegalArgumentException("Check only one box.");
                }
                if (!jQueueCheck.isSelected() && !jTimeCheck.isSelected()) {
                    throw new IllegalArgumentException("Check one box.");
                }
                if (jQueueCheck.isSelected()) {
                    SimulationManager.selectionPolicy = Scheduler.SelectionPolicy.SHORTEST_QUEUE;
                } else if (jTimeCheck.isSelected()) {
                    SimulationManager.selectionPolicy = Scheduler.SelectionPolicy.SHORTEST_TIME;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("One of the inputs is not a valid integer.", e);
            }

            SimulationManager gen = new SimulationManager(frame);
            Thread t = new Thread(gen);
            t.start();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void setjOutputText(String output) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jOutputText.setText(output);
                jScrollPane1.setViewportView(jOutputText);
            }
        });
    }




    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SimulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SimulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SimulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SimulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
               frame =  new SimulationFrame();
               frame.setVisible(true);
            }
        });
    }


}

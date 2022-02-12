import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class elevator_control extends JFrame {
    private JRadioButton elev_2_at_pos_3;
    private JPanel panel1;
    private JRadioButton elev_2_at_pos_2;
    private JRadioButton elev_2_at_pos_1;
    public JRadioButton elev_1_at_pos_3;
    private JRadioButton elev_1_at_pos_2;
    private JRadioButton elev_1_at_pos_1;
    private JButton callButton;
    private JButton callButton1;
    private JButton callButton2;
    private JButton elev_1_goto_3;
    private JButton elev_2_goto_3;
    private JButton elev_1_goto_2;
    private JButton elev_2_goto_2;
    private JButton elev_1_goto_1;
    private JButton elev_2_goto_1;
    private JTextField central_controller_terminal;
    private JButton emergencyButton;
    private JButton emergencyButton1;
    public Central_Controller c;
    public Local_Controller local_controller_1;
    public Local_Controller local_controller_2;

    public elevator_control() {
        callButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                front_panel_call_button_processor(1);
            }
        });
        callButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                front_panel_call_button_processor(2);
            }
        });
        callButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                front_panel_call_button_processor(3);
            }
        });
        elev_1_goto_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal_button_processor(1, 1);
            }
        });
        elev_2_goto_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal_button_processor(1, 2);
            }
        });
        elev_1_goto_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal_button_processor(2, 1);
            }
        });
        elev_2_goto_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal_button_processor(2, 2);
            }
        });
        elev_2_goto_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal_button_processor(3, 2);
            }
        });
        elev_1_goto_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internal_button_processor(3, 1);
            }
        });
        emergencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pop up message dialog box: "Emergency, Fire Department Notified"
                JOptionPane.showMessageDialog(null, "Emergency, Fire Department Notified");
            }
        });
        emergencyButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Emergency, Fire Department Notified");
            }
        });
        c = new Central_Controller();
        local_controller_1 = new Local_Controller(1);
        local_controller_2 = new Local_Controller(2);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(7, 8, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setPreferredSize(new Dimension(1000, 250));
        elev_2_at_pos_2 = new JRadioButton();
        elev_2_at_pos_2.setEnabled(false);
        elev_2_at_pos_2.setText("Elevator 2 here");
        panel1.add(elev_2_at_pos_2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_2_at_pos_3 = new JRadioButton();
        elev_2_at_pos_3.setEnabled(false);
        elev_2_at_pos_3.setText("Elevator 2 here");
        panel1.add(elev_2_at_pos_3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_2_at_pos_1 = new JRadioButton();
        elev_2_at_pos_1.setEnabled(false);
        elev_2_at_pos_1.setText("Elevator 2 here");
        panel1.add(elev_2_at_pos_1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_1_at_pos_3 = new JRadioButton();
        elev_1_at_pos_3.setEnabled(false);
        elev_1_at_pos_3.setText("Elevator 1 here");
        panel1.add(elev_1_at_pos_3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_1_at_pos_2 = new JRadioButton();
        elev_1_at_pos_2.setEnabled(false);
        elev_1_at_pos_2.setText("Elevator 1 here");
        panel1.add(elev_1_at_pos_2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_1_at_pos_1 = new JRadioButton();
        elev_1_at_pos_1.setEnabled(false);
        elev_1_at_pos_1.setForeground(new Color(-4473925));
        elev_1_at_pos_1.setSelected(true);
        elev_1_at_pos_1.setText("Elevator 1 here");
        panel1.add(elev_1_at_pos_1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        callButton = new JButton();
        callButton.setText("Call");
        panel1.add(callButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        callButton1 = new JButton();
        callButton1.setText("Call");
        panel1.add(callButton1, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        callButton2 = new JButton();
        callButton2.setText("Call");
        panel1.add(callButton2, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Floor 3");
        panel1.add(label1, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Floor 2");
        panel1.add(label2, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Floor 1");
        panel1.add(label3, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_2_goto_3 = new JButton();
        elev_2_goto_3.setText("3");
        panel1.add(elev_2_goto_3, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_2_goto_2 = new JButton();
        elev_2_goto_2.setText("2");
        panel1.add(elev_2_goto_2, new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_2_goto_1 = new JButton();
        elev_2_goto_1.setText("1");
        panel1.add(elev_2_goto_1, new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Elevator 2 Controls");
        panel1.add(label4, new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Elevator Position Indicator");
        panel1.add(label5, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Floor Call Buttons>>");
        panel1.add(label6, new GridConstraints(0, 2, 3, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 5, 7, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        central_controller_terminal = new JTextField();
        central_controller_terminal.setEditable(false);
        panel1.add(central_controller_terminal, new GridConstraints(4, 4, 3, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Central Controller:");
        panel1.add(label7, new GridConstraints(4, 3, 3, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_1_goto_3 = new JButton();
        elev_1_goto_3.setText("3");
        panel1.add(elev_1_goto_3, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_1_goto_2 = new JButton();
        elev_1_goto_2.setText("2");
        panel1.add(elev_1_goto_2, new GridConstraints(1, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elev_1_goto_1 = new JButton();
        elev_1_goto_1.setText("1");
        panel1.add(elev_1_goto_1, new GridConstraints(2, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Elevator 1 Controls");
        panel1.add(label8, new GridConstraints(3, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emergencyButton = new JButton();
        emergencyButton.setIcon(new ImageIcon(getClass().getResource("/emergency-transparent-png.png")));
        emergencyButton.setText("Emergency");
        panel1.add(emergencyButton, new GridConstraints(4, 6, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emergencyButton1 = new JButton();
        emergencyButton1.setIcon(new ImageIcon(getClass().getResource("/emergency-transparent-png.png")));
        emergencyButton1.setText("Emergency");
        panel1.add(emergencyButton1, new GridConstraints(4, 7, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    class Central_Controller {
        //default constructor of this class
        public Central_Controller() {
            elevator_control.this.elev_1_goto_1.setEnabled(false);
            elevator_control.this.elev_2_goto_1.setEnabled(false);
            elevator_control.this.elev_1_goto_2.setEnabled(false);
            elevator_control.this.elev_2_goto_2.setEnabled(false);
            elevator_control.this.elev_1_goto_3.setEnabled(false);
            elevator_control.this.elev_2_goto_3.setEnabled(false);
        }

        public void button_pressed(int i) {
            System.out.println("call from floor " + i);
            process_button_pressed(i);
        }

        public void process_button_pressed(int i) {
            //check local controllers 1 and 2
            boolean status_1 = local_controller_1.get_status();
            boolean status_2 = local_controller_2.get_status();
            //print status
            System.out.println("Status 1: " + status_1);
            elevator_control.this.central_controller_terminal.setText("Elevator 1 is: " + new String(status_1 ? "free" : "busy"));
            System.out.println("Status 2: " + status_2);
            elevator_control.this.central_controller_terminal.setText("Elevator 2 is: " + new String(status_2 ? "free" : "busy"));
            //if both free
            if (status_1 && status_2) {
                System.out.println("Both free");
                //get positions of local controllers
                int pos_1 = local_controller_1.get_position();
                int pos_2 = local_controller_2.get_position();
                //check which position is closer to call_from_floor
                if (Math.abs(pos_1 - i) < Math.abs(pos_2 - i)) {
                    //position 1 is closer
                    //tell local controller 1 to go to call_from_floor
                    local_controller_1.go_to_floor(i);
                } else if (Math.abs(pos_1 - i) > Math.abs(pos_2 - i)) {
                    //position 2 is closer
                    //tell local controller 2 to go to call_from_floor
                    local_controller_2.go_to_floor(i);
                } else {
                    //both are at same distance from call_from_floor
                    //choose one of them randomly
                    int random = (int) (Math.random() * 2);
                    if (random == 0) {
                        //tell local controller 1 to go to call_from_floor
                        local_controller_1.go_to_floor(i);
                    } else {
                        //tell local controller 2 to go to call_from_floor
                        local_controller_2.go_to_floor(i);
                    }
                }
            }
            //if local controller 1 free
            else if (status_1) {
                local_controller_1.go_to_floor(i);
            }
            //if local controller 2 free
            else if (status_2) {
                local_controller_2.go_to_floor(i);
            }
            //if both busy
            else {
                //wait until one of them is free
//                new Thread(new Runnable() {
//                    public void run() {
//                        //until any one of the local controllers are free, keep call buttons disabled
//                        while(!local_controller_1.get_status() || !local_controller_2.get_status()) {
//
//                        }
//                    }
//                }).start();
            }
        }
    }

    class Local_Controller {
        boolean status;
        int elevator_id;
        int current_floor;

        public Local_Controller(int i) {
            elevator_id = i;
            current_floor = 1;
            status = true;
            update_radio_button(current_floor);
        }

        public boolean get_status() {
            return status;
        }

        public void internal_button_pressed(int floor_number) {
            //go to floor number
            elevator_control.this.central_controller_terminal.setText("Elevator " + elevator_id + " is handling internal request for floor " + floor_number);
            go_to_floor(floor_number);

        }

        //deactivate inside buttons method
        public void deactivate_inside_buttons() {
            if (elevator_id == 1) {
                //work with elevator 1 inside buttons
                //deactivate buttons
                System.out.println("Elevator " + elevator_id + " Deactivating inside buttons");
                elevator_control.this.elev_1_goto_1.setEnabled(false);
                elevator_control.this.elev_1_goto_2.setEnabled(false);
                elevator_control.this.elev_1_goto_3.setEnabled(false);
            }
            if (elevator_id == 2) {
                //work with elevator 2 inside buttons
                //deactivate buttons
                System.out.println("Elevator " + elevator_id + " Deactivating inside buttons");
                elevator_control.this.elev_2_goto_1.setEnabled(false);
                elevator_control.this.elev_2_goto_2.setEnabled(false);
                elevator_control.this.elev_2_goto_3.setEnabled(false);
            }

        }

        //activate inside buttons method
        public void activate_inside_buttons() {

            if (elevator_id == 1) {
                //work with elevator 1 inside buttons
                //activate buttons
                System.out.println("Elevator " + elevator_id + " Activating inside buttons");
                elevator_control.this.elev_1_goto_1.setEnabled(true);
                elevator_control.this.elev_1_goto_2.setEnabled(true);
                elevator_control.this.elev_1_goto_3.setEnabled(true);
            }
            if (elevator_id == 2) {
                //work with elevator 2 inside buttons
                //activate buttons
                System.out.println("Elevator " + elevator_id + " Activating inside buttons");
                elevator_control.this.elev_2_goto_1.setEnabled(true);
                elevator_control.this.elev_2_goto_2.setEnabled(true);
                elevator_control.this.elev_2_goto_3.setEnabled(true);
            }
        }

        public int get_position() {
            return current_floor;
        }

        public void go_to_floor(int destination) {
            status = false;
            close_doors();
            deactivate_inside_buttons();
            //print moving to floor message
            System.out.println("Elevator " + elevator_id + " Moving to floor " + destination);
            if (current_floor < destination) {
                //print moving up message
                System.out.println("Elevator " + elevator_id + " Moving up");
                //while current floor is less than destination floor
                new Thread(new Runnable() {
                    public void run() {
                        while (current_floor < destination) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            current_floor++;
                            //update position radio button
//                            update_radio_button(current_floor);
                            update_radio_button_upper_class(current_floor, elevator_id);
                        }
                        //print arrived message
                        System.out.println("Elevator " + elevator_id + " Arrived at floor " + destination);
                        //open doors
                        open_doors();
                        //delay for 1 second
                        try {
                            Thread.sleep(2000); //emulating doors opening
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //close doors
                        close_doors();
                        //delay for 1 second
                        try {
                            Thread.sleep(2000); //emulating doors closing
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        activate_inside_buttons();
                        status = true; //elevator is free
                        System.out.println("Elevator " + elevator_id + " is free now");
                        elevator_control.this.central_controller_terminal.setText("Elevator " + elevator_id + " is free now");
                    }
                }).start();
            } else if (current_floor > destination) {
                //print moving down message
                System.out.println("Elevator " + elevator_id + " Moving down");
                //while current floor is greater than destination floor
                new Thread(new Runnable() {
                    public void run() {
                        while (current_floor > destination) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            current_floor = current_floor - 1;
                            //update position radio button
//                            update_radio_button(current_floor);
                            update_radio_button_upper_class(current_floor, elevator_id);
                        }
                        //print arrived message
                        System.out.println("Elevator " + elevator_id + " Arrived at floor " + destination);
                        //open doors
                        open_doors();
                        //delay for 1 second
                        try {
                            Thread.sleep(2000); //emulating doors opening
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //close doors
                        close_doors();
                        //delay for 1 second
                        try {
                            Thread.sleep(2000); //emulating doors closing
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        activate_inside_buttons();
                        status = true; //elevator is free
                        System.out.println("Elevator " + elevator_id + " is free now");
                        elevator_control.this.central_controller_terminal.setText("Elevator " + elevator_id + " is free now");
                    }
                }).start();
            } else {
                //already on the floor
                System.out.println("Elevator " + elevator_id + " Already on the floor");
                update_radio_button(current_floor);
                new Thread(new Runnable() {
                    public void run() {
                        //print arrived message
                        System.out.println("Elevator " + elevator_id + " Arrived at floor " + destination);
                        //open doors
                        open_doors();
                        //delay for 1 second
                        try {
                            Thread.sleep(2000); //emulating doors opening
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //close doors
                        close_doors();
                        //delay for 1 second
                        try {
                            Thread.sleep(2000); //emulating doors closing
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        activate_inside_buttons();
                        status = true; //elevator is free
                        System.out.println("Elevator " + elevator_id + " is free now");
                        elevator_control.this.central_controller_terminal.setText("Elevator " + elevator_id + " is free now");
                    }
                }).start();
            }
        }

        public void close_doors() {
            //close doors
            System.out.println("Elevator " + elevator_id + " Closing doors");
            elevator_control.this.central_controller_terminal.setText("Elevator " + elevator_id + " Closing doors");
        }

        public void open_doors() {
            //open doors
            System.out.println("Elevator " + elevator_id + " Opening doors");
            elevator_control.this.central_controller_terminal.setText("Elevator " + elevator_id + " Opening doors");
        }

        public void update_radio_button(int i) {
            //update radio button
            if (elevator_id == 1) {
                //switch case with destination
                switch (i) {
                    case 1:
                        System.out.println("Elevator " + elevator_id + " Updating radio button to floor 1");
                        elevator_control.this.elev_1_at_pos_1.setSelected(true);
                        elevator_control.this.elev_1_at_pos_2.setSelected(false);
                        elevator_control.this.elev_1_at_pos_3.setSelected(false);
                        break;
                    case 2:
                        System.out.println("Elevator " + elevator_id + " Updating radio button to floor 2");
                        elevator_control.this.elev_1_at_pos_1.setSelected(false);
                        elevator_control.this.elev_1_at_pos_2.setSelected(true);
                        elevator_control.this.elev_1_at_pos_3.setSelected(false);
                        break;
                    case 3:
                        System.out.println("Elevator " + elevator_id + " Updating radio button to floor 3");
                        elevator_control.this.elev_1_at_pos_1.setSelected(false);
                        elevator_control.this.elev_1_at_pos_2.setSelected(false);
                        elevator_control.this.elev_1_at_pos_3.setSelected(true);
                        break;
                    default:
                }
            } else {
                //switch case with destination
                switch (i) {
                    case 1:
                        System.out.println("Elevator " + elevator_id + " Updating radio button to floor 1");
                        elevator_control.this.elev_2_at_pos_1.setSelected(true);
                        elevator_control.this.elev_2_at_pos_2.setSelected(false);
                        elevator_control.this.elev_2_at_pos_3.setSelected(false);
                        break;
                    case 2:
                        System.out.println("Elevator " + elevator_id + " Updating radio button to floor 2");
                        elevator_control.this.elev_2_at_pos_1.setSelected(false);
                        elevator_control.this.elev_2_at_pos_2.setSelected(true);
                        elevator_control.this.elev_2_at_pos_3.setSelected(false);
                        break;
                    case 3:
                        System.out.println("Elevator " + elevator_id + " Updating radio button to floor 3");
                        elevator_control.this.elev_2_at_pos_1.setSelected(false);
                        elevator_control.this.elev_2_at_pos_2.setSelected(false);
                        elevator_control.this.elev_2_at_pos_3.setSelected(true);
                        break;
                    default:
                }
            }
            elevator_control.this.panel1.validate();
        }
    }

    public static void main(String[] args) {

        elevator_control j = new elevator_control();
        j.setContentPane(new elevator_control().panel1);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.pack();
        j.setVisible(true);
    }

    void front_panel_call_button_processor(int i) {
        c.button_pressed(i);
    }

    void internal_button_processor(int floor_to_go, int elevator_id) {
        if (elevator_id == 1) {
            local_controller_1.internal_button_pressed(floor_to_go);
        } else
            local_controller_2.internal_button_pressed(floor_to_go);
    }

    void update_radio_button_upper_class(int i, int elevator_id) {
        //update radio button
        if (elevator_id == 1) {
            //switch case with destination
            switch (i) {
                case 1:
                    System.out.println("Elevator " + elevator_id + " Updating radio button to floor 1");
                    elevator_control.this.elev_1_at_pos_1.setSelected(true);
                    elevator_control.this.elev_1_at_pos_2.setSelected(false);
                    elevator_control.this.elev_1_at_pos_3.setSelected(false);
                    break;
                case 2:
                    System.out.println("Elevator " + elevator_id + " Updating radio button to floor 2");
                    elevator_control.this.elev_1_at_pos_1.setSelected(false);
                    elevator_control.this.elev_1_at_pos_2.setSelected(true);
                    elevator_control.this.elev_1_at_pos_3.setSelected(false);
                    break;
                case 3:
                    System.out.println("Elevator " + elevator_id + " Updating radio button to floor 3");
                    elevator_control.this.elev_1_at_pos_1.setSelected(false);
                    elevator_control.this.elev_1_at_pos_2.setSelected(false);
                    elevator_control.this.elev_1_at_pos_3.setSelected(true);
                    break;
                default:
            }
        } else {
            //switch case with destination
            switch (i) {
                case 1:
                    System.out.println("Elevator " + elevator_id + " Updating radio button to floor 1");
                    elevator_control.this.elev_2_at_pos_1.setSelected(true);
                    elevator_control.this.elev_2_at_pos_2.setSelected(false);
                    elevator_control.this.elev_2_at_pos_3.setSelected(false);
                    break;
                case 2:
                    System.out.println("Elevator " + elevator_id + " Updating radio button to floor 2");
                    elevator_control.this.elev_2_at_pos_1.setSelected(false);
                    elevator_control.this.elev_2_at_pos_2.setSelected(true);
                    elevator_control.this.elev_2_at_pos_3.setSelected(false);
                    break;
                case 3:
                    System.out.println("Elevator " + elevator_id + " Updating radio button to floor 3");
                    elevator_control.this.elev_2_at_pos_1.setSelected(false);
                    elevator_control.this.elev_2_at_pos_2.setSelected(false);
                    elevator_control.this.elev_2_at_pos_3.setSelected(true);
                    break;
                default:
            }
        }
        elevator_control.this.panel1.validate();
    }
}

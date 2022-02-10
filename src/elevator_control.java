import javax.swing.*;
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
    Central_Controller c = new Central_Controller();
    Local_Controller local_controller_1 = new Local_Controller(1);
    Local_Controller local_controller_2 = new Local_Controller(2);

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
            elevator_control.this.central_controller_terminal.setText("Elevator 1 is: " + new String(status_1 ? "free":"busy"));
            System.out.println("Status 2: " + status_2);
            elevator_control.this.central_controller_terminal.setText("Elevator 2 is: " + new String(status_2 ? "free":"busy"));
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
//            while(true)
//            {
//                boolean s1 = local_controller_1.get_status();
//                boolean s2 = local_controller_2.get_status();
//                if(s1 || s2)
//                {
//                    break;
//                }
//            }
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
                    }
                }).start();
            }
            else if (current_floor > destination) {
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
                            current_floor= current_floor -1;
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
                    }
                }).start();
            }
            else {
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

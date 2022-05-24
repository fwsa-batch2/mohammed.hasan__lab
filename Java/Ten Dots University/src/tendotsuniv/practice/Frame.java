package tendotsuniv.practice;

import java.awt.*;
import java.awt.event.*;

//// Frame Concept
class Form extends Frame implements ActionListener {
    public Form(){
        super("Frame work");
        setSize(500,600);
        setLayout(null);
        setBackground(Color.BLACK);
        setForeground(Color.white);

        Font topicSize = new Font("comforta", Font.ITALIC, 23);

        Label topic = new Label("Registration Form");
        topic.setBounds(150,50,200,30);
        topic.setFont(topicSize);
        topic.setForeground(Color.yellow);

        Label name = new Label("Your Name: ");
        name.setBounds(80,100,80,20);

        TextField txt = new TextField();
        txt.setBounds(160,100,200,20);
        txt.setForeground(Color.black);

        Label lb2 = new Label("Gender : ");
        lb2.setBounds(80,150,50,30);

        CheckboxGroup rad = new CheckboxGroup();

        Checkbox radio = new Checkbox("Male",rad,false);
        radio.setBounds(150,150,50,30);

        Checkbox radio2 = new Checkbox("Female",rad,false);
        radio2.setBounds(230,150,50,30);

        Checkbox radio3 = new Checkbox("Rather not say",rad,false);
        radio3.setBounds(330,150,100,30);

        Label lbl = new Label("Hobbies: ");
        lbl.setBounds(80,200,60,30);

        Checkbox chbx = new Checkbox("Foot ball");
        chbx.setBounds(150,200,80,30);

        Checkbox chbx2 = new Checkbox("Basket ball");
        chbx2.setBounds(240,200,50,30);

        Label txtAreaLabel = new Label("Your Address : ");
        txtAreaLabel.setBounds(50,260,80,20);

        TextArea textArea = new TextArea(10,30);
        textArea.setBounds(180,250,170,80);
        textArea.setForeground(Color.black);


        Label courseLbl = new Label("Course : ");
        courseLbl.setBounds(50,350,60,20);
        Choice course = new Choice();
        course.setForeground(Color.black);
        course.setBounds(150,350,200,30);
        course.add("Engineering Course");
        course.add("Arts Course");
        course.add("Integrated Course");

        Button btn = new Button("Submit");
        btn.setBounds(200,450,100,25);
        btn.setBackground(Color.yellow);
        btn.setForeground(Color.black);

        add(topic);
        add(btn);
        add(name);
        add(txt);

        add(lbl);
        add(chbx);
        add(chbx2);

        add(lb2);
        add(radio);
        add(radio2);
        add(radio3);

        add(textArea);
        add(txtAreaLabel);

        add(courseLbl);
        add(course);


        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Form ob = new Form();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class Adding extends Frame implements ActionListener{
    public Adding(){
        super("Adding 2 numbers");
        setSize(700,400);
        setLayout(null);
        setVisible(true);

        Label lbl1 = new Label("Enter number 1 : ");
        lbl1.setBounds(250,100,100,20);

        TextField txt_1 = new TextField();
        txt_1.setBounds(350,100,100,20);

        Label lbl2 = new Label("Enter number 2 : ");
        lbl2.setBounds(250,150,100,20);

        TextField txt_2 = new TextField();
        txt_2.setBounds(350,150,100,20);

        Label output = new Label();
        output.setBounds(300,200,150,20);

        Button btn = new Button("Add Now");
        btn.setBounds(320, 250,70,30);

        add(lbl1);
        add(txt_1);
        add(lbl2);
        add(txt_2);
        add(output);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_1.getText().isEmpty() || txt_2.getText().isEmpty()){
                    output.setText("Please enter some values");
                }
                int num1 = Integer.parseInt(txt_1.getText());
                int num2 = Integer.parseInt(txt_2.getText());

                output.setText( "Total : " + String.valueOf(num1+num2));
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
    Adding ob = new Adding();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class CheckBox extends Frame implements ActionListener {
    public CheckBox() {
        super("Check Box Concept");
        setSize(700, 400);
        setLayout(null);
        setVisible(true);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Main menu");
        Menu subMenu = new Menu("Sub Menu");

        MenuItem item1 = new MenuItem("Item 1");
        MenuItem item2 = new MenuItem("Item 2");
        MenuItem item3 = new MenuItem("Item 3");
        MenuItem item4 = new MenuItem("Item 4");
        MenuItem item5 = new MenuItem("Item 5");

        subMenu.add(item4);
        subMenu.add(item5);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        menu.add(subMenu);
        menuBar.add(menu);
        setMenuBar(menuBar);

        Choice choice = new Choice();
        choice.setBounds(200,300,100,30);
        choice.add("Hasan");
        choice.add("Don");
        choice.add("Humaira");
        choice.add("Mohsin");

        Checkbox chbx = new Checkbox("Foot ball");
        chbx.setBounds(50, 100, 80, 30);
        Label lb1 = new Label("Unchecked");
        lb1.setBounds(50,200,100,20);

        Checkbox chbx2 = new Checkbox("Basket ball");
        chbx2.setBounds(150, 100, 50, 30);
        Label lb2 = new Label("Unchecked");
        lb2.setBounds(150,200,100,20);

        add(chbx);
        add(chbx2);
        add(lb1);
        add(lb2);
        add(choice);

        chbx.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                lb1.setText((e.getStateChange() == 1 ? "Checked" : "Unchecked"));
            }
        });
        chbx2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                lb2.setText((e.getStateChange() == 1 ? "Checked" : "Unchecked"));
            }
        });
//
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        CheckBox ob = new CheckBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


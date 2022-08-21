package tendotsuniv.practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

class Form2 extends Frame implements ActionListener {
    Button btn;
    Button btn2;
    Button btn3;
    TextArea textArea;
    TextField txt;
    TextField idTxt;
    Label output;
    Checkbox radio;
    Checkbox radio2;
    Checkbox radio3;

    String query = "";
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement stmt = null;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8";
            String username = "hasan";
            String password = "HasanTheDON7.";
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }

    public Form2(){
        super("JDBC Practice");
        connect();

        this.setSize(500,600);
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

        txt = new TextField();
        txt.setBounds(160,100,150,20);
        txt.setForeground(Color.black);

        Label id = new Label("Id : ");
        id.setBounds(340,100,30,20);
        idTxt=new TextField();
        idTxt.setBounds(370,100,40,20);
        idTxt.setForeground(Color.black);
        idTxt.addActionListener(this);

        Label lb2 = new Label("Gender : ");
        lb2.setBounds(80,150,50,30);

        CheckboxGroup rad = new CheckboxGroup();

         radio = new Checkbox("Male",rad,false);
        radio.setBounds(150,150,50,30);

        radio2 = new Checkbox("Female",rad,false);
        radio2.setBounds(230,150,50,30);

        radio3 = new Checkbox("Rather not say",rad,false);
        radio3.setBounds(330,150,100,30);

        Label lbl = new Label("Hobbies: ");
        lbl.setBounds(80,200,60,30);

        Checkbox chbx = new Checkbox("Foot ball");
        chbx.setBounds(150,200,80,30);

        Checkbox chbx2 = new Checkbox("Basket ball");
        chbx2.setBounds(240,200,50,30);

        Label txtAreaLabel = new Label("Your Address : ");
        txtAreaLabel.setBounds(50,260,80,20);

        textArea = new TextArea(5,5);
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

        btn = new Button("Save");
        btn.setBounds(100,470,100,25);
        btn.setBackground(Color.yellow);
        btn.setForeground(Color.black);
        btn.addActionListener(this);


        btn2 = new Button("Clear");
        btn2.setBounds(220,470,100,25);
        btn2.setForeground(Color.black);
        btn2.addActionListener(this);

        btn3 = new Button("Delete");
        btn3.setBounds(340,470,100,25);
        btn3.setBackground(Color.red);
        btn3.setForeground(Color.black);
        btn3.addActionListener(this);

        output = new Label("");
        output.setBounds(100,400,200,20);
        output.setForeground(Color.white);
        Font result = new Font("comforta", Font.BOLD, 14);
        output.setFont(result);

        add(topic);
        add(btn);
        add(btn2);
        add(btn3);

        add(name);
        add(txt);

        add(id);
        add(idTxt);

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
        add(output);


        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Form2 ob = new Form2();
    }
    void clear(){
        txt.setText("");
        textArea.setText("");
        idTxt.setText("");
        txt.requestFocus();
//        System.out.println(radio2.getState());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = idTxt.getText();
            String name = txt.getText();
            String address = textArea.getText();
//            String gender =

            //  Retrives details of entered id

            if(e.getSource().equals(idTxt)){
               query = "SELECT ID,NAME,ADDRESS from jdbc where ID = " + idTxt.getText();
               stmt = conn.createStatement();
               resultSet = stmt.executeQuery(query);

               if(resultSet.next()) {
                   idTxt.setText(resultSet.getString("ID"));
                   txt.setText(resultSet.getString("NAME"));
                   textArea.setText(resultSet.getString("ADDRESS"));
               }else{
                   output.setText("Invalid Id");
                   clear();
               }
            }
            // Clears all data
            if (e.getSource().equals(btn2)) {
                clear();
            }
            //
            else if(e.getSource().equals(btn)){          //  Saving Process
                if(id.isEmpty() || id == ""){
                    query = "insert into jdbc(name, address) values(?,?);";
                    preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1,name);
                    preparedStatement.setString(2,address);
                    if(name.isEmpty() || address.isEmpty()) {
                        output.setText("Please enter the values");
                        return;
                    }
                    preparedStatement.execute();
                    output.setText("Inserted");
                    clear();
                }
                else{
                    query = "update jdbc set name=?, address = ? where id = ? ";
                    preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1,name);
                    preparedStatement.setString(2,address);
                    preparedStatement.setString(3,id);
                    preparedStatement.execute();
                    output.setText("Updated");
                    clear();
                }
            }
            else if(e.getSource().equals(btn3)){         // Deleting Process
                if(!id.isEmpty() && id != ""){
                    query = "delete from jdbc where id = " + idTxt.getText();
                    preparedStatement = conn.prepareStatement(query);
                    preparedStatement.execute();
                    clear();
                    output.setText("Successfully Deleted");
                }else{
                    output.setText("Invalid Id");
                }
            }
        }catch (Exception err){
            err.printStackTrace();
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewPage;

import java.awt.Image;
import javax.swing.ImageIcon;
import graph.DijkstraAlgorithm;
import DoublyLinkedList.DoublyLinkedList;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import singlyLinkedList.SinglyLinkedList;

/**
 *
 * @author Sarith
 */
public class MainPage extends javax.swing.JFrame {

    int[][] graph;
    String[] locations;

    DoublyLinkedList bodyColorlist = new DoublyLinkedList();
    DoublyLinkedList rimAndTyersList = new DoublyLinkedList();
    DoublyLinkedList seatsList = new DoublyLinkedList();
    DoublyLinkedList lightList = new DoublyLinkedList();

    SinglyLinkedList linkedList = new SinglyLinkedList();

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        scaleImage();
        AddNewItemsPanel.setVisible(false);

        insertBodyColor();
        insertRimandTyers();
        insertSeats();
        insertLights();

        color();

        graph = new int[][]{
            {0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Sri Lanka
            {8, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // India
            {0, 7, 0, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // China
            {0, 0, 9, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Malasiya
            {0, 0, 3, 4, 0, 12, 5, 0, 0, 0, 0, 0, 0, 0, 0}, // Thailand
            {0, 0, 0, 0, 12, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0}, // Japan
            {0, 0, 0, 0, 5, 3, 0, 5, 5, 0, 0, 0, 0, 0, 0}, // South Korea
            {0, 0, 0, 0, 0, 3, 5, 0, 3, 0, 0, 0, 0, 0, 0}, // Russia
            {0, 0, 0, 0, 0, 0, 5, 3, 0, 10, 5, 0, 0, 0, 0}, // USA
            {0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 3, 3, 0, 0, 0}, // Newzeland
            {0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 5, 3, 0, 0}, // Canada
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 12, 0, 0}, // England
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 12, 0, 5, 0}, // France
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 3}, // Denmark
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0} // Netherland
        };

        // Array of location names
        locations = new String[]{"Sri_Lanka", "India", "China", "Malasiya", "Thailand", "Japan", "South_Korea", "Russia", "USA", "Newzeland", "Canada", "England", "France", "Denmark", "Netherland"};

    }

    public MainPage(SinglyLinkedList linkedList,DoublyLinkedList bodyColorlist, DoublyLinkedList rimAndTyersList, DoublyLinkedList seatsList, DoublyLinkedList lightList) {
        initComponents();
        scaleImage();
        AddNewItemsPanel.setVisible(false);

        insertBodyColor();
        insertRimandTyers();
        insertSeats();
        insertLights();

        color();
        
        this.bodyColorlist = bodyColorlist;
        this.rimAndTyersList = rimAndTyersList;
        this.seatsList = seatsList;
        this.lightList = lightList;
        
        this.linkedList = linkedList;
//        linkedList.display();

        graph = new int[][]{
            {0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Sri Lanka
            {8, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // India
            {0, 7, 0, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // China
            {0, 0, 9, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Malasiya
            {0, 0, 3, 4, 0, 12, 5, 0, 0, 0, 0, 0, 0, 0, 0}, // Thailand
            {0, 0, 0, 0, 12, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0}, // Japan
            {0, 0, 0, 0, 5, 3, 0, 5, 5, 0, 0, 0, 0, 0, 0}, // South Korea
            {0, 0, 0, 0, 0, 3, 5, 0, 3, 0, 0, 0, 0, 0, 0}, // Russia
            {0, 0, 0, 0, 0, 0, 5, 3, 0, 10, 5, 0, 0, 0, 0}, // USA
            {0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 3, 3, 0, 0, 0}, // Newzeland
            {0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 5, 3, 0, 0}, // Canada
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 12, 0, 0}, // England
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 12, 0, 5, 0}, // France
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 3}, // Denmark
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0} // Netherland
        };

        // Array of location names
        locations = new String[]{"Sri_Lanka", "India", "China", "Malasiya", "Thailand", "Japan", "South_Korea", "Russia", "USA", "Newzeland", "Canada", "England", "France", "Denmark", "Netherland"};

    }

    public void color() {
        tfNewItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tfNewItemPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public final void insertBodyColor() {
        bodyColorlist.insertAtEnd("Red", 25000.00);
        bodyColorlist.insertAtEnd("orange", 50000.00);
        bodyColorlist.insertAtEnd("Chocolate", 22000.00);
        bodyColorlist.insertAtEnd("Green", 15000.00);
        bodyColorlist.insertAtEnd("Blue", 12000.00);
        bodyColorlist.insertAtEnd("Yellow", 32600.00);
        bodyColorlist.insertAtEnd("Black", 41000.00);
        bodyColorlist.insertAtEnd("White", 32000.00);
        bodyColorlist.insertAtEnd("Purple", 55000.00);
        bodyColorlist.insertAtEnd("Gold", 100000.00);
        bodyColorlist.insertAtEnd("Black", 41000.00);

    }

    public final void insertRimandTyers() {
        rimAndTyersList.insertAtEnd("Golden Rim and Tyer", 2500.00);
        rimAndTyersList.insertAtEnd("Danlop Tyer", 500.00);
        rimAndTyersList.insertAtEnd("Silver Rim and Tyer", 9500.00);
        rimAndTyersList.insertAtEnd("Metal Rim", 5600.00);
        rimAndTyersList.insertAtEnd("Carbon fiber Rim and Tyer", 4000.00);
        rimAndTyersList.insertAtEnd("Silver Mix Rim and Tyer", 3500.00);
        rimAndTyersList.insertAtEnd("DSI Tyer", 3000.00);
        rimAndTyersList.insertAtEnd("DSI Tyer", 7000.00);
        rimAndTyersList.insertAtEnd("Super Rim and Tyer", 3000.00);

    }

    public final void insertSeats() {
        seatsList.insertAtEnd("Bucket Seat", 2000.00);
        seatsList.insertAtEnd("Bench Seat", 3000.00);
        seatsList.insertAtEnd("Captain's Chair", 3200.00);
        seatsList.insertAtEnd("Reclining Seat", 1200.00);
        seatsList.insertAtEnd("Split-Folding Seat", 5200.00);
        seatsList.insertAtEnd("Heated Seat", 6200.00);
        seatsList.insertAtEnd("Ventilated Seat", 1200.00);
        seatsList.insertAtEnd("Power-Adjustable Seat", 7500.00);
        seatsList.insertAtEnd("Massaging Seat", 9500.00);
        seatsList.insertAtEnd("Stow 'n Go Seat", 2650.00);
        seatsList.insertAtEnd("Booster Seat", 8942.00);
        seatsList.insertAtEnd("Child Safety Seat", 3216.00);
    }

    public final void insertLights() {
        lightList.insertAtEnd("Headlights", 2100.00);
        lightList.insertAtEnd("Taillights", 3265.00);
        lightList.insertAtEnd("Brake Lights", 5210.00);
        lightList.insertAtEnd("Turn Signal Lights", 4125.00);
        lightList.insertAtEnd("Reverse Lights", 3267.00);
        lightList.insertAtEnd("Fog Lights", 2851.00);
        lightList.insertAtEnd("Daytime Running Lights", 2358.00);
        lightList.insertAtEnd("Interior Lights", 9851.00);
        lightList.insertAtEnd("Parking Lights", 1258.00);
        lightList.insertAtEnd("Hazard Lights", 3269.00);
    }

    public final void scaleImage() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Saved Pictures\\car01.jpg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(labelOne.getWidth(), labelOne.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelOne.setIcon(scaledIcon);

        ImageIcon icon1 = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Saved Pictures\\car.jpg");
        Image img1 = icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(labelTwo.getWidth(), labelTwo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
        labelTwo.setIcon(scaledIcon1);

        ImageIcon icon2 = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Saved Pictures\\car02.jpg");
        Image img2 = icon2.getImage();
        Image imgScale2 = img2.getScaledInstance(labelTwo.getWidth(), labelTwo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        labelTwo1.setIcon(scaledIcon2);

        ImageIcon icon3 = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Saved Pictures\\car03.jpg");
        Image img3 = icon3.getImage();
        Image imgScale3 = img3.getScaledInstance(labelTwo.getWidth(), labelTwo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
        labelFour.setIcon(scaledIcon3);

        ImageIcon icon4 = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Saved Pictures\\car04.jpg");
        Image img4 = icon4.getImage();
        Image imgScale4 = img4.getScaledInstance(labelTwo.getWidth(), labelTwo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
        labelFive.setIcon(scaledIcon4);

        ImageIcon icon5 = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Saved Pictures\\car05.png");
        Image img5 = icon5.getImage();
        Image imgScale5 = img5.getScaledInstance(labelTwo.getWidth(), labelTwo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
        labelSix.setIcon(scaledIcon5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelOne = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelTwo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        labelTwo1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        labelSix = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelFour = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        labelFive = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnOngoingOrders = new javax.swing.JButton();
        btnAdminOnly = new javax.swing.JButton();
        AddNewItemsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxProduct = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfNewItem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfNewItemPrice = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnClearAll = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Page");
        setBounds(new java.awt.Rectangle(0, 0, 1080, 650));
        setMinimumSize(new java.awt.Dimension(1080, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 650));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(1080, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 600));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(520, 520));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        labelOne.setAlignmentY(0.0F);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Porsche 911 GT3 RS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOne, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setPreferredSize(new java.awt.Dimension(520, 520));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        labelTwo.setAlignmentY(0.0F);
        labelTwo.setPreferredSize(new java.awt.Dimension(320, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Porsche 911 Turbo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 520));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        labelTwo1.setAlignmentY(0.0F);
        labelTwo1.setPreferredSize(new java.awt.Dimension(320, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Porsche 911 Carrera T");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTwo1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTwo1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.setPreferredSize(new java.awt.Dimension(520, 520));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
        });

        labelSix.setAlignmentY(0.0F);
        labelSix.setPreferredSize(new java.awt.Dimension(320, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("911 Carrera GT4");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelSix, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSix, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(520, 520));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        labelFour.setAlignmentY(0.0F);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("911 Turbo Cabriolet");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFour, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.setPreferredSize(new java.awt.Dimension(520, 520));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        labelFive.setAlignmentY(0.0F);
        labelFive.setPreferredSize(new java.awt.Dimension(320, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Porsche 911 Dakar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelFive, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFive, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnOngoingOrders.setBackground(new java.awt.Color(0, 204, 51));
        btnOngoingOrders.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnOngoingOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnOngoingOrders.setText("Ongoing Orders");
        btnOngoingOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOngoingOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOngoingOrdersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOngoingOrdersMouseExited(evt);
            }
        });
        btnOngoingOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOngoingOrdersActionPerformed(evt);
            }
        });

        btnAdminOnly.setBackground(new java.awt.Color(255, 51, 51));
        btnAdminOnly.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAdminOnly.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminOnly.setText("Admin Only");
        btnAdminOnly.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminOnly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminOnlyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminOnlyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminOnlyMouseExited(evt);
            }
        });
        btnAdminOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminOnlyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Add New Items");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Choose Product:");

        cbxProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Product", "Body Color", "Rim & Tyers", "Seats", "Lights", " " }));
        cbxProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductActionPerformed(evt);
            }
        });
        cbxProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxProductKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("New Item:");

        tfNewItem.setPreferredSize(new java.awt.Dimension(73, 37));
        tfNewItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNewItemKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("New Item Pirce:");

        tfNewItemPrice.setPreferredSize(new java.awt.Dimension(73, 37));
        tfNewItemPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNewItemPriceKeyTyped(evt);
            }
        });

        btnClearAll.setBackground(new java.awt.Color(255, 102, 51));
        btnClearAll.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClearAll.setForeground(new java.awt.Color(255, 255, 255));
        btnClearAll.setText("Clear All");
        btnClearAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearAllMouseExited(evt);
            }
        });
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 204, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("+ Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddNewItemsPanelLayout = new javax.swing.GroupLayout(AddNewItemsPanel);
        AddNewItemsPanel.setLayout(AddNewItemsPanelLayout);
        AddNewItemsPanelLayout.setHorizontalGroup(
            AddNewItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewItemsPanelLayout.createSequentialGroup()
                .addGroup(AddNewItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewItemsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(AddNewItemsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddNewItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNewItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNewItemPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AddNewItemsPanelLayout.createSequentialGroup()
                                .addGroup(AddNewItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(AddNewItemsPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(AddNewItemsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddNewItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClearAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        AddNewItemsPanelLayout.setVerticalGroup(
            AddNewItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewItemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNewItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddNewItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdminOnly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOngoingOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdminOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddNewItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addComponent(btnOngoingOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Path(String shortestPath, String destination) {
        // Split the path into words
        String[] words = shortestPath.split(" ");
        System.out.print("Shortest path root from " + destination + " to Sri lanka : ");

        // Print the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println("");
    }
    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        int distance = 0;
        String shortestPath = "null";

        // Destination location for which shortest path is to be found
        String destination = "USA";
        if (graph != null) {
            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }

        int importDay = distance;
        System.out.println("Days for import: " + importDay);
        Path(shortestPath, destination);

        String name = "Porsche 911 GT3 RS";
        double price = 112326.00;
        CustomizationPage carOne = new CustomizationPage(name, price, importDay, destination, bodyColorlist, rimAndTyersList, seatsList, lightList, linkedList);
        carOne.setVisible(true);
        carOne.pack();
        carOne.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        int distance = 0;
        String shortestPath = "null";

        // Destination location for which shortest path is to be found
        String destination = "France";
        if (graph != null) {
            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }

        int importDay = distance;
        System.out.println("Days for import: " + importDay);
        Path(shortestPath, destination);

        String name = "Porsche 911 Turdo";
        double price = 214326.00;
        CustomizationPage carOne = new CustomizationPage(name, price, importDay, destination, bodyColorlist, rimAndTyersList, seatsList, lightList, linkedList);
        carOne.setVisible(true);
        carOne.pack();
        carOne.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        int distance = 0;
        String shortestPath = "null";

        // Destination location for which shortest path is to be found
        String destination = "Netherland";
        if (graph != null) {
            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }

        int importDay = distance;
        System.out.println("Days for import: " + importDay);
        Path(shortestPath, destination);

        String name = "Porsche 911 Carrera T";
        double price = 111316.00;
        CustomizationPage carOne = new CustomizationPage(name, price, importDay, destination, bodyColorlist, rimAndTyersList, seatsList, lightList, linkedList);
        carOne.setVisible(true);
        carOne.pack();
        carOne.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        int distance = 0;
        String shortestPath = "null";

        // Destination location for which shortest path is to be found
        String destination = "Newzeland";
        if (graph != null) {
            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }

        int importDay = distance;
        System.out.println("Days for import: " + importDay);
        Path(shortestPath, destination);

        String name = "Porsche 911 Turbo Cabriolet";
        double price = 211316.00;
        CustomizationPage carOne = new CustomizationPage(name, price, importDay, destination, bodyColorlist, rimAndTyersList, seatsList, lightList, linkedList);
        carOne.setVisible(true);
        carOne.pack();
        carOne.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        int distance = 0;
        String shortestPath = "null";

        // Destination location for which shortest path is to be found
        String destination = "England";
        if (graph != null) {
            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }

        int importDay = distance;
        System.out.println("Days for import: " + importDay);
        Path(shortestPath, destination);

        String name = "Porsche 911 Dakar";
        double price = 163259.00;
        CustomizationPage carOne = new CustomizationPage(name, price, importDay, destination, bodyColorlist, rimAndTyersList, seatsList, lightList, linkedList);
        carOne.setVisible(true);
        carOne.pack();
        carOne.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        int distance = 0;
        String shortestPath = "null";

        // Destination location for which shortest path is to be found
        String destination = "Japan";
        if (graph != null) {
            // Create an instance of DijkstraAlgorithm
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

            // Find shortest path from branch to the destination city
            distance = dijkstraAlgorithm.findShortestDistanceToLocation(graph, locations, destination);
            shortestPath = dijkstraAlgorithm.findShortestPathToLocation(graph, locations, destination);

        } else {
            System.out.println("Graph is empty");
        }

        int importDay = distance;
        System.out.println("Days for import: " + importDay);
        Path(shortestPath, destination);

        String name = "Porsche 911 Carrera GT4";
        double price = 283151.00;
        CustomizationPage carOne = new CustomizationPage(name, price, importDay, destination, bodyColorlist, rimAndTyersList, seatsList, lightList, linkedList);
        carOne.setVisible(true);
        carOne.pack();
        carOne.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:
        cbxProduct.setSelectedIndex(0);
        tfNewItem.setText("");
        tfNewItemPrice.setText("");
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (cbxProduct.getSelectedIndex() == 0 || tfNewItem.getText().isEmpty() || tfNewItemPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please, cheak again to conform all feilds should not be empty.");
        } else {
            int select = cbxProduct.getSelectedIndex();
            if (select == 0) {
                JOptionPane.showMessageDialog(this, "Sorry, the data could not be inserted into the database. Please try again.");
            } else if (select == 1) {
                String item = tfNewItem.getText(); // Use getText() instead of toString()
                double price = Double.parseDouble(tfNewItemPrice.getText()); // Use getText() instead of toString()
                bodyColorlist.insertAtEnd(item, price);
            } else if (select == 2) {
                String item = tfNewItem.getText(); // Use getText() instead of toString()
                double price = Double.parseDouble(tfNewItemPrice.getText()); // Use getText() instead of toString()
                rimAndTyersList.insertAtEnd(item, price);
            } else if (select == 3) {
                String item = tfNewItem.getText(); // Use getText() instead of toString()
                double price = Double.parseDouble(tfNewItemPrice.getText()); // Use getText() instead of toString()
                seatsList.insertAtEnd(item, price);
            } else if (select == 4) {
                String item = tfNewItem.getText(); // Use getText() instead of toString()
                double price = Double.parseDouble(tfNewItemPrice.getText()); // Use getText() instead of toString()
                lightList.insertAtEnd(item, price);
            }
            JOptionPane.showMessageDialog(this, "Data saved suuccsessfully.");
            cbxProduct.setSelectedIndex(0);
            tfNewItem.setText("");
            tfNewItemPrice.setText("");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAdminOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminOnlyActionPerformed
        // TODO add your handling code here:
        AddNewItemsPanel.setVisible(true);
    }//GEN-LAST:event_btnAdminOnlyActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        AddNewItemsPanel.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnOngoingOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOngoingOrdersActionPerformed
        // TODO add your handling code here:
        OrderPage order = new OrderPage(linkedList,bodyColorlist, rimAndTyersList, seatsList, lightList);
        order.setVisible(true);
        order.pack();
        order.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnOngoingOrdersActionPerformed

    private void btnOngoingOrdersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngoingOrdersMouseEntered
        // TODO add your handling code here:
        btnOngoingOrders.setBackground(Color.white);

        // Change text color
        btnOngoingOrders.setForeground(Color.green);
    }//GEN-LAST:event_btnOngoingOrdersMouseEntered

    private void btnOngoingOrdersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngoingOrdersMouseExited
        // TODO add your handling code here:
        btnOngoingOrders.setBackground(Color.green);

        // Change text color
        btnOngoingOrders.setForeground(Color.white);
    }//GEN-LAST:event_btnOngoingOrdersMouseExited

    private void btnAdminOnlyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminOnlyMouseEntered
        // TODO add your handling code here:
        btnAdminOnly.setBackground(Color.white);

        // Change text color
        btnAdminOnly.setForeground(Color.red);
    }//GEN-LAST:event_btnAdminOnlyMouseEntered

    private void btnAdminOnlyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminOnlyMouseClicked
        // TODO add your handling code here:
        btnAdminOnly.setBackground(Color.white);

        // Change text color
        btnAdminOnly.setForeground(Color.red);
    }//GEN-LAST:event_btnAdminOnlyMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        // TODO add your handling code here:
        btnClose.setBackground(Color.white);

        // Change text color
        btnClose.setForeground(Color.red);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        // TODO add your handling code here:
        btnClose.setBackground(Color.red);

        // Change text color
        btnClose.setForeground(Color.white);
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnClearAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearAllMouseEntered
        // TODO add your handling code here:
        btnClearAll.setBackground(Color.white);

        // Change text color
        btnClearAll.setForeground(new Color(255, 102, 51));
    }//GEN-LAST:event_btnClearAllMouseEntered

    private void btnClearAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearAllMouseExited
        // TODO add your handling code here:
        btnClearAll.setBackground(new Color(255, 102, 51));

        // Change text color
        btnClearAll.setForeground(Color.white);
    }//GEN-LAST:event_btnClearAllMouseExited

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        // TODO add your handling code here:
        btnAdd.setBackground(Color.white);

        // Change text color
        btnAdd.setForeground(Color.green);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        // TODO add your handling code here:
        btnAdd.setBackground(Color.green);

        // Change text color
        btnAdd.setForeground(Color.white);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAdminOnlyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminOnlyMouseExited
        // TODO add your handling code here:
        btnAdminOnly.setBackground(Color.red);

        // Change text color
        btnAdminOnly.setForeground(Color.white);
    }//GEN-LAST:event_btnAdminOnlyMouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseEntered

    private void cbxProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductActionPerformed

    }//GEN-LAST:event_cbxProductActionPerformed

    private void tfNewItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNewItemKeyTyped
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
//            evt.consume();
//            tfNewItem.setBorder(BorderFactory.createLineBorder(Color.red));
//            tfNewItemPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tfNewItem.setBorder(BorderFactory.createLineBorder(Color.red));
//
//        }
    }//GEN-LAST:event_tfNewItemKeyTyped

    private void tfNewItemPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNewItemPriceKeyTyped
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        if (!Character.isDigit(c) && !Character.isWhitespace(c)) {
//            evt.consume();
//            tfNewItemPrice.setBorder(BorderFactory.createLineBorder(Color.red));
//            tfNewItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        } else {
//            tfNewItemPrice.setBorder(BorderFactory.createLineBorder(Color.red));
//
//        }
    }//GEN-LAST:event_tfNewItemPriceKeyTyped

    private void cbxProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxProductKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxProductKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddNewItemsPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdminOnly;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnOngoingOrders;
    private javax.swing.JComboBox<String> cbxProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFive;
    private javax.swing.JLabel labelFour;
    private javax.swing.JLabel labelOne;
    private javax.swing.JLabel labelSix;
    private javax.swing.JLabel labelTwo;
    private javax.swing.JLabel labelTwo1;
    private javax.swing.JTextField tfNewItem;
    private javax.swing.JTextField tfNewItemPrice;
    // End of variables declaration//GEN-END:variables
}

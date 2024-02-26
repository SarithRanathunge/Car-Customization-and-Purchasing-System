/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewPage;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Node;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Sarith
 */
public class CustomizationPage extends javax.swing.JFrame {

    private boolean bodyColor;
    private boolean rimAndTyers;
    private boolean seats;
    private boolean lights;

    int[][] graph;
    String[] locations;
    int importDay;
    String Source;

    DoublyLinkedList bodyColorlist = new DoublyLinkedList();
    DoublyLinkedList rimAndTyersList = new DoublyLinkedList();
    DoublyLinkedList seatsList = new DoublyLinkedList();
    DoublyLinkedList lightList = new DoublyLinkedList();

    /**
     * Creates new form Car
     */
    public CustomizationPage() {
        initComponents();
        setDate();
        times();
        setIcon();
        reSizeTableColumn();

        this.bodyColor = false;
        this.rimAndTyers = false;
        this.seats = false;
        this.lights = false;

//        insertBodyColor();
//        insertRimandTyers();
//        insertSeats();
//        insertLights();
        locations = new String[]{"Porsche Branch", "Gallface", "Townhall", "Kollupitiya", "Bambalapitya", "Dematagoda", "Wellawatte", "Havelock Road", "Maharagama", "Nugegoda", "Piliyandala", "Nawala", "Narahenpita", "Borella", "Galle"};

        tblSelectItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    addToBill();
                }
            }
        });
    }

    public CustomizationPage(String name, double price, DoublyLinkedList bodyColorlist, DoublyLinkedList rimAndTyersList, DoublyLinkedList seatsList, DoublyLinkedList lightList) {
        initComponents();
        setVehical(name, price);
        setDate();
        times();
        setIcon();
        reSizeTableColumn();
        this.importDay = importDay;

        this.bodyColorlist = bodyColorlist;
        this.rimAndTyersList = rimAndTyersList;
        this.seatsList = seatsList;
        this.lightList = lightList;

        this.bodyColor = false;
        this.rimAndTyers = false;
        this.seats = false;
        this.lights = false;

//        insertBodyColor();
//        insertRimandTyers();
//        insertSeats();
//        insertLights();
        locations = new String[]{"Porsche Branch", "Gallface", "Townhall", "Kollupitiya", "Bambalapitya", "Dematagoda", "Wellawatte", "Havelock Road", "Maharagama", "Nugegoda", "Piliyandala", "Nawala", "Narahenpita", "Borella", "Galle"};

        tblSelectItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    addToBill();
                }
            }
        });
    }

    public void bye() {
        TableColumnModel columnModel = tblSelectItem.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(50);

        TableColumnModel columnModel1 = tblBill.getColumnModel();
        columnModel1.getColumn(0).setPreferredWidth(150);
        columnModel1.getColumn(1).setPreferredWidth(100);
    }

    public final void hello(String name, double price) {
        DefaultTableModel tableModel = (DefaultTableModel) tblBill.getModel();
        tableModel.addRow(new Object[]{name, price});
    }

    public final void goodnight() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        lblDate.setText(dd);
    }

    public final void setVehical(String name, double price) {
        DefaultTableModel tableModel = (DefaultTableModel) tblBill.getModel();
        tableModel.addRow(new Object[]{name, price});
    }

    public CustomizationPage(String name, double price) {
        initComponents();
        setVehical(name, price);
        setDate();
        times();
        setIcon();
        reSizeTableColumn();

    }

    public void reSizeTableColumn() {
        TableColumnModel columnModel = tblSelectItem.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(50);

        TableColumnModel columnModel1 = tblBill.getColumnModel();
        columnModel1.getColumn(0).setPreferredWidth(150);
        columnModel1.getColumn(1).setPreferredWidth(100);
    }

    public final void setDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        lblDate.setText(dd);
    }
    Timer t;
    SimpleDateFormat st;

    public final void times() {
        t = new Timer(0, (ActionEvent e) -> {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            Date dt = new Date();
            st = new SimpleDateFormat("HH:MM:ss a");

            String tt = st.format(dt);
            lblTime.setText(tt);
        });

        t.start();
    }

    public void addToBill() {
        int selectedRow = tblSelectItem.getSelectedRow();
        if (selectedRow == -1) {
            // No row is selected, handle this case accordingly
            return;
        }

        String item = tblSelectItem.getValueAt(selectedRow, 0).toString();
        double price = Double.parseDouble(tblSelectItem.getValueAt(selectedRow, 1).toString());

        DefaultTableModel tableModel = (DefaultTableModel) tblBill.getModel();
        tableModel.addRow(new Object[]{item, price});

        // Optionally, you can update the total price after adding the row
        updateTotalPrice();
        updateAdvacePrice();
        updatePrice();
    }

    public void updateTotalPrice() {
        double total = 0.0;
        for (int row = 0; row < tblBill.getRowCount(); row++) {
            double price = Double.parseDouble(tblBill.getValueAt(row, 1).toString());
            total += price;
        }
        lblTotalPrice.setText(String.valueOf(total));
    }

    public void updateAdvacePrice() {
        double total = 0.0;
        double discount = 0.0;
        for (int row = 0; row < tblBill.getRowCount(); row++) {
            double price = Double.parseDouble(tblBill.getValueAt(row, 1).toString());
            discount = price * 0.3;
            total += discount;
        }
        lblAdvance.setText(String.valueOf(total));
    }

    public void updatePrice() {
        double total = 0.0;
        double discount = 0.0;
        double subTotal = 0.0;
        for (int row = 0; row < tblBill.getRowCount(); row++) {
            double price = Double.parseDouble(tblBill.getValueAt(row, 1).toString());
            total += price;
            discount = price * 0.3;
            subTotal = total - discount;
        }
        lblPrice.setText(String.valueOf(subTotal));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tflName = new javax.swing.JTextField();
        tfnic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tffName = new javax.swing.JTextField();
        tftelephone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblAdvance = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnClearAll = new javax.swing.JButton();
        btnOrderNow1 = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnBodyColor = new javax.swing.JButton();
        btnSeats = new javax.swing.JButton();
        btnLights = new javax.swing.JButton();
        btnRimAndTyers = new javax.swing.JButton();
        rbtnMaxPrice = new javax.swing.JRadioButton();
        rbtnMinPrice = new javax.swing.JRadioButton();
        rbtnAtoZ = new javax.swing.JRadioButton();
        rbtnZtoA = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSelectItem = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car");
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));

        jPanel2.setPreferredSize(new java.awt.Dimension(1080, 25));

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTime.setText("Time");
        lblTime.setAlignmentY(0.0F);
        lblTime.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDate.setText("Date");
        lblDate.setAlignmentY(0.0F);
        lblDate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 812, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setMaximumSize(new java.awt.Dimension(250, 679));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 673));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Personal Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("First Name : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Last Name : ");

        tflName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tflName.setMaximumSize(new java.awt.Dimension(236, 30));
        tflName.setMinimumSize(new java.awt.Dimension(236, 30));
        tflName.setPreferredSize(new java.awt.Dimension(232, 30));
        tflName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflNameActionPerformed(evt);
            }
        });

        tfnic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfnic.setMaximumSize(new java.awt.Dimension(236, 30));
        tfnic.setMinimumSize(new java.awt.Dimension(236, 30));
        tfnic.setPreferredSize(new java.awt.Dimension(232, 30));
        tfnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnicActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("NIC No. : ");

        tfemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfemail.setMaximumSize(new java.awt.Dimension(236, 30));
        tfemail.setMinimumSize(new java.awt.Dimension(236, 30));
        tfemail.setPreferredSize(new java.awt.Dimension(232, 30));
        tfemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfemailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Email :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("City : ");

        tfCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCity.setMaximumSize(new java.awt.Dimension(236, 30));
        tfCity.setMinimumSize(new java.awt.Dimension(236, 30));
        tfCity.setPreferredSize(new java.awt.Dimension(232, 30));
        tfCity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tfCityInputMethodTextChanged(evt);
            }
        });
        tfCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCityActionPerformed(evt);
            }
        });
        tfCity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfCityPropertyChange(evt);
            }
        });

        tfAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfAddress.setMaximumSize(new java.awt.Dimension(236, 30));
        tfAddress.setMinimumSize(new java.awt.Dimension(236, 30));
        tfAddress.setPreferredSize(new java.awt.Dimension(232, 30));
        tfAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfAddressMouseClicked(evt);
            }
        });
        tfAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddressActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Address : ");

        tffName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tffName.setMaximumSize(new java.awt.Dimension(236, 30));
        tffName.setMinimumSize(new java.awt.Dimension(236, 30));
        tffName.setPreferredSize(new java.awt.Dimension(232, 30));
        tffName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffNameActionPerformed(evt);
            }
        });

        tftelephone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftelephone.setMaximumSize(new java.awt.Dimension(236, 30));
        tftelephone.setMinimumSize(new java.awt.Dimension(236, 30));
        tftelephone.setPreferredSize(new java.awt.Dimension(232, 30));
        tftelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftelephoneActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Telephone No. : ");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tftelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tflName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setMaximumSize(new java.awt.Dimension(300, 679));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 673));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 402));

        tblBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblBill.setGridColor(new java.awt.Color(204, 204, 204));
        tblBill.setRowHeight(40);
        tblBill.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tblBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblBill.setShowGrid(true);
        tblBill.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblBill);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total Price : Rs.");
        jLabel8.setMaximumSize(new java.awt.Dimension(106, 35));
        jLabel8.setMinimumSize(new java.awt.Dimension(106, 35));
        jLabel8.setPreferredSize(new java.awt.Dimension(106, 35));

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTotalPrice.setText("0.00");

        lblAdvance.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblAdvance.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Advance     : Rs.");
        jLabel11.setMaximumSize(new java.awt.Dimension(106, 35));
        jLabel11.setMinimumSize(new java.awt.Dimension(106, 35));
        jLabel11.setPreferredSize(new java.awt.Dimension(106, 35));

        btnRemove.setBackground(new java.awt.Color(255, 51, 51));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Bill Details");

        btnClearAll.setBackground(new java.awt.Color(255, 51, 51));
        btnClearAll.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClearAll.setForeground(new java.awt.Color(255, 255, 255));
        btnClearAll.setText("Clear All");
        btnClearAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        btnOrderNow1.setBackground(new java.awt.Color(0, 204, 51));
        btnOrderNow1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOrderNow1.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderNow1.setText("Order Now");
        btnOrderNow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrderNow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderNow1ActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPrice.setText("0.00");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Price           : Rs.");
        jLabel12.setMaximumSize(new java.awt.Dimension(106, 35));
        jLabel12.setMinimumSize(new java.awt.Dimension(106, 35));
        jLabel12.setPreferredSize(new java.awt.Dimension(106, 35));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOrderNow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdvance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnOrderNow1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setMaximumSize(new java.awt.Dimension(512, 679));
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(512, 673));

        btnBodyColor.setBackground(new java.awt.Color(51, 51, 51));
        btnBodyColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBodyColor.setForeground(new java.awt.Color(255, 255, 255));
        btnBodyColor.setText("Body Color");
        btnBodyColor.setAlignmentY(0.0F);
        btnBodyColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBodyColor.setMaximumSize(new java.awt.Dimension(120, 40));
        btnBodyColor.setMinimumSize(new java.awt.Dimension(120, 40));
        btnBodyColor.setPreferredSize(new java.awt.Dimension(120, 40));
        btnBodyColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBodyColorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyColorMouseExited(evt);
            }
        });
        btnBodyColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBodyColorActionPerformed(evt);
            }
        });

        btnSeats.setBackground(new java.awt.Color(51, 51, 51));
        btnSeats.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSeats.setForeground(new java.awt.Color(255, 255, 255));
        btnSeats.setText("Seats");
        btnSeats.setAlignmentY(0.0F);
        btnSeats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeats.setMaximumSize(new java.awt.Dimension(120, 40));
        btnSeats.setMinimumSize(new java.awt.Dimension(120, 40));
        btnSeats.setPreferredSize(new java.awt.Dimension(120, 40));
        btnSeats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSeatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSeatsMouseExited(evt);
            }
        });
        btnSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeatsActionPerformed(evt);
            }
        });

        btnLights.setBackground(new java.awt.Color(51, 51, 51));
        btnLights.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLights.setForeground(new java.awt.Color(255, 255, 255));
        btnLights.setText("Lights");
        btnLights.setAlignmentY(0.0F);
        btnLights.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLights.setMaximumSize(new java.awt.Dimension(120, 40));
        btnLights.setMinimumSize(new java.awt.Dimension(120, 40));
        btnLights.setPreferredSize(new java.awt.Dimension(120, 40));
        btnLights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLightsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLightsMouseExited(evt);
            }
        });
        btnLights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLightsActionPerformed(evt);
            }
        });

        btnRimAndTyers.setBackground(new java.awt.Color(51, 51, 51));
        btnRimAndTyers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRimAndTyers.setForeground(new java.awt.Color(255, 255, 255));
        btnRimAndTyers.setText("Rim & Tyers");
        btnRimAndTyers.setAlignmentY(0.0F);
        btnRimAndTyers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRimAndTyers.setMaximumSize(new java.awt.Dimension(120, 40));
        btnRimAndTyers.setMinimumSize(new java.awt.Dimension(120, 40));
        btnRimAndTyers.setPreferredSize(new java.awt.Dimension(120, 40));
        btnRimAndTyers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRimAndTyersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRimAndTyersMouseExited(evt);
            }
        });
        btnRimAndTyers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRimAndTyersActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnMaxPrice);
        rbtnMaxPrice.setText("Maximum Price");
        rbtnMaxPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnMaxPriceMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtnMinPrice);
        rbtnMinPrice.setText("Minimum Price");
        rbtnMinPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnMinPriceMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtnAtoZ);
        rbtnAtoZ.setText("A to Z ");
        rbtnAtoZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnAtoZMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtnZtoA);
        rbtnZtoA.setText("Z to A");
        rbtnZtoA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnZtoAMouseClicked(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblSelectItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSelectItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelectItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSelectItem.setGridColor(new java.awt.Color(204, 204, 204));
        tblSelectItem.setRowHeight(40);
        tblSelectItem.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tblSelectItem.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblSelectItem.setShowGrid(true);
        tblSelectItem.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblSelectItem);

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Body Color");
        jButton6.setAlignmentY(0.0F);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton6.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton6.setPreferredSize(new java.awt.Dimension(120, 40));

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Rim & Tyers");
        jButton7.setAlignmentY(0.0F);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton7.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton7.setPreferredSize(new java.awt.Dimension(120, 40));

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Seats");
        jButton8.setAlignmentY(0.0F);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton8.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton8.setPreferredSize(new java.awt.Dimension(120, 40));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Lights");
        jButton9.setAlignmentY(0.0F);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setMaximumSize(new java.awt.Dimension(120, 40));
        jButton9.setMinimumSize(new java.awt.Dimension(120, 40));
        jButton9.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBodyColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnMaxPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnMinPrice)
                            .addComponent(btnRimAndTyers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnAtoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnZtoA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBodyColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRimAndTyers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMaxPrice)
                    .addComponent(rbtnMinPrice)
                    .addComponent(rbtnAtoZ)
                    .addComponent(rbtnZtoA))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Car");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tflNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tflNameActionPerformed

    private void tfnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnicActionPerformed

    private void tfemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfemailActionPerformed

    private void tfCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCityActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCityActionPerformed

    private void tfAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddressActionPerformed

    private void tffNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tffNameActionPerformed

    private void rbtnMaxPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMaxPriceMouseClicked
//        System.out.println("Max");
        if (bodyColor == true) {
            bodyColorlist.mergeSortMaxToMin();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortMaxToMin();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortMaxToMin();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortMaxToMin();
            addLightsToTable();
        }

    }//GEN-LAST:event_rbtnMaxPriceMouseClicked

    private void rbtnMinPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMinPriceMouseClicked
//        System.out.println("Min");
        if (bodyColor == true) {
            bodyColorlist.mergeSortMinToMax();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortMinToMax();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortMinToMax();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortMinToMax();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnMinPriceMouseClicked

    private void rbtnAtoZMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnAtoZMouseClicked
//        System.out.println("A to Z");
        if (bodyColor == true) {
            bodyColorlist.mergeSortAToZ();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortAToZ();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortAToZ();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortAToZ();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnAtoZMouseClicked

    private void rbtnZtoAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnZtoAMouseClicked
//        System.out.println("Z to A");
        if (bodyColor == true) {
            bodyColorlist.mergeSortZToA();
            addBodycolorToTable();
        } else if (rimAndTyers == true) {
            rimAndTyersList.mergeSortZToA();
            addRimAndTyerToTable();
        } else if (seats == true) {
            seatsList.mergeSortZToA();
            addSeatsToTable();
        } else if (lights == true) {
            lightList.mergeSortZToA();
            addLightsToTable();
        }
    }//GEN-LAST:event_rbtnZtoAMouseClicked

    public void addBodycolorToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = bodyColorlist.head;
        Node tail = bodyColorlist.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    private void btnBodyColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBodyColorActionPerformed
        addBodycolorToTable();
        bodyColor = true;
        rimAndTyers = false;
        seats = false;
        lights = false;
    }//GEN-LAST:event_btnBodyColorActionPerformed

    private void tftelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftelephoneActionPerformed
    public void addRimAndTyerToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = rimAndTyersList.head;
        Node tail = rimAndTyersList.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    public void addSeatsToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = seatsList.head;
        Node tail = seatsList.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }

    public void addLightsToTable() {

        DefaultTableModel tableModel = (DefaultTableModel) tblSelectItem.getModel();
        tableModel.setRowCount(0);
        Node currentNode = lightList.head;
        Node tail = lightList.tail;

        while (currentNode != tail) {
            tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
            currentNode = currentNode.next;
        }
        tableModel.addRow(new Object[]{currentNode.item, currentNode.price});
    }
    private void btnRimAndTyersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRimAndTyersActionPerformed
        // TODO add your handling code here:
        addRimAndTyerToTable();
        bodyColor = false;
        rimAndTyers = true;
        seats = false;
        lights = false;
    }//GEN-LAST:event_btnRimAndTyersActionPerformed

    private void btnSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeatsActionPerformed
        // TODO add your handling code here:
        addSeatsToTable();
        bodyColor = false;
        rimAndTyers = false;
        seats = true;
        lights = false;
    }//GEN-LAST:event_btnSeatsActionPerformed

    private void btnLightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLightsActionPerformed
        // TODO add your handling code here:
        addLightsToTable();
        bodyColor = false;
        rimAndTyers = false;
        seats = false;
        lights = true;
    }//GEN-LAST:event_btnLightsActionPerformed

    public final void setIcon() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Sarith\\Pictures\\Icons\\left-arrow.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lblBack.getWidth(), lblBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lblBack.setIcon(scaledIcon);
    }
    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        MainPage page = new MainPage();
        page.setVisible(true);
        page.pack();
        page.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnClearAllActionPerformed


    private void btnOrderNow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderNow1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnOrderNow1ActionPerformed

    private void tfCityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfCityPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCityPropertyChange

    private void tfCityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfCityInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCityInputMethodTextChanged

    private void tfAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfAddressMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tfAddressMouseClicked

    private void btnBodyColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyColorMouseEntered
        // TODO add your handling code here:
         btnBodyColor.setBackground(Color.white);

        // Change text color
        btnBodyColor.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnBodyColorMouseEntered

    private void btnBodyColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyColorMouseExited
        // TODO add your handling code here:
        btnBodyColor.setBackground(Color.darkGray);

        // Change text color
        btnBodyColor.setForeground(Color.white);
    }//GEN-LAST:event_btnBodyColorMouseExited

    private void btnRimAndTyersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRimAndTyersMouseEntered
        // TODO add your handling code here:
        btnRimAndTyers.setBackground(Color.white);

        // Change text color
        btnRimAndTyers.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnRimAndTyersMouseEntered

    private void btnRimAndTyersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRimAndTyersMouseExited
        // TODO add your handling code here:
        btnRimAndTyers.setBackground(Color.darkGray);

        // Change text color
        btnRimAndTyers.setForeground(Color.white);
    }//GEN-LAST:event_btnRimAndTyersMouseExited

    private void btnSeatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeatsMouseEntered
        // TODO add your handling code here:
         btnSeats.setBackground(Color.white);

        // Change text color
        btnSeats.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnSeatsMouseEntered

    private void btnSeatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeatsMouseExited
        // TODO add your handling code here:
        btnSeats.setBackground(Color.darkGray);

        // Change text color
        btnSeats.setForeground(Color.white);
    }//GEN-LAST:event_btnSeatsMouseExited

    private void btnLightsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLightsMouseEntered
        // TODO add your handling code here:
        btnLights.setBackground(Color.white);

        // Change text color
        btnLights.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnLightsMouseEntered

    private void btnLightsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLightsMouseExited
        // TODO add your handling code here:
        btnLights.setBackground(Color.darkGray);

        // Change text color
        btnLights.setForeground(Color.white);
    }//GEN-LAST:event_btnLightsMouseExited

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
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomizationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomizationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBodyColor;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnLights;
    private javax.swing.JButton btnOrderNow1;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRimAndTyers;
    private javax.swing.JButton btnSeats;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAdvance;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JRadioButton rbtnAtoZ;
    private javax.swing.JRadioButton rbtnMaxPrice;
    private javax.swing.JRadioButton rbtnMinPrice;
    private javax.swing.JRadioButton rbtnZtoA;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblSelectItem;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tffName;
    private javax.swing.JTextField tflName;
    private javax.swing.JTextField tfnic;
    private javax.swing.JTextField tftelephone;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables

}
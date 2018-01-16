/*
Copyright (C) 2018  Tomaž Čuk

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.venoox.miningspoolcloud;

import org.json.JSONException;
import org.json.JSONObject;
import org.venoox.JSONReader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindow extends JFrame {

    private JComboBox comboBox1;
    private JTextField textField1;
    private JLabel balanceValue;
    private JButton checkButton;
    private JLabel choosePoolLabel;
    private JLabel addressLabel;
    private JLabel balanceLabel;
    private JLabel pendingLabel;
    private JLabel paidLabel;
    private JLabel hashrateLabel;
    private JLabel paidValue;
    private JLabel hashrateValue;
    private JLabel pendingValue;
    private JPanel panel1;

    public void setZeroValue() {
        balanceValue.setText("");
        paidValue.setText("");
        pendingValue.setText("");
        hashrateValue.setText("");
    }

    public MainWindow() {
        checkButton.addActionListener(e -> {
                setZeroValue();
                String address = textField1.getText();
                if (address.isEmpty()) {
                    textField1.setText("Enter the address!");
                }
                else {
                    int index = comboBox1.getSelectedIndex();
                    if (index==0) {
                        try {
                            JSONObject json = JSONReader.readJsonFromUrl("http://komodominingpool.com/api/worker_stats?"+address);
                            double balance = json.getDouble("balance");
                            double paid = json.getDouble("paid");
                            Iterator<?> keys = json.getJSONObject("workers").keys();
                            String worker = (String) keys.next();
                            String hashrate = json.getJSONObject("workers").getJSONObject(worker).getString("hashrateString");
                            balanceValue.setText(String.valueOf(balance));
                            paidValue.setText(String.valueOf(paid));
                            pendingValue.setText("");
                            hashrateValue.setText(hashrate);
                        } catch (IOException | JSONException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (index==1) {
                        try {
                            JSONObject json = JSONReader.readJsonFromUrl("http://hushpool.cloud/api/worker_stats?"+address);
                            double balance = json.getDouble("balance");
                            double paid = json.getDouble("paid");
                            double pending = json.getDouble("immature");
                            Iterator<?> keys = json.getJSONObject("workers").keys();
                            String worker = (String) keys.next();
                            String hashrate = json.getJSONObject("workers").getJSONObject(worker).getString("hashrateString");
                            balanceValue.setText(String.valueOf(balance));
                            paidValue.setText(String.valueOf(paid));
                            pendingValue.setText(String.valueOf(pending));
                            hashrateValue.setText(hashrate);
                        } catch (IOException | JSONException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (index==2) {
                        try {
                            JSONObject json = JSONReader.readJsonFromUrl("http://chipspool.cloud/api/worker_stats?"+address);
                            double balance = json.getDouble("balance");
                            double paid = json.getDouble("paid");
                            Iterator<?> keys = json.getJSONObject("workers").keys();
                            String worker = (String) keys.next();
                            String hashrate = json.getJSONObject("workers").getJSONObject(worker).getString("hashrateString");
                            balanceValue.setText(String.valueOf(balance));
                            paidValue.setText(String.valueOf(paid));
                            pendingValue.setText("");
                            hashrateValue.setText(hashrate);
                        } catch (IOException | JSONException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (index==3) {
                        try {
                            JSONObject json = JSONReader.readJsonFromUrl("http://zeropool.cloud/api/worker_stats?"+address);
                            double balance = json.getDouble("balance");
                            double paid = json.getDouble("paid");
                            double pending = json.getDouble("immature");
                            Iterator<?> keys = json.getJSONObject("workers").keys();
                            String worker = (String) keys.next();
                            String hashrate = json.getJSONObject("workers").getJSONObject(worker).getString("hashrateString");
                            balanceValue.setText(String.valueOf(balance));
                            paidValue.setText(String.valueOf(paid));
                            pendingValue.setText(String.valueOf(pending));
                            hashrateValue.setText(hashrate);
                        } catch (IOException | JSONException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (index==4) {
                        try {
                            JSONObject json = JSONReader.readJsonFromUrl("http://groestlcoin.miningpools.cloud/api/worker_stats?"+address);
                            double balance = json.getDouble("balance");
                            double paid = json.getDouble("paid");
                            Iterator<?> keys = json.getJSONObject("workers").keys();
                            String worker = (String) keys.next();
                            String hashrate = json.getJSONObject("workers").getJSONObject(worker).getString("hashrateString");
                            balanceValue.setText(String.valueOf(balance));
                            paidValue.setText(String.valueOf(paid));
                            pendingValue.setText("");
                            hashrateValue.setText(hashrate);
                        } catch (IOException | JSONException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (index==5) {
                        try {
                            JSONObject json = JSONReader.readJsonFromUrl("http://minexcoinpool.com/api/worker_stats?"+address);
                            double balance = json.getDouble("balance");
                            double paid = json.getDouble("paid");
                            double pending = json.getDouble("immature");
                            Iterator<?> keys = json.getJSONObject("workers").keys();
                            String worker = (String) keys.next();
                            String hashrate = json.getJSONObject("workers").getJSONObject(worker).getString("hashrateString");
                            balanceValue.setText(String.valueOf(balance));
                            paidValue.setText(String.valueOf(paid));
                            pendingValue.setText(String.valueOf(pending));
                            hashrateValue.setText(hashrate);
                        } catch (IOException | JSONException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        });
    }

    public static void setWindowLook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setWindowLook();
        JFrame frame = new JFrame("miningspool.cloud");
        Dimension size = new Dimension(600,400);
        frame.setContentPane(new MainWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(size);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/org/venoox/res/komodo.png")));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

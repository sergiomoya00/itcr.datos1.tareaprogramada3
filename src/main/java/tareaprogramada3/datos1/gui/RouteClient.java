/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.gui;

import tareaprogramada3.datos1.GoogleMapsServices.Geocoding;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import tareaprogramada3.datos1.GoogleMapsServices.GoogleAPI;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tareaprogramada3.datos1.administration.Place;
import tareaprogramada3.datos1.administration.Route;
import tareaprogramada3.datos1.structures.Graph.VertexNode;
import tareaprogramada3.datos1.administration.AdministratorSession;

/**
 *
 * @author samoy
 */
public class RouteClient extends javax.swing.JFrame {

    /**
     * Creates new form RouteClient
     */
    private Route route;

    private VertexNode vertex;

    public Route getPlace() {
        return route;
    }

    public VertexNode getVertex() {
        return vertex;
    }

    public RouteClient() {
        initComponents();

        DefaultTableModel model1 = ((DefaultTableModel) tablePlaces.getModel());
        model1.setRowCount(0);//Ingresa los títulos y valores al JTable.
        for (Place place : AdministratorSession.getInstance().getPlaces()) {
            model1.addRow(new Object[]{
                place.getName()
//AdministratorSession.getInstance().getPlaceInfo(q)
            });
        }
    }

    public void getTime() throws ApiException, InterruptedException, IOException {
        if (!this.oriTXT.getText().isEmpty() && !this.desTXT.getText().isEmpty()) {
            hoursRtxt.setText("");
            DisRtxt.setText("");
            String orig = oriTXT.getText();
            String dest = desTXT.getText();
            Geocoding temp = new Geocoding();

            hoursRtxt.setText(String.valueOf(temp.Time(orig, dest) + "seg"));
            DisRtxt.setText(String.valueOf(temp.getDriveDist(orig, dest) + "mts"));
            String dis = temp.getDriveDist(orig, dest) + "mts";
            String time = temp.Time(orig, dest) + "seg";
            this.route = new Route();
            this.route.setDistance(dis);
            this.route.setTime(time);
            this.route.setOrigin1(orig);
            this.route.setDestiny1(dest);
            AdministratorSession.getInstance().addRoute(route);
            DefaultTableModel model = ((DefaultTableModel) infoTable.getModel());
            model.setRowCount(0);
            for (Route route : AdministratorSession.getInstance().getRoutes()) {
                model.addRow(new Object[]{
                    route.getOrigin1(), route.getDestiny1(), route.getTime(), route.getDistance()
                });

            }
        }

    }

    public void getMap() throws ApiException, InterruptedException, IOException, URISyntaxException {
        if (!this.oriTXT.getText().isEmpty() && !this.desTXT.getText().isEmpty()) {

            String orig = this.route.getOrigin1();
            String dest = this.route.getDestiny1();

            Geocoding temp = new Geocoding();
            
            

            temp.rutaMapa(orig, dest);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePlaces = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton_Peticiones1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        oriTXT = new javax.swing.JTextField();
        desTXT = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        hoursRtxt = new javax.swing.JTextField();
        DisRtxt = new javax.swing.JTextField();
        JLabel_Ruta_Status = new javax.swing.JLabel();
        maplol = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Lugares registrados");

        tablePlaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Lugar", "Tipo de lugar", "Teléfono", "Rating", "Horario", "Website"
            }
        ));
        jScrollPane1.setViewportView(tablePlaces);

        jButton_Peticiones1.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Peticiones1.setText("Calcular");
        jButton_Peticiones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Peticiones1ActionPerformed(evt);
            }
        });

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Lugar de Origen", "Lugar de Destino", "Duración tramo", "Distancia tramo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(infoTable);

        jLabel19.setText("Dirección origen");

        jLabel20.setText("Dirección destino");

        jLabel25.setText("Tiempo total (horas)");

        jLabel26.setText("Distancia total (km)");

        hoursRtxt.setEditable(false);

        DisRtxt.setEditable(false);

        JLabel_Ruta_Status.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        maplol.setText("Mapa");
        maplol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maplolActionPerformed(evt);
            }
        });

        register.setText("Registrar cliente");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        jButton1.setText("Detalle");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(oriTXT)
                    .addComponent(desTXT)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(JLabel_Ruta_Status)
                            .addComponent(jButton_Peticiones1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hoursRtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DisRtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(maplol)
                                .addGap(18, 18, 18)
                                .addComponent(register)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oriTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Peticiones1)
                .addGap(31, 31, 31)
                .addComponent(JLabel_Ruta_Status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoursRtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisRtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maplol)
                    .addComponent(register)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Peticiones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Peticiones1ActionPerformed
        try {
            this.getTime();

        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton_Peticiones1ActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        ClientRegister client = new ClientRegister();
        client.setVisible(true);
    }//GEN-LAST:event_registerActionPerformed

    private void maplolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maplolActionPerformed
        try {
            this.getMap();

        } catch (Exception ex) {
        }   // TODO add your handling code here:
    }//GEN-LAST:event_maplolActionPerformed

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
            java.util.logging.Logger.getLogger(RouteClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RouteClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RouteClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RouteClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RouteClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DisRtxt;
    private javax.swing.JLabel JLabel_Ruta_Status;
    private javax.swing.JTextField desTXT;
    private javax.swing.JTextField hoursRtxt;
    private javax.swing.JTable infoTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Peticiones1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton maplol;
    private javax.swing.JTextField oriTXT;
    private javax.swing.JButton register;
    private javax.swing.JTable tablePlaces;
    // End of variables declaration//GEN-END:variables
}
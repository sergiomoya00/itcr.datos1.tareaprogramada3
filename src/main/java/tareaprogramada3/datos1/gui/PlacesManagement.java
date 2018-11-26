/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.gui;

import tareaprogramada3.datos1.GoogleMapsServices.GoogleAPI;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.swing.table.DefaultTableModel;
import tareaprogramada3.datos1.GoogleMapsServices.GoogleAPI;
import tareaprogramada3.datos1.administration.AdministratorSession;
import API.Geocoding;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.Photo;
import com.google.maps.model.PlaceDetails;
import java.awt.Image;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import tareaprogramada3.datos1.structures.Graph.VertexNode;

/**
 *
 * @author samoy
 */
public class PlacesManagement extends javax.swing.JFrame {

    /**
     * Creates new form PlacesManagement
     */
    private String area;

    public int start1;

    public int destiny;

    private int counter = 0;

    private VertexNode vertex;

    public VertexNode getVertex() {
        return vertex;
    }

    public PlacesManagement() {
        initComponents();
    }

    private void refresh() {
        String lugar = txtdirectionxd.getText();
        Geocoding direccion = new Geocoding();
        String q = direccion.getid(lugar);
        DefaultTableModel model1 = ((DefaultTableModel) searchedPlaces.getModel());
        model1.setRowCount(0);//Ingresa los títulos y valores al JTable.

        //for (Patient patient : HospitalManager.getInstance().getUrgencyGreen()) {
        model1.addRow(new Object[]{ //AdministratorSession.getInstance().getPlaceInfo(q)
        });
    }

    private void addRoute() {

        String v = getVertex().getVertexNodeId();
        int vfinal = Integer.parseInt(v);

        destiny = (int) searchedPlaces.getValueAt(searchedPlaces.getSelectedColumn(), searchedPlaces.getSelectedRow());
        start1 = vfinal;

        AdministratorSession.getInstance().addEdge("lol", start1, destiny, destiny);

    }

    public void getimage() {
        area = txtdirectionxd.getText();

        Geocoding direccion = new Geocoding();
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAx6wyHg-u40Cll05DxD8d1v0jnnCyuIdM")
                .build();
        PlaceDetails results = null;
        try {
            results = PlacesApi.placeDetails(context, direccion.getid(area)).await();
        } catch (ApiException ex) {
            Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String urlstring = "https://maps.googleapis.com/maps/api/place/photo?";
        urlstring = urlstring + "&maxheight=" + String.valueOf(results.photos[0].height);
        urlstring = urlstring + "&maxwidth=" + String.valueOf(results.photos[0].width);
        urlstring = urlstring + "&photoreference=" + results.photos[0].photoReference;
        urlstring = urlstring + "&key=" + "AIzaSyAx6wyHg-u40Cll05DxD8d1v0jnnCyuIdM";
        URL url = null;
        try {
            url = new URL(urlstring);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
        }
        image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        imag.setIcon(imageicon);
    }

    private void DirectionSearch() throws UnsupportedEncodingException, MalformedURLException, ApiException, InterruptedException, IOException {
        if (!this.txtdirectionxd.getText().isEmpty()) {
            txtdireccionencontrada.setText("");
            String lugar = txtdirectionxd.getText();

            Geocoding direccion = new Geocoding();

            txtdireccionencontrada.setText(String.valueOf(direccion.getdirection(lugar)));
            txtlatitud.setText(String.valueOf(direccion.getlat(lugar)));
            txtlongitud.setText(String.valueOf(direccion.getlon(lugar)));

            txtinfo.setText(String.valueOf(direccion.getid(lugar)));
            String i = direccion.getid(lugar);
            rat.setText(direccion.Rating(i));
            String u = direccion.getid(lugar);
            tel.setText(direccion.PhoneNumber(u));
            String q = direccion.getid(lugar);
            web.setText(direccion.WebSite(q));
            //AdministratorSession.getInstance().newVertexForPlaces(q, lugar);
        }
    }

    private void codi() throws IOException, URISyntaxException, ApiException, InterruptedException {
        Geocoding map = new Geocoding();
        String i = map.getid(txtdirectionxd.getText());

        String e = map.URL(i);
        map.goToURL(e);

    }

    private void detalles() throws UnsupportedEncodingException, MalformedURLException, ApiException, InterruptedException, IOException {
        Geocoding direccion = new Geocoding();
        String detail = txtinfo.getText();

    }

    //Lugar a partir de latitud y longitud
    private void CoordinatesSearch() throws ApiException, InterruptedException, IOException {
        if (!this.txtlatitud.getText().isEmpty() && !this.txtlongitud.getText().isEmpty()) {
            txtdireccion.setText("");
            String lugar = txtlatitud.getText() + "," + txtlongitud.getText();
            Geocoding direccion = new Geocoding();
            direccion.getdirection(lugar);
            txtdireccion.setText(String.valueOf(direccion.getdirection(lugar)));
            txtid.setText(String.valueOf(direccion.getid(lugar)));
            String i = direccion.getid(lugar);
            rat.setText(direccion.Rating(i));
            String u = direccion.getid(lugar);
            tel.setText(direccion.PhoneNumber(u));
            String q = direccion.getid(lugar);
            web.setText(direccion.WebSite(q));
//            AdministratorSession.getInstance().newVertexForPlaces(q, q);
        }
    }

    private void codi2() throws IOException, URISyntaxException, ApiException, InterruptedException {
        String lugar = txtlatitud.getText() + "," + txtlongitud.getText();
        Geocoding map = new Geocoding();

        String i = map.getid(lugar);

        String e = map.URL(i);
        map.goToURL(e);
    }

    private void showURl(String direccion) throws IOException, URISyntaxException {
        Geocoding url = new Geocoding();

    }

    private void showMap(Double latitud, Double longitud) throws URISyntaxException, IOException {

    }

    /**
     * if (!this.txtlatitud.getText().isEmpty() &&
     * !this.txtlongitud.getText().isEmpty()) { txtdireccion.setText(""); String
     * lugar = txtlatitud.getText() + "," + txtlongitud.getText(); Geocoding
     * direccion = new Geocoding(); direccion.getdirection(lugar);
     * txtdireccion.setText(String.valueOf(direccion.getdirection(lugar))); }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdirectionxd = new javax.swing.JTextField();
        Buscardireccion = new javax.swing.JButton();
        txtlatitud = new javax.swing.JTextField();
        txtlongitud = new javax.swing.JTextField();
        txtdireccionencontrada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtlatitud1 = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtlongitud1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchedPlaces = new javax.swing.JTable();
        deleteLugar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtinfo = new javax.swing.JTextField();
        rat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        web = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        url = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rat1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tel1 = new javax.swing.JTextField();
        web1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        showmap = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        imagePlace = new javax.swing.JButton();
        imag = new javax.swing.JLabel();
        addp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Búsqueda por dirección");

        jLabel2.setText("Búsqueda por coordenadas");

        Buscardireccion.setText("Buscar");
        Buscardireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscardireccionActionPerformed(evt);
            }
        });

        txtlatitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlatitudActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese dirección o lugar a buscar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Latitud");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Longitud");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Dirección del lugar");

        jLabel7.setText("Ingrese latitud");

        jLabel8.setText("Ingrese longitud");

        jLabel9.setText("Dirección: ");

        txtlongitud1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlongitud1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Lugares");

        searchedPlaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Lugar"
            }
        ));
        jScrollPane1.setViewportView(searchedPlaces);

        deleteLugar.setText("Eliminar");
        deleteLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLugarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Seleccionar");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Info");

        jLabel13.setText("Rating");

        jLabel14.setText("Telefono");

        jLabel15.setText("Website");

        url.setText("Mostrar mapa");
        url.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlActionPerformed(evt);
            }
        });

        jButton3.setText("Detalles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rat1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Rating");

        jLabel17.setText("Telefono");

        jLabel18.setText("Website");

        showmap.setText("Mostrar mapa");
        showmap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showmapActionPerformed(evt);
            }
        });

        jLabel19.setText("Código del lugar:");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        imagePlace.setText("Ver imagen");

        addp.setText("Añadir");
        addp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(193, 193, 193))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteLugar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdirectionxd)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Buscardireccion)
                                    .addGap(18, 18, 18)
                                    .addComponent(url)
                                    .addGap(18, 18, 18)
                                    .addComponent(imagePlace))
                                .addComponent(jLabel6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtlatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtlongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtdireccionencontrada, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(txtinfo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(rat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtlatitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addComponent(txtlongitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel9)
                                .addGap(37, 37, 37)
                                .addComponent(txtdireccion)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(rat1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(web1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showmap))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(388, 388, 388)
                                .addComponent(imag)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Buscardireccion)
                                            .addComponent(url)
                                            .addComponent(imagePlace))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtlatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(txtdirectionxd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtlongitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlatitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdireccionencontrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(16, 16, 16)
                                .addComponent(rat1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel17)
                                        .addGap(6, 6, 6)
                                        .addComponent(tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jButton2)))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18)
                                .addGap(13, 13, 13)
                                .addComponent(web1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(showmap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteLugar)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(45, 45, 45)
                                .addComponent(imag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addp)
                                .addGap(44, 44, 44)
                                .addComponent(jButton1)
                                .addGap(67, 67, 67))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(rat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addGap(16, 16, 16)
                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscardireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscardireccionActionPerformed
        try {
            this.DirectionSearch();

        } catch (Exception ex) {
        }
        refresh();
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscardireccionActionPerformed

    private void txtlatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlatitudActionPerformed

    private void txtlongitud1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlongitud1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlongitud1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.CoordinatesSearch();

        } catch (Exception ex) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteLugarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Route route = new Route();
        route.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void urlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlActionPerformed
        try {
            codi();

        } catch (Exception ex) {
        }               // TODO add your handling code here:
    }//GEN-LAST:event_urlActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            this.detalles();

        } catch (Exception ex) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rat1ActionPerformed

    private void showmapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showmapActionPerformed
        try {
            codi2();

        } catch (Exception ex) {
        }                      // TODO add your handling code here:
    }//GEN-LAST:event_showmapActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void addpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpActionPerformed
        if (counter > 1) {
            addRoute();
            AdministratorSession.getInstance().newVertexForPlaces(searchedPlaces.getValueAt(searchedPlaces.getSelectedColumn(), searchedPlaces.getSelectedRow()), node);
        } else {
            AdministratorSession.getInstance().newVertexForPlaces(searchedPlaces.getValueAt(searchedPlaces.getSelectedColumn(), searchedPlaces.getSelectedRow()), node);
            counter++;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_addpActionPerformed

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
            java.util.logging.Logger.getLogger(PlacesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlacesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlacesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlacesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlacesManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscardireccion;
    private javax.swing.JButton addp;
    private javax.swing.JButton deleteLugar;
    private javax.swing.JLabel imag;
    private javax.swing.JButton imagePlace;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rat;
    private javax.swing.JTextField rat1;
    private javax.swing.JTable searchedPlaces;
    private javax.swing.JButton showmap;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField tel1;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdireccionencontrada;
    private javax.swing.JTextField txtdirectionxd;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtinfo;
    private javax.swing.JTextField txtlatitud;
    private javax.swing.JTextField txtlatitud1;
    private javax.swing.JTextField txtlongitud;
    private javax.swing.JTextField txtlongitud1;
    private javax.swing.JButton url;
    private javax.swing.JTextField web;
    private javax.swing.JTextField web1;
    // End of variables declaration//GEN-END:variables
}

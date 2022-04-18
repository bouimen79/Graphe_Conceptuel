/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe_conceptuel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Graphe extends javax.swing.JFrame {

    ArrayList<String> concept = new ArrayList<String>();
    ArrayList<String> relation = new ArrayList<String>();
    ArrayList<String> singature = new ArrayList<String>();
    ArrayList<String> individu = new ArrayList<String>();
    ArrayList<String> t_marqu = new ArrayList<String>();
    ArrayList<ArrayList<String>> vocabu = new ArrayList<ArrayList<String>>();

    public Graphe() {
        initComponents();
    }

    public ArrayList<ArrayList<String>> read_file(String src) {
        try {
            File myObj = new File(src + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //jTextArea1.append(data);
                if (data.startsWith("c")) {
                    String m[] = data.split("/");
                    concept.add(m[1]);
                }
                if (data.startsWith("r")) {
                    String m[] = data.split("/");
                    relation.add(m[1]);
                   // System.out.println("realti---" + m[1]);
                }
                if (data.startsWith("s")) {
                    String m[] = data.split("/");
                    singature.add(m[1]);
                    //System.out.println("sing----" + m[1]);
                }
                if (data.startsWith("I")) {
                    String m[] = data.split("/");
                   // System.out.println("m of individu***********" + m[1]);
                    String i[] = m[1].split(",");
                    for (int j = 0; j < m.length + 1; j++) {
                        //System.out.println("size of m is" + m.length);
                        individu.add(i[j]);
                        System.out.println("indivi-----" + i[j]);
                    }
                }
                if (data.startsWith("t")){
                    String m[]=data.split("/");
                    System.out.println("type de marquereur ----------------"+m[1]);
                    t_marqu.add(m[1]);
                }
                vocabu.add(concept);
                vocabu.add(relation);
                vocabu.add(singature);
                vocabu.add(individu);
                vocabu.add(t_marqu);
            }
            System.out.println("les concept sont: " + concept);
            System.out.println("\n les relation sont:  " + relation);
            System.out.println("\nles singature sont:" + singature);
            System.out.println("\nles individus sont: " + individu);
                        System.out.println("\nles marqueur sont: " + t_marqu);

            System.out.println("vocabulaire" + vocabu);
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred." + e);

        }
        return vocabu;
    }

    public boolean is_relation(String r) {
        if (relation.contains(r)) {
            return true;
        }
        return false;
    }

    public boolean is_individu(String m) {
        if (individu.contains(m)) {
            return true;
        }
        return false;
    }

    public boolean is_singature(String s) {
        if (singature.contains(s)) {
            return true;
        }
        return false;
    }

    public boolean is_concept(String c) {
        String c1[] = null;
        ArrayList<String> cc = new ArrayList<String>();
        for (int i = 0; i < concept.size(); i++) {
          //  System.out.println("-----sscc-----" + concept.get(i));
            c1 = concept.get(i).split(" :");
           // System.out.println("tous les concept *-------------------" + c1[0]);
           // System.out.println("tous les concept---------------------" + c1[1]);
            cc.add(c1[0]);
            cc.add(c1[1]);
        }
        if (cc.contains(c)) {
            return true;
        }
        return false;

    }
public String type_concept(String t_c){
      String c1[] = null;
    String t= null; 
         for (int i = 0; i < concept.size(); i++) {
          //  System.out.println("-----sscc-----" + concept.get(i));
            c1 = concept.get(i).split(" :");
           // System.out.println("tous les concept *-------------------" + c1[0]);
           // System.out.println("tous les concept---------------------" + c1[1]);
           if(c1[0].equals(t_c)){
               t= c1[1];
           }        
        }
            return t;
}
public String type_marqu(String t_m){
       String c1[] = null;
    String t= null; 
         for (int i = 0; i < t_marqu.size(); i++) {
          //  System.out.println("-----sscc-----" + concept.get(i));
            c1 = t_marqu.get(i).split("=");
           //System.out.println("tous les marque *-------------------" + c1[0]);
           // System.out.println("tous les marque---------------------" + c1[1]);
           if(c1[0].equals(t_m)){
               t= c1[1];
           }
        }
         if (is_concept(t)){
             String type=type_concept(t);
             System.out.println("le type de concept est "+type);
             return  t+" et un :"+type;
         }
            return t;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphe_conceptuel/okay.png"))); // NOI18N
        jButton2.setText("Afficher le Graphe");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type de Concept", "Type de Relation", "Les signatures", "les individues", "Les marqueur indiv"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel1.setText("Graphe Conceptuel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(219, 219, 219))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<ArrayList<String>> v = new ArrayList<ArrayList<String>>();
        v = read_file("C:\\Users\\User\\Documents\\NetBeansProjects\\graphe_conceptuel\\src\\graphe_conceptuel\\vocabulaire");

        System.out.println("les concept " + v.get(0)+"and size of is "+v.get(0).size());
        System.out.println("les reltion" + v.get(1));
        System.out.println("les singature" + v.get(2));
        System.out.println("les individu" + v.get(3));
        System.out.println("");
        DefaultTableModel tableModel = new DefaultTableModel();
         //tableModel.insertRow(0, new Object[] { "concept is" });
         for (int i=0;i<v.get(0).size();i++){
              jTable1.setValueAt(v.get(0).get(i), i, 0);
         }
        for (int i=0;i<v.get(1).size();i++){
            jTable1.setValueAt(v.get(1).get(i), i, 1);
        }
           for (int i=0;i<v.get(2).size();i++){
            jTable1.setValueAt(v.get(2).get(i), i, 2);
        }
              for (int i=0;i<v.get(3).size();i++){
            jTable1.setValueAt(v.get(3).get(i), i, 3);
        }
                    for (int i=0;i<v.get(4).size();i++){
            jTable1.setValueAt(v.get(4).get(i), i, 4);
        }
         System.out.println("is do");
        //System.out.println("is relation----------/" + is_relation("possede"));
        //System.out.println("is mrqeur----------/" + is_individu("marie"));
        //System.out.println("is_concept----------/" + is_concept("action"));
      //  System.out.println("type de concept -------"+type_concept("conduire"));
// System.out.println("type de concept -------"+type_concept("piloter"));
 // System.out.println("type de concept -------"+type_concept("conduire"));
   //System.out.println("type de concept -------"+type_concept("conduire"));
 //   System.out.println("type de concept -------"+type_concept("conduire"));
     //System.out.println("type de concept -------"+type_concept("conduire"));
    System.out.println("type de marque -------"+type_marqu("jean"));
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Graphe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graphe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graphe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graphe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

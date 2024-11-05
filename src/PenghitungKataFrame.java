import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
public class PenghitungKataFrame extends javax.swing.JFrame {

    /**
     * Creates new form PenghitungKataFrame
     */
    public PenghitungKataFrame() {
        initComponents();
        // Mendapatkan Document dari JTextArea
        Document document = textArea.getDocument();

        // Menambahkan DocumentListener
        document.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungJumlahKataDanKarakter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungJumlahKataDanKarakter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hitungJumlahKataDanKarakter();
            }
        });
    }
    
    private void hitungJumlahKataDanKarakter() {
        // Mendapatkan teks dari JTextArea
        String teks = textArea.getText();

        // Menghitung jumlah karakter
        int jumlahKarakter = teks.length();

        // Menghitung jumlah kata
        String[] kataArray = teks.trim().split("\\s+");
        int jumlahKata = (teks.trim().isEmpty()) ? 0 : kataArray.length;

        // Menampilkan hasil pada JLabel
        jumlahKataLabel.setText("Jumlah Kata: " + jumlahKata);
        jumlahKarakterLabel.setText("Jumlah Karakter: " + jumlahKarakter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        hitungButton = new javax.swing.JButton();
        jumlahKataLabel = new javax.swing.JLabel();
        jumlahKarakterLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tugas 5", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Aplikasi Penghitung Kata");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        hitungButton.setText("Hitung");
        hitungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel2.add(hitungButton, gridBagConstraints);

        jumlahKataLabel.setText("Jumlah Kata");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel2.add(jumlahKataLabel, gridBagConstraints);

        jumlahKarakterLabel.setText("Jumlah Karakter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel2.add(jumlahKarakterLabel, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungButtonActionPerformed
        // Mendapatkan teks dari JTextArea
        String teks = textArea.getText();

        // Menghitung jumlah karakter
        int jumlahKarakter = teks.length();

        // Menghitung jumlah kata
        String[] kataArray = teks.trim().split("\\s+");
        int jumlahKata = (teks.trim().isEmpty()) ? 0 : kataArray.length;

        // Menampilkan hasil pada JLabel
        jumlahKataLabel.setText("Jumlah Kata: " + jumlahKata);
        jumlahKarakterLabel.setText("Jumlah Karakter: " + jumlahKarakter);
    }//GEN-LAST:event_hitungButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenghitungKataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenghitungKataFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hitungButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahKarakterLabel;
    private javax.swing.JLabel jumlahKataLabel;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}

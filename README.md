# Tugas 5: Aplikasi Penghitung Kata

### Pembuat
- **Nama**: Muhammad Irwan Habibie
- **NPM**: 2210010461

---

## 1. Deskripsi Program
Aplikasi ini memungkinkan pengguna untuk:
- Memasukkan teks ke dalam **JTextArea** yang ada di dalam **JScrollPane**.
- Menekan tombol **Hitung** untuk menampilkan jumlah kata dan karakter dalam teks yang dimasukkan.
- Menampilkan hasil perhitungan dalam beberapa **JLabel**.

## 2. Komponen GUI
- **JFrame**: Window utama aplikasi.
- **JPanel**: Panel untuk menampung komponen.
- **JLabel**: Label untuk menunjukkan jumlah kata, karakter, kalimat, dan paragraf.
- **JTextArea**: Area input untuk memasukkan teks.
- **JScrollPane**: Panel scroll untuk **JTextArea**.
- **JButton**: Tombol untuk memulai perhitungan dan fungsi lainnya.

## 3. Logika Program
- Menggunakan manipulasi string dan ekspresi reguler untuk menghitung jumlah kata, karakter, kalimat, dan paragraf.
- Menghitung kemunculan kata tertentu dalam teks saat tombol **Cari Kata** ditekan.

## 4. Events
Menggunakan **ActionListener** dan **DocumentListener** untuk interaksi pengguna secara real-time:

### A. Tombol Hitung
Menghitung jumlah kata, karakter, kalimat, dan paragraf dalam teks yang dimasukkan.

    private void hitungButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
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

### B. DocumentListener pada JTextArea
Menghitung jumlah kata dan karakter secara real-time setiap kali ada perubahan di **JTextArea**.

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

        // Menghitung jumlah kalimat (diasumsikan kalimat diakhiri dengan '.', '!', atau '?')
        String[] kalimatArray = teks.split("[.!?]+");
        int jumlahKalimat = (teks.trim().isEmpty()) ? 0 : kalimatArray.length;

        // Menghitung jumlah paragraf (diasumsikan paragraf dipisahkan oleh baris baru)
        String[] paragrafArray = teks.split("\\n+");
        int jumlahParagraf = (teks.trim().isEmpty()) ? 0 : paragrafArray.length;

        // Menampilkan hasil pada JLabel
        jumlahKataLabel.setText("Jumlah Kata: " + jumlahKata);
        jumlahKarakterLabel.setText("Jumlah Karakter: " + jumlahKarakter);
        jumlahKalimatLabel.setText("Jumlah Kalimat: " + jumlahKalimat);
        jumlahParagrafLabel.setText("Jumlah Paragraf: " + jumlahParagraf);
    }
    
## 5. Variasi
Aplikasi ini memiliki variasi tambahan berikut:

### A. Menghitung Jumlah Kalimat dan Paragraf
Menghitung jumlah kalimat dan paragraf dalam teks dengan menggunakan ekspresi reguler.

    private void hitungJumlahKataDanKarakter() {
        // Mendapatkan teks dari JTextArea
        String teks = textArea.getText();

        // Menghitung jumlah kalimat (diasumsikan kalimat diakhiri dengan '.', '!', atau '?')
        String[] kalimatArray = teks.split("[.!?]+");
        int jumlahKalimat = (teks.trim().isEmpty()) ? 0 : kalimatArray.length;

        // Menghitung jumlah paragraf (diasumsikan paragraf dipisahkan oleh baris baru)
        String[] paragrafArray = teks.split("\\n+");
        int jumlahParagraf = (teks.trim().isEmpty()) ? 0 : paragrafArray.length;

        jumlahKalimatLabel.setText("Jumlah Kalimat: " + jumlahKalimat);
        jumlahParagrafLabel.setText("Jumlah Paragraf: " + jumlahParagraf);
    } 
        
### B. Pencarian Kata
Memungkinkan pengguna mencari kemunculan kata tertentu dalam teks.

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String teks = textArea.getText();
        String kataCari = kataCariField.getText().trim();

        if (kataCari.isEmpty()) {
            jumlahKemunculanLabel.setText("Kata yang dicari tidak boleh kosong.");
            return;
        }

        String[] kataArray = teks.split("\\s+");
        int jumlahKemunculan = 0;
        for (String kata : kataArray) {
            if (kata.equalsIgnoreCase(kataCari)) {
                jumlahKemunculan++;
            }
        }

        jumlahKemunculanLabel.setText("Kemunculan '" + kataCari + "': " + jumlahKemunculan);
    }

### C. Menyimpan Hasil ke File
Menyediakan opsi untuk menyimpan teks dan hasil perhitungan ke dalam file menggunakan **JFileChooser**.

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Menampilkan dialog JFileChooser untuk memilih lokasi penyimpanan
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Mendapatkan file yang dipilih
            File fileToSave = fileChooser.getSelectedFile();

            try (PrintWriter writer = new PrintWriter(fileToSave)) {
                // Menulis isi teks
                writer.println("Isi Teks:");
                writer.println(textArea.getText());

                // Menulis hasil perhitungan
                writer.println("\nHasil Perhitungan:");
                writer.println(jumlahKataLabel.getText());
                writer.println(jumlahKarakterLabel.getText());
                writer.println(jumlahKalimatLabel.getText());
                writer.println(jumlahParagrafLabel.getText());

                // Menampilkan pesan sukses
                JOptionPane.showMessageDialog(this, "File berhasil disimpan.", "Simpan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                // Menampilkan pesan error jika terjadi kesalahan
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


## 6. Tampilan Saat Aplikasi di Run
![TampilanPenghitunganKata](https://github.com/user-attachments/assets/20d5f2af-30da-441b-800f-92f199763599)

## 7. Indikator Penilaian

| No  | Komponen          | Persentase |
| :-: | ------------------ | :--------: |
|  1  | Komponen GUI      |     10%    |
|  2  | Logika Program    |     20%    |
|  3  | Events            |     10%    |
|  4  | Kesesuaian UI     |     20%    |
|  5  | Memenuhi Variasi  |     40%    |
|     | **TOTAL**         |  **100%**  |

--- 

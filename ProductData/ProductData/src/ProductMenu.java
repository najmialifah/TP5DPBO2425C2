import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMenu extends JFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Gagal ubah tema GUI");
        }

        ProductMenu menu = new ProductMenu();
        menu.setSize(700, 600);
        menu.setLocationRelativeTo(null);
        menu.setContentPane(menu.mainPanel);
        menu.getContentPane().setBackground(Color.WHITE);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int selectedIndex = -1;
    private Database database;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField hargaField;
    private JTable productTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> kategoriComboBox;
    private JComboBox<String> merekComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel namaLabel;
    private JLabel hargaLabel;
    private JLabel kategoriLabel;
    private JLabel merekLabel;

    public ProductMenu() {
        database = new Database();

        // tampilkan data awal dari database
        productTable.setModel(setTable());

        titleLabel.setText("Menu Kafe");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        String[] kategoriData = { "???", "Minuman", "Makanan", "Dessert" };
        kategoriComboBox.setModel(new DefaultComboBoxModel<>(kategoriData));

        String[] merekData = { "???", "Starbrew", "BeanCraft", "SweetHouse", "Dapur Kita", "Bakehouse", "Coklats" };
        merekComboBox.setModel(new DefaultComboBoxModel<>(merekData));

        deleteButton.setVisible(false);

        addUpdateButton.addActionListener(e -> {
            if (selectedIndex == -1) insertData();
            else updateData();
        });

        deleteButton.addActionListener(e -> deleteData());
        cancelButton.addActionListener(e -> clearForm());

        // saat klik tabel, isi field
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = productTable.getSelectedRow();

                String curId = productTable.getModel().getValueAt(selectedIndex, 1).toString();
                String curNama = productTable.getModel().getValueAt(selectedIndex, 2).toString();
                String curHarga = productTable.getModel().getValueAt(selectedIndex, 3).toString();
                String curKategori = productTable.getModel().getValueAt(selectedIndex, 4).toString();
                String curMerek = productTable.getModel().getValueAt(selectedIndex, 5).toString();

                idField.setText(curId);
                namaField.setText(curNama);
                hargaField.setText(curHarga);
                kategoriComboBox.setSelectedItem(curKategori);
                merekComboBox.setSelectedItem(curMerek);

                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    // menampilkan data dari database ke tabel
    public final DefaultTableModel setTable() {
        Object[] cols = { "No", "Kode Menu", "Nama Menu", "Harga", "Kategori", "Brand" };
        DefaultTableModel tmp = new DefaultTableModel(null, cols);

        try {
            ResultSet rs = database.selectQuery("SELECT * FROM menu_kafe");
            int i = 0;
            while (rs.next()) {
                Object[] row = {
                        i + 1,
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getDouble("harga"),
                        rs.getString("kategori"),
                        rs.getString("merek")
                };
                tmp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tmp;
    }

    public void insertData() {
        try {
            String id = idField.getText().trim();
            String nama = namaField.getText().trim();
            String hargaStr = hargaField.getText().trim();
            String kategori = kategoriComboBox.getSelectedItem().toString();
            String merek = merekComboBox.getSelectedItem().toString();

            if (id.isEmpty() || nama.isEmpty() || hargaStr.isEmpty() || kategori.equals("???") || merek.equals("???")) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // cek id duplikat
            ResultSet rs = database.selectQuery("SELECT * FROM menu_kafe WHERE id='" + id + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "ID sudah digunakan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double harga = Double.parseDouble(hargaStr);

            String sql = "INSERT INTO menu_kafe VALUES ('" + id + "', '" + nama + "', " + harga + ", '" + kategori + "', '" + merek + "')";
            database.insertUpdateDeleteQuery(sql);

            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateData() {
        try {
            String id = idField.getText().trim();
            String nama = namaField.getText().trim();
            String hargaStr = hargaField.getText().trim();
            String kategori = kategoriComboBox.getSelectedItem().toString();
            String merek = merekComboBox.getSelectedItem().toString();

            if (id.isEmpty() || nama.isEmpty() || hargaStr.isEmpty() || kategori.equals("???") || merek.equals("???")) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double harga = Double.parseDouble(hargaStr);

            String sql = "UPDATE menu_kafe SET nama='" + nama + "', harga=" + harga + ", kategori='" + kategori + "', merek='" + merek + "' WHERE id='" + id + "'";
            database.insertUpdateDeleteQuery(sql);

            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteData() {
        String id = idField.getText();
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM menu_kafe WHERE id='" + id + "'";
            database.insertUpdateDeleteQuery(sql);
            productTable.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        }
    }

    public void clearForm() {
        idField.setText("");
        namaField.setText("");
        hargaField.setText("");
        kategoriComboBox.setSelectedIndex(0);
        merekComboBox.setSelectedIndex(0);
        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }
}
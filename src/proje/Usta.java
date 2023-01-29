package proje;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Insets;

public class Usta extends JFrame {

	private static Usta frame;
	private JPanel contentPane;
	private JTable tblPersonelBilgi;
	private JTable tblPersonelBilgi1;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private String bolum="Depo";
	
	/**
	 * Create the frame.
	 */
	public Usta() {
		setTitle("Usta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 220, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {//Giriþ yapan personelin bölüm bilgisi alýnýyor
			Giris.conn=DriverManager.getConnection(Giris.url);
			Statement st=Giris.conn.createStatement();
			ResultSet rs=st.executeQuery("select Per_bolum from Personel where Per_no='"+Giris.per_no+"'");
			bolum=rs.getString(1);
			Giris.conn.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Bölüm Bilgisi Alýnamadý");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bir sorun var  :)");
		}
		
		JLabel lblhosgeldin = new JLabel(Giris.kullanici);
		lblhosgeldin.setHorizontalAlignment(SwingConstants.CENTER);
		lblhosgeldin.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblhosgeldin.setBackground(Color.red);
		lblhosgeldin.setBounds(664, 74, 110, 32);
		contentPane.add(lblhosgeldin);
		
		JButton btnvardiyamesaibilgileri = new JButton(" Vardiya, Mesai Bilgileri");
		btnvardiyamesaibilgileri.setMargin(new Insets(0, 0, 0, 0));
		btnvardiyamesaibilgileri.setHorizontalAlignment(SwingConstants.LEFT);
		btnvardiyamesaibilgileri.setIcon(new ImageIcon("icon\\Vardiya_mesaigruntule.png"));
		btnvardiyamesaibilgileri.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnvardiyamesaibilgileri.setBounds(10, 11, 478, 95);
		contentPane.add(btnvardiyamesaibilgileri);
		
		JButton btnbolumbilgileri = new JButton(" B\u00F6l\u00FCm Bilgileri");
		btnbolumbilgileri.setMargin(new Insets(0, 0, 0, 0));
		btnbolumbilgileri.setHorizontalAlignment(SwingConstants.LEFT);
		btnbolumbilgileri.setIcon(new ImageIcon("icon\\bolumbilgileri.png"));
		btnbolumbilgileri.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnbolumbilgileri.setBounds(10, 117, 478, 95);
		contentPane.add(btnbolumbilgileri);
		
		JLabel lblAdi = new JLabel("Ad\u0131n\u0131z:");
		lblAdi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi.setVisible(false);
		lblAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdi.setBounds(0, 72, 177, 50);
		contentPane.add(lblAdi);
		
		JLabel lblSoyadi = new JLabel("Soyad\u0131n\u0131z:");
		lblSoyadi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi.setVisible(false);
		lblSoyadi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyadi.setBounds(0, 133, 177, 50);
		contentPane.add(lblSoyadi);
		
		JLabel lblBolum = new JLabel("B\u00F6l\u00FCm\u00FCn\u00FCz:");
		lblBolum.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblBolum.setVisible(false);
		lblBolum.setHorizontalAlignment(SwingConstants.LEFT);
		lblBolum.setBounds(0, 194, 177, 50);
		contentPane.add(lblBolum);
		
		JLabel lblMaas = new JLabel("Maaþýnýz:");
		lblMaas.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas.setVisible(false);
		lblMaas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaas.setBounds(0, 255, 177, 50);
		contentPane.add(lblMaas);
		
		JLabel lblVardiya = new JLabel("Vardiya:");
		lblVardiya.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblVardiya.setVisible(false);
		lblVardiya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVardiya.setBounds(0, 377, 177, 50);
		contentPane.add(lblVardiya);
		
		JLabel lblTarihAra = new JLabel("Tarih Arlk:");
		lblTarihAra.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblTarihAra.setVisible(false);
		lblTarihAra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTarihAra.setBounds(0, 438, 177, 50);
		contentPane.add(lblTarihAra);
		
		JLabel lblMesai = new JLabel("Mesai:");
		lblMesai.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMesai.setVisible(false);
		lblMesai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMesai.setBounds(0, 316, 177, 50);
		contentPane.add(lblMesai);
		
		JLabel lblAdi1 = new JLabel("");
		lblAdi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi1.setVisible(false);
		lblAdi1.setForeground(new Color(255, 0, 0));
		lblAdi1.setBounds(179, 72, 250, 50);
		contentPane.add(lblAdi1);
		
		JLabel lblSoyadi1 = new JLabel("");
		lblSoyadi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi1.setVisible(false);
		lblSoyadi1.setForeground(new Color(255, 0, 0));
		lblSoyadi1.setBounds(179, 133, 250, 50);
		contentPane.add(lblSoyadi1);
		
		JLabel lblBolum1 = new JLabel("");
		lblBolum1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblBolum1.setVisible(false);
		lblBolum1.setForeground(new Color(255, 0, 0));
		lblBolum1.setBounds(179, 194, 250, 50);
		contentPane.add(lblBolum1);
		
		JLabel lblMaas1 = new JLabel("");
		lblMaas1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas1.setVisible(false);
		lblMaas1.setForeground(new Color(255, 0, 0));
		lblMaas1.setBounds(179, 255, 250, 50);
		contentPane.add(lblMaas1);
		
		JLabel lblVardiya1 = new JLabel("");
		lblVardiya1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblVardiya1.setVisible(false);
		lblVardiya1.setForeground(new Color(255, 0, 0));
		lblVardiya1.setBounds(179, 377, 250, 50);
		contentPane.add(lblVardiya1);
		
		JLabel lblMesai1 = new JLabel("");
		lblMesai1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMesai1.setVisible(false);
		lblMesai1.setForeground(new Color(255, 0, 0));
		lblMesai1.setBounds(179, 316, 250, 50);
		contentPane.add(lblMesai1);
		
		JLabel lblTarihAra1 = new JLabel("");
		lblTarihAra1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblTarihAra1.setVisible(false);
		lblTarihAra1.setForeground(new Color(255, 0, 0));
		lblTarihAra1.setBounds(179, 438, 450, 50);
		contentPane.add(lblTarihAra1);
		
		JButton btnGeri = new JButton(" Geri");
		btnGeri.setVisible(false);
		btnGeri.setIcon(new ImageIcon("icon\\gerii.png"));
		btnGeri.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnGeri.setBounds(0, 0, 160, 50);
		contentPane.add(btnGeri);
		
		JButton btncikis = new JButton(" \u00C7\u0131k\u0131\u015F");
		btncikis.addActionListener(new ActionListener() {//Çýkýþ iþlemleri
			public void actionPerformed(ActionEvent e) {
				Giris.frame=new Giris();
				Giris.frame.setVisible(true);
				if (Giris.frame3==null) {
					frame.dispose();
				} else {
					Giris.frame3.dispose();
				}
				
			}
		});
		btncikis.setIcon(new ImageIcon("icon\\cikis.png"));
		btncikis.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btncikis.setBounds(614, 500, 160, 50);
		contentPane.add(btncikis);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		scrollPane.setVisible(false);
		scrollPane.setBounds(83, 189, 634, 300);
		contentPane.add(scrollPane);
		
		tblPersonelBilgi = new JTable();
		tblPersonelBilgi.setAutoCreateRowSorter(true);;
		tblPersonelBilgi.setForeground(new Color(0, 0, 0));
		tblPersonelBilgi.setBackground(new Color(188, 235, 237));
		tblPersonelBilgi.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		tblPersonelBilgi.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Ad", "Soyad", "Vardiya", "Mesai", "Tarih Aral\u0131\u011F\u0131"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		}
		
		);
		model=(DefaultTableModel) tblPersonelBilgi.getModel();
		tblPersonelBilgi.setVisible(false);
		scrollPane.setViewportView(tblPersonelBilgi);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setVisible(false);
		scrollPane1.setBounds(83, 189, 634, 300);
		contentPane.add(scrollPane1);
		
		tblPersonelBilgi1 = new JTable();
		tblPersonelBilgi1.setAutoCreateRowSorter(true);//Sýralama yapýlmayý aktif yapma
		tblPersonelBilgi1.setForeground(new Color(0, 0, 0));
		tblPersonelBilgi1.setBackground(new Color(188, 235, 237));
		tblPersonelBilgi1.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		tblPersonelBilgi1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Ad", "Soyad", "B\u00F6l\u00FCm"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row,int column) {//jtable verileri düzenleme devre dýþý yapýlýyor
				return false;
			}
		}
		
		);
		model1=(DefaultTableModel) tblPersonelBilgi1.getModel();
		tblPersonelBilgi1.setVisible(false);
		scrollPane1.setViewportView(tblPersonelBilgi1);
		
		JLabel lblHosÝcon = new JLabel("");
		lblHosÝcon.setIcon(new ImageIcon("icon\\usta.png"));
		lblHosÝcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHosÝcon.setBounds(664, 11, 110, 66);
		contentPane.add(lblHosÝcon);
		
		lblhosgeldin.addMouseListener(new MouseAdapter() {//Kullanýcý bilgileri iþlemleri
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=lblhosgeldin.getBackground();
				lblhosgeldin.setBackground(lblhosgeldin.getForeground());
				lblhosgeldin.setForeground(c);
			}
			public void mouseExited(MouseEvent e) {
				Color c=lblhosgeldin.getForeground();
				lblhosgeldin.setForeground(lblhosgeldin.getBackground());
				lblhosgeldin.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnbolumbilgileri.setVisible(false);
				btnvardiyamesaibilgileri.setVisible(false);
				btnGeri.setVisible(true);
				lblAdi.setVisible(true);
				lblAdi1.setVisible(true);
				lblSoyadi.setVisible(true);
				lblSoyadi1.setVisible(true);
				lblBolum.setVisible(true);
				lblBolum1.setVisible(true);
				lblVardiya.setVisible(true);
				lblVardiya1.setVisible(true);
				lblMesai.setVisible(true);
				lblMesai1.setVisible(true);
				lblMaas.setVisible(true);
				lblMaas1.setVisible(true);
				lblTarihAra.setVisible(true);
				lblTarihAra1.setVisible(true);

				int uznlk=model.getRowCount();
				for (int i = 0; i<uznlk; i++) {
					model.removeRow(0);
				}//Eski veriler siliniyor
				int uznlk1=model1.getRowCount();
				for (int i = 0; i<uznlk1; i++) {
					model1.removeRow(0);
				}
				scrollPane.setVisible(false);
				tblPersonelBilgi.setVisible(false);
				scrollPane1.setVisible(false);
				tblPersonelBilgi1.setVisible(false);
				try {//Personel bilgileri alýnýyor
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select * from Personel where Per_no='"+Giris.per_no+"'");
					lblAdi1.setText(rs.getString(2));
					lblSoyadi1.setText(rs.getString(3));
					lblMaas1.setText(rs.getString(4));
					lblBolum1.setText(rs.getString(5));
					lblVardiya1.setText(rs.getString(6));
					lblMesai1.setText(rs.getString(7));
					String tarihAra = null;
					if (rs.getString(8) != null&&rs.getString(9)!=null) {
						tarihAra=rs.getString(8)+" / "+rs.getString(9);
					}
					lblTarihAra1.setText(tarihAra);
					rs.close();
					Giris.conn.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No bilgisi alýnamadý");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});
		
		btnvardiyamesaibilgileri.addActionListener(new ActionListener() {//Vardiya mesai bilgileri ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnbolumbilgileri.setVisible(false);
				btnvardiyamesaibilgileri.setVisible(false);
				btnGeri.setVisible(true);
				scrollPane.setVisible(true);
				tblPersonelBilgi.setVisible(true);
				int uznlk=model.getRowCount();
				for (int i = 0; i<uznlk; i++) {
					model.removeRow(0);
				}
				try {//Veriler jtableye aktarýlýyor
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_no,Per_ad,Per_soyad,Per_vardiya,Per_mesai,Per_Itarih,Per_Starih from Personel where Per_bolum='"+bolum+"' ");
					while (rs.next()) {
						String tarihAra = "";
						if (rs.getString(6) != null&&rs.getString(7)!=null) {
							tarihAra=rs.getString(6)+" / "+rs.getString(7);
						}
						model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),tarihAra});
					}
					Giris.conn.close();
					st.close();
					rs.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});
		
		btnbolumbilgileri.addActionListener(new ActionListener() {//Bölüm bilgileri ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnbolumbilgileri.setVisible(false);
				btnvardiyamesaibilgileri.setVisible(false);
				btnGeri.setVisible(true);
				scrollPane1.setVisible(true);
				tblPersonelBilgi1.setVisible(true);
				int uznlk=model1.getRowCount();
				for (int i = 0; i<uznlk; i++) {
					model1.removeRow(0);
				}
				try {//Bilgiler jtableye aktarýlýyor
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_no,Per_ad,Per_soyad,Per_bolum from Personel where Per_bolum='"+bolum+"' ");
					while (rs.next()) {
						model1.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
					}
					Giris.conn.close();
					st.close();
					rs.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});
		
		btnGeri.addActionListener(new ActionListener() {//AnaEkran
			public void actionPerformed(ActionEvent e) {
				btnbolumbilgileri.setVisible(true);
				btnvardiyamesaibilgileri.setVisible(true);
				btnGeri.setVisible(false);
				lblAdi.setVisible(false);
				lblAdi1.setVisible(false);
				lblAdi1.setText("");
				lblSoyadi.setVisible(false);
				lblSoyadi1.setVisible(false);
				lblSoyadi1.setText("");
				lblBolum.setVisible(false);
				lblBolum1.setVisible(false);
				lblBolum1.setText("");
				lblVardiya.setVisible(false);
				lblVardiya1.setVisible(false);
				lblVardiya1.setText("");
				lblMesai.setVisible(false);
				lblMesai1.setVisible(false);
				lblMesai1.setText("");
				lblMaas.setVisible(false);
				lblMaas1.setVisible(false);
				lblMaas1.setText("");
				lblTarihAra.setVisible(false);
				lblTarihAra1.setVisible(false);
				lblTarihAra1.setText("");

				
				int uznlk=model.getRowCount();
				for (int i = 0; i<uznlk; i++) {
					model.removeRow(0);
				}//Eski veriler siliniyor
				int uznlk1=model1.getRowCount();
				for (int i = 0; i<uznlk1; i++) {
					model1.removeRow(0);
				}
				scrollPane.setVisible(false);
				tblPersonelBilgi.setVisible(false);
				scrollPane1.setVisible(false);
				tblPersonelBilgi1.setVisible(false);

			}
		});
		
	}

}
